package com.examen.banquito.dto;

import com.examen.banquito.enums.TipoTransaccionEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "DTO para la gestión de transacciones de turno")
public class TransaccionesTurnoDTO {

    @Schema(description = "Código del turno asociado", example = "CAJ01-USU01-20250709")
    private String codigoTurno;

    @NotBlank(message = "El código de la caja es requerido")
    @Schema(description = "Código de la caja", example = "CAJ01")
    private String codigoCaja;

    @NotBlank(message = "El código del cajero es requerido")
    @Schema(description = "Código del cajero", example = "USU01")
    private String codigoCajero;

    @NotNull(message = "El tipo de transacción es requerido")
    @Schema(description = "Tipo de transacción", example = "DEPOSITO")
    private TipoTransaccionEnum tipoTransaccion;

    @NotNull(message = "El monto total es requerido")
    @DecimalMin(value = "0.0", message = "El monto no puede ser negativo")
    @Schema(description = "Monto total de la transacción", example = "500.00")
    private BigDecimal montoTotal;

    @NotNull(message = "Las denominaciones son requeridas")
    @Schema(description = "Lista de denominaciones de billetes involucrados en la transacción")
    private List<DenominacionDTO> denominaciones;

    @Data
    @NoArgsConstructor
    public static class DenominacionDTO {
        @NotBlank(message = "La denominación es requerida")
        @Schema(description = "Denominación del billete", example = "1 dólar")
        private String billete;

        @NotNull(message = "La cantidad de billetes es requerida")
        @Min(value = 1, message = "La cantidad de billetes no puede ser menor a 1")
        @Schema(description = "Cantidad de billetes de esta denominación", example = "100")
        private Integer cantidadBilletes;

        @NotNull(message = "El monto es requerido")
        @DecimalMin(value = "0.0", message = "El monto no puede ser negativo")
        @Schema(description = "Monto total para esta denominación", example = "100.00")
        private BigDecimal monto;
    }
}
