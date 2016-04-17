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
    public void addPerjalanan(Perjalanan j) {
        daftarPerjalanan.add(j);

    }

    public Perjalanan getPerjalanan(String id) {
        Perjalanan j = null;
        for (Perjalanan jp : daftarPerjalanan) {
            if (jp.getIdJalan().equals(id)) {
                j = jp;
            }
        }
        return j;
    }

    public void deletePerjalanan(String id) {
        for (int i = 0; i < daftarPerjalanan.size(); i++) {
            if (daftarPerjalanan.get(i).getIdJalan().equals(id)) {
                daftarPerjalanan.remove(i);
            }
        }
    }
    
    public ArrayList<Perjalanan> getPerjalananFromFile() {
        File f = new File("jalan.txt");
        ArrayList<Perjalanan> j = new ArrayList<>();
        if (f.exists()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                j = (ArrayList<Perjalanan>) ois.readObject();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return j;
    }
    
    public void fileTempat(ArrayList<TempatWisata> daftarTempatWisata) {
        try (FileOutputStream fos = new FileOutputStream("tempat.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(daftarTempatWisata);
            oos.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void fileJalan(ArrayList<Perjalanan> daftarPerjalanan) {
        try (FileOutputStream fos = new FileOutputStream("jalan.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(daftarPerjalanan);
            oos.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String tampilJalan() {
        ArrayList<Perjalanan> pt = new ArrayList<>();
        for (Perjalanan p : daftarPerjalanan) {
            pt.add(p);
        }
        return pt.toString();
    }
}
