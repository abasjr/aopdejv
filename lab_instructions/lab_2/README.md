# Lab 2 : Expression, Operators, dan Decision
Dasar-dasar Pemrograman 2 - CSGE601021 | Fakultas Ilmu Komputer, Universitas Indonesia, Semester Gasal 2018/2019

**Dibuat oleh: ANGA, dimodifikasi dari Tutorial DDP2 2017**

* * *

Pada tutorial sebelumnya, Anda telah mempelajari mengenai beberapa perbedaan syntax antara bahasa pemrograman Java dan Python. Anda juga telah mempelajari version control system yaitu Git. Kali ini, Anda akan mempelajari lebih dalam konsep pemrograman dalam bahasa pemrograman Java.

## **Tujuan Pembelajaran**
1. Memahami konsep **tipe data** dalam Java (tipe data primitif, tipe data reference, dan casting).
2. Memahami **control flow** dalam Java (conditionals, iteratives, branching statements).
3. Memahami konsep dasar **String** dan operasi String.
4. Memahami dasar-dasar **_Input_ dan _Output_** dalam Java (Scanner, System.out, parsing).

### **Before You Start...**
1. Lakukan `git pull upstream master` dengan menggunakan Command Prompt pada folder repository lokal Anda.
2. Anda dapat mengimplementasikan source code java tutorial 2 pada folder `ddp-lab/tutorial-2/main/java`.
3. Implementasikan kode Anda sesuai apa yang diminta soal tutorial dan lab nanti.
4. Setelah selesai mengimplementasikan kode tersebut, lakukan add, commit, dan push code kalian tersebut.
5. Selamat Anda berhasil!

## **Materi Tutorial**
### **Data Type**
Tipe data merupakan jenis tipe nilai apa yang dapat dimasukkan ke dalam suatu variabel, serta operasi apa yang dapat dapat diterapkan terhadap variabel tersebut. Operasi yang dapat diterapkan pada suatu variabel dapat berupa operasi matematika, relasi, dan logika.
Berbeda dengan bahasa Python, pada bahasa Java, kita harus mendeklarasikan secara explicit tipe data variabel yang akan diinisiasi.

**Python**
```python
iniString = “DDP 2”
iniInt = 2018
iniFloat = 4.4
```

**Java**
```java
String iniString = “DDP 2”;
int iniInt = 2018;
float iniFloat = 4.4;
```

