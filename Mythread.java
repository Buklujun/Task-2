public class Mythread implements Runnable {
	public Set coloda;
	public int numb;

	public Mythread(Set coloda, int player) {
		this.coloda = coloda;
		numb = player;

	}

	public void run() {
		//System.out.println("начался поток № " + numb);
		synchronized (coloda) {
			System.out.println("Игрок № " + numb + " вытянул "
					+ coloda.randRemove());
		}
	}

}
