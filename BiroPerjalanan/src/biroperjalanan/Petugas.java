/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biroperjalanan;

import java.io.Serializable;

/**
 *
 * @author Kurniawan
 */
public class Petugas extends Orang implements Serializable{
    private String id;
    private String userName;
    private String pass;
    
    public Petugas(String id, String userName, String pass, String nama, String alamat, long noTlp) {
        super(nama, alamat, noTlp);
        this.id = id;
        this.userName = userName;
        this.pass = pass;
    }
    public String getId() {
        return id;
    }
    public String getUserName() {
        return userName;
    }
    public String getPass() {
        return pass;
    }
    @Override
    public String toString() {
        return super.toString()+"\n"+"Username: " + userName +"\n"+ "Password: " + pass ;
    } 
}