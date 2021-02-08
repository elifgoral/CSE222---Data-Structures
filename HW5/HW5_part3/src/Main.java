
/**
 * @author  Elif Goral
 * 			171044003
 *
 */
public class Main {

	public static void main(String[] args) {
		String treeStr;
		System.out.println("constructing with no parameter constructor.");
		AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();
		treeStr = ageTree.toString();
		System.out.println("Tree:\n" + treeStr);

		System.out.println("add AgeData(10)");
		ageTree.add(new AgeData(10));
		treeStr = ageTree.toString();
		System.out.println("Tree:\n" + treeStr);

		System.out.println("add AgeData(20)");
		ageTree.add(new AgeData(20));
		treeStr = ageTree.toString();
		System.out.println("Tree:\n" + treeStr);

		System.out.println("add AgeData(5)");
		ageTree.add(new AgeData(5));
		treeStr = ageTree.toString();
		System.out.println("Tree:\n" + treeStr);

		System.out.println("add AgeData(15)");
		ageTree.add(new AgeData(15));
		treeStr = ageTree.toString();
		System.out.println("Tree:\n" + treeStr);

		System.out.println("add AgeData(10)");
		ageTree.add(new AgeData(10));
		treeStr = ageTree.toString();
		System.out.println("Tree:\n" + treeStr);		
		
		System.out.println("number of younger than 20 :  "+ ageTree.youngerThan(20));
		System.out.println();
		System.out.println("number of older than 20   :  " + ageTree.olderThan(20));
		System.out.println();

		System.out.println("number of younger than 15 :  "+ ageTree.youngerThan(15));
		System.out.println();
		System.out.println("number of older than 15   :  " + ageTree.olderThan(15));
		System.out.println();
		
		System.out.println("number of younger than 10 :  "+ ageTree.youngerThan(10));
		System.out.println();
		System.out.println("number of older than 10   :  " + ageTree.olderThan(10));
		System.out.println();
		
		System.out.println("number of younger than 5  :  " + ageTree.youngerThan(5));
		System.out.println();
		System.out.println("number of older than 5    :  " + ageTree.olderThan(5));
		System.out.println();
		
		System.out.println("number of younger than 7  :  " + ageTree.youngerThan(7));
		System.out.println();
		System.out.println("number of older than 7    :  " + ageTree.olderThan(7));
		System.out.println();
		
		System.out.println("finding 10....");
		System.out.println(ageTree.find(new AgeData(10)).toString());
		System.out.println();
		
		System.out.println("finding 2....");
		System.out.println(ageTree.find(new AgeData(2)).toString());
		System.out.println();
		
		System.out.println("removing 20...");
		ageTree.remove(new AgeData(20));
		treeStr = ageTree.toString();
		System.out.println("Tree:\n" + treeStr);
		
		System.out.println("removing 1...");
		ageTree.remove(new AgeData(1));
		treeStr = ageTree.toString();
		System.out.println("Tree:\n" + treeStr);
		
		System.out.println("removing 10...");
		ageTree.remove(new AgeData(10));
		treeStr = ageTree.toString();
		System.out.println("Tree:\n" + treeStr);
		
		System.out.println("removing 10...");
		ageTree.remove(new AgeData(10));
		treeStr = ageTree.toString();
		System.out.println("Tree:\n" + treeStr);



	}

}
