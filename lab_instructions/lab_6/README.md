# **Tutorial 6: Rekursif**

Dasar-dasar Pemrograman 2 - CSGE601021 | Fakultas Ilmu Komputer, Universitas Indonesia, Semester Genap 2018/2019

**Dibuat oleh: AR, dimodifikasi dari Tutorial DDP2 2017**

* * *

## **Tujuan Pembelajaran**
1. Memahami konsep **recursive method**.

### **Before You Start...**
1. Lakukan `git pull upstream master` dengan menggunakan Command Prompt pada folder repository lokal Anda.
2. Kerjakan soal tersebut kemudian letakkan file jawaban anda di folder `lab_6/src/main/java`. Kami sudah menyediakan folder kosong untuk kamu.
3. Setelah selesai mengimplementasikan kode tersebut, lakukan add, commit, dan push code kalian tersebut.

## **Materi Tutorial**

### **Recursive Method**

Pada tutorial kali ini, Anda akan belajar suatu fungsi yang disebut recursive method. Sebuah fungsi dapat dikatakan rekursif jika fungsi tersebut memanggil dirinya sendiri. Biasanya fungsi rekursif digunakan untuk menyelesaikan permasalahan yang dapat direduksi menjadi masalah serupa yang lebih kecil.

Salah satu contohnya adalah menghitung faktorial sebuah bilangan. Perhatikan gambar berikut:

![alt text](https://i.imgur.com/hriRLZ7.png "Ilustrasi faktorial")

Apakah Anda melihat sebuah pola? Fungsi factorial di atas dipanggil empat kali, dengan parameter yang mengecil. Dapat kita simpulkan bahwa dalam fungsi factorial(n), akan terpanggil fungsi factorial(n-1) hingga selesai.
Agar fungsi rekursif tidak terus dijalankan tanpa henti, kita membutuhkan sebuah basis atau base case yang tidak menggunakan recursive call, atau tidak memanggil fungsi rekursif kembali. Perhatikan contoh kode berikut:

```Java
int factorial(int number){
    if (number <= 1) {                 //basis
        return 1;
    }
    else {                             //rekurens
        return number * factorial(number - 1);
    }
}
```

Pada dasarnya, fungsi rekursif dapat dibagi menjadi basis dan rekurens. Pada kode di atas, base case fungsi tersebut adalah jika angka parameter yaitu number kurang dari atau sama dengan satu, karena 1! = 1, dan 0! = 1 (asumsi input tidak negatif, karena faktorial negatif tidak terdefinisi). Base case ini tidak menggunakan recursive call karena bertujuan menghentikan pemanggilan rekursif jika terjadi.

Sedangkan untuk rekurens, fungsi diatas mengembalikan nilai number itu sendiri dikalikan dengan pemanggilan fungsi kembali, tetapi parameter menjadi number-1. Nilai saat pemanggilan selanjutnya akan mengecil mendekati basis. Pemanggilan factorial(4) akan mengembalikan nilai 4 dikali dengan factorial(3), yang akan mengembalikan nilai 3 dikali dengan factorial(2), hingga base case yaitu factorial(1).

### **Let's do this!?**

Sebelum kita masuk ke soal tutorial, kita akan warm-up terlebih dahulu. Untuk setiap soal, cari kasus *base case* dan kasus *rekurens*

1. Fungsi yang mengeluarkan output hitung mundur dari n sampai 1

    ```
    n = 5
    Output:
    5
    4
    3
    2
    1
    ```

2. Fungsi menghitung bilangan fibonacci ke-n (bilangan fibonacci ke-n adalah hasil jumlahan dari dua bilangan sebelumnya)

    ```
    fibonacci(6)
    Output:
    13
    ```
3. Fungsi yang memasukkan char ‘*’ di antara semua huruf dalam suatu string.

    ```
    masukkanBintang(“depechan”)
    Output:
    d*e*p*e*c*h*a*n
    ```

## **Soal Tutorial : Ouija dan TB**

------
**WARNING** Untuk soal tutorial ini, dilarang untuk memakai loop (for, while, etc.)

------

### **What's the story?**

Amir memiliki seorang teman bernama Ouija yang juga memiliki kucing bernama TB. Hari ini merupakan hari yang bahagia untuk Ouija, karena TB hari ini melahirkan beberapa anak kucing yang lucu. Ouija ingin memberikan nama yang unik kepada anak kucing tersebut. Ouija ingin anak kucingnya memiliki nama yang bersifat **palindrome**. Ouija berdiskusi dengan Amir untuk membuat nama untuk anak TB. Amir meminta tolong kepada anda sebagai Java Programmer untuk membuat sebuah program yang dapat mengecek apakah nama yang diusulkan merupakan **palindrome** atau bukan.

### **Spesifikasi program**

> - Nama program kamu **wajib** NamaAnakTB.java
> - Buat method **isPal** yang digunakan untuk mengimplementasikan kode anda
> - Method **isPal** mengambalikan nilai _boolean_
> - Program kamu menerima **satu** baris input, yang merupakan usulan nama untuk anak TB. 
> - Usulan nama dapat mengandung beberapa kata. 
> - **M** dan **m** merupakan huruf yang tidak _equals_.

Contoh masukan 1:

>hannah

Contoh keluaran 1:

>true

Contoh masukan 2:

>hakam

Contoh keluaran 2:

>false

## **Soal Bonus : **
_Tidak ada bonus yaa hehe :)_

