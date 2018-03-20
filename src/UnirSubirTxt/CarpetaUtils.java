package UnirSubirTxt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CarpetaUtils {
	/**---------------------------------------------
	 * obtenerCarpetasRuta
	 * ---------------------------------------------
	 * Obtiene los listados de carpetas
	 * @param ruta : Indica la ruta de destino de origen
	 * @return
	 */
	
	public List<String> obtenerCarpetasRuta(String ruta) {
		List<String> listaNombresArchivos = new ArrayList<String>();
		File archivos = new File(ruta);
		File[] ficheros = archivos.listFiles();
		for (File file : ficheros) {
			listaNombresArchivos.add(file.getName());
		}
		return listaNombresArchivos;
	}
	
	/**
	 * ----------------------------------------------------
	 * 							crearCarpeta
	 * ----------------------------------------------------
	 * @param ruta : Indica la ruta donde se creara la carpeta
	 * @param nombre : Indica el nombre que tomara la carpeta 
	 * @return
	 */
	
	public File crearCarpeta(String ruta, String nombre) {
		File directorio=new File(ruta+"/"+nombre); 
		directorio.mkdir(); 
		return directorio;
	}
	/**
	 * ----------------------------------------------------
	 * 						existeCarpeta
	 * ----------------------------------------------------
	 * @param ruta :  Indica la ubicacion de la carpeta
	 * @param nombre : Indica el nombre de la carpeta 
	 * @return
	 */
	public boolean existeCarpeta(String ruta, String nombre) {
		List<String> carpetas = new ArrayList<>();
		try {
			carpetas=obtenerCarpetasRuta(ruta);
			for (String listaCarpetas : carpetas) {
				if (listaCarpetas.equalsIgnoreCase(nombre)) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
