package com.shortyurl.shortyurl.models;

public class UrlDetails {

	private String originalUrl;
	private String compressedUrl;

	public UrlDetails(String originalUrl, String compressedUrl) {
		super();
		this.originalUrl = originalUrl;
		this.compressedUrl = compressedUrl;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getCompressedUrl() {
		return compressedUrl;
	}

	public void setCompressedUrl(String compressedUrl) {
		this.compressedUrl = compressedUrl;
	}

}
