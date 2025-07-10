package com.examen.banquito.dto;

import com.examen.banquito.enums.TipoTransaccionEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "DTO para la gestión de transacciones de turno")
public class TransaccionesTurnoDTO {

    @Schema(description = "ID se genera auntomaticamente", example = "5fdf9c4b5f5b5f5b5f5b5f5b")
    private String id; 

    @Schema(description = "Código del turno asociado", example = "CAJ01-USU01-20250709")
    private String codigoTurno;

    @Schema(description = "Código de la caja", example = "CAJ01")
    private String codigoCaja;

    @Schema(description = "Código del cajero", example = "USU01")
    private String codigoCajero;

    @Schema(description = "Tipo de transacción", example = "DEPOSITO")
    private TipoTransaccionEnum tipoTransaccion;

    @Schema(description = "Monto total de la transacción", example = "500.00")
    private BigDecimal montoTotal;

    @Schema(description = "Lista de denominaciones de billetes involucrados en la transacción")
    private List<DenominacionDTO> denominaciones;
}