Secara umum, pada setiap bahasa pemrograman memiliki tiga kategori tipe data yaitu:
1. **Primitive Data Types**

	Primitive Data Type merupakan tipe data yang hanya memiliki maksimum satu nilai saja.
	![Primitive Data Types](https://only4techies.files.wordpress.com/2009/10/3.jpg)

	Dalam bahasa pemrograman Java Anda dapat melakukan type casting, yaitu mengassign nilai tipe data suatu variabel dengan tipe data yang berbeda. Terdapat dua macam type casting, yaitu
	- **Widening** (sudah dilakukan secara implisit ):
		```java
		int anInt = 18;
		long aLong = anInt;
		float aFloat = aLong;

		// hasil type casting
		// anInt = 18
		// aLong = 18
		// aFloat = 18.0
		```
	- **Narrowing** (harus didefinisikan secara eksplisit):
		```java
		double aDouble = 18.1;
		long aLong = (long) aDouble;
		int anInt = (int) aLong;

		// hasil type casting
		// aDouble = 18.1
		// aLong = 18
		// anInt = 18
		```

2. **Derived Data Types**

	Derived Data Types merupakan tipe data yang dapat di-parsing. Dalam bahasa pemrograman Java, terdapat teknik parsing. Teknik parsing merupakan teknik untuk mengubah tipe data non primitive menjadi tipe data primitive, begitu juga sebaliknya. Dimana hasil parsing tersebut di-assign ke variabel lain.
	```java
	// mengassign var angka dengan hasil parsing
	// string to integer var stringAngka
	String stringAngka = “2018”;
	int angka = Integer.parseInt(stringAngka);
	```

3. **User Defined Data Types**

	User Defined Data Type merupakan tipe data yang didefinisikan sendiri.

### **Control Flow**
Secara umum, komputer akan mengeksekusi code secara berurutan dari baris atas ke bawah. Perintah pada bahasa pemrograman untuk mengubah urutan eksekusi program sesuai kebutuhan dinamakan sebagai Control Flow. Pada umumnya, bahasa pemrograman terdapat tiga jenis perintah control flow yaitu:

#### 1. **Decision Making**
Anda tentu telah mengerti konsep dan syntax decision making pada bahasa pemrograman Python. Dibandingkan dengan bahasa pemrograman Python, decision making pada bahasa pemrograman Java hanya berbeda dari segi syntax.

**Python**
```python
if (nilai >= 80):
	print("Nilai A")
elif (nilai >= 60 and nilai < 80):
	print("Nilai B")
else:
	print("Nilai C")
```

**Java**
```java
if (nilai >= 80){
	System.out.println("Nilai A");
} else if (nilai >= 60 && nilai < 80) {
	System.out.println("Nilai B");
} else {
	System.out.println("Nilai C");
}
```

#### 2. **Looping**
Konsep looping pun juga ada dalam bahasa pemrograman Java. Looping pada java diantaranya for loop, for each loop, do while loop, dan while loop.

- **While**

	Python:
	```pyton
	i = 20;
	while (i>0):
	print(i)
	i = i-1
	```

	Java:
	```java
	int i = 20;
	while (i>0) {
		System.out.print(i);
		i--;
	}
	```

- **For**

	Python:
	```python
	for x in range(20):
		print(i);
	```

	Java:
	```java
	for (int i=0; i<20; i++) {
		System.out.print(i);
	}
	```

- **Do While**

	Looping Do While tidak ada di Python. Berikut ini adalah contoh kode Java-nya:
	```java
	do {
		System.out.println("Halo");
	} while (true);
	```

#### 3. **Branching Statement**
Terdapat beberapa statement yang sangat berguna untuk branching pada loop yaitu statement break, continue, dan return.
- **break** - digunakan untuk menghentikan loop

	**Contoh Output:**
	```
	0
	1
	2
	```

	**Contoh Kode Python:**
	```python
	for i in range(4):
		if i == 3:
			break
	print(i)
	```

	**Contoh Kode Java:**
	```java
	int[] arr = {0,1,2,3};
	for(int i:arr) {
		if(i == 3) {
			break;
		}
		System.out.println(i);
	}
	```

- **continue** - digunakan untuk melompati suatu iterasi

	**Contoh Output:**
	```
	0
	2
	3
	```

	**Contoh Kode Python:**
	```python
	for i in range(3):
		if i == 1:
			continue
	print(i)
	```

	**Contoh Kode Java:**
	```java
	int[] arr = {0,1,2,3};
	for(int i:arr) {
		if(i == 1) {
			continue;
		}
		System.out.println(i);
	}
	```

- **return** - digunakan untuk mengembalikan nilai
	**Contoh Output:**
	```
	2
	```

	**Contoh Kode Python:**
	```python
	def returnAngka(angka):
			return angka
	print(returnAngka(2))
	```

	**Contoh Kode Java:**
	```java
	public static int returnAngka(int angka) {
		return angka;
	}
	public static void main(String[] args) {
	System.out.println(returnAngka(2));
	}
	```

### **String**
Seperti Python, kalimat-kalimat yang bukan berupa angka merupakan tipe data String. String merupakan tipe data **reference** dan bersifat **immutable** (tidak bisa mengganti isi objek yang sama, harus membuat objek baru). Berikut ini adalah contoh perbandingan penggunaan String:

**Python**
```python
pesan = “DDP2”
pesanKecil = “saya usep”

pesanDipotong = pesan[:3]
pesanBesar = pesanKecil.upper()
ukuran = len(pesanKecil)
huruf = pesanKecil[1]

print(pesanDipotong)
print(pesanBesar)
print(ukuran)
print(huruf)
```

Output program di atas:
```python
DDP
SAYA USEP
9
a
```

**Java**
```java
String pesan = “DDP2”;
String pesanKecil = “saya usep”;

String pesanDipotong = pesan.substring(0,3);
String pesanBesar = pesanKecil.toUpperCase();
int ukuran = pesanKecil.length();
char huruf = pesanKecil.charAt(1);

System.out.println(pesanDipotong);
System.out.println(pesanBesar);
System.out.println(ukuran);
System.out.println(huruf);
System.out.println(5 + 3 + ““ + 53);
```

Output program di atas:
```java
DDP
SAYA USEP
9
a
853
```

### **Input dan Output Sederhana**
Pada umumnya, setiap program membutuhkan masukan dari pengguna, dan mengembalikannya lagi berupa keluaran yang diinginkan oleh pengguna. Dalam bahasa pemrograman Java, terdapat dua variabel sistem yang berfungsi untuk Input/Output, yaitu **System.in** sebagai **input**, dan **System.out** sebagai **output**. Cara menggunakannya adalah sebagai berikut:

#### 1. **Output**
Output pada command-line Java sebenarnya sangat mudah untuk digunakan, kita dapat menggunakan beberapa method pada System.out, seperti **contoh** di bawah ini:

```java
String namaSapi = “Cang”;
float beratSapi = 1532.3;

// println -> cetak dengan diakhiri baris baru
System.out.println(“Nama: “);
System.out.println(namaSapi);
// print -> cetak tanpa diakhiri baris baru
System.out.print(“Berat: “);
System.out.print(beratSapi);
```

**Keluaran program**:
```java
Nama:
Cang
Berat: 1532.3
```

#### 2. **Input**
Input pada Java membutuhkan objek input reader tersendiri untuk membaca System.in. Pada DDP2, kalian akan menggunakan objek Scanner. Berikut ini adalah **contoh** penggunaannya:

```java
// Inisialisasi objek Scanner dan simpan di suatu variabel
Scanner input = new Scanner(System.in);

String nama = input.nextLine();
String panggilan1 = input.next();
String panggilan2 = input.next();

// Tutup objek Scanner setelah selesai digunakan (best practice)
input.close();
```

Apabila pengguna mengetik seperti ini di console:
```java
Muhammad Abdurrahman
Abd Aab
```

Maka **isi variabel** setelah program dijalankan adalah:
> - `nama`  →  `“Muhammad Abdurrahman”`
> - `panggilan1`  →  `“Abd”`
> - `panggilan2`  →  `“Aab”`

#### 3. **Mengubah String ke bilangan (tipe primitif) dan bilangan ke String**
Layaknya Python, dalam bahasa pemrograman Java kita juga dapat melakukan konversi dari **String** ke format bilangan yang berupa **tipe primitif** seperti int, float, dsb.
- **Integer.parseInt()**, untuk mengubah **String → int**
- **Byte.parseByte()**, untuk mengubah **String → byte**
- **Short.parseShort()**, untuk mengubah **String → short**
- **Long.parseLong()**, untuk mengubah **String → long**
- **Float.parseFloat()**, untuk mengubah **String → float**
- **Double.parseDouble()**, untuk mengubah **String → double**
- **Boolean.parseBoolean()**, untuk mengubah **String → boolean**
- **String.valueOf()**, untuk mengubah **tipe primitif → String**

**Python**
```python
nomor = “553”
nomorInt = int(nomor)
nomorFloat = float(nomor)
nomor2 = str(nomorFloat
```

**Java**
```java
String nomor = “553”
int nomorInt = Integer.parseInt(nomor);
float nomorFloat = Float.parseFloat(nomor);
String nomor2 = String.valueOf(nomorFloat);
```

**Isi variabel** setelah program dijalankan:
> - `nomorInt`  →  `553`
> - `nomorFloat`  →  `553.0`
> - `nomor2`  →  `“553.0”`

## **Soal Tutorial: "Sensus Daerah Kumuh (Slum)"**
### **What's the story?**
Kak Pewe adalah seorang petugas bidang survei lapangan dari Dinas Kependudukan Provinsi Tamfir. Saat ini, Dinas Kependudukan Provinsi Tamfir akan melaksanakan pendataan (yang seringkali orang sebut dengan sensus) khusus penduduk di daerah-daerah kumuh di provinsi Tamfir. Sensus ini perlu dilakukan untuk mengatasi masalah kebersihan dan kesehatan lingkungan yang seringkali dikeluhkan oleh lingkungan megapolitan seperti provinsi Tamfir.

Tentu saja Kak Pewe sangat khawatir terhadap beratnya pekerjaan ini, yang harus ia selesaikan dalam waktu tiga hari, sebelum Pemerintah Pusat mengirimkan bantuan untuk merapikan daerah kumuh yang ada dan mempersiapkan relokasi untuk penduduk. Nah… Kak Pewe tahu kalau adiknya, Dek Depe punya banyak teman yang kini kuliah di Fasilkom UI.

Oleh karena itu, Kak Pewe meminta bantuan adiknya, Dek Depe, untuk mencari teman dalam mengerjakan tugas ini, dan kamu adalah orang yang tepat. Pada suatu hari, Dek Depe berkunjung ke Fasilkom UI, dan memberikanmu sebuah surat sederhana beserta lampirannya:

> “Wahai temanku, aku ingin meminta bantuan kamu untuk membuatkan program yang mampu mencetak data penduduk setelah dimasukkan. Tolong bantu aku, kakakku sangat membutuhkannya untuk memperbaiki lingkungan provinsi Tamfir. Semua ketentuan program yang harus dibuat sudah terlampir ya… Terima kasih :)”

