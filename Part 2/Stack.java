import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Stack<E> implements MyCollection<E>, Iterable<E> {

    /*
     * Private class implementing nodes.
     */
    private static class Node<T> {

	private T value;
	private Node<T> next;

	private Node(T value, Node<T> next) {
	    this.value = value;
	    this.next = next;
	}

	/*
	 * Auxiliary method for checking whether e occurs in the stack starting
	 * from this node.
	 */
	private boolean contains(T t) {
	    return ((value == t) || ((next != null) && next.contains(t)));
	}

	/*
	 * Auxiliary method for counting the number of nodes following this one.
	 */
	private int size() {
	    return ((next == null) ? 1 : 1+next.size());
	}

	/*
	 * Returns a copy of the stack from this node.
	 */
	private Node<T> copy() {
	    return ((next == null) ? null : new Node<T>(value,next.copy()));
	}

	/*
	 * Returns a textual representation of the stack from this node.
	 */
	public String toString() {
	    return ((next == null) ? value+" ]" : value + " : "+next.toString());
	}

	/*
	 * Checks whether the stack starting from this node is equal to the
	 * stack starting from other.
	 */
	private boolean equals(Node<T> other) {
	    if (next == null)
		return ((this.value == other.value) && (other.next == null));
	    else
		return ((other.next != null) && this.next.equals(other.next));
	}

	/*
	 * Returns a hash of the stack starting from this node.
	 */
	public int hashCode() {
	    return Objects.hash(value,next);
	}

    }

    /*
     * Private class implementing the iterator.
     */
    private class StackIterator implements Iterator<E> {

	private Node<E> current;

	private StackIterator() {
	    current = top;
	}

	public boolean hasNext() {
	    return (current != null);
	}

	public E next() throws NoSuchElementException {
	    if (current == null)
		throw new NoSuchElementException("No elements left.");
	    E next = current.value;
	    current = current.next;
	    return next;
	}

    }

    /*
     * We only have a pointer to the top element of this stack.
     */
    private Node<E> top;

    /*
     * Creates an empty stack.
     */
    public Stack() {
	top = null;
    }

    /*
     * No getters or setters.
     */

    /*
     * We implement the MyCollection<E> interface.
     */
    public void add(E e) {
	Node<E> newNode = new Node<E>(e, top);
	top = newNode;
    }

    public void clear() {
	top = null;
    }

    public boolean contains(E e) {
	return ((top != null) && top.contains(e));
    }

    public boolean isEmpty() {
	return (top == null);
    }

    public int size() {
	return ((top == null) ? 0 : top.size());
    }

    /*
     * We implement the Iterable<E> interface.
     */
    public Iterator<E> iterator() {
	return new StackIterator();
    }

    /*
     * Returns the top element in this stack.
     * Assumes size() > 0.
     */
    public E top() {
	return top.value;
    }

    /*
     * Removes the top element from this stack.
     * Does nothing if this stack is empty.
     */
    public void pop() {
	if (top != null)
	    top = top.next;
    }

    /*
     * Returns a copy of this stack.
     */
    public Stack<E> copy() {
	Stack<E> copy = new Stack<E>();
	if (top != null)
	    copy.top = top.copy();
	return copy;
    }

    /*
     * Returns a textual representation of this stack.
     */
    public String toString() {
	if (top == null)
	    return "[]";
	else
	    return "[ "+top.toString();
    }

    /*
     * Checks whether this stack is equal to other.
     */
    public boolean equals(Object other) {
	if (!(other instanceof Stack))
	    return false;
	Stack<?> otherStack = (Stack<?>) other;
	return ((this.top == null) ? (otherStack.top == null) :
		((otherStack.top != null) && this.top.equals(otherStack.top)));
    }

    /*
     * Returns a hash of this stack.
     */
    public int hashCode() {
	return Objects.hash(top);
    }

    /*
     * Basic testing.
     */
    public static void main(String[] args) {
	Stack<Integer> s = new Stack<Integer>();
	s.add(1);
	s.add(2);
	System.out.println("Top: "+s.top());
	System.out.println("Size: "+s.size());
	System.out.println("Contains 1: "+s.contains(1));
	System.out.println("Contains 2: "+s.contains(2));
	System.out.println("Contains 4: "+s.contains(4));
	System.out.println("Empty? "+s.isEmpty());
	s.clear();
	System.out.println("Size: "+s.size());
	System.out.println("Empty? "+s.isEmpty());
	s.add(1);
	s.add(2);
	s.add(3);
	s.add(4);
	for (Integer i:s)
	    System.out.println("Iterating: "+i);
	s.pop();
	s.pop();
	System.out.println("Top: "+s.top());
	System.out.println("Size: "+s.size());
	s.pop();
	System.out.println("Top: "+s.top());
	System.out.println("Size: "+s.size());
    }

}
