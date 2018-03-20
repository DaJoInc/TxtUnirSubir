package UnirSubirTxt;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaUtils {
	
	/**
	 * -------------------------------------------------------
	 * 			obtenerListadoAspiranteArchivoLibros
	 * -------------------------------------------------------
	 * Obtiene un listado de aspirantes de libros que contenga tres lineas de texto 
	 * @param ruta : obtiene la ubicacion de los archivos
	 * @param nombreUsuario : obtiene usuario que es ingrezado por consola 
	 * @return
	 * @throws IOException
	 */
	
	public List<String> obtenerListadoAspiranteArchivoLibros(String ruta, String nombreUsuario) throws IOException{
		int totalLineasPorArchivo=0;
		List<String> lineasArchivo = new ArrayList<String>();
		List<String> lineasArchivosLibros = new ArrayList<String>();
		List<String> listaArchivos = new ArrayList<String>();
		
		ArchivoUtils archivoUtils = new ArchivoUtils();
		lineasArchivosLibros = archivoUtils.obtenerListadoDeNombresDeArchivosEnUnaCarpeta(ruta);
		
		for (String archivosCandidatos : lineasArchivosLibros) {
			lineasArchivo=archivoUtils.obtenerLineasArchivo(ruta, archivosCandidatos);
			totalLineasPorArchivo = lineasArchivo.size();
			if (totalLineasPorArchivo==3 && lineasArchivo.get(2).equalsIgnoreCase(nombreUsuario)) {
				listaArchivos.add(archivosCandidatos);
			}
		}
	return listaArchivos;
	}
	
	/**
	 * ----------------------------------------------------------------------------
	 * 					obtenerListadoAspirantesArchivoCapitulo
	 * ----------------------------------------------------------------------------
	 * Obtiene un listado de aspirantes de capitulos que contenga tres o mas lineas de texto
	 * @param ruta : Obtiene ubicacion de texstos
	 * @return
	 * @throws IOException
	 */
	
	public List<String> obtenerListadoAspirantesArchivoCapitulo(String ruta) throws IOException{
		int totalLineasPorArchivo=0;
		List<String> lineasArchivoCapitulo = new ArrayList<String>();
		List<String> lineasArchivosCapitulos = new ArrayList<String>();
		List<String> listaArchivosCapitulos = new ArrayList<String>();
		
		ArchivoUtils archivoUtils = new ArchivoUtils();
		lineasArchivosCapitulos = archivoUtils.obtenerListadoDeNombresDeArchivosEnUnaCarpeta(ruta);
		
		for (String archivosCandidatos : lineasArchivosCapitulos) {
			lineasArchivoCapitulo=archivoUtils.obtenerLineasArchivo(ruta, archivosCandidatos);
			totalLineasPorArchivo = lineasArchivoCapitulo.size();
			if (totalLineasPorArchivo>3) {
				listaArchivosCapitulos.add(archivosCandidatos);
			}
		}
	return listaArchivosCapitulos;
	}
	
	/**
	 * ---------------------------------------------------------------------------------
	 * 								crearArchivoIndiceLibro
	 * ---------------------------------------------------------------------------------
	 * Crea una carpeta apartir del nombre de usuario ingresado por consola
	 * Crea un archivo Indice con el nombre del libro si el nombre de usuario ingresado
	 * por consola es igual al nombre de autor del libro y el nombre de autor de los capitulos
	 * @param ruta : Ubicacion de la carpeta donde se encuentar los textos
	 * @param listaArchivosLibros : Obtiene el listado de archivos candidatos de libros 
	 * @param listaArchivosCapitulos : Obtiene el listado de archivos candidatos de capitulos
	 * @return
	 * @throws IOException
	 */
	
	public boolean crearArchivoIndiceLibro(String ruta, List<String> listaArchivosLibros, List<String> listaArchivosCapitulos) throws IOException {
		List<String> listadoArchivoLibro = new ArrayList<>();
		List<String> listadoArchivoCapitulo = new ArrayList<>();
		List<String> lineasArchivosLibro = new ArrayList<>();
		List<String> lineasArchivosCapitulos = new ArrayList<>();
		List<String> indice = new ArrayList<>();
	
		ArchivoUtils archivoUtils = new ArchivoUtils();
		CarpetaUtils carpetaUtils = new CarpetaUtils();
		
		indice.add("Indice");
		listadoArchivoLibro=listaArchivosLibros;
		listadoArchivoCapitulo=listaArchivosCapitulos;
		carpetaUtils.obtenerCarpetasRuta(ruta);
			
		for (String string : listadoArchivoLibro) {
			lineasArchivosLibro=archivoUtils.obtenerLineasArchivo(ruta, string);
			indice.add(lineasArchivosLibro.get(0));
			for (String string2 : listadoArchivoCapitulo) {
				lineasArchivosCapitulos=archivoUtils.obtenerLineasArchivo(ruta, string2);
					if (lineasArchivosLibro.get(1).equalsIgnoreCase(lineasArchivosCapitulos.get(1))) {
						indice.add(lineasArchivosCapitulos.get(0)+" "+string2);
							 for (int contadorLinea=3; contadorLinea < lineasArchivosCapitulos.size(); contadorLinea+=2) {
							 	  indice.add(lineasArchivosCapitulos.get(contadorLinea)+" "+contadorLinea);
							 }
						File nombreCarpeta = carpetaUtils.crearCarpeta(ruta, lineasArchivosLibro.get(2));
						archivoUtils.crearArchivo(indice,lineasArchivosLibro.get(0), nombreCarpeta);
					}
			}
		}
			
			return false;
  }
}


