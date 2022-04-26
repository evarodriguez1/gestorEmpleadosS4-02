$(document).ready(function() {
        //on ready

});

function guardarEmpleado() {
    var id = window.location.toString().split('id=')[1];
    if (id) {
    modificarEmpleado();
    } else {
    registrarEmpleado();
    }
}

async function registrarEmpleado(){
 let datos ={};
 datos.nombre = document.getElementById('txtNombre').value
 datos.apellido = document.getElementById('txtApellido').value
 datos.cargo = document.getElementById('txtCargo').value
 datos.salario = document.getElementById('txtSalario').value

 const request = await fetch('api/empleados', {
    method: 'POST',
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  location.reload();
}

async function modificarEmpleado(){
 let datos ={};
 datos.id = window.location.toString().split('id=')[1]

 datos.nombre = document.getElementById('txtNombre').value
 datos.apellido = document.getElementById('txtApellido').value
 datos.cargo = document.getElementById('txtCargo').value
 datos.salario = document.getElementById('txtSalario').value

 const request = await fetch('api/empleados', {
    method: 'PUT',
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  location.reload();
}

