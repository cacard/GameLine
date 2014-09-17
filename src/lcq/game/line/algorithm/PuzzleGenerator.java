/**
 * ����������
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
	 * ����һ�����յ�puzzle
	 * 
	 * @return
	 */
	public Puzzle generate() {
		// ��ȡһ��line
		List<Pair<Integer, Integer>> line = lineStrategy.generate(puzzle.getDim());

		// ����line����puzzle�Ŀɴ�������ϰ����

		// �������ɺõ�puzzle
		return puzzle;
	}

}
