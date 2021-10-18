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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class BookTester {
	
		ArrayList<String> authors=new ArrayList<>();
		{
			authors.add("John");
			authors.add("Nathan");
		}
		Book b1=new Book("Title 1", 19.99, LocalDate.of(2020,02,23), 20, authors);
		Book b2=new Book(b1,2000,authors);
		Book b3=new Book("Title 3", 14.99, LocalDate.of(2020,02,23), 30, authors);
	
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
				() -> assertEquals(20, b1.getQuantity()),
				() -> assertEquals("Title 1", b1.getTitle()),
				() -> assertEquals(9000,b1.getItemID()),
				() -> assertEquals(19.99, b1.getRegularPrice()),
				() -> assertEquals("2020-02-23",b1.getReleaseDate().toString()),
				() -> assertEquals("[John, Nathan]", b1.getAuthors().toString()),
				() -> assertEquals(20, b2.getQuantity()),
				() -> assertEquals(2000,b2.getItemID()),
				() -> assertEquals("Title 1",b2.getTitle()),
				() -> assertEquals(30, b3.getQuantity()),
				() -> assertEquals(14.99, b3.getRegularPrice()),
				() -> assertEquals("2020-02-23",b3.getReleaseDate().toString()),
				() -> assertEquals(9100,b3.getItemID()),
				() -> assertEquals("Title 3",b3.getTitle()));
	}
	
	@Test
	@Order(2)
	public void testGetAuthors() {
		System.out.println("2 testGetAuthors called");
		ArrayList<String> copy=b1.getAuthors();
		assertNotSame(authors,copy);
	}
	
	@Test
	@Order(3)
	public void testGetPrice() {
		System.out.println("3 testGetPrice called");
		assertEquals(b1.getRegularPrice(),b1.getPrice(LocalDate.of(2023,02,23)));
		
	}
	
	@Test
	@Order(4)
	public void testMakeCopy() {
		System.out.println("4 testMakeCopy called");
		assertNotSame(b1,b1.makeCopy());
	}
}
