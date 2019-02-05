package com.example.tatangit.umrota_maker.View.Home.Model;

public class Model_Store {


    public String nomor_store;
    public String nama_store;
    public String alamat_store;
    public String nomor_telp;
    public String open_toko;
    public String Url_ImageToko;

    public String getUrl_ImageToko() {
        return Url_ImageToko;
    }

    public void setUrl_ImageToko(String url_ImageToko) {
        Url_ImageToko = url_ImageToko;
    }

    public String getNomor_store() {
        return nomor_store;
    }

    public void setNomor_store(String nomor_store) {
        this.nomor_store = nomor_store;
    }

    public String getNama_store() {
        return nama_store;
    }

    public void setNama_store(String nama_store) {
        this.nama_store = nama_store;
    }

    public String getAlamat_store() {
        return alamat_store;
    }

    public void setAlamat_store(String alamat_store) {
        this.alamat_store = alamat_store;
    }

    public String getNomor_telp() {
        return nomor_telp;
    }

    public void setNomor_telp(String nomor_telp) {
        this.nomor_telp = nomor_telp;
    }

    public String getOpen_toko() {
        return open_toko;
    }

    public void setOpen_toko(String open_toko) {
        this.open_toko = open_toko;
    }

    public Model_Store(String nomor_store, String nama_store, String alamat_store, String nomor_telp, String open_toko, String Url_ImageToko) {
        this.nomor_store = nomor_store;
        this.nama_store = nama_store;
        this.alamat_store = alamat_store;
        this.nomor_telp = nomor_telp;
        this.open_toko = open_toko;
        this.Url_ImageToko = Url_ImageToko;
    }

}
