# Lab 5 : Array dan ArrayList

Dasar-dasar Pemrograman 2 - CSGE601021 | Fakultas Ilmu Komputer, Universitas Indonesia, Semester Gasal 2018/2019

**Dibuat oleh: AFAI diadaptasi dari Lab DDP2 2017**

* * *

## Tujuan Pembelajaran
1. Memahami penggunaan **Array** dalam Java.
2. Memahami penggunaan **Array List** dalam Java.
3. Memahami perbedaan Array dan Array List dalam Java.

### Before You Start...
**Jika Memiliki Akses ke Repository Lokal (Misal: Membawa Laptop Sendiri)**
1. Lakukan `git pull upstream master` dengan menggunakan Command Prompt pada folder repository lokal Anda.

**Jika Tidak Memiliki Akses ke Repository Lokal (Misal: Menggunakan Komputer Lab)**
1. Lakukan `git clone <link-repository-Anda>` dengan menggunakan Command Prompt untuk menginisiasi repository lokal berdasarkan
   repository online Anda.  
2. Arahkan Command Prompt ke folder repository lokal yang baru saja diinisiasi.
3. Lakukan `git remote add upstream <link-repository-DDP2>`
4. Lakukan `git pull upstream master`

## **Materi Tutorial**

### **Array**
**Array** adalah struktur data paling sederhana yang disediakan oleh bahasa pemrograman Java. Secara informal, array **array** adalah sebuah kumpulan n buah data dengan tipe data yang sama​. Selanjutnya, dapat dikatakan bahwa array **array** memiliki panjang n​. Sederhana, bukan?.  Tipe data yang bisa menggunakan Array adalah **primitive** dan **refference/object**. 

**Array bersifat fixed-size** yang berarti panjang sebuah array tidak dapat diubah setelah array tersebut diinstansiasi. Sebuah array dapat diidentifikasi dengan simbol “[]”. Elemen-elemen pada array dapat diakses berdasarkan index/posisi elemen tersebut. Sebagai contoh, array[i] akan mengembalikan elemen dengan index i​ pada array *array*​, tentu saja dengan i < n​, index pada array dimulai dari 0. 

**Array** juga dapat berupa **Array Multidimensi**, yang berarti tiap elemennya merupakan sebuah array juga.

Untuk mengetahui lebih lanjut tentang **array** bisa lihat [disini](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)

### **Ayo coba tebak hasil dari setiap code dibawah ini untuk menambah pemahaman kamu!!**

**Latihan 1**
```java
class Latihan1{
    public static void main(String[] args){
      int[] numbers = new int[10]; // menginisiasi array of int dengan panjang 10 
      System.out.println(numbers[5]); // menampilkan ... , karena ...
    }
}
```

**Latihan 2**
```java
class Latihan2{
    public static void main(String[] args){
      String[] strList = new String[5];//...
      System.out.println(strList[0]);// menampilkan ... , karena ....
    }
}
```

**Latihan 3**
```java
class Latihan3{
    public static void main(String[] args){
      int[] primes = {2,3,5,7,11}; //menginisiasi array of int dengan initial values 
      System.out.println(primes[2]);// menampilkan ...
    }
}
```

**Latihan 4**
```java
class Latihan4{
    public static void main(String[] args){
        String[] animals = {"cat","bird","tiger"}; // ...
        System.out.println(animals[1]); // menampilkan ...
        animals[0] = "fish"; //mengganti elemen index ke 0
        System.out.println(animals[1]); // menampilkan ...
    }
}


```

**Latihan 5**
```java
class Latihan5{
    public static void main(String[] args){
      String str  = "a b c d";
      String[] splitstr = str.split(" "); //menginisiasi array of String dari method split
      System.out.println(splitstr[3]);// menampilkan ...
      splitstr[3] = "new"; //...
    }
}

```
**Latihan 6**
```java
class Latihan6{
    public static void main(String[] args){ 
        int[][] points = new int[4][4];     // array of int 2 dimensi dengan panjang 4, dan lebar 4 seperti papan catur
        // System.out.println(points[0][0]);  //....
        points[0][1] = 5;  //...
        points[1] = new int[2]; //...
        points[2] = {1,2,3};    //...
        Int[] sesuatu = {1,2,3};  //....
        // System.out.println(points[0][5]); //...
     }
}



```

