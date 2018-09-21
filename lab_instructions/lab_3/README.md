# Lab 2 : Iteration
Dasar-dasar Pemrograman 2 - CSGE601021 | Fakultas Ilmu Komputer, Universitas Indonesia, Semester Gasal 2018/2019

**Dibuat oleh: AFAI**

* * *

## **Tujuan Pembelajaran**
1. Memahami konsep **iteration** dalam Java.
2. Memahami penggunaan **for loop** dalam Java.
3. Memahami penggunaan **while loop** dalam Java.
4. Memahami penggunaan **do loop** dalam Java

### **Before You Start...**
**Jika Memiliki Akses ke Repository Lokal (Misal: Membawa Laptop Sendiri)**
1. Lakukan `git pull upstream master` dengan menggunakan Command Prompt pada folder repository lokal Anda.
2. Anda dapat mengimplementasikan source code java tutorial 3 pada folder `ddp-lab/lab_3/src/main/java`.
3. Implementasikan kode Anda sesuai apa yang diminta soal tutorial dan lab.
4. Setelah selesai mengimplementasikan kode tersebut, lakukan add, commit, dan push code kalian tersebut.

**Jika Tidak Memiliki Akses ke Repository Lokal (Misal: Menggunakan Komputer Lab)**
1. Lakukan `git clone <link-repository-Anda>` dengan menggunakan Command Prompt untuk menginisiasi repository lokal berdasarkan
   repository online Anda.  
2. Arahkan Command Prompt ke folder repository lokal yang baru saja diinisiasi.
3. Lakukan `git remote add upstream <link-repository-DDP2>`
4. Lakukan `git pull upstream master`

## **Materi Tutorial**
### **Iteration**
Iteration (perulangan) adalah salah satu bentuk kontrol pemrograman yang umum digunakan. Iteration memungkinkan kita 
untuk melakukan eksekusi perintah secara berulang selama kondisi tertentu terpenuhi. Dalam Java, terdapat tiga macam 
perintah utama untuk melakukan perulangan, yaitu for loop, while loop, dan do loop.

#### While Loop
While loop merupakan perintah iterasi yang umumnya digunakan untuk mengeksekusi sekumpulan perintah berulang kali hingga
suatu tujuan tercapai.

*Syntax:*
```
while (condition) {
    statements
}
```

Misal Anda ingin membuat suatu program untuk mensimulasikan pembelahan diri pada bakteri.
Bakteri A akan membelah diri menjadi dua setiap satu jam, Anda ingin menghitung berapa jumlah jam
yang diperlukan satu bakteri A agar berkembang biak menjadi 2147483648 bakteri.

Berdasarkan deskripsi soal tersebut, kita dapat mengambil beberapa bagian penting, yaitu :
- Kondisi : Selama jumlah bakteri kurang dari 2147483648
- Statement : Jumlah bakteri dikali 2 setiap kali iterasi, jumlah jam ditambah 1 setiap iterasi

Berikut adalah contoh program untuk menyelesaikan kasus tersebut:
```java
class Bakteri{

    public static int hitungJam(){
        int jumlahBakteri = 1;
        int jumlahJam = 0;
        while (jumlahBakteri < 1073741824) {
            jumlahBakteri *= 2;
            jumlahJam++;
        }
        return jumlahJam;
    }

    public static void main(String[] args){
        System.out.printf("Jumlah jam yang diperlukan adalah : %s\n", Bakteri.hitungJam());
    }
}
```

#### For Loop
For loop merupakan perintah perulangan yang umum digunakan ketika kita ingin mengeksekusi perintah dalam jumlah
tertentu. 

*Syntax:*
```
for (inisialisasi; kondisi; update) {
    statement;
}
```

Misal Anda ingin membuat suatu program untuk mensimulasikan pembelahan diri pada bakteri.
Bakteri A akan membelah diri menjadi dua setiap satu jam, Anda ingin menghitung berapa jumlah bakteri A
setiap jamnya, selama 30 jam.

