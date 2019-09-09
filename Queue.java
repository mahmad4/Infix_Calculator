
public class Queue<T> {
	private Node<T> first;
	private Node<T> last;
	
	// Node class
	private class Node<T> {
		private T data;
		private Node<T> next;
	}
	
	// Queue constructor
	public Queue(){
		first = null;
		last = null;
	}
	
	// to check if the queue is empty
	public boolean Empty(){
		return first == null;
	}
	
	// enqueue method 
	public void enqueue(T data){
		Node<T> old = last;
		last = new Node<T>();
		last.data = data;
		last.next = null;
		if (Empty()){
			first = last;
		}
		else{
			old.next = last;
		}
	}
	
	
	//dequeue method
	public T dequeue(){
		T data = first.data;
		first = first.next;
		return data;
	}
	
}
