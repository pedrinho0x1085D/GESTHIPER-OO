
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Pedro Cunha
 */
public class Navigator<T> {
	private ArrayList<T> items;
	int current;
	
	public Navigator(ArrayList<T> l) {
		this.items = new ArrayList<>(l);
		this.current = 0;
	}
	
	public Navigator(TreeSet<T> s) {
		this.items = new ArrayList<>(s);
		this.current = 0;
	}
	
	public T getNext() throws NoMoreItemsException {
		if (this.current >= this.items.size()) {
			throw new NoMoreItemsException();
		}
		else {
			this.current++;
			return this.items.get(this.current - 1);
		}
	}
	
	public List<T> getNext(int n) throws NoMoreItemsException {
		if (this.current >= this.items.size()) {
			throw new NoMoreItemsException();
		}
		else {
			int curr = this.current;
			this.current += n;
			
			if (this.current > this.items.size()) {
				this.current = this.items.size();
			}
			
			return this.items.subList(curr, this.current);
		}
	}
	
	public void back(int n) throws NoMoreItemsException {
		if (this.current <= 0) {
			throw new NoMoreItemsException();
		}
		else {
			this.current -= n;
			
			if (this.current < 0) {
				this.current = 0;
			}
		}
	}
	
	public void back() throws NoMoreItemsException {
		if (this.current <= 0) {
			throw new NoMoreItemsException();
		}
		else {
			this.current--;
		}
	}
	
	public int size() {
		return this.items.size();
	}
	
	public int current() {
		return this.current;
	}
	
	public int itemsLeft() {
		return this.items.size() - this.current;
	}
}