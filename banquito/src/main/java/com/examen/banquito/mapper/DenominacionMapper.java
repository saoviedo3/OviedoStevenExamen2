package com.examen.banquito.mapper;

import com.examen.banquito.dto.DenominacionDTO;
import com.examen.banquito.model.Denominacion;
import org.springframework.stereotype.Component;

@Component
public class DenominacionMapper {

    public DenominacionDTO toDTO(Denominacion model) {
        if (model == null) return null;
        DenominacionDTO dto = new DenominacionDTO();
        dto.setBillete(model.getBillete());
        dto.setCantidadBilletes(model.getCantidadBilletes());
        dto.setMonto(model.getMonto());
        return dto;
    }

    public Denominacion toModel(DenominacionDTO dto) {
        if (dto == null) return null;
        Denominacion model = new Denominacion();
        model.setBillete(dto.getBillete());
        model.setCantidadBilletes(dto.getCantidadBilletes());
        model.setMonto(dto.getMonto());
        return model;
    }
}