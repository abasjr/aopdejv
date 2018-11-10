# Tutorial 7: Inheritance

Dasar-dasar Pemrograman 2 - CSGE601021 | Fakultas Ilmu Komputer, Universitas Indonesia, Semester Gasal 2018/2019

**Dibuat oleh: AFAI, dimodifikasi dari Tutorial DDP2 2017**

## Tujuan Pembelajaran
1. Memahami *konsep inheritance*
2. Dapat mengimplementasikan konsep *inheritance* menggunakan bahasa java

### Before You Start...
**Jika Memiliki Akses ke Repository Lokal (Misal: Membawa Laptop Sendiri)**
1. Lakukan `git pull upstream master` dengan menggunakan Command Prompt pada folder repository lokal Anda.

**Jika Tidak Memiliki Akses ke Repository Lokal (Misal: Menggunakan Komputer Lab)**
1. Lakukan `git clone <link-repository-Anda>` dengan menggunakan Command Prompt untuk menginisiasi repository lokal berdasarkan
   repository online Anda.  
2. Arahkan Command Prompt ke folder repository lokal yang baru saja diinisiasi.
3. Lakukan `git remote add upstream <link-repository-DDP2>`
4. Lakukan `git pull upstream master`

## Materi Tutorial

### What is inheritance
**Inheritance** dapat didefinisikan sebagai suatu proses di mana satu kelas memerlukan suatu
properti (method atau atribut) dari kelas lainnya. Penggunaan inheritance sebuah informasi data
dapat di-manage dalam struktur hierarchical.
Suatu kelas yang meng-inherit properti dari kelas lain dikenal sebagai subclass dan kelas yang
di-inherit dikenal sebagai superclass.

#### Example of Inheritance
Mari kita coba mengimplmentasikan inheritance pada program sederhana berikut ini
```java
interface HitungBangunDatar {
    void hitungLuas();

    void hitungKeliling();
}

public class ProgramBangunDatar {
    public static void main(String[] args) {
        Persegi persegi = new Persegi(4);
        PersegiPanjang persegiPanjang = new PersegiPanjang(4, 2);
        persegi.hitungLuas();
        persegiPanjang.hitungLuas();
        persegi.hitungKeliling();
        persegiPanjang.hitungKeliling();
    }
}

class BangunDatar implements HitungBangunDatar {
    int hasil;

    public void hitungLuas() {
    }

    public void hitungKeliling() {
    }
}

class Persegi extends BangunDatar {
    int x;

    public Persegi(int x) {
        this.x = x;
    }

    public void hitungLuas() {
        hasil = x * x;
        System.out.println("Luas dari persegi adalah: " + hasil);
    }

    public void hitungKeliling() {
        hasil = x * 4;
        System.out.println("Keliling dari persegi adalah: " + hasil);
    }
}

class PersegiPanjang extends BangunDatar {
    int x, y;

    public PersegiPanjang(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void hitungLuas() {
        hasil = x * y;
        System.out.println("Luas dari persegi panjang adalah: " + hasil);
    }

    public void hitungKeliling() {
        hasil = (2 * x) + (2 * y);
        System.out.println("Keliling dari persegi panjang adalah: " + hasil);
    }
}


```
Perhatikan bahwa kelas Persegi dan *PersegiPanjang* (subclass) meng-inherit kelas *BangunDatar*
(superclass), dan mengambil atribut hasil dan method hitungKeliling() serta hitungLuas() dari
superclass-nya. Cara subclass meng-inherit yaitu dengan keyword `extends`.
Kita juga dapat memanggil method superclass atau mengambil atribut superclass melalui suatu
subclass dengan memakai keyword `super`. Silahkan membuat kode seperti berikut, dan coba kalian
eksekusikan.

```java
# Reference: https://www.tutorialspoint.com/java/java_inheritance.htm
class Super_class {
    int num = 20;
    // display method of superclass
    public void display() {
        System.out.println("This is the display method of superclass");
    }
}

public class Sub_class extends Super_class {
    int num = 10;
    // display method of sub class
    public void display() {
        System.out.println("This is the display method of subclass");
    }
    public void my_method() {
        // Instantiating subclass
        Sub_class sub = new Sub_class();
        // Invoking the display() method of sub class
        sub.display();
        // Invoking the display() method of superclass
        super.display();
        // printing the value of variable num of subclass
        System.out.println("value of the variable named num in sub class:"+ sub.num);
        // printing the value of variable num of superclass
        System.out.println("value of the variable named num in super class:"+ super.num);
    }
    public static void main(String args[]) {
        Sub_class obj = new Sub_class();
        obj.my_method();
    }
}

```
Selain dengan memanggil method dari superclass, kita juga bisa meng-construct superclass dengan
menggunakan method 'super' pada constructor subclass. Silahkan buat program seperti di bawah ini:

