import java.util.Random;

public class Wald {
	public String[][] wald = new String[25][25];
	public static final Random rand = new Random();

	public static void main(String[] args) throws InterruptedException {

		feldErstellen();

		BaumZuFeuer();
		FeuerZuAsche();
		AscheZuBaum();
		
		printAll();
		while(true) {
			BaumZuFeuer();
			FeuerZuAsche();
			AscheZuBaum();
			
			printAll();
			Thread.sleep(1000);
			for(int i = 0 ;i<100000;i++) {
				System.out.println();
			}

		}

	}
	private static void FeuerZuAsche() {
		for (int x = 0; x < 25; x++) {
			for (int y = 0; y < 25; y++) {
				int zufall = rand.nextInt(100);
				if (wald[x][y].equals("🔥") && zufall < 10) {
					wald[x][y] = "💨";

				}
			}

		}
	}
	private static void AscheZuBaum() {
		for (int x = 0; x < 25; x++) {
			for (int y = 0; y < 25; y++) {
				int zufall = rand.nextInt(100);
				if (wald[x][y].equals("💨") && zufall < 10) {
					wald[x][y] = "🌳";

				}
			}

		}
	}

	private static void BaumZuFeuer() {
		for (int x = 0; x < 25; x++) {
			for (int y = 0; y < 25; y++) {
				int zufall = rand.nextInt(100);
				if (wald[x][y].equals("🌳") && zufall < 10) {
					wald[x][y] = "🔥";

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

	private static void feldErstellen() {

		for (int x = 0; x < 25; x++) {
			for (int y = 0; y < 25; y++) {
				int zufall = rand.nextInt(100);
				if (zufall < 99 - 20) {
					wald[x][y] = "🌳";
				} else {
					wald[x][y] = "💨 ";
				}

			}
		}

	}
}