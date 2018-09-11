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
}
