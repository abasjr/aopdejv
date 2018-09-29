# Tutorial 4: Pengenalan OOP

Dasar-dasar Pemrograman 2 - CSGE601021 | Fakultas Ilmu Komputer, Universitas Indonesia, Semester Genap 2017/2018

**Dibuat oleh: AR, dimodifikasi dari Tutorial DDP2 2017**

* * *
Pada tutorial sebelumnya, Anda telah mempelajari mengenai konsep loop di Java. Anda juga telah menyinggung sedikit materi mengenai method (return pada bagian branching statement). Kali ini, Anda akan mempelajari lebih mengenai method, keyword *static*, overloading dan mendesain kelas (intro to OOP).

## **Tujuan Pembelajaran**
1. Memahami konsep **static** keyword.
2. Memahami konsep **overloading**.
3. Memahami konsep **encapsulation**.
3. Memahami cara mendesain **kelas** dalam Java.

### **Before You Start...**
1. Lakukan `git pull upstream master` dengan menggunakan Command Prompt pada folder repository lokal Anda.
2. Kerjakan soal tersebut kemudian letakkan file jawaban anda di folder `lab_4/src/main/java`.
3. Implementasikan kode Anda sesuai apa yang diminta soal tutorial dan lab.
4. Setelah selesai mengimplementasikan kode tersebut, lakukan add, commit, dan push code anda tersebut.

## **Materi Tutorial**

### **Static keyword in Java**
**Static** keyword di dalam java adalah keyword yang menyatakan bahwa properti (atribut atau method) suatu kelas dimiliki oleh kelas tersebut, bukan objek (instansiasi sebuah kelas) dari kelas tersebut. Pengaksesan properti **static** harus melalui kelasnya secara langsung, namun bisa juga melalui objek dari kelas tersebut (tidak *best practice*).
### Contoh penggunaan keyword **static**
```java
public class Frame {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public String type;

    public Frame(String type) {
        this.type = type;
    }

    public static int area(){
        return HEIGHT * WIDTH;
    }
}
```
### Perintah untuk mengakses atribut/method static
```java
int frameWidth = Frame.WIDTH;
int frameHeight = Frame.HEIGHT;
int frameArea = Frame.area();
System.out.println(frameArea); // Mencetak bilangan 250000

// Untuk mengakses type, perlu diinstansiasi terlebih dahulu objek Frame!
Frame bingkai = new Frame("Bingkai Foto");
String tipeBingkai = bingkai.type;
System.out.println(tipeBingkai); // Mencetak string "Bingkai Foto"
System.out.println(bingkai.WIDTH); // Mencetak bilangan 500, namun tidak best practice :)
```

### **Overloading**
Pada tutorial kali ini, Anda akan belajar suatu konsep yang disebut *overloading*. *Overloading* di dalam Java terdiri atas *method overloading* dan *constructor overloading*. *Method overloading* adalah sebuah konsep/fitur yang memungkinkan untuk membuat method dengan nama yang sama, namun memiliki parameter masukan yang berbeda, baik tipe parameter maupun jumlah parameter. *Constructor overloading* memiliki konsep yang sama dengan *method overloading*, namun yang di-overload adalah constructor dari kelas. Salah satu overloading method yang sering anda gunakan adalah method println().
### Contoh overloading method
```java
public void spawn() {
    System.out.println("Unknown object successfully spawned");    
}

public String spawn(String name) {
    return name + " successfully spawned";
}

public String spawn(String name, int amount) {
    return amount + " objects of " + name + " successfully spawned";
}
```

### **Encapsulation**
*Encapsulation* merupakan proses menutup/membungkus untuk membatasi akses langsung ke beberapa properti objek (atribut/method). Di Java, kita dapat melakukan *encapsulation* dengan cara memberikan *access modifier* kepada properti objek. Terdapat 4 macam access specifier di Java, yaitu :

| **Access modifier** | **Class** | **Package**  | **Subclass** | **Global** |
| --- | :---: | :---: | :---: | :---: |
| private | ✅ | ❎ | ❎ | ❎ |
| default | ✅ | ✅ | ❎ | ❎ |      
| protected | ✅ | ✅ | ✅ | ❎ |  
| public | ✅ | ✅ | ✅ | ✅ |

✅ : Bisa diakses

❎ : Tidak bisa diakses

