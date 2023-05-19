package fp.NBAplayer;

import java.util.Objects;

public record Jugador(String name, Integer height) {

	@Override
	public String toString() {
		return "Jugador [name=" + name + ", height=" + height + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, height);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(name, other.name) && Objects.equals(height, other.height);
	}
	
	

}
