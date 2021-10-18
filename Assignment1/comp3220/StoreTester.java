package comp3220;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class StoreTester {

	Store s1=new Store();
	Movie m2=new Movie("Into the Wilds", 22.00, LocalDate.of(1999, 11, 22), 40, "Bob", "Joe");
	Movie m1=new Movie(m2,2000,"Bob","Joe");
	Item i=new Item("Butter", 4, LocalDate.of(2019,02,11), 80);
	
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
	public void testConstructor() {
		System.out.println("1 TestConstructor called");
		assertNotNull(s1.inventory);
	}
	
	@Test
	@Order(2)
	public void testMakeSale() {
		System.out.println("2 TestMakeSale called");
		s1.addItem(m1);
		assertEquals(false,s1.makeSale(1000, 10, LocalDate.of(2020,02,23)));
		assertEquals(false,s1.makeSale( 2000, 50,LocalDate.of(2020,02,23)));
		assertEquals(true,s1.makeSale( 2000, 5,LocalDate.of(2020,02,23)));
		assertNotEquals(0,s1.totalSalesValue);
		assertEquals(1,s1.totalNumberOfSales);
	}
	
	@Test
	@Order(3)
	public void testAddItem() {
		System.out.println("3 TestAddItem called");
		assertEquals(0,s1.inventory.size());
		s1.addItem(null);
		assertEquals(0,s1.inventory.size());
		s1.addItem(m1);
		assertEquals(1,s1.inventory.size());
	}
	
	@Test
	@Order(4)
	public void testCheckForItem() {
		System.out.println("4 TestCheckForItem called");
		s1.addItem(m1);
		assertNull(s1.checkForItem(1000));
		assertNotNull(s1.checkForItem(2000));
		Item copy=s1.checkForItem(2000);
		assertNotSame(copy,m1);
	}
	
	@Test
	@Order(5)
	public void testGetItemByID() {
		System.out.println("5 TestGetItemByID called");
		s1.addItem(m1);
		assertNull(s1.getItemByID(1000));
		assertNotNull(s1.getItemByID(2000));
		assertSame(m1,s1.getItemByID(2000));
	}
	
	@Test
	@Order(6)
	public void testGetTotalSalesValueAndNumber() {
		System.out.println("6 TestGetTotalSalesValueAndNumber called");
		assertEquals(0,s1.totalSalesValue);
		assertEquals(0,s1.totalNumberOfSales);
		s1.addItem(m1);
		s1.makeSale( 2000, 5,LocalDate.of(2020,02,23));
		s1.makeSale( 2000, 4,LocalDate.of(2020,02,23));
		assertEquals(2,s1.totalNumberOfSales);
		assertEquals(22.0*9,s1.totalSalesValue);
		s1.makeSale( 2000, 1,LocalDate.of(2020,02,23));
		s1.makeSale( 2000, 2,LocalDate.of(2020,02,23));
		s1.makeSale( 2000, 10,LocalDate.of(2020,02,23));
		assertEquals(5,s1.totalNumberOfSales);
		assertEquals(22.0*22,s1.totalSalesValue);
	}

}
