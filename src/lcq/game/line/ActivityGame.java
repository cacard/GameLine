/**
 * 
 */
package lcq.game.line;

import lcq.game.line.algorithm.LineStrategyTest;
import lcq.game.line.algorithm.PuzzleGenerator;
import lcq.game.line.model.Block;
import lcq.game.line.model.Puzzle;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

public class ActivityGame extends Activity {

	private static int gameboxPadding = 10;
	private static int blockPadding = 10;

	private final int colorStart = Color.rgb(0xFF, 0x66, 0);
	private final int colorTouchable = Color.rgb(0xCC, 0xFF, 0x99);
	private final int colorBarrier = Color.rgb(200, 200, 200);

	private int dim = 6;
	private Puzzle puzzleOrg;// 原始puzzle
	private Puzzle puzzleOperate;// 用户操作中的puzzle

	private RelativeLayout layoutRoot;
	private LinearLayout layoutGamebox;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_game);

		layoutGamebox = (LinearLayout) this.findViewById(R.id.layoutGamebox);
		layoutRoot = (RelativeLayout) this.findViewById(R.id.layoutRoot);

		puzzleOrg = new PuzzleGenerator(new LineStrategyTest(), dim).generate();
		Block[][] blocks = puzzleOrg.getBlocks();

		// 绘制
		for (int i = 0; i < dim; i++) {
			// 每行一个LinearLayout
			LinearLayout ll = new LinearLayout(this);
			ll.setOrientation(LinearLayout.HORIZONTAL);
			ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1));

			// 每一行内的Block
			for (int j = 0; j < dim; j++) {
				final View v = new View(this);
				LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1);
				layoutParams.setMargins(10, 10, 10, 10);
				v.setLayoutParams(layoutParams);

				if (blocks[i][j].getRole() == Block.ROLE_START) {
					v.setBackgroundColor(colorStart);
				} else if (blocks[i][j].getRole() == Block.ROLE_TOUCHABLE) {
					v.setBackgroundColor(colorTouchable);
					
					final int ii=i;
					final int jj=j;
					// TODO Hover事件捕捉
					v.setOnTouchListener(new OnTouchListener() {
						@Override
						public boolean onTouch(View v, MotionEvent event) {
							v.setBackgroundColor(colorStart);
							Log.i("test", "block[" + ii + "][" + jj + "],action:" + event.getActionMasked());
							return true;
						}
					});

				} else if (blocks[i][j].getRole() == Block.ROLE_BARRIER) {
					v.setBackgroundColor(colorBarrier);
				}

				ll.addView(v);
			}

			layoutGamebox.addView(ll);
		}

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
