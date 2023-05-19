package fp.NBAplayer;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class BasketballPlayer implements Comparable <BasketballPlayer> {

	private String name;
    private Integer height;
    private Integer age;
    private Integer salary;
    private Double points;
    private Double assists;
    private Boolean finals;
    private LocalDate drafted;
    private List<String> partidos;
    private Rol rol;
    private Jugador jugadorRecord;

    //Constructor 1
    
	public BasketballPlayer(String name, Integer height, Integer age, Integer salary, Double points, Double assists, Boolean finals, LocalDate drafted, List<String> partidos,
			Jugador jugadorRecord) {
		Checkers.check("La edad no puede ser menor a 18", age > 18);
		//Checkers.check("El salario no puede ser menor al salario mínimo establecido por la NBA", salary == 0 || salary > 100000);
		Checkers.check("La fecha del draft no puede ser anterior al 23 de junio de 2018", drafted.isBefore(LocalDate.of(2018, 6, 23)));
		this.name = name;
        this.height = height;
        this.age = age;
        this.salary = salary;
        this.points = points;
        this.assists = assists;
        this.finals = finals;
        this.drafted = drafted;
        this.partidos = partidos;
        this.jugadorRecord = jugadorRecord;
    }
	
	//Constructor 2
	
	public BasketballPlayer(String name, Integer salary) {
		//Checkers.check("El salario no puede ser menor al salario mínimo establecido por la NBA", salary != 0 || salary > 100000);
        this.name = name;
        this.salary = salary;
        
}
	
	//Getters y setters 
	
    public String getName() {
        return name;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSalary() {
        return salary;
    }

    public Double getPoints() {
        return points;
    }

    public Double getAssists() {
        return assists;
    }

    public Boolean getFinals() {
        return finals;
    }

    public LocalDate getDrafted() {
        return drafted;
        
    }
    
    public List<String> getPartidos() {
        return partidos;
        
    }
    
    public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public void setAssists(Double assists) {
		this.assists = assists;
	}
	
	public Jugador getJugador(Jugador jugadorRecord) {
		return jugadorRecord;
	}
    
    //Propiedad derivada

	public Rol getRol() {
		Double totalPointsAssists = points + assists;
        if (totalPointsAssists < 5) {
            return Rol.BENCHWARMER;
        } else if (totalPointsAssists < 15) {
            return Rol.ROLEPLAYER;
        } else if (totalPointsAssists < 30) {
            return Rol.STARTER;
        } else {
            return Rol.SUPERSTAR;
        }
    }
    
    //Representación como cadena

	public String toString() {
		return "BasketballPlayer [name=" + name + ", height=" + height + ", age=" + age + ", salary=" + salary
				+ ", points=" + points + ", assists=" + assists + ", finals=" + finals + ", drafted=" + drafted
				+ ", partidos=" + partidos + ", rol=" + rol + ", jugadorRecord=" + jugadorRecord + "]";
	}
    
    //Criterio de igualdad
    
    public int hashCode() {
		return Objects.hash(age, height, rol);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasketballPlayer other = (BasketballPlayer) obj;
		return age == other.age && height == other.height && rol == other.rol;
	}
	
	//Orden natural 

	public int compareTo(BasketballPlayer o) {
	    int r = this.getRol().compareTo(o.getRol());
	    if (r == 0) 
	        r = this.getPoints().compareTo(o.getPoints());
	        if (r == 0) 
	        	r = this.getAssists().compareTo(o.getAssists());
	    return r;
	}
    
    
    
    
    
    
}
