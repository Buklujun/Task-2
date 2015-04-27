public class Mythread implements Runnable {
	private Set coloda;
	private int numb;

	public Mythread(Set coloda, int numb) {
		this.coloda = coloda;
		this.numb = numb + 1;

	}

	public void run() {
		// System.out.println("начался поток № " + numb);
		synchronized (coloda) {
			System.out.println("Игрок № " + numb + " вытянул "
					+ coloda.randRemove());
		}
	}

}
