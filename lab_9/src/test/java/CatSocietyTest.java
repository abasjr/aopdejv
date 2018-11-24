import org.junit.jupiter.api.*;

import characterv2.Kucing;
import characterv2.KucingBangsawan;
import characterv2.KucingPrajurit;
import characterv2.KucingRakyat;
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
	private Kucing kucingBangsawan2;
	private Kucing kucingPrajurit;
	private Kucing kucingRakyat;

	// Untuk setiap test, lakukan setup terlebih dahulu
	@BeforeEach
	void init() {
		// inisiasi objek manusia
		kucingBangsawan = new KucingBangsawan("Aya", "1000000000000000000000000000000000000000000000000000000000000000000000000000000", "300000000000000000000000000000000000000000000000000000000000000000000000000000", "Empress");
		kucingBangsawan2 = new KucingBangsawan("Aya", "0", "300000000000000000000000000000000000000000000000000000000000000000000000000000", "Emperror");
		kucingPrajurit = new KucingPrajurit("Rian", "1200000000000000000000000000000000000000000000000000000000000000000000000000000", "300000000000000000000000000000000000000000000000000000000000000000000000000000");
		kucingRakyat = new KucingRakyat("Salsa", "800000000000000000000000000000000000000000000000000000000000000000000000000000", "200000000000000000000000000000000000000000000000000000000000000000000000000000");

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
		assertEquals("500000000000000000000000000000000000000000000000000000000000000000000000000000", kucingRakyat.getHealth().toString());

		kucingRakyat.attack(kucingBangsawan);
		assertEquals("800000000000000000000000000000000000000000000000000000000000000000000000000000", kucingBangsawan.getHealth().toString());

		kucingPrajurit.attack(kucingRakyat);
		assertEquals("0", kucingRakyat.getHealth().toString());
	}

	@Test
	@DisplayName("Test sleep")
	void testDua() {

		kucingBangsawan.sleep();
		kucingPrajurit.sleep();
		kucingRakyat.sleep();

		assertEquals("1000000000000000000000000000000000000000000200000000000000000000000000000000000", kucingBangsawan.getHealth().toString());
		assertEquals("1200000000000000000000000000000000000000000200000000000000000000000000000000000", kucingPrajurit.getHealth().toString());
		assertEquals("800000000000000000000000000000000000000000200000000000000000000000000000000000", kucingRakyat.getHealth().toString());
	}

	@Test
	@DisplayName("Test status")
	void testTiga() {

		assertTrue(kucingBangsawan.status().contains("Aya"));
		assertTrue(kucingBangsawan.status().contains("1000000000000000000000000000000000000000000000000000000000000000000000000000000"));
		assertTrue(kucingBangsawan.status().contains("300000000000000000000000000000000000000000000000000000000000000000000000000000"));
		assertTrue(kucingBangsawan.status().contains("Empress"));
		assertTrue(kucingPrajurit.status().contains("Rian"));
		assertTrue(kucingPrajurit.status().contains("1200000000000000000000000000000000000000000000000000000000000000000000000000000"));
		assertTrue(kucingPrajurit.status().contains("300000000000000000000000000000000000000000000000000000000000000000000000000000"));

		assertTrue(kucingRakyat.status().contains("Salsa"));
		assertTrue(kucingRakyat.status().contains("800000000000000000000000000000000000000000000000000000000000000000000000000000"));
		assertTrue(kucingRakyat.status().contains("200000000000000000000000000000000000000000000000000000000000000000000000000000"));

	}

	@Test
	@DisplayName("Test execute")
	void testEmpat() {
		KucingBangsawan kucing = (KucingBangsawan)(kucingBangsawan);
		KucingRakyat kucing2 = (KucingRakyat)(kucingRakyat);
		KucingRakyat kucing3 = (KucingRakyat)(kucingPrajurit);

		kucing.execute(kucing2);
		kucing.execute(kucing3);

		assertEquals("0", kucing2.getHealth().toString());
		assertEquals("0", kucing3.getHealth().toString());
	}

	@Test
	@DisplayName("Test pay tax")
	void testLima() {
		KucingRakyat kucing1 = (KucingRakyat)(kucingRakyat);
		KucingRakyat kucing2 = (KucingRakyat)(kucingPrajurit);

		kucing1.payTax();
		kucing2.payTax();

		assertEquals("799999999999999999999999999999999999999999800000000000000000000000000000000000", kucing1.getHealth().toString());
		assertEquals("1199999999999999999999999999999999999999999800000000000000000000000000000000000", kucing2.getHealth().toString());

		kucing1.payTax();
		assertEquals("799999999999999999999999999999999999999999600000000000000000000000000000000000", kucing1.getHealth().toString());

	}

	@Test
	@DisplayName("Test interaksi setelah meninggal")
	void testEnam() {

		KucingBangsawan kucing3 = (KucingBangsawan)kucingBangsawan;
		KucingBangsawan kucing4 = (KucingBangsawan)kucingBangsawan2;
		KucingRakyat kucing1 = (KucingRakyat)(kucingRakyat);
		KucingRakyat kucing2 = (KucingRakyat)(kucingPrajurit);

		kucing4.sleep();
		kucing4.execute(kucing1);
		kucing4.execute(kucing2);
		assertEquals("0", kucing4.getHealth().toString());
		assertEquals("800000000000000000000000000000000000000000000000000000000000000000000000000000", kucing1.getHealth().toString());
		assertEquals("1200000000000000000000000000000000000000000000000000000000000000000000000000000", kucing2.getHealth().toString());

		kucing3.execute(kucing1);
		kucing3.execute(kucing2);

		kucingRakyat.sleep();
		kucingRakyat.attack(kucingBangsawan);
		kucingPrajurit.sleep();
		kucingPrajurit.attack(kucingBangsawan);

		kucing1.payTax();
		kucing2.payTax();

		assertEquals("0", kucing1.getHealth().toString());
		assertEquals("0", kucing2.getHealth().toString());
		assertEquals("1000000000000000000000000000000000000000000000000000000000000000000000000000000", kucingBangsawan.getHealth().toString());

	}
}
