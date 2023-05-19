package fp.test;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import fp.NBAplayer.BasketballPlayer;
import fp.NBAplayer.ContenedorNBA;
import fp.NBAplayer.FactoriaNBA;
import fp.NBAplayer.Rol;

public class ContenedorNBATest {
	
	private static ContenedorNBA jugadores = FactoriaNBA.leerJugadores("data/NBA stats 2018-2019.csv");
	
	public static void main(String[] args) {
		
		System.out.println("ENTREGA 2");
		System.out.println("\n 1. Test de existeJugadorQueGaneMas");
		testExisteJugadorQueGaneMas(jugadores, 1000000);
		System.out.println("\n 2. Test de mediaPPP");
		testMediaPPP(jugadores);
		System.out.println("\n 3. Test de filtrarPorSalario");
		testFiltrarPorSalario(jugadores, 30000000);
		System.out.println("\n 4. Test de agruparPorNombre");
		testAgruparPorNombre(jugadores);
		System.out.println("\n 5. Test de acumularPorPuntos");
		testAcumularPorPuntos(jugadores);
		System.out.println("\n ENTREGA 3");
		System.out.println("\n 1. Test de existeJugadorQuePromedieNPuntosConMEdad");
		testExisteJugadorQuePromedieNPuntosConMEdad(jugadores, 27.00, 25);
		System.out.println("\n 2. Test de mediaPuntosJugadoresEnRangoEdad");
		testMediaPuntosJugadoresEnRangoEdad(jugadores, 20, 24);
		System.out.println("\n 3. Test de filtrarPorAltura");
		testFiltrarPorAltura(jugadores, 83);
		System.out.println("\n 4. Test de jugadorConMasPuntosMayorQueN");
		testJugadorConMasPuntosMayorQueN(jugadores, 28);
		System.out.println("\n 5. Test de filtrarPorAlturaOrdenadoPorSalario");
		testFiltrarPorAlturaOrdenadoPorSalario(jugadores, 80);
		System.out.println("\n 6. Test de acumularPorAsistencias");
		testAcumularPorAsistencias(jugadores);
		System.out.println("\n 7. Test de agruparJugadoresPorRol");
		testAgruparJugadoresPorRol(jugadores);
		System.out.println("\n 8. Test de jugadoresMasPagadosPorAltura");
		testJugadoresMasPagadosPorAltura(jugadores);
		System.out.println("\n 9. Test de jugadoresPorAlturaEnFuncionDelSalario");
		testAgrupaJugadoresPorAlturaEnFuncionDelSalario(jugadores, 1);
		System.out.println("\n 10. Test de jugadorMVP");
		testJugadorMVP(jugadores);
		
	}
		
