package com.example.tatangit.umrota_maker.Hellper;

public class ShareData {
    private volatile static ShareData shareData;

    public static ShareData data() {
        if (shareData == null) {
            synchronized (ShareData.class) {
                if (shareData == null) {
                    shareData = new ShareData();
                }
            }
        }
        return shareData;
    }

    public String value;
}