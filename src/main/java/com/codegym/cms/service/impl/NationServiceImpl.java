package com.codegym.cms.service.impl;

import com.codegym.cms.model.Nation;
import com.codegym.cms.repository.NationRepository;
import com.codegym.cms.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;

public class NationServiceImpl implements NationService {
    @Autowired
    private NationRepository nationRepository;
    @Override
    public Iterable<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public Nation findById(Long id) {
        return nationRepository.findOne(id);
    }

    @Override
    public void save(Nation nation) {
        nationRepository.save(nation);

    }

    @Override
    public void remove(Long id) {
        nationRepository.delete(id);

    }
}
