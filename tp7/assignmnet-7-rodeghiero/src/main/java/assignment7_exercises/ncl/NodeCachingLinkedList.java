package assignment7_exercises.ncl;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************
Taking (and then modified) from an implementation of NodeCachingList of Juan Pablo Galeotti 
and Marcelo Frias, Relational Formal Methods 
Group, University of Buenos Aires and Buenos Aires Institute of Technology,
Buenos Aires, Argentina.

****************************************************************************/


//package roops.core.objects;


public class NodeCachingLinkedList{

		
	private  LinkedListNode header;
	private int size;

	private  LinkedListNode firstCachedNode;

	/**
	 * The size of the cache.
	 */
	private  int cacheSize;

	/**
	 * The maximum size of the cache.
	 */
	private  int maximumCacheSize;

	public static final int DEFAULT_MAXIMUM_CACHE_SIZE = 20;

	public NodeCachingLinkedList(){
		header = new LinkedListNode();
		header.setValue(null);
		header.setNext(header);
		header.setPrevious(header);
		maximumCacheSize = DEFAULT_MAXIMUM_CACHE_SIZE;
	}
	
	
	public int getCacheSize() {
		return cacheSize;
	}
	
	public int getSize() {
		return size;
	}
	
	/**Gets the element from the list in index position 
	 * @param index of the searched element
	 * @throws IllegalArgumentException if index <0 or index <= size
	 * @return the element in the index position 
	 **/
	public Integer get(int index) {
		if(index >=this.size || index <0)
			throw new IllegalArgumentException("invalid index");
        LinkedListNode node = getNode(index);
        return node.getValue();
    }

    
    /*Adds an element to the list**/
    public void addFirst(Integer o) {
        LinkedListNode newNode = createNode(o);
        addNode(newNode, header.getNext());

    }
	
	
	 /**
     * Gets a node from the cache. If a node is returned, then the value of
     * cacheSize is decreased accordingly. The node that is returned
     * will have null values for next, previous and element.
     *
     * @return a node, or null if there are no nodes in the cache.
     */
    private LinkedListNode getNodeFromCache() {
        if (cacheSize == 0) {
            return null;
        }
        final LinkedListNode cachedNode = firstCachedNode;
        firstCachedNode = cachedNode.getNext();
        cachedNode.setNext(null); 
        cacheSize--;
        return cachedNode;
    }
    
    /**
     * Inserts a new node into the list.
     *
     * @param nodeToInsert  new node to insert
     * @param insertAfterNode  node to insert before
     * @throws NullPointerException if either node is null
     */
    private void addNode(LinkedListNode nodeToInsert, LinkedListNode insertAfterNode) {
    	nodeToInsert.setNext(insertAfterNode);
        nodeToInsert.setPrevious(insertAfterNode.getPrevious());
        insertAfterNode.getPrevious().setNext(nodeToInsert);
        insertAfterNode.setPrevious(nodeToInsert);
        size++;
    }

    
    
    //-----------------------------------------------------------------------
    /**
     * Creates a new node, either by reusing one from the cache or creating
     * a new one.
     *
     * @param value  value of the new node
     * @return the newly created node
     */
    
    private LinkedListNode createNode(Integer value) {
        final LinkedListNode cachedNode = getNodeFromCache();
        if (cachedNode == null) {
        	LinkedListNode n = new LinkedListNode();
        	n.setValue(value);
            return n;
        }
        cachedNode.setValue(value);
        return cachedNode;
    }
    
    
    /**
	 * Checks whether the cache is full.
	 * 
	 * @return true if the cache is full
	 */
	private boolean isCacheFull() {
		return cacheSize >= maximumCacheSize; 
	}

	

	private void addNodeToCache(LinkedListNode node) {
		if (isCacheFull()) {
			// don't cache the node.
			return;
		}       
		// clear the node's contents and add it to the cache.
		LinkedListNode nextCachedNode = firstCachedNode;
		node.setPrevious(null);
		node.setNext(nextCachedNode);
		node.setValue(null);
		firstCachedNode = node;
		cacheSize=cacheSize +1;
	}

	
	/**
	 * Removes the specified node from the list.
	 *
	 * @param node  the node to remove
	 * @throws NullPointerException if node is null
	 */
	private void super_removeNode(LinkedListNode node) {
		node.getPrevious().setNext(node.getNext());
		node.getNext().setPrevious(node.getPrevious());
		size=size-1;
	}

	

