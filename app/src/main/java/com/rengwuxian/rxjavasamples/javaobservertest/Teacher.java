package com.rengwuxian.rxjavasamples.javaobservertest;

import java.util.Observable;

/**
 * @author chengyong
 * @time 2017/03/12 21:07
 * @des 被观察者
 */
public class Teacher extends Observable {
	public String	message;

	/*
	 */
	/**
	 * 模拟发布消息
	 */
	public void publishMessage(String message) {
		this.message = message;
		System.out.println("tiantian说: " + message);
		setChanged();
		notifyObservers();
	}
}
