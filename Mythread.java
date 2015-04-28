public class MyThread implements Runnable {
	private Set mColoda; // Useful pack of cards
	private int mNumb; // Number of player

	public MyThread(Set coloda, int numb) {
		mColoda = coloda;// Pack of cards
		mNumb = numb + 1;// Get number of player

	}

	public void run() {
		synchronized (mColoda) {
			System.out.println("Игрок № " + mNumb + " вытянул "
					+ mColoda.randRemove());
		}
	}

}