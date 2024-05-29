


	function llamada(){
		fetch('GestionCitas?op=1')
		.then(response => response.json())
		.then(data => pintarTabla(data))
		
	}
	function borrar(id){
		
		if(confirm("Seguro que quieres borrar")){
			fetch('GestionCitas?id='+id+'&op=3')
			.then(response => response.json())
			.then(data => pintarTabla(data))
		}else{
			
		}
 	}
 	function pintarTabla(datos){
		 let html = "<table border=1>";
		 	for(let i=0;i<datos.length;i++){
			 
			 html += "<tr><td>"+datos[i].id+"</td>";
			 html +="<td>"+datos[i].nombre+"</td>";
			 html += "<td>"+datos[i].apellidos+"</td>";
			 html += "<td>"+datos[i].fecha+"</td>";
			 html += "<td>"+datos[i].hora+"</td>";
			 html += "<td>"+datos[i].motivo+"</td>";
			html +="<td><a href = 'citas.html?id="+datos[i].id+"&op=2'>Editar</a></td><td><a href='javascript:borrar("+datos[i].id+")'>Borrar</a></td>";
			 html +="</tr>";
		 }
		 
		 html +="</table>";
		 
		 document.getElementById("listado").innerHTML = html;
	 }
 	
	window.onload = function(){
		

		llamada();
	
	}
