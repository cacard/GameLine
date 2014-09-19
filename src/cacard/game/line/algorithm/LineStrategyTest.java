package cacard.game.line.algorithm;

import java.util.ArrayList;
import java.util.List;

import cacard.game.line.model.Pair;

/**
 * 手动生成，供测试
 */
public class LineStrategyTest implements LineStrategy {
	@Override
	public List<Pair> generate(int dim) {
		List<Pair> list = new ArrayList<Pair>();

		for (int i = 0; i < dim; i++) {
			list.add(new Pair(0, i));
		}

		for (int i = 1; i < dim; i++) {
			list.add(new Pair(i, dim - 1));
		}

		return list;
	}
}
