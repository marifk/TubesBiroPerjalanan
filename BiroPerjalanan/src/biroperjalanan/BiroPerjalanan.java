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
public class BiroPerjalanan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Petugas p = new Petugas("PGW-001","Hamba Allah","hamba","Muhammad", "Jl. GOR", 885458);
       

        Pelanggan pl1 = new Pelanggan(131022128,"Arif", "Komplek PU", 896751);
       
        Pelanggan pl2 = new Pelanggan(130921219,"Kurniawan", "Toga", 221244);
        
        Pelanggan pl3 = new Pelanggan(131012145,"Selvi", "PGA", 140145);
        
        Pelanggan pl4 = new Pelanggan(130931342,"Aliya", "Moh. Toha", 142414);
       

        TempatWisata tmp1 = new TempatWisata("WST001", "Jatim Park", "Malang");
        TempatWisata tmp2 = new TempatWisata("WST002", "Pulau Sempu", "Malang");
        TempatWisata tmp3 = new TempatWisata("WST003", "Balekambang", "Malang");
        TempatWisata tmp4 = new TempatWisata("WST004", "Kawah Putih", "Bandung");
        TempatWisata tmp5 = new TempatWisata("WST005", "Situ Patenggang", "Bandung");
        TempatWisata tmp6 = new TempatWisata("WST006", "Tangkuban Perahu", "Bandung");
        
        PaketWisata pkt1 = new PaketWisata("PKT001",90000000);
        pkt1.addTempatWisata(tmp1);
        pkt1.addTempatWisata(tmp2);
        pkt1.addTempatWisata(tmp3);

        Perjalanan jln1 = new Perjalanan("JLN001","14-06-2016",4);
        jln1.addPelanggan(pl1);
        jln1.addPelanggan(pl2);
        jln1.addPelanggan(pl3);
        jln1.addPelanggan(pl4);
        jln1.setPaket(pkt1);
        System.out.println("==============Data Perjalanan===============");
        System.out.println("Pelanggan: ");
        for (int i = 0; i < jln1.getJumlahPelanggan(); i++) {
            System.out.println((i+1)+". "+jln1.getPelanggan(i).getNama());
        }
        System.out.println("Tempat Wisata: ");
        for (int j = 0; j < jln1.getPaket().getJumlahWisata(); j++) {
            System.out.println((j + 1) + ". " + jln1.getPaket().getTempatWisata(j).getNama());
        }
        System.out.println("Tanggal: "+jln1.getTanggal());
        System.out.println("Harga: RP." + jln1.getPaket().getHarga()+",-/orang");
    }
    
}