Berikut adalah contoh program untuk menyelesaikan kasus tersebut:
```java
class Bakteri{

    public static void hitungBakteriPerJam(){
        int jumlahBakteri = 1;
        for (int jam = 1; jam <= 30; jam++){
            jumlahBakteri*=2;
            System.out.printf("Bakteri pada jam ke %s berjumlah %s\n", jam, jumlahBakteri);
        }
    }

    public static void main(String[] args){
        hitungBakteriPerJam();
    }
}
```

Bagaimana jika Anda diminta untuk menyelesaikannya menggunakan while loop ? Silakan coba diimplementasikan penyelesaian
kasus tersebut menggunakan while loop.

#### Do Loop
Do Loop merupakan perintah perulangan yang umum digunakan ketika kita ingin mengeksekusi suatu perintah setidaknya sekali,
kemudian melakukan pengecekan.

*Syntax:*
```
do {
statements
}
while (condition);
```

Misal Anda ingin membuat suatu program untuk mensimulasikan pembelahan diri pada bakteri.
Bakteri A akan membelah diri menjadi dua setiap satu jam, Anda ingin meminta user memasukkan suatu angka x dalam rentang 
1-30 dan mencetak jumlah perkembangan bakteri A pada jam ke x.

```java
import  java.util.Scanner;
class Bakteri{
    
    public static int bakteriSaatJam(int jam){
        return (int)Math.pow(2, jam);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int jam;
        do {
            jam = scanner.nextInt();
        } while (jam>30 || jam <1);
        System.out.printf("Bakteri saat jam ke %s adalah %s\n", jam, bakteriSaatJam(jam));
    }
}
```

#### Nested Loop
Nested loop adalah loop lain didalam statement dari suatu loop. Dalam program yang kompleks terkadang
kita memerlukan Nested Loop. 

Misal Anda ingin mensimulasikan perkembangan hidup bakteri yang  membelah diri `tiap satu jam`. 
Kali ini Anda memiliki `10 bakteri yang berbeda jenis`, dengan bakteri jenis pertama membelah diri menjadi dua, 
bakteri jenis kedua membelah diri menjadi tiga, dan seterusnya hingga bakteri jenis kesepuluh membelah diri menjadi sebelas.
Anda ingin mengetahui jumlah bakteri pada setiap jenis dari `jam pertama hingga jam ke lima`. Anda akan mencetak
jumlah pada setiap jenis bakteri setiap jamnya dalam bentuk tabel, baris mewakili jenis bakteri dan kolom mewakili
jam (Misal: Baris ke 1 kolom 2 berisi jumlah bakteri pada kelompok 1 pada jam ke 2). Jumlah awal dari masing-masing jenis
bakteri adalah 1(saat jam ke 0).

Berikut adalah contoh program untuk menyelesaikan kasus tersebut:

```java
class Bakteri{

    public static void kelompokBakteri(){
        for (int kelompok=1; kelompok<=10; kelompok++){
            int jumlah=1;
            int kemampuanMembelah = kelompok+1;
            for (int jam=1; jam<=5; jam++){
                jumlah*=kemampuanMembelah;
                System.out.printf("%s ",jumlah);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args){
        kelompokBakteri();
    }
}
```

#### Mengurai String dengan Loop
Misal kita ingin mengambil setiap karakter pada sebuah string dan mencetaknya satu persatu, salah satu pendekatan yang 
mungkin kita lakukan untuk melakukan hal tersebut adalah melakukan looping mengikuti indeks string tersebut dengan for loop
kemudian mengambil karakter menggunakan indeks.

```java
class ForLoop{

    public static void ambilKarakterForLoop(String iniString){
        for (int i = 0; i<iniString.length(); i++){
            System.out.println(iniString.charAt(i));
        }
    }

    public static void main(String[] args){
        ambilKarakterForLoop("AKU ADALAH AKU");
    }
}
```

