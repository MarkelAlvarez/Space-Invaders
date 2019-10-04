package tp.p1.logic;

public class MyStringUtils {

	public static String repetir(String elemento, int longitud) {
		
		int i;
		String resultado = "";

		for (i = 0; i < longitud; i++) {
			
			resultado += elemento;
		}

		return resultado;
	}

	public static String centrar(String texto, int longitud) {

		String out = String.format("%"+ longitud + "s%s%" + longitud + "s", "", texto, "");
		float medio = (out.length()/2);
		float principio = medio - (longitud/2);
		float fin = principio + longitud;

		return out.substring((int)principio, (int)fin);
	} 
}