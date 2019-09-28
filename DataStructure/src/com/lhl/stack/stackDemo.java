package com.lhl.stack;

public class stackDemo {
	public static void main(String[] args) {
		ArrayStack as=new ArrayStack(3);
		as.push(1);
		as.push(3);
		as.push(5);
		
		
		as.showStack();
		
		as.pop();
		
		as.showStack();
	}
}

class ArrayStack{
	
	int maxSize;
	int top;
	int[] stack;
	
	public ArrayStack(int size) {
		this.maxSize=size;
		this.top=-1;
		this.stack=new int[size];
	}
	
	boolean isFull() {
		return top==maxSize-1;
	}
	
	boolean isEmpty() {
		return top==-1;
	}
	
	int pop() {
		if(isEmpty()) {
			System.out.println("栈为空");
			throw new RuntimeException("栈为空");
		}
		top--;
		return stack[top];
	}
	
	void push(int value) {
		if(isFull()) {
			System.out.println("栈为满");
			return;
		}
		top++;
		stack[top]=value;
	}

	int getTop(){
		return stack[top];
	}
	
	void showStack() {
		int i=top;
		
		if(isEmpty()) {
			return;
		}
		
		while(i>-1) {
			System.out.printf("stack[%d]=%d    ",i,stack[i]);
			i--;
		}
		System.out.println();
	}
	
}
