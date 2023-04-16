package fp.test;

import java.util.List;
import java.util.Map;

import fp.NBAplayer.BasketballPlayer;
import fp.NBAplayer.ContenedorNBA;
import fp.NBAplayer.FactoriaNBA;

public class ContenedorNBATest {
	
	private static ContenedorNBA jugadores = FactoriaNBA.leerJugadores("data/NBA stats 2018-2019.csv");
	
	public static void main(String[] args) {
		

		testExisteJugadorQueGaneMas(jugadores, 1000000);
		testMediaPPP(jugadores);
		testFiltrarPorSalario(jugadores, 30000000);
		testAgruparPorNombre(jugadores);
		testAcumularPorPuntos(jugadores);
	}
		
	public static void testExisteJugadorQueGaneMas(ContenedorNBA jugadores, Integer n) {
	    try {
	        boolean existeJugadorQueGaneMas = jugadores.existeJugadorQueGaneMas(n);
	        String msg = String.format("El resultado de existeJugadorQueGaneMas es: %b", existeJugadorQueGaneMas);
	        System.out.println(msg);
	    } catch (Exception e) {
	        System.err.println("Capturada excepción inesperada: " + e.getMessage());
	    }
	}
	
	public static void testMediaPPP(ContenedorNBA jugadores) {
	    try {
	        double mediaPPP = jugadores.mediaPPP();
	        String msg = String.format("La media de puntos por partido es: %f", mediaPPP);
	        System.out.println(msg);
	    } catch (Exception e) {
	        System.err.println("Capturada excepción inesperada: " + e.getMessage());
	    }
	}
		
	public static void testFiltrarPorSalario(ContenedorNBA jugadores, Integer minSal) {
	    try {
	    	List<BasketballPlayer> filtrarPorSalario = jugadores.filtrarPorSalario(minSal);
	    	String msg = String.format("Los jugadores que ganan mas de %d son: %s", minSal, filtrarPorSalario);
	        System.out.println(msg);
	    } catch (Exception e) {
	        System.err.println("Capturada excepción inesperada: " + e.getMessage());
	    }
	}
	
	public static void testAgruparPorNombre(ContenedorNBA jugadores) {
	    try {
	        Map<String, List<Integer>> agruparPorNombre = jugadores.agruparPorNombre();
	        String msg = String.format("Asociamos los nombres de los jugadores a sus salarios: %s", agruparPorNombre);
	        System.out.println(msg);
	    } catch (Exception e) {
	        System.err.println("Capturada excepción inesperada: " + e.getMessage());
	    }
	}

	public static void testAcumularPorPuntos(ContenedorNBA jugadores) {
	    try {
	        Map<Integer, Double> acumularPorPuntos = jugadores.acumularPorPuntos();
	        String msg = String.format("Los puntos por partido de cada grupo de edad son: %s", acumularPorPuntos);
	        System.out.println(msg);
	    } catch (Exception e) {
	        System.err.println("Capturada excepción inesperada: " + e.getMessage());
	    }
	}
}


