package com.example.tatangit.umrota_maker.View.Home.Model;

public class Model_Promo {

    String Promo;
    String Nama_Perusahaan;
    String TanggalPromo;
    String HargaPromo;
    String AlamatPerusahaan;
    String UrlImage;
    int JmlBintang;


    public Model_Promo(String UrlImage, String promo, String nama_Perusahaan, String tanggalPromo, String hargaPromo, String alamatPerusahaan, int JmlBintang) {
        this.UrlImage = UrlImage;
        this.Promo = promo;
        this.Nama_Perusahaan = nama_Perusahaan;
        this.TanggalPromo = tanggalPromo;
        this.HargaPromo = hargaPromo;
        this.AlamatPerusahaan = alamatPerusahaan;
        this.JmlBintang = JmlBintang;
    }

    public int getJmlBintang() {
        return JmlBintang;
    }

    public void setJmlBintang(int jmlBintang) {
        JmlBintang = jmlBintang;
    }

    public String getUrlPromo() {
        return UrlImage;
    }

    public void setUrlPromo(String UrlImage) {
        UrlImage = UrlImage;
    }

    public String getPromo() {
        return Promo;
    }

    public void setPromo(String promo) {
        Promo = promo;
    }

    public String getNama_Perusahaan() {
        return Nama_Perusahaan;
    }

    public void setNama_Perusahaan(String nama_Perusahaan) {
        Nama_Perusahaan = nama_Perusahaan;
    }

    public String getTanggalPromo() {
        return TanggalPromo;
    }

    public void setTanggalPromo(String tanggalPromo) {
        TanggalPromo = tanggalPromo;
    }

    public String getHargaPromo() {
        return HargaPromo;
    }

    public void setHargaPromo(String hargaPromo) {
        HargaPromo = hargaPromo;
    }

    public String getAlamatPerusahaan() {
        return AlamatPerusahaan;
    }

    public void setAlamatPerusahaan(String alamatPerusahaan) {
        AlamatPerusahaan = alamatPerusahaan;
    }


}
