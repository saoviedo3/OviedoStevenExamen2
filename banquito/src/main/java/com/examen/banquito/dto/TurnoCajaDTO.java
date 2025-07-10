package com.examen.banquito.dto;

import com.examen.banquito.enums.EstadoTurnoEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Schema(description = "DTO para la gestión de turnos de caja")
public class TurnoCajaDTO {

    @Schema(description = "ID generado automáticamente", accessMode = Schema.AccessMode.READ_ONLY, example = "CAJ01-USU01-20250709")
    private String codigoTurno;

    @NotBlank(message = "El código de la caja es requerido")
    @Schema(description = "Código de la caja", example = "CAJ01")
    private String codigoCaja;

    @NotBlank(message = "El código del cajero es requerido")
    @Schema(description = "Código del cajero", example = "USU01")
    private String codigoCajero;

    @NotNull(message = "La fecha de inicio es requerida")
    @Schema(description = "Fecha y hora de inicio del turno", example = "2025-07-09T08:00:00")
    private LocalDateTime inicioTurno;

    @NotNull(message = "El monto inicial es requerido")
    @DecimalMin(value = "0.0", message = "El monto no puede ser negativo")
    @Schema(description = "Monto inicial registrado para el turno", example = "1000.00")
    private BigDecimal montoInicial;

    @Schema(description = "Fecha y hora de fin del turno", example = "2025-07-09T16:00:00")
    private LocalDateTime finTurno;

    @NotNull(message = "El estado es requerido")
    @Schema(description = "Estado del turno", example = "ABIERTO")
    private EstadoTurnoEnum estado;
}