package cacard.game.line.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import cacard.game.line.model.Pair;

/**
 * Line生成算法策略-随机生成
 */

public class LineStrategyRandom implements LineStrategy {

	@Override
	public List<Pair> generate(int dim) {
		List<Pair> line = new ArrayList<Pair>();

		// 随机头部
		line.add(PuzzleHelper.getRandomPair(dim));

		while (true) {
			if (line.size() >= dim * dim) {
				break;
			}

			List<Pair> listNeighbor = PuzzleHelper.getNeighbor(line.get(line.size() - 1), dim);
			PuzzleHelper.removeList(listNeighbor, line); // neighbor中去除已经在line中的元素

			if (listNeighbor == null || listNeighbor.size() == 0) {
				break;
			}

			// 随机选取一个
			if (listNeighbor.size() == 1) {
				line.add(listNeighbor.get(0));
			} else {
				int index = new Random(System.nanoTime()).nextInt(listNeighbor.size());
				line.add(listNeighbor.get(index));
			}
		}

		return line;
	}

	// Test
	public static void main(String[] args) {

	}

}
