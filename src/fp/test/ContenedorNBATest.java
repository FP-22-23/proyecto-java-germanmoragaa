package fp.test;

import fp.NBAplayer.ContenedorNBA;
import fp.NBAplayer.FactoriaNBA;

public class ContenedorNBATest {
	
	private static ContenedorNBA jugadores = FactoriaNBA.leerJugadores("data/NBA stats 2018-2019.csv");
	
	public static void main(String[] args) {
		

		testExisteJugadorQueGaneMas(jugadores, 1000000);
			
	}
		
	public static void testExisteJugadorQueGaneMas(ContenedorNBA jugadores, Integer n) {
	    try {
	        boolean existeJugador = jugadores.existeJugadorQueGaneMas(n);
	        String msg = String.format("El resultado de existeJugadorQueGaneMas es: %b", existeJugador);
	        System.out.println(msg);
	    } catch (Exception e) {
	        System.err.println("Capturada excepción inesperada: " + e.getMessage());
	    }
	}
		
		
}


