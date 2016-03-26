/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biroperjalanan;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Kurniawan
 */
public class Aplikasi {

    private Petugas[] daftarPetugas;
    private int jumPetugas;
    private Pelanggan[] daftarPelanggan;
    private int jumPelanggan;
    private Perjalanan[] daftarPerjalanan;
    private int jumPerjalanan;
    private PaketWisata[] daftarPaketWisata;
    private int jumPaket;
    private TempatWisata[] daftarTempatWisata;
    private int jumTempat;

    public void addPetugas(Petugas pt) {
        //  daftarPetugas.add(pt);
        daftarPetugas = new Petugas[10];
        daftarPetugas[jumPetugas] = pt;
        jumPetugas++;
    }

    public Petugas getPetugas(String id) {
        Petugas p = null;
        for (int j = 0; j < jumPetugas; j++) {
            if (daftarPetugas[j].getId().equals(id)) {
                p = daftarPetugas[j];
            }

        }
        return p;
    }

    public void deletePetugas(String id) {
        Petugas p = null;
        for (int j = 0; j < jumPetugas; j++) {
            if (daftarPetugas[j].getId().equals(id)) {
                p = daftarPetugas[j];
            }

        }
        p = null;
    }

    public void addPelanggan(Pelanggan pl) {
        daftarPelanggan = new Pelanggan[20];
        daftarPelanggan[jumPelanggan] = pl;
        jumPelanggan++;
    }

    public Pelanggan getPelanggan(long idKTP) {
        int i = 0;
        while (daftarPelanggan[i].getIdKTP() != idKTP) {
            i++;
        }
        return daftarPelanggan[i];
    }

    public void deletePelanggan(long idKTP) {
        int i = 0;
        while (daftarPelanggan[i].getIdKTP() != idKTP) {
            i++;
        }

        daftarPelanggan[i] = null;
    }

    public void addPerjalanan(Perjalanan j) {
        daftarPerjalanan = new Perjalanan[10];
        daftarPerjalanan[jumPerjalanan] = j;
        jumPerjalanan++;

    }

    public Perjalanan getPerjalanan(String id) {
        Perjalanan j = null;
        for (int i = 0; i < jumPerjalanan; i++) {
            if (daftarPerjalanan[i].getIdJalan().equals(id)) {
                j = daftarPerjalanan[i];
            }

        }
        return j;
    }

    public void deletePerjalanan(String id) {
        Perjalanan j = null;
        for (int i = 0; i < jumPerjalanan; i++) {
            if (daftarPerjalanan[i].getIdJalan().equals(id)) {
                j = daftarPerjalanan[i];
            }

        }
        j = null;
    }

    public void addPaketWisata(PaketWisata p) {
        daftarPaketWisata = new PaketWisata[10];
        daftarPaketWisata[jumPaket] = p;
        jumPaket++;
    }

    public PaketWisata getPaketWisata(String id) {
        PaketWisata pk = null;
        for (int i = 0; i < jumPaket; i++) {
            if (daftarPaketWisata[i].getIdPaket().equals(id)) {
                pk = daftarPaketWisata[i];
            }

        }
        return pk;
    }

    public void deletePaketWisata(String id) {
        PaketWisata pk = null;
        for (int i = 0; i < jumPaket; i++) {
            if (daftarPaketWisata[i].getIdPaket().equals(id)) {
                pk = daftarPaketWisata[i];
            }

        }
        pk = null;
    }

    public void addTempatWisata(TempatWisata w) {
        daftarTempatWisata = new TempatWisata[20];
        daftarTempatWisata[jumTempat] = w;
        jumTempat++;
    }

    public TempatWisata getTempatWisata(String kode) {
        TempatWisata tm = null;
        for (int i = 0; i < jumTempat; i++) {
            if (daftarTempatWisata[i].getKode().equals(kode)) {
                tm = daftarTempatWisata[i];
            }

        }
        return tm;
    }

