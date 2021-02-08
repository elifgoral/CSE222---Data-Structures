import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

	public static void main(String[] args) throws IOException {
			
		Instant start,end;
		Duration timeElapsed;
	
		Logger logger = Logger.getLogger("My log");
		FileHandler fh;
			
		try {
			fh = new FileHandler();
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			
			// 1 for arrayList
			// 2 for linkedlist
			
			SimpleTextEditor textEditor1 = new SimpleTextEditor('a');
			
			System.out.println("----------------------");
			System.out.println("ARRAY LIST - WITH ITERATOR");

			
			System.out.println("Reading bb.txt file and write to the arrayList with iterator...");
			start = Instant.now(); //START
			textEditor1.readIter("bb.txt");
			System.out.println("Now printing the arrayList... ");
			textEditor1.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");

			System.out.println("----------------------");
			
			System.out.println("Reading aa.txt file and write to the arrayList with iterator...");
			start = Instant.now(); //START
			textEditor1.readIter("aa.txt");
			System.out.println("Now printing the arrayList... ");
			textEditor1.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");

			System.out.println("----------------------");
			
			start = Instant.now(); //START
			System.out.println("Add 'ada' to the index -6");
			textEditor1.addIter("ada", -6);
			textEditor1.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");

			System.out.println("----------------------");
			
			start = Instant.now(); //START
			System.out.println("Add 'ela' to the index 12");
			textEditor1.addIter("ela", 12);
			textEditor1.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");

			System.out.println("----------------------");
			
			start = Instant.now(); //START
			System.out.println("Add 'kk' to the index 1");
			textEditor1.addIter("kk", 1);
			textEditor1.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");

			System.out.println("----------------------");
			
			start = Instant.now(); //START
			System.out.println("Lets find the 'nesli' on the arrayList...");
			if(textEditor1.findIter("nesli") != -1)
				System.out.println("nesli is " + textEditor1.findIter("nesli") + "th index");
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");

			System.out.println("----------------------");
			
			start = Instant.now(); //START
			System.out.println("Lets find the 'def' on the arrayList...");
			if(textEditor1.findIter("def") != -1)
				System.out.println("def is " + textEditor1.findIter("def") + "th index");
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");		
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");

			System.out.println("----------------------");
			
			start = Instant.now(); //START
			System.out.println("Now, replace the f with q");
			textEditor1.replaceIter('f', 'q');
			textEditor1.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");

			System.out.println("----------------------");
			
			start = Instant.now(); //START
			System.out.println("Now, replace the x with y");
			textEditor1.replaceIter('x', 'y');
			textEditor1.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");

			System.out.println("----------------------");		
			System.out.println();
			System.out.println("ARRAY LIST - WITHOUT ITERATOR");
			System.out.println();
			System.out.println("----------------------");
			
			System.out.println();
			System.out.println();
			SimpleTextEditor textEditor2 = new SimpleTextEditor('a');
			
			System.out.println("Reading cc.txt file and write to the arrayList without iterator...");
			start = Instant.now(); //START
			textEditor2.readWithoutIter("cc.txt");
			System.out.println("Now printing the arrayList... ");
			textEditor2.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");		

			System.out.println("Lets reading the same file which is aa.txt and write to the arrayList again. But this time without using iterator...");
			System.out.println();
			start = Instant.now(); //START
			textEditor2.readWithoutIter("aa.txt");
			System.out.println("Now printing the arrayList... ");
			textEditor2.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			start = Instant.now(); //START
			System.out.println("Add 'elif' to the index -9");
			textEditor2.addWithoutIter("elif", -9);
			textEditor2.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			start = Instant.now(); //START
			System.out.println("Add 'levo' to the index 36");
			textEditor2.addWithoutIter("levo", 36);
			textEditor2.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			start = Instant.now(); //START
			System.out.println("Add 'nesli' to the index 3");
			textEditor2.addWithoutIter("nesli", 3);
			textEditor2.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			start = Instant.now(); //START
			System.out.println("Lets find the 'eq' on the arrayList...");
			if(textEditor2.findWithoutIter("eq") != -1)
				System.out.println("eq is " + textEditor2.findWithoutIter("eq") + "th index");
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			start = Instant.now(); //START
			System.out.println("Lets find the 'nesli' on the arrayList...");
			if(textEditor2.findWithoutIter("nesli") != -1)
				System.out.println("nesli is " + textEditor2.findWithoutIter("nesli") + "th index");
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			System.out.println("Now, replace the t with q");
			textEditor2.replaceWithoutIter('t', 'q');
			textEditor2.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println("----------------------");

			System.out.println("Now, replace the i with q");
			textEditor2.replaceWithoutIter('i', 'q');
			textEditor2.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
	
			System.out.println();
			System.out.println();
			System.out.println("----------------------");
			System.out.println("LINKED LIST - WITH ITERATOR");
			System.out.println("----------------------");
			System.out.println();
			System.out.println();
			
			
			SimpleTextEditor textEditor3 = new SimpleTextEditor('l');

			
			System.out.println("Reading dd.txt file and write to the linked list with iterator...");
			start = Instant.now(); //START
			textEditor3.readIter("dd.txt");
			System.out.println("Now printing the arrayList... ");
			textEditor3.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			System.out.println("Reading aa.txt file and write to the LinkedList with iterator...");
			
			start = Instant.now(); // START
			textEditor3.readIter("aa.txt");
			System.out.println("Now printing the LinkedList... ");
			textEditor3.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			start = Instant.now(); // START
			System.out.println("Add 'kk' to the index 1");
			textEditor3.addIter("kk", 1);
			textEditor3.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			start = Instant.now(); // START
			System.out.println("Add 'qew' to the index -45");
			textEditor3.addIter("qew", -45);
			textEditor3.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			start = Instant.now(); // START
			System.out.println("Add 'yuý' to the index 123");
			textEditor3.addIter("yuý", 123);
			textEditor3.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			start = Instant.now(); // START
			System.out.println("Lets find the 'def' on the LinkedList...");
			if(textEditor3.findIter("def") != -1)
				System.out.println("def is " + textEditor3.findIter("def") + "th index");
			
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			start = Instant.now(); // START
			System.out.println("Lets find the 'bck' on the LinkedList...");
			if(textEditor3.findIter("bck") != -1)
				System.out.println("bck is " + textEditor3.findIter("bck") + "th index");
			
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			System.out.println("Now, replace the f with q");
			start = Instant.now(); // START
			textEditor3.replaceIter('f', 'q');
			textEditor3.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			System.out.println("Now, replace the x with q");
			start = Instant.now(); // START
			textEditor3.replaceIter('x', 'q');
			textEditor3.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			System.out.println();
			System.out.println();
			System.out.println("----------------------");
			System.out.println("LINKED LIST - WITHOUT ITERATOR");
			System.out.println("----------------------");
			System.out.println();
			System.out.println();
			
			System.out.println("----------------------");

			System.out.println();
			SimpleTextEditor textEditor4 = new SimpleTextEditor('l');
			
			System.out.println("Reading ee.txt file and write to the linked list without iterator...");
			start = Instant.now(); //START
			textEditor4.readIter("ee.txt");
			System.out.println("Now printing the arrayList... ");
			textEditor4.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			System.out.println("Lets reading the same file which is aa.txt and write to the LinkedList again.But this time without using iterator... ");
			start = Instant.now(); // START
			textEditor4.readWithoutIter("aa.txt");
			System.out.println("Now printing the LinkedList... ");
			textEditor4.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			start = Instant.now(); // START
			System.out.println("Add 'elif' to the index 5");
			textEditor4.addWithoutIter("elif", 5);
			textEditor4.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			start = Instant.now(); // START
			System.out.println("Add 'qqq' to the index -78");
			textEditor4.addWithoutIter("qqq", -78);
			textEditor4.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			start = Instant.now(); // START
			System.out.println("Add 'ooo' to the index 64");
			textEditor4.addWithoutIter("ooo", 64);
			textEditor4.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			start = Instant.now(); // START
			System.out.println("Lets find the 'eq' on the LinkedList...");
			if(textEditor4.findWithoutIter("eq") != -1)
				System.out.println("eq is " + textEditor4.findWithoutIter("eq") + "th index");
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			start = Instant.now(); // START
			System.out.println("Lets find the 'cde' on the LinkedList...");
			if(textEditor4.findWithoutIter("cde") != -1)
				System.out.println("eq is " + textEditor4.findWithoutIter("cde") + "th index");
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
			
			System.out.println("----------------------");
			
			start = Instant.now(); // START
			System.out.println("Now, replace the x with q");
			textEditor4.replaceWithoutIter('x', 'q');
			textEditor4.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
		
			System.out.println("----------------------");
			
			start = Instant.now(); // START
			System.out.println("Now, replace the i with q");
			textEditor4.replaceWithoutIter('i', 'q');
			textEditor4.printList();
			end = Instant.now(); //END
			timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			logger.info("Time taken: "+ timeElapsed.toNanos() +" nanoseconds");
			System.out.println();
		
			System.out.println("----------------------");
					
		}
		catch(SecurityException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
			
	}
	

}
