# **Tutorial 10: Exception dan GUI (Soal Tutorial)**

Dasar-dasar Pemrograman 2 - CSGE601021 | Fakultas Ilmu Komputer, Universitas Indonesia, Semester Genap 2017/2018

**Dibuat oleh DZ | TYB**

* * *
Pada tutorial kali ini, kita akan mempelajari cara melakukan *input* dan *output* menggunakan *file* serta bagaimana kita bisa melakukan serta mendefinisikan sendiri *exception* yang berguna untuk menghindari hal-hal yang tidak diinginkan. Selain itu kita juga akan belajar untuk membangun GUI kita sendiri untuk memudahkan *user* dalam menggunakan aplikasi yang kita buat.

## **Tujuan Pembelajaran**
1. Memahami dan dapat menggunakan *Files*
2. Memahami konsep, penggunaan, dan jenis-jenis *Exception* dan *Error*
3. Memahami penggunaan perintah *Try, Catch, Finally*
4. Memahami konsep *Defensive Programming*
5. Memahami penggunaan Javax Swing Package untuk membangun GUI

### **Before You Start...**
1. Lakukan `git pull upstream master` dengan menggunakan Command Prompt pada folder repository lokal Anda.
2. Kerjakan soal tersebut kemudian letakkan file jawaban anda di folder `lab_10/src/main/java`. Kami sudah menyediakan folder kosong untuk kamu.
3. Setelah selesai mengimplementasikan kode tersebut, lakukan add, commit, dan push code kalian tersebut.

## **Materi Tutorial**

Catch IntroductionNotFoundException! Materi pada tutorial kali ini berisi mengenai *Files, Exception* dan *Error*, konsep *Defensive Programming* dan GUI dengan *Swing*.

### **Files**

#### Input

Terdapat beberapa cara untuk melakukan, namun cara termudahnya adalah dengan menggunakan class `File` yang kemudian dimasukkan ke dalam Scanner.
```java
public static void main(String[] args) {

        try {
            System.out.print("Enter the file name with extension : ");

            Scanner input = new Scanner(System.in);

            File file = new File(input.nextLine());

            input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
```
Cara lain dapat menggunakan FileReader yang bisa kalian cari sendiri.

#### Output

Cara untuk melakukan *output* ke suatu *file* juga dapat dilakukan dengan banyak cara. Untuk yang mudah, dapat menggunakan `FileWriter`. Pembuatan objek FileWriter dapat dilakukan dengan memasukkan objek File sebagai parameter atau dengan sebuah String *path* menuju *file output* sebagai parameter.
```java
public static void main(String args[])throws IOException {
    File file = new File("contoh.txt");
    file.createNewFile();
    
    FileWriter writer = new FileWriter(file); 
    
    writer.write("Ini adalah sebuah\nC O N T O H"); 
    writer.flush();
    writer.close();
}
```
Objek FileWriter **WAJIB** dilakukan `flush` atau `close` untuk menyimpan nilai yang tersimpan dalam *buffer* ke dalam *file* sebenarnya.

Referensi:
- https://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java
- https://www.tutorialspoint.com/java/java_filewriter_class.htm

### **Throwing Exceptions**

