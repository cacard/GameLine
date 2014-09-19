package cacard.game.line.algorithm;

import java.util.List;

import cacard.game.line.model.Block;
import cacard.game.line.model.Pair;
import cacard.game.line.model.Puzzle;

/**
 * 谜题生成器
 */
public class PuzzleGenerator {

	private LineStrategy lineStrategy;
	private Puzzle puzzle;

	public PuzzleGenerator(LineStrategy lineStrategy, int dim) {
		this.lineStrategy = lineStrategy;
		puzzle = new Puzzle(dim);
	}

	/**
	 * 生成一个最终的puzzle
	 * 
	 * @return
	 */
	public Puzzle generate() {
		// 获取一个line
		List<Pair> line = lineStrategy.generate(puzzle.getDim());

		// 根据line设置puzzle的可触摸块和障碍物块
		Block[][] blocks = puzzle.getBlocks();

		for (int i = 0; i < line.size(); i++) {
			if (i == 0) { // 一次性设置头部
				blocks[line.get(i).getT1()][line.get(i).getT2()].setRole(Block.ROLE_START);
				puzzle.setStart(new Pair(line.get(i).getT1(), line.get(i).getT2()));
			} else {
				blocks[line.get(i).getT1()][line.get(i).getT2()].setRole(Block.ROLE_TOUCHABLE);
			}
		}

		// 设置其余Block为Barrier
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
	 * 使用Test策略生成谜题
	 */
	private static void generatePuzzleUsingTest() {
		PuzzleGenerator gen = new PuzzleGenerator(new LineStrategyTest(), 6);
		Puzzle puzzle = gen.generate();

		PuzzleHelper.printPuzzle(puzzle);
	}

	/**
	 * 测试Random策略
	 */
	private static void generatePuzzleUsingRandom() {
		PuzzleGenerator gen = new PuzzleGenerator(new LineStrategyRandom(), 6);
		Puzzle puzzle = gen.generate();

		PuzzleHelper.printPuzzle(puzzle);
	}

}
