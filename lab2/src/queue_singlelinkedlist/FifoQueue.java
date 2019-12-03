package queue_singlelinkedlist;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**
	 * Inserts the specified element into this queue, if possible post: The
	 * specified element is added to the rear of this queue
	 * 
	 * @param e the element to insert
	 * @return true if it was possible to add the element to this queue, else false
	 */
	public boolean offer(E x) {
		QueueNode<E> newLast = new QueueNode<E>(x);

		if (size != 0) {
			newLast.next = last.next;
			last.next = newLast;
		} else {
			newLast.next = newLast;
		}
		last = newLast;
		size++;

		return true;
	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if
	 * this queue is empty
	 * 
	 * @return the head element of this queue, or null if this queue is empty
	 */
	public E peek() {
		if (last != null)
			return last.next.element;
		return null;
	}
	
	/**
	* Appends the specified queue to this queue
	* post: all elements from the specified queue are appended
	* to this queue. The specified queue (q) is empty after the call.
	* @param q the queue to append
	* @throws IllegalArgumentException if this queue and q are identical
	*/
	public void append(FifoQueue <E> x)throws IllegalArgumentException  {
		if (last==null || x.isEmpty() || this.last==x.last) {
			throw new IllegalArgumentException (" queue and q are identical or q is empty");	
		}
		
		while (x.size()!=0) {
		offer(x.poll());
		}
	}

	/**
	 * Retrieves and removes the head of this queue, or null if this queue is empty.
	 * post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {
		if (last != null) {
			QueueNode<E> copy = last;
			last = copy.next;
			size--;
			return last.element;
		}
		return null;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	public Iterator<E> iterator() {
		return new QueueIterator();

	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;

		private QueueIterator() {
			pos = last;

		}

		public boolean hasNext() {
			return pos != null;

		}

		public E next() throws NoSuchElementException {
			if (hasNext()) {
				QueueNode<E> copy = pos.next;
				pos = pos.next;
				if (pos.next == last.next || last.next == last)
					pos = null;
				return copy.element;
			} else {
				throw new NoSuchElementException("next has a problem");
			}
		}
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}

		

	}

	

	

	
}
