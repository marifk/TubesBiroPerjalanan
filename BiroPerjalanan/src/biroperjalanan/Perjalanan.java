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
    private Pelanggan[] pelanggan;
    private PaketWisata paket;
    private long idKTP;
    private int jumlahPelanggan;
    public long getIdKTP() {
        return idKTP;
    }

    public void setIdKTP(long idKTP) {
        this.idKTP = idKTP;
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
}
