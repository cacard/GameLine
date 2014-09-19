package cacard.game.line.algorithm;

import java.util.List;

import cacard.game.line.model.Block;
import cacard.game.line.model.Pair;
import cacard.game.line.model.Puzzle;

/**
 * ����������
 */
public class PuzzleGenerator {

	private LineStrategy lineStrategy;
	private Puzzle puzzle;

	public PuzzleGenerator(LineStrategy lineStrategy, int dim) {
		this.lineStrategy = lineStrategy;
		puzzle = new Puzzle(dim);
	}

	/**
	 * ����һ�����յ�puzzle
	 * 
	 * @return
	 */
	public Puzzle generate() {
		// ��ȡһ��line
		List<Pair> line = lineStrategy.generate(puzzle.getDim());

		// ����line����puzzle�Ŀɴ�������ϰ����
		Block[][] blocks = puzzle.getBlocks();

		for (int i = 0; i < line.size(); i++) {
			if (i == 0) { // һ��������ͷ��
				blocks[line.get(i).getT1()][line.get(i).getT2()].setRole(Block.ROLE_START);
				puzzle.setStart(new Pair(line.get(i).getT1(), line.get(i).getT2()));
			} else {
				blocks[line.get(i).getT1()][line.get(i).getT2()].setRole(Block.ROLE_TOUCHABLE);
			}
		}

		// ��������BlockΪBarrier
		for (int i = 0; i < puzzle.getDim(); i++) {
			for (int j = 0; j < puzzle.getDim(); j++) {
				if (blocks[i][j].getRole() == Block.ROLE_NULL) {
					blocks[i][j].setRole(Block.ROLE_BARRIER);
				}
			}
		}

		return puzzle;
	}

	// Test
	public static void main(String[] args) {

		generatePuzzleUsingRandom();
	}

	/**
	 * ʹ��Test������������
	 */
	private static void generatePuzzleUsingTest() {
		PuzzleGenerator gen = new PuzzleGenerator(new LineStrategyTest(), 6);
		Puzzle puzzle = gen.generate();

		PuzzleHelper.printPuzzle(puzzle);
	}

	/**
	 * ����Random����
	 */
	private static void generatePuzzleUsingRandom() {
		PuzzleGenerator gen = new PuzzleGenerator(new LineStrategyRandom(), 6);
		Puzzle puzzle = gen.generate();

		PuzzleHelper.printPuzzle(puzzle);
	}

}
