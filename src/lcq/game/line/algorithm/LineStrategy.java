/**
 * 生成一条Line的算法策略接口
 */

package lcq.game.line.algorithm;

import java.util.List;

import lcq.game.line.model.Pair;

public interface LineStrategy {
	List<Pair<Integer, Integer>> generate(int dim);
}
