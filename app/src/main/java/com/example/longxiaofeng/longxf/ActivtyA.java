package com.example.longxiaofeng.longxf;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author longxiaofeng
 * @since 17/8/9
 */

public class ActivtyA extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LXF",this.getClass().getSimpleName()+"onCre111ate");
        setContentView(R.layout.act_main);


        Log.d("LXF",this.getClass().getSimpleName()+"onCre111ate+master");
        Log.d("LXF",this.getClass().getSimpleName()+"onCre111ate+master");

        Log.d("LXF",this.getClass().getSimpleName()+"onCre111ate+branch");
        Log.d("LXF",this.getClass().getSimpleName()+"onCre111ate+branch");
        Log.d("LXF",this.getClass().getSimpleName()+"onCre111ate+branch");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LXF",this.getClass().getSimpleName()+"onStart");
        Log.d("LXF",this.getClass().getSimpleName()+"onCre111ate+master");
        Log.d("LXF",this.getClass().getSimpleName()+"onCre111ate+master");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LXF",this.getClass().getSimpleName()+"onPause");
        Log.d("LXF",this.getClass().getSimpleName()+"onCre111ate+branch");
        Log.d("LXF",this.getClass().getSimpleName()+"onCre111ate+branch");
        Log.d("LXF",this.getClass().getSimpleName()+"onCre111ate+branch");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LXF",this.getClass().getSimpleName()+"onResume");

        Log.d("LXF",this.getClass().getSimpleName()+"onResume+branch1");
        Log.d("LXF",this.getClass().getSimpleName()+"onResume+branch2");
        Log.d("LXF",this.getClass().getSimpleName()+"onResume+branch3");

        Log.d("LXF",this.getClass().getSimpleName()+"onResume+branch11");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LXF",this.getClass().getSimpleName()+"onStop");
    }
}
