package com.example.tatangit.umrota_maker.View.Home.Model;

import com.google.gson.annotations.SerializedName;

public class MessageItemGalleryCompany {

	@SerializedName("size")
	private String size;

	@SerializedName("date_upload")
	private String dateUpload;

	@SerializedName("nomor_company")
	private String nomorCompany;

	@SerializedName("file_type")
	private String fileType;

	@SerializedName("nomor_company_gallery")
	private String nomorCompanyGallery;

	@SerializedName("url")
	private String url;

	public void setSize(String size){
		this.size = size;
	}

	public String getSize(){
		return size;
	}

	public void setDateUpload(String dateUpload){
		this.dateUpload = dateUpload;
	}

	public String getDateUpload(){
		return dateUpload;
	}

	public void setNomorCompany(String nomorCompany){
		this.nomorCompany = nomorCompany;
	}

	public String getNomorCompany(){
		return nomorCompany;
	}

	public void setFileType(String fileType){
		this.fileType = fileType;
	}

	public String getFileType(){
		return fileType;
	}

	public void setNomorCompanyGallery(String nomorCompanyGallery){
		this.nomorCompanyGallery = nomorCompanyGallery;
	}

	public String getNomorCompanyGallery(){
		return nomorCompanyGallery;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"MessageItemGalleryCompany{" +
			"size = '" + size + '\'' + 
			",date_upload = '" + dateUpload + '\'' + 
			",nomor_company = '" + nomorCompany + '\'' + 
			",file_type = '" + fileType + '\'' + 
			",nomor_company_gallery = '" + nomorCompanyGallery + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}