package com.rengwuxian.rxjavasamples.custom;

/**
 */
public class Test {
	public static void main(String[] args) {
		//两个角色
		Teacher t = new Teacher();
		Student1 stu1 = new Student1();
		Student2 stu2 = new Student2();
		//角色发生关心
		t.addObserver(stu1);
		t.addObserver(stu2);
		//模拟发布消息
		t.publishMessage("tiantian真的说了");
	}
}
