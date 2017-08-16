package com.picturetagview;

import android.app.Activity;
import android.os.Bundle;

import com.example.longxiaofeng.longxf.R;

public class MainAct extends Activity{

	private PictureTagLayout mPictureTagLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.act_main);
		mPictureTagLayout = (PictureTagLayout)findViewById(R.id.mPictureTagLayout);


	}

	@Override
	protected void onResume() {
		super.onResume();
		mPictureTagLayout.post(new Runnable() {
			@Override
			public void run() {
				int x = (int) mPictureTagLayout.getX();
				int y= (int) mPictureTagLayout.getY();
				mPictureTagLayout.addItem(0,y,"龙小锋");
			}
		});

	}
}
