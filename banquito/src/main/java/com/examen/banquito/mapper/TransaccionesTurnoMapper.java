package com.examen.banquito.mapper;

import com.examen.banquito.dto.TransaccionesTurnoDTO;
import com.examen.banquito.model.TransaccionesTurno;
import com.examen.banquito.dto.DenominacionDTO;
import com.examen.banquito.model.Denominacion;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransaccionesTurnoMapper {

    private final DenominacionMapper denominacionMapper;

    public TransaccionesTurnoMapper(DenominacionMapper denominacionMapper) {
        this.denominacionMapper = denominacionMapper;
    }

    public TransaccionesTurnoDTO toDTO(TransaccionesTurno model) {
        if (model == null) return null;
        TransaccionesTurnoDTO dto = new TransaccionesTurnoDTO();
        dto.setCodigoTurno(model.getCodigoTurno());
        dto.setCodigoCaja(model.getCodigoCaja());
        dto.setCodigoCajero(model.getCodigoCajero());
        dto.setTipoTransaccion(model.getTipoTransaccion());
        dto.setMontoTotal(model.getMontoTotal());
        dto.setDenominaciones(toDenominacionDTOList(model.getDenominaciones()));
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
        model.setDenominaciones(toDenominacionList(dto.getDenominaciones()));
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
