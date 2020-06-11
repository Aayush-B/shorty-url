package com.shortyurl.shortyurl.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shortyurl.shortyurl.exceptions.UrlNotFoundException;
import com.shortyurl.shortyurl.models.UrlDbDetails;
import com.shortyurl.shortyurl.models.UrlRepository;

@Component
public class UrlDaoService {

	@Autowired
	private UrlRepository urlRepository;

	public Long getNextId() {
		return (Long) (urlRepository.count() + 1);
	}

	public UrlDbDetails insert(UrlDbDetails urlDbDetails) {
		try {
			urlRepository.save(urlDbDetails);
		} catch (Exception e) {
			throw e;
		}

		return urlDbDetails;
	}

	public List<UrlDbDetails> getLastTenUrls() {

		ArrayList<Long> lastTenIds = new ArrayList<Long>();

		for (long currId = urlRepository.count() - 9; currId <= urlRepository.count(); currId++) {
			if (currId >= 0) {
				lastTenIds.add(currId);
			}
		}

		List<UrlDbDetails> lastTenUrls = null;

		try {
			lastTenUrls = (List<UrlDbDetails>) urlRepository.findAllById(lastTenIds);
			Collections.reverse(lastTenUrls);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return lastTenUrls;
		}

	}

	public UrlDbDetails getOriginalUrl(Long id) {
		try {
			return urlRepository.findById(id).get();
		} catch (Exception e) {
			throw new UrlNotFoundException("The entered URL was not found.");
		}
	}
}
