package com.examen.banquito.mapper;

import com.examen.banquito.dto.TurnoCajaDTO;
import com.examen.banquito.model.TurnosCaja;
import org.springframework.stereotype.Component;

@Component
public class TurnoCajaMapper {

    public TurnoCajaDTO toDTO(TurnosCaja model) {
        if (model == null) return null;
        TurnoCajaDTO dto = new TurnoCajaDTO();
        dto.setCodigoTurno(model.getCodigoTurno());
        dto.setCodigoCaja(model.getCodigoCaja());
        dto.setCodigoCajero(model.getCodigoCajero());
        dto.setInicioTurno(model.getInicioTurno());
        dto.setMontoInicial(model.getMontoInicial());
        dto.setFinTurno(model.getFinTurno());
        dto.setEstado(model.getEstado());
        return dto;
    }

    public TurnosCaja toModel(TurnoCajaDTO dto) {
        if (dto == null) return null;
        TurnosCaja model = new TurnosCaja();
        model.setCodigoTurno(dto.getCodigoTurno());
        model.setCodigoCaja(dto.getCodigoCaja());
        model.setCodigoCajero(dto.getCodigoCajero());
        model.setInicioTurno(dto.getInicioTurno());
        model.setMontoInicial(dto.getMontoInicial());
        model.setFinTurno(dto.getFinTurno());
        model.setEstado(dto.getEstado());
        return model;
    }
}
