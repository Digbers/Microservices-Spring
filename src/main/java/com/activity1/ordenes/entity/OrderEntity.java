package com.activity1.ordenes.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ordenes")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60, nullable = false)
    private String description;
    private String status;
    @Column(name = "fecha_emision")
    private Date fechaEmision;
    private String username;
    @Column(name = "usuario_creacion")
    private Long usuarioCreacion;
    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private Timestamp fechaCreacion;
    @Column(name = "usuario_actualizacion")
    private Long usuarioActualizacion;
    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private String fechaActualizacion;

}
