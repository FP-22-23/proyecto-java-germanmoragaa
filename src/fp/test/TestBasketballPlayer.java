package fp.test;

import java.time.LocalDate;

import java.util.Arrays;

import fp.NBAplayer.BasketballPlayer;
import fp.NBAplayer.Jugador;

public class TestBasketballPlayer {

	public static void main(String[] args) {
		
		BasketballPlayer p1 = new BasketballPlayer("LeBron James", 206, 37, 4925258, 25.5, 7.9, true, LocalDate.of(2003, 6, 26), Arrays.asList("Memphis", "Boston"), new Jugador("LeBron James", 78));
		BasketballPlayer p2 = new BasketballPlayer("LeBron James", 206, 37, 4925258, 25.5, 7.9, true, LocalDate.of(2003, 6, 26), Arrays.asList("Memphis", "Boston"), new Jugador("LeBron James", 78));
		BasketballPlayer p3 = new BasketballPlayer("Stephen Curry", 190, 33, 9925258, 30.1, 6.7, true, LocalDate.of(2009, 6, 25), Arrays.asList("Memphis", "Boston"), new Jugador("Stephen Curry", 78));
		BasketballPlayer p4 = new BasketballPlayer("Ricky Rubio", 192, 32, 1200000, 12.5, 2.1, true, LocalDate.of(2008, 6, 25), Arrays.asList("Memphis", "Boston"), new Jugador("Ricky Rubio", 78));
		BasketballPlayer p5 = new BasketballPlayer("Carmelo Anthony",1234500);

		//Test constructores y representación como cadena
		
		System.out.println(p1);
		System.out.println(p5);
		
		//Test propiedad derivada
		
		System.out.println(p1.getRol());
		System.out.println(p4.getRol());
		
		//Test criterio de igualdad
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		System.out.println(p2.equals(p3));
		
		//Test criterio orden natural
		
		System.out.println(p2.compareTo(p3));
		System.out.println(p2.compareTo(p1));
		System.out.println(p2.compareTo(p4));
		
		//Test restricciones
		try {
		    BasketballPlayer p6 = new BasketballPlayer("Ricky Rubio", 192, 32, 1200000, 12.5, 2.1, true, LocalDate.of(2018, 6, 25), Arrays.asList("Memphis", "Boston"), new Jugador("Ricky Rubio", 78));
		} catch (IllegalArgumentException e) {
		    System.out.println("Excepción capturada: " + e.getMessage());
		}

		try {
		    BasketballPlayer p7 = new BasketballPlayer("Ricky Rubio", 192, 17, 350000, 12.5, 2.1, true, LocalDate.of(2008, 6, 25), Arrays.asList("Memphis", "Boston"), new Jugador("Ricky Rubio", 78));
		} catch (IllegalArgumentException e) {
		    System.out.println("Excepción capturada: " + e.getMessage());
		}
	}

}
