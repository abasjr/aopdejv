import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This code is redeveloped from Ichlasul Affan's code
 */

@DisplayName("Rak Test")
public class RakTest {
	// Membuat variabel baru untuk output dan error output
	private ByteArrayOutputStream outContent;
	private ByteArrayOutputStream errContent;
	private Rak rak;

	// Untuk setiap test, lakukan setup terlebih dahulu
	@BeforeEach
	void init() {
		// inisiasi objek manusia
		rak = new Rak();
		rak.rak = new String[10];

		rak.simpanBarang("PIRING_KUCING", 0);
		rak.simpanBarang("MAKANAN_KUCING", 9);

		// make new ByteArrayOutputStream for output and error output
		outContent = new ByteArrayOutputStream();
		errContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent)); // Connect outContent ke System.out
		System.setErr(new PrintStream(errContent)); // Connect errContent ke System.err
	}

	@Test
	@DisplayName("Test Cek Barang")
	void testCekBarang() {
		assertEquals(false, rak.cekBarang("SENDOK"));
		assertEquals(true, rak.cekBarang("PIRING_KUCING"));
		assertEquals(true, rak.cekBarang("MAKANAN_KUCING"));
	}

	@Test
	@DisplayName("Test Cari Barang")
	void testCariBarang() {
		assertEquals(-1, rak.cariBarang("SENDOK"));
		assertEquals(0, rak.cariBarang("PIRING_KUCING"));
        assertEquals(9, rak.cariBarang("MAKANAN_KUCING"));
	}

	@Test
	@DisplayName("Test Simpan Barang")
	void testSimpanBarang() {
		assertEquals(false, rak.simpanBarang("SENDOK", 0));
        assertEquals(true, rak.simpanBarang("SENDOK", 1));
	}

	@Test
	@DisplayName("Test Ambil Barang")
	void testAmbilBarang() {
        assertEquals("Rak kosong", rak.ambilBarang(7));
        assertEquals("PIRING_KUCING", rak.ambilBarang(0));
        assertEquals("Rak kosong", rak.ambilBarang(0));
	}

	@Test
	@DisplayName("Test Pindah Barang")
	void testPindahBarang() {
		rak.pindahBarang("PIRING_KUCING",0, 9);
	    assertEquals("MAKANAN_KUCING", rak.rak[0]);
	    assertEquals("PIRING_KUCING", rak.rak[9]);
        rak.pindahBarang("PIRING_KUCING",9, 8);
        assertEquals(null, rak.rak[9]);
        assertEquals("PIRING_KUCING", rak.rak[8]);
    }
}
