package cacard.game.line.listener;

import java.util.List;

import cacard.game.line.Config;
import cacard.game.line.algorithm.PuzzleHelper;
import cacard.game.line.model.Block;
import cacard.game.line.model.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * 跟踪layoutGamebox的手指坐标，触发box触碰
 */
public class GameboxOnTouchListener implements OnTouchListener {

	private int dim;
	private Block[][] blocks;
	private View[][] blockViews;
	private int blockWidth;
	private List<Pair<Integer, Integer>> line;

	public GameboxOnTouchListener(int dim, View[][] blockViews, int blockWidth, Block[][] blocks, List<Pair<Integer, Integer>> line) {
		this.dim = dim;
		this.blockViews = blockViews;
		this.blockWidth = blockWidth;
		this.blocks = blocks;
		this.line = line;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getActionMasked() == MotionEvent.ACTION_DOWN || event.getActionMasked() == MotionEvent.ACTION_MOVE) {

			// 计算对应的数组坐标
			int j = (int) Math.floor((float) event.getX() / (float) blockWidth);
			int i = (int) Math.floor((float) event.getY() / (float) blockWidth);
			// Log.i("test", "x:" + event.getX() + ",y:" + event.getY()
			// + "|m:" + m + ",n:" + n);

			// 边界检查
			if (j < 0 || i < 0 || j >= dim || i >= dim) {
				return true;
			}

			if (blocks[i][j].isTouchable()) {

				// 判断是否是line中最后一个元素的近邻
				List<Pair<Integer, Integer>> l = PuzzleHelper.getNeighbor(line.get(line.size() - 1), dim);

				// 判断当前元素是否是近邻元素之一
				if (PuzzleHelper.containsPair(l, i, j)) {
					line.add(new Pair<Integer, Integer>(i, j));
					blockViews[i][j].setBackgroundColor(Config.colorStart);
				}

			}

		} else if (event.getActionMasked() == MotionEvent.ACTION_UP) {

		}

		return true;
	}

}
