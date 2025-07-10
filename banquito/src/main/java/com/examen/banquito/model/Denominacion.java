package com.examen.banquito.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Document(collection = "denominaciones")
public class Denominacion {

    @Id
    private String id;
    private String billete; 
    private Integer cantidadBilletes;
    private BigDecimal monto; 

}