```java
class Superclass {
    int age;
    
    Superclass(int age) {
        this.age = age;
    }
    public void getAge() {
        System.out.println("The value of the variable named age in super class is: " +age);
    }
}

public class Subclass extends Superclass {
    Subclass(int age) {
        super(age);
    }
    public static void main(String argd[]) {
        Subclass s = new Subclass(24);
        s.getAge();
    }
}
```
Perhatikan kembali bahwa method super pada constructor kelas *Subclass* digunakan untuk
meng-construct kelas *Superclass*. Ini sangat berguna ketika superclass mempunyai semua atribut
yang ada di subclass sehingga kita hanya perlu memanggil method super.
Dan terakhir, kita juga dapat mengecek apakah suatu kelas merupakan instance dari kelas yang
lain dengan memakai keyword `instanceof`. Silahkan mengimplementasikan program sederhana
berikut untuk lebih memahami fungsionalitas instanceof

```java
# Reference: https://www.tutorialspoint.com/java/java_inheritance.htm
interface Animal{}
class Mammal implements Animal{}
public class Dog extends Mammal {
    public static void main(String args[]) {
        Mammal m = new Mammal();
        Dog d = new Dog();
        System.out.println(m instanceof Animal);
        System.out.println(d instanceof Mammal);
        System.out.println(d instanceof Animal); 
    }
}

```

Perhatikan bahwa output dari program akan menjadi seperti berikut:

true

true

true

Hal tersebut menunjukkan bahwa m merupakan instance dari kelas Animal, dan d merupakan
instance dari kelas Mammal serta Animal. Keyword instance sangat berguna untuk mengetahui
apakah suatu kelas meng-extend suatu kelas atau meng-implement suatu interface.

## Soal Tutorial: To Eat Or To Be Eaten

### What's the story?

Tidak terasa Amir sudah melakukan banyak sekali hal di hari ini, ia tidak mengira bahwa membeli makanan kucing akan
mengantarkan dia ke perjalanan yang sangat panjang. Karena kelelahan, Amir pun memutuskan untuk tidur. Saat tidur,
Amir bermimpi ia menjadi seorang prajurit di sebuah dunia bernama Cat Society. Ternyata, cat society tersebut hanya
dihuni oleh `Kucing`, terdiri dari `Kucing Bangsawan`, `Kucing Rakyat`, dan `Kucing Prajurit`. 
Setelah terbangun dari tidurnya, Amir menceritakan mimpinya pada Anda. Anda yang merasa tertantang pun mencoba 
membuat simulasi dari Cat Society tersebut.

#### Kucing

Setiap kucing memiliki attribut `String name`, `int health`, dan `int power`. Setiap kucing dapat menyerang dengan `attack` dan tidur dengan
`sleep`. Kucing dengan `health` 0 berarti kucing tersebut telah meninggal. Health minimum dari setiap kucing adalah 0,
sehingga jika `Kucing` mendapatkan serangan yang melebihi healthnya, healthnya tetap 0 tidak minus. Status dari setiap
kucing dapat dilihat menggunakan `status`.

- attack(Kucing kucingLain)  
  Ketika seekor kucing A melakukan `attack` ke kucingLain, health dari kucingLain akan berkurang sebanyak power
  kucing A
  
- sleep()  
  Ketika seekor kucing melakukan `sleep`, health nya akan bertambah 20
  
- status()  
  Mengembalikan String status dari kucing dengan format  
  ```
  Nama : [name]
  Health : [health]
  Power : [power]
  ``` 
 

#### KucingBangsawan

Kucing Bangsawan adalah seekor kucing yang terlahir di keluarga kerajaan. Kucing Bangsawan memiliki attribut tambahan 
`String title`. Kucing Bangsawan juga memiliki sebuah hak istimewa untuk mengeksekusi Kucing Rakyat dengan `execute`.

- execute(KucingRakyat kucing)  
  Ketika seekor kucing bangsawan melakukan `execute` ke seekor kucing rakyat, kucing rakyat tersebut akan langsung 
  meninggal.
  
- status()  
  Pada status dari kucing bangsawan terdapat tambahan title.
  
  ```
  Nama : [name]
  Health : [health]
  Power : [power]
  Title : [title]
  ``` 

#### KucingRakyat

Kucing Rakyat adalah rakyat biasa di Cat Society. Seekor kucing rakyat memiliki kesempatan khusus untuk berkontribusi
kepada Cat Society berupa membayar pajak dengan `payTax`.

- payTax()  
  Cat Society dibangun dengan menggunakan energi kehidupan, sehingga ketika seekor kucing rakyat membayar pajak, pajak
  yang dibayarkan bukanlah uang melainkan `health` dari kucing tersebut. Ketika seekor kucing membayar pajak, maka
  `health` nya berkurang sebanyak 20.

#### KucingPrajurit

Kucing Prajurit adalah seekor Kucing Rakyat yang mengabdikan dirinya untuk melindungi Cat Society. Sebagai seekor
Kucing Prajurit, mereka telah mendapatkan pelatihan khusus sehingga `attack` nya lebih kuat dari kucing lainnya.
Ketika Kucing Prajurit melakukan `attack` ke kucing lainnya, maka health dari kucing lain akan berkurang sebanyak
2 kali power Kucing Prajurit.

#### Tambahan

