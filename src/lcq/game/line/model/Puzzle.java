/**
 * 迷宫以及迷宫生成
 * 
 * @author licunqing
 */

package lcq.game.line.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Puzzle {

	private static int minDim = 3;
	private int dim; // 维度
	private Block[][] blocks; // block集合
	private List<Pair<Integer, Integer>> solution; // 一个解答，目的是用来生成Puzzle

	// 禁止在外部创建一个Puzzle实例
	public Puzzle() {
		this(minDim);
	}

	public Puzzle(int dim) {
		this.dim = dim < minDim ? minDim : dim;
		init();
	}

	public int getDim() {
		return dim;
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

}
