import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This code is redeveloped from Ichlasul Affan's code
 */

@DisplayName("Kucing")
public class KucingTest {
	// Membuat variabel baru untuk output dan error output
	private ByteArrayOutputStream outContent;
	private ByteArrayOutputStream errContent;
	private Kucing kucing1;
	private Kucing kucing2;

	// Untuk setiap test, lakukan setup terlebih dahulu
	@BeforeEach
	void init() {
		// inisiasi objek manusia
		kucing1 = new Kucing("Blacky", "Persia", 901);
		kucing2 = new Kucing("Snowy", "Siam", 404);

		// make new ByteArrayOutputStream for output and error output
		outContent = new ByteArrayOutputStream();
		errContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent)); // Connect outContent ke System.out
		System.setErr(new PrintStream(errContent)); // Connect errContent ke System.err
	}

	@Test
	@DisplayName("Test nama")
	void testNama() {
		assertEquals("Blacky", kucing1.nama);
		assertEquals("Snowy", kucing2.nama);
	}

	@Test
	@DisplayName("Test ras")
	void testRas() {
		assertEquals("Persia", kucing1.ras);
		assertEquals("Siam", kucing2.ras);
	}

	@Test
	@DisplayName("Test umur")
	void testUmur() {
		assertEquals(901, kucing1.umur);
		assertEquals(404, kucing2.umur);
	}

	@Test
	@DisplayName("Test mengeong")
	void testMengeong() {
		assertEquals("Meooooooonnnnnng", kucing1.mengeong());
	}

	@Test
	@DisplayName("Test berjalan")
	void testBerjalan() {
		assertEquals("Kucingku, Blacky telah berjalan sejauh 1 langkah", kucing1.berjalan(1));
		assertEquals("Kucingku, Snowy telah berjalan sejauh 10 langkah", kucing2.berjalan(10));
	}

	@Test
	@DisplayName("Test tidur")
	void testTidur() {
		kucing1.tidur();
		kucing2.tidur();
		assertEquals(902, kucing1.umur);
		assertEquals(405, kucing2.umur);
	}
}