	//ENTREGA 2
	public static void testExisteJugadorQueGaneMas(ContenedorNBA jugadores, Integer n) {
	    try {
	        boolean existeJugadorQueGaneMas = jugadores.existeJugadorQueGaneMas(n);
	        String msg = String.format("¿Existe un jugador que gane mas de %d? %b", n, existeJugadorQueGaneMas);
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
	
	//ENTREGA 3
	
	public static void testExisteJugadorQuePromedieNPuntosConMEdad(ContenedorNBA jugadores, Double n, Integer m) {
	    try {
	        Boolean existeJugadorQuePromedieNPuntosConMEdad = jugadores.existeJugadorQuePromedieNPuntosConMEdad(n,m);
	        String msg = String.format("¿Existe un jugador que promedie %f puntos o más y tenga una edad mayor o igual a %d?: %b", n, m, existeJugadorQuePromedieNPuntosConMEdad);
	        System.out.println(msg);
	    } catch (Exception e) {
	        System.err.println("Capturada excepción inesperada: " + e.getMessage());
	    }
	}
	
	public static void testMediaPuntosJugadoresEnRangoEdad(ContenedorNBA jugadores, Integer edadMin, Integer edadMax) {
	    try {
	        Double mediaPuntosJugadoresEnRangoEdad = jugadores.mediaPuntosJugadoresEnRangoEdad(edadMin,edadMax);
	        String msg = String.format("Los puntos por partido de los jugadores de edad %d-%d es: %f", edadMin, edadMax, mediaPuntosJugadoresEnRangoEdad);
	        System.out.println(msg);
	    } catch (Exception e) {
	        System.err.println("Capturada excepción inesperada: " + e.getMessage());
	    }
	}
	
	public static void testFiltrarPorAltura(ContenedorNBA jugadores, Integer altura) {
	    try {
	    	List<BasketballPlayer> filtrarPorAltura = jugadores.filtrarPorAltura(altura);
	    	String msg = String.format("Los jugadores que miden %d son: %s", altura, filtrarPorAltura);
	        System.out.println(msg);
	    } catch (Exception e) {
	        System.err.println("Capturada excepción inesperada: " + e.getMessage());
	    }
	}
	
	public static void testJugadorConMasPuntosMayorQueN(ContenedorNBA jugadores, Integer n) {
	    try {
	    	BasketballPlayer jugadorConMasPuntosMayorQueN = jugadores.jugadorConMasPuntosMayorQueN(n);
	    	String msg = String.format("El jugador con más puntos con una edad superior a %d, es: %s", n, jugadorConMasPuntosMayorQueN);
	        System.out.println(msg);
	    } catch (Exception e) {
	        System.err.println("Capturada excepción inesperada: " + e.getMessage());
	    }
	}
	
	public static void testFiltrarPorAlturaOrdenadoPorSalario(ContenedorNBA jugadores, Integer altura) {
	    try {
	    	List<BasketballPlayer> filtrarPorAlturaOrdenadoPorSalario = jugadores.filtrarPorAlturaOrdenadoPorSalario(altura);
	    	String msg = String.format("Los jugadores que miden %d pulgadas, ordenados por su salario son: %s", altura, filtrarPorAlturaOrdenadoPorSalario);
	        System.out.println(msg);
	    } catch (Exception e) {
	        System.err.println("Capturada excepción inesperada: " + e.getMessage());
	    }
	}
	
	public static void testAcumularPorAsistencias(ContenedorNBA jugadores) {
	    try {
	        Map<Integer, Double> acumularPorAsistencias = jugadores.acumularPorAsistencias();
	        String msg = String.format("El total de asistencias acumuladas por edad son: %s", acumularPorAsistencias.toString());
	        System.out.println(msg);
	    } catch (Exception e) {
	        System.err.println("Capturada excepción inesperada: " + e.getMessage());
	    }
	}
	
	public static void testAgruparJugadoresPorRol(ContenedorNBA jugadores) {
	    try {
	    	Map<Rol, List<String>> agruparJugadoresPorRol = jugadores.agruparJugadoresPorRol();
	        String msg = String.format("Los jugadores agrupados por rol son: %s", agruparJugadoresPorRol);
	        System.out.println(msg);
	    } catch (Exception e) {
	        System.err.println("Capturada excepción inesperada: " + e.getMessage());
	    }
	}
	
	public static void testJugadoresMasPagadosPorAltura(ContenedorNBA jugadores) {
	    try {
	    	Map<Integer, String> jugadoresMasPagadosPorAltura = jugadores.jugadoresMasPagadosPorAltura();
	        String msg = String.format("Los jugadores mas pagados por altura son: %s", jugadoresMasPagadosPorAltura);
	        System.out.println(msg);
	    } catch (Exception e) {
	        System.err.println("Capturada excepción inesperada: " + e.getMessage());
	    }
	}
	
	public static void testAgrupaJugadoresPorAlturaEnFuncionDelSalario(ContenedorNBA jugadores, Integer n) {
	    try {
	    	SortedMap<Integer, List<String>> agrupaJugadoresPorAlturaEnFuncionDelSalario = jugadores.agrupaJugadoresPorAlturaEnFuncionDelSalario(n);
	        String msg = String.format("Los jugadores agrupados por altura, organizados por salario de mayor a menor y con un limite de %d jugadores por altura es: %s", n, agrupaJugadoresPorAlturaEnFuncionDelSalario);
	        System.out.println(msg);
	    } catch (Exception e) {
	        System.err.println("Capturada excepción inesperada: " + e.getMessage());
	    }
	}
	
	public static void testJugadorMVP(ContenedorNBA jugadores) {
	    try {
	    	String jugadorMVP = jugadores.jugadorMVP();
	        String msg = String.format("El jugador con mayor produccion de la temporada es: %s", jugadorMVP);
	        System.out.println(msg);
	    } catch (Exception e) {
	        System.err.println("Capturada excepción inesperada: " + e.getMessage());
	    }
	}
	
}





