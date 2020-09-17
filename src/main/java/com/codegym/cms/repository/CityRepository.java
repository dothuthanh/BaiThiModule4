package com.codegym.cms.repository;

import com.codegym.cms.model.City;
import com.codegym.cms.model.Nation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City , Long> {
    Iterable<City> findAllByNation(Nation nation);
}
