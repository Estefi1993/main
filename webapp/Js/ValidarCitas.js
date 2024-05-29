

function llamada(id,op){
		fetch('GestionCitas?id='+id+"&op="+op)
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
            let fecha = document.getElementById ('fecha').value;
            let hora = document.getElementById ('hora').value;
            let motivo = document.getElementById ('motivol').value;
          
            
            let ok = true;
            
			if(nombre == ""){
				ok = false;
				document.getElementById('nombre').style.background = "red";
			}
			
			if(apellidos == ""){
				ok = false;
				document.getElementById('apellidos').style.background = "red";
			}
			if(fecha == ""){
				ok = false;
				document.getElementById('fecha').style.background = "red";
			}
			if(hora == ""){
				ok = false;
				document.getElementById('hora').style.background = "red";
			}
			if(motivo == ""){
				ok = false;
				document.getElementById('motivo').style.background = "red";
			}
			
			if(ok == true){
				
				document.getElementById("citas").submit();
				
			}
	

		}
 
	function pintarFormulario(datos){
		document.getElementById("id").value = datos.id;
		document.getElementById("nombre").value = datos.nombre;
		document.getElementById("apellidos").value = datos.apellidos;
		document.getElementById("fecha").value = datos.fecha;
		document.getElementById("hora").value = datos.hora;
		document.getElementById("motivo").value = datos.motivo;
		
	}
	
	window.onload = function(){
		let id = getParameterByName("id");
		let op = getParameterByName("op");
		llamada(id,op);
	}