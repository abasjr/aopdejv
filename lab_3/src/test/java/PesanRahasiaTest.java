import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This code is redeveloped from Ichlasul Affan's code
 */

@DisplayName("Pesan Rahasia")
public class PesanRahasiaTest {
	// Membuat variabel baru untuk output dan error output
	private ByteArrayOutputStream outContent;
	private ByteArrayOutputStream errContent;

	// Untuk setiap test, lakukan setup terlebih dahulu
	@BeforeEach
	void setUp() {

		// make new ByteArrayOutputStream for output and error output
		outContent = new ByteArrayOutputStream();
		errContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent)); // Connect outContent ke System.out
		System.setErr(new PrintStream(errContent)); // Connect errContent ke System.err
	}

	@Test
	@DisplayName("Test Construct X Baris Pertama")
	void testConstructXBarisPertama() {
		assertEquals("JHHMNMV ZMXACUE RTFAVUZ FYKAK LIKAM KUSALZ HEYAAA",
				PesanRahasia.constructX("JAHSHCMFNDMAVE FZBMSXAAZCXUCEE FRGTTFZASVBUNZZ EFFYJKKALKI OLLIHKJAMMH DKAUDSFAVLRZV DHFERYTAFAVAR"));
	}

	@Test
	@DisplayName("Test Construct Y Baris Pertama")
	void testConstructYBarisPertama() {
		assertEquals("JHHMNMV ZMXACUE RTFAVUZ FYKA",
				PesanRahasia.constructY("JHHMNMV ZMXACUE RTFAVUZ FYKAK LIKAM KUSALZ HEYAAA"));
	}

	@Test
	@DisplayName("Test Isi Pesan Sebenarnya Baris Pertama")
	void testTerjemahanBarisPertama() {
		assertEquals("HMM MAU TAU YA", PesanRahasia.constructIsiPesanSebenarnya("JHHMNMV ZMXACUE RTFAVUZ FYKA"));
	}

	@Test
	@DisplayName("Test Construct X Baris Keempat")
	void testConstructXBarisEmpat() {
		assertEquals("FSGEHLJAKMKALTO OYIA FFD",
				PesanRahasia.constructX("FDSCGSEDHELFJAASKDMCKEAFLDTCOS CODYDICAC DFCFCDD"));
	}

	@Test
	@DisplayName("Test Construct Y Baris Keempat")
	void testConstructYBarisEmpat() {
		assertEquals("FSGEHLJAKMKALTO OYIA",
				PesanRahasia.constructY("FSGEHLJAKMKALTO OYIA FFD"));
	}

	@Test
	@DisplayName("Test Isi Pesan Sebenarnya Baris Keempat")
	void testTerjemahanBarisEmpat() {
		assertEquals("SELAMAT YA", PesanRahasia.constructIsiPesanSebenarnya("FSGEHLJAKMKALTO OYIA"));
	}
}
