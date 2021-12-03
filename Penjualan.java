package penjualan;

import java.util.Scanner;


public class Penjualan {
    public static void main(String[] args){
        Scanner inputUser = new Scanner(System.in).useDelimiter("\n");
        String namaKasir;
        System.out.print("Selamat datang, silahkan masukkan nama anda terlebih dahulu : "); namaKasir = inputUser.next();
        System.out.println("=======================================================");
        System.out.println("PROGRAM DATA PENJUALAN BARANG\nPT. \"PAMULANG TAMA\"\nNAMA KASIR: " + namaKasir);
        System.out.println("=======================================================\n");
        float JumlahBayar = 0;
        double diskon = 0, HargaDiskon = 0, BiayaKartu = 0, TotalBayar;
        double ppn = 0.1;
        
        dataBarang[] dataBrg = new dataBarang[0];
        
        int pilihan, jumlahBarang, x;
        do {
            System.out.println("\nPilih menu : ");
            System.out.println("1. Input data penjualan");
            System.out.println("2. Pembayaran");
            System.out.println("3. Keluar Program");
            
            System.out.print("\nPilih : ");
            pilihan = inputUser.nextInt();
            int Pembayaran = 0;
            switch (pilihan){
                case 1:
                System.out.print("Masukan jumlah barang : ");
                jumlahBarang = inputUser.nextInt();
                dataBrg = new dataBarang[jumlahBarang];
                for(x = 0; x < dataBrg.length; x++){
                    dataBrg[x] = new dataBarang();
                    System.out.println("\nBarang ke : " + (x+1));
                    System.out.print("Masukan kode barang  : "); dataBrg[x].setKodeBarang(inputUser.next());
                    System.out.print("Masukan nama barang  : "); dataBrg[x].setNamaBarang(inputUser.next());
                    System.out.print("Masukan harga barang : "); dataBrg[x].setHargaBarang(inputUser.nextFloat());
                    System.out.print("Masukan jumlah beli  : "); dataBrg[x].setJumlahBeli(inputUser.nextInt());
                }
                // Metode Pembayaran yang digunakan
                break;
                case 2:
                    System.out.println("\nDATA PENJUALAN BARANG");
                    System.out.println("PT PAMULANG TAMA");
                    System.out.println("Nama Kasir : "+ namaKasir);
                    System.out.println("================================================================================");
                    System.out.println("No. \tKode Barang \tNama Barang \tHarga Barang \tJumlah Beli \tBayar");
                    System.out.println("================================================================================");
                    for(x = 0; x < dataBrg.length; x++){
                        System.out.println((x + 1) + "\t" + dataBrg[x].getKodeBarang() + "\t"+ "\t" + dataBrg[x].getNamaBarang() + "\t"+ "\t" + dataBrg[x].getHargaBarang() + "\t"+ "\t" + dataBrg[x].getJumlahBeli() + "\t" + dataBrg[x].getBayar());
                        JumlahBayar = (float)(JumlahBayar + dataBrg[x].getBayar());
                         if(JumlahBayar < 500000){ 
                        diskon = 0;
                    }else{
                            diskon = JumlahBayar * 0.05;
                            }
                    }
                    HargaDiskon = JumlahBayar - diskon;
                    ppn = JumlahBayar * 0.1;
            System.out.println("\nJumlah Bayar \t : Rp. " + JumlahBayar);
            System.out.println("Diskon 5% \t : Rp. " + diskon);
            System.out.println("PPN %10 \t : Rp. " + ppn);
            
            System.out.println("\nPilih Metode Pembayaran : ");
            System.out.println("1. Visa/Master Card");
            System.out.println("2. Cash");
            System.out.print("\nPilihan Pembayaran : ");
            Pembayaran = inputUser.nextInt();
            
            if(Pembayaran == 1){
                BiayaKartu = 0.03 * JumlahBayar;
                System.out.println("\nBiaya kartu \t : Rp. " + BiayaKartu);
                TotalBayar = HargaDiskon + ppn + BiayaKartu;
                System.out.println("Total Bayar (inc Disc,PPN,CC Fee) \t : Rp. " + TotalBayar);
            }else{
                TotalBayar = HargaDiskon + ppn;
                System.out.println("Total Bayar (inc Disc,PPN) \t : Rp. " + TotalBayar);
            }
            }
        } while (pilihan !=3);
    }
     
    
}