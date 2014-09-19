package cacard.game.line.model;

import java.util.List;


/**
 * 谜题
 * 
 */
public class Puzzle {

	private static int minDim = 3;
	private int dim; // 维度
	private Block[][] blocks; // block集合
	private Pair start;
	private List<Pair> solution; // 一个解答，目的是用来生成Puzzle

	public Puzzle(int dim) {
		this.dim = dim < minDim ? minDim : dim;
		init();
	}

	public int getDim() {
		return dim;
	}

	// 初始化blocks[][]
	private void init() {
		setBlocks(new Block[dim][dim]);
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				getBlocks()[i][j] = new Block();
			}
		}
	}

	public Block[][] getBlocks() {
		return blocks;
	}

	public void setBlocks(Block[][] blocks) {
		this.blocks = blocks;
	}

	public Pair getStart() {
		return start;
	}

	public void setStart(Pair start) {
		this.start = start;
	}

}
