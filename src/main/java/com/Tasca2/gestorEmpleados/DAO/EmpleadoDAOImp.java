package com.Tasca2.gestorEmpleados.DAO;

import com.Tasca2.gestorEmpleados.models.Empleado;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EmpleadoDAOImp implements EmpleadoDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List getEmpleados() {

        String query = "FROM Empleado";
        List<Empleado>resultado= entityManager.createQuery(query).getResultList();

        return resultado;
    }

    @Override
    public List<Empleado> getEmpleadosPorCargo(String cargo) {
        String query = "FROM Empleado where cargo like '%" + cargo + "%'";
        List<Empleado>resultado= entityManager.createQuery(query).getResultList();
        return resultado;
    }


    @Override
    public void eliminar(Long id) {
        Empleado empleado = entityManager.find(Empleado.class, id);
        entityManager.remove(empleado);
    }

    @Override
    public void registrarEmpleado(Empleado empleado) {
        entityManager.merge(empleado);

    }

    @Override
    public void updateEmpleado(Empleado empleado) {
        entityManager.merge(empleado);

    }
}
