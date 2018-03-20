package UnirSubirTxt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListarClasesMetodosConNumeroLineasCodigo {
	
	public List<RecibirMostrarClasesMetodos> listarClasesMetodos (String ruta, String nombreArchivo) throws IOException{
		int contadorLineas=0;
		List<String> lineasdoArchivos = new ArrayList<>();
		List<RecibirMostrarClasesMetodos> listaMetodos = new ArrayList<RecibirMostrarClasesMetodos>();
		List<RecibirMostrarClasesMetodos> listaClases = new ArrayList<RecibirMostrarClasesMetodos>();
		
		ArchivoUtils archivoUtils = new ArchivoUtils();
		RecibirMostrarClasesMetodos metodo  = new RecibirMostrarClasesMetodos();
		lineasdoArchivos = archivoUtils.obtenerLineasArchivo(ruta,nombreArchivo);
		
		for (String claseLeida : lineasdoArchivos) {
			 if (claseLeida.trim().startsWith("p") && !claseLeida.endsWith(";")) {
				 if (claseLeida.trim().contains("class")) {
					 metodo = new RecibirMostrarClasesMetodos();
					 metodo.setNombreClase(claseLeida);
					 listaClases.add(metodo);
				 }else {
					 metodo = new RecibirMostrarClasesMetodos();
					 metodo.setNombreMetodo(claseLeida);
					 metodo.setLineaInicial((contadorLineas));
				 }
			 }
			 if (claseLeida.trim().startsWith("return")) {
				 metodo.setLineaFinal((contadorLineas));
				 listaMetodos.add(metodo);
			 }
			 contadorLineas++;
		 }
		 for (RecibirMostrarClasesMetodos clase : listaClases) {
			 System.out.println("Nombre de Clase : "+clase.getNombreClase());
			 System.out.println("Numero de Clase : "+listaClases.size());
		 }
		     
		 for (RecibirMostrarClasesMetodos metodos : listaMetodos) {
			System.out.println("----------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Nombre del metodo : "+metodos.getNombreMetodo());
			int sum=(int) (metodos.getLineaFinal()-metodos.getLineaInicial());
			System.out.println("total de lineas de codigo  : "+sum);
		 }
		 System.out.println("Numero de metodos : "+listaMetodos.size());
		 System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
	return listaMetodos;
	}
}
