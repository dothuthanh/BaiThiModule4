package com.codegym.cms.service;

import com.codegym.cms.model.City;
import com.codegym.cms.model.Nation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface CityService {
    Iterable<City> findAll();
    City findById(Long id);
    void save(City city);
    void remove(Long id);
    Iterable<City> findAllByNation(Nation nation);
}
