package com.Tasca2.gestorEmpleados.DAO;

import com.Tasca2.gestorEmpleados.models.Empleado;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

//Entity mannager esta relacionado con JPA que es para manejar la database relacional y permite acceder y persistir datos entre los objeos de las clases y la base de datos

@Repository // le da la funcionalidad  de poder acceder al repositorio de la bbdd
@Transactional //le da la funcionalidad de armar y ejecutar las consultas de sql a la bbdd
public class EmpleadoDAOImp implements EmpleadoDAO{

    @PersistenceContext //hace que el EntityManager pueda ser usado en cualquier método y automatiza las transacciones.
    private EntityManager entityManager; //se utiliza para crear y eliminar instancias persistentes entidad, para encontrar entidades por su clave primaria, y para consultar sobre las entidades

    @Override
    public List getEmpleados() {

        String query = "FROM Empleado";
        List<Empleado> resultado = entityManager.createQuery(query).getResultList(); //get.ResultList() recibe Entities de la base de datos.

        return resultado;
    }

    @Override
    public Empleado getEmpleadosById(Long id) {

        Empleado resultado = entityManager.find(Empleado.class, id);

        return resultado;
    }

    @Override
    public List<Empleado> getEmpleadosPorCargo(String cargo) {

        String query = "FROM Empleado where cargo like '%" + cargo + "%'";
        List<Empleado> resultado = entityManager.createQuery(query).getResultList();

        return resultado;
    }

    @Override
    public void eliminar(Long id) {

        Empleado empleado = entityManager.find(Empleado.class, id);
        entityManager.remove(empleado);
    }

    @Override
    public void registrarEmpleado(Empleado empleado) {
        //.merge obliga al entity manager a convertir una entidad no gestionada en una gestionada
        entityManager.merge(empleado);
    }

    @Override
    public void updateEmpleado(Empleado empleado) {
        entityManager.merge(empleado);

    }
}
