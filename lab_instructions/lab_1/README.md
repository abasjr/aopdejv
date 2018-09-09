# Lab 1 : Pengenalan Java & Git
Dasar-dasar Pemrograman 2 - CSGE601021 | Fakultas Ilmu Komputer, Universitas Indonesia, Semester Gasal 2018/2019

**Dibuat oleh: AFAI, dimodifikasi dari Tutorial DDP2 2017**

## Java

Di DDP 1 kalian telah belajar konsep-konsep pemrograman dengan menggunakan bahasa Python, 
di DDP 2 ini kalian memperdalam pemahaman pemrograman kalian dengan konsep-konsep yang menarik 
seperti _Object Oriented Programming_ dengan menggunakan bahasa pemrograman Java.
 
Pasti timbul pertanyaan di benak kalian, kenapa memakai Java ? kenapa tidak pakai Python saja?. 

Singkatnya, Java mempunyai kelebihan yaitu kejelasan struktur dalam pemrogramannya, 
sehingga membuat mudah untuk memahami konsep _Object Oriented_. Selain itu juga masih ada perbedaan lain 
yang perlu kalian ketahui, simak penjelasan dibawah ini.

**Interpreted / Compiled**

Python merupakan salah satu _Interpreted Language_, dimana saat program dijalankan, 
komputer akan mengeksekusi tiap instruksi satu per satu. Oleh karena itu kita bisa langsung 
menjalankan program Python. Java merupakan salah satu _Compiled Language_, dimana setiap program 
harus diubah menjadi bahasa lain yang bisa dimengerti komputer, lalu setelah itu baru bisa dijalankan.

**Struktur Kode**

Pada dasarnya, walaupun memiliki perbedaan struktur kode yang mencolok, semua bahasa pemrograman itu memiliki garis 
besar yang sama, sehingga jika kalian telah memahami sebuah bahasa pemrograman, akan lebih mudah untuk memahami bahasa 
yang lain. 

Oleh karena itu, yuk simak perbedaan intruksi-intruksi di Python dan Java.

1.  **Declaring & Assigning Variables**
    
    Variabel di Python bersifat _dynamic_, contohnya adalah kita bisa memberi nilai dengan tipe data apapun ke sebuah 
    variabel, dan kita bisa mengubah nilai variabel tersebut dengan tipe data yang berbeda. 
    
    Java memiliki variabel yang 
    bersifat _static_, perbedaanya dengan Python adalah kita harus memberikan informasi mengenai tipe data sebuah variabel 
    secara **eksplisit**, serta kita hanya bisa mengganti nilai variabel tersebut dengan tipe data yang sama. 
    
    Untuk lebih jelasnya lihat perbandingan dibawah ini.

    **Python**
    
    ```python
    var1 = 3
    var2 = "Hehe"
    var3 = True
    var1 = False # bisa
    ```
    
    **Java**
    
    ```java
    int var1 = 3;
    String var2 = "Hehe";
    boolean var3 = true;
    var1 = false; // error, var1 bertipe int
    ```
    
    **_Catatan :_** Tipe tipe data di Java antara lain, **int** (bil. bulat), **double** (bil. pecahan), **boolean** 
    (true/false), **String** (kalimat), **char** (satu huruf), dan masih banyak lagi yang akan kalian pelajari nanti.
    
    >**Perhatian**
    >
    >Di Java, kalian harus memberikan semicolon ( **;** ) di tiap akhir instruksi, 
    ini menandakan akhir sebuah instruksi dan pemisah antar instruksi, 
    dimana di Python tiap instruksi dipisahkan dengan baris.

