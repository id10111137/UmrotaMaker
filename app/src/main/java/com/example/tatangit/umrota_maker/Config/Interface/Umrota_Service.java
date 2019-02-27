package com.example.tatangit.umrota_maker.Config.Interface;

import com.example.tatangit.umrota_maker.Config.Model.M_Company;
import com.example.tatangit.umrota_maker.Config.Model.M_Company_Umroh;
import com.example.tatangit.umrota_maker.Config.Model.M_Promo;
import com.example.tatangit.umrota_maker.Config.Model.M_Register;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_User;

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
    Call<Model_User> LoginCostumer(
            @Field("username") String username,
            @Field("password") String password
    );

    @POST("Umrota_Costumer/Costumer_Profil")
    @FormUrlEncoded
    Call<Model_User> cProfil(
            @Field("nomorCostumer") String nomorCostumer,
            @Field("id_nama") String id_nama,
            @Field("id_alamat") String id_alamat,
            @Field("id_notlp") String id_notlp,
            @Field("id_nonpwp") String id_nonpwp,
            @Field("id_nopassport") String id_nopassport,
            @Field("id_nomor_ktp") String id_nomor_ktp,
            @Field("id_email") String id_email,
            @Field("id_usia") String id_usia,
            @Field("id_jk") String id_jk,
            @Field("id_nokartukesehatan") String id_nokartukesehatan,
            @Field("id_username") String id_username,
            @Field("id_password") String id_password
    );


    @POST("Umrota_Costumer/Costumer_Regisiter")
    @FormUrlEncoded
    Call<Model_User> cRegister(
            @Field("id_namacostumer") String id_namacostumer,
            @Field("id_username") String id_username,
            @Field("id_password") String id_password,
            @Field("id_email") String id_email,
            @Field("id_phone") String id_phone
    );












}
