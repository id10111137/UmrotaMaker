package com.example.tatangit.umrota_maker.Config.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class MessageItem{

	@SerializedName("alamat_perusahaan")
	private String alamatPerusahaan;

	@SerializedName("mobile_tlp")
	private String mobileTlp;

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

	@SerializedName("detail_umroh")
	private String detailUmroh;

	@SerializedName("nomor_company")
	private String nomorCompany;

	@SerializedName("lot_alamt")
	private Object lotAlamt;

	@SerializedName("logo")
	private String logo;

	@SerializedName("office_tlp")
	private String officeTlp;

	@SerializedName("no_npwp")
	private Object noNpwp;

	@SerializedName("email")
	private String email;

	@SerializedName("kepulangan")
	private String kepulangan;

	@SerializedName("tanggal_posting")
	private String tanggalPosting;

	public void setAlamatPerusahaan(String alamatPerusahaan){
		this.alamatPerusahaan = alamatPerusahaan;
	}

	public String getAlamatPerusahaan(){
		return alamatPerusahaan;
	}

	public void setMobileTlp(String mobileTlp){
		this.mobileTlp = mobileTlp;
	}

	public String getMobileTlp(){
		return mobileTlp;
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

	public void setDetailUmroh(String detailUmroh){
		this.detailUmroh = detailUmroh;
	}

	public String getDetailUmroh(){
		return detailUmroh;
	}

	public void setNomorCompany(String nomorCompany){
		this.nomorCompany = nomorCompany;
	}

	public String getNomorCompany(){
		return nomorCompany;
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

	public void setOfficeTlp(String officeTlp){
		this.officeTlp = officeTlp;
	}

	public String getOfficeTlp(){
		return officeTlp;
	}

	public void setNoNpwp(Object noNpwp){
		this.noNpwp = noNpwp;
	}

	public Object getNoNpwp(){
		return noNpwp;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setKepulangan(String kepulangan){
		this.kepulangan = kepulangan;
	}

	public String getKepulangan(){
		return kepulangan;
	}

	public void setTanggalPosting(String tanggalPosting){
		this.tanggalPosting = tanggalPosting;
	}

	public String getTanggalPosting(){
		return tanggalPosting;
	}

	@Override
 	public String toString(){
		return 
			"MessageItem{" + 
			"alamat_perusahaan = '" + alamatPerusahaan + '\'' + 
			",mobile_tlp = '" + mobileTlp + '\'' + 
			",nomor_umroh = '" + nomorUmroh + '\'' + 
			",nama_perusahaan = '" + namaPerusahaan + '\'' + 
			",keberangkatan = '" + keberangkatan + '\'' + 
			",judul_umroh = '" + judulUmroh + '\'' + 
			",harga_umroh = '" + hargaUmroh + '\'' + 
			",max_orang_umroh = '" + maxOrangUmroh + '\'' + 
			",lat_alamat = '" + latAlamat + '\'' + 
			",min_orang_umroh = '" + minOrangUmroh + '\'' + 
			",detail_umroh = '" + detailUmroh + '\'' + 
			",nomor_company = '" + nomorCompany + '\'' + 
			",lot_alamt = '" + lotAlamt + '\'' + 
			",logo = '" + logo + '\'' + 
			",office_tlp = '" + officeTlp + '\'' + 
			",no_npwp = '" + noNpwp + '\'' + 
			",email = '" + email + '\'' + 
			",kepulangan = '" + kepulangan + '\'' + 
			",tanggal_posting = '" + tanggalPosting + '\'' + 
			"}";
		}
}