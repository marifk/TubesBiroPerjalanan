/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biroperjalanan;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Kurniawan
 */
public class Aplikasi implements Serializable {

    private static ArrayList<Petugas> daftarPetugas = new ArrayList<Petugas>();
    private static ArrayList<Pelanggan> daftarPelanggan = new ArrayList<Pelanggan>();
    private static ArrayList<Perjalanan> daftarPerjalanan = new ArrayList<Perjalanan>();
    private static ArrayList<PaketWisata> daftarPaketWisata = new ArrayList<PaketWisata>();
    private static ArrayList<TempatWisata> daftarTempatWisata = new ArrayList<TempatWisata>();

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

    public void addPaketWisata(PaketWisata p) {
        daftarPaketWisata.add(p);
    }

    public PaketWisata getPaketWisata(String id) {
        PaketWisata pk = null;
        for (PaketWisata pkp : daftarPaketWisata) {
            if (pkp.getIdPaket().equals(id)) {
                pk = pkp;
            }
        }
        return pk;
    }

    public void deletePaketWisata(String id) {
        for (int i = 0; i < daftarPaketWisata.size(); i++) {
            if (daftarPaketWisata.get(i).getIdPaket().equals(id)) {
                daftarPaketWisata.remove(i);
            }
        }
    }

    public void addTempatWisata(TempatWisata w) {
        daftarTempatWisata.add(w);
    }

    public TempatWisata getTempatWisata(String kode) {
        TempatWisata tm = null;
        for (TempatWisata tp : daftarTempatWisata) {
            if (tp.getKode().equals(kode)) {
                tm = tp;
            }
        }
        return tm;
    }

    public void deleteTempatWisata(String kode) {
        for (int i = 0; i < daftarTempatWisata.size(); i++) {
            if (daftarTempatWisata.get(i).getKode().equals(kode)) {
                daftarTempatWisata.remove(i);
            }
        }
    }

    public void menuSatu(Petugas pt) {
        addPetugas(pt);
    }

    public void menuDua(String id) {
        System.out.println(getPetugas(id));
    }

    public void menuTiga(String id) {
        deletePetugas(id);
    }

    public void menuEmpat(Pelanggan pl) {
        addPelanggan(pl);
    }

    public void menuLima(long id) {
        System.out.println(getPelanggan(id));
    }

    public void menuEnam(long id) {
        deletePelanggan(id);
    }

    public void menuTujuh(TempatWisata w) {
        addTempatWisata(w);
    }

    public void menuDelapan(String id) {
        System.out.println(getTempatWisata(id));
    }

    public void menuSembilan(String id) {
        deleteTempatWisata(id);
    }

    public void menuSepuluh(PaketWisata p) {
        addPaketWisata(p);
    }

    public void menuSebelas(String id) {
        System.out.println(getPaketWisata(id));
    }

    public void menuDuaBelas(String id) {
        deletePaketWisata(id);
    }

    public void menuTigaBelas(Perjalanan j) {
        addPerjalanan(j);
    }

    public void menuEmpatBelas(String id) {
        System.out.println(getPerjalanan(id));
    }

    public void menuLimaBelas(String id) {
        deletePerjalanan(id);
    }

