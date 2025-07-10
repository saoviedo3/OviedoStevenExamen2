package com.examen.banquito.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.examen.banquito.enums.TipoTransaccionEnum;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Document(collection = "transacciones_turno")
public class TransaccionesTurno {

    private String codigoCaja;
    private String codigoCajero;
    private String codigoTurno;
    private TipoTransaccionEnum tipoTransaccion; 
    private BigDecimal montoTotal;
    private List<Denominacion> denominaciones; 

    @Getter
    @Setter
    public static class Denominacion {
        private String billete; 
        private Integer cantidadBilletes;
        private BigDecimal monto;
    }
}