package com.rengwuxian.rxjavasamples.javaobservertest;

/**
 * @author chengyong
 * @time 2017/03/12 21:17
 * @des 测试
 */
public class Test {
	public static void main(String[] args) {
		//1.需要两个角色
		Teacher t = new Teacher();
		Student1 stu1 = new Student1();
		Student2 stu2 = new Student2();
		//2.两个角色发生关系
		t.addObserver(stu1);
		t.addObserver(stu2);
		//3.数据发生改变的时候,被观察者通知所有的观察者
		t.publishMessage(" 我们做一个演示");
	}
}