### **A little trigger?**
Sebelum kamu mengerjakan soal tutorial ini, ada baiknya kamu membaca penjelasan materi yang diberikan sebelumnya, lalu jawab pertanyaan berikut ini sebagai "pemanasan" sebelum mengerjakan tutorial :D

> **Ingat kembali!**
> - Bagaimana kita membuat program yang dapat menerima input dari user?
> - Bagaimana mengubah input masukan yang berupa String menjadi tipe data tertentu?
> - Sebutkan tipe-tipe data yang kamu ketahui! Jelaskan penggunaan tipe data tersebut!
> - Apa itu keyword ‘static’? Jelaskan apa yang dimaksud dengan ‘static method’!
> - Sebutkan dan jelaskan jenis-jenis loop pada bahasa pemrograman java!
> - Bagaimana cara membuat program agar dapat mencetak output?

### **What you need to do**
- [ ] **Meminta masukan dari user**
	- [ ] Nama Kepala Keluarga (kalimat, dapat lebih dari 1 kata).
	- [ ] Alamat Rumah (kalimat, dapat lebih dari 1 kata).
	- [ ] Panjang, Lebar, Tinggi Badan (bilangan bulat, satuan cm, dijamin ≤ 250 cm).
	- [ ] Berat Badan (bilangan riil, satuan kg, dijamin ≤ 150 kg).
	- [ ] Jumlah Anggota Keluarga (bilangan bulat, dijamin ≤ 20).
	- [ ] Tanggal Lahir (format DD-MM-YYYY, 1000 < tahun < 2018, dijamin benar).
	- [ ] Catatan Tambahan (kalimat, dapat lebih dari 1 kata).
	- [ ] Jumlah Cetakan Data (bilangan bulat, dijamin ≤ 99).
	- [ ] Pastikan tipe data yang digunakan setiap variabel masukan adalah yang paling efisien (tipe data terkecil yang pas dengan kebutuhan).
	- [ ] Buat user interface permintaan masukan yang baik (sebaiknya gunakan format contoh, namun dapat menyesuaikan dengan kreativitas kalian).

