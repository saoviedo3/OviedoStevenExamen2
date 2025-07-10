package com.examen.banquito.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Schema(description = "DTO para representar las denominaciones de billetes")
public class DenominacionDTO {

    @Schema(description = "ID se genera auntomaticamente", example = "5fdf9c4b5f5b5f5b5f5b5f5b")
    private String id; 

    @Schema(description = "Denominación del billete", example = "1 dólar")
    private String billete;

    @Schema(description = "Cantidad de billetes de esta denominación", example = "100")
    private Integer cantidadBilletes;

    @Schema(description = "Monto total de esta denominación", example = "100.00")
    private BigDecimal monto;
}