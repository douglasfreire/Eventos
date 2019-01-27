package com.douglas.eventos.controller;

import com.douglas.eventos.model.Evento;
import com.douglas.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;

    @RequestMapping(value = "/cadastrarEventos", method = RequestMethod.GET)
    public String formulario() {
        return "formEvento";
    }

    @RequestMapping(value = "/cadastrarEventos", method = RequestMethod.POST)
    public String formulario(Evento evento) {

       er.save(evento);

       return "redirect:/cadastrarEventos";
    }

    @RequestMapping("/eventos")
    public ModelAndView listaEventos() {
        ModelAndView mv = new ModelAndView("/index");
        Iterable<Evento> eventos = er.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }
}