package com.codegym.cms.model;

import javax.persistence.*;

@Entity
@Table(name = "citys")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameCity;
    private String acreage;
    private String population;
    private String gdp;
    private String description;
    @ManyToOne
    @JoinColumn(name = "nation_id")
    private Nation nation;
    public City(){
    }

    public City(String nameCity, String acreage, String population, String gdp, String description) {
        this.nameCity = nameCity;
        this.acreage = acreage;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }


    @Override
    public String toString() {
        return String.format("City[id=%d, nameCity='%s', acreage='%s', population='%s', gdp='%s', description='%s']", id, nameCity,acreage,population,description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getAcreage() {
        return acreage;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getGdp() {
        return gdp;
    }

    public void setGdp(String gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }
}
