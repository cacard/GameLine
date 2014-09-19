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
 * ����layoutGamebox����ָ���꣬����box����
 */
public class GameboxOnTouchListener implements OnTouchListener {

	private int dim;
	private Block[][] blocks;
	private View[][] blockViews;
	private int blockWidth;
	private List<Pair> line;

	public GameboxOnTouchListener(int dim, View[][] blockViews, int blockWidth, Block[][] blocks, List<Pair> line) {
		this.dim = dim;
		this.blockViews = blockViews;
		this.blockWidth = blockWidth;
		this.blocks = blocks;
		this.line = line;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {

		boolean needCheck = false;

		if (event.getActionMasked() == MotionEvent.ACTION_DOWN || event.getActionMasked() == MotionEvent.ACTION_MOVE) {

			// �����Ӧ����������
			int j = (int) Math.floor((float) event.getX() / (float) blockWidth);
			int i = (int) Math.floor((float) event.getY() / (float) blockWidth);

			// �߽���
			if (j < 0 || i < 0 || j >= dim || i >= dim) {
				return true;
			}

			if (blocks[i][j].isTouchable()) {
				List<Pair> neighbor = PuzzleHelper.getNeighbor(line.get(line.size() - 1), dim);
				PuzzleHelper.removeList(neighbor, line); // ȥ���Ѿ���line�е�neighborԪ��
				// �жϵ�ǰԪ���Ƿ��ǿ���ӵĽ���Ԫ��֮һ���Ѿ���line�е�Ԫ�ز������
				if (PuzzleHelper.containsPair(neighbor, i, j)) {
					line.add(new Pair(i, j));
					blockViews[i][j].setBackgroundColor(Config.colorTouched);

					needCheck = true;
				}
			}

		} else if (event.getActionMasked() == MotionEvent.ACTION_UP) {
			needCheck = true;
		}

		if (needCheck) {
			if (PuzzleHelper.isSolved(blocks, dim, line)) {
				for (Pair p : line) {
					blockViews[p.getT1()][p.getT2()].setBackgroundColor(Config.colorStart);
				}
			}
		}

		return true;
	}

}
