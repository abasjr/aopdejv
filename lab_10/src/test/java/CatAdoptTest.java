import org.junit.jupiter.api.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This code is redeveloped from Ichlasul Affan's code
 */

@DisplayName("Makhluk Hidup Test")
public class MakhlukHidupTest {
	// Membuat variabel baru untuk output dan error output
	private ByteArrayOutputStream outContent;
	private ByteArrayOutputStream errContent;
	private MakhlukHidup mhm;
	private MakhlukHidup mht;
	private MakhlukHidup mhh;
	private Manusia m;
	private Manusia mot;
	private Manusia ma;
	private Tumbuhan t;
	private Hewan h;
	private Hewan hk;
	private Hewan hhb;
	private OrangTua ot;
	private Anak a;
	private Karnivora k;
	private Herbivora hb;

	// Untuk setiap test, lakukan setup terlebih dahulu
	@BeforeEach
	void init() {
		// inisiasi objek
		mhm = new Manusia();
		mht = new Tumbuhan();
		mhh = new Hewan();
		m = new Manusia();
		mot = new OrangTua();
		ma = new Anak();
		t = new Tumbuhan();
		h = new Hewan();
		hk = new Karnivora();
		hhb = new Herbivora();
		ot = new OrangTua();
		a = new Anak();
		k = new Karnivora();
		hb = new Herbivora();

		// make new ByteArrayOutputStream for output and error output
		outContent = new ByteArrayOutputStream();
		errContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent)); // Connect outContent ke System.out
		System.setErr(new PrintStream(errContent)); // Connect errContent ke System.err
	}

	@Test
	@DisplayName("Test Manusia")
	void testSatu() {
		assertTrue(mhm.makan().contains("manusia"));
		assertTrue(mhm.makan().contains("hewan"));
		assertTrue(mhm.makan().contains("tumbuhan"));
		assertTrue(mhm.bernafas().contains("manusia"));
		assertTrue(mhm.bernafas().contains("oksigen"));
		assertTrue(mhm.bergerak().contains("manusia"));
		assertTrue(mhm.bergerak().contains("sedang"));
	}

	@Test
	@DisplayName("Test Hewan")
	void testDua() {
		assertTrue(mhh.makan().contains("hewan"));
		assertTrue(mhh.makan().contains("hewan"));
		assertTrue(mhh.makan().contains("tumbuhan"));
		assertTrue(mhh.bernafas().contains("hewan"));
		assertTrue(mhh.bernafas().contains("oksigen"));
		assertTrue(mhh.bergerak().contains("hewan"));
		assertTrue(mhh.bergerak().contains("cepat"));
	}

	@Test
	@DisplayName("Test Tumbuhan")
	void testTiga() {
		assertTrue(mht.makan().contains("tumbuhan"));
		assertTrue(mht.makan().contains("nutrisi"));
		assertTrue(mht.makan().contains("tanah"));
		assertTrue(mht.bernafas().contains("tumbuhan"));
		assertTrue(mht.bernafas().contains("karbondioksida"));
		assertTrue(mht.bergerak().contains("tumbuhan"));
		assertTrue(mht.bergerak().contains("diam"));
	}

	@Test
	@DisplayName("Test Orang Tua")
	void testEmpat() {
		assertTrue(mot.makan().contains("orang"));
		assertTrue(mot.makan().contains("tua"));
		assertTrue(mot.makan().contains("tumbuhan"));
		assertTrue(mot.bernafas().contains("orang"));
		assertTrue(mot.bernafas().contains("tua"));
		assertTrue(mot.bernafas().contains("oksigen"));
		assertTrue(mot.bergerak().contains("orang"));
		assertTrue(mot.bergerak().contains("tua"));
		assertTrue(mot.bergerak().contains("lambat"));
	}

	@Test
	@DisplayName("Test Anak")
	void testLima() {
		assertTrue(ma.makan().contains("anak"));
		assertTrue(ma.makan().contains("hewan"));
		assertTrue(ma.bernafas().contains("anak"));
		assertTrue(ma.bernafas().contains("oksigen"));
		assertTrue(ma.bergerak().contains("anak"));
		assertTrue(ma.bergerak().contains("cepat"));
	}

	@Test
	@DisplayName("Test Variabel Turunan pada Anak")
	void testEnam() {
		Anak ma1 = new Anak("Bambang", "Depok", 21, 171, 64, "SMA");
		assertEquals("Bambang",ma1.getNama());
		assertEquals("Depok",ma1.getTmpLahir());
		assertEquals(21,ma1.getUsia());
		assertEquals(171,ma1.getTb());
		assertEquals(64,ma1.getBb());
		assertEquals("SMA",ma1.getDerajatSekolah());
	}

	@Test
	@DisplayName("Test Variabel Turunan pada Orang Tua")
	void testTujuh() {
		Anak ma1 = new Anak("Bambang", "Depok", 21, 171, 64, "SMA");
		OrangTua mot1 = new OrangTua("Ferguso", "Depok", 31, 175, 74, "Pengajar", ma1);
		assertEquals("Ferguso",mot1.getNama());
		assertEquals("Depok",mot1.getTmpLahir());
		assertEquals(31,mot1.getUsia());
		assertEquals(175,mot1.getTb());
		assertEquals(74,mot1.getBb());
		assertEquals("Pengajar",mot1.getPekerjaan());
		assertEquals("Bambang",mot1.getAnak().get(0).getNama());
	}

	@Test
	@DisplayName("Test Variabel Turunan pada Herbivora dan Karnivora")
	void testLapan() {
		Hewan hh1 = new Herbivora(2);
		assertEquals(2,hh1.getJumlahKaki());
		Karnivora hk1 = new Karnivora(4);
		assertEquals(4,hk1.getJumlahKaki());
	}

	@Test
	@DisplayName("Test Karnivora")
	void testBilan() {
		assertTrue(hk.makan().contains("karnivora"));
		assertTrue(hk.makan().contains("hewan"));
		assertTrue(hk.bernafas().contains("karnivora"));
		assertTrue(hk.bernafas().contains("oksigen"));
		assertTrue(hk.bergerak().contains("karnivora"));
		assertTrue(hk.bergerak().contains("cepat"));
	}

	@Test
	@DisplayName("Test Herbivora")
	void testPuluh() {
		assertTrue(hhb.makan().contains("herbivora"));
		assertTrue(hhb.makan().contains("tumbuhan"));
		assertTrue(hhb.bernafas().contains("herbivora"));
		assertTrue(hhb.bernafas().contains("oksigen"));
		assertTrue(hhb.bergerak().contains("herbivora"));
		assertTrue(hhb.bergerak().contains("cepat"));
	}
}
