/**
 * Line生成算法策略-随机生成
 */

package lcq.game.line.algorithm;

import java.util.ArrayList;
import java.util.List;

import lcq.game.line.model.Pair;

public class LineStrategyRandom implements LineStrategy {

	/**
	 * TODO
	 */
	@Override
	public List<Pair<Integer, Integer>> generate(int dim) {
		
		return null;
	}

	/**
	 * 判断元素是否在链表中
	 * 
	 * @param element
	 * @param list
	 * @return
	 */
	private boolean isInList(Pair<Integer, Integer> element, Pair<Integer, Integer> list) {
		boolean result = false;

		Pair<Integer, Integer> pointer = list;
		while (pointer != null) {
			if (pointer.equals(element)) {
				result = true;
				break;
			}
			pointer = pointer.getNext();
		}

		return result;
	}

	/**
	 * Pair链表转化成ArrayList
	 * 
	 * @param head
	 * @return
	 */
	private List<Pair<Integer, Integer>> convertToArrayList(Pair<Integer, Integer> head) {

		if (head == null) {
			return null;
		}

		List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();

		do {
			list.add(head);
			head = head.getNext();
		} while (head != null);

		return list;
	}

	/**
	 * List<Pair<>> => List<String>
	 * 
	 * @param list
	 * @return
	 */
	private List<String> convertPairListToStringList(List<Pair<Integer, Integer>> list) {
		if (list == null || list.size() == 0) {
			return null;
		}

		List<String> listString = new ArrayList<String>();
		for (Pair<Integer, Integer> p : list) {
			listString.add(p.toString());
		}

		return listString;
	}

}
