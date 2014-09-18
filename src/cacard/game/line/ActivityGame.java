package cacard.game.line;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import cacard.game.line.algorithm.LineStrategyTest;
import cacard.game.line.algorithm.PuzzleGenerator;
import cacard.game.line.listener.GameboxOnTouchListener;
import cacard.game.line.model.Block;
import cacard.game.line.model.Pair;
import cacard.game.line.model.Puzzle;
import cacard.game.line.view.BlockView;

public class ActivityGame extends Activity {

	private int dim = 6;
	private Puzzle puzzleOrg;// 原始puzzle
	private Puzzle puzzleOperate;// 用户操作中的puzzle

	private RelativeLayout layoutRoot;
	private RelativeLayout layoutGamebox;
	
	private List<Pair<Integer,Integer>> line = new ArrayList<Pair<Integer,Integer>>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_game);

		layoutGamebox = (RelativeLayout) this.findViewById(R.id.layoutGamebox);
		layoutRoot = (RelativeLayout) this.findViewById(R.id.layoutRoot);
		
		layoutGamebox.setPadding(5, 15, 5, 15);

		// 屏幕相关信息
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		final int screenWidth = metrics.widthPixels;
		final int blockWidth = (int) ((float) screenWidth / (float) dim); // 计算出每个block的宽度

		puzzleOrg = new PuzzleGenerator(new LineStrategyTest(), dim).generate();
		Block[][] blocks = puzzleOrg.getBlocks();
		line.add(puzzleOrg.getStart());// start块加入到line中

		// block对应的view块存放起来
		View[][] blockViews = new View[dim][dim];

		// 绘制
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

					final int ii = i;
					final int jj = j;

					v.post(new Runnable() {
						@Override
						public void run() {
							Log.i("test", "" + v.getWidth() + "," + v.getHeight() + "|" + v.getX() + "," + v.getY() + "|" + v.getTop() + "," + v.getLeft() + "," + v.getRight() + "," + v.getBottom());

						}
					});

				}

				layoutGamebox.addView(v);
				blockViews[i][j] = v;
			}
		}
		
		

		// 跟踪layoutGamebox的手指坐标，触发box触碰
		layoutGamebox.setOnTouchListener(new GameboxOnTouchListener(dim, blockViews, blockWidth, blocks,line));

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
