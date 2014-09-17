/**
 * 二维数组坐标对
 */
package lcq.game.line.model;

public class Pair<T1, T2> {

	private T1 t1;
	private T2 t2;
	private Pair<T1, T2> pre; // 实现链表，可用来表示line
	private Pair<T1, T2> next;

	public Pair(T1 t1, T2 t2) {
		this.setT1(t1);
		this.setT2(t2);
	}

	@Override
	public String toString() {
		return String.valueOf(t1) + "," + String.valueOf(t2);
	}

	/**
	 * 自定义相等语义，即对象相等或者二值分别相等，则相等
	 */
	@Override
	public boolean equals(Object obj) {
		Pair that = (Pair) obj;

		if (this == that) {
			return true;
		}

		if (this.getT1().equals(that.getT1()) && this.getT2().equals(that.getT2())) {
			return true;
		}

		return false;
	}

	public T1 getT1() {
		return t1;
	}

	public void setT1(T1 t1) {
		this.t1 = t1;
	}

	public T2 getT2() {
		return t2;
	}

	public void setT2(T2 t2) {
		this.t2 = t2;
	}

	public Pair<T1, T2> getPre() {
		return pre;
	}

	public void setPre(Pair<T1, T2> pre) {
		this.pre = pre;
	}

	public Pair<T1, T2> getNext() {
		return next;
	}

	public void setNext(Pair<T1, T2> next) {
		this.next = next;
	}

}
