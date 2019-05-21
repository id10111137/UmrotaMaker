package com.example.tatangit.umrota_maker.View.Home.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ModelCompanyInfo{

	@SerializedName("code")
	private int code;

	@SerializedName("message")
	private List<MessageItemCompanyInfo> message;

	@SerializedName("status")
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setMessage(List<MessageItemCompanyInfo> message){
		this.message = message;
	}

	public List<MessageItemCompanyInfo> getMessage(){
		return message;
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
			"ModelCompanyInfo{" + 
			"code = '" + code + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}