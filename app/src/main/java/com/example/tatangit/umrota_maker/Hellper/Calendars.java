package com.example.tatangit.umrota_maker.Hellper;

import java.util.Calendar;

public class Calendars {

    private Calendar calendar;
    private int mYear, mMonth, mDay;
    private String mMonthChoose = "January";

    public Calendars() {
        this.calendar = Calendar.getInstance();
    }

    public int getDay() {
        return mYear = calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getMonth() {
        return mYear = calendar.get(Calendar.MONTH);
    }

    public int getYearh() {
        return mYear = calendar.get(Calendar.YEAR);
    }


    public String getDateMonthYearh(int mYears, int mMonths, int mDays) {

        return Integer.toString(mDays) + " - " + ConvertMonth(mMonths) + " - " + mYears;

    }

    private String ConvertMonth(int mMonths) {

        if (mMonths == 1) {
            mMonthChoose = "January";
        } else if (mMonths == 2) {
            mMonthChoose = "Febuary";
        } else if (mMonths == 3) {
            mMonthChoose = "Maret";
        } else if (mMonths == 4) {
            mMonthChoose = "April";
        } else if (mMonths == 5) {
            mMonthChoose = "Mei";
        } else if (mMonths == 6) {
            mMonthChoose = "Juni";
        } else if (mMonths == 7) {
            mMonthChoose = "July";
        } else if (mMonths == 8) {
            mMonthChoose = "Agustus";
        } else if (mMonths == 9) {
            mMonthChoose = "September";
        } else if (mMonths == 10) {
            mMonthChoose = "Oktober";
        } else if (mMonths == 11) {
            mMonthChoose = "November";
        } else if (mMonths == 12) {
            mMonthChoose = "Desember";
        }
        return mMonthChoose;
    }

}
