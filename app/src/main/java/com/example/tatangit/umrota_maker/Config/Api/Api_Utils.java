package com.example.tatangit.umrota_maker.Config.Api;

import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;

public class Api_Utils {

    public static final String BASE_URL = "http://api.umrota.com/index.php/";

    public static Umrota_Service getSOService() {
        return Umrota_Client.getClient(BASE_URL).create(Umrota_Service.class);
    }

}
