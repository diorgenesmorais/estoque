package com.dms.caixa.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("caixa")
public class CaixaApiProperty {

	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
