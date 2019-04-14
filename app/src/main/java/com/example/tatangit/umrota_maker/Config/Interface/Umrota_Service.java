package com.example.tatangit.umrota_maker.Config.Interface;

import com.example.tatangit.umrota_maker.Config.Model.M_Company;
import com.example.tatangit.umrota_maker.Config.Model.M_Company_Umroh;
import com.example.tatangit.umrota_maker.Config.Model.M_Promo;
import com.example.tatangit.umrota_maker.Config.Model.M_Register;
import com.example.tatangit.umrota_maker.View.Home.Model.ModelCompanyInfo;
import com.example.tatangit.umrota_maker.View.Home.Model.ModelCompanyStore;
import com.example.tatangit.umrota_maker.View.Home.Model.ModelGalleryCompany;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Company_Gallery;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_UmrohByID;
import com.example.tatangit.umrota_maker.View.SignUp.Model.ModelUploadDoc;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_User;
import com.example.tatangit.umrota_maker.View.SignUp.Model.RUploadImage;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface Umrota_Service {

    @POST("Umrota_Company/ListCompany")
    @FormUrlEncoded
    Call<M_Company> postAllCompany(@Field("nama_perusahaan") String nama_perusahaan, @Field("alamat_perusahaan") String alamat_perusahaan);


    @POST("Umrota/UmrotaPacketByID")
    @FormUrlEncoded
    Call<Model_UmrohByID> getUmrohByID(@Field("nomor_umroh") String nomor_umroh);


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

    @PUT("Umrota_Costumer/Costumer_Update")
    @FormUrlEncoded
    Call<Model_User> cProfil(
            @Field("nomor_costumer") String nomor_costumer,
            @Field("nama_costumer") String nama_costumer,
            @Field("alamat_costumer") String id_alamat,
            @Field("nomor_tlp") String alamat_costumer,
            @Field("nomor_npwp") String nomor_npwp,
            @Field("nomor_passport") String nomor_passport,
            @Field("nomor_ktp") String nomor_ktp,
            @Field("email") String email,
            @Field("usia") String usia,
            @Field("jenis_kelamin") String jenis_kelamin,
            @Field("create_date") String create_date,
            @Field("nomor_kartu_kesehatan") String nomor_kartu_kesehatan,
            @Field("username") String username,
            @Field("password") String password


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


    @FormUrlEncoded
    @POST("Umrota_Costumer/Upload_Document")
    Call<RUploadImage> uImage(
            @Field("imageurl") String imageurl,
            @Field("NameImage") String NameImage,
            @Field("CreateDate") String CreateDate,
            @Field("nomor_costumer") String nomor_costumer);


    @FormUrlEncoded
    @POST("Umrota_Costumer/Ambil_Gambar")
    Call<ModelUploadDoc> gGambar(@Field("nomor_costumer") String nomor_costumer);


    @FormUrlEncoded
    @POST("Umrota_Company/AmbilGallery")
    Call<ModelGalleryCompany> gGallery(@Field("nomor_company") String nomor_company);

    @FormUrlEncoded
    @POST("Umrota_Company/AmbilCompanyInfo")
    Call<ModelCompanyInfo> gCompanyInfo(@Field("nomor_company") String nomor_company);

    @FormUrlEncoded
    @POST("Umrota_Company/AmbilCompanyStore")
    Call<ModelCompanyStore> gCompanyStore(@Field("nomor_company") String nomor_company);

}
