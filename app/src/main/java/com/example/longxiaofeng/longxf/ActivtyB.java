package com.example.longxiaofeng.longxf;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author longxiaofeng
 * @since 17/8/9
 */

public class ActivtyB extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LXF",this.getClass().getSimpleName()+"onCreate");
        setContentView(R.layout.act_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LXF",this.getClass().getSimpleName()+"onStart");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LXF",this.getClass().getSimpleName()+"onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LXF",this.getClass().getSimpleName()+"onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LXF",this.getClass().getSimpleName()+"onStop");
    }
}