- [ ] **Hitung rasio berat per volume**
	- [ ] Gunakan rumus: (Berat (kg)) / (Panjang (m) * Lebar (m) * Tinggi (m)).
	- [ ] Pastikan kamu telah menyesuaikan satuan input dari cm ke m saat menghitung.
	- [ ] Pastikan kamu menggunakan tipe data yang tepat saat menghitung.
	- [ ] Tipe data akhir hasil perhitungan adalah bilangan bulat (perhatikan bahwa tipe data harus seefisien mungkin → tipe data terkecil yang pas dengan kebutuhan).

- [ ] **Cetak data sesuai dengan format yang ditentukan**
	- [ ] Lakukan looping sebanyak jumlah cetakan.
	- [ ] Pada setiap iterasi, terdapat masukan untuk meminta nama penerima data, lalu cetak data keluarga. Gunakan format berikut: (masukan dicetak tebal)
		<pre>Pencetakan [Nomor] dari [Jumlah Cetakan] untuk: <b>[Penerima Data]</b>
		DATA SIAP DICETAK UNTUK [PENERIMA DATA (UPPERCASE)]
		-----------------
		[Nama Kepala Keluarga] - [Alamat Rumah]
		Lahir pada tanggal [Tanggal Lahir]
		Rasio Berat Per Volume     = [Rasio] kg/m^3
		Catatan: [Catatan]
		</pre>
	- [ ] Jika tidak ada catatan, ganti baris `Catatan: [Catatan]` menjadi:
		<pre>Tidak ada catatan tambahan</pre>

