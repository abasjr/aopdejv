import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This code is redeveloped from Ichlasul Affan's code
 */

@DisplayName("Member")
public class MemberTest {
	// Membuat variabel baru untuk output dan error output
	private ByteArrayOutputStream outContent;
	private ByteArrayOutputStream errContent;
	private Member member1;
	private Member member2;

	// Untuk setiap test, lakukan setup terlebih dahulu
	@BeforeEach
	void init() {
		// inisiasi objek manusia
		member1 = new Member(1, "Pak Ijo", 18, 100000);
		member2 = new Member(2, "Pak Inem", 20);

		// make new ByteArrayOutputStream for output and error output
		outContent = new ByteArrayOutputStream();
		errContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent)); // Connect outContent ke System.out
		System.setErr(new PrintStream(errContent)); // Connect errContent ke System.err
	}

	@Test
	@DisplayName("Test nama")
	void testNama() {
		assertEquals("Pak Ijo", member1.getNama());
		assertEquals("Pak Inem", member2.getNama());
	}

	@Test
	@DisplayName("Test nomor member")
	void testNomorMember() {
		assertEquals(1, member1.getNomorMember());
		assertEquals(2, member2.getNomorMember());
	}

	@Test
	@DisplayName("Test Umur")
	void testUmur() {
		assertEquals(18, member1.getUmur());
		assertEquals(20, member2.getUmur());
	}

	@Test
	@DisplayName("Test saldo")
	void testSaldo() {
		assertEquals(100000, member1.getSaldo());
		assertEquals(50000, member2.getSaldo());
	}

	@Test
	@DisplayName("Test Pak Ijo top up saldo")
	void testTopUp() {
		member1.topUpSaldo(20000);
		assertEquals(120000, member1.getSaldo());
	}

	@Test
	@DisplayName("Test Pak Ijo kirim saldo")
	void testKirim() {
		member1.kirimSaldo(member2, 40000);
		assertEquals(60000, member1.getSaldo());
		assertEquals(90000, member2.getSaldo());
	}

	@Test
	@DisplayName("Test Pak Inem tutup member")
	void testTutup() {
		member2.tutupMember();
		assertEquals(true, member2.isMemberTutup());
	}

	@Test
	@DisplayName("Test Pak Ijo Ulang Tahun")
	void testUlangTahun() {
		member1.setUmur(60);
		assertEquals(true, member1.isMemberTutup());
	}

}