Jika kita tidak melakukan *encapsulation* dengan baik, bisa saja terjadi hal-hal yang tidak diinginkan, seperti :
```java
// Inisiasi objek Frame
Frame bingkai = new Frame("Foto");

// bingkai langsung berubah jadi undangan
bingkai.type = "Undangan";
```
Supaya *behavior* kelas yang kita kembangkan dapat sesuai dengan harapan, dan supaya pengguna kelas tersebut dapat menggunakannya dengan lebih mudah, adalah alasan mengapa *encapsulation* penting untuk dilakukan. (contoh kasus diatas terjadi **JIKA** *access modifier* atribut **type** dari kelas Frame adalah **public**, jadi solusinya adalah ubah *access modifier* atribut tersebut menjadi **private**). Selain itu, *encapsulation* bertujuan untuk menyembunyikan kerumitan dari suatu kelas. Misal, anda menggunakan kelas Math di Java, kemudian anda menggunakan method log() untuk menghitung logaritma, anda tidak perlu mengetahui apa yang dilakukan didalam method log().

Terus gimana dong cara mengakses variable yang *access modifier*-nya **private**? Jawabannya adalah, menggunakan **setter dan getter**, contohnya gini :
```java
public void setType(String type) {
    this.type = type;    
}

public String getType() {
    return type;
}
```

### **Class Design**
Dalam Object Oriented Programming, struktur kelas yang digunakan biasanya seperti ini:
```java
package Demo;       // Kelas Demo berada dalam package Demo

public class Demo   // Nama kelas
{
    /* Atribut dari kelas */
    private String var1;                    // Instance variable, menggunakan access modifier private
    private int var2;                       // Juga instance variable

    /* Konstruktor kelas Demo, sama seperti __init__() di Python */
    public Demo(String var1, int var2) {
        this.var1 = var1;                   // Keyword 'this', menunjuk kepada atribut/method suatu object di kelas ini (kelas Demo)
        this.var2 = var2;
    }

    /* Setters & Getters */
    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar2(int var2) {
        this.var2 = var2;
    }

    public String getVar2() {
        return var2;
    }

    /* Method lain yang ingin diimplementasikan */
    public void method1(String args1) {
        System.out.println(var1 + " " + args1);
    }

    public int method2(int args2) {
        return var2 + args2;
    }
}
```

### **Let's do this!?**

Sebelum kita masuk ke soal tutorial, kita akan warm-up terlebih dahulu. Untuk menguji pemahaman Object Oriented Programming anda, coba jawab pertanyaan berikut :

Misal kita punya class:
```java
class Motor {
   String nama;
   String merk;

   Motor(String nama, String merk) {
       this.nama = nama;
       this.merk = merk;
   }
}
```
Coba tebak output program di main method berikut :

**Soal 1**
```java
Motor a = new Motor("bleki", "Yamahmud");
Motor b = new Motor("bleki", "Yamahmud");
System.out.println(a == b);
```
**Soal 2**
```java
Motor a = new Motor("bleki", "Yamahmud");
Motor b = a;
b.nama = "hajigur";
System.out.println(a.nama);
```
**Soal 3**
```java
Motor a = new Motor("bleki", "Yamahmud");
Motor b = a;
b = new Motor("hajigur", "Yamahmud");
System.out.println(a.nama);
```


## **Soal Tutorial : "Member Pet Shop"**

### **What's the story?**

Setelah sampai di pet shop, Amir langsung membeli makanan untuk kucing kesayangannya. Saat ingin melakukan pembayaran di kasir, terjadi antrian panjang. Hal ini disebabkan Mbak Kasir harus menuliskan seluruh data pembeli secara manual. Amir memiliki ide untuk membuat sebuah aplikasi java untuk memanajemen data member di pet shop. Setelah berdiskusi dengan Manajer pet shop, Amir telah mendapatkan semua hal yang dibutuhkan untuk membuat aplikasi. Namun karena Amir sudah ditunggu kucing kesayangannya, Amir meminta anda untuk membuat aplikasi tersebut. Amir akan mengurus input dari user yang merupakan file bernama **MemberMain.java** sehingga kamu dilarang untuk mengubah file ini sedikitpun. Tugas kamu adalah membuat file terpisah dengan nama **Member.java**.

### **Spesifikasi Class**

Nama file kamu **wajib** Member.java

### Setiap Member mempunyai :
- [ ] nomorMember (sebuah bilangan bulat)
- [ ] nama
- [ ] umur
- [ ] saldo (sebuah bilangan bulat)
- [ ] memberTutup (sebuah kondisi untuk status member, default value : false)

> Catatan : 
> - Semua atribut yang dimiliki member harus disimpan secara aman dan hanya dapat diubah dan diakses sesuai kebutuhan.
> - Kamu boleh menambahkan atribut baru jika dibutuhkan
> - Setiap pendaftaran member baru, pendaftar wajib menginputkan nomor member, nama, nomor telepon, dan saldo awal
> - Jumlah saldo awal apabila tidak dispesifikasikan adalah 50000 (Hint : Overloading Constructor)
> - Jika member sudah berusia diatas 50 tahun, maka akun member tersebut otomatis ditutup
> - Jangan lupa untuk mengimplementasikan **Setters & Getters**