### **Contoh Input dan Output**
Berikut ini adalah contoh interaksi program (yang dicetak tebal adalah masukan):
<pre>PROGRAM PENCETAK DATA SENSUS
--------------------
Nama Kepala Keluarga           : <b>Butterfield</b>
Alamat Rumah                   : <b>RSE</b>
Panjang Tubuh (cm)             : <b>30</b>
Lebar Tubuh (cm)               : <b>60</b>
Tinggi Tubuh (cm)              : <b>170</b>
Berat Tubuh (kg)               : <b>75</b>
Jumlah Anggota Keluarga        : <b>1</b>
Tanggal Lahir                  : <b>22-01-2000</b>
Catatan Tambahan               : <b>Belum berkeluarga, orang kaya</b>
Jumlah Cetakan Data            : <b>3</b>

Pencetakan 1 dari 3 untuk: <b>Arsip pemerintah provinsi Tamfir</b>
DATA SIAP DICETAK UNTUK ARSIP PEMERINTAH PROVINSI TAMFIR
--------------------
Butterfield - RSE
Lahir pada tanggal 22-01-2000
Rasio Berat Per Volume     = 245 kg/m^3
Catatan: Belum berkeluarga, orang kaya

Pencetakan 2 dari 3 untuk: <b>Badan Kesehatan Lingkungan Nasional</b>
DATA SIAP DICETAK UNTUK BADAN KESEHATAN LINGKUNGAN NASIONAL
--------------------
Butterfield - RSE
Lahir pada tanggal 22-01-2000
Rasio Berat Per Volume     = 245 kg/m^3
Catatan: Belum berkeluarga, orang kaya

Pencetakan 3 dari 3 untuk: <b>gubernur provinsi Tamfir</b>
DATA SIAP DICETAK UNTUK GUBERNUR PROVINSI TAMFIR
--------------------
Butterfield - RSE
Lahir pada tanggal 22-01-2000
Rasio Berat Per Volume     = 245 kg/m^3
Catatan: Belum berkeluarga, orang kaya
</pre>

Berikut ini adalah contoh lain interaksi program yang mungkin terjadi  (yang dicetak tebal adalah masukan):
<pre>PROGRAM PENCETAK DATA SENSUS
--------------------
Nama Kepala Keluarga           : <b>master Shifu</b>
Alamat Rumah                   : <b>Ninja</b>
Panjang Tubuh (cm)             : <b>36</b>
Lebar Tubuh (cm)               : <b>71</b>
Tinggi Tubuh (cm)              : <b>189</b>
Berat Tubuh (kg)               : <b>68.5</b>
Jumlah Anggota Keluarga        : <b>7</b>
Tanggal Lahir                  : <b>12-03-1971</b>
Catatan Tambahan               : <b></b>
Jumlah Cetakan Data            : <b>2</b>

Pencetakan 1 dari 2 untuk: <b>komunitas lingkungan hidup Fasilkom</b>
DATA SIAP DICETAK UNTUK KOMUNITAS LINGKUNGAN HIDUP FASILKOM
--------------------
master Shifu - Ninja
Lahir pada tanggal 12-03-1971
Rasio Berat Per Volume     = 141 kg/m^3
Tidak ada catatan tambahan

Pencetakan 2 dari 2 untuk: <b>Arsip pemerintah kabupaten Fasilkom</b>
DATA SIAP DICETAK UNTUK ARSIP PEMERINTAH KABUPATEN FASILKOM
--------------------
master Shifu - Ninja
Lahir pada tanggal 12-03-1971
Rasio Berat Per Volume     = 141 kg/m^3
Tidak ada catatan tambahan
</pre>

### **Any templates?**
Jadi... ternyata Dek Depe punya teman yang bersedia untuk mempermudah kamu dalam menyelesaikan pekerjaan ini, namun karena ia sibuk, ia hanya mampu membuat **template**nya saja. **Template** terdapat pada `/lab_2/src/main/java/SistemSensus.java`.

Bagaimana cara menggunakannya? Langsung modifikasi template tersebut, isi dengan kode-kode jawaban kalian :) Panduan lebih lanjutnya sudah ada di dalam kode templatenya ya!

