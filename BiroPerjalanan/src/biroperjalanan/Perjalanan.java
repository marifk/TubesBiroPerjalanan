/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biroperjalanan;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Kurniawan
 */
public class Perjalanan {
    private String idJalan;
    private Pelanggan[] pelanggan;
    private PaketWisata paket;
    private int jumlahPelanggan;
    
    private String tanggal;
    public String getIdJalan() {
        return idJalan;
    }

    public Perjalanan(String idJalan, String tanggal,int jum) {
        this.idJalan = idJalan;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.tanggal= tanggal;
        pelanggan=new Pelanggan[jum];
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
    
   
    public Pelanggan getPelanggan(long id) {
        int i=0;
        while (pelanggan[i].getIdKTP()!=id) {
            i++;
        }
        return pelanggan[i];
    }

    public String getTanggal() {
        return tanggal;
    }

    @Override
    public String toString() {
        return "Perjalanan{" + "idJalan=" + idJalan + ", pelanggan=" + Arrays.toString(pelanggan) + ", paket=" + paket + ", jumlahPelanggan=" + jumlahPelanggan +  ", tanggal=" + tanggal + '}';
    }
    
}
