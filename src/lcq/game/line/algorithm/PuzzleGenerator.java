/**
 * 谜题生成器
 */

package lcq.game.line.algorithm;

import java.util.List;

import lcq.game.line.model.Block;
import lcq.game.line.model.Pair;
import lcq.game.line.model.Puzzle;

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
		List<Pair<Integer, Integer>> line = lineStrategy.generate(puzzle.getDim());

		// 根据line设置puzzle的可触摸块和障碍物块
		Block[][] blocks = puzzle.getBlocks();

		for (int i = 0; i < line.size(); i++) {
			if (i == 0) {
				blocks[line.get(i).getT1()][line.get(i).getT2()].setRole(Block.ROLE_START);
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

		generatePuzzleUsingTest();
	}

	/**
	 * 使用Test策略生成谜题
	 */
	private static void generatePuzzleUsingTest() {
		PuzzleGenerator gen = new PuzzleGenerator(new LineStrategyTest(), 6);
		Puzzle puzzle = gen.generate();

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

}
