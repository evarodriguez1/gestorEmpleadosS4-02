package com.Tasca2.gestorEmpleados.models;

//esta libreria lombok hace que sea mas abreviados lo etters y setters
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "empleados")
public class Empleado {
    @Id
    @Getter@Setter
    @Column (name = "id")
    private Long id;
    @Getter@Setter
    @Column (name = "nombre")
    private String nombre;
    @Getter@Setter
    @Column (name = "apellido")
    private String apellido;
    @Getter@Setter
    @Column (name = "cargo")
    private String cargo;
    @Getter@Setter
    @Column (name = "salario")
    private String salario;

}