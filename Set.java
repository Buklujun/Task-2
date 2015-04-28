import java.util.Random;

public class Set {

	private String[] mMass; // Cards value
	private int[] mAmount; // Number of each cards in the pack
	private int mOver; // Number of the last not null element
	private int mSize; // Size of pack

	public Set(int val) {

		mMass = new String[val];
		mAmount = new int[val];
		mSize = 0;
		mOver = val;
	}

	/** Add new card in the pack with check option */
	public boolean add(String val, Function f) {
		if (mOver == mSize) {
			int new_mSize = (3 * mSize / 2) + 1;
			String[] remSize = new String[new_mSize];
			for (int i = 0; i < mSize; i++) {
				remSize[i] = mMass[i];

			}
			mOver = new_mSize;
			mMass = remSize;

		}

		int i = 0;
		String k = new String();

		do {

			k = mMass[i];
			i++;

		} while ((f.f(k, val) != true) && (i < mSize + 1));

		if (val != mMass[i - 1]) {

			mMass[mSize] = val;
			mAmount[mSize] = 4;
			mSize = mSize + 1;

			return true;
		} else

			return false;

	}

	public boolean search(String val, Function f) {

		int i = 0;
		String k;
		do {
			k = mMass[i];
			i++;
		} while ((f.f(k, val) != true) && (i < mSize + 1));

		if (f.f(k, val) != true)
			return false;

		else

			return true;
	}

	public boolean remove(String val, Function f) {
		String j;
		int i = 0;
		do {

			j = mMass[i];

			i++;
		}

		while ((f.f(j, val) != true) && (i < mSize + 1));

		if (f.f(j, val) != true)

			return false;

		else {
			i = 0;
			boolean k;

			do {
				k = (f.f(val, mMass[i]));
				i++;
			}

			while ((k == false) & (i - 1 < mSize));
			mAmount[i - 1]--;

			if (mAmount[i - 1] == 0)
				mMass[i - 1] = null;

			return true;

		}
	}

	public int getmSize() {
		return mSize;
	}

	public boolean isEmpty() {
		if (mSize != 0)
			return false;
		else
			return true;

	}

	/**
	 * Remove random card from the pack and if amount of this card turns into 0,
	 * replace this card with the last card which no 0 amount, then turn value
	 * of card which amount is 0 into null
	 */
	public String randRemove() {
		int i, buf2 = 0;
		do {
			i = 0;
			buf2 = mAmount[i];
			i++;
		} while ((buf2 == 0) && (i < mSize));
		if (buf2 == 0) {
			return null;
		} else {

			Random rand = new Random();
			int rn = rand.nextInt(mSize);

			String buf = mMass[rn];
			mAmount[rn]--;
			if (mAmount[rn] == 0) {
				mMass[rn] = mMass[mSize - 1];
				mMass[mSize - 1] = null;
				mAmount[rn] = mAmount[mSize - 1];
				mSize--;
			}
			return buf;

		}
	}

}