Lalu bagaimana dengan pendekatan lainnya ?
Bagaimana jika kita ingin memanipulasi string, bukan hanya mengaksesnya?

## Chapter 3: Pesan Rahasia
### What's the story?

Setelah meninggalkan catatan mengenai class Kucing, Amir bersiap untuk membeli makanan kucing-kucing kesayangannya. 
Ia langsung menuju garasi, mengeluarkan motornya dan tancap gas menuju pet shop. Di tengah perjalanan, Amir merasakan
ada hal yang aneh dengan motornya, entah kenapa motornya semakin lama semakin pelan padahal dia menarik gasnya secara konstan.
Ternyata, motornya telah kehabisan bensin, ia tidak sadar karena terlalu fokus melihat jalanan. Ia segera meminggirkan
motornya, dan menuntun motornya menuju pom bensin terdekat (sepertinya kucing-kucingnya harus menunggu lebih lama lagi).
Amir yang sedang menuntun motor secara tidak sengaja menemukan selembar kertas yang menarik perhatiannya, tidak ada hal
khusus pada kertas tersebut, namun instingnya berkata bahwa ia harus mengambil kertas tersebut.

Setelah mengambil kertas tersebut, ia membacanya dan mendapati bahwa kertas tersebut berisi sebuah pesan yang di
encode dengan algoritma tertentu, ia sangat yakin bahwa pesan itu adalah sebuah pesan rahasia. Untungnya, dibalik 
kertas tersebut terdapat cara untuk mendecode pesan tersebut (Jadi masih bisakah disebut pesan rahasia ?). Karena
Amir sedang sibuk menuntun motor, ia pun mengirimkan foto kertas tersebut dan meminta bantuan pada Anda untuk membuatkan
program yang menerjemahkan isi pesan tersebut.

Algoritma yang tersedia hanya dapat digunakan untuk menerjemahkan baris per baris, tidak bisa satu pesan sekaligus.
Berikut adalah cara untuk menerjemahkan suatu baris dari pesan tersebut:

- Anggap setiap baris pada pesan tersebut adalah sebuah string yang dimulai dengan indeks 0
- Ambil setiap karakter berindeks genap pada baris pesan tersebut, susunlah menjadi sebuah kalimat baru, misal kalimat `X`  
  
  Baris pada pesan : 
  ```JAHSHCMFNDMAVE FZBMSXAAZCXUCEE FRGTTFZASVBUNZZ EFFYJKKALKI OLLIHKJAMMH DKAUDSFAVLRZV DHFERYTAFAVAR```
  Kalimat X: 
  ```JHHMNMV ZMXACUE RTFAVUZ FYKAK LIKAM KUSALZ HEYAAA```
  
- Kemudian lakukan pengecekan karakter pada kalimat `X`, abaikan isi kalimat `X` setelah kemunculan huruf `A` yang ketiga
  kalinya. Ambil bagian kalimat `X` yang `tidak diabaikan` dan buat menjadi kalimat baru, misal kalimat `Y`  
  
  Kalimat X: 
  ```JHHMNMV ZMXACUE RTFAVUZ FYKAK LIKAM KUSALZ HEYAAA```
  Kalimat Y: 
  ```JHHMNMV ZMXACUE RTFAVUZ FYKA```
  
- Terakhir, ambil setiap karakter berindeks ganjil pada kalimat `Y`, susunlah menjadi kalimat baru, kalimat tersebut
  adalah isi dari baris pesan tersebut.
  
  Isi sebenarnya pada baris pesan: 
  ```HMM MAU TAU YA```
    
