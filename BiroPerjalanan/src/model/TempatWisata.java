/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Kurniawan
 */
public class TempatWisata implements Serializable {

    private String kode;
    private String nama;
    private String alamat;

    public TempatWisata(String kode, String nama, String alamat) {
        this.kode = kode;
        this.nama = nama;
        this.alamat = alamat;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getKode() {
        return kode;
    }

    @Override
    public String toString() {
        return "Kode Tempat: " + kode + "\n" + "Nama: " + nama + "\n" + "Alamat: " + alamat + "\n";
    }

}
