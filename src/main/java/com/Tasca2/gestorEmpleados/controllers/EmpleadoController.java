package com.Tasca2.gestorEmpleados.controllers;

import com.Tasca2.gestorEmpleados.DAO.EmpleadoDAO;
import com.Tasca2.gestorEmpleados.models.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoDAO empleadoDAO;


    @RequestMapping(value = "api/empleados", method = RequestMethod.GET)
    public List<Empleado> getEmpleados() {
        return empleadoDAO.getEmpleados();
    }

    @RequestMapping(value = "api/empleados/{cargo}", method = RequestMethod.GET)
    public List<Empleado> getEmpleadosPorCargo(@PathVariable String cargo) {
        return empleadoDAO.getEmpleadosPorCargo(cargo);
    }

    @RequestMapping(value = "api/empleados", method = RequestMethod.POST)
    public void registrarEmpleado(@RequestBody Empleado empleado) { //convierte el json que recibe en un empleado
        empleadoDAO.registrarEmpleado(empleado);
    }

    @RequestMapping(value = "api/empleados", method = RequestMethod.PUT)
    public void updateEmpleado(@RequestBody Empleado empleado) {
        empleadoDAO.updateEmpleado(empleado);
    }

    @RequestMapping(value = "api/empleados{id}", method = RequestMethod.DELETE)
    public void deleteEmpleado(@PathVariable Long id) {
       empleadoDAO.eliminar(id);
    }

}
