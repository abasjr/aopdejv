import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This code is redeveloped from Ichlasul Affan's code
 */

@DisplayName("Kalkulator")
public class KalkulatorTest {
	// Membuat variabel baru untuk output dan error output
	private ByteArrayOutputStream outContent;
	private ByteArrayOutputStream errContent;

	// Untuk setiap test, lakukan setup terlebih dahulu
	@BeforeEach
	void setUp() {
		// inisiasi objek manusia

		// make new ByteArrayOutputStream for output and error output
		outContent = new ByteArrayOutputStream();
		errContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent)); // Connect outContent ke System.out
		System.setErr(new PrintStream(errContent)); // Connect errContent ke System.err
	}

	@Test
	@DisplayName("Test Hitung Penjumlahan")
	void testHitungJumlah() {
		hitung(9,"+",8);
		assertEquals(17);
	}

	@Test
	@DisplayName("Test Hitung Pengurangan")
	void testHitungJumlah() {
		hitung(9,"-",8);
		assertEquals(1);
	}

	@Test
	@DisplayName("Test Hitung Perkalian")
	void testHitungJumlah() {
		hitung(9,"*",8);
		assertEquals(72);
	}

	@Test
	@DisplayName("Test Hitung Pembagian")
	void testHitungJumlah() {
		hitung(9,"/",8);
		assertEquals(1);
	}

	@Test
	@DisplayName("Test Hitung Modulus")
	void testHitungJumlah() {
		hitung(9,"%",8);
		assertEquals(1);
	}

	@Test
	@DisplayName("Test Hitung Pemangkatan")
	void testHitungJumlah() {
		hitung(3,"^",3);
		assertEquals(27);
	}

	@Test
	@DisplayName("Test Hitung Pengakaran 2")
	void testHitungJumlah() {
		hitung(9,"v",2);
		assertEquals(3);
	}

	@Test
	@DisplayName("Test Hitung Pengakaran 3")
	void testHitungJumlah() {
		hitung(8,"v",3);
		assertEquals(2);
	}
}
