public class Black_jack {
	static Mythread player;

	public static void main(String[] args) {
		Set coloda = new Set(13);
		for (int i = 0; i < 9; i++) {
			coloda.add(Integer.toString(i + 2), new F1());
		}
		coloda.add("J", new F1());
		coloda.add("Q", new F1());
		coloda.add("K", new F1());
		coloda.add("A", new F1());

		Thread t[] = new Thread[13];
		do {
			for (int numb = 0; numb < 13; numb++) {
				player = new Mythread(coloda, numb);
				t[numb] = new Thread(player);
			}
			int last = 0;
			for (int numb = 0; numb < 13; numb++) {
				if (numb == 0)
					t[numb].start();
				else
					try {
						t[numb - 1].join();
						t[numb].start();
						last = numb;
					} catch (InterruptedException e) {
						System.out.println("ChildThread прерван");
					}
			}
			try {
				t[last].join();
			} catch (InterruptedException e) {
				System.out.println("Основной поток прерван");
			}

			// System.out.println("Size = " + coloda.getSize());
		} while (coloda.isEmpty() != true);
	}
}
