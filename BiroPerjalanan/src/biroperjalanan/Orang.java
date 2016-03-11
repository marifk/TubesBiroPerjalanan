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
public abstract class Orang {
    private String nama;
    private String alamat;
    private long noTlp;
    
    public Orang(String nama, String alamat, long noTlp){
        this.nama = nama;
        this.alamat = alamat;
        this.noTlp = noTlp;
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

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public long getNoTlp() {
        return noTlp;
    }

    public void setNoTlp(long noTlp) {
        this.noTlp = noTlp;
    }
}
