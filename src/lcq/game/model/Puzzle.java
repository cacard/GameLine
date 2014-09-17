/**
 * 迷宫以及迷宫生成
 * 
 * @author licunqing
 */

package lcq.game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Puzzle {

	private static int minDim = 3;
	private int dim; // 维度
	private Block[][] blocks; // block集合
	private List<Pair<Integer, Integer>> solution; // 一个解答，目的是用来生成Puzzle

	// 禁止在外部创建一个Puzzle实例
	private Puzzle() {
		this(minDim);
	}

	private Puzzle(int dim) {
		this.dim = dim < minDim ? minDim : dim;
		init();
	}

	/**
	 * 寻找横向、纵向相邻元素
	 * 
	 * @param p
	 * @return
	 */
	public List<Pair<Integer, Integer>> getNeighbor(Pair<Integer, Integer> p) {
		// 边界检查
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

	// 初始化blocks[][]
	private void init() {
		blocks = new Block[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				blocks[i][j] = new Block();
			}
		}
	}

	/**
	 * 随机生成一对数组的索引
	 * 
	 * @return
	 */
	private Pair<Integer, Integer> getRandomPair() {
		int t1 = new Random(System.nanoTime()).nextInt(dim);
		int t2 = new Random(System.nanoTime()).nextInt(dim);

		return new Pair<Integer, Integer>(t1, t2);
	}

	/**
	 * 生成一个Puzzle
	 * 
	 * @param dim
	 * @return
	 */
	public static Puzzle generate(int dim) {
		Puzzle p = new Puzzle(dim);

		// 随机指定一个起点

		// 生成一条线

		// 添加障碍物

		return p;
	}

	// test
	public static void main(String[] args) {
		Puzzle p = Puzzle.generate(6);
		testGetRandomPair(p);
	}

	private static void testGetNeighbor(Puzzle p) {
		System.out.println("[testGetNeighbor]");

		// 测试集
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
