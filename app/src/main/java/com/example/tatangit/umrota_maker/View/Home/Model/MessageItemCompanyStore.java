package com.example.tatangit.umrota_maker.View.Home.Model;

import com.google.gson.annotations.SerializedName;

public class MessageItemCompanyStore {

	@SerializedName("alamat_store")
	private String alamatStore;

	@SerializedName("lat_")
	private Object lat;

	@SerializedName("no_tlp")
	private Object noTlp;

	@SerializedName("nomor_company_store")
	private String nomorCompanyStore;

	@SerializedName("nomor_company")
	private String nomorCompany;

	@SerializedName("nama_store")
	private String namaStore;

	@SerializedName("jam_kerja")
	private String jamKerja;

	@SerializedName("photo")
	private Object photo;

	@SerializedName("lot_")
	private Object lot;

	@SerializedName("email")
	private String email;

	public void setAlamatStore(String alamatStore){
		this.alamatStore = alamatStore;
	}

	public String getAlamatStore(){
		return alamatStore;
	}

	public void setLat(Object lat){
		this.lat = lat;
	}

	public Object getLat(){
		return lat;
	}

	public void setNoTlp(Object noTlp){
		this.noTlp = noTlp;
	}

	public Object getNoTlp(){
		return noTlp;
	}

	public void setNomorCompanyStore(String nomorCompanyStore){
		this.nomorCompanyStore = nomorCompanyStore;
	}

	public String getNomorCompanyStore(){
		return nomorCompanyStore;
	}

	public void setNomorCompany(String nomorCompany){
		this.nomorCompany = nomorCompany;
	}

	public String getNomorCompany(){
		return nomorCompany;
	}

	public void setNamaStore(String namaStore){
		this.namaStore = namaStore;
	}

	public String getNamaStore(){
		return namaStore;
	}

	public void setJamKerja(String jamKerja){
		this.jamKerja = jamKerja;
	}

	public String getJamKerja(){
		return jamKerja;
	}

	public void setPhoto(Object photo){
		this.photo = photo;
	}

	public Object getPhoto(){
		return photo;
	}

	public void setLot(Object lot){
		this.lot = lot;
	}

	public Object getLot(){
		return lot;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"MessageItemCompanyStore{" +
			"alamat_store = '" + alamatStore + '\'' + 
			",lat_ = '" + lat + '\'' + 
			",no_tlp = '" + noTlp + '\'' + 
			",nomor_company_store = '" + nomorCompanyStore + '\'' + 
			",nomor_company = '" + nomorCompany + '\'' + 
			",nama_store = '" + namaStore + '\'' + 
			",jam_kerja = '" + jamKerja + '\'' + 
			",photo = '" + photo + '\'' + 
			",lot_ = '" + lot + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}