## **Soal Bonus: "Rekomendasi Apartemen"**
### **What's the story?**
Berkat bantuanmu, Kak Pewe berhasil melaksanakan sensus terhadap slums di Provinsi Tamfir tepat waktu. Setelah dilakukan penataan lingkungan selama satu bulan, ternyata tidak semua orang bisa menempati daerah tersebut, sehingga ada yang perlu direlokasi. Mak Dis selaku kepala Dinas Perumahan Rakyat Provinsi Tamfir telah memberikan rekomendasi tiga apartemen yang akan dijadikan tempat relokasi, beserta ketentuan dalam menentukan tempat relokasi. Kak Pewe diminta untuk mendata ulang terhadap orang-orang yang memenuhi prasyarat untuk dapat direlokasi. Dan ia tentu meminta bantuan adiknya, Dek Depe, sekali lagi.

Oleh karena itu, Dek Depe juga meminta bantuanmu sekali lagi untuk melanjutkan program yang telah dibuat sebelumnya, lalu menambahkan fitur baru sesuai checklist berikut:

### **What you need to do**
- [ ] **Validasi masukan**

	Validasi dilakukan setelah pengguna selesai memasukkan semua masukan yang dibutuhkan. Jika masukan tidak sesuai dengan ketentuan di bawah maka:
	- [ ] Tampilkan pesan **langsung** saat user memasukkan input yang tidak valid (di luar batasan yang ditentukan):
		<pre>WARNING: Keluarga ini tidak perlu direlokasi!</pre>
	- [ ] Keluar dari program (hint: gunakan branching statement yang sesuai)
	Berikut ini adalah ketentuan masukan yang harus divalidasi:
		- [ ] 0 < **panjang tubuh** ≤ 250 cm, merupakan bilangan **bulat**.
		- [ ] 0 < **lebar tubuh** ≤ 250 cm, merupakan bilangan **bulat**.
		- [ ] 0 < **tinggi tubuh** ≤ 250 cm, merupakan bilangan **bulat**.
		- [ ] 0 < **berat tubuh** ≤ 150 kg, merupakan bilangan **riil**.
		- [ ] 0 < **jumlah anggota keluarga** ≤ 20, merupakan bilangan **bulat**.

- [ ] ***Generate* nomor pengenal keluarga**
	- [ ] Gunakan format: `[Huruf pertama nama kepala keluarga][Hasil kalkulasi]`.
	- [ ] Untuk kalkulasi, gunakan rumus:
		```
		((Panjang * Tinggi * Lebar) + Jumlah ASCII tiap huruf nama) mod 10000.
		```

		**Contoh Kasus:**
		```java
		nama = “are NG”
		panjang = 71
		lebar = 26
		tinggi = 37
		```
		Maka **nomor keluarga** adalah: `a8795`.

- [ ] **Hitung anggaran makanan per tahun**
	- [ ] Gunakan rumus: `Rp 50000 * 365 * (jumlah anggota keluarga)`.
	- [ ] Pastikan kamu menggunakan tipe data yang tepat **saat menghitung**.
	- [ ] Tipe data akhir hasil perhitungan adalah **bilangan bulat** (perhatikan bahwa tipe data harus seefisien mungkin → tipe data terkecil yang pas dengan kebutuhan).

- [ ] **Hitung umur kepala keluarga**
	- [ ] Ambil tahun lahir dari tanggal lahir.
	- [ ] Gunakan rumus: **2018 - (tahun lahir)**.
	- [ ] Tipe data akhir hasil perhitungan adalah **bilangan bulat** (perhatikan bahwa tipe data harus seefisien mungkin → tipe data terkecil yang pas dengan kebutuhan).

- [ ] **Mengelompokkan keluarga ke apartemen**
	- [ ] Berikut ini adalah daftar apartemen beserta kriterianya:
		- > Nama: **PPMT**<br>
			> Kabupaten: **Rotunda**<br>
			> RANGE Anggaran Makanan/Tahun: **BEBAS**<br>
			> RANGE Umur Kepala Keluarga: **0** tahun s.d. **18** tahun
		- > Nama: **Teksas**<br>
			> Kabupaten: **Sastra**<br>
			> RANGE Anggaran Makanan/Tahun: Rp **0** s.d. Rp **100.000.000**<br>
			> RANGE Umur Kepala Keluarga: **19** tahun s.d. **1018** tahun
		- > Nama: **Mares**<br>
			> Kabupaten: **Margonda**<br>
			> RANGE Anggaran Makanan/Tahun: Rp **100.000.000** s.d. **TAK HINGGA**<br>
			> RANGE Umur Kepala Keluarga: **19** tahun s.d. **1018** tahun
