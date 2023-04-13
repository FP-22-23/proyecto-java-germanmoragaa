package fp.NBAplayer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ContenedorNBA {

private List<BasketballPlayer> jugadores;

	//Crea un objeto de tipo jugadores vacío

	public ContenedorNBA() {
		this.jugadores = new ArrayList<>();
	}
	
	//Stream de jugadores, crea un objeto de tipo jugadores a partir de una colección de jugadores NBA
	
	public ContenedorNBA(Stream<BasketballPlayer> stream) {
		this.jugadores = stream.collect(Collectors.toList());
	}
	
	//Colección de jugadores, crea un objeto de tipo jugadores a partir de una colección de jugadores NBA

	public ContenedorNBA(Collection<BasketballPlayer> jugadores) {
	    this.jugadores = new ArrayList<>(jugadores);
	}
	 
	//Devuelve el número de jugadores
	
	public Integer getNumJugadores() {
		return jugadores.size();
	}
	
	//Añadir un jugador
	
    public void anyadirJugador(BasketballPlayer jugador) {          
    	jugadores.add(jugador);
    }
    
    //Añadir una colección de jugadores 
    
    public void anyadirJugadores(Collection<BasketballPlayer> jugadores) {
        this.jugadores.addAll(jugadores);
    }
    
    //Eliminar un jugador
    
    public void eliminarJugador(BasketballPlayer jugador) {        
        if (!jugadores.contains(jugador)) {
            throw new IllegalArgumentException("El jugador no existe");
        } else {
        	jugadores.remove(jugador);
        }
    }
    
    //Criterio de igualdad
    
	public int hashCode() {
		return Objects.hash(jugadores);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContenedorNBA other = (ContenedorNBA) obj;
		return Objects.equals(jugadores, other.jugadores);
	}

    //Representación como cadena
    
    public String toString() {
		return "ContenedorNBA [jugadores=" + jugadores + "]";
	}

    //1. Existe un jugador que gane mas de n dólares
    
	public Boolean existeJugadorQueGaneMas(Integer n) {
		for (BasketballPlayer jugador : jugadores) {
	        if (jugador.getSalary() > n) {
	            return true;
	        }
	    }
	    return false;
	}
	
	//2. Media de los puntos por partido de todos los jugadores de la NBA 
	
	public double mediaPPP() {
		int totalPuntos = 0;
	    for (BasketballPlayer jugador : jugadores) {
	        totalPuntos += jugador.getPoints();
	    }
	    return (double) totalPuntos / jugadores.size();
	}


	//3. Selección con filtrado para filtrar por salario 

	public List<BasketballPlayer> filtrarPorSalario(Integer minSal) {
	    List<BasketballPlayer> filteredPlayers = new ArrayList<>();

	    for (BasketballPlayer player : jugadores) {
	        if (player.getSalary() >= minSal) {
	            filteredPlayers.add(player);
	        }
	    }

	    return filteredPlayers;
	}
	
	//4. Map que agrupa el nombre de los jugadores con sus salarios
	
	public Map<String, List<Integer>> agruparPorNombre(List<BasketballPlayer> jugadores) {
	    Map<String, List<Integer>> mapa = new HashMap<>();

	    for (BasketballPlayer jugador : jugadores) {
	        String nombre = jugador.getName();
	        Integer salario = jugador.getSalary();
	        if (!mapa.containsKey(nombre)) {
	            mapa.put(nombre, new ArrayList<Integer>());
	        }
	        mapa.get(nombre).add(salario);
	    }

	    return mapa;
	}
	
	//5. Map que agrupa las edades de los jugadores con la suma de PPP de todos los de dicha edad
	
	public Map<Integer, Double> acumularPorPuntos(List<BasketballPlayer> jugadores) {
	    Map<Integer, Double> mapa = new HashMap<>();

	    for (BasketballPlayer jugador : jugadores) {
	        Integer edad = jugador.getAge();
	        Double puntos = jugador.getPoints();
	        if (!mapa.containsKey(edad)) {
	            mapa.put(edad, 0.0);
	        }
	        mapa.put(edad, mapa.get(edad) + puntos);
	    }

	    return mapa;
	}
}