2.  **If-Else Conditions**

    Flow Conditions di Java dan Python sama, yang membedakan adalah di Python kita mengenal **elif**, 
    di Java menggunakan **else if**, simak contoh dibawah ini.

    **Python**
    
    ```python
    nilai = 78
    huruf = ''
    
    if(nilai > 85):
        huruf = 'A'
    elif(nilai > 70):
        huruf = 'B'
    elif(nilai > 55):
        huruf = 'C'
    else:
        huruf = 'D'
    
    print(huruf)
    ```
    
    **Java**
    
    ```java
    int nilai = 78;
    char huruf;
    
    if(nilai > 85){
        huruf = 'A';
    }else if(nilai > 70){
           huruf = 'B';
    }else if(nilai > 55){
           huruf = 'C';
    }else{
           huruf = 'D';
    }
    System.out.println(huruf);
    ```

    >**Perhatian**
    >
    >Di Python, untuk mendefinisikan isi sebuah conditions (if elif else), kita memberi titik dua  ( : ) 
    pada conditions, lalu isinya berada dibawahnya dengan indentasi. 
    >
    >Di Java, isi dari sebuah conditions ada didalam 
    kurung kurawal ( **{ }** ). penggunaan indentasi hanya sebagai aestetik agar program lebih mudah dibaca, 
    ini juga berlaku untuk fungsi, class, dan lain-lain.

3.  **Loop**
    
    Untuk memahami perbedaan loop di Java dengan Python, simak kode di bawah ini.
    
    **Python**
    
    ```python
    for num in range(10):
        print("Cetakan ke-" + str(num+1))
    
    point = 0
    while (point < 10):
        print(point)
        point += 1
    ```
    
    **Java**
    
    ```java
    for(int a = 0; a<10; a++){
                System.out.println("Cetakan ke-" + Integer.toString(a+1));
            }
    
    int point = 0;
    while(point<10){
        System.out.println(point);
        point++; // tanda ++ untuk menambah dengan nilai 1
    }
    ```

    Perbedaan paling mencolok ada pada `for` loop di Java yang memiliki format :
    
    ```java
    for (int variabel; syarat; peubah nilai){
         // isi
    }
    ```
    
    Kita harus membuat variabel dulu, lalu tentukan syarat berjalannya loop, yang selama true, maka loop akan berjalan, 
    dan yang ketiga memberikan peubah nilai agar nilai suatu saat loop nya berhenti. 
    
    Memang terlihat rumit namun kita bisa membuat for loop yang bermacam-macam.
    
### Membuat Program Java

Kalian sudah mengetahui beberapa perbedaan Java dengan Python, sekarang saatnya kalian belajar membuat program 
sederhana, berbeda dengan Python dimana kalian bisa langsung menulis instruksi di file python, ada beberapa aturan 
main saat kalian membuat program di Java, simak petunjuknya dibawah ini.

Pertama, buatlah sebuah file dengan format **.java** (buat sebuah file text, lalu ganti formatnya dengan .java), lalu 
buka dengan text editor (Notepad++, Sublime, dll.).

Hal yang pertama kita buat adalah sebuah **class**, karena di Java, setiap program yang kita buat harus berada di dalam 
sebuah class. Pastikan nama class nya sama dengan nama file nya (jika nama filenya **Halo.java**, maka nama class nya 
**Halo**).

Lalu, kita buat sebuah fungsi _main_, _**Buat apa fungsi main?**_ Fungsi main berguna sebagai entry-point (titik masuk) 
jalannya sebuah program, saat kalian jalankan program kalian, Java akan mencari letak fungsi main, lalu menjalankan 
instruksi yang ada didalamnya. 

Setelah itu di dalam fungsi main tersebut bisa diisikan instruksi-instruksi yang ingin dijalankan, contoh 
programnya :

```java
public class Halo{
    
    public static void main(String[] args){
    
        System.out.println("Hello World!");
        
        String nama = "Dek Depe";
        System.out.println("Namaku " + nama);
        
    }
    
}
```

> **_System.out.println()_** digunakan untuk mencetak sebuah informasi ke layar, di Python kita mengenal _print()_

Untuk menjalankan program kalian, pertama _save_ dulu file kalian, lalu buka folder dimana file kalian berada, pada 
address bar nya, ketik `cmd`, lalu tekan _Enter_, Command Prompt akan terbuka dengan directory menunjuk ke lokasi file 
kalian. 

Kalian juga bisa membuka _Command Prompt_ di _Start Menu_, namun kalian harus mengarahkan direktorinya ke folder
dimana program kalian berada secara manual 

>gunakan perintah `cd` untuk berpindah direktori, (misal D:\Kuliah), dan `<drive>:` untuk 
berpindah partisi (misal `D:`).

