
/**
 * @author  Elif Goral
 * 			171044003
 *
 */
public class Main {

	public static void main(String[] args) {
		String heapStr;
		MaxHeap<AgeData> heap = new MaxHeap<AgeData>();
		
		System.out.println("Add AgeData(10)");
		heap.add(new AgeData(10));
		heapStr = heap.toString();
		System.out.println("heap: \n"+ heapStr);
		
		System.out.println("Add AgeData(5)");
		heap.add(new AgeData(5));
		heapStr = heap.toString();
		System.out.println("heap: \n"+ heapStr);
		
		System.out.println("Add AgeData(70)");
		heap.add(new AgeData(70));
		heapStr = heap.toString();
		System.out.println("heap: \n"+ heapStr);
		
		System.out.println("Add AgeData(10)");
		heap.add(new AgeData(10));
		heapStr = heap.toString();
		System.out.println("heap: \n"+ heapStr);
		
		System.out.println("Add AgeData(50)");
		heap.add(new AgeData(50));
		heapStr = heap.toString();
		System.out.println("heap: \n"+ heapStr);
		
		System.out.println("Add AgeData(5)");
		heap.add(new AgeData(5));
		heapStr = heap.toString();
		System.out.println("heap: \n"+ heapStr);
		
		System.out.println("Add AgeData(15)");
		heap.add(new AgeData(15));
		heapStr = heap.toString();
		System.out.println("heap: \n"+ heapStr);
		
		System.out.println("find AgeData(10)");
		System.out.println(heap.find(new AgeData(10)).toString());
		System.out.println();
		
		System.out.println("find AgeData(70)");
		System.out.println(heap.find(new AgeData(70)).toString());
		System.out.println();
		
		System.out.println("find AgeData(23)");
		System.out.println(heap.find(new AgeData(23)).toString());
		System.out.println();
		
		System.out.println("number of younger than 10	:  " + heap.youngerThan(10));
		System.out.println("number of older than 10		:  " + heap.olderThan(10));
		System.out.println();

		System.out.println("number of younger than 5	:  " + heap.youngerThan(5));
		System.out.println("number of older than 5		:  " + heap.olderThan(5));
		System.out.println();
		
		System.out.println("number of younger than 70	:  " + heap.youngerThan(70));
		System.out.println("number of older than 70		:  " + heap.olderThan(70));
		System.out.println();
		
		System.out.println("number of younger than 50	:  " + heap.youngerThan(50));
		System.out.println("number of older than 50		:  " + heap.olderThan(50));
		System.out.println();

		System.out.println("number of younger than 15	:  " + heap.youngerThan(15));
		System.out.println("number of older than 15		:  " + heap.olderThan(15));
		System.out.println();
		
		System.out.println("number of younger than 23	:  " + heap.youngerThan(23));
		System.out.println("number of older than 23		:  " + heap.olderThan(23));
		System.out.println();

		System.out.println("removing 10");
		heap.remove(new AgeData(10));
		heapStr = heap.toString();
		System.out.println("heap: \n"+ heapStr);
		
		System.out.println("removing 5");
		heap.remove(new AgeData(5));
		heapStr = heap.toString();
		System.out.println("heap: \n"+ heapStr);
		
		System.out.println("removing 6");
		heap.remove(new AgeData(6));
		heapStr = heap.toString();
		System.out.println("heap: \n"+ heapStr);

		System.out.println("removing 5");
		heap.remove(new AgeData(5));
		heapStr = heap.toString();
		System.out.println("heap: \n"+ heapStr);
		
	}

}
