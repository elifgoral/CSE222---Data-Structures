import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		LinkedListGraph2D graph = new LinkedListGraph2D(0,true);
		System.out.println("addVertice (123)");
		graph.addVertice(123);
		graph.print();
		
		System.out.println("edges:");
		Iterator<Edge> iter = graph.edgeIterator(0);

		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		System.out.println("edge number: " + graph.getEdgeNum());
		System.out.println("vertex number: " + graph.getVerticeNum());
		System.out.println();

		System.out.println("-----------------------------------------");

		System.out.println("addVertice (456)");
		graph.addVertice(456);
		graph.print();
		
		System.out.println("edges:");
		iter = graph.edgeIterator(0);

		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		System.out.println("edge number: " + graph.getEdgeNum());
		System.out.println("vertex number: " + graph.getVerticeNum());
		System.out.println();
		
		System.out.println("-----------------------------------------");

		System.out.println("addVertice (789)");
		graph.addVertice(789);
		graph.print();
		
		System.out.println("edges:");
		iter = graph.edgeIterator(0);

		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		System.out.println("edge number: " + graph.getEdgeNum());
		System.out.println("vertex number: " + graph.getVerticeNum());
		System.out.println();
		
		System.out.println("-----------------------------------------");

		System.out.println("addEdge (123,456)");
		graph.addEdge(123, 456);
		graph.print();
		
		System.out.println("edges:");
		iter = graph.edgeIterator(0);

		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		System.out.println("edge number: " + graph.getEdgeNum());
		System.out.println("vertex number: " + graph.getVerticeNum());
		System.out.println();
	
		System.out.println("-----------------------------------------");

		System.out.println("addEdge (789,789)");
		graph.addEdge(789, 789);
		graph.print();
		
		System.out.println("edges:");
		iter = graph.edgeIterator(0);

		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		System.out.println("edge number: " + graph.getEdgeNum());
		System.out.println("vertex number: " + graph.getVerticeNum());
		System.out.println();
	
		System.out.println("-----------------------------------------");

		System.out.println("addEdge (123,123)");
		graph.addEdge(123, 123);
		graph.print();
		
		System.out.println("edges:");
		iter = graph.edgeIterator(0);

		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		System.out.println("edge number: " + graph.getEdgeNum());
		System.out.println("vertex number: " + graph.getVerticeNum());
		System.out.println();
		
		System.out.println("-----------------------------------------");

		System.out.println("addEdge (789,123)");
		graph.addEdge(789, 123);
		graph.print();
		
		System.out.println("edges:");
		iter = graph.edgeIterator(0);

		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		System.out.println("edge number: " + graph.getEdgeNum());
		System.out.println("vertex number: " + graph.getVerticeNum());
		System.out.println();
		
		System.out.println("-----------------------------------------");

		System.out.println("removeEdge (789,123)");
		graph.removeEdge(789, 123);
		graph.print();
		
		System.out.println("edges:");
		iter = graph.edgeIterator(0);

		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		System.out.println("edge number: " + graph.getEdgeNum());
		System.out.println("vertex number: " + graph.getVerticeNum());
		System.out.println();
				
		System.out.println("-----------------------------------------");

		System.out.println("insert (456,456)");
		graph.insert(new Edge(456, 456));
		graph.print();
		
		System.out.println("edges:");
		iter = graph.edgeIterator(0);

		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		System.out.println("edge number: " + graph.getEdgeNum());
		System.out.println("vertex number: " + graph.getVerticeNum());
		System.out.println();
		
		
		System.out.println("-----------------------------------------");

		System.out.println("isEdge(456,456) -> " + graph.isEdge(456,456));
		System.out.println("source     :" + graph.getEdge(456, 456).getSource());
		System.out.println("destination:" + graph.getEdge(456, 456).getDest());
		System.out.println();

		System.out.println("-----------------------------------------");	
		
		System.out.println("isEdge(789,123) -> " + graph.isEdge(789,123));
		System.out.println("source     :" + graph.getEdge(789, 123).getSource());
		System.out.println("destination:" + graph.getEdge(789, 123).getDest());
		System.out.println();
				
		System.out.println("-----------------------------------------");

		System.out.println("remove(Edge(123,456))");
		graph.remove(new Edge(123,456));
		graph.print();
		
		System.out.println("edges:");
		iter = graph.edgeIterator(0);

		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		System.out.println("edge number: " + graph.getEdgeNum());
		System.out.println("vertex number: " + graph.getVerticeNum());
		System.out.println();
		
		System.out.println("-----------------------------------------");

		System.out.println("removeVertice(456)");
		graph.removeVertice(456);
		graph.print();
		
		System.out.println("edges:");
		iter = graph.edgeIterator(0);

		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		System.out.println("edge number: " + graph.getEdgeNum());
		System.out.println("vertex number: " + graph.getVerticeNum());
		System.out.println();

		System.out.println("-----------------------------------------");
		
		System.out.println("removeVertice(123)");
		graph.removeVertice(123);
		graph.print();

		System.out.println("edges:");
		iter = graph.edgeIterator(0);

		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		System.out.println("edge number: " + graph.getEdgeNum());
		System.out.println("vertex number: " + graph.getVerticeNum());
		System.out.println();
						
		System.out.println("-----------------------------------------");
		
		System.out.println("removeVertice(789)");
		graph.removeVertice(789);
		graph.print();

		System.out.println("edges:");
		iter = graph.edgeIterator(0);

		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		System.out.println("edge number: " + graph.getEdgeNum());
		System.out.println("vertex number: " + graph.getVerticeNum());
		System.out.println();
		

		

		
	}

}
