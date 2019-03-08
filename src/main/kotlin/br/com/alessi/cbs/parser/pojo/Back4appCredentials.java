package br.com.alessi.cbs.parser.pojo;

import com.google.gson.annotations.SerializedName;

public class Back4appCredentials{

	@SerializedName("back4app_app_id")
	private String back4appAppId;

	@SerializedName("back4app_server_url")
	private String back4appServerUrl;

	@SerializedName("back4app_rest_api_key")
	private String back4appRestApiKey;

	@SerializedName("back4app_client_key")
	private String back4appClientKey;

	public void setBack4appAppId(String back4appAppId){
		this.back4appAppId = back4appAppId;
	}

	public String getBack4appAppId(){
		return back4appAppId;
	}

	public void setBack4appServerUrl(String back4appServerUrl){
		this.back4appServerUrl = back4appServerUrl;
	}

	public String getBack4appServerUrl(){
		return back4appServerUrl;
	}

	public void setBack4appRestApiKey(String back4appRestApiKey){
		this.back4appRestApiKey = back4appRestApiKey;
	}

	public String getBack4appRestApiKey(){
		return back4appRestApiKey;
	}

	public void setBack4appClientKey(String back4appClientKey){
		this.back4appClientKey = back4appClientKey;
	}

	public String getBack4appClientKey(){
		return back4appClientKey;
	}

	@Override
 	public String toString(){
		return 
			"Back4appCredentials{" + 
			"back4app_app_id = '" + back4appAppId + '\'' + 
			",back4app_server_url = '" + back4appServerUrl + '\'' + 
			",back4app_rest_api_key = '" + back4appRestApiKey + '\'' + 
			",back4app_client_key = '" + back4appClientKey + '\'' + 
			"}";
		}
}