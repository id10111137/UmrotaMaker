package com.example.tatangit.umrota_maker.Config.Model;

import com.google.gson.annotations.SerializedName;

public class M_PromoItem {

	@SerializedName("alamat_perusahaan")
	private String alamatPerusahaan;

	@SerializedName("hotel_")
	private String hotel;

	@SerializedName("manasik")
	private String manasik;

	@SerializedName("nomor_umroh")
	private String nomorUmroh;

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

	@SerializedName("lat_alamat")
	private Object latAlamat;

	@SerializedName("min_orang_umroh")
	private String minOrangUmroh;

	@SerializedName("makanan_")
	private String makanan;

	@SerializedName("detail_umroh")
	private String detailUmroh;

	@SerializedName("nomor_umroh_fasilitas")
	private String nomorUmrohFasilitas;

	@SerializedName("lot_alamt")
	private Object lotAlamt;

	@SerializedName("logo")
	private String logo;

	@SerializedName("penerbangan_")
	private String penerbangan;

	@SerializedName("discount_percent")
	private String discountPercent;

	@SerializedName("jenis_perusahaan")
	private String jenisPerusahaan;

	@SerializedName("destinasi_")
	private String destinasi;

	@SerializedName("kepulangan")
	private String kepulangan;

	@SerializedName("pakaian")
	private String pakaian;

	@SerializedName("email")
	private String email;

	public void setAlamatPerusahaan(String alamatPerusahaan){
		this.alamatPerusahaan = alamatPerusahaan;
	}

	public String getAlamatPerusahaan(){
		return alamatPerusahaan;
	}

	public void setHotel(String hotel){
		this.hotel = hotel;
	}

	public String getHotel(){
		return hotel;
	}

	public void setManasik(String manasik){
		this.manasik = manasik;
	}

	public String getManasik(){
		return manasik;
	}

	public void setNomorUmroh(String nomorUmroh){
		this.nomorUmroh = nomorUmroh;
	}

	public String getNomorUmroh(){
		return nomorUmroh;
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

	public void setLatAlamat(Object latAlamat){
		this.latAlamat = latAlamat;
	}

	public Object getLatAlamat(){
		return latAlamat;
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

	public void setNomorUmrohFasilitas(String nomorUmrohFasilitas){
		this.nomorUmrohFasilitas = nomorUmrohFasilitas;
	}

	public String getNomorUmrohFasilitas(){
		return nomorUmrohFasilitas;
	}

	public void setLotAlamt(Object lotAlamt){
		this.lotAlamt = lotAlamt;
	}

	public Object getLotAlamt(){
		return lotAlamt;
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

	public void setDiscountPercent(String discountPercent){
		this.discountPercent = discountPercent;
	}

	public String getDiscountPercent(){
		return discountPercent;
	}

	public void setJenisPerusahaan(String jenisPerusahaan){
		this.jenisPerusahaan = jenisPerusahaan;
	}

	public String getJenisPerusahaan(){
		return jenisPerusahaan;
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
			"M_PromoItem{" +
			"alamat_perusahaan = '" + alamatPerusahaan + '\'' + 
			",hotel_ = '" + hotel + '\'' + 
			",manasik = '" + manasik + '\'' + 
			",nomor_umroh = '" + nomorUmroh + '\'' + 
			",nama_perusahaan = '" + namaPerusahaan + '\'' + 
			",keberangkatan = '" + keberangkatan + '\'' + 
			",judul_umroh = '" + judulUmroh + '\'' + 
			",harga_umroh = '" + hargaUmroh + '\'' + 
			",max_orang_umroh = '" + maxOrangUmroh + '\'' + 
			",lat_alamat = '" + latAlamat + '\'' + 
			",min_orang_umroh = '" + minOrangUmroh + '\'' + 
			",makanan_ = '" + makanan + '\'' + 
			",detail_umroh = '" + detailUmroh + '\'' + 
			",nomor_umroh_fasilitas = '" + nomorUmrohFasilitas + '\'' + 
			",lot_alamt = '" + lotAlamt + '\'' + 
			",logo = '" + logo + '\'' + 
			",penerbangan_ = '" + penerbangan + '\'' + 
			",discount_percent = '" + discountPercent + '\'' + 
			",jenis_perusahaan = '" + jenisPerusahaan + '\'' + 
			",destinasi_ = '" + destinasi + '\'' + 
			",kepulangan = '" + kepulangan + '\'' + 
			",pakaian = '" + pakaian + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}