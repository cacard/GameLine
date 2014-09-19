package cacard.game.line.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import cacard.game.line.model.Pair;

/**
 * Line�����㷨����-�������
 */

public class LineStrategyRandom implements LineStrategy {

	@Override
	public List<Pair> generate(int dim) {
		List<Pair> line = new ArrayList<Pair>();

		// ���ͷ��
		line.add(PuzzleHelper.getRandomPair(dim));

		while (true) {
			if (line.size() >= dim * dim) {
				break;
			}

			List<Pair> listNeighbor = PuzzleHelper.getNeighbor(line.get(line.size() - 1), dim);
			PuzzleHelper.removeList(listNeighbor, line); // neighbor��ȥ���Ѿ���line�е�Ԫ��

			if (listNeighbor == null || listNeighbor.size() == 0) {
				break;
			}

			// ���ѡȡһ��
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
