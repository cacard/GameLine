package cacard.game.line.model;

/**
 * ��ά���������
 */
public class Pair {

	private int t1;
	private int t2;
	private Pair pre; // ʵ��������������ʾline
	private Pair next;

	public Pair(int t1, int t2) {
		this.setT1(t1);
		this.setT2(t2);
	}

	@Override
	public String toString() {
		return String.valueOf(t1) + "," + String.valueOf(t2);
	}

	/**
	 * �Զ���������壬��������Ȼ��߶�ֵ�ֱ���ȣ������
	 */
	@Override
	public boolean equals(Object obj) {
		Pair that = (Pair) obj;

		if (this == that) {
			return true;
		}

		if (this.getT1() == (that.getT1()) && this.getT2() == (that.getT2())) {
			return true;
		}

		return false;
	}

	public int getT1() {
		return t1;
	}

	public void setT1(int t1) {
		this.t1 = t1;
	}

	public int getT2() {
		return t2;
	}

	public void setT2(int t2) {
		this.t2 = t2;
	}

	public Pair getPre() {
		return pre;
	}

	public void setPre(Pair pre) {
		this.pre = pre;
	}

	public Pair getNext() {
		return next;
	}

	public void setNext(Pair next) {
		this.next = next;
	}

}
