package com.codegym.cms.repository;

import com.codegym.cms.model.Nation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NationRepository extends PagingAndSortingRepository<Nation, Long> {
}
