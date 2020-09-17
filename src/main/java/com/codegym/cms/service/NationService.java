package com.codegym.cms.service;

import com.codegym.cms.model.Nation;

public interface NationService {
    Iterable<Nation> findAll();
    Nation findById(Long id);
    void save(Nation nation);
    void remove(Long id);
}
