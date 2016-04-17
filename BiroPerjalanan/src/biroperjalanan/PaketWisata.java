/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biroperjalanan;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Kurniawan
 */
public class PaketWisata implements Serializable{

    private String idPaket;
    private TempatWisata[] daftarTujuanWisata;
    private int jumlahWisata;
    private int harga;

    public PaketWisata(String idPaket, int harga) {
        this.idPaket = idPaket;
        this.harga = harga;
        daftarTujuanWisata = new TempatWisata[3];
    }


    public int getJumlahWisata() {
        return jumlahWisata;
    }

    public String getIdPaket() {
        return idPaket;
    }

    public void addTempatWisata(TempatWisata w) {
        this.daftarTujuanWisata[jumlahWisata] = w;
        jumlahWisata++;
    }

    public TempatWisata getTempatWisata(int i) {
        return daftarTujuanWisata[i];
    }

    public TempatWisata getTempatWisata(String id) {
        int i = 0;
        while (daftarTujuanWisata[i].getKode() != id) {
            i++;
        }
        return daftarTujuanWisata[i];
    }

    public void removeTempatWisata(TempatWisata wst) {
        for (int i = 0; i < daftarTujuanWisata.length; i++) {
            if (daftarTujuanWisata[i] == wst) {
                daftarTujuanWisata[i] = null;
            }

        }
    }

    public int getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return "PaketWisata{" + "idPaket=" + idPaket + ", daftarTujuanWisata=" + Arrays.toString(daftarTujuanWisata) + ", harga=" + harga + '}';
    }
}
