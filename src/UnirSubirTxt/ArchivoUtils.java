package UnirSubirTxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUtils {
	
   /**
    * ---------------------------------------------
    * obtenerListadoDeNombresDeArchivosEnUnaCarpeta
    * ---------------------------------------------
    * obtiene la lista de nombres de los archivos que se encuentren en una carpeta
    * @param ruta : indica la ruta de destino del origen
    * @return
    */
	public List<String> obtenerListadoDeNombresDeArchivosEnUnaCarpeta(String ruta){
		List<String> listaNombresArchivos = new ArrayList<String>();
		File archivos = new File(ruta);
		File[] ficheros = archivos.listFiles();
		for (File file : ficheros) {
			listaNombresArchivos.add(file.getPath());
		}
		return listaNombresArchivos;
	}

	/**
	 * -----------------------------------------------------
	 * 				obtenerArchivo
	 * -----------------------------------------------------
	 * Obtener un archivo de una ruta especifica
	 * 
	 * @param ruta : este parametro indica la ruta origén del archivo
	 * @param nombre : este parametro indica el nombre del archivo 
	 * @return : este metodo retorna un archivo para que sea procesado
	 */
	public File obtenerArchivo (String ruta, String nombre) {
		
		File archivo = null;
		try {
	         archivo = new File (ruta+"/"+nombre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return archivo;
	}
	
	/**
	 * --------------------------------------------------------------
	 * 					leerArchivo
	 * --------------------------------------------------------------
	 * Lee un archivo
	 * @param archivo : indica el archivo que se tiene que leer
	 * @return :  este metodo retorna un archivo para que sea procesado
	 * @throws IOException 
	 */
	public String leerArchivo(File archivo) throws IOException {
		 FileReader fr;
		 BufferedReader br;
		 String linea="";
		 String siguientelinea="";
		 try {
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
	         while((siguientelinea=br.readLine())!=null) {
	        	 linea = linea + siguientelinea;
	         }
	         
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return linea;
	}
	
	/**
	 * -----------------------------------------------------------------------------------------
	 * 									crearArchivo
	 * -----------------------------------------------------------------------------------------
	 * Crea un archivo en el cual guarda los datos asignados con un nombre y una ruta de destino
	 * @param datosdearchivo : informacion que va dentro del archivo
	 * @param nombre : este parametro indica el nombre que se le asigna al archivo
	 * @param rutadestino : este parametro indica ruta donde se dejara el archivo
	 * @return
	 */
	
	public boolean crearArchivo(String datosdearchivo, String nombre, String rutadestino) {
		FileWriter file=null;
		PrintWriter pw =null;
		try {
			 file = new FileWriter(rutadestino+"/"+nombre );
			 pw = new PrintWriter(file);
			 pw.println(datosdearchivo);
			 file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ------------------------------------------------
	 * 					crearArchivo
	 * ------------------------------------------------
	 * Crea un archivo en el cual guarda los datos asignados con un nombre y una ruta de destino
	 * @param datosdearchivo : Lista de informacion que va dentro del archivo
	 * @param nombre : este parametro indica el nombre que se le asigna al archivo
	 * @param rutadestino : este parametro indica ruta donde se dejara el archivo
	 * @return
	 */
	
	public boolean crearArchivo(List<String> datosdearchivo, String nombre, File rutadestino) {
		FileWriter file=null;
		PrintWriter pw =null;
		try {
			 file = new FileWriter(rutadestino+"/"+nombre );
			 pw = new PrintWriter(file);
			 for (String string : datosdearchivo) {
				 pw.println(string);
			}
			 file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * ---------------------------------------------------------------------------------
	 * 							obtenerLineasArchivo
	 * ---------------------------------------------------------------------------------
	 * Obtiene las lineas de texto de un archivo plano
	 * @param ruta : Indica la ruta origen del archivo
	 * @param nombre : Indica nombre del archivo
	 * @return
	 * @throws IOException
	 */
	public List<String> obtenerLineasArchivo(String ruta , String nombre) throws IOException{
		List<String>obtenerLineaArchivo = new ArrayList<>();
		File archivo = new File(ruta,nombre);
		FileReader fr;
		 BufferedReader br;
		 String siguientelinea="";
		 if (ruta.equals(nombre)) {
			try {
				fr = new FileReader (archivo);
				br = new BufferedReader(fr);
		        while((siguientelinea=br.readLine())!=null) {
		        	
		        	obtenerLineaArchivo.add(siguientelinea);
		        }
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else {
			try {
				fr = new FileReader (nombre);
				br = new BufferedReader(fr);
				int con=0;
	        
		        while((siguientelinea=br.readLine())!=null) {
		        	con++;
		        	obtenerLineaArchivo.add(siguientelinea);
		        }
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return obtenerLineaArchivo;
	}
	
	
	public List<String> obtenerLineasArchivoA(String ruta , String nombre) throws IOException{
		List<String>obtenerLineaArchivo = new ArrayList<>();
		File archivo = new File(ruta,nombre);
		FileReader fr;
		 BufferedReader br;
		 String siguientelinea="";
		 if (ruta.equals(nombre)) {
			try {
				fr = new FileReader (archivo);
				br = new BufferedReader(fr);
		        while((siguientelinea=br.readLine())!=null) {
		        	
		        	obtenerLineaArchivo.add(siguientelinea);
		        }
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else {
			try {
				fr = new FileReader (nombre);
				br = new BufferedReader(fr);
				int con = 0;
	        
		        while((siguientelinea=br.readLine())!=null) {
		        	con++;
		        	obtenerLineaArchivo.add(siguientelinea+con);
		        }
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return obtenerLineaArchivo;
	}
}
