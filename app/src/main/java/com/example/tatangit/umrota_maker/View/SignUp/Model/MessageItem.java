package com.example.tatangit.umrota_maker.View.SignUp.Model;

import com.google.gson.annotations.SerializedName;

public class MessageItem{

	@SerializedName("nomor_costumer")
	private String nomorCostumer;

	@SerializedName("size")
	private String size;

	@SerializedName("nama_file")
	private String namaFile;

	@SerializedName("nomor_costumer_file")
	private String nomorCostumerFile;

	@SerializedName("url")
	private String url;

	@SerializedName("jenis_file")
	private String jenisFile;

	@SerializedName("create_Date")
	private String createDate;

	public void setNomorCostumer(String nomorCostumer){
		this.nomorCostumer = nomorCostumer;
	}

	public String getNomorCostumer(){
		return nomorCostumer;
	}

	public void setSize(String size){
		this.size = size;
	}

	public String getSize(){
		return size;
	}

	public void setNamaFile(String namaFile){
		this.namaFile = namaFile;
	}

	public String getNamaFile(){
		return namaFile;
	}

	public void setNomorCostumerFile(String nomorCostumerFile){
		this.nomorCostumerFile = nomorCostumerFile;
	}

	public String getNomorCostumerFile(){
		return nomorCostumerFile;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setJenisFile(String jenisFile){
		this.jenisFile = jenisFile;
	}

	public String getJenisFile(){
		return jenisFile;
	}

	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}

	public String getCreateDate(){
		return createDate;
	}

	@Override
 	public String toString(){
		return 
			"MessageItemCompanyInfo{" +
			"nomor_costumer = '" + nomorCostumer + '\'' + 
			",size = '" + size + '\'' + 
			",nama_file = '" + namaFile + '\'' + 
			",nomor_costumer_file = '" + nomorCostumerFile + '\'' + 
			",url = '" + url + '\'' + 
			",jenis_file = '" + jenisFile + '\'' + 
			",create_Date = '" + createDate + '\'' + 
			"}";
		}
}