   
   
function eliminar(codigo) {

	swal({
		  title: "Esta seguro de Eliminar?",
		  text: "Una vez eliminado no se prodra restablecer!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				 url:"/GraficasRiobamba/eliminar/"+codigo,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Poof! Registro eliminado!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/GraficasRiobamba/listar";
		    	}
		    });
		  } 
		});
}


