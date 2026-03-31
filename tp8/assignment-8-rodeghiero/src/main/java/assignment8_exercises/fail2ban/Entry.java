package assignment8_exercises.fail2ban;
/**
 *SinglyLinkedList's nodes
 * @author
 */

import java.io.Serializable;

public  class Entry implements Serializable{

	public  static final long serialVersionUID = 1;

	public IP element;

	public Entry next;

	public String toString() {
		return "[" + (element != null ? element.toString() : "null") + "]";
	}
}
