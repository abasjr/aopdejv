import org.junit.jupiter.api.*;

import character.Kucing;
import character.KucingBangsawan;
import character.KucingPrajurit;
import character.KucingRakyat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This code is redeveloped from Ichlasul Affan's code
 */

@DisplayName("Cat Society Test")
public class CatSocietyTest {
	// Membuat variabel baru untuk output dan error output
	private ByteArrayOutputStream outContent;
	private ByteArrayOutputStream errContent;
	private Kucing kucingBangsawan;
	private Kucing kucingPrajurit;
	private Kucing kucingRakyat;

	// Untuk setiap test, lakukan setup terlebih dahulu
	@BeforeEach
	void init() {
		// inisiasi objek manusia
		kucingBangsawan = new KucingBangsawan("Aya", 100, 30, "Empress");
		kucingPrajurit = new KucingPrajurit("Rian", 120, 30);
		kucingRakyat = new KucingRakyat("Salsa", 80, 20);

		// make new ByteArrayOutputStream for output and error output
		outContent = new ByteArrayOutputStream();
		errContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent)); // Connect outContent ke System.out
		System.setErr(new PrintStream(errContent)); // Connect errContent ke System.err
	}

	@Test
	@DisplayName("Test attack")
	void testSatu() {
		kucingBangsawan.attack(kucingRakyat);
		assertEquals(50, kucingRakyat.getHealth());

		kucingRakyat.attack(kucingBangsawan);
		assertEquals(80, kucingBangsawan.getHealth());

		kucingPrajurit.attack(kucingRakyat);
		assertEquals(0, kucingRakyat.getHealth());
	}

	@Test
	@DisplayName("Test sleep")
	void testDua() {

		kucingBangsawan.sleep();
		kucingPrajurit.sleep();
		kucingRakyat.sleep();

		assertEquals(120, kucingBangsawan.getHealth());
		assertEquals(140, kucingPrajurit.getHealth());
		assertEquals(100, kucingRakyat.getHealth());
	}

	@Test
	@DisplayName("Test status")
	void testTiga() {

		assertTrue(kucingBangsawan.status().contains("Aya"));
		assertTrue(kucingBangsawan.status().contains("100"));
		assertTrue(kucingBangsawan.status().contains("30"));
		/*assertTrue(kucingBangsawan.status().contains("Empress"));
		assertTrue(kucingPrajurit.status().contains("Rian"));
		assertTrue(kucingPrajurit.status().contains("120"));
		assertTrue(kucingPrajurit.status().contains("30"));
		assertTrue(kucingPrajurit.status().contains("Salsa"));
		assertTrue(kucingPrajurit.status().contains("80"));
		assertTrue(kucingPrajurit.status().contains("20"));*/

	}

	@Test
	@DisplayName("Test execute")
	void testEmpat() {
		KucingBangsawan kucing = (KucingBangsawan)(kucingBangsawan);
		KucingRakyat kucing2 = (KucingRakyat)(kucingRakyat);
		KucingRakyat kucing3 = (KucingRakyat)(kucingPrajurit);

		kucing.execute(kucing2);
		kucing.execute(kucing3);

		assertEquals(0, kucing2.getHealth());
		assertEquals(0, kucing3.getHealth());
	}

	@Test
	@DisplayName("Test pay tax")
	void testLima() {
		KucingRakyat kucing1 = (KucingRakyat)(kucingRakyat);
		KucingRakyat kucing2 = (KucingRakyat)(kucingPrajurit);

		kucing1.payTax();
		kucing2.payTax();

		assertEquals(60, kucing1.getHealth());
		assertEquals(100, kucing2.getHealth());

		kucing1.payTax();
		assertEquals(40, kucing1.getHealth());

	}
}
