package com.douglas.eventos.repository;

import com.douglas.eventos.model.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository <Evento, String> {

}
