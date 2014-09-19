package cacard.game.line.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import cacard.game.line.model.Block;
import cacard.game.line.model.Pair;
import cacard.game.line.model.Puzzle;

public class PuzzleHelper {

	/**
	 * line是否解决了puzzle
	 * 
	 * @param puzzle
	 * @param line
	 * @return
	 */
	public static boolean isSolved(final Puzzle puzzle, final List<Pair> line) {
		return isSolved(puzzle.getBlocks(), puzzle.getDim(), line);
	}

	/**
	 * line是否解决了puzzle
	 * 
	 * @param blocks
	 * @param dim
	 * @param line
	 * @return
	 */
	public static boolean isSolved(final Block[][] blocks, final int dim, final List<Pair> line) {
		if (line == null || line.size() == 0) {
			return false;
		}

		// TODO 算法需要优化，本处时间复杂度为O(n^3)
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if (blocks[i][j].isTouchable()) {
					if (containsPair(line, i, j) == false) {
						return false;
					}
				}
			}
		}

		return true;
	}

	/**
	 * 寻找横向、纵向相邻元素
	 * 
	 * @param p
	 * @return
	 */
	public static List<Pair> getNeighbor(Pair p, int dim) {
		if (p == null || dim == 0) {
			return null;
		}
		if (p.getT1() > dim - 1 || p.getT2() > dim - 1) {
			return null;
		}

		List<Pair> list = new ArrayList<Pair>();

		if (p.getT1() + 1 <= dim - 1)
			list.add(new Pair(p.getT1() + 1, p.getT2()));

		if (p.getT2() + 1 <= dim - 1)
			list.add(new Pair(p.getT1(), p.getT2() + 1));

		if (p.getT1() - 1 >= 0)
			list.add(new Pair(p.getT1() - 1, p.getT2()));

		if (p.getT2() - 1 >= 0)
			list.add(new Pair(p.getT1(), p.getT2() - 1));

		return list;
	}

	/**
	 * 随机生成一个Pari作为二维数组的坐标
	 * 
	 * @return
	 */
	public static Pair getRandomPair(int dim) {
		int t1 = new Random(System.nanoTime()).nextInt(dim);
		int t2 = new Random(System.nanoTime()).nextInt(dim);

		return new Pair(t1, t2);
	}

	/**
	 * 判断一个Pair是否在一个Pair列表中
	 * 
	 * @param list
	 * @param p
	 * @return
	 */
	public static boolean containsPair(List<Pair> l, Pair p) {
		if (l == null || l.size() == 0) {
			return false;
		}

		if (p == null) {
			return false;
		}

		for (Pair e : l) {
			if (e.equals(p)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 判断一个Pair是否在一个Pair列表中
	 * 
	 * @param l
	 * @param i
	 * @param j
	 * @return
	 */
	public static boolean containsPair(List<Pair> l, int i, int j) {
		return containsPair(l, new Pair(i, j));
	}

	/**
	 * list1减去list2，通过引用更新list1
	 * 
	 * @param list1
	 * @param list2
	 */
	public static void removeList(List<Pair> list1, List<Pair> list2) {

		if (list1 == null || list1.size() == 0 || list2 == null || list2.size() == 0) {
			return;
		}

		for (int i = 0; i < list2.size(); i++) {
			for (Iterator<Pair> iter = list1.iterator(); iter.hasNext();) {
				if (iter.next().equals(list2.get(i))) {
					iter.remove();
				}
			}
		}
	}

	/**
	 * 打印出Puzzle，供查看测试
	 * 
	 * @param puzzle
	 */
	public static void printPuzzle(Puzzle puzzle) {
		Block[][] blocks = puzzle.getBlocks();
		for (int i = 0; i < puzzle.getDim(); i++) {
			for (int j = 0; j < puzzle.getDim(); j++) {
				if (blocks[i][j].getRole() == Block.ROLE_BARRIER) {
					System.out.print("[B]");
				} else if (blocks[i][j].getRole() == Block.ROLE_START) {
					System.out.print("[S]");
				} else if (blocks[i][j].getRole() == Block.ROLE_TOUCHABLE) {
					System.out.print("[ ]");
				} else if (blocks[i][j].getRole() == Block.ROLE_NULL) {
					System.out.print("[N]");
				}
			}
			System.out.print("\r\n");
		}
	}

	// Test
	public static void main(String[] args) {

	}

	/**
	 * 测试获取临接元素是否正确
	 * 
	 * @param p
	 */
	private static void testGetNeighbor(Puzzle p) {
		System.out.println("[testGetNeighbor]");

		// 测试集
		List<Pair> finding = new ArrayList<Pair>();
		finding.add(new Pair(0, 0));
		finding.add(new Pair(3, 3));
		finding.add(new Pair(2, 2));
		finding.add(new Pair(1, 1));

		for (Pair j : finding) {
			System.out.println("finding[" + j.getT1() + "][" + j.getT2() + "]:");
			List<Pair> finded = PuzzleHelper.getNeighbor(j, p.getDim());
			if (finded == null) {
				System.out.println("no result");
			} else {
				for (Pair i : finded) {
					System.out.println("[" + i.getT1() + "][" + i.getT2() + "]");
				}
			}
		}

	}

	/**
	 * 测试Random是否符合随机
	 * 
	 * @param p
	 */
	private static void testGetRandomPair(Puzzle p) {
		for (int i = 0; i < 10; i++) {
			Pair pair = PuzzleHelper.getRandomPair(p.getDim());
			System.out.println("[" + pair.getT1() + "][" + pair.getT2() + "]");
		}
	}

	private static void test_removeList() {
		List<Pair> list1 = new ArrayList<Pair>();
		list1.add(new Pair(1, 1));
		list1.add(new Pair(1, 2));
		list1.add(new Pair(2, 1));

		List<Pair> list2 = new ArrayList<Pair>();
		list2.add(new Pair(5, 1));
		list2.add(new Pair(1, 2));
		list2.add(new Pair(6, 1));

		removeList(list1, list2);

		for (Pair p : list1) {
			System.out.println(p.toString());
		}
	}

}
