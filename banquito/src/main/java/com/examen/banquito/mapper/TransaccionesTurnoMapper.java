package com.examen.banquito.mapper;

import com.examen.banquito.dto.TransaccionesTurnoDTO;
import com.examen.banquito.model.TransaccionesTurno;
import org.springframework.stereotype.Component;

@Component
public class TransaccionesTurnoMapper {

    public TransaccionesTurnoDTO toDTO(TransaccionesTurno model) {
        if (model == null) return null;
        TransaccionesTurnoDTO dto = new TransaccionesTurnoDTO();
        dto.setCodigoTurno(model.getCodigoTurno());
        dto.setCodigoCaja(model.getCodigoCaja());
        dto.setCodigoCajero(model.getCodigoCajero());
        dto.setTipoTransaccion(model.getTipoTransaccion());
        dto.setMontoTotal(model.getMontoTotal());
        dto.setDenominaciones(model.getDenominaciones());
        return dto;
    }

    public TransaccionesTurno toModel(TransaccionesTurnoDTO dto) {
        if (dto == null) return null;
        TransaccionesTurno model = new TransaccionesTurno();
        model.setCodigoTurno(dto.getCodigoTurno());
        model.setCodigoCaja(dto.getCodigoCaja());
        model.setCodigoCajero(dto.getCodigoCajero());
        model.setTipoTransaccion(dto.getTipoTransaccion());
        model.setMontoTotal(dto.getMontoTotal());
        model.setDenominaciones(dto.getDenominaciones());
        return model;
    }
}
