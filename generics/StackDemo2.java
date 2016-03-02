package demo.generics;

public class StackDemo2<T> {
	private class Node<T> {
		T item;
		Node<T> next;
		Node() { item = null; next = null; }
		Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}
	}
	private Node<T> top = new Node<T>();
	
	public void push(T x) {
		if (x != null) top = new Node<T>(x, top); 
	}
	public T pop() {
		T result = top.item;
		if (result != null) top = top.next;
		return result;
	}
}
