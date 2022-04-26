package com.Tasca2.gestorEmpleados.controllers;

import com.Tasca2.gestorEmpleados.DAO.EmpleadoDAO;
import com.Tasca2.gestorEmpleados.models.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "api/empleados{id}", method = RequestMethod.GET)
    public Empleado getEmpleadoById(@PathVariable Long id) {
        return empleadoDAO.getEmpleadosById(id);
    }


    @RequestMapping(value = "api/empleados/{cargo}", method = RequestMethod.GET)
    public List<Empleado> getEmpleadosPorCargo(@PathVariable String cargo) {
        return empleadoDAO.getEmpleadosPorCargo(cargo);
    }

    @RequestMapping(value = "api/empleados", method = RequestMethod.POST)
    public ResponseEntity registrarEmpleado(@RequestBody Empleado empleado) {

        if(empleado != null) {
            empleadoDAO.registrarEmpleado(empleado);
            //para retornar un mensaje para probar
            return (ResponseEntity.status(HttpStatus.CREATED)).
                    body("usuario creado con exito");
        }else {
            return (ResponseEntity.status(HttpStatus.NO_CONTENT)).
                    body("faltan datos");
        }

    }

    @RequestMapping(value = "api/empleados{id}", method = RequestMethod.PUT)
    public void updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        Empleado empledoOld = empleadoDAO.getEmpleadosById(id);

        if(empleado.getNombre() != null){
            empledoOld.setNombre(empleado.getNombre());
        }else if(empleado.getApellido() != null){
            empledoOld.setApellido(empleado.getApellido());
        }else if(empleado.getCargo() != null) {
            empledoOld.setCargo(empleado.getCargo());
        }else if (empleado.getEmail() != null) {
            empledoOld.setEmail(empleado.getEmail());
        }else  if (empleado.getTelefono() != null) {
            empledoOld.setTelefono(empleado.getTelefono());
        }else if (empleado.getSalario() != null) {
            empledoOld.setSalario(empleado.getSalario());
        }
        empleadoDAO.updateEmpleado(empledoOld);

    }

    @RequestMapping(value = "api/empleados{id}", method = RequestMethod.DELETE)
    public void deleteEmpleado(@PathVariable Long id) {
       empleadoDAO.eliminar(id);
    }

}