## Checklist
Isi kurung siku komponen dengan x untuk menceklis komponen.
### Komponen Wajib | 100 Poin
- [ ] **Meminta masukan dari user**
- [ ] **Validasi masukan**
- [ ] **Membuat fungsi isPal untuk mengecek nama**
- [ ] **Memanggil fungsi tersebut di method main, dan mengeluarkan hasil di console**


-----
### **Woah, apa ini !?**

Ketika kalian meng-push hasil kerja kalian, kalian akan sadar bahwa ada logo cross merah atau centang hijau di samping hasil kerja kalian.

![alt text](https://i.imgur.com/ZNfetmP.png "Ilustrasi git 1")

Kalian mungkin memperhatikan bahwa kita mulai memakai sistem git sejak semester 2, mengikuti kakak angkatan kalian yang baru mulai memakai sistem git sejak semester 3. Salah satu guna dari menggunakan git adalah kita bisa menggunakan fitur Continuos Integration?

Apa itu Continuous Integration? Continuos Integration adalah konsep di mana ketika kalian push, hasil push kalian langsung di build (compile) dan di test (uji langsung). Jika gagal, kalian akan diberitahu.

Bagian Build baru akan dijelaskan di mata kuliah Advanced Programming. Kalian hanya perlu mengetahui bagian test.

Sistem yang digunakan untuk mengetest di Java bernama JUnit. Kita bisa menggunakan framework JUnit untuk mengetes secara langsung (tanpa harus print di command line). Untuk sekarang, kalian tidak perlu tahu cara kerja JUnit.

Kamu dapat memeriksa hasil kerja Junit di tab Commit. Tekan logo centang hijau atau cross merah untuk memeriksa detail lebih lanjut.

![alt text](https://i.imgur.com/E23AOfl.png "Ilustrasi commit")

Ketika kamu menekan logo tersebut, kamu akan memeriksa rangkuman dari tes tersebut yang memiliki dua lingkaran.

Jika lingkaran pertama cross, maka program kamu gagal karena compile error.
Jika lingkaran pertama centang hijau tetapi lingkaran kedua cross, maka program kamu tidak akurat.
Jika kedua lingkaran centang, berati program kamu sudah baik.

![alt text](https://i.imgur.com/1ElduFi.png "Ilustrasi status")

Kamu dapat menekan tombol cross merah atau centang hijau untuk melihat hasil lebih lanjut. Sebagai contoh, jika kalain mendapat cross merah di lingkaran kedua, kamu dapat menemkan cross merah kedua untuk melihat test case mana program kalian tidak akurat.
