package com.examen.banquito.model;
import com.examen.banquito.enums.EstadoTurnoEnum;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Document(collection = "turnos_caja")
public class TurnosCaja {

    private String codigoCaja;
    private String codigoCajero;
    private String codigoTurno;
    private LocalDateTime inicioTurno;
    private BigDecimal montoInicial;
    private LocalDateTime finTurno;
    private EstadoTurnoEnum estado;
    private List<Denominacion> denominaciones;

}
