/**
 * �㷨���Խӿ�
 */

package lcq.game.line.algorithm;

import java.util.List;

import lcq.game.line.model.Pair;

public interface PuzzleStrategy {
	List<Pair<Integer, Integer>> generate(int dim);
}
