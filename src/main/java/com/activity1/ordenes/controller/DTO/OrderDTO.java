package com.activity1.ordenes.controller.DTO;


import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
@Data
@Builder
public class OrderDTO {

    private Long id;

    private String description;
    private String status;

    private Date fechaEmision;
    private String username;

    private Long usuarioCreacion;

    private Timestamp fechaCreacion;
    private Long usuarioActualizacion;

    private String fechaActualizacion;
}