Untuk menjalankan program, kalian perlu melakukan 2 perintah di Command Prompt, yaitu :

1.  `javac NamaFile.java`

    Ini akan meng-_compile_ file Java kalian dan menghasilkan file bernama sama dengan tipe file `.class`

2.  `java NamaFile`
    
    Ini akan mengeksekusi file yang telah kalian compile, semua output akan terlihat di _Command Prompt_

Dan program Java pertama kalian berhasil dijalankan ! yay!

### Membuat Program Java (Lanjutan)

Setelah kalian berhasil membuat program java sederhana, kita akan mencoba program java yang lebih kompleks. Sebelum itu,
kalian harus memahami mengenai beberapa hal sebagai berikut :
1. Class & Object
2. Methods
3. Instance & Local Variables
4. Object references
5. Parameters
 
#### Class & Object

Class merupakan sebuah *blueprint* atau *template* untuk membuat object. Pada class, kita mendefinisikan *properties* dan 
*behaviors* yang akan dimiliki oleh object yang terikat dengan class tersebut.

Object adalah sebuah entitas yang dapat dimanipulasi pada program, setiap object merupakan representasi dari sebuah
kelas. Perhatikan contoh berikut :

```java
public class Kucing {
    String nama; //properties
    
    public void mengeong() {
        System.out.println("Meeeooooong");
    } //behaviors
    
    public static void main(String[] args) {
      Kucing kucing1 = new Kucing(); //Object kucing dibuat
      Kucing kucing2 = new Kucing(); 
      kucing1.nama = "Blacky"; //Melakukan manipulasi pada object dengan mengisi nama kucing1
      kucing2.nama = "Garfield";
      System.out.println("Kucing 1:" + kucing1.nama);
      System.out.println("Kucing 2:" + kucing2.nama);
      kucing1.mengeong();
    }
}
```

Pada contoh program tersebut kita membuat sebuah class bernama `Kucing` kemudian melakukan instansiasi object Kucing
pada fungsi `main`. `kucing1` dan `kucing2` merupakan sebuah object yang dibuat berdasarkan kelas `Kucing`, sehingga
`kucing1` dan `kucing2` memiliki karakteristik sesuai dengan yang kita definisikan pada kelas `kucing` ketika mereka
pertama kali dibuat. Setelah `kucing` dan `kucing2` dibuat, kita dapat melakukan manipulasi pada kedua objek tersebut
sehingga mereka memiliki karakteristik yang berbeda (Pada contoh diatas mereka memiliki nama yang berbeda). Manipulasi
yang dapat dilakukan pada object `kucing1` dan `kucing2` terbatas pada properties dan behaviors yang didefinisikan
pada class kucing.

#### Methods 

Method adalah rangkaian instruksi yang mengakses data dari sebuah object. Method didefinisikan pada class, object yang
dapat dimanipulasi dengan menggunakan method yang telah didefiniskan pada classnya. Perhatikan contoh berikut :

```java
public class Kucing {
    
    public void mengeong() {
        System.out.println("Meeeooooong");
    } 
    
    public static void main(String[] args) {
      Kucing kucing = new Kucing();
      kucing.mengeong();
    }
}
```

Pada contoh diatas, terdapat sebuah method `mengeong()` yang berisi instruksi untuk mencetak string `"Meeeooooong"` ketika
method tersebut dipanggil.

#### Instance & Local variables

Instance variable merupakan variable yang dideklarasikan di dalam suatu class, namun di luar method. Instance variabel
menyimpan data suatu objek. Instance variable dihidupkan ketika sebuah objek dibuat dan akan tetap terus hidup hingga
objek yang berkaitan dimusnahkan

Local variable merupakan variable yang didefinisikan di dalam suatu method. Local variable hanya bisa digunakan pada 
method tersebut. Local variable dihidupkan ketika method yang bersangkutan dijalankan, ketika method yang bersangkutan
selesai dieksekusi, local variable akan langsung dimusnahkan.

```java
public class Kucing {
    String nama; //instance variable
    
    public void mengeong() {
        String suara = "Meeeooooong"; //local variable 
        System.out.println(suara);
    } 
    
    public static void main(String[] args) {
      Kucing kucing1 = new Kucing(); //Instance variable dihidupkan bersamaan dengan pembuatan objek
      kucing1.mengeong(); //local variable dihidupkan ketika method dijalankan
    }
}
```

