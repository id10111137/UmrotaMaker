package com.example.tatangit.umrota_maker.View.Home.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Model_UmrohByID {

	@SerializedName("code")
	private int code;

	@SerializedName("message")
	private List<Model_UmrohByID_Item> message;

	@SerializedName("status")
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setMessage(List<Model_UmrohByID_Item> message){
		this.message = message;
	}

	public List<Model_UmrohByID_Item> getMessage(){
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
			"Model_UmrohByID{" +
			"code = '" + code + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}