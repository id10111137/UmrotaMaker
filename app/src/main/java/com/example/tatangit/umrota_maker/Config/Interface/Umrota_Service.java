package com.example.tatangit.umrota_maker.Config.Interface;

import com.example.tatangit.umrota_maker.Config.Model.M_Company;
import com.example.tatangit.umrota_maker.Config.Model.M_Company_Umroh;
import com.example.tatangit.umrota_maker.Config.Model.M_Login;
import com.example.tatangit.umrota_maker.Config.Model.M_Promo;
import com.example.tatangit.umrota_maker.Config.Model.M_Register;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Umrota_Service {

    @GET("Umrota_Company/ListCompany")
    Call<M_Company> getAllCompany();

    @POST("Umrota/Umrota")
    @FormUrlEncoded
    Call<M_Company_Umroh> getAllUmrohCompany(@Field("nomor_company") String nomor_company);

    @GET("Umrota/UmrotaPromo")
    Call<M_Promo> getAllUmrohCompany();


    @POST("Umrota_Costumer/Costumer_Regisiter")
    @FormUrlEncoded
    Call<M_Register> RegisterCostumer(
            @Field("nama_costumer") String nama_costumer,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("nomor_tlp") String nomor_tlp
    );

    @POST("Umrota_Costumer/Costumer_Login")
    @FormUrlEncoded
    Call<M_Login> LoginCostumer(
            @Field("username") String username,
            @Field("password") String password
    );

}