#### Throw
*Keyword* ***throw*** dalam Java digunakan untuk melemparkan *exception* secara eksplisit pada *method* atau suatu blok kode. *Keyword* ***throw*** biasanya digunakan untuk melemparkan *exception* buatan sendiri (*custom exception*). Berikut ini adalah cara menggunakan ***throw***:
```java
throw <instance>

// Contoh:
throw new ArithmeticException("Pembagian dengan nol");
```
Pada contoh di atas, blok kode yang mengandung *throw* tersebut akan menghasilkan sebuah *exception* bernama ArithmeticException. *Exception* tersebut kemudian bisa di-*handle* oleh yang menggunakan *method* yang mengandung potongan program tersebut dengan melakukan *try-catch* yang akan dijelaskan pada submateri [Try, Catch, Finally](#catching-exceptions).

*Instance class* yang bisa dilemparkan oleh ***throw*** haruslah merupakan *subclass* dari *class* Throwable. Biasanya, *class exception* buatan sendiri dibuat dengan meng-*extend class* Exception atau RuntimeException karena kedua *class* tersebut sudah merupakan *subclass* dari Throwable. 

Untuk membuat *class exception* sendiri lebih lanjut dijelaskan pada submateri [Mendesain Exception](#exception-design).

#### Throws
***Throws*** merupakan salah satu cara untuk meng-*handle* kemunculan *exception* selain menggunakan *try-catch*. Dengan menggunakan ***throws***, *exception* yang muncul pada suatu blok kode dalam suatu *method* akan dilemparkan lagi menuju kode yang memanggil *method* tersebut. Dengan demikian, biarkan yang menggunakan *method* tersebut yang melakukan *handle* lebih lanjut dari *exception* yang telah muncul.

Berikut contoh cara penggunaan ***throws***:
```java
public int divide(int a, int b) throws ArithmeticException {
       int result = a / b; // Akan terjadi exception ketika b bernilai 0.
       return result;
}
```
Pada contoh di atas, *exception* akan dilemparkan dari hasil pembagian ketika peubah b bernilai 0. Kemudian kita melakukan *handle* dengan cara melemparkan lagi *exception* tersebut keluar *method* kepada kode yang melakukan pemanggilan *method* `divide` (saat ini kita tidak perlu memikirkan dulu bagaimana nanti *exception* tersebut di-*handle* oleh kode yang memanggil *method* `divide` tersebut). Dengan demikian, seakan-akan *method* `divide` lah yang menghasilkan *exception* tersebut.
```java
public static void main(String[] args) {
       // Akan terjadi exception seakan-akan dihasilkan oleh method divide
       int x = divide(5, 0);
}
```
Akan tetapi, perlu dicatat bahwa ***throws*** biasanya lebih sering digunakan untuk *checked exception*, seperti IOException, dibandingkan pada *unchecked exception* dikarenakan rasanya penggunaanya tidak bermakna.

Referensi: https://www.geeksforgeeks.org/throw-throws-java/

![Throwable class inheritance](https://u.catgirl.host/bn9z3.png)

### **Checked and Unchecked Exceptions**

#### Checked Exceptions

***Checked Exceptions*** merupakan *exception* yang diperiksa saat waktu kompilasi. Jika suatu potongan kode dapat melemparkan *checked exception*, maka pada blok kode program tersebut harus melakukan *handle exception* tersebut bisa dengan *try-catch* maupun *throws*. Apabila *exception* tersebut tidak di-*handle*, maka akan terjadi *compile error* saat melakukan kompilasi.

#### Unchecked Exceptions

***Unhecked Exceptions*** merupakan *exception* yang tidak diperiksa saat waktu kompilasi. Dengan demikian, *compiler* tidak akan memaksa kita untuk meng-*handle exception* yang sewaktu-waktu dapat muncul tersebut. Penanganannya kembali ke si *programmer* apakah ia ingin menanganinya atau tidak.

Pada Java, *class exception* yang termasuk ke dalam *unchecked exceptions* adalah *class* Error dan RuntimeException beserta *subclass*-nya, selain itu, semua yang di bawah *class* Throwable, merupakan *checked exceptions*.

![Checked and unchecked exceptions](https://u.catgirl.host/2olda.png)

Referensi:
- https://www.geeksforgeeks.org/checked-vs-unchecked-exceptions-in-java/
- https://stackoverflow.com/questions/29763315/java-checked-and-unchecked-exceptions


### <a name="catching-exceptions"></a>**Try, Catch, Finally**

*Catching* merupakan salah satu cara yang dapat dilakukan untuk menangani *exception* yang muncul. Untuk melakukan *catching exceptions*, kita akan mengenal dengan yang namanya **blok _Try_** dan **blok _Catch_**. Pada blok *try* berisi potongan program yang dapat memunculkan *exception*. Sedangkan pada blok *catch*, berisi perintah-perintah yang dilakukan ketika menangani *exception* yang muncul pada blok *try*. *Catch* dapat ditulis berkali-kali dengan menangkap berbagai jenis *exception* yang berbeda-beda.
```java
class Example1 {
   public static void main(String args[]) {
      int num1, num2;
      try {
         // Kita memprediksi akan terjadi exception pada blok ini
         // dengan begitu kita memasukkannya ke dalam blok try.
         num1 = 0;
         num2 = 62 / num1;
         System.out.println(num2);
         System.out.println("Hey I'm at the end of try block");
      }
      catch (ArithmeticException e) { 
         // Blok ini hanya akan terjadi ketika Arithmetic Exception muncul
         System.out.println("You should not divide a number by zero");
      }
      catch (Exception e) {
         // Blok ini menangkap Exception umum, akan dieksekusi ketika
         // ada exception yang belum ter-handle oleh catch sebelum-sebelumnya
         System.out.println("Exception occurred");
      }
      System.out.println("I'm out of try-catch block in Java.");
   }
}
```
Selain blok *try* dan *catch*, terdapat satu blok lagi yang disebut dengan ***finally***. Blok *finally* akan selalu tereksekusi ketika keluar dari blok *try*. Hal ini memastikan bahwa perintah-perintah yang berada di dalam blok *finally* akan selalu tereksekusi meskipun nanti ternyata muncul *exception* yang tidak terduga. Kegunaan *finally* lebih dari hanya *handling exception*. *Finally* bisa memungkinkan *programmer* menghindari kode *cleanup* terlewati karena *return*, *continue*, atau *break*. Meletakkan kode *cleanup* di dalam blok *finally* merupakan praktik yang bagus meskipun tidak akan muncul *exception*.

```java
try {
    int n = Integer.parseInt(scanner.nextLine());
}
catch (NumberFormatException e) {
    System.out.println("Tried to parse non integer.");
}
finally {
    // Kode di dalam sini akan selalu tereksekusi
    System.out.println("Finally, it's here!");
}
```

Referensi:
- https://beginnersbook.com/2013/04/try-catch-in-java/
- https://docs.oracle.com/javase/tutorial/essential/exceptions/finally.html

### <a name="exception-design"></a>**Mendesain Exception**

Pada materi sebelumnya, telah diketahui bagaimana *throwing exception* beserta *checked* dan *unchecked exception*. Untuk membuat *exception class* kita sendiri (*custom exception class*), cukup membuat *class* pada umumnya namun dengan meng-*extends Exception class* atau *subclass*-nya. *Unchecked custom exception class* dibuat dengan meng-*extends* *RuntimeException* dan *subclass*-nya sedangkan *checked* meng-*extends Exception* dan *subclass*-nya yang bukan *RuntimeException*.

Berikut contoh pembuatan *checked exception class*:
```java
class UnfitAnimalException extends Exception {
   public UnfitAnimalException(String message) {
       super(message);
   }
}
//throw new UnfitAnimalException("The parrot can’t perform attraction")
```
Berikut contoh pembuatan *unchecked exception class*:
```java
class VisitorExceededException extends RuntimeException {
   public VisitorExceededException(String message) {
       super(message);
   }
}
//throw new VisitorExceededException("Attraction can’t exceed 1000 visitors")
```

### **Defensive Programming**

*Defensive programming is a form of defensive design intended to ensure the continuing function of a piece of software in spite of unforeseeable usage of said software. The idea can be viewed as reducing or eliminating the prospect of Murphy’s Law having effect. Defensive programming techniques are used especially when a piece of software could be misused mischievously or inadvertently to catastrophic effect. (...yes Wikipedia).*

Inti dari *Defensive Programming* adalah prinsip yang menyatakan bahwa sebuah program pasti akan menjumpai *error* sehingga sebisa mungkin harus diberikan tindakan preventif untuk segala kemungkinan yang dapat terjadi.
```java
public void printName(Person person) {
    print(person.getIdentity().getName());
}
//Dengan defensive programming
public void printName(Person person) {
   if (person == null) {
       print("The person cannot be found");
   } else if(person.getIdentity() == null) {
       print("This person doesn’t have integrity");
   } else {
       print(person.getIdentity().getName());
   }
}
```

### **Javax Swing Package**

*Package* javax.swing berisi kumpulan *class* yang berfungsi untuk pembuatan *Graphical User Interface* atau GUI di Java. *Abstract Windowing Toolkit* atau AWT yang berada pada java.awt juga berisi kumpulan class untuk membangun GUI; digunakan sebelum adanya implementasi Swing. *Swing* dibangun di atas AWT memberikan penambahan fitur dan fleksibilitas dalam pembuatan GUI. Prinsip dasar penggunaan *Swing* adalah penambahan *Component* di dalam *Component*. Sebagai contoh adalah penempatan JButton di dalam JFrame yang keduanya merupakan *Component*.

![Example of Layouts](https://u.catgirl.host/g7fua.png)

LayoutManagers digunakan untuk mengatur tata letak Component sesuai dengan tata letak tertentu. Terdapat BorderLayout (kiri), GridLayout (tengah), FlowLayout (kanan), serta LayoutManager lainnya.

**Latihan!** Buatlah implementasi BorderLayout, GridLayout, dan FlowLayout menggunakan *Swing*! 

# **Soal Tutorial: Secret Mission**

### **What's the story?**

Pada suatu hari Dek Depe diundang seseorang bernama si Z untuk datang ke suatu acara. Dek Depe yang ikut datang ke acara si Z melihat sebuah kotak aneh di acara tersebut. Ketika membuka kotak tersebut ternyata terdapat pesan rahasia bertuliskan suatu *string* yang terlihat *random* sehingga tidak mengerti maksudnya apa. Dek Depe menyimpan pesan tersebut dan dibawa ke rumah.

Saat di rumah, Dek Depe mencoba menginvestigasi apa maksud dari tulisan tersebut. Setelah dicari ternyata pesan itu dibuat oleh seseorang bernama LEN. Ternyata LEN dan Z adalah intelijen. Mereka berdua saling berkirim pesan dengan penggunaan enkripsi.

 Enkripsi adalah proses mengamankan suatu informasi dengan membuat informasi tersebut tidak dapat dibaca tanpa bantuan pengetahuan khusus. Enkripsi yang digunakan oleh LEN dan Z ternyata menggunakan algoritma enkripsi yang tidak pernah di-*publish* di mana-mana. Enkripsi ini menggunakan suatu algoritma yang bernama Xoxo Encryption yang dikembangkan bertahun-tahun oleh dua orang *computer scientist* yang memiliki *codename* DZ dan TYB.

 Xoxo Encryption adalah suatu algoritma enkripsi yang menggunakan dua *key*. Key yang pertama disebut dengan Kiss Key yang digunakan untuk melakukan enkripsi. Key yang satu lagi disebut Hug Key yang digunakan untuk melakukan dekripsi. Kedua *key* ini saling berpasangan sehingga pesan yang dienkripsi menggunakan Kiss Key hanya bisa didekripsi dengan Hug Key pasangan dari Kiss Key tersebut. Selain itu juga terdapat suatu *seed* yang juga merupakan sepasang dengan Hug Key untuk melakukan dekripsi.

 Dek Depe berhasil menemukan kode Xoxo Encryption tersebut, namun kode tersebut hanya berisi cara melakukan enkripsinya saja. Dek Depe akhirnya meminta Anda untuk melakukan riset cara mendekripsi pesan tersebut menggunakan Xoxo Encryption.

### **Spesifikasi**

Anda diberikan *template* program untuk melakukan enkripsi dan dekripsi pesan menggunakan Xoxo Encryption. Berikut adalah *checklist* yang perlu Anda lakukan:
- Membuat *method* untuk mendekripsi pesan
- Membuat dan melemparkan *exceptions*
- Membuat GUI dan simpan hasil pada *file*
- Menangani *exceptions* dengan GUI

#### Dekripsi Pesan

Terdapat file `xoxo/crypto/XoxoDecryption.java`. Anda diminta untuk mengisi *method* `decrypt`. Setelah Anda melakukan riset, ternyata Anda menemukan algoritma untuk melakukan dekripsi. Dekripsi dilakukan dengan cara berikut:

1. Lakukan *looping* sebanyak panjang pesan,
2. Untuk setiap karakter pada Hug Key di index `i % hugKeyString.length()` lakukan xor dengan `seed`,
3. Lakukan operasi pengurangan hasil yang didapat pada langkah 2 dengan karakter `'a'`,
4. Untuk setiap karakter pada pesan di index ke-`i` lakukan xor dengan nilai yang didapat pada langkah 3,
5. Gabungan dari setiap hasil karakter dalam bentuk `char` pada langkah 4 merupakan hasil dekripsi, kembalikan hasil gabungan tersebut sebagai `String`.

**NOTE:** Gunakan operator `^` untuk melakukan operasi xor.

#### Throwing Exceptions

Anda diminta untuk melengkapi semua *class* yang pada `xoxo/exceptions/`. Setelah semua *class* Anda implementasi, lakukan pelemparan *exceptions* tersebut pada *class* `XoxoEncryption` dan `XoxoDecryption` dengan *requirements* sebagai berikut:

- Ukuran *message* maksimal 10 Kbit
- Panjang *key* maksimal 28 karakter
- String Kiss Key hanya boleh mengandung huruf `A-Z`, `a-z`, dan karakter `@`
- Seed merupakan angka di antara 0-36 (*inclusive*)

Apabila terjadi hal-hal di luar *requirements* tersebut, maka lemparkan *exception* yang sesuai.

#### Membuat GUI

Untuk memudahkan *user*, Anda diminta membuat GUI. Pembuatan GUI dilakukan pada `xoxo/XoxoView.java`. Untuk implementasi logika dilakukan pada `xoxo/XoxoController.java`.

Berikut adalah beberapa komponen yang wajib ada dalam GUI Anda:
- 3 JTextField untuk *input* pesan, key, dan seed
- 2 JButton untuk melakukan enkripsi dan dekripsi
- 1 JTextArea untuk menuliskan log

Dalam *class* XoxoView, sudah diberikan beberapa *method* yang membantu Anda untuk bertukar data (seperti pesan atau key) antara logika dengan GUI.

| Method | Kegunaan |
|-|-|
|getMessageText|Mengambil *input* pesan dari GUI|
|getKeyText|Mengambil *input* key dari GUI|
|getSeedText|Mengambil *input* seed dari GUI|
|appendLog|Menambahkan suatu teks ke dalam log di GUI|
|setEncryptButton|Menerima sebuah ActionListener yang berisi logika untuk melakukan enkripsi agar bisa dilakukan pada tombol di GUI|
|setDecryptButton|Menerima sebuah ActionListener yang berisi logika untuk melakukan dekripsi agar bisa dilakukan pada tombol di GUI|

Anda dapat menggunakan *method-method* tersebut dalam *class* `XoxoController` melalui *instance* XoxoView.

Simpan hasil enkripsi atau dekripsi Anda ke dalam sebuah file dengan ekstensi `.enc` untuk hasil enkripsi dan `.txt` untuk hasil dekripsi.

#### Menangani *exceptions* dengan GUI

Sebelumnya Anda telah membuat dan melempar *exceptions*. Sekarang dengan memanfaatkan GUI, tangani *exceptions* tersebut dengan memunculkan *alert dialog* dengan memanfaatkan komponen `JOptionPane`.

### Contoh Hasil Enkripsi dan Dekripsi

#### Enkripsi

Jenis key: **Kiss Key**

|Pesan|Key|Seed|Enkripsi|
|-----|---|----|--------|
|Love|live|DEFAULT_SEED|Ggca|
|Saya di Fasilkom|ddp|DEFAULT_SEED|Pbvb#kj#Ibpfoh`n|
|Besok_Jam_3|kencan|32|Ha~mkR@e`]3|
|FN P90|pchan|28|IL'P4?|
|DDP memang mudah|bohong|50|EJW.`cloii-ktjff|

#### Dekripsi

Jenis key: **Hug Key**

|Pesan Terenkripsi|Key|Seed|Pesan Asli|
|-----|---|----|--------|
|&#124;ioswf!vwk\`|e{pg|DEFAULT_SEED|jangan baca|
|fmfpo3s\`c1tvael1vrzeqxe|awq\`wf|DEFAULT_SEED|tidak ada pesan rahasia|
|ﾏﾋﾞﾜﾅￍﾉﾇￍﾞﾏﾟﾊﾁ|mlmwlm|35|besok di margo|
|gi-verjl-g\`p#bbk|x}r{yn|28|di pacil ada bom|
|ﾹﾅﾁﾛￆﾌﾇﾈﾙﾝￆﾄﾖﾔ|RDLNF@|1|Kamu lulus ddp|


**NOTE:** Algoritma ini masih belum sempurna, apabila Anda melakukan *test case* sendiri dengan melakukan enkripsi kemudian mendekripsikannya kembali, mungkin ada beberapa informasi yang hilang atau rusak. Sementara ini yang penting Anda bisa mengimplementasikannya.

## Bonus

Sewaktu riset mencari cara mendekripsi menggunakan Xoxo Encryption, Anda menemukan suatu repositori di GitLab yang berisi *file-file* dengan ekstensi .enc. Ketika Anda buka menggunakan Notepad, Anda melihat *file-file* tersebut berisi pesan-pesan yang telah terenkripsi. Melihat ternyata pemilik repositori tersebut adalah LEN, Anda tahu bahwa *file* tersebut terenkripsi menggunakan Xoxo Encryption.

Dengan begitu, Anda mencoba untuk mengembangkan lagi program Anda agar bisa menginput menggunakan *file* saja karena rasanya malas untuk *copy-paste* semua isi *file*.

### Spesifikasi ###

Buatlah agar GUI dapat menerima *input file* dengan memanfaatkan komponen `JFileChooser`.

## Checklist
Isi kurung siku komponen dengan x untuk menceklis komponen.
### Komponen Wajib | 100 Poin
- [ ] **Implementasi seluruh hal yang diminta pada soal**
- [ ] **Implementasi keluaran dengan FileWriter**
- [ ] **Implementasi method dekripsi sesuai yang diminta**
- [ ] **Membuat dan memakai *Exception* pada program dengan baik**
- [ ] **Implementasi GUI untuk keseluruhan program**
- [ ] **Handle _exception_ dan tampilkan pada GUI menggunakan JOptionPane**

### Komponen Bonus | 10 Poin
- [ ] **Implementasi masukan menggunakan File dan komponen GUI JFileChooser** (5)
- [ ] **Implementasi konsep *defensive programming* yang matang** (2)
- [ ] **Implementasi estetika GUI yang baik dan enak dipandang mata** (3)


-----
### **Woah, apa ini !?**

Ketika kalian meng-push hasil kerja kalian, kalian akan sadar bahwa ada logo cross merah atau centang hijau di samping hasil kerja kalian.

![alt text](https://i.imgur.com/ZNfetmP.png "Ilustrasi git 1")

Kalian mungkin memperhatikan bahwa kita mulai memakai sistem git sejak semester 2, mengikuti kakak angkatan kalian yang baru mulai memakai sistem git sejak semester 3. Salah satu guna dari menggunakan git adalah kita bisa menggunakan fitur Continuous Integration?

Apa itu Continuous Integration? Continuous Integration adalah konsep di mana ketika kalian push, hasil push kalian langsung di build (compile) dan di test (uji langsung). Jika gagal, kalian akan diberitahu.

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
