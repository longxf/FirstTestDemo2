package com.example.longxiaofeng.longxf;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class Main2Activity extends AppCompatActivity {
private Button mButton;

    public static final String tag="LXF";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mButton = (Button)this.findViewById(R.id.Button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rxJavaTest1();
            }
        });
        recreate();
    }

    private void rxJavaTest1(){
        Observer<String> observer =new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.d(tag,"Observer onCompleted");

            }
            public void onError(Throwable e) {
                Log.d(tag,"Observer onError");
            }

            @Override
            public void onNext(String s) {
                Log.d(tag,"Observer onNext");
            }
        };

        Subscriber<String> subscriber = new Subscriber<String>(){

            @Override
            public void onCompleted() {
                Log.d(tag,"Subscriber onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(tag,"Subscriber onError");
            }

            @Override
            public void onNext(String s) {
                Log.d(tag,"Subscriber onNext "+s);
            }
        };

        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("111");
                subscriber.onNext("222");
                subscriber.onNext("333");
                subscriber.onCompleted();
            }
        });
        observable.subscribeOn(Schedulers.newThread());
        observable.subscribe(observer);
    }

    private void rxJavaTest2(){
        //Observable.from("").flatMap()
    }

}
