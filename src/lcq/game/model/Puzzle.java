/**
 * �Թ��Լ��Թ�����
 * 
 * @author licunqing
 */

package lcq.game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Puzzle {

	private static int minDim = 3;
	private int dim; // ά��
	private Block[][] blocks; // block����
	private List<Pair<Integer, Integer>> solution; // һ�����Ŀ������������Puzzle

	// ��ֹ���ⲿ����һ��Puzzleʵ��
	private Puzzle() {
		this(minDim);
	}

	private Puzzle(int dim) {
		this.dim = dim < minDim ? minDim : dim;
		init();
	}

	/**
	 * Ѱ�Һ�����������Ԫ��
	 * 
	 * @param p
	 * @return
	 */
	public List<Pair<Integer, Integer>> getNeighbor(Pair<Integer, Integer> p) {
		// �߽���
		if (p.getT1() > dim - 1 || p.getT2() > dim - 1) {
			return null;
		}

		List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();

		if (p.getT1() + 1 <= dim - 1)
			list.add(new Pair<Integer, Integer>(p.getT1() + 1, p.getT2()));

		if (p.getT2() + 1 <= dim - 1)
			list.add(new Pair<Integer, Integer>(p.getT1(), p.getT2() + 1));

		if (p.getT1() - 1 >= 0)
			list.add(new Pair<Integer, Integer>(p.getT1() - 1, p.getT2()));

		if (p.getT2() - 1 >= 0)
			list.add(new Pair<Integer, Integer>(p.getT1(), p.getT2() - 1));

		return list;
	}

	// ��ʼ��blocks[][]
	private void init() {
		blocks = new Block[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				blocks[i][j] = new Block();
			}
		}
	}

	/**
	 * �������һ�����������
	 * 
	 * @return
	 */
	private Pair<Integer, Integer> getRandomPair() {
		int t1 = new Random(System.nanoTime()).nextInt(dim);
		int t2 = new Random(System.nanoTime()).nextInt(dim);

		return new Pair<Integer, Integer>(t1, t2);
	}

	/**
	 * ����һ��Puzzle
	 * 
	 * @param dim
	 * @return
	 */
	public static Puzzle generate(int dim) {
		Puzzle p = new Puzzle(dim);

		// ���ָ��һ�����

		// ����һ����

		// ����ϰ���

		return p;
	}

	// test
	public static void main(String[] args) {
		Puzzle p = Puzzle.generate(6);
		testGetRandomPair(p);
	}

	private static void testGetNeighbor(Puzzle p) {
		System.out.println("[testGetNeighbor]");

		// ���Լ�
		List<Pair<Integer, Integer>> finding = new ArrayList<Pair<Integer, Integer>>();
		finding.add(new Pair<Integer, Integer>(0, 0));
		finding.add(new Pair<Integer, Integer>(3, 3));
		finding.add(new Pair<Integer, Integer>(2, 2));
		finding.add(new Pair<Integer, Integer>(1, 1));

		for (Pair<Integer, Integer> j : finding) {
			System.out.println("finding[" + j.getT1() + "][" + j.getT2() + "]:");
			List<Pair<Integer, Integer>> finded = p.getNeighbor(j);
			if (finded == null) {
				System.out.println("no result");
			} else {
				for (Pair<Integer, Integer> i : finded) {
					System.out.println("[" + i.getT1() + "][" + i.getT2() + "]");
				}
			}
		}

	}

	private static void testGetRandomPair(Puzzle p) {
		for (int i = 0; i < 10; i++) {
			Pair<Integer, Integer> pair = p.getRandomPair();
			System.out.println("[" + pair.getT1() + "][" + pair.getT2() + "]");
		}
	}
}
