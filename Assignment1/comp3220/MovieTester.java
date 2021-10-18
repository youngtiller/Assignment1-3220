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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class MovieTester {

	Movie m1=new Movie("Movie 1", 10, LocalDate.of(2020,02,23), 10, "Director name", "Producer name");
	Movie m2=new Movie(m1,1900,"Director 2 name", "Producer 2 name");
	Movie m3=new Movie("Movie 3", 4.99, LocalDate.of(2020,02,23), 40, "Director 3 name", "Producer 3 name");
	
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
				() -> assertEquals(10, m1.getQuantity()),
				() -> assertEquals("Movie 1", m1.getTitle()),
				() -> assertEquals(9000,m1.getItemID()),
				() -> assertEquals(10, m1.getRegularPrice()),
				() -> assertEquals("2020-02-23",m1.getReleaseDate().toString()),
				() -> assertEquals("Director name", m1.director),
				() -> assertEquals("Producer name", m1.producer),
				() -> assertEquals(10, m2.getQuantity()),
				() -> assertEquals(1900,m2.getItemID()),
				() -> assertEquals("Movie 1",m2.getTitle()),
				() -> assertEquals("Director 2 name", m2.director),
				() -> assertEquals("Producer 2 name", m2.producer),
				() -> assertEquals(40, m3.getQuantity()),
				() -> assertEquals(4.99, m3.getRegularPrice()),
				() -> assertEquals("2020-02-23",m3.getReleaseDate().toString()),
				() -> assertEquals(9100,m3.getItemID()),
				() -> assertEquals("Director 3 name", m3.director),
				() -> assertEquals("Producer 3 name", m3.producer),
				() -> assertEquals("Movie 3",m3.getTitle()));
	}
	
	@Test
	@Order(2)
	public void testGetPrice() {
		System.out.println("2 testGetPrice called");
		assertAll("Get Price testing",
				() -> assertEquals(m1.getRegularPrice(), m1.getPrice(LocalDate.of(2021,02,22))),
				() -> assertEquals(m1.getRegularPrice(),m1.getPrice(LocalDate.of(2021,02,23))),
				() -> assertEquals(m1.getRegularPrice()*0.5, m1.getPrice(LocalDate.of(2021,02,24))));
	}
	
	@Test
	@Order(3)
	public void testMakeCopy() {
		System.out.println("3 testMakeCopy called");
		assertNotSame(m1,m1.makeCopy());
	}

}
