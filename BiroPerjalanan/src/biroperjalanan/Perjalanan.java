/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biroperjalanan;

/**
 *
 * @author Kurniawan
 */
public class Perjalanan {
   private String idJalan;
    private Pelanggan[] pelanggan;
    private PaketWisata paket;
    private int jumlahPelanggan;
    private int harga;

    public Perjalanan(String idJalan) {
        this.idJalan = idJalan;
        pelanggan=new Pelanggan[8];
    }
    
    public void addPelanggan(Pelanggan p){
        pelanggan[jumlahPelanggan]=p;
        jumlahPelanggan++;
    }
    public void setPaket(PaketWisata p){
        this.paket=p;
    }

    public Pelanggan getPelanggan(int i) {
        return pelanggan[i];
    }

    public PaketWisata getPaket() {
        return paket;
    }
    
   public int getJumlahPelanggan() {
        return jumlahPelanggan;
    }
    
    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    public Pelanggan getPelanggan(long id) {
        int i=0;
        while (pelanggan[i].getIdKTP()!=id) {
            i++;
        }
        return pelanggan[i];
    }
}
