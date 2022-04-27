package com.Tasca2.gestorEmpleados.DAO;

import com.Tasca2.gestorEmpleados.models.Empleado;

import java.util.List;

//DAO Data Acces Object-> dentro irán las clases que van a hacer la conexion a la base de datos. cada clase será una tabla

public interface EmpleadoDAO {

    List<Empleado> getEmpleados();

    List<Empleado> getEmpleadosPorCargo(String cargo);

    Empleado getEmpleadosById(Long id);

    void eliminar(Long id);

    void registrarEmpleado(Empleado empleado);

    void updateEmpleado(Empleado empleado);
}
