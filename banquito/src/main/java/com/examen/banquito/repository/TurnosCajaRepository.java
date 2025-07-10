package com.examen.banquito.repository;

import com.examen.banquito.model.TurnosCaja;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface TurnosCajaRepository extends MongoRepository<TurnosCaja, String> {

    Optional<TurnosCaja> findByCodigoTurno(String codigoTurno);

}
