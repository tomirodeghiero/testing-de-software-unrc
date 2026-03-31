package assignment8_exercises.fail2ban;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Class  StrictlySortedSinglyLinkedList defines Strictly Sorted, Singly linked List 
 * @author 
 */
public class StrictlySortedSinglyLinkedList implements Serializable{
	
    public  static final long serialVersionUID = 1; 

    public Node header;
    public int size = 0;
   
    public StrictlySortedSinglyLinkedList(){
    	header = new Node();
    	size = 0;
   }	

    /**
     * This method checks whether a given Integer value belongs to the current list.
     * @param value The element whose presence in this list is to be tested.
     * @return true iff value is in the current list.
     */
    public boolean contains(IPBan value){
    	if (value == null || value.getExpires() == null) {
    		return false;
    	}
    	Node current = header.next;	
    	while(current!=null && current.element != null && current.element.getExpires() != null
    			&& current.element.getExpires().compareTo(value.getExpires()) <= 0){
    			if(current.element.getExpires().equals(value.getExpires()))
    				return  true;
    			current = current.next;
       	} 
    	return false;
    	
    }
    
    /**
     * This method checks whether a given Integer value belongs to the current list.
     * @param value The element whose presence in this list is to be tested.
     * @return true iff value is in the current list.
     */
    public boolean containsIP(IP value){
    	if (value == null) {
    		return false;
    	}
    	Node current = header.next;	
    	while(current!=null){
    			if(current.element != null && current.element.getIp() != null && current.element.getIp().equals(value))
    				return  true;
    			current = current.next;
       	} 
    	return false;
    	
    }
    
    /**
     * This method removes a given IP iff it belongs to the current list.
     */
    public boolean removeFromIP(IP value){
    	if (value == null || header.next == null) return false;
    	
    	Node current = header.next;	
    	Node prev = header;
    	while(current!=null){
    			if(current.element != null && current.element.getIp() != null && current.element.getIp().equals(value)){
    				//remove ip
    				prev.next = current.next;
    				// Remove size-- for a hard to find bug!
    				size--;
    				return true;
    			}
    			current = current.next;
    			prev = prev.next;
       	} 
    	return false;
    	
    }

    public boolean add(IPBan value){
		if (value == null || value.getExpires() == null || value.getIp() == null) {
			return false;
		}
		Node current = header.next;	
		Node previous = header;
			
	    	while(current!=null && current.element != null && current.element.getExpires() != null
	    			&& current.element.getExpires() < value.getExpires()){
			previous = current;		
			current = current.next;
	       	}
		Node n = new Node();
		n.element =  value;
		if (current==null || current.element == null || current.element.getExpires() == null){
			previous.next = n;
			n.next = current;
			size++;
			return true;
		} 
		if(current.element != null && current.element.getExpires().equals(value.getExpires()))
	    		return  false;
	
		if(current.element != null && current.element.getExpires() > value.getExpires()){
			previous.next = n;
			n.next = current;
			size++;
	  		return  true;
	    	}
		return true;
    		
    }

     public IPBan get(int index){
    	Node current = header.next;
    	int i = 0;
    	while(current!=null && i< index){
    		current = current .next;
    		i++;
    	}
    	if(current!=null){
    		return current.element;
       	}
    	return null;
    } 

    
    public int getSize(){
    	return size;
    }    
  	
    
    /** ------------------------ repOK and related routines---------------------------*/

   /**
     * RepOk checks whether the list satisfies its representation invariant. 
     * @return True iff the current list satisfies its representation invariant
     */
    public boolean repOK() {
    	if (header == null) {
    		return false;
    	}
    	if (size < 0) {
    		return false;
    	}

    	Set<Node> visitedNodes = new HashSet<Node>();
    	Set<IP> visitedIps = new HashSet<IP>();
    	Long previousExpires = null;
    	int realSize = 0;

    	for (Node current = header.next; current != null; current = current.next) {
    		if (!visitedNodes.add(current)) {
    			return false;
    		}
    		if (current.element == null) {
    			return false;
    		}
    		if (current.element.getIp() == null || current.element.getExpires() == null) {
    			return false;
    		}
    		if (!visitedIps.add(current.element.getIp())) {
    			return false;
    		}
    		if (previousExpires != null && current.element.getExpires().compareTo(previousExpires) <= 0) {
    			return false;
    		}
    		previousExpires = current.element.getExpires();
    		realSize++;
    	}

    	return realSize == size;
    }
   
 
    public boolean greaterThan(Long l) {
    	for (Node current = header.next; current != null; current = current.next) {
    		if (current.element.getExpires().compareTo(l) <= 0)
    			return false;
    	}
    	return true;
    }
    
    
    /**
	 * Checks whether or not the current list has not repeated elements.
	 * @return true iff all the elements in the list are different each other.
	 */
	public boolean noReps(){
		if(!isEmpty()){
			Set<IP> visited = new java.util.HashSet<IP>();
			for (Node current = header.next; current != null; current = current.next) {
				if(!visited.add(current.element.getIp())){
					return false;
				}
			}   	
		}	
		return true;
	}
	
	
	public HashSet<IP> toSet(){
		HashSet<IP> ipSet = new java.util.HashSet<IP>();
		for (Node current = header.next; current != null; current = current.next) {
			ipSet.add(current.element.getIp());
		}
		return ipSet;
	} 
    
    
    

    /**
 	 * Checks whether or not the current list has not elements.
     * @return true iff the current list is empty, false otherwise.
     */
    
    public boolean isEmpty(){
    	return header.next== null;
    }

    public String toString() {
        String res = "{";
        if (header != null) {
            Node cur = header.next;
            while (cur != null && cur != header) {
                res += cur.toString();
                cur = cur.next;
            }
        }
        return res + "}";
    }
 
}//End Class
