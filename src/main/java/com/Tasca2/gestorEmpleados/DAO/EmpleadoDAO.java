package com.Tasca2.gestorEmpleados.DAO;

import com.Tasca2.gestorEmpleados.models.Empleado;

import java.util.List;

public interface EmpleadoDAO {

    List<Empleado> getEmpleados();

    List<Empleado> getEmpleadosPorCargo(String cargo);

    void eliminar(Long id);

    void registrarEmpleado(Empleado empleado);

    void updateEmpleado(Empleado empleado);
}
