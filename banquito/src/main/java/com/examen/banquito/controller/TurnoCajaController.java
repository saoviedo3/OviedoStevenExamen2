package com.examen.banquito.controller;

import com.examen.banquito.dto.TurnoCajaDTO;
import com.examen.banquito.dto.TransaccionesTurnoDTO;
import com.examen.banquito.service.TurnoCajaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Tag(name = "TurnosCaja", description = "Operaciones relacionadas con la gestión de turnos de caja y transacciones")
@RestController
@RequestMapping("/api/turnos")
public class TurnoCajaController {

    private final TurnoCajaService turnoCajaService;

    public TurnoCajaController(TurnoCajaService turnoCajaService) {
        this.turnoCajaService = turnoCajaService;
    }

    @Operation(summary = "Iniciar un turno", description = "Crea un nuevo turno y lo marca como ABIERTO")
    @PostMapping("/iniciar")
    public ResponseEntity<TurnoCajaDTO> iniciarTurno(@Valid @RequestBody TurnoCajaDTO turnoCajaDTO) {
        return ResponseEntity.ok(turnoCajaService.iniciarTurno(turnoCajaDTO));
    }

    @Operation(summary = "Procesar transacción", description = "Registra una transacción de retiro o depósito")
    @PostMapping("/transacciones")
    public ResponseEntity<TransaccionesTurnoDTO> procesarTransaccion(@Valid @RequestBody TransaccionesTurnoDTO transaccionesTurnoDTO) {
        return ResponseEntity.ok(turnoCajaService.procesarTransaccion(transaccionesTurnoDTO));
    }

    @Operation(summary = "Cerrar turno", description = "Finaliza un turno, verificando las transacciones y el monto final")
    @PutMapping("/cerrar/{codigoTurno}")
    public ResponseEntity<TurnoCajaDTO> cerrarTurno(@PathVariable String codigoTurno, @Valid @RequestBody TurnoCajaDTO turnoCajaDTO) {
        return ResponseEntity.ok(turnoCajaService.cerrarTurno(codigoTurno, turnoCajaDTO));
    }
}
