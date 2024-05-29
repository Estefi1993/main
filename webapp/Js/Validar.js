

 function llamada(id,op){
		fetch('GestionUsuarios?id='+id+"&op="+op)
		.then(response => response.json())
		.then(data => pintarFormulario(data))	
		
	}
	
	/*Funci�n para otener el valor de un parametro en el GET */
	function getParameterByName(name) {
		
		  name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
		    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
		    results = regex.exec(location.search);
		    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
		
	}

	function validarFormulario(){
			
            let nombre = document.getElementById ('nombre').value;
            let apellidos = document.getElementById ('apellidos').value;
            let telefono = document.getElementById ('telefono').value;
            let direccion = document.getElementById ('direccion').value;
            let email = document.getElementById ('email').value;
          
            
            let ok = true;

            const nombreRegex = /^[a-zA-Z\s]+$/;
			if (!nombreRegex.test(nombre)) {
            	ok = false;
            document.getElementById ('nombre').style.background = "red";
            }

	        const apellidosRegex = /^[a-zA-Z\s]+$/;
			if (!apellidosRegex.test(apellidos)) {
           	 	ok = false;
            document.getElementById ('apellidos').style.background = "red";
            }

            const telefonoRegex = /^\d{9}$/;
			if (!telefonoRegex.test(telefono)) {
           	 	ok = false;            
            document.getElementById ('telefono').style.background = "red";
            }

            const direccionRegex = /^(?=.*[0-9])(?=.*[a-zA-Z])[a-zA-Z0-9\s]+$/;
			if (!direccionRegex.test(direccion)) {
            	ok = false;
            document.getElementById ('direccion').style.background = "red";
            }

            if(email == ""){
           		 ok = false;
            document.getElementById ('email').style.background = "red";
            }
			if (ok==true){
				document.getElementById("altas").submit();
			}
		
      }
      
 
	function pintarFormulario(datos){
		document.getElementById("id").value = datos.id;
		document.getElementById("nombre").value = datos.nombre;
		document.getElementById("apellidos").value = datos.apellidos;
		document.getElementById("telefono").value = datos.telefono;
		document.getElementById("direccion").value = datos.direccion;
		document.getElementById("email").value = datos.email;
		document.getElementById("permiso").value = datos.permiso;
	}
	
	window.onload = function(){
		let id = getParameterByName("id");
		let op = getParameterByName("op");
		llamada(id,op);
	}
	