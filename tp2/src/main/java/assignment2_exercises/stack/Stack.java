package assignment2_exercises.stack;

/**
 * Abstract class that represents a stack.
 */
public abstract class Stack {
	
    /**
     * Returns the number of elements on the stack.
     */
    public abstract int size();
   
    /**
     * Returns true if the stack is empty, false otherwise.
     */
    public abstract boolean isEmpty();

    /**
     * Returns true if the stack is full, false otherwise.
     */
    public abstract boolean isFull();

    /**
     * Adds an item to the stack.
     */
    public abstract void push(Object o) throws IllegalStateException;
    
    /**
     * Make the stack  empty.
     */
    public abstract void makeEmpty();
       
    /**
     * Removes and returns the element at the top of the stack.
     */
    public abstract Object pop() throws IllegalStateException;

    /**
     * Returns the element at the top of the stack.
     */
    public abstract Object top() throws IllegalStateException;

    
    /**
     * Returns an integer that represents the hash code of the stack
     */
    public abstract int hashCode();

    /**
     * Returns true if the stack is equal to another object, false otherwise.
     */
    public abstract boolean equals(Object obj);

    /**
     * Returns a String representation of the stack.
     */
    public abstract String toString();
}
