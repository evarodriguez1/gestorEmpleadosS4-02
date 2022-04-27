package com.Tasca2.gestorEmpleados.models;

//esta libreria lombok hace que sea mas abreviados getters y setters
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//
@Entity
@Table (name = "empleados")
public class Empleado {
    @Id
    @Getter@Setter
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter@Setter
    @Column (name = "nombre")
    private String nombre;

    @Getter@Setter
    @Column (name = "apellido")
    private String apellido;

    @Getter@Setter
    @Column (name = "telefono")
    private String telefono;

    @Getter@Setter
    @Column (name = "email")
    private String email;

    @Getter@Setter
    @Column (name = "cargo")
    private String cargo;

    @Getter@Setter
    @Column (name = "salario")
    private Double salario;

}