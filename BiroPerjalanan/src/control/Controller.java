/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import view.Tempat;
import view.Transaksi;
import view.Customer;
import view.Home;
import view.Petugas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.plaf.DesktopPaneUI;
import model.*;
import view.*;

/**
 *
 * @author Kurniawan
 */
public class Controller implements ActionListener{
    private View view;
    private Aplikasi app;

    public Controller() {
        app = new Aplikasi();
        app.load();
        goToLogin();
    }

    public void goToRegister() {
        Register regis = new Register();
        regis.setVisible(true);
        regis.addListener(this);
        view = regis;
    }

    public void goToMain() {
        Main main = new Main();
        main.setRemoveDP();
        main.setVisible(true);
        main.addListener(this);
        view = main;
    }

    public void goToLogin() {
        Login lg = new Login();
        lg.setVisible(true);
        lg.addListener(this);
        view = lg;
    }

    model.Petugas plog = null;

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        try {
            if (view instanceof Login) {
                Login lg = (Login) view;
                if (source.equals(lg.getBtnLogin())) {
                    try {
                        model.Petugas log = app.cekLogin(lg.getTxUsername(), lg.getTxPassword());
                        if (lg.getTxUsername().equals("") && lg.getTxPassword().equals("")) {
                            JOptionPane.showMessageDialog(null, "Username dan Password tidak boleh kosong");
                            lg.setVisible(true);
                        } else if (lg.getTxUsername().equals("")) {
                            JOptionPane.showMessageDialog(null, "Username tidak boleh kosong");
                            lg.setVisible(true);
                        } else if (lg.getTxPassword().equals("")) {
                            JOptionPane.showMessageDialog(null, "Password tidak boleh kosong");
                            lg.setVisible(true);
                        } else if (log != null) {
                            lg.dispose();
                            JOptionPane.showMessageDialog(null, "Selamat Datang " + log.getNama().toUpperCase());
                            goToMain();
                            plog = log;
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
                            lg.setVisible(true);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (source.equals(lg.getBtnRegister())) {
                    goToRegister();
                    lg.dispose();
                }
            } else if (view instanceof Register) {
                Register regis = (Register) view;
                if (source.equals(regis.getRegistrasi())) {
                    try {
                        model.Petugas c = app.getPetugas(regis.getTxID());
                        if (regis.getTxID().equals("") || regis.getNama().equals("") || regis.getAlamat().equals("") || regis.getNotlp() == null || regis.getUsername().equals("") || regis.getPassword().equals("")) {
                            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                            regis.setVisible(true);
                        } else if (c == null) {
                            model.Petugas pt = new model.Petugas(regis.getTxID(), regis.getUsername(), regis.getPassword(), regis.getNama(), regis.getAlamat(), regis.getNotlp());
                            app.addPetugas(pt);
                            JOptionPane.showMessageDialog(null, "Registrasi Berhasil");
                            goToLogin();
                            regis.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Sudah ada");
                            regis.setVisible(true);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Inputan salah");
                    }
                } else if (source.equals(regis.getKembali())) {
                    goToLogin();
                    regis.dispose();
                }
            } else if (view instanceof Main) {
                Main main = (Main) view;
                if (source.equals(main.getAkun())) {
                    Home h = new Home();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(h);
                    h.setTxAreaHome("Selamat datang, " + plog.getNama().toUpperCase() + " Semangat kerjanya");
                    h.setVisible(true);
                } else if (source.equals(main.getLogout())) {
                    main.dispose();
                    JOptionPane.showMessageDialog(null, "Terima Kasih");
                    goToLogin();
                } else if (source.equals(main.getPetugas())) {
                    Petugas pg = new Petugas();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(pg);
                    pg.setVisible(true);
                    pg.setAreaPetugas();
                } else if (source.equals(main.getAddPetugas())) {
                    addPetugas add = new addPetugas();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(add);
                    add.setVisible(true);
                    if (source.equals(add.getBtnSave())) {
                        if (app.getPetugas(add.getTxID()) == null) {
                            model.Petugas pt = new model.Petugas(add.getTxID(), add.getUsername(), add.getPassword(), add.getNama(), add.getAlamat(), add.getNotlp());
                            app.addPetugas(pt);
                            JOptionPane.showMessageDialog(null, "Add Petugas Berhasil");
                            add.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Sudah ada");
                            add.setVisible(true);
                        }
                    }
                } else if (source.equals(main.getCariPetugas())) {
                    cariPetugas cp = new cariPetugas();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(cp);
                    cp.setVisible(true);
                    if (source.equals(cp.getBtnCari())) {
                        model.Petugas p = app.getPetugas(cp.getTxId());
                        if (p != null) {
                            cp.setAreaPetugas(p.toString());
                            cp.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Tidak ada");
                            cp.setVisible(true);
                        }
                    }
                } else if (source.equals(main.getDelPetugas())) {
                    delPetugas dp = new delPetugas();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(dp);
                    dp.setVisible(true);
                    if (source.equals(dp.getBtnDel())) {
                        model.Petugas p = app.getPetugas(dp.getTxId());
                        if (p != null) {
                            app.deletePetugas(dp.getTxId());
                            JOptionPane.showMessageDialog(null, "Delete Data Petugas Berhasil");
                            dp.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
                            dp.setVisible(true);
                        }
                    }
                } else if (source.equals(main.getPelanggan())) {
                    Customer cs = new Customer();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(cs);
                    cs.setVisible(true);
                    if (source.equals(cs.getBtnSimpan())) {
                        if (app.getPelanggan(cs.getIdKtp()) == null) {
                            model.Pelanggan pl = new model.Pelanggan(cs.getIdKtp(), cs.getNama(), cs.getAlamat(), cs.getNotlp());
                            app.addPelanggan(pl);
                            JOptionPane.showMessageDialog(null, "Add Pelanggan Berhasil");
                            cs.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Sudah ada");
                            cs.setVisible(true);
                        }
                    }
                } else if (source.equals(main.getDatPelanggan())) {
                    dataPelanggan cs = new dataPelanggan();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(cs);
                    cs.setVisible(true);
                    cs.setDatPl();
                    cs.setVisible(true);
                } else if (source.equals(main.getCariPelanggan())) {
                    cariPelanggan cp = new cariPelanggan();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(cp);
                    cp.setVisible(true);
                    if (source.equals(cp.getBtnCari())) {
                        model.Pelanggan cpl = app.getPelanggan(cp.getTxId());
                        if (cpl != null) {
                            cp.setAreaPelanggan(cpl.toString());
                            cp.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Tidak ada");
                            cp.setVisible(true);
                        }
                    }
                } else if (source.equals(main.getDelPelanggan())) {
                    delPelanggan dpel = new delPelanggan();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(dpel);
                    dpel.setVisible(true);
                    if (source.equals(dpel.getBtnDel())) {
                        model.Pelanggan p = app.getPelanggan(dpel.getTxId());
                        if (p != null) {
                            app.deletePelanggan(dpel.getTxId());
                            JOptionPane.showMessageDialog(null, "Delete Data Pelanggan Berhasil");
                            dpel.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
                            dpel.setVisible(true);
                        }
                    }
                } else if (source.equals(main.getTempat())) {
                    Tempat t = new Tempat();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(t);
                    t.setVisible(true);
                    if (source.equals(t.getBtnSave())) {
                        if (app.getTempatWisata(t.getTxKode()) == null) {
                            model.TempatWisata tw = new model.TempatWisata(t.getTxKode(), t.getTxNama(), t.getTxAlamat());
                            app.addTempatWisata(tw);
                            JOptionPane.showMessageDialog(null, "Add Tempat Wisata Berhasil");
                            t.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Sudah ada");
                            t.setVisible(true);
                        }
                    }
                } else if (source.equals(main.getDatTempat())) {
                    dataTempat t = new dataTempat();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(t);
                    t.setVisible(true);
                    t.setDatTempat();
                    t.setVisible(true);
                } else if (source.equals(main.getCariTempat())) {
                    /*sampai sini*/
                    cariTempat ct = new cariTempat();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(ct);
                    ct.setVisible(true);
                    if (source.equals(ct.getBtnCari())) {
                        model.TempatWisata ctem = app.getTempatWisata(ct.getTxId());
                        if (ctem != null) {
                            ct.setAreaTempat(ctem.toString());
                            ct.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Tidak ada");
                            ct.setVisible(true);
                        }
                    }
                } else if (source.equals(main.getDelTempat())) {
                    delTempat dt = new delTempat();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(dt);
                    dt.setVisible(true);
                    if (source.equals(dt.getBtnDel())) {
                        model.TempatWisata tp = app.getTempatWisata(dt.getTxkode());
                        if (tp != null) {
                            app.deleteTempatWisata(dt.getTxkode());
                            JOptionPane.showMessageDialog(null, "Delete Data Tempat Wisata Berhasil");
                            dt.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
                            dt.setVisible(true);
                        }
                    }
                } else if (source.equals(main.getPaket())) {
                    Paket p = new Paket();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(p);
                    p.setVisible(true);
                    if (source.equals(p.getBtnSave())) {
                        if (app.getPaketWisata(p.getKdPaket()) == null) {
                            model.PaketWisata pak = new model.PaketWisata(p.getKdPaket(), p.getHarga());

                            app.addPaketWisata(pak);
                            JOptionPane.showMessageDialog(null, "Add Paket Wisata Berhasil");
                            p.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Sudah ada");
                            p.setVisible(true);
                        }
                    }
                } else if (source.equals(main.getDatPaket())) {
                    dataPaket p = new dataPaket();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(p);
                    p.setVisible(true);
                    p.setDatPaket();
                    p.setVisible(true);

                } else if (source.equals(main.getCariPaket())) {
                    cariPaket p = new cariPaket();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(p);
                    p.setVisible(true);
                    if (source.equals(p.getBtnCari())) {
                        model.PaketWisata pak = app.getPaketWisata(p.getTxId());
                        if (pak != null) {
                            p.setAreaPaket(pak.toString());
                            p.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Tidak ada");
                            p.setVisible(true);
                        }
                    }
                } else if (source.equals(main.getDelPaket())) {
                    delPaket p = new delPaket();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(p);
                    p.setVisible(true);
                    if (source.equals(p.getBtnDel())) {
                        model.PaketWisata pak = app.getPaketWisata(p.getTxId());
                        if (pak != null) {
                            app.deletePaketWisata(p.getTxId());
                            JOptionPane.showMessageDialog(null, "Delete Data Paket Wisata Berhasil");
                            p.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
                            p.setVisible(true);
                        }
                    }
                } else if (source.equals(main.getJalan())) {
                    addJalan j = new addJalan();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(j);
                    j.setVisible(true);
                    if (source.equals(j.getBtnSave())) {
                        try {
                            if (j.getIdJalan().equals("") || j.getIdPaket().equals("")) {
                                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                            } else if (app.getPerjalanan(j.getIdJalan()) == null) {
                                model.PaketWisata p = app.getPaketWisata(j.getIdPaket());
                                if (p != null) {
                                    model.Perjalanan pj = new model.Perjalanan(j.getIdJalan(), j.getTanggal());
                                    pj.setPaket(p);
                                    app.addPerjalanan(pj);
                                    JOptionPane.showMessageDialog(null, "Add Perjalanan Berhasil");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Data Paket tidak ada");
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Data Sudah ada");
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Inputan salah");
                        }
                    }
                } else if (source.equals(main.getAddTransaksi())) {
                    Transaksi j = new Transaksi();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(j);
                    j.setVisible(true);
                    if (source.equals(j.getSave())) {
                        model.Perjalanan p = app.getPerjalanan(j.getTxId());
                        if (p != null) {
                            model.Pelanggan pl = app.getPelanggan(j.getIdKtp());
                            if (pl != null) {
                                model.Perjalanan pj = p;
                                pj.addPelanggan(pl);
                                app.addPerjalanan(pj);
                                JOptionPane.showMessageDialog(null, "Add Transaksi Perjalanan Berhasil");
                            } else {
                                JOptionPane.showMessageDialog(null, "ID-KTP Pelanggan tidak ditemukan");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "ID Perjalanan tidak ditemukan");
                        }
                    }
                } else if (source.equals(main.getDatJalan())) {
                    dataTransaksi dj = new dataTransaksi();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(dj);
                    dj.setDatTransaksi();
                    dj.setVisible(true);
                } else if (source.equals(main.getCariJalan())) {
                    cariJalan cj = new cariJalan();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(cj);
                    cj.setVisible(true);
                    if (source.equals(cj.getBtnCari())) {
                        model.Perjalanan pj = app.getPerjalanan(cj.getTxId());
                        if (pj != null) {
                            cj.setAreaJalan(pj.toString());
                            cj.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Tidak ada");
                            cj.setVisible(true);
                        }
                    }
                } else if (source.equals(main.getDelJalan())) {
                    delJalan p = new delJalan();
                    main.setRemoveDP();
                    main.setVisible(true);
                    main.setDesktopPane(p);
                    p.setVisible(true);
                    if (source.equals(p.getBtnDel())) {
                        model.Perjalanan pj = app.getPerjalanan(p.getTxId());
                        if (pj != null) {
                            app.deletePerjalanan(p.getTxId());
                            JOptionPane.showMessageDialog(null, "Delete Data Perjalanan Wisata Berhasil");
                            p.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
                            p.setVisible(true);
                        }
                    }
                } else if (source.equals(main.getExit())) {
                    app.save();
                    JOptionPane.showMessageDialog(null, "Terima Kasih");
                    System.exit(1);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
