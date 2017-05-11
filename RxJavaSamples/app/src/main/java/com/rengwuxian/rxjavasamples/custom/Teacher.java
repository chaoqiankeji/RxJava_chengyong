package com.rengwuxian.rxjavasamples.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 */
public class Teacher {
	public String	message;

	/*
	 addObserver(Observer) 添加观察者到观察者集合中
	 deleteObserver(Observer) 移除对应的观察者
	 notifyObservers() 通知所有的观察者数据已经发生改变
	 setChanged()  标记数据已经发生改变
	 */
	/**
	 * 模拟发布消息
	 */
	public void publishMessage(String message) {
		this.message = message;
		System.out.println("tian说: " + message);
		notifyObservers(message);
	}

	//1.定义接口,以及接口变量
	public interface MessageObserver {
		void onMessageUpdate(String message);
	}

	//2.定义集合保存接口对象
	public List<MessageObserver>	observers	= new ArrayList<>();

	//3.实现必须的几个方法(添加,移除,通知观察者)
	//添加观察者到观察者集合中
	public synchronized void addObserver(MessageObserver o) {
		if (o == null)
			throw new NullPointerException();
		if (!observers.contains(o)) {
			observers.add(o);
		}
	}

	//从观察者集合中移除对应的观察者
	public synchronized void deleteObserver(Observer o) {
		observers.remove(o);
	}

	//通知所有的观察者数据已经发生改变
	public void notifyObservers(String message) {
		for (MessageObserver o : observers) {
			o.onMessageUpdate(message);
		}
	}
}
