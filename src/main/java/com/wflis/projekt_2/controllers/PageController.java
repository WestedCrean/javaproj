package com.wflis.projekt_2.controllers;

import com.wflis.projekt_2.entities.Zadanie;

import com.wflis.projekt_2.repositories.ZadanieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {
    @Autowired
    public ZadanieRepository rep;


    @RequestMapping(method = RequestMethod.GET, value="/")
    @ResponseBody
    public String mainPage() {
        return "Hello Spring Boot from mainPage() method!";
    }

    @RequestMapping(method = RequestMethod.GET, value="/hello")
    @ResponseBody
    public String pageTwo() {
        return "Hello Spring Boot from pageTwo() method!";
    } 

    @RequestMapping(method = RequestMethod.GET, value="/listaZadan")
    @ResponseBody
    public String listaZadan() {
        StringBuilder response = new StringBuilder();
        Zadanie zadanie = new Zadanie();

        // using rep save zadanie to database
        rep.save(zadanie);
        // using rep download all Zadanie from database and append to response
        for (Zadanie zadanie1 : rep.findAll()) {
            response.append(zadanie1.toString()).append("<br>");
        }
        return response.toString();
    }

    @RequestMapping(method = RequestMethod.GET, value="/utworz10Zadan")
    @ResponseBody
    public String utworz10Zadan() {
        StringBuilder response = new StringBuilder();
        // create 10 Zadanie with random values of koszt field
        for (int i = 0; i < 10; i++) {
            Zadanie zadanie = new Zadanie((double) (Math.random() * 1000));
            rep.save(zadanie);
            response.append(zadanie.toString()).append("<br>");
        }
        return response.toString();
    }

    // create DELETE endpoint with id path parameter to delete Zadanie by id
    @RequestMapping(method = RequestMethod.DELETE, value="/usunZadanie/{id}")
    @ResponseBody
    public String usunZadanie(Long id) {
        rep.deleteById(id);
        return "Zadanie o id: " + id + " zostało usunięte";
    }

    // create GET endpoint that uses findByKosztBetween method to find Zadanie by koszt field value
    @RequestMapping(method = RequestMethod.GET, value="/zadaniaWKoszcie/{koszt1}/{koszt2}")
    @ResponseBody
    public String zadaniaWKoszcie(double koszt1, double koszt2) {
        StringBuilder response = new StringBuilder();
        // using rep findByKosztBetween method to find Zadanie by koszt field value
        for (Zadanie zadanie : rep.findByKosztBetween(koszt1, koszt2)) {
            response.append(zadanie.toString()).append("<br>");
        }
        return response.toString();
    }
}
