$(document).ready(function() {
        //on ready

});


async function updateEmpleado(id){

 empleado.setNombre = document.getElementById('txtNombre').value
 empleado.setApellido = document.getElementById('txtApellido').value
 empleado.setCargo = document.getElementById('txtCargo').value
 empleado.setSalario = document.getElementById('txtSalario').value
 }
 const request = await fetch('api/empleados'+ id, {
    method: 'PUT',
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
    },
    body: JSON.stringify(empleado)
  });

}