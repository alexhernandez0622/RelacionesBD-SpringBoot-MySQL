package com.example.RestApiRelacionesSpingBootMySQL.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    //se utiliza para establecer una relación de muchos a uno entre dos entidades en una base de datos relacional.
    @ManyToOne
    // se utiliza para especificar la columna de la tabla de la base de datos que se utilizará para almacenar la clave externa (foreign key) que establece la relación entre las dos entidades.
    @JoinColumn(name = "usuario_id")
    //@JsonIgnore // Evita la serialización del usuario para evitar ciclos infinitos
    private Usuario usuario;

}