**Isi Pesan**:
```
JAHSHCMFNDMAVE FZBMSXAAZCXUCEE FRGTTFZASVBUNZZ EFFYJKKALKI OLLIHKJAMMH DKAUDSFAVLRZV DHFERYTAFAVAR
BSCDNCOVMSBFDDAAFF GGETTHYEUYGBDRCASTAKFUV CIDYEOFAA FJDECNEGDDCEERDECNEGDDCEANSGB GKDREEFNGGA
VDKFBEAFNDMEHFUSTC SYCHDUCESTCBSRCAEEFTSSD CDEJFFSUDGFGSFDACDS DSEEFMSASNSGSASTS SFSSSDSCSASSSES SFSFSFSASSSSS
FDSCGSEDHELFJAASKDMCKEAFLDTCOS CODYDICAC DFCFCDD
```

### A little trigger?
Sebelum kamu mengerjakan soal tutorial ini, ada baiknya kamu membaca penjelasan materi yang diberikan sebelumnya, lalu jawab pertanyaan berikut ini sebagai "pemanasan" sebelum mengerjakan tutorial :D

> **Ingat kembali!**
> - Kapan sebaiknya kita menggunakan for loop ?
> - Kapan sebaiknya kita menggunakan while loop ?
> - Loop berjalan selama ...

### **What you need to do**
- [ ] Buka file lab_3/src/main/java/PesanRahasia.java (**Ada Template Yeaaay**)
- [ ] Implementasikan fungsi `decode(String pesan)` agar bisa mengembalikan terjemahan pesan

### **Contoh Input dan Output**

Berikut ini adalah contoh interaksi program (yang dicetak tebal adalah masukan):
<pre>
Masukkan Pesan      : <b>JAHSHCMFNDMAVE FZBMSXAAZCXUCEE FRGTTFZASVBUNZZ EFFYJKKALKI OLLIHKJAMMH DKAUDSFAVLRZV DHFERYTAFAVAR</b>
Isi Sebenarnya      : <b>HMM MAU TAU YA</b>
</pre>

Berikut ini adalah contoh lain interaksi program (yang dicetak tebal adalah masukan):
<pre>
Masukkan Pesan      : <b>BSCDNCOVMSBFDDAAFF GGETTHYEUYGBDRCASTAKFUV CIDYEOFAA FJDECNEGDDCEERDECNEGDDCEANSGB GKDREEFNGGA</b>
Isi Sebenarnya      : <b>COBA TEBAK YA</b>
</pre>

## BONUS
Sekarang Anda sudah dapat membuat program untuk menerjemahkan pesan rahasia yang diberikan oleh Amir. Namun, Anda
merasa program yang Anda miliki kurang efisien karena hanya bisa menerima satu kali input setiap program dijalankan.
Akhirnya, Anda memutuskan untuk memodifikasi program Anda agar dapat menerima input berulang-kali hingga menerima
iput `EXIT`.

### **Contoh Input dan Output Bonus**

Berikut ini adalah contoh interaksi program (yang dicetak tebal adalah masukan):
<pre>
Masukkan Pesan      : <b>JAHSHCMFNDMAVE FZBMSXAAZCXUCEE FRGTTFZASVBUNZZ EFFYJKKALKI OLLIHKJAMMH DKAUDSFAVLRZV DHFERYTAFAVAR</b>
Isi Sebenarnya      : <b>HMM MAU TAU YA</b>
Masukkan Pesan      : <b>BSCDNCOVMSBFDDAAFF GGETTHYEUYGBDRCASTAKFUV CIDYEOFAA FJDECNEGDDCEERDECNEGDDCEANSGB GKDREEFNGGA</b>
Isi Sebenarnya      : <b>COBA TEBAK YA</b>
Masukkan Pesan      : <b>EXIT</b>
Program Berhenti
</pre>

## Checklist
### Komponen Wajib | 100 Poin
- [ ] **Mengimplementasikan fungsi `decode(String pesan)` sesuai dengan ketentuan**

## **Komponen Bonus | 10 Poin**
- [ ] **Memodifikasi program agar terus menerus meminta input hingga mendapatkan input `EXIT`**