    public ArrayList<Petugas> getPetugasFromFile() {
        ArrayList<Petugas> petugas = new ArrayList<Petugas>();
        try {
            FileInputStream fis = new FileInputStream("petugas.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            petugas = (ArrayList<Petugas>) ois.readObject();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return petugas;
    }

    public ArrayList<Pelanggan> getPelangganFromFile() {
        ArrayList<Pelanggan> pelanggan = new ArrayList<Pelanggan>();
        try {
            FileInputStream fis = new FileInputStream("pelanggan.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Pelanggan> pl = (ArrayList<Pelanggan>) ois.readObject();
            pelanggan = pl;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pelanggan;
    }

    public ArrayList<TempatWisata> getTempatWisataFromFile() {
        ArrayList<TempatWisata> tempat = new ArrayList<TempatWisata>();
        try {
            FileInputStream fis = new FileInputStream("tempat.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<TempatWisata> w = (ArrayList<TempatWisata>) ois.readObject();
            tempat = w;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tempat;
    }

    public ArrayList<PaketWisata> getPaketWisataFromFile() {
        ArrayList<PaketWisata> paket = new ArrayList<PaketWisata>();
        try {
            FileInputStream fis = new FileInputStream("paket.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<PaketWisata> p = (ArrayList<PaketWisata>) ois.readObject();
            paket = p;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return paket;
    }

    public ArrayList<Perjalanan> getPerjalananFromFile() {
        ArrayList<Perjalanan> jalan = new ArrayList<Perjalanan>();
        try {
            FileInputStream fis = new FileInputStream("jalan.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Perjalanan> j = (ArrayList<Perjalanan>) ois.readObject();
            jalan = j;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jalan;
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

    public void fileTempat(ArrayList<TempatWisata> daftarTempatWisata) {
        try (FileOutputStream fos = new FileOutputStream("tempat.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(daftarTempatWisata);
            oos.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void filePaket(ArrayList<PaketWisata> daftarPaketWisata) {
        try (FileOutputStream fos = new FileOutputStream("paket.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(daftarPaketWisata);
            oos.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void fileJalan(ArrayList<Perjalanan> daftarPerjalanan) {
        try (FileOutputStream fos = new FileOutputStream("jalan.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(this.daftarPerjalanan);
            oos.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void mainMenu() {
        Scanner input = new Scanner(System.in);
        Scanner angka = new Scanner(System.in);

        daftarPetugas = getPetugasFromFile();
        daftarPelanggan = getPelangganFromFile();
        daftarTempatWisata = getTempatWisataFromFile();
        daftarPaketWisata = getPaketWisataFromFile();
        daftarPerjalanan = getPerjalananFromFile();
        int menu = 1;
        String id, nama, alamat, user, pass, tmp, tgl, pkt;
        int hr;
        long no, ktp;
        try {
            while (menu != 0) {
                System.out.println("~~~~~~~~~~~~~~BIRO PERJALANAN MERDEKA~~~~~~~~~~~~~~");
                System.out.println("1. Petugas");
                System.out.println("2. Pelanggan");
                System.out.println("3. Tempat Wisata");
                System.out.println("4. Paket Wisata");
                System.out.println("5. Transaksi");
                System.out.println("6. Exit");
                System.out.print("Masukkan Pilihan Menu: ");

                int pil = input.nextInt();
                switch (pil) {
                    case 1:
                        System.out.println("=============Petugas=============");
                        System.out.println("1. Add Petugas");
                        System.out.println("2. Data Petugas");
                        System.out.println("3. Cari Petugas by ID");
                        System.out.println("4. Delete Petugas");
                        System.out.println("5. Back");
                        System.out.print("Masukkan Pilihan Menu: ");
                        int m1 = input.nextInt();
                        switch (m1) {
                            case 1:
                                try {
                                    System.out.print("Masukkan ID Petugas: ");
                                    id = input.next();

                                    Petugas c = getPetugas(id);
                                    if (c == null) {
                                        System.out.print("Masukkan Nama Petugas: ");
                                        nama = input.next();
                                        System.out.print("Masukkan Alamat Petugas: ");
                                        alamat = input.next();
                                        System.out.print("Masukkan No. Tlp: ");
                                        no = angka.nextLong();
                                        System.out.print("Masukkan Username: ");
                                        user = input.next();
                                        System.out.print("Masukkan Password: ");
                                        pass = input.next();
                                        Petugas pt = new Petugas(id, user, pass, nama, alamat, no);

                                        menuSatu(pt);
                                        filePetugas(daftarPetugas);
                                    } else {
                                        System.out.println("Data sudah ada");
                                    }

                                } catch (Exception e) {
                                    System.out.println("SALAH");
                                }
                                break;
                            case 2:
                                System.out.println("Daftar Petugas: ");
                                //System.out.println(Arrays.toString(getPetugasFromFile()));
                                // bacaPetugas(daftarPetugas);
                                // System.out.println(daftarPetugas[1].toString());
                                try {
                                    for (int i = 0; i < daftarPetugas.size(); i++) {
                                        System.out.println("Petugas-" + (i + 1) + ":");
                                        System.out.println(daftarPetugas.get(i).toString());
                                        System.out.println("-------------------------");
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;
                            case 3:
                                try {
                                    System.out.print("Masukkan ID Petugas yang dicari: ");
                                    id = input.next();
                                    menuDua(id);
                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;
                            case 4:
                                try {
                                    System.out.print("Masukkan ID Petugas yang akan di hapus: ");
                                    id = input.next();
                                    menuTiga(id);
                                    filePetugas(daftarPetugas);
                                    System.out.println("Data yang ber-ID " + id + " telah dihapus");

                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("=============Pelanggan=============");
                        System.out.println("1. Add Pelanggan");
                        System.out.println("2. Data Pelanggan");
                        System.out.println("3. Cari Pelanggan by ID");
                        System.out.println("4. Delete Pelanggan");
                        System.out.println("5. Back");
                        System.out.print("Masukkan Pilihan Menu: ");
                        int m2 = input.nextInt();
                        switch (m2) {
                            case 1:
                                try {
                                    System.out.print("Masukkan ID KTP: ");
                                    ktp = input.nextLong();
                                    Pelanggan pc = getPelanggan(ktp);
                                    if (pc == null) {
                                        System.out.print("Masukkan Nama: ");
                                        nama = input.next();
                                        System.out.print("Masukkan Alamat: ");
                                        alamat = input.next();
                                        System.out.print("Masukkan No. Tlp: ");
                                        no = angka.nextLong();
                                        Pelanggan pl = new Pelanggan(ktp, nama, alamat, no);

                                        menuEmpat(pl);
                                        filePelanggan(daftarPelanggan);
                                    } else {
                                        System.out.println("Data sudah ada");
                                    }
                                } catch (Exception e) {
                                    System.out.println("SALAH");
                                }
                                break;
                            case 2:
                                System.out.println("Daftar Pelanggan: ");
                                try {
                                    for (int i = 0; i < daftarPelanggan.size(); i++) {
                                        System.out.println("Pelanggan-" + (i + 1) + ":");
                                        System.out.println(daftarPelanggan.get(i).toString());
                                        System.out.println("-------------------------");
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;
                            case 3:
                                try {
                                    System.out.print("Masukkan ID KTP yang dicari: ");
                                    ktp = input.nextLong();
                                    menuLima(ktp);
                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;
                            case 4:
                                try {
                                    System.out.print("Masukkan ID KTP yang akan dihapus: ");
                                    ktp = input.nextLong();
                                    menuEnam(ktp);
                                    filePelanggan(daftarPelanggan);
                                    System.out.println("Data yang ber-idKTP " + ktp + " telah dihapus");
                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("=============Tempat Wisata=============");
                        System.out.println("1. Add Tempat Wisata");
                        System.out.println("2. Data Tempat Wisata");
                        System.out.println("3. Cari Tempat Wisata by ID");
                        System.out.println("4. Delete Tempat Wisata");
                        System.out.println("5. Back");
                        System.out.print("Masukkan Pilihan Menu: ");
                        int m3 = input.nextInt();
                        switch (m3) {
                            case 1:
                                try {
                                    System.out.print("Masukkan ID Tempat: ");
                                    id = input.next();
                                    TempatWisata wc = getTempatWisata(id);
                                    if (wc == null) {
                                        System.out.print("Masukkan Nama Tempat: ");
                                        nama = input.next();
                                        System.out.print("Masukkan Alamat: ");
                                        alamat = input.next();
                                        TempatWisata w = new TempatWisata(id, nama, alamat);
                                        menuTujuh(w);
                                        fileTempat(daftarTempatWisata);
                                    } else {
                                        System.out.println("Data sudah ada");
                                    }
                                } catch (Exception e) {
                                    System.out.println("SALAH");
                                }
                                break;
                            case 2:
                                System.out.println("Daftar Tempat Wisata: ");
                                try {
                                    for (int i = 0; i < daftarTempatWisata.size(); i++) {
                                        System.out.println("Pelanggan-" + (i + 1) + ":");
                                        System.out.println(daftarTempatWisata.get(i).toString());
                                        System.out.println("-------------------------");
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;
                            case 3:
                                try {
                                    System.out.print("Masukkan ID Tempat yang dicari: ");
                                    id = input.next();
                                    menuDelapan(id);
                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;
                            case 4:
                                try {
                                    System.out.print("Masukkan ID Tempat yang akan dihapus: ");
                                    id = input.next();
                                    menuSembilan(id);
                                    fileTempat(daftarTempatWisata);
                                    System.out.println("Data yang ber-id " + id + " telah dihapus");
                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;
                        }
                        break;

                    case 4:
                        System.out.println("=============Paket Wisata=============");
                        System.out.println("1. Add Paket Wisata");
                        System.out.println("2. Data Paket Wisata");
                        System.out.println("3. Cari Paket Wisata by ID");
                        System.out.println("4. Delete Paket Wisata");
                        System.out.println("5. Back");
                        System.out.print("Masukkan Pilihan Menu: ");
                        int m4 = input.nextInt();
                        switch (m4) {
                            case 1:
                                try {
                                    System.out.print("Masukkan ID Paket: ");
                                    id = input.next();
                                    PaketWisata pkc = getPaketWisata(id);
                                    if (pkc == null) {
                                        System.out.print("Masukkan Harga: ");
                                        hr = angka.nextInt();
                                        PaketWisata p = new PaketWisata(id, hr);
                                        for (int i = 0; i < 3; i++) {
                                            System.out.print("Masukkan ID Tempat " + (i + 1) + ": ");
                                            tmp = input.next();
                                            TempatWisata tc = getTempatWisata(tmp);
                                            if (tmp == null) {
                                                p.addTempatWisata(tc);
                                            }
                                        }
                                        menuSepuluh(p);
                                        filePaket(daftarPaketWisata);
                                    } else {
                                        System.out.println("Data sudah ada");
                                    }
                                } catch (Exception e) {
                                    System.out.println("SALAH");
                                }
                                break;
                            case 2:
                                System.out.println("Daftar Paket Wisata: ");
                                try {
                                    for (int i = 0; i < daftarPaketWisata.size(); i++) {
                                        System.out.println("Pelanggan-" + (i + 1) + ":");
                                        System.out.println(daftarPaketWisata.get(i).toString());
                                        System.out.println("-------------------------");
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;
                            case 3:
                                try {
                                    System.out.print("Masukkan ID Paket yang dicari: ");
                                    id = input.next();
                                    menuSebelas(id);
                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;
                            case 4:
                                try {
                                    System.out.print("Masukkan ID Paket yang akan dihapus: ");
                                    id = input.next();
                                    menuDuaBelas(id);
                                    filePaket(daftarPaketWisata);
                                    System.out.println("Data yang ber-id " + id + " telah dihapus");
                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;
                        }
                        break;

                    case 5:

                        System.out.println("=============Perjalanan=============");
                        System.out.println("1. Add Perjalanan");
                        System.out.println("2. Data Perjalanan");
                        System.out.println("3. Cari Perjalanan by ID");
                        System.out.println("4. Delete Perjalanan");
                        System.out.println("5. Back");
                        System.out.print("Masukkan Pilihan Menu: ");
                        int m5 = input.nextInt();
                        switch (m5) {
                            case 1:
                                try {
                                    System.out.print("Masukkan ID Perjalanan: ");
                                    id = input.next();
                                    Perjalanan jc = getPerjalanan(id);
                                    if (jc == null) {
                                        System.out.print("Masukkan Tanggal(dd-MM-yyyy): ");
                                        tgl = input.next();
                                        System.out.print("Masukkan Jumlah Pelanggan: ");
                                        hr = angka.nextInt();
                                        Perjalanan j = new Perjalanan(id, tgl);
                                        System.out.print("Masukkan ID Paket: ");
                                        id = input.next();
                                        PaketWisata pkc = getPaketWisata(id);
                                        if (pkc != null) {
                                            for (int i = 0; i < hr; i++) {
                                                System.out.print("Masukkan ID KTP Pelanggan: ");
                                                ktp = input.nextLong();
                                                Pelanggan pc = getPelanggan(ktp);
                                                if (pc != null) {
                                                    j.addPelanggan(pc);
                                                } else {
                                                    System.out.println("Pelanggan Tidak ada");
                                                }
                                            }
                                        } else {
                                            System.out.println("Paket Tidak ada");
                                        }
                                        menuTigaBelas(j);
                                        fileJalan(daftarPerjalanan);
                                    } else {
                                        System.out.println("Data sudah ada");
                                    }
                                } catch (Exception e) {
                                    System.out.println("SALAH");
                                }
                                break;
                            case 2:
                                System.out.println("Daftar Perjalanan: ");
                                try {
                                    for (int i = 0; i < daftarPerjalanan.size(); i++) {
                                        System.out.println("Pelanggan-" + (i + 1) + ":");
                                        System.out.println(daftarPerjalanan.get(i).toString());
                                        System.out.println("-------------------------");
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;

                            case 3:
                                try {
                                    System.out.print("Masukkan ID Perjalanan yang dicari: ");
                                    id = input.next();
                                    menuEmpatBelas(id);
                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;
                            case 4:
                                try {
                                    System.out.print("Masukkan ID Perjalanan yang akan dihapus: ");
                                    id = input.next();
                                    menuLimaBelas(id);
                                    fileJalan(daftarPerjalanan);
                                    System.out.println("Data yang ber-id " + id + " telah dihapus");
                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;
                        }
                        break;

                    case 6:
                        System.out.println("Terima Kasih");
                        menu = 0;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Salah Input Kak");
        }
    }
}
