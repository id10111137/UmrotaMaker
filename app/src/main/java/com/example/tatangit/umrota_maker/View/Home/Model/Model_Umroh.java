package com.example.tatangit.umrota_maker.View.Home.Model;

public class Model_Umroh {

    String Url_Image;
    String Nama_Perusahaan;
    String Alamat;
    String Layanan;
    String TotalPenerbangan;

    public Model_Umroh(String url_Image, String nama_Perusahaan, String alamat, String layanan, String totalPenerbangan) {
        Url_Image = url_Image;
        Nama_Perusahaan = nama_Perusahaan;
        Alamat = alamat;
        Layanan = layanan;
        TotalPenerbangan = totalPenerbangan;
    }

    public String getUrl_Image() {
        return Url_Image;
    }

    public void setUrl_Image(String url_Image) {
        Url_Image = url_Image;
    }

    public String getNama_Perusahaan() {
        return Nama_Perusahaan;
    }

    public void setNama_Perusahaan(String nama_Perusahaan) {
        Nama_Perusahaan = nama_Perusahaan;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getLayanan() {
        return Layanan;
    }

    public void setLayanan(String layanan) {
        Layanan = layanan;
    }

    public String getTotalPenerbangan() {
        return TotalPenerbangan;
    }

    public void setTotalPenerbangan(String totalPenerbangan) {
        TotalPenerbangan = totalPenerbangan;
    }


}
