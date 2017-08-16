package com.example.longxiaofeng.longxf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.longxiaofeng.utils.Task;
import com.example.longxiaofeng.utils.TaskManager;
import com.example.longxiaofeng.utils.TaskOperation;
import com.lxf.aar.MyTest;


import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.M;


public class MainActivity extends AppCompatActivity {

    private Button btn;
    private ImageTextView imageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);

        imageTextView = (ImageTextView) findViewById(R.id.imageText);


        Log.d("LXF","MainActivity");
        MyTest.add(100);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imageTextView.setText("hello");
//                imageTextView.setImageRes(R.mipmap.pic_auto_pause);
//                btn.setError("error");
 //               doTask();
//                startActivity(new Intent(MainActivity.this,Main2Activity.class));

                Intent[] intents = new Intent[1];
                intents[0] = new Intent(MainActivity.this,ConstraintLayoutActivity.class);
//                intents[1] = new Intent(MainActivity.this,ActivtyB.class);
                MainActivity.this.startActivities(intents);
            }
        });
    }

    private void doTask(){
        TaskManager taskManager = new TaskManager("lxf",true);
        taskManager.setStateChangeListener(new TaskManager.IStateChangeListener() {
            @Override
            public void onStateChanged(TaskManager taskManager, TaskManager.State oldState, TaskManager.State
                    newState) {
            }
        });
        taskManager.next(new Task(Task.RunningStatus.WORK_THREAD) {
            @Override
            public TaskOperation onExecute(TaskOperation operation) {
                ArrayList<String> list = new ArrayList<String>();
                list.add("111");
                list.add("222");
                list.add("333");
                operation.appendTaskParams(new Object[]{list});
                return operation;
            }
        }).next(new Task(Task.RunningStatus.WORK_THREAD) {
            @Override
            public TaskOperation onExecute(TaskOperation operation) {
                ArrayList<String> list = (ArrayList<String>)operation.getTaskParams()[0];

                list.add("444");
                list.add("555");
                list.add("666");
                operation.appendTaskParams(new Object[]{list});
                return operation;
            }
        }).next(new Task(Task.RunningStatus.UI_THREAD) {
            @Override
            public TaskOperation onExecute(TaskOperation operation) {
                ArrayList<String> list = (ArrayList<String>)operation.getTaskParams()[0];
                if(list!=null){
                    Toast.makeText(MainActivity.this,"size"+list.size(),Toast.LENGTH_LONG).show();
                }

                return null;
            }
        }).execute();
    }

}
