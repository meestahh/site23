package com.example.site23;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private BarbershopService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword){
        List<Barbershop> listBarbershop = service.listAll(keyword);
        model.addAttribute("ListBarbershop", listBarbershop);
        model.addAttribute("keyword", keyword);
        return "index";
    }
    @RequestMapping("/gist")
    public String index(Model model, @Param("keyword") String keyword){
        List<Barbershop> listBarbershop = service.listAll(keyword);
        model.addAttribute("ListBarbershop", listBarbershop);
        model.addAttribute("keyword", keyword);
        return "gist";
    }

    @RequestMapping("/new")
    public String showNewTypeForm(Model model){
        Barbershop type = new Barbershop();
        model.addAttribute("barbershop", type);
        return "new_barbershop";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveType(@ModelAttribute("type") Barbershop type){
        service.save(type);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditTypeForm(@PathVariable(name="id") Long id){
        ModelAndView mav = new ModelAndView("edit_barbershop");
        Barbershop type = service.get(id);
        mav.addObject("Type", type);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteType(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/";
    }


}
