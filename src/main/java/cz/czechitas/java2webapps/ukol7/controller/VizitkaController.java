package cz.czechitas.java2webapps.ukol7.controller;

import cz.czechitas.java2webapps.ukol7.entity.Vizitka;
import cz.czechitas.java2webapps.ukol7.repository.VizitkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;


/**
 * vytvorene fieldy pro typ VizitkyRepository
 * vytvoren konstruktor a jako parametr je repository
 * pridana anotace @Autowired
 */


@Controller
public class VizitkaController {

    private final VizitkaRepository repository;


    @Autowired
    public VizitkaController(VizitkaRepository repository) {
        this.repository = repository;
    }


    //    metoda zajisti, aby se prazdne Stringy prevedly na NULL
    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }


    //    zobrazi seznam vizitek
    @GetMapping("/")
    public Object seznam() {
        Iterable<Vizitka> seznam = repository.findAll();
        return new ModelAndView("seznam")
                .addObject("seznam", seznam);
    }


    //    zobrazi vizitku podle id zadaneho v url
    @GetMapping("/{id:[0-9]+}")
    public Object detail(@PathVariable Integer id) {
        Optional<Vizitka> vizitka = repository.findById(id);
        if (vizitka.isPresent()) {
            return new ModelAndView("vizitka")
                    .addObject("vizitka", vizitka.get());
        }
        return ResponseEntity.notFound().build();
    }


    //    metoda pro pridani nove vizitky
    @GetMapping("/nova")
    public Object nova() {
        return new ModelAndView("formular")
                .addObject("vizitka", new Vizitka());
    }


    @PostMapping("/nova")
    public Object pridat(@ModelAttribute("vizitka") @Valid Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }
        repository.save(vizitka);
        return "redirect:/";
    }


    //    metoda pro smazani vizitky
    @PostMapping(value = "/{id:[0-9]+}")
    public Object smazat(@PathVariable int id) {
        Optional<Vizitka> vizitka = repository.findById(id);
        repository.deleteById(id);
        return "redirect:/";
    }
}
