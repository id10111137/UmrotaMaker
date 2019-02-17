package com.example.tatangit.umrota_maker.Config.Model;

import com.google.gson.annotations.SerializedName;

public class M_Login_Item {

	@SerializedName("usia")
	private String usia;

	@SerializedName("nomor_costumer")
	private String nomorCostumer;

	@SerializedName("nomor_tlp")
	private String nomorTlp;

	@SerializedName("url_photo")
	private String urlPhoto;

	@SerializedName("nomor_passport")
	private String nomorPassport;

	@SerializedName("nomor_npwp")
	private String nomorNpwp;

	@SerializedName("password")
	private String password;

	@SerializedName("alamat_costumer")
	private String alamatCostumer;

	@SerializedName("nomor_ktp")
	private String nomorKtp;

	@SerializedName("create_date")
	private String createDate;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("nama_costumer")
	private String namaCostumer;

	@SerializedName("email")
	private String email;

	@SerializedName("nomor_kartu_kesehatan")
	private String nomorKartuKesehatan;

	@SerializedName("username")
	private String username;

	@SerializedName("status")
	private String status;

	public void setUsia(String usia){
		this.usia = usia;
	}

	public String getUsia(){
		return usia;
	}

	public void setNomorCostumer(String nomorCostumer){
		this.nomorCostumer = nomorCostumer;
	}

	public String getNomorCostumer(){
		return nomorCostumer;
	}

	public void setNomorTlp(String nomorTlp){
		this.nomorTlp = nomorTlp;
	}

	public String getNomorTlp(){
		return nomorTlp;
	}

	public void setUrlPhoto(String urlPhoto){
		this.urlPhoto = urlPhoto;
	}

	public String getUrlPhoto(){
		return urlPhoto;
	}

	public void setNomorPassport(String nomorPassport){
		this.nomorPassport = nomorPassport;
	}

	public String getNomorPassport(){
		return nomorPassport;
	}

	public void setNomorNpwp(String nomorNpwp){
		this.nomorNpwp = nomorNpwp;
	}

	public String getNomorNpwp(){
		return nomorNpwp;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setAlamatCostumer(String alamatCostumer){
		this.alamatCostumer = alamatCostumer;
	}

	public String getAlamatCostumer(){
		return alamatCostumer;
	}

	public void setNomorKtp(String nomorKtp){
		this.nomorKtp = nomorKtp;
	}

	public String getNomorKtp(){
		return nomorKtp;
	}

	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}

	public String getCreateDate(){
		return createDate;
	}

	public void setJenisKelamin(String jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public String getJenisKelamin(){
		return jenisKelamin;
	}

	public void setNamaCostumer(String namaCostumer){
		this.namaCostumer = namaCostumer;
	}

	public String getNamaCostumer(){
		return namaCostumer;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setNomorKartuKesehatan(String nomorKartuKesehatan){
		this.nomorKartuKesehatan = nomorKartuKesehatan;
	}

	public String getNomorKartuKesehatan(){
		return nomorKartuKesehatan;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"M_Login_Item{" +
			"usia = '" + usia + '\'' + 
			",nomor_costumer = '" + nomorCostumer + '\'' + 
			",nomor_tlp = '" + nomorTlp + '\'' + 
			",url_photo = '" + urlPhoto + '\'' + 
			",nomor_passport = '" + nomorPassport + '\'' + 
			",nomor_npwp = '" + nomorNpwp + '\'' + 
			",password = '" + password + '\'' + 
			",alamat_costumer = '" + alamatCostumer + '\'' + 
			",nomor_ktp = '" + nomorKtp + '\'' + 
			",create_date = '" + createDate + '\'' + 
			",jenis_kelamin = '" + jenisKelamin + '\'' + 
			",nama_costumer = '" + namaCostumer + '\'' + 
			",email = '" + email + '\'' + 
			",nomor_kartu_kesehatan = '" + nomorKartuKesehatan + '\'' + 
			",username = '" + username + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}