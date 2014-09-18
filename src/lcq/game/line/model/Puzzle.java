/**
 * ����
 * 
 */

package lcq.game.line.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Puzzle {

	private static int minDim = 3;
	private int dim; // ά��
	private Block[][] blocks; // block����
	private List<Pair<Integer, Integer>> solution; // һ�����Ŀ������������Puzzle

	public Puzzle(int dim) {
		this.dim = dim < minDim ? minDim : dim;
		init();
	}

	public int getDim() {
		return dim;
	}

	// ��ʼ��blocks[][]
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

}
