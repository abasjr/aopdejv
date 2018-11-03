import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This code is redeveloped from Ichlasul Affan's code
 */

@DisplayName("Nama Anak TB")
public class NamaAnakTBTest {
	// Membuat variabel baru untuk output dan error output
	private ByteArrayOutputStream outContent;
	private ByteArrayOutputStream errContent;
	private NamaAnakTB tb1;
	private NamaAnakTB tb2;

	// Untuk setiap test, lakukan setup terlebih dahulu
	@BeforeEach
	void init() {
		// inisiasi objek manusia
		

		// make new ByteArrayOutputStream for output and error output
		outContent = new ByteArrayOutputStream();
		errContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent)); // Connect outContent ke System.out
		System.setErr(new PrintStream(errContent)); // Connect errContent ke System.err
	}

	@Test
	@DisplayName("Test palindrome 1")
	void testSatu() {
		assertTrue(tb1.isPal("hannah"));
		assertFalse(tb2.isPal("makan"));
	}

	@Test
	@DisplayName("Test palindrome 2")
	void testDua() {
		assertTrue(tb1.isPal("kasur rusak"));
		assertFalse(tb2.isPal("makan malam"));
	}

	@Test
	@DisplayName("Test palindrome 3")
	void testDua() {
		assertTrue(tb1.isPal("Kasur Rusak"));
		assertFalse(tb2.isPal("Makan Malam"));
	}

}