#### Object References

Pada java, object variable (yaitu variable yang tipenya adalah sebuah class) sebenarnya tidak menyimpan sebuah object, tetapi 
menyimpan lokasi memori dari sebuah object. Kita menggunakan istilah **object reference** untuk menyatakan lokasi memori dari
sebuah object. Ketika sebuah variable menyimpan alamat dari sebuah object, dapat dikatakan bahwa variable tersebut mengacu
ke sebuah object.  

```java
Kucing kucing1 = new Kucing();
```

Pada statement tersebut, operator `new` mengembalikan sebuah referensi ke object baru, kemudian referensi tersebut disimpan 
pada variable kucing1.

Sangat penting untuk mengingat bahwa object variable tidak menyimpan sebuah object, melainkan hanya mengacu ke suatu object. 
Dua variable yang berbeda dapat mengacu ke objek yang sama. 

```java
Kucing kucing1 = new Kucing();
Kucing kucing2 = kucing1;
```

Pada statement tersebut, kucing2 tidak menyalin object dari kucing1, melainkan hanya menyalin referensi yang disimpan oleh
kucing1, sehingga kucing1 dan kucing2 mengacu pada object yang sama.

#### Parameter

Parameter merupakan input untuk suatu method, terdapat dua jenis parameter, yaitu explicit paameter dan implicit parameter

- Implicit parameter adalah objek yang memanggil method tersebut.
- Explicit parameter adalah semua parameter selain implicit parameter.

```java
public class Kucing {
    public void mengeong(String suara) {
        System.out.println(suara);
    } 
    
    public static void main(String[] args) {
      Kucing kucing1 = new Kucing();
      String suara1 = "Meong";
      String suara2 = "Meeeeeooong";
      kucing1.mengeong(suara1); //Line 4
      kucing1.mengeong(suara2); //Line 5
    }
}
```

Pada contoh program diatas, line 4 dan line 5 melakukan pemanggilan method `mengeong`. Line 4 dan line 5 memiliki 
implicit parameter yang sama yaitu kucing1, dan explicit parameter yang berbeda yaitu suara1 dan suara2. Secara singkat,
dalam pemanggilan sebuah method, implicit dan explicit parameter dituliskan sebagai berikut:

`[implicitParameter].[methodName]([explicitParameter])`

#### Latihan :

1.  Akhir tiap instruksi di Java harus diakhiri dengan . . . .

2.  Isi dari sebuah conditional, fungsi, dll harus berada di dalam tanda  . . . .

3.  Object merupakan . . . . dari class

4.  Ketika sebuah method dipanggil, object yang memanggilnya disebut sebagai . . . . parameter

***

## Git

Selain beralih dari bahasa pemrograman Python ke bahasa pemrograman Java, di mata kuliah DDP2 kali ini, kalian akan 
diberikan sebuah pengalaman baru dengan menggunakan Git.

**Version Control System (VCS)**

VCS merupakan sebuah software yang membantu para developer untuk saling bekerja sama dan tetap mempertahankan 
riwayat kerja mereka secara utuh. 

VCS memiliki beberapa fungsi, di antaranya mengizinkan para developer untuk  bekerja secara bersamaan, tidak 
mengizinkan saling tumpang-tindih perubahaan yang ada, dan mempertahankan riwayat dari setiap versi. 

VCS sendiri terbagi menjadi dua tipe, yaitu Centralized VCS (CVCS) dan Distributed/Decentralized VCS (DVCS). 

Git merupakan VCS yang sering digunakan sekarang ini. Git merupakan salah satu Distributed Version Control System 
(DVCS), yang berarti salinan kode yang tersimpan di local repository adalah sebuah version control repository yang 
lengkap. 

Jadi, antara local repository dan remote repository sama-sama berisi versi terakhir (terupdate).

**Perintah di Git**

