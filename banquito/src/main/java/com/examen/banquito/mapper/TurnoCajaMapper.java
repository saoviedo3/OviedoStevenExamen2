package com.examen.banquito.mapper;

import com.examen.banquito.dto.TurnoCajaDTO;
import com.examen.banquito.model.TurnosCaja;
import com.examen.banquito.dto.DenominacionDTO;
import com.examen.banquito.model.Denominacion;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TurnoCajaMapper {

    private final DenominacionMapper denominacionMapper;

    public TurnoCajaMapper(DenominacionMapper denominacionMapper) {
        this.denominacionMapper = denominacionMapper;
    }

    public TurnoCajaDTO toDTO(TurnosCaja model) {
        if (model == null) return null;
        TurnoCajaDTO dto = new TurnoCajaDTO();
        dto.setCodigoTurno(model.getCodigoTurno());
        dto.setCodigoCaja(model.getCodigoCaja());
        dto.setCodigoCajero(model.getCodigoCajero());
        dto.setInicioTurno(model.getInicioTurno());
        dto.setMontoInicial(model.getMontoInicial());
        dto.setDenominaciones(toDenominacionDTOList(model.getDenominaciones()));
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
        model.setDenominaciones(toDenominacionList(dto.getDenominaciones()));
        model.setFinTurno(dto.getFinTurno());
        model.setEstado(dto.getEstado());
        return model;
    }

    private List<DenominacionDTO> toDenominacionDTOList(List<Denominacion> denominacionList) {
        return denominacionList.stream()
                .map(denominacionMapper::toDTO)
                .collect(Collectors.toList());
    }

    private List<Denominacion> toDenominacionList(List<DenominacionDTO> denominacionDTOList) {
        return denominacionDTOList.stream()
                .map(denominacionMapper::toModel)
                .collect(Collectors.toList());
    }
}
