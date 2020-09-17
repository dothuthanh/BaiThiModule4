package com.codegym.cms.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "nations")
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String name;
    @OneToMany(targetEntity = City.class)
    private Set<City> citys;
    public Nation() {

    }
    public Nation(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Set<City> getCitys() {
        return citys;
    }
    public void setCitys(Set<City> citys) {
        this.citys = citys;
    }
}
