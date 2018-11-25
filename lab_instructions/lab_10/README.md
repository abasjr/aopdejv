# **Tutorial 10: Exception Handling (Soal Tutorial)**

Dasar-dasar Pemrograman 2 - CSGE601021 | Fakultas Ilmu Komputer, Universitas Indonesia, Semester Genap 2018/2019

**Dibuat oleh: AR, dimodifikasi dari Tutorial DDP2 2017**

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



# **Soal Tutorial: Cat Adopt**

### **What's the story?**
Tidak terasa 2 bulan telah berlalu, kini kucing Amir sudah sangat banyak. Amir semakin sulit untuk merawat kucing-kucing tersebut. Amir memiliki ide untuk membuka toko adopsi kucing. Amir meminta bantuan anda untuk membuat program yang dapat mencatat detail adopsi setiap harinya. Data adopsi diperoleh dari sebuah file .txt yang nama filenya diinput manual oleh user. Amir memiliki 5 jenis kucing yang dapat diadopsi, yaitu Savannah, Bengal, Peterbald, Sphynx, dan Scottish.

Setiap jenis kucing memiliki biaya perawatan berbeda-beda (juta) :
- Savannah (700)
- Bengal (300)
- Peterbald (70)
- Sphynx(50)
- Scottish (40)

Amir menyediakan 2 tipe pembayaran yaitu Angsur dan Tunai. Harga diatas berlaku untuk Tunai, sedangkan untuk Angsur dikenakan biaya admin 1 juta.


### **Format Masukan**

Masukan dibaca dari sebuah file .txt yang berisi data adopsi pada suatu tanggal. Baris pertama file input berisi tanggal adopsi dengan format dd/mm/yyyy. Tanggal dianggap valid selama mengikuti format tersebut, sehingga 30/02/2018 merupakan tanggal yang valid. Baris selanjutnya berisi jenis kucing, tipe pembayaran (A untuk Angsur dan T untuk Tunai), serta biaya perawatan yang harus dibayar pelanggan sebelum ditambah biaya admin (tidak perlu menuliskan keterangan juta, cukup 300 atau 40). Sehingga formatnya adalah :

> **[jenis kucing][spasi][A/T][biaya perawatan]**

### **Contoh Masukan**
<pre>

11/11/2018
Savannah A700
Bengal T300
Bengal A300
Peterbald T70

</pre>


### ***Format Keluaran*

Cukup tampilkan di layar tanggal adopsi, total biaya perawatan pada tanggal tersebut, dan rinciannya untuk setiap jenis kucing.

### **Contoh Keluaran**
<pre>

Savannah :
11/11/2018 Total Biaya Perawatan = Rp 701,000,000 (701)

Bengal :
11/11/2018 Total Biaya Perawatan = Rp 601,000,000 (300 + 301)

Peterbald :
11/11/2018 Total Biaya Perawatan = Rp 70,000,000 (70)

</pre>


#### Throwing Exceptions

Dalam tutorial ini terdapat beberapa eksepsi yang perlu diperhatikan dan ditangani, yaitu :

> 1. **FileNotFoundException**, bila file input tidak ada maka program akan memberikan pesan pada layar sbb: “File tidak ditemukan”.
> 2. **NumberFormatException** , dapat terjadi pada penulisan tanggal (mis: 14 menjadi 1A atau 10 menjadi iO). Untuk kesalahan pada tanggal maka program akan memberi pesan pada layar sbb: “Terdapat kesalahan penulisan tanggal” dan program akan berhenti. Perlu dicek juga pada penulisan biaya perawatan (mis: A50 menjadi VS0), maka program akan memberi pesan pada layar sbb : “Terdapat kesalahan penulisan nominal” dan program akan berhenti.
> 3. **IOException**, program akan memberi pesan “Ada error”.


## Bonus
Keluaran dibuat ke file-file untuk setiap tanggal dengan format [jenis kucing].txt kemudian tampilkan tanggal adopsi, total biaya perawatan pada tanggal tersebut, dan rinciannya untuk setiap jenis kucing.

### **Contoh Keluaran**

Savannah.txt
>11/11/2018 Total Biaya Perawatan = Rp 701,000,000 (701)

.

Bengal.txt
>11/11/2018 Total Biaya Perawatan = Rp 601,000,000 (300 + 301)

.

Peterbald.txt
>11/11/2018 Total Biaya Perawatan = Rp 70,000,000 (70)


## Checklist
Isi kurung siku komponen dengan x untuk menceklis komponen.
### Komponen Wajib | 100 Poin
- [ ] **Implementasi seluruh hal yang diminta pada soal**
- [ ] **Terima input dari file**
- [ ] **Bedakan Angsur dan Tunai**
- [ ] **Buat perhitungan Total Biaya Perawatan dengan tepat**
- [ ] **Handle _exception_**

### Komponen Bonus | 10 Poin
- [ ] **Implementasi keluaran dengan FileWriter**
