package com.examen.banquito.model;

import com.examen.banquito.enums.TipoTransaccionEnum;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Document(collection = "transacciones_turno")
public class TransaccionesTurno {

    @Id
    private String id;
    private String codigoCaja;
    private String codigoCajero;
    private String codigoTurno;
    private TipoTransaccionEnum tipoTransaccion;
    private BigDecimal montoTotal;
    private List<Denominacion> denominaciones;
}