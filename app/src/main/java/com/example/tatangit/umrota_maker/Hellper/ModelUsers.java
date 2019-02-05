package com.example.tatangit.umrota_maker.Hellper;

public class ModelUsers {

    private String nomor_users;
    private String nama_users;
    private String email_users;
    private String username;
    private String password;
    private String status_active;
    private String alamat_users;
    private String photo_users;
    private String nomor_ktp;
    private String nomor_passport;
    private String jenis_kelamin;
    private String nomor_kk;

    public String getNomor_users() {
        return nomor_users;
    }

    public void setNomor_users(String nomor_users) {
        this.nomor_users = nomor_users;
    }

    public String getNama_users() {
        return nama_users;
    }

    public void setNama_users(String nama_users) {
        this.nama_users = nama_users;
    }

    public String getEmail_users() {
        return email_users;
    }

    public void setEmail_users(String email_users) {
        this.email_users = email_users;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getStatus_active() {
        return status_active;
    }

    public void setStatus_active(String status_active) {
        this.status_active = status_active;
    }

    public String getAlamat_users() {
        return alamat_users;
    }

    public void setAlamat_users(String alamat_users) {
        this.alamat_users = alamat_users;
    }

    public String getPhoto_users() {
        return photo_users;
    }

    public void setPhoto_users(String photo_users) {
        this.photo_users = photo_users;
    }

    public String getNomor_ktp() {
        return nomor_ktp;
    }

    public void setNomor_ktp(String nomor_ktp) {
        this.nomor_ktp = nomor_ktp;
    }

    public String getNomor_passport() {
        return nomor_passport;
    }

    public void setNomor_passport(String nomor_passport) {
        this.nomor_passport = nomor_passport;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNomor_kk() {
        return nomor_kk;
    }

    public void setNomor_kk(String nomor_kk) {
        this.nomor_kk = nomor_kk;
    }

    public ModelUsers(String nomor_users, String nama_users, String email_users, String username, String password, String status_active, String alamat_users, String photo_users, String nomor_ktp, String nomor_passport, String jenis_kelamin, String nomor_kk) {
        this.nomor_users = nomor_users;
        this.nama_users = nama_users;
        this.email_users = email_users;
        this.username = username;
        this.password = password;
        this.status_active = status_active;
        this.alamat_users = alamat_users;
        this.photo_users = photo_users;
        this.nomor_ktp = nomor_ktp;
        this.nomor_passport = nomor_passport;
        this.jenis_kelamin = jenis_kelamin;
        this.nomor_kk = nomor_kk;
    }
}
