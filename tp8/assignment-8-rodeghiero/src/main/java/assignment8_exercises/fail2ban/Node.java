package assignment8_exercises.fail2ban;

import java.io.Serializable;


/**
 *StrictlySortedSinglyLinkedList's nodes
 *@author
 */

public  class Node implements Serializable{

	public  static final long serialVersionUID = 1; 
	public IPBan element;

	public Node next;

	public String toString() {
		return "[" + (element != null ? element.toString() : "null") + "]";
	}
}
