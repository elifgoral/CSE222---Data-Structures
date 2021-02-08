import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListGraph2D  extends AbstractGraph{

	public Node firstRow;
	public Node firstCol;
	public Node lastRow;
	public Node lastCol;
	public int dimension;
	public int verticeNum;
	public int edgeNum;
	public List < Edge > edges;

	public LinkedListGraph2D(int data,boolean directed) {
		super(0,directed);
		firstRow = new Node(data);
		firstCol = firstRow;
		lastRow = firstRow;
		lastCol = firstRow;
		dimension = 0;	
		verticeNum = 0;
		edgeNum = 0;
	    edges = new LinkedList < Edge > ();
	 }
		
	/**
	 * That method add an edge to the two dimensional linked list.
	 */
	@Override
	public void insert(Edge edge) {
		addEdge(edge.getSource(),edge.getDest());	
	}

	/**
	 * That method remove an edge from the two dimensional linked list.
	 * @param edge edge which will be remove.
	 */
	public void remove(Edge edge) {
		removeEdge(edge.getSource(),edge.getDest());
	}
	
	/**
	 * That method checks the node is edge or not
	 */
	@Override
	public boolean isEdge(int source, int dest) {
	    for (Edge edge : edges) {
	    	if(edge.getSource()== source && edge.getDest() == dest)
	    		return true;
	    }
	    return false;
	}

	/**
	 * That method returns the edge.
	 */
	@Override
	public Edge getEdge(int source, int dest) {
		Edge target =  new Edge(source, dest, Double.POSITIVE_INFINITY);
		for (Edge edge : edges) {
		   if (edge.equals(target))
		      return edge; 
		}
		return target; 
	}

	/**
	 * That method returns the edge list's iterator version.
	 */
	@Override
	public Iterator<Edge> edgeIterator(int source) {
		return edges.iterator();
	}
	
	/**
	 * That method returns the vertice number.
	 * @return vertice number
	 */
	public int getVerticeNum() {
		return verticeNum;
	}
	
	/**
	 * That method returns the edge number.
	 * @return edge number.
	 */
	public int getEdgeNum() {
		return edgeNum;
	}
	
	/**
	 * That method prints the two dimensional linked list
	 */
	public void print() {
		Node col = firstCol; 
		Node row = firstRow; 
      
		System.out.println();
        while (row != null) {       
        	col = row;       
            while (col!=null) { 
            	if(col.data == 0)
            		System.out.printf("\t");
              	else
            		System.out.printf(col.data+"\t"); 
                col = col.cnext; 
            }      
            System.out.print("\n"); 
            row = row.rnext; 
        } 
	}
	
	/**
	 * That method add the edge to the two dimensional linked list.
	 * Firstly I find the address of edge. After that I change the node's data value to the 1. add to the edge list and increase the number of edge.
	 * @param src source vertex
	 * @param dest destination vertex
	 */
	public void addEdge(int src , int dest) {
		
		Node tempRow = firstRow;
		Node tempCol = firstCol;
		int rowCounter = 0;
		int colCounter = 0;
		while(tempRow.getData() != src) {
			tempRow = tempRow.rnext;
			rowCounter++;
		}
		while(tempCol.getData() != dest) {
			tempCol = tempCol.rnext;
			colCounter++;
		}		
		Node temp = firstRow;

		for(int i = 0 ; i < rowCounter ; i++) {
			firstRow = firstRow.rnext;
		}
		for(int j = 0 ; j < colCounter ; j++) {
			firstRow = firstRow.cnext;
		}	
			
		Edge newEdge = new Edge(tempRow.getData(),tempCol.getData());
		edges.add(newEdge);
		firstRow.setData(1);
		firstRow = temp;	
		edgeNum++;
	}
	
	/**
	 * That method remove a edge from the two dimensional linked list.
	 * Firstly I find the address of edge. After that I change the node's data value to the 0. remove from the edge list and decrease the number of edge.
	 * @param src source vertex
	 * @param dest destination vertex
	 */
	public void removeEdge(int src , int dest){
		
		Node tempRow = firstRow;
		Node tempCol = firstCol;
		int rowCounter = 0;
		int colCounter = 0;
		while(tempRow.getData() != src) {
			tempRow = tempRow.rnext;
			rowCounter++;
		}
		while(tempCol.getData() != dest) {
			tempCol = tempCol.rnext;
			colCounter++;
		}		
		Node temp = firstRow;

		for(int i = 0 ; i < rowCounter ; i++) {
			firstRow = firstRow.rnext;
		}
		for(int j = 0 ; j < colCounter ; j++) {
			firstRow = firstRow.cnext;
		}

		firstRow.setData(0);
		firstRow = temp;			
		edgeNum--;
		Edge newEdge = new Edge(tempRow.getData(),tempCol.getData());
		edges.remove(newEdge);
		
	}
		
	/**
	 * That method add a vertex to two dimensional linked list.
	 * Firstly I add vertex to the end of the vertices. Then I create nodes between the all vertices. If there is an edge,I do not touch that node. 
	 * But the node is not edge, I give 0 value to the node. which means node is not edge.
	 * @param data vertex's data.
	 */
	public void addVertice(int data) {
		Node row = new Node(data);
		row.rprev = lastRow;
		lastRow.rnext = row;
		lastRow = row;
		
		Node col = new Node(data);
		col.cprev = lastCol;
		lastCol.cnext = col;
		lastCol = col;	
		dimension++;	
		
		Node tempRow = firstRow;
		Node tempCol = firstCol;
		
		int counter = 0;
		while (firstRow != null) {       
			firstCol = firstRow;
	        	while (counter < dimension) { 
	        		if(firstCol.cnext != null && firstCol.cnext.data != 0) {
		        		firstCol = firstCol.cnext; 
		        		counter++;
	        		}
	        		else {
	        			Node temp = new Node(0);
	        			firstCol.cnext = temp;
	        			firstCol = firstCol.cnext; 
		        		counter++;	
	        		}
	    		
	    	 	} 
	       	 	counter = 0;
	        	firstRow = firstRow.rnext; 
	    	} 
		firstRow = tempRow;
		firstCol = tempCol;
		verticeNum++;
	}
	
	
	/**
	 * Firstly remove the edges from the row which will be remove, remove from the edge list and decrease the number of edge.
	 * Then remove the row. After that, I do same process for column.
	 * Firstly remove the edges from the column which will be remove, remove from the edge list and decrease the number of edge.
	 * Then remove the column. 
	 * That method remove the vertex from two dimensional linked list.
	 * @param data vertex's data.
	 */
	public void removeVertice(int data) {
		Node tempCol = firstCol;
		Node tempRow = firstRow;
			
		int counter = 0,temp = 0;
		Node buffer;
		while(firstRow.rnext != null) {
			if(firstRow.rnext.getData() == data) {
				//remove the edges from the row which will be remove
				buffer = firstRow.rnext;
				while(buffer != null) {
					if(buffer.getData() == 1) {
						Edge newEdge = new Edge(firstRow.rnext.getData(),firstCol.getData());
						edges.remove(newEdge);
						edgeNum--;
					}
					buffer = buffer.cnext;
					firstCol = firstCol.cnext;
				}
				if(firstRow.rnext.rnext == null) {
					firstRow.rnext = null;
					temp = counter;
					break;
				}
				else {
					firstRow.rnext = firstRow.rnext.rnext;
					temp = counter;
				}
			}
			firstRow = firstRow.rnext;	
			counter++;
		}
		firstRow = tempRow;
		temp++;
		
		while(firstRow != null) {
			firstCol = firstRow;
			for(int i = 0 ; i < temp - 1; i++) {
				firstCol = firstCol.cnext;
			}
			//remove the edges from the column which will be remove
			buffer = firstCol.cnext;
			while(buffer != null) {
				if(buffer.getData() == 1) {
					Edge newEdge = new Edge(firstRow.getData(),firstCol.getData());
					edges.remove(newEdge);
					edgeNum--;
				}
				buffer = buffer.rnext;
			}
		
			firstCol.cnext = firstCol.cnext.cnext;
			firstRow = firstRow.rnext;
		}
		firstRow = tempRow;
		firstCol = tempCol;
		dimension--;
		verticeNum--;
	}
	
	
	protected static class Node {
		protected int data;
		protected Node rnext;
		protected Node rprev;
		protected Node cnext;
		protected Node cprev;
			
		protected Node(int dataItem) {
			rnext = null;
			rprev = null;
			cnext = null;
			cprev = null;
			data = dataItem;
		}
	
		protected int getData() {
			return data;
		}
		
		protected void setData(int dataItem) {
			data = dataItem;
		}
			
		protected boolean isVertex() {
			if(data != 0 && data != 1)
				return true;
			return false;
		}	
		
		
	}
	
}

