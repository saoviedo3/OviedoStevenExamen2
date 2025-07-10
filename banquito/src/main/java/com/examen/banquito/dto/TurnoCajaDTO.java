package com.examen.banquito.dto;

import com.examen.banquito.enums.EstadoTurnoEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "DTO para la gestión de turnos de caja")
public class TurnoCajaDTO {

    @Schema(description = "ID generado automáticamente", accessMode = Schema.AccessMode.READ_ONLY, example = "CAJ01-USU01-20250709")
    private String codigoTurno;

    @Schema(description = "Código de la caja", example = "CAJ01")
    private String codigoCaja;

    @Schema(description = "Código del cajero", example = "USU01")
    private String codigoCajero;

    @Schema(description = "Fecha y hora de inicio del turno", example = "2025-07-09T08:00:00")
    private LocalDateTime inicioTurno;

    @Schema(description = "Monto inicial registrado para el turno", example = "1000.00")
    private BigDecimal montoInicial;

    @Schema(description = "Lista de denominaciones de billetes involucrados en el turno")
    private List<DenominacionDTO> denominaciones;

    @Schema(description = "Fecha y hora de fin del turno", example = "2025-07-09T16:00:00")
    private LocalDateTime finTurno;

    @Schema(description = "Estado del turno", example = "ABIERTO")
    private EstadoTurnoEnum estado;
}