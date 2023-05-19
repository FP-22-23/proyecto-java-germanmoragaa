package fp.NBAplayer;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
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

    //ENTREGA 2
    
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
		double totalPuntos = 0;
	    for (BasketballPlayer jugador : jugadores) {
	        totalPuntos += jugador.getPoints();
	    }
	    return (totalPuntos / jugadores.size());
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
	
	public Map<String, List<Integer>> agruparPorNombre() {
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
	
	public Map<Integer, Double> acumularPorPuntos() {
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
	
	//ENTREGA 3
	
	//1. Existe un jugador que promedie n puntos o más y tenga una edad mayor o igual a m
	
	public Boolean existeJugadorQuePromedieNPuntosConMEdad(Double n, Integer m) {
	    return jugadores.stream().filter(jugador -> jugador.getAge() <= m).anyMatch(jugador -> jugador.getPoints()>= n); 
	}


	//2. Media de puntos para jugadores en un rango de edad determinada

	public Double mediaPuntosJugadoresEnRangoEdad(Integer edadMin, Integer edadMax) {
		return jugadores.stream().filter(jugador -> jugador.getAge() >= edadMin && jugador.getAge() <= edadMax).mapToDouble(jugador -> jugador.getPoints()).average().orElse(Double.NaN); 
	}

	//3. Selección con filtrado para filtrar por altura
	
	public List<BasketballPlayer> filtrarPorAltura(Integer altura) {
		 return jugadores.stream().filter(jugador -> jugador.getHeight() == altura).toList();
			}

	//4. Un máximo/mínimo con filtrado
	
	public BasketballPlayer jugadorConMasPuntosMayorQueN(Integer n) {
	    return jugadores.stream().filter(jugador -> jugador.getAge() >= n).max(Comparator.comparing(BasketballPlayer::getAssists)).orElse(null);
	}
	
	//5. Una selección, con filtrado y ordenación
	
	public List<BasketballPlayer> filtrarPorAlturaOrdenadoPorSalario(Integer altura) {
	    return jugadores.stream().filter(jugador -> jugador.getHeight() == altura).sorted(Comparator.comparingDouble(BasketballPlayer::getSalary)).toList(); 
	}
	
	//6. Map que agrupa las edades de los jugadores con la suma de APP de todos los de dicha edad (Con streams)
	
	public Map<Integer, Double> acumularPorAsistencias() {
		return jugadores.stream().collect(Collectors.groupingBy(BasketballPlayer::getAge, Collectors.summingDouble(BasketballPlayer::getAssists)));
	}
	
	//7. Función que agrupa los nombres de los jugadores por el rol al que pertenecen
	
	public Map<Rol, List<String>> agruparJugadoresPorRol() {
		return this.jugadores.stream().collect(Collectors.groupingBy(BasketballPlayer::getRol,TreeMap::new,Collectors.mapping(BasketballPlayer::getName, Collectors.toList())));
		}
	
	//8. Método que nos devuelve el nombre del jugador mejor pagado para cada altura
	
	public Map<Integer, String> jugadoresMasPagadosPorAltura() {
	    return jugadores.stream()
	            .collect(Collectors.groupingBy(BasketballPlayer::getHeight,
	                    Collectors.collectingAndThen(
	                            Collectors.maxBy(Comparator.comparing(BasketballPlayer::getSalary)),
	                            player -> player.map(BasketballPlayer::getName).orElse(null)
	                    )
	            ));
	}
	
	//9.  Método que nos agrupa los jugadores por altura, organizados por salario de mayor a menor y con un limite de n jugadores por altura
	
	public SortedMap<Integer, List<String>> agrupaJugadoresPorAlturaEnFuncionDelSalario(Integer n) {
		 return jugadores.stream()
		            .collect(Collectors.groupingBy(BasketballPlayer::getHeight,
		                    Collectors.collectingAndThen(Collectors.toList(),
		                            listaJugadores -> listaJugadores.stream()
		                                    .sorted(Comparator.comparingDouble(BasketballPlayer::getSalary).reversed())
		                                    .limit(n)
		                                    .map(BasketballPlayer::getName)
		                                    .collect(Collectors.toList()))))
		            .entrySet().stream()
		            .sorted(Map.Entry.comparingByKey())
		            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, TreeMap::new));
		}
	
	//10. Metodo que nos devuelve el jugador con mas PPP+APP a partir del maximo de un Map de los jugadores con su producción 
	
	public String jugadorMVP() {
	    Map<String, Double> ratios = jugadoresPorProduccion();
	    return ratios.entrySet().stream()
	            .max(Map.Entry.comparingByValue())
	            .map(Map.Entry::getKey)
	            .orElse(null);
	}

	public Map<String, Double> jugadoresPorProduccion() {
	    return jugadores.stream()
	            .filter(jugador -> jugador.getSalary() > 0)
	            .collect(Collectors.toMap(
	                    BasketballPlayer::getName,
	                    jugador -> (jugador.getPoints() + jugador.getAssists()),
	                    (val1, val2) -> val1,
	                    HashMap::new 
	            ));
	}
}
