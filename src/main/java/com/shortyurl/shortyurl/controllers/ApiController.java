package com.shortyurl.shortyurl.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shortyurl.shortyurl.models.UrlDetails;

import com.shortyurl.shortyurl.services.UrlService;

@RestController
public class ApiController {

	@Autowired
	private UrlService urlService;

	@PostMapping("/api/compress-url")
	public UrlDetails getShortUrl(@RequestBody Map<String, String> userUrlDetails) {
		String userUrl = userUrlDetails.get("userUrl");
		return new UrlDetails(userUrl, urlService.compressURL(userUrl));
	}

	@GetMapping("/api/decompress-url")
	public UrlDetails getOriginalUrl(@RequestBody Map<String, String> userUrlDetails) {
		String userUrl = userUrlDetails.get("userUrl");
		return new UrlDetails(urlService.getOriginalUrl(userUrl), userUrl);
	}

}
