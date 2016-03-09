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
public class Pelanggan extends Orang{
    private long idKTP;
    
    public Pelanggan(String nama, String alamat, long noTlp) {
        super(nama, alamat, noTlp);
    }

    public long getIdKTP() {
        return idKTP;
    }

    public void setIdKTP(long idKTP) {
        this.idKTP = idKTP;
    }
}
