package com.example.tatangit.umrota_maker.Config.Model;

import com.google.gson.annotations.SerializedName;

public class M_Company_Item {

	@SerializedName("alamat_perusahaan")
	private String alamatPerusahaan;

	@SerializedName("mobile_tlp")
	private String mobileTlp;

	@SerializedName("status_perusahaan")
	private String statusPerusahaan;

	@SerializedName("no_siup")
	private Object noSiup;

	@SerializedName("nama_perusahaan")
	private String namaPerusahaan;

	@SerializedName("lat_alamat")
	private Object latAlamat;

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

	@SerializedName("create_date")
	private Object createDate;

	@SerializedName("jenis_perusahaan")
	private String jenisPerusahaan;

	@SerializedName("email")
	private String email;

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

	public void setStatusPerusahaan(String statusPerusahaan){
		this.statusPerusahaan = statusPerusahaan;
	}

	public String getStatusPerusahaan(){
		return statusPerusahaan;
	}

	public void setNoSiup(Object noSiup){
		this.noSiup = noSiup;
	}

	public Object getNoSiup(){
		return noSiup;
	}

	public void setNamaPerusahaan(String namaPerusahaan){
		this.namaPerusahaan = namaPerusahaan;
	}

	public String getNamaPerusahaan(){
		return namaPerusahaan;
	}

	public void setLatAlamat(Object latAlamat){
		this.latAlamat = latAlamat;
	}

	public Object getLatAlamat(){
		return latAlamat;
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

	public void setCreateDate(Object createDate){
		this.createDate = createDate;
	}

	public Object getCreateDate(){
		return createDate;
	}

	public void setJenisPerusahaan(String jenisPerusahaan){
		this.jenisPerusahaan = jenisPerusahaan;
	}

	public String getJenisPerusahaan(){
		return jenisPerusahaan;
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
			"M_Company_Item{" +
			"alamat_perusahaan = '" + alamatPerusahaan + '\'' + 
			",mobile_tlp = '" + mobileTlp + '\'' + 
			",status_perusahaan = '" + statusPerusahaan + '\'' + 
			",no_siup = '" + noSiup + '\'' + 
			",nama_perusahaan = '" + namaPerusahaan + '\'' + 
			",lat_alamat = '" + latAlamat + '\'' + 
			",nomor_company = '" + nomorCompany + '\'' + 
			",lot_alamt = '" + lotAlamt + '\'' + 
			",logo = '" + logo + '\'' + 
			",office_tlp = '" + officeTlp + '\'' + 
			",no_npwp = '" + noNpwp + '\'' + 
			",create_date = '" + createDate + '\'' + 
			",jenis_perusahaan = '" + jenisPerusahaan + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}