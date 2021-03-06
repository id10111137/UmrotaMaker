package com.example.tatangit.umrota_maker.Config.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class M_Promo {

	@SerializedName("code")
	private int code;

	@SerializedName("message")
	private List<M_PromoItem> message;

	@SerializedName("status")
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setMessage(List<M_PromoItem> message){
		this.message = message;
	}

	public List<M_PromoItem> getMessage(){
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
			"M_Promo{" +
			"code = '" + code + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}