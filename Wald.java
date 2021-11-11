import java.util.Random;

public class Wald {
	public static String[][] wald = new String[25][25];
	public static final Random rand = new Random();
	public static final String[] states = new String[]{"🌳", "💨", "🔥"};

	public static void main(String[] args) throws InterruptedException {

		feldErstellen(true);


		while(true) {
			transformation("🌳", "🔥");
			transformation("🔥","💨");
			transformation("💨", "🌳");
			
			printAll();
			Thread.sleep(1000);
			for(int i = 0 ;i<100000;i++) {
				System.out.println();
			}

		}

	}
	private static void transformation(String initial, String next) {
		for (int x = 0; x < 25; x++) {
			for (int y = 0; y < 25; y++) {
				int zufall = rand.nextInt(100);
				if (wald[x][y].equals(initial) && zufall < 10) {
					wald[x][y] = next;

				}
			}

		}
	}

	private static void printAll() {
		int zähler = 0;
		for (int x = 0; x < 25; x++) {
			for (int y = 0; y < 25; y++) {
				System.out.print(wald[x][y] + "	");
				zähler++;
				if (zähler == 25) {
					System.out.println();
					zähler = 0;
				}
			}
		}

	}

	private static void feldErstellen(boolean random) {

		for (int x = 0; x < 25; x++) {
			for (int y = 0; y < 25; y++) {
				if(random) {
					int zufall = rand.nextInt(2);
					wald[x][y] = states[zufall];
				} else {
					wald[x][y] = states[0]; //baum
				}
			}
		}

	}
}