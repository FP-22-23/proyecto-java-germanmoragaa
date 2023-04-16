package fp.NBAplayer;

import java.io.IOException;



import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class FactoriaNBA {
	
	public static ContenedorNBA leerJugadores(String fichero) {
		ContenedorNBA jugador = null;
	    try {
	    	Stream<BasketballPlayer> st = Files.lines(Paths.get(fichero)).skip(1).map(FactoriaNBA::parsePlayer);
	    	jugador = new ContenedorNBA(st);
	    } catch (IOException e) {
	        System.out.println("Fichero no encontrado: " + fichero);
	        e.printStackTrace();
	    }
	    return jugador;
	}
	
    public static BasketballPlayer parsePlayer(String lineaCSV) {
    	BasketballPlayer res;
    	Checkers.checkNoNull(lineaCSV);
    	String[] campos = lineaCSV.split(",");
    	String name = campos[0].trim();
        int height = Integer.parseInt(campos[1].trim());
        int age = Integer.parseInt(campos[2].trim());
        int salary = 0; 
        if (!campos[3].trim().equals("-")) {
        	salary = Integer.parseInt(campos[3].trim());
        	}
        Double points = Double.parseDouble(campos[4].trim());
        Double assists = Double.parseDouble(campos[5].trim());
        boolean finals = Boolean.parseBoolean(campos[6].trim());
        LocalDate drafted = LocalDate.parse(campos[7].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        //List<String> partidos = Arrays.asList(campos[8].trim().split(","));
        List<String> partidos = parsearLista(campos[8].trim());
        res = new BasketballPlayer(name, height, age, salary, points, assists, finals, drafted, partidos);
        return res;
    }
  
    private static List<String> parsearLista(String partidos) {
		String limpia = partidos.replace("[","").replace("'", "")
				.replaceAll(" ", "");
		String[] trozos = limpia.split(",");
		
		List<String> res = new ArrayList<>();
		for(String trozo: trozos) {
			res.add(trozo);
		}
		return res;
	}
 
}
