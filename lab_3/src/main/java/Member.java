/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Royya
 */
public class Member {
    private int nomorMember;
    private String nama;
    private int umur;
    private int saldo;
    public static int banyakMember;
    private boolean tutupMember;
    
    public Member(int nomorMember, String nama, int umur, int saldo) {
        this.nomorMember = nomorMember;
        this.nama = nama;
        this.umur = umur;
        this.saldo = saldo;
        banyakMember++;
        this.tutupMember = false;
    }

    public Member(int nomorMember, String nama, int umur) {
        this.nomorMember = nomorMember;
        this.nama = nama;
        this.umur = umur;
        this.saldo = 50000;
        banyakMember++;
        this.tutupMember = false;
    }

    public int getNomorMember() {
        return nomorMember;
    }

    public void setNomorMember(int nomorMember) {
        this.nomorMember = nomorMember;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        if(umur > 50){
            System.out.println(this.nama + " terlalu tua untuk menjadi member");
            tutupMember();
        }
        this.umur = umur;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public boolean isTutupMember() {
        return tutupMember;
    }

    public void setTutupMember(boolean tutupMember) {
        this.tutupMember = tutupMember;
    }
    
    public void kirimSaldo(Member penerima, int uang){
        if(!this.tutupMember && !penerima.isTutupMember()){
            if(this.nomorMember != penerima.getNomorMember()){
                if(uang > this.saldo){
                    System.out.println("Saldo " +this.nama+ " tidak cukup");
                }else{
                    penerima.setSaldo(penerima.getSaldo() + uang);
                    this.saldo = this.saldo - uang;
                    System.out.println(this.nama + " telah berhasil mengirim saldo ke " + penerima.getNama() + " sebesar " + uang);
                    System.out.println("Saldo " +this.nama+ " saat ini " + this.getSaldo());
                    System.out.println("Saldo " +penerima.nama+ " saat ini " + penerima.getSaldo());
                }
            }else{
                System.out.println(this.nama+ " tidak dapat mengirim saldo ke diri sendiri");
            }
        }else if(penerima.isTutupMember()){
            System.out.println("Member atas nama " + penerima.nama + " telah ditutup");
        }else{
            System.out.println("Member atas nama " + this.nama + " telah ditutup");
        }
    }
    
    public void topUpSaldo(int uang){
        if(!this.tutupMember){
            this.saldo = this.saldo + uang;
            System.out.println(this.nama + " telah berhasi top up saldo");
            System.out.println("Saldo " +this.nama+ " saat ini " + this.getSaldo());
        }else{
            System.out.println("Member atas nama " + this.nama + " telah ditutup");
        }
    }
    
    public void tutupMember(){
        if(!this.tutupMember){
            this.tutupMember = true;
            banyakMember--;
            System.out.println("Member atas nama " + this.nama + " telah resmi ditutup");
            System.out.println("Banyak member sekarang : " + banyakMember);
        }else{
            System.out.println("Member atas nama " + this.nama + " telah ditutup");
        }
    }

    @Override
    public String toString() {
        String balik = "";
        if(this.tutupMember){
            System.out.println("Member atas nama " + this.nama + " telah ditutup");
        }else{
            balik += "Nomor Member\t: " + this.nomorMember;
            balik += "\nNama\t\t: " + this.nama;
            balik += "\nUmur\t\t: " + this.umur;
            balik += "\nSaldo\t\t: " + this.saldo;
            balik += "\n";
        }
        
        return balik;
    }
    
}
