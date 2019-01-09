public class Member{
  private int nomorMember;
  private String nama;
  private int umur;
  private int saldo;
  private boolean memberTutup;

  public Member(int nomorMember, String nama, int umur){
    this.nomorMember = nomorMember;
    this.nama = nama;
    this.umur = umur;
    this.saldo = 50000;
  }

  // Overloading Contructor
  public Member(int nomorMember, String nama, int umur, int saldo){
    this.nomorMember = nomorMember;
    this.nama = nama;
    this.umur = umur;
    this.saldo = saldo;
  }

  public int getNomorMember(){
    return nomorMember;
  }

  public String getNama(){
    return nama;
  }

  public int getSaldo(){
    return saldo;
  }

  public boolean isMemberTutup(){
    return memberTutup;
  }

  public void setUmur(int umur){
    this.umur += umur;
    if (umur > 49){
      System.out.println(getNama() + " terlalu tua untuk menjadi member");
      System.out.println("Member atas nama " + nama + " telah resmi ditutup");
      this.memberTutup = true;
    }
    else
      System.out.println("Umur Bertambah");
  }

  public int getUmur(){
    return this.umur;
  }

  public String toString(){
    String cetakBiodata = (isMemberTutup() == true) ?
      "Member atas nama "+getNama()+" telah ditutup\n":
      "Nomor Member  : "+getNomorMember()+"\nNama          : "+getNama()+"\nUmur          : "+getUmur()+ "\nSaldo         : "+getSaldo();
    return cetakBiodata;
  }

  public void kirimSaldo(Member penerima, int uang){
    this.saldo -= uang;
    penerima.saldo += uang;
    System.out.println(nama + " telah berhasil mengirim saldo ke " + penerima.getNama()+ " sebesar " + uang);
    System.out.println("Saldo " + getNama() + " saat ini " + getSaldo());
    System.out.println("Saldo " + penerima.getNama() + " saat ini " + penerima.getSaldo());
  }

  public void topUpSaldo(int uang){
    if (isMemberTutup() == true){
      System.out.println("Member atas nama " + getNama() + " telah ditutup");
    }
    else {
      this.saldo += uang;
      System.out.println( getNama() + " berhasil top up saldo" );
      System.out.println("Saldo " + getNama() + " saat ini " + getSaldo());
    }
  }

  public void tutupMember(){
    this.memberTutup = true;
    System.out.println("Member atas nama " + this.nama + " telah resmi ditutup");
  }
}
