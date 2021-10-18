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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CompactDiscTester {
	
	CompactDisc c1=new CompactDisc("Title 1", 15, LocalDate.of(2020,02,23), 50, "Linkin Park", "Warner");
	CompactDisc c2=new CompactDisc(c1,3000,"Linkin Park", "Warner");
	CompactDisc c3=new CompactDisc("Title 3", 150, LocalDate.of(2020,02,23), 100, "Polyphia");
	
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
		assertAll("Item testing",
				() -> assertEquals(50, c1.getQuantity()),
				() -> assertEquals("Title 1", c1.getTitle()),
				() -> assertEquals(9000,c1.getItemID()),
				() -> assertEquals(15, c1.getRegularPrice()),
				() -> assertEquals("2020-02-23",c1.getReleaseDate().toString()),
				() -> assertEquals("Linkin Park", c1.bandName),
				() -> assertEquals("Warner", c1.recordLabel),
				() -> assertEquals(50, c2.getQuantity()),
				() -> assertEquals(3000,c2.getItemID()),
				() -> assertEquals("Title 1",c2.getTitle()),
				() -> assertEquals("Linkin Park", c2.bandName),
				() -> assertEquals("Warner", c2.recordLabel),
				() -> assertEquals(100, c3.getQuantity()),
				() -> assertEquals(150, c3.getRegularPrice()),
				() -> assertEquals("2020-02-23",c3.getReleaseDate().toString()),
				() -> assertEquals(9100,c3.getItemID()),
				() -> assertEquals("Polyphia", c3.bandName),
				() -> assertEquals("Indie", c3.recordLabel),
				() -> assertEquals("Title 3",c3.getTitle()));
	}
	
	@Test
	@Order(2)
	public void testGetPrice() {
		System.out.println("2 testGetPrice called");
		assertAll("Get Price testing",
				() -> assertEquals(c1.getRegularPrice(), c1.getPrice(LocalDate.of(2021,02,22))),
				() -> assertEquals(c1.getRegularPrice(),c1.getPrice(LocalDate.of(2021,02,23))),
				() -> assertEquals(c1.getRegularPrice()*0.5, c1.getPrice(LocalDate.of(2021,02,24))));
	}
	
	@Test
	@Order(3)
	public void testMakeCopy() {
		System.out.println("3 testMakeCopy called");
		assertNotSame(c1,c1.makeCopy());
	}

}
