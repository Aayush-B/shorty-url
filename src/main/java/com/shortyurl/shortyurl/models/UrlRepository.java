package com.shortyurl.shortyurl.models;

import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<UrlDbDetails, Long> {

}
