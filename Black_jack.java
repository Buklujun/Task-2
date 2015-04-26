public class Black_jack {
	static Mythread player;

	public static void main(String[] args) {
		Set coloda = new Set(13);
		for (int i = 0; i < 13; i++) {
			coloda.add(Integer.toString(i + 2), new F1());

		}
		int i = 0;
		Thread t[] = new Thread[13];
		do {
			for (i = 0; i < 13; i++) {
				player = new Mythread(coloda, i);
				t[i] = new Thread(player);
			}
			for (i = 0; i < 13; i++) {
				if (i == 0)
					t[i].start();
				else
					try {
						t[i - 1].join();
						t[i].start();
					} catch (InterruptedException e) {
						System.out.println("ChildThread прерван");
					}
			}
			try {
				t[i - 1].join();
			} catch (InterruptedException e) {
				System.out.println("Основной поток прерван");
			}

			// System.out.println("Size = " + coloda.size());
		} while (coloda.isEmpty() != true);

	}
}
