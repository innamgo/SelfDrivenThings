package com.selfdriventhings.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("PropertiesConfigUtil")
public class PropertiesConfigUtil {

	@Value("#{configProperties[ASR_SERVER_RADIATION]}")
	private String asrRadiation;
	
	@Value("#{configProperties[ASR_SERVER_JOBSTATUS]}")
	private String asrJobStatus;
	
	@Value("#{configProperties[CARI6M]}")
	private String cari6m;
	
	@Value("#{configProperties[CARI_OUT_FILE]}")
	private String carriout;

	public String getCarriout() {
		return carriout;
	}

	public void setCarriout(String carriout) {
		this.carriout = carriout;
	}

	public String getCari6m() {
		return cari6m;
	}

	public void setCari6m(String cari6m) {
		this.cari6m = cari6m;
	}

	public String getAsrRadiation() {
		return asrRadiation;
	}

	public void setAsrRadiation(String asrRadiation) {
		this.asrRadiation = asrRadiation;
	}

	public String getAsrJobStatus() {
		return asrJobStatus;
	}

	public void setAsrJobStatus(String asrJobStatus) {
		this.asrJobStatus = asrJobStatus;
	}
	

}