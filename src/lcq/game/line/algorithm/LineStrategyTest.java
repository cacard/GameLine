/**
 * 手动生成，供测试
 */
package lcq.game.line.algorithm;

import java.util.ArrayList;
import java.util.List;

import lcq.game.line.model.Pair;

public class LineStrategyTest implements LineStrategy {

	@Override
	public List<Pair<Integer, Integer>> generate(int dim) {
		List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();

		for (int i = 0; i < dim - 1; i++) {
			list.add(new Pair<Integer, Integer>(0, i));
		}

		for (int i = 1; i < dim - 1; i++) {
			list.add(new Pair<Integer, Integer>(i, dim - 1));
		}

		return null;
	}

}
