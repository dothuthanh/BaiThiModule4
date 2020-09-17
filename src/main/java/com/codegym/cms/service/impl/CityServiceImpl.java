package com.codegym.cms.service.impl;

import com.codegym.cms.model.City;
import com.codegym.cms.model.Nation;
import com.codegym.cms.repository.CityRepository;
import com.codegym.cms.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);

    }

    @Override
    public void remove(Long id) {
        cityRepository.delete(id);

    }

    @Override
    public Iterable<City> findAllByNation(Nation nation) {
        return cityRepository.findAllByNation(nation);
    }
}
