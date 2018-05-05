/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstset;

/**
 *
 * @author aravinsivakumar
 */
public class Stack<E> {

	private int size;
	private Object [] nums; // for this case
	private int index;
	public Stack() {
		size = 10000; // arbitrary
		nums = new Object[size];
		index = 0;
	}
	public Stack(int n) {
		size = n;
		nums = new Object[n];
		index = 0;
	}
	public void push(E val) {
		nums[index] = val;
		index ++;
	}
	public Object pop() {
		if(index < 0) {
			throw new java.lang.Error("Stack Empty");
		}else {
			index --;
			return nums[index];
		}
	}
	public int getSize() {
		return index;
	}
	public boolean isIn(int a) {
		for(int i=0; i<size; i++) {
			if((int)nums[i] == a) {
				return true;
			}
		}
		return false;}
}
