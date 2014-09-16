/**
 * 
 */
package lcq.game.line;

import lcq.game.line.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class ActivityMain extends Activity {

	private ImageView imageLogo;
	private Button btnStart;
	private Button btnSettings;
	private Button btnHelp;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		findControls();
		setClickEvent();
	}

	// 寻找控件
	private void findControls() {
		imageLogo = (ImageView) this.findViewById(R.id.imageLogo);
		btnStart = (Button) this.findViewById(R.id.btnStartGame1);
		btnSettings = (Button) this.findViewById(R.id.btnSettings);
		btnHelp = (Button) this.findViewById(R.id.btnHelp);
	}

	// 按钮添加点击事件
	private void setClickEvent() {
		btnStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ActivityMain.this.startActivity(new Intent(ActivityMain.this, ActivityGame.class));
			}
		});

		btnSettings.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ActivityMain.this.startActivity(new Intent(ActivityMain.this, ActivitySettings.class));
			}
		});

		btnHelp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ActivityMain.this.startActivity(new Intent(ActivityMain.this, ActivityHelp.class));
			}
		});

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
