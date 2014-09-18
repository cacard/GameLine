package cacard.game.line.algorithm;

import java.util.List;

import cacard.game.line.model.Pair;

/**
 * 生成一条Line的算法策略接口
 */
public interface LineStrategy {
	List<Pair<Integer, Integer>> generate(int dim);
}
