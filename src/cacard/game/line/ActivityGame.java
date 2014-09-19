/**
 * Line Puzzle Game
 * 
 * copyright by licunqing @ 2014.9
 */

package cacard.game.line;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import cacard.game.line.algorithm.LineStrategy;
import cacard.game.line.algorithm.LineStrategyRandom;
import cacard.game.line.algorithm.PuzzleGenerator;
import cacard.game.line.listener.GameboxOnTouchListener;
import cacard.game.line.model.Block;
import cacard.game.line.model.Pair;
import cacard.game.line.model.Puzzle;
import cacard.game.line.view.BlockView;

public class ActivityGame extends Activity {

	private int dim = 6;
	private Puzzle puzzleOrg;// ԭʼpuzzle

	private RelativeLayout layoutRoot;
	private RelativeLayout layoutGamebox;
	private Button btnNewGame;
	private Button btnReGame;

	private List<Pair> line = new ArrayList<Pair>();
	private LineStrategy defaultStrategy = new LineStrategyRandom();// ����

	private int blockWidth;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_game);

		layoutGamebox = (RelativeLayout) this.findViewById(R.id.layoutGamebox);
		layoutRoot = (RelativeLayout) this.findViewById(R.id.layoutRoot);
		btnNewGame = (Button) this.findViewById(R.id.btnNewGame);
		btnReGame = (Button) this.findViewById(R.id.btnReGame);
		layoutGamebox.setPadding(5, 15, 5, 15);

		// ��Ļ�����Ϣ
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		final int screenWidth = metrics.widthPixels;
		blockWidth = (int) ((float) screenWidth / (float) dim); // �����ÿ��block�Ŀ��

		// events
		btnReGame.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ActivityGame.this.reGame();
			}
		});
		btnNewGame.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ActivityGame.this.newGame(defaultStrategy);
			}
		});

		newGame(defaultStrategy);
	}

	/**
	 * ��������
	 */
	private void reGame() {
		// clear
		layoutGamebox.setOnTouchListener(null);
		final Pair pHead = new Pair(line.get(0).getT1(), line.get(0).getT2()); // ͷ������
		line.clear();
		line.add(pHead);

		drawAndListen();
	}

	/**
	 * ����Ϸ
	 * 
	 * @param strategy
	 */
	private void newGame(LineStrategy strategy) {
		// clear
		layoutGamebox.setOnTouchListener(null);
		layoutGamebox.removeAllViews();
		line = new ArrayList<Pair>();
		puzzleOrg = new PuzzleGenerator(strategy, dim).generate();

		line.add(puzzleOrg.getStart());// start����뵽line��
		drawAndListen();
	}

	private void drawAndListen() {

		final Block[][] blocks = puzzleOrg.getBlocks();

		View[][] blockViews = new View[dim][dim];// block��Ӧ��view��������

		// ����
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				final View v = new BlockView(this);
				android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(blockWidth - 10, blockWidth - 10);

				layoutParams.leftMargin = j * blockWidth;
				layoutParams.topMargin = i * blockWidth;
				v.setLayoutParams(layoutParams);

				if (blocks[i][j].getRole() == Block.ROLE_START) {
					v.setBackgroundColor(Config.colorStart);
				} else if (blocks[i][j].getRole() == Block.ROLE_BARRIER) {
					v.setBackgroundColor(Config.colorBarrier);
				} else if (blocks[i][j].getRole() == Block.ROLE_TOUCHABLE) {
					v.setBackgroundColor(Config.colorTouchable);
				}

				layoutGamebox.addView(v);
				blockViews[i][j] = v;
			}
		}

		// ����layoutGamebox����ָ���꣬����box����
		layoutGamebox.setOnTouchListener(new GameboxOnTouchListener(dim, blockViews, blockWidth, blocks, line));
	}

	@Override
	public void onStart() {
		super.onStart();

	}

	@Override
	public void onResume() {
		super.onResume();

	}

	@Override
	public void onPause() {
		super.onPause();

	}

	@Override
	public void onStop() {
		super.onStop();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

	}

}