	private void removeNode(LinkedListNode node) {
		super_removeNode(node);
		addNodeToCache(node);
	}

	//-----------------------------------------------------------------------

	public Integer removeIndex(int index) {
		
		Integer oldValue= null;
		LinkedListNode node = getNode(index);
		if(node!=null){
			oldValue = node.getValue();
			removeNode(node);
		}	
		return oldValue;
	}

	//-----------------------------------------------------------------------
	private LinkedListNode getNode(int index) {
		// Check the index is within the bounds
		if (index < 0) {
			return null;
		} 
		if (index >= size) {
			return null;
		} 
		// Search the list and get the node
		LinkedListNode node;
		int size_div_2 = size >> 1;
		
		if (index < size_div_2) {
			
			// Search forwards
			node = header.getNext();
			for (int currentIndex = 0; currentIndex < index; currentIndex++) {
				node = node.getNext();
			}
			
		} else {
			
			// Search backwards
			node = header;
			for (int currentIndex = size; currentIndex > index; currentIndex--) {
				node = node.getPrevious();
			}
			
		}
		return node;
	}
	
	
	//-----------------------------------------------------------------------
	
	public String toString(){
		String res="[";
		for(int i=0; i< this.size; i++){
			if(i== this.size-1)
				res= res + this.get(i);
			else
				res= res + this.get(i) + ",";
		}
		res= res + "]";
	    return res;
	}
	
	
	
	   //*************************************************************************
	   //************** From now on repOK()  *************************************
	   //*************************************************************************
	  
	/**
	 * @Invariant 
	 *		( this.header!=null ) &&
	 *		( this.header.next!=null ) &&
	 *		( this.header.previous!=null ) &&
	 *		( this.size==#(this.header.*next @- null)-1 ) &&
	 *		( this.size>=0 ) &&
	 *		( this.cacheSize <= this.maximumCacheSize ) &&
	 *		( this.DEFAULT_MAXIMUM_CACHE_SIZE == 20 ) &&
	 *		( cacheSize == number of nodes in the cachelist) &&
	 *		(for all node m in the cachelist, m.previous==null && m.value==null) &&
	 *		(cachelist is acyclic) &&
	 *		(for all node n in the list, n!=null &&  n.previous!=null && n.previous.next==n &&
	 *				  n.next!=null &&  n.next.previous==n )&&
	 *		(size == (number of nodes in the list-1))
	 */
	    public boolean repOK() {
		 if (header == null) {
			 return false;
		 }
		 if (header.getNext() == null || header.getPrevious() == null) {
			 return false;
		 }
		 if (size < 0) {
			 return false;
		 }
		 if (maximumCacheSize < 0 || cacheSize < 0 || cacheSize > maximumCacheSize) {
			 return false;
		 }
		 if (DEFAULT_MAXIMUM_CACHE_SIZE != 20) {
			 return false;
		 }

		 Set<LinkedListNode> listNodes = new HashSet<LinkedListNode>();
		 LinkedListNode current = header;
		 int listCount = 0;
		 while (true) {
			 if (current == null) {
				 return false;
			 }
			 if (!listNodes.add(current)) {
				 return false;
			 }
			 if (current.getNext() == null || current.getPrevious() == null) {
				 return false;
			 }
			 if (current.getNext().getPrevious() != current) {
				 return false;
			 }
			 if (current.getPrevious().getNext() != current) {
				 return false;
			 }

			 listCount++;
			 current = current.getNext();
			 if (current == header) {
				 break;
			 }
		 }
		 if (size != listCount - 1) {
			 return false;
		 }

		 Set<LinkedListNode> cacheNodes = new HashSet<LinkedListNode>();
		 current = firstCachedNode;
		 int cacheCount = 0;
		 while (current != null) {
			 if (!cacheNodes.add(current)) {
				 return false;
			 }
			 if (listNodes.contains(current)) {
				 return false;
			 }
			 if (current.getPrevious() != null) {
				 return false;
			 }
			 if (current.getValue() != null) {
				 return false;
			 }

			 cacheCount++;
			 current = current.getNext();
		 }
		 if (cacheSize != cacheCount) {
			 return false;
		 }

	        return true;
	    }

	    
	//-----------------------------------------------------------------------

	

}
