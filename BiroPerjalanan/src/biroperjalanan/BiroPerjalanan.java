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
        Petugas p = new Petugas("Muhammad", "Jl. GOR", 885458);
        p.setId(0001);
        p.setUserName("Hamba Allah");
        p.setPass("hamba");

        Pelanggan pl1 = new Pelanggan("Arif", "Komplek PU", 896751);
        pl1.setIdKTP(131022128);
        Pelanggan pl2 = new Pelanggan("Kurniawan", "Toga", 221244);
        pl2.setIdKTP(130921219);
        Pelanggan pl3 = new Pelanggan("Selvi", "PGA", 140145);
        pl3.setIdKTP(131012145);
        Pelanggan pl4 = new Pelanggan("Aliya", "Moh. Toha", 142414);
        pl4.setIdKTP(130931342);

        TempatWisata tmp1 = new TempatWisata("WST001", "Jatim Park", "Malang");
        TempatWisata tmp2 = new TempatWisata("WST002", "Pulau Sempu", "Malang");
        TempatWisata tmp3 = new TempatWisata("WST003", "Balekambang", "Malang");
        TempatWisata tmp4 = new TempatWisata("WST004", "Kawah Putih", "Bandung");
        TempatWisata tmp5 = new TempatWisata("WST005", "Situ Patenggang", "Bandung");
        TempatWisata tmp6 = new TempatWisata("WST006", "Tangkuban Perahu", "Bandung");
        
        PaketWisata pkt1 = new PaketWisata("PKT001");
        pkt1.addTempatWisata(tmp1);
        pkt1.addTempatWisata(tmp2);
        pkt1.addTempatWisata(tmp3);
       

        Perjalanan jln1 = new Perjalanan("JLN001");
        jln1.addPelanggan(pl1);
        jln1.addPelanggan(pl2);
        jln1.addPelanggan(pl3);
        jln1.addPelanggan(pl4);
        jln1.setPaket(pkt1);
        jln1.setHarga(900000);

        System.out.println("==============Data Perjalanan===============");
        System.out.println("Pelanggan: ");
        for (int i = 0; i < jln1.getJumlahPelanggan(); i++) {
            System.out.println((i+1)+". "+jln1.getPelanggan(i).getNama());
        }
        System.out.println("Tempat Wisata: ");
        for (int j = 0; j < jln1.getPaket().getJumlahWisata(); j++) {
            System.out.println((j + 1) + ". " + jln1.getPaket().getTempatWisata(j).getNama());
        }
        System.out.println("Harga: RP." + jln1.getHarga()+",-/orang");
    }
    
}
