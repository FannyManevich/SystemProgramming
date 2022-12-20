/* 
 * Fany Manevich 206116725
 * Cindy Zilberman - 316268150
*/
public enum Input {
	O, X, EMPTY;

	public String toString() {
		switch (this) {
		case O:
			return "O";
		case X:
			return "X";
		case EMPTY: 
			return " ";
		default:
			throw new RuntimeException("Invalid value");
		}

	}
}