### Setiap Member dapat melakukan beberapa *behaviour* yaitu :

:boom: **kirimSaldo(penerima,uang)**
> - Method untuk mengirim saldo kepada **penerima**
> - Banyak saldo yang akan dikirim sesuai dengan yang diinputkan.
> - Jika akun pemberi atau penerima telah ditutup maka proses kirim saldo gagal.
> - Pemberi tidak bisa mengirim saldo ke diri sendiri.
> - Jika saldo yang dimiliki pemberi cukup, maka saldo pemberi akan berkurang dan saldo penerima akan bertambah.
> - Jika saldo yang dimiliki pemberi tersebut tidak cukup, proses pengiriman saldo akan gagal.

:boom: **topUpSaldo(uang)**
> - Method untuk menambah saldo Member.
> - Banyak saldo yang akan di *top up* sesuai dengan yang diinputkan.
> - Jika akun member telah ditutup maka proses top up saldo gagal.

:boom: **tutupMember()**
> - Method untuk menutup member.
> - Jika akun member telah ditutup maka proses tutup akun gagal.


### **Contoh output yang diharapkan ketika file MemberMain.java dijalankan :**

<pre>
--------------------
Nomor Member	: 1
Nama		: Pak Ijo
Umur		: 18
Saldo		: 100000

--------------------
Nomor Member	: 2
Nama		: Pak Inem
Umur		: 20
Saldo		: 50000

--------------------
Pak Ijo telah berhasi top up saldo
Saldo Pak Ijo saat ini 120000

--------------------
Pak Ijo telah berhasil mengirim saldo ke Pak Inem sebesar 30000
Saldo Pak Ijo saat ini 90000
Saldo Pak Inem saat ini 80000

--------------------
Member atas nama Pak Inem telah resmi ditutup

--------------------
Member atas nama Pak Inem telah ditutup

--------------------
Nomor Member	: 1
Nama		: Pak Ijo
Umur		: 18
Saldo		: 90000

--------------------
Member atas nama Pak Inem telah ditutup

--------------------
Pak Ijo terlalu tua untuk menjadi member
Member atas nama Pak Ijo telah resmi ditutup

--------------------
Member atas nama Pak Ijo telah ditutup

--------------------
Member atas nama Pak Inem telah ditutup

</pre>



## **Soal Bonus: Jumlah Member**
Seluruh *instance* member memiliki variabel bersama yaitu **banyakMember** yang bersifat *public* dan berisi informasi mengenai banyak *instance* dari member. Jika ada member baru maka **banyakMember** otomatis bertambah. Jika ada member yang akunnya ditutup maka **banyakMember** otomatis berkurang. Pengecualian untuk pembuatan bonus, kamu diperbolehkan menambah beberapa baris kode pada file **MemberMain.java** di tempat yang telah disediakan untuk mencetak banyak member awal.

### **Contoh output yang diharapkan ketika file MemberMain.java dijalankan kembali :**
<pre>
--------------------
Banyak member : 2

--------------------
Nomor Member	: 1
Nama		: Pak Ijo
Umur		: 18
Saldo		: 100000

--------------------
Nomor Member	: 2
Nama		: Pak Inem
Umur		: 20
Saldo		: 50000

--------------------
Pak Ijo telah berhasi top up saldo
Saldo Pak Ijo saat ini 120000

--------------------
Pak Ijo telah berhasil mengirim saldo ke Pak Inem sebesar 30000
Saldo Pak Ijo saat ini 90000
Saldo Pak Inem saat ini 80000

--------------------
Member atas nama Pak Inem telah resmi ditutup
Banyak member sekarang : 1

--------------------
Member atas nama Pak Inem telah ditutup

--------------------
Nomor Member	: 1
Nama		: Pak Ijo
Umur		: 18
Saldo		: 90000

--------------------
Member atas nama Pak Inem telah ditutup

--------------------
Pak Ijo terlalu tua untuk menjadi member
Member atas nama Pak Ijo telah resmi ditutup
Banyak member sekarang : 0

--------------------
Member atas nama Pak Ijo telah ditutup

--------------------
Member atas nama Pak Inem telah ditutup

</pre>

## Checklist
### Komponen Wajib | 100 Poin
- [ ] Membuat kelas **Member** sesuai spesifikasi
- [ ] Melakukan handling pada method **kirimSaldo(penerima,uang)**, **topUpSaldo(uang)**, **tutupMember()**
- [ ] Menerapkan contructor overloading pada kelas **Member**
- [ ] Menerapkan access modifier (encapsulation) yang sesuai pada kelas **Member**
- [ ] Membuat Getter Setter

### Komponen Bonus | 10 Poin
- [ ] Membuat variabel **banyakMember**
- [ ] Proses penambahan/pengurangan member berhasil


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
