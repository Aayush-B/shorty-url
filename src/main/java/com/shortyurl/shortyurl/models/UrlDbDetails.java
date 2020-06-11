package com.shortyurl.shortyurl.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UrlDbDetails {

	@Id
	private Long id;

	private String userUrl;

	public UrlDbDetails() {
		super();
	}

	public UrlDbDetails(Long id, String userUrl) {
		super();
		this.id = id;
		this.userUrl = userUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserUrl() {
		return userUrl;
	}

	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}

}
