package com.codegym.cms.controller;

import com.codegym.cms.model.Nation;
import com.codegym.cms.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NationController {
    @Autowired
    private NationService nationService;
    @GetMapping("/nations")
    public ModelAndView listNations(){
        Iterable<Nation> nations = nationService.findAll();
        ModelAndView modelAndView = new ModelAndView("/nation/list");
        modelAndView.addObject("nations", nations);
        return modelAndView;
    }

    @GetMapping("/create-nation")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/nation/create");
        modelAndView.addObject("nation", new Nation());
        return modelAndView;
    }

    @PostMapping("/create-nation")
    public ModelAndView saveNation(@ModelAttribute("nation") Nation nation){
        nationService.save(nation);

        ModelAndView modelAndView = new ModelAndView("/nation/create");
        modelAndView.addObject("nation", new Nation());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-nation/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Nation nation = nationService.findById(id);
        if(nation != null) {
            ModelAndView modelAndView = new ModelAndView("/nation/edit");
            modelAndView.addObject("nation", nation);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-nation")
    public ModelAndView updateProvince(@ModelAttribute("nation") Nation nation){
        nationService.save(nation);
        ModelAndView modelAndView = new ModelAndView("/nation/edit");
        modelAndView.addObject("nation", nation);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-nation/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Nation nation = nationService.findById(id);
        if(nation != null) {
            ModelAndView modelAndView = new ModelAndView("/nation/delete");
            modelAndView.addObject("nation", nation);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-nation")
    public String deleteProvince(@ModelAttribute("nation") Nation nation){
        nationService.remove(nation.getId());
        return "redirect:nations";
    }
}
