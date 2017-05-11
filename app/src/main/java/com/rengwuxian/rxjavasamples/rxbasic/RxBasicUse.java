package com.rengwuxian.rxjavasamples.rxbasic;

import android.os.SystemClock;
import android.util.Log;

import com.rengwuxian.rxjavasamples.custom.Teacher;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.NewThreadScheduler;
import rx.schedulers.Schedulers;

/**
 * @author chengyong
 * @time 2017/3/13 10:52
 * @des ${TODO}
 */

public class RxBasicUse {
public static final String TAG="juice";
    public static void orignal(){
        Subscriber<String> observer = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                System.out.println("from----onNext");
            }

            @Override
            public void onCompleted() {
                System.out.println("from----onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("from----onError");
            }
        };
        //穿件被观察者
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("from----call");
                subscriber.onNext("Hello");
            }
        });

        observable.subscribe(observer);  //订阅
        observable.subscribe(observer);  //订阅
    }





    /**
     * 功能：将一个或多个对象转换成发射这个或这些对象的一个Observable。
     */
    public static void just(){
//        String j="teacher";
        Teacher  j=new Teacher();
     Observable.just(1,3,j,5,6)
             .subscribe(new Action1<Object>() {
                 @Override
                 public void call(Object o) {

                 }
             });
    }

    /**
     * 功能：将一个Iterable, 一个Future, 或者一个数组转换成一个Observable
     */
    public static void from(){
        List<String> list=new ArrayList<String>();
        list.add("on");
        list.add("one");
        list.add("two");
        list.add("owe");
        Observable.
                from(list)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("from----onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("from---onError"+e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("from----OnNext"+s);
            }
        });
    }

    /**
     *    功能： 过滤数据。
          该例子打印以“o”开头，“e”结尾的字符串。
     */
    public static void filter(){
        List<String> list=new ArrayList<>();
        list.add("on");
        list.add("one");
        list.add("two");
        list.add("owe");
         Observable.from(list)
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return s.startsWith("i");
                    }
                })
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        System.out.println("from----filter?"+s);
                        return s.endsWith("e");
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("from----filter"+s);
                    }
                });
    }


//    .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
//            .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程

    /**
     *    功能：对序列的每一项都应用一个函数来变换Observable发射的数据序列。
     */
    public static void map(){
        Observable.just(1,2,3,4)
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return "45"+integer;
                    }
                })
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return Integer.parseInt(s)+100;
                    }
                })
                .subscribe(new Action1<Integer>() {

                    @Override
                    public void call(Integer s) {
                        System.out.println("map: " + s);
                    }
                });
    }
}
