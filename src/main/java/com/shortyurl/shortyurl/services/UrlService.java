package com.shortyurl.shortyurl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shortyurl.shortyurl.models.UrlDbDetails;

@Component
public class UrlService {

	@Autowired
	UrlDaoService urlDaoService;

	private String appendProtocolToUrl(String url) {

		if ((url.startsWith("http://")) || (url.startsWith("https://"))) {
			return url;
		}

		return "http://" + url;
	}

	public String compressURL(String userUrl) {

		String compressedUrl = HashUrlService.encode(urlDaoService.getNextId());
		userUrl=appendProtocolToUrl(userUrl) ;
		urlDaoService.insert(new UrlDbDetails(urlDaoService.getNextId(), userUrl));

		return compressedUrl;
	}

	public String getOriginalUrl(String userUrl) {
		Long urlId = HashUrlService.decode(userUrl);

		return appendProtocolToUrl(urlDaoService.getOriginalUrl(urlId).getUserUrl());
	}

	public List<UrlDbDetails> returnLastTenUrls() {
		return urlDaoService.getLastTenUrls();
	}
}
