package com.example.tatangit.umrota_maker.View.SignUp.Model;

public class Model_MyDoc {


    String NameImage;
    String UrlImage;
    String SizeImage;
    String Nomor_DocID;


    public Model_MyDoc(String nameImage, String urlImage, String sizeImage, String nomor_DocID) {
        NameImage = nameImage;
        UrlImage = urlImage;
        SizeImage = sizeImage;
        Nomor_DocID = nomor_DocID;
    }


    public String getNameImage() {
        return NameImage;
    }

    public void setNameImage(String nameImage) {
        NameImage = nameImage;
    }

    public String getUrlImage() {
        return UrlImage;
    }

    public void setUrlImage(String urlImage) {
        UrlImage = urlImage;
    }

    public String getSizeImage() {
        return SizeImage;
    }

    public void setSizeImage(String sizeImage) {
        SizeImage = sizeImage;
    }

    public String getNomor_DocID() {
        return Nomor_DocID;
    }

    public void setNomor_DocID(String nomor_DocID) {
        Nomor_DocID = nomor_DocID;
    }


}
