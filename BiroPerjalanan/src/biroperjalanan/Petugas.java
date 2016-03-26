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
public class Petugas extends Orang {
    private String id;
    private String userName;
    private String pass;
    
    public Petugas(String nama, String alamat, long noTlp){
       super(nama,alamat,noTlp);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    @Override
    public String toString() {
        return super.toString()+"\n"+"Username: " + userName +"\n"+ "Password: " + pass ;
    }
}
