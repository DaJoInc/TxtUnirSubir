package UnirSubirTxt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class UnirSubirTxt {
	public static void main(String[] args) throws IOException {
		
		System.out.println("Ingrese ruta del proyecto");
		Scanner r = new Scanner(System.in);
		String ruta =r.nextLine();
		
		List<String> listadoArchivos = new ArrayList<String>();
		List<String> listaCarpetas = new ArrayList<String>();
		
		CarpetaUtils carpetaUtils = new CarpetaUtils();
		ArchivoUtils archivoUtils = new ArchivoUtils();
		ListarClasesMetodosConNumeroLineasCodigo listarClasesMetodosConNumeroLineasCodigo = new ListarClasesMetodosConNumeroLineasCodigo();
		
		listaCarpetas=carpetaUtils.obtenerCarpetasRuta(ruta+"/"+"src");
		
		
			listadoArchivos = archivoUtils.obtenerListadoDeNombresDeArchivosEnUnDirectorio(ruta);
			for (String archivo : listadoArchivos) {
				System.out.println("****************************************************************************************************************");
				System.out.println("Lista de archivos : "+archivo);
				listarClasesMetodosConNumeroLineasCodigo.listarClasesMetodos(ruta, archivo);
			
		}
	}
}