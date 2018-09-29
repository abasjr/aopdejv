/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Royya
 */
public class MemberMain {
    public static void main(String []args){

        // Menginisiasi seorang member bernama Pak Ijo dengan nomor member 1, umur 18 tahun dan saldo 100000
        Member A = new Member(1, "Pak Ijo", 18, 100000);
        
        // Menginisiasi seorang member bernama Pak Inem dengan nomor member 2, umur 20 tahun
        Member B = new Member(2, "Pak Inem", 20);
        
        /*
            Cetak banyak member awal disini
        */
        
        System.out.println("--------------------");
        System.out.println("Banyak member : " + Member.banyakMember);
        System.out.println();
        
        System.out.println("--------------------");
        System.out.println(A);
        System.out.println("--------------------");
        System.out.println(B);
        
        System.out.println("--------------------");
        //Pak Ijo top up saldo 20000
        A.topUpSaldo(20000);
        System.out.println();
        
        System.out.println("--------------------");
        //Pak Ijo kirim saldo ke Pak Inem 30000
        A.kirimSaldo(B, 30000);
        System.out.println();
        
        System.out.println("--------------------");
        //Pak Inem tutup member
        B.tutupMember();
        System.out.println();
        
        
        System.out.println("--------------------");
        //Pak Inem top up saldo 10000
        B.topUpSaldo(10000);
        System.out.println();
        
        System.out.println("--------------------");
        System.out.println(A);
        System.out.println("--------------------");
        System.out.println(B);
        
        System.out.println("--------------------");
        A.setUmur(60);
        System.out.println();
        
        
        System.out.println("--------------------");
        System.out.println(A);
        System.out.println("--------------------");
        System.out.println(B);
        
    }
}