### **ArrayList**
**ArrayList** sederhananya merupakan array yang dinamik, berbeda dengan array, ukuran ArrayList dapat berkembang sesuai kebutuhan, dan elemen-elemen yang disimpan ArrayList harus bertipe reference.

Untuk mengetahui lebih lanjut tentang **array list** bisa lihat [disini](https://www.tutorialspoint.com/java/java_arraylist_class.htm)

### **Ayo cari tahu apa yang dilakukan code dibawah ini untuk menambah pemahaman kamu!!**

```java
import java.util.ArrayList;
public class Test {
    public static void main(String[] args){
    	ArrayList<Integer> numbers = new ArrayList<Integer>(); // menginisiasi arraylist of integer

    	//.......
    	numbers.add(3); 
		numbers.add(2);
		numbers.add(4);
		numbers.add(5);
		numbers.add(7);


		numbers.size(); //...
		numbers.get(0); //...
		numbers.set(0, 1); //....


		numbers.remove(1); //....

	}
}
```

## **Soal Tutorial : "Manajemen Rak"**

### **What's the story?**
Setelah sampai dirumah, Amir bergegas untuk memberi makan kucingnya. Dengan terburu-buru dan diiringin suara kucing
kelaparan, Amir mencari-cari tempat makan kucing yang ia simpan di rak. Ia pun mengacak-ngacak rak tersebut hingga
akhirnya berhasil menemukan tempat makan kucing yang ia cari. Kejadian tersebut memberikan sebuah ide bagi Amir,
bagaimana jika ia membuat sebuah sistem yang mendaftarkan barang-barang di raknya, sehingga ia tidak perlu mengacak-ngacak
rak untuk mencari barang di lain waktu. Ia segera memberi tahu kepada Anda mengenai ide tersebut sebelum ide tersebut 
menghilang dari kepalanya. Anda yang merasa tertantang pun mencoba untuk membuat sistem tersebut. 

### **Spesifikasi Class**

Nama file kamu **wajib** Rak.java

**Wajib** menggunakan Array dan **tidak boleh** menggunakan Array List

> Rak adalah sebuah array  
> Nomor rak adalah indeks pada array

#### Implementasikan Fungsi:

- cekBarang(String namaBarang)  
  Fungsi ini menerima argumen nama barang yang ingin di cek, mengembalikan true jika barang terdapat di rak, 
  dan false jika barang tidak ada di rak.

- cariBarang(String namaBarang)   
  Fungsi ini menerima argumen nama barang yang dicari, mengembalikan nomor rak tempat barang tersebut berada.
  Jika barang tidak ditemukan, kembalikan -1.

- simpanBarang(String namaBarang, int nomorRak)  
  Fungsi ini menyimpang barang ke dalam lemari berdasarkan nomor rak yang diminta. Apabila rak dengan nomor yang
  diminta sudah berisi barang lainnya, maka gagal menyimpan ke dalam rak, kembalikan false. Apabila rak dengan nomor
  yang diminta masih kosong, simpan barang ke rak sesuai nomor yang diminta, kembalikan true.
  
- ambilBarang(int nomorRak)  
  Fungsi ini mengambil barang yang terletak di rak sesuai dengan nomor yang diminta. Apabila terdapat barang pada
  rak kembalikan namaBarang. Apabila rak kosong, kembalikan "Rak kosong". Rak dengan nomor rak dikosongkan setelah 
  barang diambil.
  
- pindahBarang(String namaBarang, int tempatAwal, int tempatPindah)  
  Fungsi ini memindahkan namaBarang dari nomor rak tempatAwal ke nomor rak tempatPindah. Apabila nomor rak tempatPindah
  tidak berisi barang apapun, maka namaBarang dipindahkan dari tempatAwal ke tempatPindah. Jika nomor rak tempatPindah berisi
  suatu barang, maka barang dari nomor rak tempatAwal dipindahkan ke nomor rak tempatPindah dan barang dari nomor rak
  tempatPindah dipindahkan ke nomor rak tempatAwal.

#### Catatan : 

- Nama barang unik, tidak ada dua barang dengan nama yang sama di nomor rak berbeda
- Nomor rak yang diinputkan valid (tidak perlu mengecek index out of bound)
- namaBarang pada fungsi pindahBarang dijamin ada di tempatAwal
- template tersedia di [`template`][template]

#### Flow Program

Program akan berjalan terus menerus hingga menerima input "EXIT"  

1. INISIASI_RAK `<PANJANGRAK>`  
   Menginisiasi rak dengan panjang `<PANJANGRAK>`. Sudah tersedia di template.

1. CEK_BARANG `<NAMABARANG>`  
   Output adalah "Barang tersedia" jika barang terdapat di rak, dan "Barang tidak tersedia" jika barang tidak ada
   di rak.
   
2. CARI_BARANG `<NAMABARANG>`  
   Output adalah "Barang teletak pada `<nomorRak>`" jika barang ditemukan. Jika barang tidak ditemukan, output adalah
   "Barang tidak ditemukan".

3. SIMPAN_BARANG `<NAMABARANG>` `<NOMORRAK>`  
   Output adalah "`<NAMABARANG>` berhasil disimpan di `<NOMORRAK>`" jika berhasil menyimpan barang. Jika gagal, output
   adalah "Gagal menyimpan `<NAMABARANG>`".
   
4. AMBIL_BARANG `<NOMORRAK>`  
   Output adalah "Berhasil mengambil `<namaBarang>`" jika berhasil mengambil barang. Jika gagal, output adalah
   "Rak kosong". 
   
5. PINDAH_BARANG `<NAMABARANG>` `<TEMPATAWAL>` `<TEMPATAKHIR>`  
   Output adalah "Pemindahan Berhasil, rak nomor `<TEMPATAKHIR>` berisi `<NAMABARANG>` dan rak nomor `<TEMPATAWAL>`
   berisi `<namaBarangLain>`". nama barang lain adalah barang yang terdapat di tempat awal setelah pemindahan barang
   berhasil, jika tempat awal tidak ada isinya, namaBarangLain = "null"     

### Simulasi Program

**Output** dicetak tebal

<pre>
INISIASI_RAK 10
CEK_BARANG PIRING_KUCING
<b>Barang tidak tersedia</b>
CARI_BARANG PIRING_KUCING
<b>Barang tidak ditemukan</b>
SIMPAN_BARANG PIRING_KUCING 0
<b>PIRING_KUCING berhasil disimpan di 0</b>
SIMPAN_BARANG MAKANAN_KUCING 0
<b>Gagal menyimpan MAKANAN_KUCING</b>
CEK_BARANG PIRING_KUCING
<b>Barang tersedia</b>
CARI_BARANG PIRING_KUCING
<b>Barang terletak pada 0</b>
AMBIL_BARANG 0
<b>Berhasil mengambil PIRING_KUCING</b>
AMBIL_BARANG 0
<b>Rak kosong</b>
SIMPAN_BARANG PIRING_KUCING 0
<b>PIRING_KUCING berhasil disimpan di 0</b>
SIMPAN_BARANG MAKANAN_KUCING 5
<b>MAKANAN_KUCING berhasil disimpan di 5</b>
PINDAH_BARANG PIRING_KUCING 0 5
<b>Pemindahan Berhasil, rak nomor 5 berisi PIRING_KUCING dan rak nomor 0 berisi MAKANAN_KUCING</b>
PINDAH_BARANG PIRING_KUCING 5 7
<b>Pemindahan Berhasil, rak nomor 7 berisi PIRING_KUCING dan rak nomor 5 berisi null</b>
EXIT
</pre>


### Daftar Input Pada Simulasi Program

<pre>
INISIASI_RAK 10
CEK_BARANG PIRING_KUCING
CARI_BARANG PIRING_KUCING
SIMPAN_BARANG PIRING_KUCING 0
SIMPAN_BARANG MAKANAN_KUCING 0
CEK_BARANG PIRING_KUCING
CARI_BARANG PIRING_KUCING
AMBIL_BARANG 0
AMBIL_BARANG 0
SIMPAN_BARANG PIRING_KUCING 0
SIMPAN_BARANG MAKANAN_KUCING 5
PINDAH_BARANG PIRING_KUCING 0 5
PINDAH_BARANG PIRING_KUCING 5 7
EXIT
</pre>

## Soal Bonus : Gabung Rak

- Fungsi gabungRak(String[] rak1, String[] rak2)
  Fungsi ini mengembalikan sebuah rak hasil dari gabungan rak1 dengan rak2.
  ```java
  String[] rak1 = new String[]{"Buku", "Tulis"};
  String[] rak2 = new String[]{"Kotak", "Pensil"};
  Rak rak = new Rak();
  String[] rak3 = rak.gabungRak(rak1, rak2);
  ```
  
  Maka rak3 akan memiliki isi dan panjang yang sama dengan rak4 pada kode berikut
  ```java
  String[] rak4 = new String[]{"Buku", "Tulis", "Kotak", "Pensil"}
  ```
## Checklist
### Komponen Wajib | 100 Poin
- [ ] Mengimplementasikan semua fungsi yang diminta

### Komponen Bonus | 10 Poin
- [ ] Membuat fungsi gabungRak(String[] rak1, String[] rak2)


-----
### **Woah, apa ini !?**

Ketika anda meng-push hasil kerja anda, anda akan sadar bahwa ada logo cross merah atau centang hijau di samping hasil kerja anda.

![alt text](https://i.imgur.com/ZNfetmP.png "Ilustrasi git 1")

Kenapa kita menggunakan git ? Salah satu keuntungan dari menggunakan git adalah kita bisa menggunakan fitur Continuos Integration?

Apa itu Continuous Integration? Continuos Integration adalah konsep di mana ketika anda push, hasil push anda langsung di build (compile) dan di test (uji langsung). Jika gagal, anda akan diberitahu.

Bagian Build baru akan dijelaskan di mata kuliah Advanced Programming. Anda hanya perlu mengetahui bagian test.

Sistem yang digunakan untuk mengetest di Java bernama JUnit. Kita bisa menggunakan framework JUnit untuk mengetes secara langsung (tanpa harus print di command line). Untuk sekarang, anda tidak perlu tahu cara kerja JUnit.

Kamu dapat memeriksa hasil kerja Junit di tab Commit. Tekan logo centang hijau atau cross merah untuk memeriksa detail lebih lanjut.

![alt text](https://i.imgur.com/E23AOfl.png "Ilustrasi commit")

Ketika kamu menekan logo tersebut, kamu akan memeriksa rangkuman dari tes tersebut yang memiliki dua lingkaran.

Jika lingkaran pertama cross, maka program kamu gagal karena compile error.
Jika lingkaran pertama centang hijau tetapi lingkaran kedua cross, maka program kamu tidak akurat.
Jika kedua lingkaran centang, berati program kamu sudah baik.

![alt text](https://i.imgur.com/1ElduFi.png "Ilustrasi status")

Kamu dapat menekan tombol cross merah atau centang hijau untuk melihat hasil lebih lanjut. Sebagai contoh, jika kalain mendapat cross merah di lingkaran kedua, kamu dapat menemkan cross merah kedua untuk melihat test case mana program anda tidak akurat.

[template]: https://gitlab.com/DDP2-Ekstensi-CSUI/ddp-lab/blob/master/lab_5/src/main/java/Rak.java