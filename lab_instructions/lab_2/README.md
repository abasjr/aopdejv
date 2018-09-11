# Lab 2 : Expression, Operators, dan Decision
Dasar-dasar Pemrograman 2 - CSGE601021 | Fakultas Ilmu Komputer, Universitas Indonesia, Semester Gasal 2018/2019

**Dibuat oleh: AR, dimodifikasi dari Tutorial DDP2 2017**

* * *

Pada tutorial sebelumnya, Anda telah mempelajari mengenai beberapa perbedaan syntax antara bahasa pemrograman Java dan Python. Anda juga telah mempelajari version control system yaitu Git. Kali ini, Anda akan mempelajari lebih dalam konsep pemrograman dalam bahasa pemrograman Java.

## **Tujuan Pembelajaran**
1. Memahami konsep **tipe data** dalam Java (tipe data primitif, tipe data reference, dan casting).
2. Memahami **control flow** dalam Java (conditionals, iteratives, branching statements).
3. Memahami konsep dasar **String** dan operasi String.
4. Memahami dasar-dasar **_Input_ dan _Output_** dalam Java (Scanner, System.out, parsing).

### **Before You Start...**
1. Lakukan `git pull upstream master` dengan menggunakan Command Prompt pada folder repository lokal Anda.
2. Anda dapat mengimplementasikan source code java tutorial 2 pada folder `ddp-lab/lab_2/src/main/java`.
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
Looping akan dibahas pada Lab 3.

#### 3. **Branching Statement**
Branching Statement akan dibahas pada Lab 3.

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

## **Chapter 2: "Kalkulator Syantik"**
### **What's the story?**
Pak Iqbal memiliki seorang istri bernama Bu Nurrani yang merupakan seorang pedagang sembako di Pasar TokTik. Setiap harinya lapak Bu Nurrani dipenuhi oleh pembeli, mulai dari pembeli dalam negeri sampai mancanegara. Dalam melayani pembeli, Bu Nurrani dibekali oleh suaminya sebuah alat canggih bernama Kalkulator Syantik. Alat ini dibuat sendiri oleh Pak Iqbal.

Suatu hari, Kalkulator Syantik milik Bu Nurrani rusak. Hal ini mengakibatkan Bu Nurrani kesulitan dalam berjualan sembako. Kemudian, Bu Nurrani meminta kepada Pak Iqbal untuk membuatkan lagi Kalkulator Syantik. Namun karena Pak Iqbal sedang sibuk konser keliling Wakanda, dia tidak dapat membuatkan Kalkulator Syantik untuk Bu Nurrani. Lalu Pak Iqbal meminta bantuan anda sebagai seorang Java Programmer untuk membuatkan Kalkulator Syantik untuk Bu Nurrani.

Pak Iqbal lalu menuliskan spesifikasi dari Kalkulator Syantik supaya anda tidak tersesat dan tak tau arah jalan pulang dalam pengerjaan alat ini. Spesifikasi Kalkulator Syantik sebagai berikut :
> - Nama _class_ : `Kalkulator`.
> - Kalkulator Syantik membutuhkan input 3 buah data **(2 buah angka dan 1 buah simbol operator)**.
> - 3 buah data tersebut diinput dalam 1 baris dengan format `angka1 <spasi> operator <spasi> angka2`.
> - Buat method `hitung(int angka1, String operator, int angka2)` yang digunakan untuk menghitung hasil dari operasi yang diiput.
> - Method `hitung(int angka1, String operator, int angka2)` merupakan `static` method.
> - Ketika dipanggil, method `hitung(int angka1, String operator, int angka2)` akan mengembalikan sebuah nilai bertipe data `int` yang merupakan hasil dari perhitungan.
> - Operasi yang harus ada :
> 	- Penjumlahan dengan simbol `+`.
> 	- Pengurangan dengan simbol `-`.
> 	- Perkalian dengan simbol `*`.
> 	- Pembagian dengan simbol `/`.
> 	- Modulo dengan simbol `%`.
> 	- Pemangkatan dengan simbol `^`.
> 	- Pengakaran dengan simbol `v`.
> - Khusus untuk operasi Pengakaran (`v`), `angka2` hanya memiliki nilai `2` atau `3`.

### **A little trigger?**
Sebelum kamu mengerjakan soal tutorial ini, ada baiknya kamu membaca penjelasan materi yang diberikan sebelumnya, lalu jawab pertanyaan berikut ini sebagai "pemanasan" sebelum mengerjakan tutorial :D

> **Ingat kembali!**
> - Bagaimana kita membuat program yang dapat menerima input dari user?
> - Bagaimana mengubah input masukan yang berupa String menjadi tipe data tertentu?
> - Method apa saja yang dapat digunakan untuk memanipulasi data dengan tipe data String ?
> - Sebutkan tipe-tipe data yang kamu ketahui! Jelaskan penggunaan tipe data tersebut!
> - Apa itu keyword ‘static’? Jelaskan apa yang dimaksud dengan ‘static method’!
> - Bagaimana cara membuat program agar dapat mencetak output?

### **What you need to do**
- [ ] Masukkan 3 buah data **(2 buah angka dan 1 buah simbol operator)** pada 1 baris dengan urutan `angka1, operator, angka2`.
- [ ] Pisahkan 3 data yang telah diinput.
- [ ] Panggil method `hitung(int angka1, String operator, int angka2)`.
- [ ] Tampilkan hasil perhitungan.

### **Contoh Input dan Output**
Berikut ini adalah contoh interaksi program (yang dicetak tebal adalah masukan):
<pre>KALKULATOR SYANTIK
--------------------
Masukkan Input           : <b>2 + 4</b>
Hasil Perhitungan	 : 6

</pre>

Berikut ini adalah contoh lain interaksi program yang mungkin terjadi  (yang dicetak tebal adalah masukan):
<pre>KALKULATOR SYANTIK
--------------------
Masukkan Input           : <b>7 - 4</b>
Hasil Perhitungan	 : 3

</pre>

Berikut ini adalah contoh lain interaksi program yang mungkin terjadi  (yang dicetak tebal adalah masukan):
<pre>KALKULATOR SYANTIK
--------------------
Masukkan Input           : <b>7 ^ 2</b>
Hasil Perhitungan	 : 49

</pre>

Berikut ini adalah contoh lain interaksi program yang mungkin terjadi  (yang dicetak tebal adalah masukan):
<pre>KALKULATOR SYANTIK
--------------------
Masukkan Input           : <b>7 / 2</b>
Hasil Perhitungan	 : 3

</pre>

Berikut ini adalah contoh lain interaksi program yang mungkin terjadi  (yang dicetak tebal adalah masukan):
<pre>KALKULATOR SYANTIK
--------------------
Masukkan Input           : <b>8 v 3</b>
Hasil Perhitungan	 : 2

</pre>

## Checklist
### Komponen Wajib | 100 Poin
- [ ] **Meminta input dari user**
- [ ] **Hanya membuat 1 buah method `hitung(int angka1, String operator, int angka2)`**
- [ ] **Sediakan semua operasi yang diminta Pak Iqbal**
- [ ] **Tampilkan hasil perhitungan dengan benar**

## **Komponen Bonus | 10 Poin**
_Belum ada bonus yaa hehe :)_