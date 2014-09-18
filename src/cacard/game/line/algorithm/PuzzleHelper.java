package cacard.game.line.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cacard.game.line.model.Pair;
import cacard.game.line.model.Puzzle;

public class PuzzleHelper {

	/**
	 * Ѱ�Һ�����������Ԫ��
	 * 
	 * @param p
	 * @return
	 */
	public static List<Pair<Integer, Integer>> getNeighbor(Pair<Integer, Integer> p, int dim) {
		if (p == null || dim == 0) {
			return null;
		}
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

	/**
	 * �������һ��Pari��Ϊ��ά���������
	 * 
	 * @return
	 */
	public static Pair<Integer, Integer> getRandomPair(int dim) {
		int t1 = new Random(System.nanoTime()).nextInt(dim);
		int t2 = new Random(System.nanoTime()).nextInt(dim);

		return new Pair<Integer, Integer>(t1, t2);
	}

	/**
	 * �ж�һ��Pair�Ƿ���һ��Pair�б���
	 * 
	 * @param list
	 * @param p
	 * @return
	 */
	public static boolean containsPair(List<Pair<Integer, Integer>> l, Pair<Integer, Integer> p) {
		if (l == null || l.size() == 0) {
			return false;
		}

		if (p == null) {
			return false;
		}

		for (Pair<Integer, Integer> e : l) {
			if (e.equals(p)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * �ж�һ��Pair�Ƿ���һ��Pair�б���
	 * 
	 * @param l
	 * @param i
	 * @param j
	 * @return
	 */
	public static boolean containsPair(List<Pair<Integer, Integer>> l, int i, int j) {
		return containsPair(l, new Pair<Integer, Integer>(i, j));
	}

	// Test
	public static void main(String[] args) {

	}

	/**
	 * ���Ի�ȡ�ٽ�Ԫ���Ƿ���ȷ
	 * 
	 * @param p
	 */
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
			List<Pair<Integer, Integer>> finded = PuzzleHelper.getNeighbor(j, p.getDim());
			if (finded == null) {
				System.out.println("no result");
			} else {
				for (Pair<Integer, Integer> i : finded) {
					System.out.println("[" + i.getT1() + "][" + i.getT2() + "]");
				}
			}
		}

	}

	/**
	 * ����Random�Ƿ�������
	 * 
	 * @param p
	 */
	private static void testGetRandomPair(Puzzle p) {
		for (int i = 0; i < 10; i++) {
			Pair<Integer, Integer> pair = PuzzleHelper.getRandomPair(p.getDim());
			System.out.println("[" + pair.getT1() + "][" + pair.getT2() + "]");
		}
	}

}
