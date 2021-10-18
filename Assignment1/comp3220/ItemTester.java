package comp3220;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ItemTester {
	
	Item i=new Item("Butter", 4, LocalDate.of(2019,02,11), 101);
	Item i3=new Item(i,5000);
	Item i2=new Item("Salt", 5.99, LocalDate.of(2020,06,23), 100);
	Item i4=new Item("Pepper", 3.99, LocalDate.of(2020,01,19), 99);
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("\nNote the specific order here");
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	@Order(1)
	public void testItemConstructors() {	
		System.out.println("1 testItemConstructors called");
		assertAll("Item testing",() -> assertEquals(100, i.getQuantity()),
				() -> assertEquals("Butter", i.getTitle()),
				() -> assertEquals(9000,i.getItemID()),
				() -> assertEquals(4, i.getRegularPrice()),
				() -> assertEquals("2019-02-11",i.getReleaseDate().toString()),
				() -> assertEquals(100, i2.getQuantity()),
				() -> assertEquals(9100,i2.getItemID()),
				() -> assertEquals("Butter",i3.getTitle()),
				() -> assertEquals(100, i3.getQuantity()),
				() -> assertEquals(4, i3.getRegularPrice()),
				() -> assertEquals("2019-02-11",i3.getReleaseDate().toString()),
				() -> assertEquals(5000,i3.getItemID()),
				() -> assertEquals("Pepper",i4.getTitle()),
				() -> assertEquals(99, i4.getQuantity()));
	}
	
	@Test
	@Order(2)
	public void testGetPrice() {
		System.out.println("2 testGetPrice called");
		assertAll("Get Price testing",
				() -> assertEquals(i.getRegularPrice(), i.getPrice(LocalDate.of(2020,02,10))),
				() -> assertEquals(i.getRegularPrice(),i.getPrice(LocalDate.of(2020,02,11))),
				() -> assertEquals(i.getRegularPrice()*0.5, i.getPrice(LocalDate.of(2020,02,12))));
	}
	
	@Test
	@Order(3)
	public void testSetDiscount() {
		System.out.println("3 testSetDiscount called");
		assertFalse(i2.setDiscount(0.51));
		assertTrue(i2.setDiscount(0.50));
		assertTrue(i2.setDiscount(0.49));
	}
	
	@Test
	@Order(4)
	public void testSell() {
		System.out.println("4 testSell called");
		assertEquals(0,i.sell(101,LocalDate.of(2020,01,1)));
		assertEquals(0,i.sell(-1,LocalDate.of(2020,01,1)));
		assertEquals(0,i.sell(-0,LocalDate.of(2020,01,1)));
		assertEquals(0,i.sell(1,LocalDate.of(2019,02,10)));
		assertNotEquals(0,i.sell(1,LocalDate.of(2019,02,11)));
		assertNotEquals(0,i.sell(1,LocalDate.of(2019,02,12)));
		assertNotEquals(0,i.sell(98,LocalDate.of(2020,01,1)));
	}
	
	@Test
	@Order(5)
	public void testAddStock() {
		System.out.println("5 testAddStock called");
		i.sell(100,LocalDate.of(2021,02,11));
		assertFalse(i.addStock(0));
		assertTrue(i.addStock(1));
		assertFalse(i.addStock(100));
		assertTrue(i.addStock(99));
	}
	
	@Test
	@Order(6)
	public void testMakeCopy() {
		System.out.println("6 testMakeCopy called");
		assertNotSame(i,i.makeCopy());
	}
}