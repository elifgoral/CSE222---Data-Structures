import java.util.Stack;

public class Main {

	public static void main(String[] args) {
	
		Recursive recursive = new Recursive();
		
		System.out.println("Question 1: Reversing a string.");
		System.out.println();

		 String input1 =  "this function writes the sentence in reverse";
		 System.out.println("String 1:  " + input1);
		 System.out.println("Reverse : " + recursive.reverseString(input1,""));
		 
		 System.out.println();

		 String input2 =  "Elif Levent Neslihan Abdullah";
		 System.out.println("String 1:  " + input2);
		 System.out.println("Reverse : " + recursive.reverseString(input2,""));
		
		System.out.println();

		 String input3 =  "";
		 System.out.println("String 1:  " + input3);
		 System.out.println("Reverse : " + recursive.reverseString(input3,""));
		
		System.out.println();
		System.out.println("--------------------------------------------------------------");

		System.out.println("Question 2: Determining whether a word is elfish or not \n A word is considered elfish if it contains the letters: e, l, and f in it, in any order");
		System.out.println();

		System.out.println("String : unfriendly -> "+ recursive.isElfish("unfriendly",0,0,0));
		System.out.println("String : whiteleaf -> "+ recursive.isElfish("whiteleaf",0,0,0));
		System.out.println("String : tasteful -> "+ recursive.isElfish("tasteful",0,0,0));
		System.out.println("String : waffles -> "+ recursive.isElfish("waffles",0,0,0));
		System.out.println("String : elif -> "+ recursive.isElfish("elif",0,0,0));
		System.out.println("String : levent -> "+ recursive.isElfish("levent",0,0,0));
		System.out.println("String : asdf -> "+ recursive.isElfish("asdf",0,0,0));
		System.out.println("String : qwert -> "+ recursive.isElfish("qwert",0,0,0));

		System.out.println();
		System.out.println("--------------------------------------------------------------");

		System.out.println("Question 3: Sorting an array of elements using selection sort algorithm.");
		System.out.println();
		int array1[] ={ 3, 5, 8, 4, 1, 9, -2};
		int size = array1.length;
		System.out.println("array1 which will be sorted:");
		recursive.printArray(array1, size, 0);
		System.out.println("Selection sort algorithm started...");
		int sortedArray1[] = recursive.selectionSort(array1, 0 , size,99999);
		System.out.println("selection sorted array1: ");
		recursive.printArray(sortedArray1, size, 0);

		System.out.println();

		int array2[] ={ 1,8,221,95,-9,12,65};
		size = array1.length;
		System.out.println("array2 which will be sorted:");
		recursive.printArray(array2, size, 0);
		System.out.println("Selection sort algorithm started...");
		int sortedArray2[] = recursive.selectionSort(array2, 0 , size,99999);
		System.out.println("selection sorted array 2: ");
		recursive.printArray(sortedArray2, size, 0);
		 
		System.out.println();
		
		System.out.println("--------------------------------------------------------------");
				
		System.out.println("Question 4: Evaluating a Prefix expression");
		String exp = "- / * 20 * 50 + 3 6 300 2";
	    System.out.println();
	    Stack<Integer> stack2 = new Stack<Integer>();

	    System.out.println("Prefix Expression: " + exp);
	    System.out.println("Evaluation: " + recursive.evaluatePrefix(exp,exp.length()-1,0,stack2,0,false));
		
		String exp2 = "+ * / 135 * 5 + 3 6 120 2";
	    System.out.println();
	    Stack<Integer> stack5 = new Stack<Integer>();

	    System.out.println("Prefix Expression: " + exp2);
	    System.out.println("Evaluation: " + recursive.evaluatePrefix(exp2,exp2.length()-1,0,stack5,0,false));
	    
	    
	    System.out.println();
	    System.out.println();
		System.out.println("--------------------------------------------------------------");

		System.out.println("Question 5: Evaluating a Postfix expression."); 
		
		String expPostfix = "100 200 + 2 / 5 * 7 +"; 
	    System.out.println("postfix expression: " +expPostfix);
	    Stack<Integer> stack1 = new Stack<Integer>();
	    System.out.println(recursive.evaluatePostfix(expPostfix,0,expPostfix.length(),0,stack1,0)); 
	    System.out.println();
	     
	
	    String expPostfix2 = "40 20 - 2 / 4 * 5 -"; 
	    System.out.println("postfix expression: " +expPostfix2);
	    Stack<Integer> stack3 = new Stack<Integer>();
	    System.out.println(recursive.evaluatePostfix(expPostfix2,0,expPostfix2.length(),0,stack3,0)); 
	    System.out.println();
	    
		System.out.println("--------------------------------------------------------------");

	    System.out.println("Question 6: Printing the elements of an array different type.");

		System.out.println();

	 	int[][] array3 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
	 	System.out.println("Our array is:");	 	
	 	int row = array3.length;
		int col = array3[0].length;
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				System.out.printf(array3[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("sorted way:");
		recursive.printSorted(array3, 0, row-1, 0, col-1 ,0,0,row*col, 0);

		int[][] array4 = {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30}};
		System.out.println();
		System.out.println();

		System.out.println("Our array is:");	 	
	 	row = array4.length;
		col = array4[0].length;
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				System.out.printf(array4[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("sorted way:");
		recursive.printSorted(array4, 0, row-1, 0, col-1 ,0,0,row*col, 0);
		
	    System.out.println();
	    System.out.println();
		System.out.println("--------------------------------------------------------------");
	}



}
