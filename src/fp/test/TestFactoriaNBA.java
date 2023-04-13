package fp.test;

import fp.NBAplayer.FactoriaNBA;
import fp.NBAplayer.ContenedorNBA;

public class TestFactoriaNBA {

	public static void main(String[] args) {
			testLeerJugadores("data/NBA stats 2018-2019.csv");
		}

		private static void testLeerJugadores(String fichero) {
			System.out.println("\nTestLeerJugadores");
			ContenedorNBA partidas = FactoriaNBA.leerJugadores(fichero); 
			System.out.println("   Partidas: "+ partidas);
	}

}