    public void deleteTempatWisata(String kode) {
        TempatWisata tm = null;
        for (int i = 0; i < jumTempat; i++) {
            if (daftarTempatWisata[i].getKode().equals(kode)) {
                tm = daftarTempatWisata[i];
            }

        }
        tm = null;
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

    public Petugas[] getPetugasFromFile() {
        Petugas[] petugas = new Petugas[jumPetugas];
        try {
            FileInputStream fis = new FileInputStream("petugas.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            for (int i = 0; i < jumPetugas; i++) {
                ois.readObject();
                petugas = (Petugas[]) ois.readObject();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return petugas;
    }

    public Pelanggan[] getPelangganFromFile() {
        Pelanggan[] pelanggan = new Pelanggan[jumPelanggan];
        try {
            FileInputStream fis = new FileInputStream("pelanggan.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Pelanggan[] pl = (Pelanggan[]) ois.readObject();
            pelanggan = pl;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pelanggan;
    }

    public TempatWisata[] getTempatWisataFromFile() {
        TempatWisata[] tempat = new TempatWisata[jumTempat];
        try {
            FileInputStream fis = new FileInputStream("tempat.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            TempatWisata[] w = (TempatWisata[]) ois.readObject();
            tempat = w;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tempat;
    }

    public PaketWisata[] getPaketWisataFromFile() {
        PaketWisata[] paket = new PaketWisata[jumPaket];
        try {
            FileInputStream fis = new FileInputStream("paket.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            PaketWisata[] p = (PaketWisata[]) ois.readObject();
            paket = p;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return paket;
    }

    public Perjalanan[] getPerjalananFromFile() {
        Perjalanan[] jalan = new Perjalanan[jumPerjalanan];
        try {
            FileInputStream fis = new FileInputStream("jalan.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Perjalanan[] j = (Perjalanan[]) ois.readObject();
            jalan = j;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jalan;
    }

    public void filePetugas(Petugas[] daftarPetugas) {
        try (FileOutputStream fos = new FileOutputStream("petugas.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(daftarPetugas);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void filePelanggan(Pelanggan[] daftarPelanggan) {
        try (FileOutputStream fos = new FileOutputStream("pelanggan.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(daftarPelanggan);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void fileTempat(TempatWisata[] daftarTempatWisata) {
        try (FileOutputStream fos = new FileOutputStream("tempat.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(daftarTempatWisata);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void filePaket(PaketWisata[] daftarPaketWisata) {
        try (FileOutputStream fos = new FileOutputStream("paket.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(daftarPaketWisata);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void fileJalan(Perjalanan[] daftarPerjalanan) {
        try (FileOutputStream fos = new FileOutputStream("jalan.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(this.daftarPerjalanan);
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
                                        Petugas pt = new Petugas(nama, alamat, no);
                                        pt.setId(id);
                                        pt.setUserName(user);
                                        pt.setPass(pass);
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
                                try {
                                    for (int i = 0; i < jumPetugas; i++) {
                                        System.out.println(daftarPetugas[i].toString());
                                        System.out.println("-------------------------");

                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;
                            case 3:
                                try {
                                    System.out.print("Masukkan ID Petugas yang dicari: ");
                                    id = input.nextLine();
                                    Petugas c = getPetugas(id);
                                    if (c != null) {
                                        menuDua(id);
                                    } else {
                                        System.out.println("Data Tidak ada");
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("SALAH");
                                }
                                break;
                            case 4:
                                try {
                                    System.out.print("Masukkan ID Petugas yang akan di hapus: ");
                                    id = input.nextLine();
                                    Petugas c = getPetugas(id);
                                    if (c != null) {
                                        menuTiga(id);
                                        filePetugas(daftarPetugas);
                                        System.out.println("Data yang ber-ID " + id + " telah dihapus");
                                    } else {
                                        System.out.println("Data Tidak ada");
                                    }
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
                                        Pelanggan pl = new Pelanggan(nama, alamat, no);
                                        pl.setIdKTP(ktp);
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
                                    for (int i = 0; i < jumPelanggan; i++) {
                                        System.out.println(daftarPelanggan[i].toString());
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
                                    Pelanggan pc = getPelanggan(ktp);
                                    if (pc != null) {
                                        menuLima(ktp);
                                    } else {
                                        System.out.println("Data Tidak ada");
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("SALAH");
                                }
                                break;
                            case 4:
                                try {
                                    System.out.print("Masukkan ID KTP yang akan dihapus: ");
                                    ktp = input.nextLong();
                                    Pelanggan pc = getPelanggan(ktp);
                                    if (pc != null) {
                                        menuEnam(ktp);
                                        filePelanggan(daftarPelanggan);
                                        System.out.println("Data yang ber-idKTP " + ktp + " telah dihapus");
                                    } else {
                                        System.out.println("Data Tidak ada");
                                    }
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
                                    for (int i = 0; i < jumTempat; i++) {
                                        System.out.println(daftarTempatWisata[i].toString());
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
                                    TempatWisata wc = getTempatWisata(id);
                                    if (wc != null) {
                                        menuDelapan(id);
                                    } else {
                                        System.out.println("Data Tidak ada");
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("SALAH");
                                }
                                break;
                            case 4:
                                try {
                                    System.out.print("Masukkan ID Tempat yang akan dihapus: ");
                                    id = input.next();
                                    TempatWisata wc = getTempatWisata(id);
                                    if (wc != null) {
                                        menuSembilan(id);
                                        fileTempat(daftarTempatWisata);
                                        System.out.println("Data yang ber-id " + id + " telah dihapus");
                                    } else {
                                        System.out.println("Data Tidak ada");
                                    }
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
                                        PaketWisata p = new PaketWisata(id);
                                        for (int i = 0; i < 3; i++) {
                                            System.out.print("Masukkan ID Tempat " + (i + 1) + ": ");
                                            tmp = input.next();
                                            TempatWisata tc = getTempatWisata(tmp);
                                            if (tmp == null) {
                                                p.addTempatWisata(tc);
                                            }
                                        }
                                        System.out.print("Masukkan Harga: ");
                                        hr = angka.nextInt();
                                        p.setHarga(hr);
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
                                    for (int i = 0; i < jumPaket; i++) {
                                        System.out.println(daftarPaketWisata[i].toString());
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
                                    PaketWisata pkc = getPaketWisata(id);
                                    if (pkc != null) {
                                        menuSebelas(id);
                                    } else {
                                        System.out.println("Data Tidak ada");
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("SALAH");
                                }
                                break;
                            case 4:
                                try {
                                    System.out.print("Masukkan ID Paket yang akan dihapus: ");
                                    id = input.next();
                                    PaketWisata pkc = getPaketWisata(id);
                                    if (pkc != null) {
                                        menuDuaBelas(id);
                                        filePaket(daftarPaketWisata);
                                        System.out.println("Data yang ber-id " + id + " telah dihapus");
                                    } else {
                                        System.out.println("Data Tidak ada");
                                    }
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
                                        Perjalanan j = new Perjalanan(id, tgl, hr);
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
                                    for (int i = 0; i < jumPerjalanan; i++) {
                                        System.out.println(daftarPerjalanan[i].toString());
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
                                    Perjalanan jc = getPerjalanan(id);
                                    if (jc == null) {
                                        menuEmpatBelas(id);
                                    } else {
                                        System.out.println("Perjalanan Tidak ada");
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("Data Tidak ada");
                                }
                                break;
                            case 4:
                                try {
                                    System.out.print("Masukkan ID Perjalanan yang akan dihapus: ");
                                    id = input.next();
                                    Perjalanan jc = getPerjalanan(id);
                                    if (jc == null) {
                                        menuLimaBelas(id);
                                        fileJalan(daftarPerjalanan);
                                        System.out.println("Data yang ber-id " + id + " telah dihapus");
                                    } else {
                                        System.out.println("Perjalanan Tidak ada");
                                    }
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
