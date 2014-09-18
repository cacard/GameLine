package cacard.game.line.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class BlockView extends View {

	public BlockView(Context context) {
		super(context);
	}

	public BlockView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		// 修改measureHeight等于measureWidth，实现正方形效果
		setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec), getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec));

	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		// int width = right - left;
		// this.setBottom(top + width); // 设置为正方形

	}

	@Override
	protected void onDraw(Canvas canvas) {
	}
}
