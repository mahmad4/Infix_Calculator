
public class Stack<T> {

	private Node<T> top;
	
	// Node class
	private class Node<T>{
		private T data;
		private Node<T> next;
	}
	
	// stack constructor
	public Stack(){
		top = null;
	}
	
	// push method
	public void push (T data){
		Node<T> old = top;
		top = new Node<T>();
		top.data = data;
		top.next = old;
	}
	
	// pop method 
	public T pop(){
		T data = top.data;
		top = top.next;
		return data;
	}
	
	public boolean isEmpty() {
        return top == null;
    }
	
	public T getTop(){
		return top.data;
	}
	 
}
