/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Kurniawan
 */
public class Aplikasi {
    public void addPetugas(Petugas pt) {
        daftarPetugas.add(pt);
    }

    public Petugas getPetugas(String id) {
        Petugas p = null;
        for (Petugas dp : daftarPetugas) {
            if (dp.getId().equals(id)) {
                p = dp;
            }
        }
        return p;
    }

    public void deletePetugas(String id) {
        for (int i = 0; i < daftarPetugas.size(); i++) {
            if (daftarPetugas.get(i).getId().equals(id)) {
                daftarPetugas.remove(i);
            }
        }
    }

    public void addPelanggan(Pelanggan pl) {
        daftarPelanggan.add(pl);
    }

    public Pelanggan getPelanggan(long idKTP) {
        Pelanggan pl = null;
        for (Pelanggan plp : daftarPelanggan) {
            if (plp.getIdKTP() == idKTP) {
                pl = plp;
            }
        }
        return pl;
    }

    public void deletePelanggan(long idKTP) {
        for (int i = 0; i < daftarPelanggan.size(); i++) {
            if (daftarPelanggan.get(i).getIdKTP() == idKTP) {
                daftarPelanggan.remove(i);
            }
        }
    }
    
    public ArrayList<Petugas> getPetugasFromFile() {
        File f = new File("petugas.txt");
        ArrayList<Petugas> p = new ArrayList<>();
        if (f.exists()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                p = (ArrayList<Petugas>) ois.readObject();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return p;
    }

    public ArrayList<Pelanggan> getPelangganFromFile() {
        File f = new File("pelanggan.txt");
        ArrayList<Pelanggan> pl = new ArrayList<>();
        if (f.exists()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                pl = (ArrayList<Pelanggan>) ois.readObject();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return pl;
    }
    
     public void filePetugas(ArrayList<Petugas> daftarPetugas) {
        try (FileOutputStream fos = new FileOutputStream("petugas.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(daftarPetugas);
            oos.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void filePelanggan(ArrayList<Pelanggan> daftarPelanggan) {
        try (FileOutputStream fos = new FileOutputStream("pelanggan.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(daftarPelanggan);
            oos.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
     public String tampilPetugas() {
        ArrayList<Petugas> pt = new ArrayList<>();
        for (Petugas p : daftarPetugas) {
            pt.add(p);
        }
        return pt.toString();
    }

    public String tampilPelanggan() {
        ArrayList<Pelanggan> pl = new ArrayList<>();
        for (Pelanggan p : daftarPelanggan) {
            pl.add(p);
        }
        return pl.toString();
    }
    
}
