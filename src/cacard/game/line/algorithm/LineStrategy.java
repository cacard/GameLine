package cacard.game.line.algorithm;

import java.util.List;

import cacard.game.line.model.Pair;

/**
 * ����һ��Line���㷨���Խӿ�
 */
public interface LineStrategy {
	List<Pair<Integer, Integer>> generate(int dim);
}
