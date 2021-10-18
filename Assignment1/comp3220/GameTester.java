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

class GameTester {
	
	Game g1=new Game("Game 1", 15, LocalDate.of(2020,02,23), 50, "EA", false);
	Game g3=new Game("Game 3", 10, LocalDate.of(2020,02,23), 80, "PS", true);
	Game g2=new Game(g1, 4500);
	
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
				() -> assertEquals(50, g1.getQuantity()),
				() -> assertEquals("Game 1", g1.getTitle()),
				() -> assertEquals(9000,g1.getItemID()),
				() -> assertEquals(15, g1.getRegularPrice()),
				() -> assertEquals("2020-02-23",g1.getReleaseDate().toString()),
				() -> assertEquals(50, g2.getQuantity()),
				() -> assertEquals(4500,g2.getItemID()),
				() -> assertEquals("Game 1",g2.getTitle()),
				() -> assertEquals(80, g3.getQuantity()),
				() -> assertEquals(10, g3.getRegularPrice()),
				() -> assertEquals("2020-02-23",g3.getReleaseDate().toString()),
				() -> assertEquals(9100,g3.getItemID()),
				() -> assertEquals("Game 3",g3.getTitle()));
	}
	
	@Test
	@Order(2)
	public void testGetPrice() {
		System.out.println("2 testBookConstructors called");
		assertAll("Get Price testing",
				() -> assertEquals(g1.getRegularPrice(),g1.getPrice(LocalDate.of(2021,02,23))),
				() -> assertEquals(g3.getRegularPrice()*20, g3.getPrice(LocalDate.of(2021,02,24))));
	}
	
	@Test
	@Order(3)
	public void testMakeCopy() {
		System.out.println("3 testMakeCopy called");
		assertNotSame(g1,g1.makeCopy());
	}

}
