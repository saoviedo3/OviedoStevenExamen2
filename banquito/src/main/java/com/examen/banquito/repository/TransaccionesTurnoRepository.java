package com.examen.banquito.repository;

import com.examen.banquito.model.TransaccionesTurno;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TransaccionesTurnoRepository extends MongoRepository<TransaccionesTurno, String> {

    List<TransaccionesTurno> findByCodigoTurno(String codigoTurno);

    List<TransaccionesTurno> findByCodigoCajaAndCodigoCajero(String codigoCaja, String codigoCajero);

}