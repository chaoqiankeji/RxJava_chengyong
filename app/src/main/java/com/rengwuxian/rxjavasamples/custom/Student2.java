package com.rengwuxian.rxjavasamples.custom;

import com.rengwuxian.rxjavasamples.custom.Teacher.MessageObserver;

/**
 */
public class Student2 implements MessageObserver {

	@Override
	public void onMessageUpdate(String message) {
		System.out.println(this.getClass().getSimpleName() + " 收到 " + message);
	}

}
