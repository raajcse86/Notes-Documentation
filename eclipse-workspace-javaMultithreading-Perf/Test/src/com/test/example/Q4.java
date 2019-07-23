package com.test.example;


class Message {
    String msg = "Happy New Year!";

    public void print() {
        System.out.println(msg);
    }
}
public class Q4 {

	
	public static void change(Message m) {
        m = new Message();
        m.msg = "Happy Holidays!";
        //m.print();
        //return m;
    }

    public static void main(String[] args) {
        Message obj = new Message();
        obj.print();
        change(obj);
        obj.print();
    }
}



