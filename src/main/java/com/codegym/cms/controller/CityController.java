package com.codegym.cms.controller;

import com.codegym.cms.model.City;
import com.codegym.cms.model.Nation;
import com.codegym.cms.service.CityService;
import com.codegym.cms.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;import java.util.Optional;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private NationService nationService;
    @ModelAttribute("nations")
    public Iterable<Nation> nations() {
        return nationService.findAll();
    }
    @GetMapping("/")
    public ModelAndView listCitys() {
        Iterable<City> city = cityService.findAll();
             ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("citys", city);
        return modelAndView;
    }
    @GetMapping("/create-city")
    public ModelAndView ShowCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }
    @PostMapping("/create-city")
    public ModelAndView saveCity(@ModelAttribute("city") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "New city created successfuly");
        return modelAndView;
    }
    @GetMapping("edit-city/{id}")
    public ModelAndView shoowEditForm(@PathVariable Long id) {
        City city = cityService.findById(id);
        if (city != null) {
            ModelAndView modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("city", city);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
        @PostMapping("/edit-city")
                public ModelAndView updateCiyt(@ModelAttribute("city") City city) {
            cityService.save(city);
            ModelAndView modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("city", city);
            modelAndView.addObject("message", "City update successfully");
            return modelAndView;
        }
        @GetMapping("/delete-city/{id}")
        public ModelAndView showDeletForm(@PathVariable Long id) {
            City city = cityService.findById(id);
            if (city != null) {
                ModelAndView modelAndView = new ModelAndView("/city/delete");
                modelAndView.addObject("city", city);
                return modelAndView;
            } else {
                ModelAndView modelAndView = new ModelAndView("/error.404");
                return modelAndView;
            }
        }
        @PostMapping("/delete-city")
    public String deleteCity(@ModelAttribute("city") City city) {
        cityService.remove(city.getId());
        return "redirect:citys";
    }
    @GetMapping("view-city/{id}")
    public String viewCity(@PathVariable("id") Long id, Model model){
        model.addAttribute("city",cityService.findById(id));
        return "/city/view";
    }

}
