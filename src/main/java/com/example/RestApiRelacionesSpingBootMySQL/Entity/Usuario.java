package com.example.RestApiRelacionesSpingBootMySQL.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
// Evita la serialización del usuario para evitar ciclos infinitos
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    /*@OneToMany se utiliza para establecer una relación de uno a muchos entre entidades en una base de datos relacional.
    mappedBy = "usuario" especifica el nombre del atributo en la entidad relacionada que mapea esta relación.*/
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    //@JsonIgnore // Evita la serialización de la lista de tareas para evitar ciclos infinitos
    private List<Tarea> tareas;

}