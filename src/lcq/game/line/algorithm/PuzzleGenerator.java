/**
 * 谜题生成器
 */

package lcq.game.line.algorithm;

import java.util.List;

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

		// 返回生成好的puzzle
		return puzzle;
	}

}
