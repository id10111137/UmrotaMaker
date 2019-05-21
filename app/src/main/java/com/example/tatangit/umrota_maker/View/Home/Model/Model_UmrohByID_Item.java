package com.example.tatangit.umrota_maker.View.Home.Model;

import com.google.gson.annotations.SerializedName;

public class Model_UmrohByID_Item {

	@SerializedName("hotel_")
	private String hotel;

	@SerializedName("alamat_perusahaan")
	private String alamatPerusahaan;

	@SerializedName("manasik")
	private String manasik;

	@SerializedName("nama_perusahaan")
	private String namaPerusahaan;

	@SerializedName("keberangkatan")
	private String keberangkatan;

	@SerializedName("judul_umroh")
	private String judulUmroh;

	@SerializedName("harga_umroh")
	private String hargaUmroh;

	@SerializedName("max_orang_umroh")
	private String maxOrangUmroh;

	@SerializedName("min_orang_umroh")
	private String minOrangUmroh;

	@SerializedName("makanan_")
	private String makanan;

	@SerializedName("detail_umroh")
	private String detailUmroh;

	@SerializedName("logo")
	private String logo;

	@SerializedName("penerbangan_")
	private String penerbangan;

	@SerializedName("office_tlp")
	private String officeTlp;

	@SerializedName("discount_percent")
	private String discountPercent;

	@SerializedName("destinasi_")
	private String destinasi;

	@SerializedName("kepulangan")
	private String kepulangan;

	@SerializedName("pakaian")
	private String pakaian;

	@SerializedName("email")
	private String email;

	public void setHotel(String hotel){
		this.hotel = hotel;
	}

	public String getHotel(){
		return hotel;
	}

	public void setAlamatPerusahaan(String alamatPerusahaan){
		this.alamatPerusahaan = alamatPerusahaan;
	}

	public String getAlamatPerusahaan(){
		return alamatPerusahaan;
	}

	public void setManasik(String manasik){
		this.manasik = manasik;
	}

	public String getManasik(){
		return manasik;
	}

	public void setNamaPerusahaan(String namaPerusahaan){
		this.namaPerusahaan = namaPerusahaan;
	}

	public String getNamaPerusahaan(){
		return namaPerusahaan;
	}

	public void setKeberangkatan(String keberangkatan){
		this.keberangkatan = keberangkatan;
	}

	public String getKeberangkatan(){
		return keberangkatan;
	}

	public void setJudulUmroh(String judulUmroh){
		this.judulUmroh = judulUmroh;
	}

	public String getJudulUmroh(){
		return judulUmroh;
	}

	public void setHargaUmroh(String hargaUmroh){
		this.hargaUmroh = hargaUmroh;
	}

	public String getHargaUmroh(){
		return hargaUmroh;
	}

	public void setMaxOrangUmroh(String maxOrangUmroh){
		this.maxOrangUmroh = maxOrangUmroh;
	}

	public String getMaxOrangUmroh(){
		return maxOrangUmroh;
	}

	public void setMinOrangUmroh(String minOrangUmroh){
		this.minOrangUmroh = minOrangUmroh;
	}

	public String getMinOrangUmroh(){
		return minOrangUmroh;
	}

	public void setMakanan(String makanan){
		this.makanan = makanan;
	}

	public String getMakanan(){
		return makanan;
	}

	public void setDetailUmroh(String detailUmroh){
		this.detailUmroh = detailUmroh;
	}

	public String getDetailUmroh(){
		return detailUmroh;
	}

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getLogo(){
		return logo;
	}

	public void setPenerbangan(String penerbangan){
		this.penerbangan = penerbangan;
	}

	public String getPenerbangan(){
		return penerbangan;
	}

	public void setOfficeTlp(String officeTlp){
		this.officeTlp = officeTlp;
	}

	public String getOfficeTlp(){
		return officeTlp;
	}

	public void setDiscountPercent(String discountPercent){
		this.discountPercent = discountPercent;
	}

	public String getDiscountPercent(){
		return discountPercent;
	}

	public void setDestinasi(String destinasi){
		this.destinasi = destinasi;
	}

	public String getDestinasi(){
		return destinasi;
	}

	public void setKepulangan(String kepulangan){
		this.kepulangan = kepulangan;
	}

	public String getKepulangan(){
		return kepulangan;
	}

	public void setPakaian(String pakaian){
		this.pakaian = pakaian;
	}

	public String getPakaian(){
		return pakaian;
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
			"Model_UmrohByID_Item{" +
			"hotel_ = '" + hotel + '\'' + 
			",alamat_perusahaan = '" + alamatPerusahaan + '\'' + 
			",manasik = '" + manasik + '\'' + 
			",nama_perusahaan = '" + namaPerusahaan + '\'' + 
			",keberangkatan = '" + keberangkatan + '\'' + 
			",judul_umroh = '" + judulUmroh + '\'' + 
			",harga_umroh = '" + hargaUmroh + '\'' + 
			",max_orang_umroh = '" + maxOrangUmroh + '\'' + 
			",min_orang_umroh = '" + minOrangUmroh + '\'' + 
			",makanan_ = '" + makanan + '\'' + 
			",detail_umroh = '" + detailUmroh + '\'' + 
			",logo = '" + logo + '\'' + 
			",penerbangan_ = '" + penerbangan + '\'' + 
			",office_tlp = '" + officeTlp + '\'' + 
			",discount_percent = '" + discountPercent + '\'' + 
			",destinasi_ = '" + destinasi + '\'' + 
			",kepulangan = '" + kepulangan + '\'' + 
			",pakaian = '" + pakaian + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}