1. Buatlah constructor untuk setiap kelas, dimana setiap attribut pada kelas tersebut menjadi parameter constructornya
   mengikuti urutan parameter sebagai berikut.
   1. nama
   2. health
   3. power
   4. title (khusus untuk KucingBangsawan)
   Contoh : `public KucingRakyat(String name, int health, int power)`

3. Implementasikan setter getter untuk setiap atribut

2. Kucing yang sudah meninggal tidak dapat melakukan apapun, sehingga method selain method `status` dan setter getter yang dipanggil dari 
   kucing yang sudah meninggal tidak akan berdampak apapun. Method `status` tetap akan menampilkan status dari kucing
   yang sudah meninggal.

### Contoh output command

Jalankan CatSociety.java
```java
import character.Kucing;
import character.KucingBangsawan;
import character.KucingRakyat;
import character.KucingPrajurit;

public class CatSociety {
    public static void main(String[] args) {
        KucingBangsawan kucingBangsawan= new KucingBangsawan("Aya", 100, 30, "Empress");
        KucingPrajurit kucingPrajurit= new KucingPrajurit("Rian", 120, 30);
        KucingRakyat kucingRakyat = new KucingRakyat("Salsa", 80, 20);

        System.out.println(kucingBangsawan.status() + "\n");
        System.out.println(kucingPrajurit.status() + "\n");
        System.out.println(kucingRakyat.status() + "\n");
        kucingBangsawan.attack(kucingRakyat);
        kucingRakyat.attack(kucingBangsawan);
        kucingPrajurit.attack(kucingBangsawan);
        System.out.println(kucingBangsawan.status() + "\n");
        System.out.println(kucingPrajurit.status() + "\n");
        System.out.println(kucingRakyat.status() + "\n");
        kucingBangsawan.sleep();
        kucingPrajurit.sleep();
        kucingRakyat.sleep();
        System.out.println(kucingBangsawan.status() + "\n");
        System.out.println(kucingPrajurit.status() + "\n");
        System.out.println(kucingRakyat.status() + "\n");
        kucingRakyat.payTax();
        kucingPrajurit.payTax();
        System.out.println(kucingPrajurit.status() + "\n");
        System.out.println(kucingRakyat.status() + "\n");
        kucingBangsawan.execute(kucingPrajurit);
        kucingBangsawan.execute(kucingRakyat);
        kucingRakyat.sleep();
        kucingPrajurit.sleep();
        System.out.println(kucingPrajurit.status() + "\n");
        System.out.println(kucingRakyat.status() + "\n");
    }
}

```

Output seharusnya adalah :
```
Nama : Aya
Health : 100
Power : 30
Title : Empress

Nama : Rian
Health : 120
Power : 30

Nama : Salsa
Health : 80
Power : 20

Nama : Aya
Health : 20
Power : 30
Title : Empress

Nama : Rian
Health : 120
Power : 30

Nama : Salsa
Health : 50
Power : 20

Nama : Aya
Health : 40
Power : 30
Title : Empress

Nama : Rian
Health : 140
Power : 30

Nama : Salsa
Health : 70
Power : 20

Nama : Rian
Health : 120
Power : 30

Nama : Salsa
Health : 50
Power : 20

Nama : Rian
Health : 0
Power : 30

Nama : Salsa
Health : 0
Power : 20
```

### Hint

- Gunakan access level modifiers protected untuk attribut yang diwariskan.
- Gunakan access level modifiers private untuk attribut yang tidak diwariskan.
- Gunakan access level modifiers public untuk setter getter

#### Bonus  

Buatlah sebuah method tambahan pada kelas Kucing

- history()
  Method ini akan menampilkan seluruh energi kehidupan yang pernah direnggut oleh Kucing beserta nama kucing yang direnggut
  energi kehidupannya. Seekor kucing dikatakan merenggut energi kehidupan apabila tindakannya menyebabkan `health` 
  kucing lainnya berkurang. Method ini tetap bisa dipanggil meski kucing sudah mati.  
  Contoh :
  ```java
  Kucing aya = new KucingRakyat("Aya", 100, 20);
  Kucing salsa = new KucingBangsawan("Salsa", 80, 10, "Empress");
  Kucing rian = new KucingPrajurit("Rian", 120, 30);
  
  salsa.execute(aya);
  System.out.println(salsa.history());
  
  /* Output:
     Aya : 100
  */

  salsa.attack(rian);
  System.out.println(salsa.history());
  /* Output:
     Aya : 100
     Rian : 10
  */

  rian.attack(salsa);
  System.out.println(rian.history());
  /* Output:
     Salsa : 60
  */

  rian.attack(salsa);
  System.out.println(rian.history());
  /* Output:
     Salsa : 60
     Salsa : 20
  */
  ``` 

### Komponen Wajib | 100 Poin

- [ ] **Mengimplementasikan class-class yang diminta (boleh mengimplementasikan lebih dari yang diminta)**
- [ ] **Mengimplementasikan atribut-atribut yang sesuai pada setiap class**
- [ ] **Mengimplementasikan setiap method sesuai dengan kebutuhan soal**

### Komponen Bonus | 10 Poin

- [ ] **Implementasikan fungsi history()**

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
