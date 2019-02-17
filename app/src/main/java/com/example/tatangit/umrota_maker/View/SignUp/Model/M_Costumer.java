package com.example.tatangit.umrota_maker.View.SignUp.Model;

import com.google.gson.annotations.SerializedName;

public class M_Costumer {

    private String usia;
    private String nomorCostumer;
    private String nomorTlp;
    private String urlPhoto;
    private String nomorPassport;
    private String nomorNpwp;
    private String password;
    private String alamatCostumer;
    private String nomorKtp;
    private String createDate;
    private String jenisKelamin;
    private String namaCostumer;
    private String email;
    private String nomorKartuKesehatan;
    private String username;
    private String status;

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public String getNomorCostumer() {
        return nomorCostumer;
    }

    public void setNomorCostumer(String nomorCostumer) {
        this.nomorCostumer = nomorCostumer;
    }

    public String getNomorTlp() {
        return nomorTlp;
    }

    public void setNomorTlp(String nomorTlp) {
        this.nomorTlp = nomorTlp;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getNomorPassport() {
        return nomorPassport;
    }

    public void setNomorPassport(String nomorPassport) {
        this.nomorPassport = nomorPassport;
    }

    public String getNomorNpwp() {
        return nomorNpwp;
    }

    public void setNomorNpwp(String nomorNpwp) {
        this.nomorNpwp = nomorNpwp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamatCostumer() {
        return alamatCostumer;
    }

    public void setAlamatCostumer(String alamatCostumer) {
        this.alamatCostumer = alamatCostumer;
    }

    public String getNomorKtp() {
        return nomorKtp;
    }

    public void setNomorKtp(String nomorKtp) {
        this.nomorKtp = nomorKtp;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNamaCostumer() {
        return namaCostumer;
    }

    public void setNamaCostumer(String namaCostumer) {
        this.namaCostumer = namaCostumer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomorKartuKesehatan() {
        return nomorKartuKesehatan;
    }

    public void setNomorKartuKesehatan(String nomorKartuKesehatan) {
        this.nomorKartuKesehatan = nomorKartuKesehatan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public M_Costumer(String usia, String nomorCostumer, String nomorTlp, String urlPhoto, String nomorPassport, String nomorNpwp, String password, String alamatCostumer, String nomorKtp, String createDate, String jenisKelamin, String namaCostumer, String email, String nomorKartuKesehatan, String username, String status) {
        this.usia = usia;
        this.nomorCostumer = nomorCostumer;
        this.nomorTlp = nomorTlp;
        this.urlPhoto = urlPhoto;
        this.nomorPassport = nomorPassport;
        this.nomorNpwp = nomorNpwp;
        this.password = password;
        this.alamatCostumer = alamatCostumer;
        this.nomorKtp = nomorKtp;
        this.createDate = createDate;
        this.jenisKelamin = jenisKelamin;
        this.namaCostumer = namaCostumer;
        this.email = email;
        this.nomorKartuKesehatan = nomorKartuKesehatan;
        this.username = username;
        this.status = status;
    }
}
