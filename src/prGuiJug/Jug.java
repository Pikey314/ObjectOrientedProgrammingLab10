package prGuiJug;
/**
 * Class that simulates the use of a jug that contains liquid. The jug can be
 * filled completely or emptied. We can also pour the liquid in a jug to another
 * jug, until the latter one is filled.
 *
 */

public class Jug {
	/**
	 * Amount of liquid contained in the jug (in liters)
	 */
	private int content;

	/**
	 * Jug Capacity (in liters)
	 */
	private final int capacity;

	/**
	 * A new Jug object is created given its capacity
	 * 
	 * @param initialCapacity
	 *            capacity for the new jug
	 */
	public Jug(int initialCapacity) {
		capacity = initialCapacity;
		content = 0;
	}

	/**
	 * Returning the jug capacity
	 * 
	 * @return int with the jug capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Returning the amount of liquid contained in the jug
	 * 
	 * @return int with the amount of liters.
	 */
	public int getContent() {
		return content;
	}

	/**
	 * The jug is completely filled
	 */
	public void fill() {
		content = capacity;
	}

	/**
	 * The jug is emptied
	 */
	public void empty() {
		content = 0;
	}

	/**
	 * Pouring from a jug into another jug. The operation finishes when
	 * the receiver jug is filled or the jug we use to pour from is empty
	 * 
	 * @param j
	 *             the jug from which we pour the liquid.
	 */
	public void pourFrom(Jug j) {
		int minimumQuantity = Math.min(capacity - content, j.getContent());
		content = content + minimumQuantity;
		j.content = j.content - minimumQuantity;
	}

	/**
	 * String representation of a jug (a pair comprising the quantity and the capacity)
	 */
	public String toString() {
		return "(" + content + ", " + capacity + ")";
	}
}
