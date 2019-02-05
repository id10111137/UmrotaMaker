package com.example.tatangit.umrota_maker.View.Home.Model;

public class Model_Company_Gallery {

    public String Nomor_Image;
    public String Url_Image;
    public String Description_Image;
    public String Nomor_Perusahaan;

    public Model_Company_Gallery(String nomor_Image, String url_Image, String description_Image, String nomor_Perusahaan) {
        Nomor_Image = nomor_Image;
        Url_Image = url_Image;
        Description_Image = description_Image;
        Nomor_Perusahaan = nomor_Perusahaan;
    }

    public String getNomor_Image() {
        return Nomor_Image;
    }

    public void setNomor_Image(String nomor_Image) {
        Nomor_Image = nomor_Image;
    }

    public String getUrl_Image() {
        return Url_Image;
    }

    public void setUrl_Image(String url_Image) {
        Url_Image = url_Image;
    }

    public String getDescription_Image() {
        return Description_Image;
    }

    public void setDescription_Image(String description_Image) {
        Description_Image = description_Image;
    }

    public String getNomor_Perusahaan() {
        return Nomor_Perusahaan;
    }

    public void setNomor_Perusahaan(String nomor_Perusahaan) {
        Nomor_Perusahaan = nomor_Perusahaan;
    }



}
