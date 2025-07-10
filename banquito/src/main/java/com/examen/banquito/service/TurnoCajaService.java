package com.examen.banquito.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.banquito.dto.TurnoCajaDTO;
import com.examen.banquito.dto.TransaccionesTurnoDTO;
import com.examen.banquito.enums.EstadoTurnoEnum;
import com.examen.banquito.exception.CreateEntityException;
import com.examen.banquito.exception.ResourceNotFoundException;
import com.examen.banquito.exception.UpdateEntityException;
import com.examen.banquito.mapper.TurnoCajaMapper;
import com.examen.banquito.mapper.TransaccionesTurnoMapper;
import com.examen.banquito.model.TurnosCaja;
import com.examen.banquito.model.TransaccionesTurno;
import com.examen.banquito.repository.TurnosCajaRepository;
import com.examen.banquito.repository.TransaccionesTurnoRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TurnoCajaService {

    private final TurnosCajaRepository turnosCajaRepository;
    private final TurnoCajaMapper turnoCajaMapper;
    private final TransaccionesTurnoRepository transaccionesTurnoRepository;
    private final TransaccionesTurnoMapper transaccionesTurnoMapper;

    public TurnoCajaService(
            TurnosCajaRepository turnosCajaRepository,
            TurnoCajaMapper turnoCajaMapper,
            TransaccionesTurnoRepository transaccionesTurnoRepository,
            TransaccionesTurnoMapper transaccionesTurnoMapper) {
        this.turnosCajaRepository = turnosCajaRepository;
        this.turnoCajaMapper = turnoCajaMapper;
        this.transaccionesTurnoRepository = transaccionesTurnoRepository;
        this.transaccionesTurnoMapper = transaccionesTurnoMapper;
    }

    @Transactional
    public TurnoCajaDTO iniciarTurno(TurnoCajaDTO turnoCajaDTO) {
        try {
            TurnosCaja turnoCaja = turnoCajaMapper.toModel(turnoCajaDTO);
            turnoCaja.setEstado(EstadoTurnoEnum.ABIERTO);
            TurnosCaja turnoCreado = turnosCajaRepository.save(turnoCaja);
            return turnoCajaMapper.toDTO(turnoCreado);
        } catch (Exception e) {
            throw new CreateEntityException("TurnoCaja", "Error al iniciar el turno. Detalle: " + e.getMessage());
        }
    }

    @Transactional
    public TransaccionesTurnoDTO procesarTransaccion(TransaccionesTurnoDTO transaccionesTurnoDTO) {
        try {
            TransaccionesTurno transaccion = transaccionesTurnoMapper.toModel(transaccionesTurnoDTO);
            transaccionesTurnoRepository.save(transaccion);
            return transaccionesTurnoMapper.toDTO(transaccion);
        } catch (Exception e) {
            throw new CreateEntityException("TransaccionesTurno",
                    "Error al procesar la transacción. Detalle: " + e.getMessage());
        }
    }

    @Transactional
    public TurnoCajaDTO cerrarTurno(String codigoTurno, TurnoCajaDTO turnoCajaDTO) {
        try {
            TurnosCaja turnoCaja = turnosCajaRepository.findByCodigoTurno(codigoTurno)
                    .orElseThrow(() -> new ResourceNotFoundException("Turno no encontrado con código=" + codigoTurno));

            List<TransaccionesTurno> transacciones = transaccionesTurnoRepository.findByCodigoTurno(codigoTurno);

            BigDecimal montoTotalTransacciones = transacciones.stream()
                    .map(TransaccionesTurno::getMontoTotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            if (!turnoCaja.getMontoInicial().equals(montoTotalTransacciones)) {
                throw new UpdateEntityException("TurnoCaja",
                        "El monto total de las transacciones no coincide con el monto inicial.");
            }

            turnoCaja.setEstado(EstadoTurnoEnum.CERRADO);
            turnoCaja.setFinTurno(turnoCajaDTO.getFinTurno());

            turnosCajaRepository.save(turnoCaja);

            return turnoCajaMapper.toDTO(turnoCaja);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new UpdateEntityException("TurnoCaja", "Error al cerrar el turno. Detalle: " + e.getMessage());
        }
    }
}
