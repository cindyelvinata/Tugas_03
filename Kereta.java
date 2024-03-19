public class Kereta {
    private Ticket ticket;
    private int jumlahTiketygAda;
    private String namaKereta;

    // Constructor default buat objek kereta
    public Kereta() {
        ticket = new Ticket("", 0);
        jumlahTiketygAda = 1000;
    }

    // Constructor buat objek kereta
    public Kereta(String namaKeretanyaApa, int jumlahTiketnya) {
        this.namaKereta = namaKeretanyaApa;
        ticket = new Ticket(namaKeretanyaApa, jumlahTiketnya);
        jumlahTiketygAda = jumlahTiketnya;
    }

    // Method buat yang komuter
    public void tambahTiket(String namaPenumpang) {
        if (jumlahTiketygAda > 0) {
            System.out.println("==================================================");
            System.out.println("Tiket berhasil dipesan");

            jumlahTiketygAda--;
            String[] namaPenumpangArray = ticket.getNamaPenumpang();
            if (namaPenumpangArray == null) {
                ticket.setNamaPenumpang(new String[]{namaPenumpang});
            } else {
                String[] newNamaPenumpang = new String[namaPenumpangArray.length + 1];
                for (int i = 0; i < namaPenumpangArray.length; i++) {
                    newNamaPenumpang[i] = namaPenumpangArray[i];
                }
                // Menambah nama penumpang lagi
                newNamaPenumpang[namaPenumpangArray.length] = namaPenumpang;
                ticket.setNamaPenumpang(newNamaPenumpang);
            }
        }
    }

    // Method buat yang KAJJ
    public void tambahTiket(String namaPenumpang, String asal, String tujuan) {
        if (jumlahTiketygAda > 0) {
            System.out.println("==================================================");

            jumlahTiketygAda--;
            String[] namaPenumpangArray = ticket.getNamaPenumpang();
            String[] asalArray = ticket.getAsal();
            String[] tujuanArray = ticket.getTujuan();
            if (namaPenumpangArray == null) {
                ticket.setNamaPenumpang(new String[]{namaPenumpang});
                ticket.setAsal(new String[]{asal});
                ticket.setTujuan(new String[]{tujuan});
            } else {
                String[] newNamaPenumpang = new String[namaPenumpangArray.length + 1];
                String[] newAsal = new String[asalArray.length + 1];
                String[] newTujuan = new String[tujuanArray.length + 1];
                for (int i = 0; i < namaPenumpangArray.length; i++) {
                    newNamaPenumpang[i] = namaPenumpangArray[i];
                    newAsal[i] = asalArray[i];
                    newTujuan[i] = tujuanArray[i];
                }
                // Menambah data penumpang lagi
                newNamaPenumpang[namaPenumpangArray.length] = namaPenumpang;
                newAsal[asalArray.length] = asal;
                newTujuan[tujuanArray.length] = tujuan;
                ticket.setNamaPenumpang(newNamaPenumpang);
                ticket.setAsal(newAsal);
                ticket.setTujuan(newTujuan);
            }
            if (jumlahTiketygAda < 30) {
                System.out.println("Tiket berhasil dipesan Sisa tiket tersedia: " + jumlahTiketygAda);
            }
        } else {
            System.out.println("==================================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
            System.out.println("==================================================");
        }
    }

    // Tampilan buat kereta komuter
    public void tampilkanTiket() {
        if (namaKereta != null) {
            System.out.println("Daftar penumpang kereta api " + namaKereta);
            System.out.println("----------------------------");
        } else {
            System.out.println("==================================================");
            System.out.println("Daftar penumpang kereta api komuter:");
            System.out.println("----------------------------");
            String[] namaPenumpang = ticket.getNamaPenumpang();
            if (namaPenumpang != null) {
                for (String penumpang : namaPenumpang) {
                    System.out.println("Nama: " + penumpang);
                }
            }
            return;
        }

        // Tampilan buat KAJJ
        String[] namaPenumpang = ticket.getNamaPenumpang();
        String[] asal = ticket.getAsal();
        String[] tujuan = ticket.getTujuan();
        if (namaPenumpang != null) {
            if (namaKereta.equals("Jayabaya")) {
                for (int i = 0; i < Math.min(namaPenumpang.length, 2); i++) {
                    System.out.println("Nama: " + namaPenumpang[i]);
                    if (asal != null && tujuan != null) {
                        System.out.println("Asal: " + asal[i]);
                        System.out.println("Tujuan: " + tujuan[i]);
                    }
                    if (i == 0 && namaPenumpang.length > 1) {
                        System.out.println("----------------------------");
                    }
                }
                System.out.println("----------------------------");
            } else if (namaKereta.equals("komuter")) {
                for (String penumpang : namaPenumpang) {
                    System.out.println("Nama: " + penumpang);
                }
            }
        }
    }
}