// Call the dataTables jQuery plugin
$(document).ready(function() {

   cargarEmpleados(null);
  $('#empleados').DataTable();
});


async function cargarEmpleados(cargo){
var url = 'api/empleados';
if (cargo) {
    url = 'api/empleados/' + cargo;
}
 const request = await fetch(url, {
    method: 'GET',
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
    }
  });
   const empleados = await request.json();


   let listadoHtml = '';
     for (let empleado of empleados){
     let botonEliminar = '<a td:href="#" onclick="eliminarEmpleado('+empleado.id+')" class="btn btn-danger">Delete</a>';
     let botonUpdate = '<a td:href="#" onclick="modificarEmpleado('+empleado.id+')" class="btn btn-primary">Update</a>';


     let empleadoHtml = '<tr><td>'+empleado.nombre+'</td><td>'
                        +empleado.apellido+'</td><td>'+empleado.cargo+
                        '</td><td>'+empleado.salario+'</td><td>'+empleado.id+
                        '</td><td>'+botonUpdate+' '+botonEliminar+'</td></tr>'
       listadoHtml += empleadoHtml;
     }

     if (listadoHtml == '') {
     listadoHtml = '<tr></tr>';
     }

     document.querySelector ('#empleados tbody').outerHTML = listadoHtml;
}
function modificarEmpleado (id){
    location.href = 'registrar.html?id=' + id
}

async function eliminarEmpleado (id){

 if(!confirm('Quiere eliminar este usuario?')){
    return;
 }

 const request = await fetch('api/empleados' + id,{
    method: 'DELETE',
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
    }
  });
  location.reload();
}

async function mostrarEmpleado(id){
    let datos = {};

    datos.id = window.location.toString().split('id=')[1]


    datos.nombre = document.getElementById('txtNombre').value
    datos.apellido = document.getElementById('txtApellido').value
    datos.cargo = document.getElementById('txtCargo').value
    datos.salario = document.getElementById('txtSalario').value



    const request = await fetch('api/empleados', {
        method: 'GET',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
      });
      location.reload();


        // return request o json del empleado
}
