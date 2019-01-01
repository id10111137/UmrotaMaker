package com.example.tatangit.umrota_maker.View.Home.Model;

import android.support.v7.app.AppCompatActivity;

public class Model_DCompany extends AppCompatActivity {


    String UrlDCompany;
    int CompanyNamber;
    String NameCompany;
    String SubjectTraveling;
    String DDeparture;
    String DArrival;
    int Qty;
    int Booking;

    public Model_DCompany(String urlDCompany, int companyNamber, String nameCompany, String subjectTraveling, String DDeparture, String DArrival, int qty, int booking) {
        this.UrlDCompany = urlDCompany;
        this.CompanyNamber = companyNamber;
        this.NameCompany = nameCompany;
        this.SubjectTraveling = subjectTraveling;
        this.DDeparture = DDeparture;
        this.DArrival = DArrival;
        this.Qty = qty;
        this.Booking = booking;
    }

    public String getUrlDCompany() {
        return UrlDCompany;
    }

    public void setUrlDCompany(String urlDCompany) {
        UrlDCompany = urlDCompany;
    }

    public int getCompanyNamber() {
        return CompanyNamber;
    }

    public void setCompanyNamber(int companyNamber) {
        CompanyNamber = companyNamber;
    }

    public String getNameCompany() {
        return NameCompany;
    }

    public void setNameCompany(String nameCompany) {
        NameCompany = nameCompany;
    }

    public String getSubjectTraveling() {
        return SubjectTraveling;
    }

    public void setSubjectTraveling(String subjectTraveling) {
        SubjectTraveling = subjectTraveling;
    }

    public String getDDeparture() {
        return DDeparture;
    }

    public void setDDeparture(String DDeparture) {
        this.DDeparture = DDeparture;
    }

    public String getDArrival() {
        return DArrival;
    }

    public void setDArrival(String DArrival) {
        this.DArrival = DArrival;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public int getBooking() {
        return Booking;
    }

    public void setBooking(int booking) {
        Booking = booking;
    }


}
