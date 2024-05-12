
  
  function llamada(){
		fetch('GestionUsuarios?op=1')
		.then(response => response.json())
		.then(data => pintarTabla(data))	
		
	}
	
	function borrar(id){
		
		if(confirm("Seguro que quieres borrar")){
			fetch('GestionUsuarios?id='+id+'&op=3')
			.then(response => response.json())
			.then(data => pintarTabla(data))
		}else{
			
		}
	}
	
		
	function pintarTabla(datos){
		let html = "<table border='5' >";
		
		for (let i=0;i<datos.length;i++){
			
		
		html +="<tr><td>"+datos[i].id+"</td>";
		html +="<td>"+datos[i].nombre+"</td>";
		html +="<td>"+datos[i].apellidos+"</td>";
        html +="<td>"+datos[i].telefono+"</td>";	
		html +="<td>"+datos[i].direccion+"</td>";
		html +="<td>"+datos[i].email+"</td>";
		html +="<td><a href = 'Registrarse.html?id="+datos[i].id+"&op=2'>Editar</a></td><td><a href='javascript:borrar("+datos[i].id+")'>Borrar</a></td>";
		html +="</tr>";
		
		}
		html +="</table>";
		
		document.getElementById("listado").innerHTML = html;
 	
	}

		llamada();
	
	
