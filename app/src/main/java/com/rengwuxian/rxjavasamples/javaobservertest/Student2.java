package com.rengwuxian.rxjavasamples.javaobservertest;

import java.util.Observable;
import java.util.Observer;
/**
 * @author chengyong
 * @time 2017/03/12 21:07
 * @des 观察者2
 */
public class Student2 implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		Teacher t = (Teacher) o;
		String message = t.message;
		System.out.println(this.getClass().getSimpleName() + " 收到 " + message);
	}

}