Untuk melihat berbagai perintah (command) yang ada di Git, kamu bisa melihatnya di [sini](https://gitlab.com/gitlab-com/marketing/raw/master/design/print/git-cheatsheet/print-pdf/git-cheatsheet.pdf).

**Tutorial Git**

Pada bagian pertama, kamu sudah diberikan soal tutorial mengenai bahasa pemrograman Java. Pada bagian ini, kamu 
akan menyimpan file yang telah kamu buat secara remote di GitLab. 

Untuk melakukan hal tersebut, harap ikuti langkah-langkah berikut ini:

1.  Buatlah sebuah folder yang akan menjadi local repository yang kamu gunakan,. Nama folder bebas.
    > Catatan: dalam soal tutorial ini, nama folder yang digunakan adalah “TutorialDDP2”, kalian boleh menggantinya.

2.  Buka command prompt/shell.

3.  Ubah direktori sekarang menjadi direktori dari folder “TutorialDDP2”.
    > Misal : D:\DDP2\TutorialDDP2

4.  Jalankan perintah `git init` pada command prompt/shell.

    > ini akan menginisiasi Git pada direkori yang ditunjuk oleh _Command Prompt_, pastikan kalian tidak salah menginisiasi folder

5.  Jalankan perintah `git status` untuk memastikan bahwa inisiasi repository Git sudah berhasil dilakukan.

6.  Atur username dan email yang akan diasosiasikan dengan pekerjaanmu di repository Git dengan perintah berikut:
           `git config --global user.name “<nama-lengkapmu”`  
           `git config --global user.email “<masukkan-emailmu>”`
    > ini untuk memberi informasi tentang pengguna repo, masukan email dan nama kalian.
           
7.  Setelah melakukan konfigurasi, silakan pindahkan file `Halo.java`  yang kalian buat pada tutorial sebelumnya ke dalam folder “TutorialDDP2”.
              
8.  Setelah itu, jalankan perintah `git status` pada _command prompt/shell_, maka nanti akan muncul daftar _untracked files_ dari folder tersebut. Oleh karena itu, jalankan perintah `git add <nama-file>` untuk setiap _untracked files_.
                 
9.  Setelah itu, jalankan perintah `git commit -m “<isi-dengan-pesanmu>”`. Hal tersebut berfungsi sebagai penanda terhadap perubahan yang terjadi di dalam files yang kamu buat sebelumnya. 
                    
10. Dengan begitu, kamu sudah berhasil mengimplementasikan Git di _local repository_. Untuk tahapan berikutnya, 
    kamu akan membagikan hasil kerjamu kepada orang lain melalui GitLab, yang terkoneksi dengan local repository yang 
    kamu miliki. Buka [GitLab](https://gitlab.com) melalui browser kalian.
                        
11. Buat sebuah project baru, kamu bisa atur nama project sesukamu, dan atur _Visibility Level_ menjadi **Private**, 
    sehingga hasil pekerjaan kalian tidak bisa dimanfaatkan pihak yang tidak bertanggung jawab.
                           
12. Silakan tekan tombol copy yang berada di sebelah baris yang berisi link menuju repository kamu.
                                
13. Buka kembali _command prompt/shell kamu_, lalu ketikkan perintah:
    
    ```git
    git remote add origin <CLONEURL>
    ```
    
    <CLONEURL> diganti dengan link yang sudah kamu copy sebelumnya. Contoh:
    
    ```git
    git remote add origin https://gitlab.com/dekdepe/ddp-2.git
    ```
    
    > git remote add origin merupakan perintah untuk menambahkan address/link ke git kalian, dengan format
    >
    > `git remote add <nama link> <branch> <link>` 
    > `origin` biasanya digunakan untuk link repo di gitlab kalian, sedangkan `upstream` biasanya digunakan untuk link
    > _sumber_ seperti repo ini. selebihnya akan dijelaskan nanti yaa.
                                    
14. Jalankan perintah `git remote -v`, maka akan muncul alamat repository kalian di bagian `origin`.
                                        
15. Setelah itu, buka repository resmi dari perkuliahan DDP 2 di GitLab melalui link 
    [ini](https://gitlab.com/DDP2-Ekstensi-CSUI/ddp-lab). Setelah itu, lakukan hal 
    yang sama seperti pada langkah nomor 12.
                                            
16. Buka kembali _command prompt/shell_ kamu, lalu ketikkan perintah:
    
    ```git
    git remote add upstream <CLONEURL>
    ```
    
    <CLONEURL> diganti dengan link yang sudah kamu copy sebelumnya. Contoh:
    
    ```git
    git remote add upstream https://gitlab.com/DDP2-Ekstensi-CSUI/ddp-lab
    ```
                                               
17.  Jalankan perintah `git remote -v`, maka akan muncul alamat repository kalian di bagian origin dan alamat 
     repository resmi DDP 2 di bagian upstream.

19. Untuk meng-_"upload"_ hasil pekerjaan kalian, setelah kalian lakukan perintah `add` dan `commit` seperti petunjuk 
    diatas. ketik perintah `git push origin master` untuk menyimpan file yang kalian telah `commit` sebelumnya ke repo 
    dengan nama `origin` (yaitu repo kalian)
    
    > perintah `push` memiliki format `git push <nama link> <branch>`

>Perhatian
>
>Jika terdapat poin yang tidak dimengerti pada penjelasan Soal Tutorial Git, harap segera bertanya kepada asisten atau 
teman kalian, agar kalian tidak tertinggal.

#### Latihan :

1. Menurutmu, kenapa kita menggunakan Git pada DDP 2 kali ini?
    
2. Menurutmu, apa saja keuntungan yang diperoleh jika kita menggunakan Git sejak perkuliahan DDP 2?
        
3. Sebutkan 5 perintah Git!

4. Jelaskan apa yang dilakukan kelima perintah Git yang sudah disebutkan di atas!

---

## Chapter 1 : Kucing Kesayangan

Amir merupakan mahasiswa Fasilkom UI yang baru belajar bahasa pemrograman Java. Setelah mempelajari Java, ia memiliki
ide untuk membuat kelas yang menyimulasikan kucing-kucing yang ia miliki. Dalam kelas tersebut, rencananya setiap 
`Kucing` akan memiliki `nama`, `ras`, dan `umur` dalam hari. Selain itu, setiap kucing dapat `berjalan`, `mengeong`, dan `tidur`.

Setelah selesai merancang spesifikasi kelas tersebut, ia berencana untuk segera membuatnya, namun ia baru ingat bahwa
makanan untuk kucing-kucingnya telah habis dan ia harus segera membeli makanan untuk kucingnya sebelum kucing-kucing
tersebut memberontak. Amir pun meminta bantuan Anda untuk menyelesaikan kelas yang ingin ia buat. Karena Anda merupakan
teman yang baik hati, maka Anda pun bersedia menyelesaikan kelas tersebut.

Sebelum pergi, Amir meninggalkan ketentuan untuk method pada kelasnya agar Anda memiliki gambaran yang lebih jelas 
mengenai kelas yang ingin ia buat

1. Method `mengeong()`
   > mengembalikan sebuah String `"Meooooooonnnnnng"`

2. Method `berjalan(int jumlahLangkah)`
   mengembalikan sebuah String
   > "Kucingku, `[nama]` telah berjalan sejauh `[jumlahLangkah]` langkah"

3. Method `tidur()`
   Menambah umur kucing sebanyak 1 hari.

Catatan : Constructor class dibuat dengan urutan parameter `nama`, `ras`, `umur`

Setelah kalian selesai membuatkan kelas tersebut, coba compile kelasnya dan buat fungsi main yang mengakses attribut
pada kelas Anda untuk mengecek kebenaran kelas yang telah dibuat. Pastikan program kalian berjalan dengan baik, 
output sesuai yang diharapkan tanpa ada error. Kalian juga bisa mengecek kebenaran code dengan menjalankan `gradle check` di cmd pada directory repo anda.

Untuk submisi tugas, didalam folder repo kalian terdapat folder `lab_1\src\main\java`, lalu masukkan file `.java` 
dari tugas diatas kedalam folder itu. Lalu add, commit, dan push semua file tersebut ke _online repo_ kalian.

Pastikan file `.class` tidak ikut di push.

---

### Cara Pengumpulan file Kucing.java

**Sebelum membaca bagian ini, kalian sudah harus membaca tutorial bagian `Git`**

Jika kalian sudah membaca tutorial bagian `Git` kalian pasti akan sadar terdapat perintah `git add <nama-file>`
untuk menambahkan file baru dan perintah `git commit -m "<nama-pesan>` untuk menandai perubahan yang terjadi pada
repository. Namun, sebelum kalian menambahkan file Kucing.java, kalian harus membuat repository kalian `up-to-date`
dengan repository `DDP2-Ekstensi-CSUI`. Perhatikan langkah-langkah berikut:

1. Buka command prompt/shell.

2. Ubah directory sekarang menjadi directory dari folder repository Anda.
   >Jalankan perintah `dir` pada windows atau `ls` pada mac untuk melihat file pada directory Anda sekarang  
   >Jalankan perintah `cd <nama-folder>` untuk masuk ke folder yang ada di directory Anda sekarang  
   >Jalankan perintah `cd ..` untuk keluar dari directory Anda sekarang, dan kembali satu level diatasnya,
   >misal Anda berada pada directory `D:\DDP2\Lab-1` setelah melakukan perintah `cd ..` Anda akan berpindah
   >directory `D:\DDP2`

3. Jalankan perintah `git log` lihat apakah terdapat commit di local repository Anda.  
   Kemudian, ketik 	`q` dan enter untuk keluar dari log.
   
4. Jalankah perintah `git pull upstream master` bila **tidak terdapat** commit di local repository Anda.  
   Jalankan perintah `git pull upstream master --allow-unrelated-histories` bila **terdapat** commit di local repository Anda.
   >Hal ini dilakukan untuk menyalin semua file yang terdapat pada repository `DDP2-Ekstensi-CSUI`
   >agar repository kalian `up-to-date` dengan repository `DDP2-Ekstensi-CSUI`

5. Buka online repository kalian di web browser, misal: https://gitlab.com/<UsernameKalian>/<NamaRepoKalian> ,
   pastikan apakah terdapat atau tidak suatu file apapun di online repository kalian.
   
6. **Jika online repository kalian terdapat suatu file didalamnya, jalankan perintah nomor 6 ini**  
   Jalankan perintah `git pull origin master --allow-unrelated-histories`
   >Hal ini dilakukan untuk menggabungkan commit yang telah kalian push ke repository kalian dengan commit yang kalian salin
   >dari repository `DDP2-Ekstensi-CSUI`

7. Pindahkan file `Kucing.java` ke directory `lab_1\src\main\java` pada folder repository Anda

8. Sekarang kalian bisa menambahkan file Kucing.java seperti yang kalian lakukan pada tutorial bagian `Git`
   >Jalankan perintah `git add Kucing.java`

9. Kemudian tandai perubahan yang terjadi seperti yang kalian lakukan pada tutorial bagian `Git`
   >Jalankan perintah `git commit -m "<isi-pesan>"`
   
10. Terakhir, upload hasil pekerjaan kalian seperti yang kalian lakukan pada tutorial bagian `Git`
   >Jalankan perintah `git push origin master`
   
11. **Jika terdapat masalah tanyakan pada asdos Anda**

## Checklist

### Komponen Wajib | 100 Poin

1. Java
    1. [ ] Memahami perbedaan struktur kode Java dan Python.
    2. [ ] Mampu membuat dan menjalankan program Java menggunakan _text editor_ dan _Command Prompt_.
    3. [ ] Memahami perbedaan class dan object
    4. [ ] Membuat instance variable pada program Amir sesuai spesifikasi
    5. [ ] Membuat method pada program Amir sesuai spesifikasi
    
2. Git
    1. [ ] Membuat _Local dan Online Repository_
    2. [ ] Set `origin` dan `upstream`
    3. [ ] Melakukan perintah `add`, `commit`, dan `push`
    
### Komponen Bonus | 10 Poin

_Belum ada bonus yaa hehe :)_

---

### **Woah, apa ini !?**

Ketika kalian meng-push hasil kerja kalian, kalian akan sadar bahwa ada logo cross merah atau centang hijau di samping hasil kerja kalian.

![alt text](https://i.imgur.com/ZNfetmP.png "Ilustrasi git 1")

Kalian mungkin memperhatikan bahwa kita memakai sistem git semester ini. Salah satu guna dari menggunakan git adalah kita bisa menggunakan fitur Continuos Integration?

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