package kitchen;

import java.util.List;
import java.util.Random;

public enum Chef {

	ANDREJA, PETAR, MARKO, ANA;
	
	private static final List<Chef> VALUES = List.of(values());
	private static final Random RANDOM = new Random();
	
	public static Chef getRandomChef() {
		return VALUES.get(RANDOM.nextInt(VALUES.size()));
	}
}
