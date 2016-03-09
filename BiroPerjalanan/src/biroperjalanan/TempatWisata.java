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
public class TempatWisata {
    private String kode;
    private String nama;
    private String alamat;

    public TempatWisata (String kode,String nama, String alamat){
        this.kode=kode;
        this.nama = nama;
        this.alamat = alamat;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getKode() {
        return kode;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
