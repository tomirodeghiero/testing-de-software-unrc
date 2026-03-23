package assignment2_exercises.stack;

import java.util.Arrays;

public class StackAr extends Stack {

	private final static int DEFAULT_CAPACITY = 10;

	private final Object[] elems;

	private int sp = -1;

	
	/**
     * Construct a stack of DEFAULT_CAPACITY (10) capacity
     */
	public StackAr() {
		this(DEFAULT_CAPACITY);
	}

	
	/**
     * Construct the stack.
     * @param capacity the capacity.
     */

	public StackAr(int capacity) throws IllegalArgumentException {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}
		this.elems = new Object[capacity];
	}
	
	

	public int size() {
		return sp+1;
	}

	
	 /**
     * Test if the stack is  empty.
     * @return true if empty, false otherwise.
     */
	public boolean isEmpty() {
		return size() == 0;
	}

	
	 /**
     * Test if the stack is  full.
     * @return true if full, false otherwise.
     */

	public boolean isFull() {
		return size() == elems.length;
	}

	/**
     * Insert a new item into the stack, if not already full.
     * @param x the item to insert.
     * @throw IllegalStateException if stack is already full.
     */
	
	public void push(Object o) throws IllegalStateException {
		if (isFull()) {
			throw new IllegalStateException();
		}
		if (o == null) {
			throw new IllegalArgumentException();
		}
		this.sp++;
		this.elems[sp] = o;
	}
	
	/**
     * Make the stack  empty.
     */
    public void makeEmpty( )
    {
    	
		for(int i = 0; i<= sp; i++) {
			elems[i] = null;
		}
        sp = -1;
    }

    

    /**
     * Remove the most recently inserted item from the stack.
     * @throw IllegalStateException if stack is empty.
     */
	public Object pop() throws IllegalStateException {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		Object rv = this.elems[sp];
		this.elems[sp] = null;
		sp--;
		return rv;
	}

	
	
	 /**
     * Get the most recently inserted item in the stack.
     * Does not alter the stack.
     * @return the most recently inserted item in the stack,
     * @throw IllegalStateException if stack is  empty.

     */
	public Object top() throws IllegalStateException {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		Object rv = this.elems[sp];
		return rv;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(elems);
		result = prime * result + sp;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StackAr other = (StackAr) obj;
		if (!Arrays.equals(elems, other.elems))
			return false;
		if (sp != other.sp)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("[");
		for (int i = 0; i <= sp; i++) {
			if (i > 0) {
				b.append(",");
			}
			Object o = elems[i];
			String s = String.valueOf(o);
			b.append(s);
		}
		b.append("]");
		return b.toString();
	}
	
	
	/**
     * @return True if the stack is a well-formed stack,
     * false otherwise
     */
	public boolean repOk(){
		if (elems == null) {
			return false;
		}

		if (sp < -1 || sp >= elems.length) {
			return false;
		}

		for (int i = 0; i < elems.length; i++) {
			if (i > sp && elems[i] != null) {
				return false;
			}
			if (i <= sp && elems[i] == null) {
				return false;
			}
		}

		return true;
	}

}