- [ ] **Cetak rekomendasi sesuai dengan format yang ditentukan**
	<pre>
		REKOMENDASI APARTEMEN
		--------------------
		MENGETAHUI: Identitas keluarga: < Nama Kepala Keluarga > - < Nomor >
		MENIMBANG:  Anggaran makanan tahunan: Rp < Anggaran >
					Umur kepala keluarga: < Umur > tahun
		MEMUTUSKAN: keluarga < Nama Kepala Keluarga > akan ditempatkan di:
		< Nama Tempat >, kabupaten < Nama Kabupaten >
	</pre>

> **Hint**
> - Gunakan fungsi .split() untuk memisahkan tanggal, bulan, dan tahun lahir.
> - Gunakan casting untuk memasukkan ASCII huruf dalam rumus.

### **Contoh Input dan Output**
Berikut ini adalah contoh interaksi program yang mungkin terjadi (yang dicetak tebal adalah masukan):
<pre>PROGRAM PENCETAK DATA SENSUS
--------------------
Nama Kepala Keluarga           : <b>master Shifu</b>
Alamat Rumah                   : <b>Ninja</b>
Panjang Tubuh (cm)             : <b>36</b>
Lebar Tubuh (cm)               : <b>71</b>
Tinggi Tubuh (cm)              : <b>189</b>
Berat Tubuh (kg)               : <b>68.5</b>
Jumlah Anggota Keluarga        : <b>7</b>
Tanggal Lahir                  : <b>12-03-1971</b>
Catatan Tambahan               : <b></b>
Jumlah Cetakan Data            : <b>2</b>

Pencetakan 1 dari 2 untuk: <b>komunitas lingkungan hidup Fasilkom</b>
DATA SIAP DICETAK UNTUK KOMUNITAS LINGKUNGAN HIDUP FASILKOM
--------------------
master Shifu - Ninja
Lahir pada tanggal 12-03-1971
Rasio Berat Per Volume     = 141 kg/m^3
Tidak ada catatan tambahan

Pencetakan 2 dari 2 untuk: <b>Arsip pemerintah kabupaten Fasilkom</b>
DATA SIAP DICETAK UNTUK ARSIP PEMERINTAH KABUPATEN FASILKOM
--------------------
master Shifu - Ninja
Lahir pada tanggal 12-03-1971
Rasio Berat Per Volume     = 141 kg/m^3
Tidak ada catatan tambahan

REKOMENDASI APARTEMEN
--------------------
MENGETAHUI: Identitas keluarga: master Shifu - m4279
MENIMBANG:  Anggaran makanan tahunan: Rp 127750000
			Umur kepala keluarga: 47 tahun
MEMUTUSKAN: keluarga master Shifu akan ditempatkan di:
Mares, kabupaten Margonda
</pre>

Berikut ini adalah contoh jika masukan tidak memenuhi validasi (yang dicetak tebal adalah masukan):
<pre>PROGRAM PENCETAK DATA SENSUS
--------------------
Nama Kepala Keluarga           : <b>Esta</b>
Alamat Rumah                   : <b>Parbel</b>
Panjang Tubuh (cm)             : <b>45</b>
Lebar Tubuh (cm)               : <b>64</b>
Tinggi Tubuh (cm)              : <b>288</b>
WARNING: Keluarga ini tidak perlu direlokasi!
</pre>

## Checklist
Isi kurung siku komponen dengan x untuk menceklis komponen.
### Komponen Wajib | 100 Poin
- [ ] **Meminta masukan dari user**
- [ ] **Hitung rasio berat per volume**
- [ ] **Cetak data sesuai dengan format yang ditentukan**

### Komponen Bonus | 10 Poin
- [ ] **Validasi masukan**
- [ ] ***Generate* nomor pengenal keluarga**
- [ ] **Hitung anggaran makanan per tahun**
- [ ] **Hitung umur kepala keluarga**
- [ ] **Mengelompokkan keluarga ke apartemen**
- [ ] **Cetak rekomendasi sesuai dengan format yang ditentukan**