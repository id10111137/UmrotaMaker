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

    public int getHour() {
        return mYear = calendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinute() {
        return mYear = calendar.get(Calendar.MINUTE);
    }

    public int getSecond() {
        return mYear = calendar.get(Calendar.MILLISECOND);
    }


}
