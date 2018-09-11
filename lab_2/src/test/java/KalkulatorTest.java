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
		assertEquals(17,Kalkulator.hitung(9,"+",8));
	}

	@Test
	@DisplayName("Test Hitung Pengurangan")
	void testHitungKurang() {
		assertEquals(1,Kalkulator.hitung(9,"-",8));
	}

	@Test
	@DisplayName("Test Hitung Perkalian")
	void testHitungKali() {
		assertEquals(72,Kalkulator.hitung(9,"*",8));
	}

	@Test
	@DisplayName("Test Hitung Pembagian")
	void testHitungBagi() {
		assertEquals(1,Kalkulator.hitung(9,"/",8));
	}

	@Test
	@DisplayName("Test Hitung Modulus")
	void testHitungMod() {
		assertEquals(1,Kalkulator.hitung(9,"%",8));
	}

	@Test
	@DisplayName("Test Hitung Pemangkatan")
	void testHitungPangkat() {
		assertEquals(27,Kalkulator.hitung(3,"^",3));
	}

	@Test
	@DisplayName("Test Hitung Pengakaran 2")
	void testHitungAkar2() {
		assertEquals(3,Kalkulator.hitung(9,"v",2));
	}

	@Test
	@DisplayName("Test Hitung Pengakaran 3")
	void testHitungAkar3() {
		assertEquals(2,Kalkulator.hitung(8,"v",3));
	}
}
