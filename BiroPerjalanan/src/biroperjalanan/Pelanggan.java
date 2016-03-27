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
public class Pelanggan extends Orang {
    private long idKTP;

    public Pelanggan(long idKTP, String nama, String alamat, long noTlp) {
        super(nama, alamat, noTlp);
        this.idKTP = idKTP;
    }
    public long getIdKTP() {
        return idKTP;
    }
    @Override
    public String toString() {
        return super.toString()+"\n"+"ID KTP: " + idKTP  ;
    }
}