import java.util.Stack;

public class Recursive {

	/**
	 * That method helper of reverseString function. That method adds the words to the output with decreasing index. When the index is 0, returns the output.
	 * @param buffer words of the input string 
	 * @param index which word as a index we are adding to output on word list.
	 * @param output reverse of input
	 * @return output
	 */
	public String helperReversing(String[] buffer,int index,String output) {
		if(index == 0) {
			output += buffer[index] + " ";
			return output;
		}
		output += buffer[index] + " ";
		return helperReversing(buffer,index-1,output);
	}
	
	/**
	 * That method throw the words to the buffer array. If the string is empty, I throw an exception for that.
	 * @param input string which will be reverse
	 * @param output string which is reversed.
	 * @return output
	 */
	public String reverseString(String input,String output) {
	     	try {
	     		if(input == "")
	   	    	 throw new Exception("String is empty");
	     		
	   		  String[] buffer = input.split(" ");
	   	      output = helperReversing(buffer,buffer.length-1,output);
	   	      return output;	
	     	}
	     	catch(Exception e) {
	     		System.out.println(e);
	     	}
			return output;	
	}		

	/**
	 * That method determine whether a word is elfish or not. A word is considered elfish if it contains the letters: e, l, and f in it, in any order. 
	 * @param str str is the input string
	 * @param eNum number of e letter
	 * @param lNum number of l letter
	 * @param fNum number of f letter
	 * @return true if the all leters exist,otherwise returns false.
	 */
	public boolean isElfish(String str,int eNum,int lNum,int fNum) {
		try {
			if(str == null || str.equals("")) {
				if(eNum != 0 && lNum != 0 && fNum != 0)
					return true;			
				else 
					return false;
			}
			else if(str.charAt(0) == 'e' || str.charAt(0) == 'E')
				return isElfish(str.substring(1),eNum+1,lNum,fNum);

			else if(str.charAt(0) == 'l' || str.charAt(0) == 'L' )
				return isElfish(str.substring(1),eNum,lNum+1,fNum);
			
			else if(str.charAt(0) == 'f' || str.charAt(0) == 'F') 
				return isElfish(str.substring(1),eNum,lNum,fNum+1);
				
			return isElfish(str.substring(1),eNum,lNum,fNum);	
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	/**
	 * That method prints the array
	 * @param array array will be printed
	 * @param size array's size.
	 * @param index array's current index.
	 */
	public void printArray(int array[],int size,int index) {
		if(index < size) {
			System.out.printf(array[index] + " ");			
			printArray(array,size,index+1);
		}
		if(index == size)
			System.out.println();
		return;
	}
	
	/**
	 * That method find the minimum index of the given array.
	 * @param array array which will be checked
	 * @param index index which we control at that time.
	 * @param size array's size.
	 * @param minValue minValue is the criterion of greatness
	 * @param minIndex index which has minimum value.
	 * @return minIndex index which has minimum value.
	 */
	public int findMinIndex(int array[],int index,int size,int minValue,int minIndex) {
		if(index == size)
			return minIndex;
		
		if(array[index] < minValue) {
			minIndex = index;
			minValue = array[index];
			return findMinIndex(array,index+1,size,minValue,minIndex);
		}
		return findMinIndex(array,index+1,size,minValue,minIndex);	
	}
	
	
	/**
	 * That method sort the arrays with a selection sort algorithm.
	 * Selection sort is an algorithm that selects the smallest element from an unsorted list in each iteration and places that element at the beginning of the unsorted list.
	 * @param array array which will be sorted with a selection sort algorithm.
	 * @param index array's current index.
	 * @param size array's size.
	 * @param minValue minValue is the minimum value of array  when we look after our current status.
	 * @return array which will be sorted.
	 */
	public int[] selectionSort(int array[],int index,int size,int minValue) {
		int minIndex = 0,temp;
		if(index == size-1)
			return array;
		else {
			minIndex = findMinIndex(array,index+1,size,minValue,minIndex);
			if(array[index] > array[minIndex]) {
				temp = array[index];
				array[index] = array[minIndex];
				array[minIndex] = temp;
				printArray(array,size,0);
				return selectionSort(array,index+1,size,minValue);
			}
			
			printArray(array,size,0);
			return selectionSort(array,index+1,size,minValue);
		}		
	}
	
	
	/**
	 * That method checks the character is digit or not. 
	 * @param c character which will be check
	 * @return if character is digit returns true,otherwise false.
	 */
	public boolean isDigit(char c) {
		if (c >= 48 && c <= 57) {
			System.out.println(c);
            return true; 
		}
	    else
	        return false;
	}
	
	/**
	 * That method checks the character is oeprator or not. 
	 * @param c character which will be check
	 * @return if character is operator returns true,otherwise false
	 */
	public boolean isOperator(char c) {
		if(c == '+' || c == '-' || c == '/' || c == '*')
			return true;
		return false;
	}
	
	/**
	 * That method evaluate the prefix expression
	 * @param expression which will be evaluate expression version
	 * @param index expression's current character's index
	 * @param temp it keep numbers which has more than one digit.
	 * @param stack stack
	 * @param digit digit number of number
	 * @param isPush that parameter decides push or not push. if the space comes after the operator,returns false, if space comes after the number returns true.
	 * @return result.
	 */
	public int evaluatePrefix(String expression,int index,int temp,Stack<Integer> stack,int digit,boolean isPush) {
		 if(index < 0)
	           return stack.pop();  
		        
	     else {
		      char c = expression.charAt(index); 
		             
		       if(c == ' ') { 
		          if(isPush) {
		        	  System.out.println("temp:"+temp);
			          stack.push(temp); 
			          System.out.println(stack);
			          return evaluatePrefix(expression,index-1,0,stack,0,false);	
		           }
		           else
		        	   return evaluatePrefix(expression,index-1,0,stack,0,false);	
		       	}  
		                 
		       else if(isDigit(c)) 
		       { 
		           temp += (int) (Math.pow(10, digit) * (int)(c - '0'));
		           return evaluatePrefix(expression,index-1,temp,stack,digit+1,true);	
		        }
		        else if(isOperator(c)) {   
		            	  
		        	int val1 = stack.pop(); 
		            int val2 = stack.pop(); 
		            int result;
		             
		            if(c == '+') {
		                result = val2+val1;
		                System.out.println(val1 + " + " + val2 + " = " + result);
		                stack.push(result);
			            System.out.println(stack);
		                return evaluatePrefix(expression,index-1,0,stack,digit,false);	
		             }
		             else if(c == '-') {
		                result = val1-val2;
		                stack.push(result); 
			            System.out.println(stack);
		                System.out.println(val1 + " - " + val2 + " = " + result);
		                return evaluatePrefix(expression,index-1,0,stack,digit,false);	
		             }
		             else if(c == '*') {
		                result = val2*val1;
		                stack.push(result);
			            System.out.println(stack);
		                System.out.println(val1 + " * " + val2 + " = " + result);
		                return evaluatePrefix(expression,index-1,0,stack,digit,false);	
		             }
		             else if(c == '/') {
		                 result = val1/val2;
		                 stack.push(result); 
			             System.out.println(stack);
		                 System.out.println(val1 + " / " + val2 + " = " + result);
		                 return evaluatePrefix(expression,index-1,0,stack,digit,false);	
		            }
		         }
		     }         
		    return evaluatePrefix(expression,index-1,0,stack,digit,false);	 
		}
	
	/**
	 * That method prints different way.
	 * @param array array which will be sorted
	 * @param startRow top row of array
	 * @param endRow bottom row of array
	 * @param startCol leftmost column of array
	 * @param endCol rightmost column of array
	 * @param indexRow current Row index
	 * @param indexCol current column index
	 * @param totalSize array' size.
	 * @param counter that parameter checks the all elements of array is printed or not.
	 */
	public void printSorted(int[][] array,int startRow,int endRow,int startCol,int endCol,int indexRow,int indexCol,int totalSize,int counter) {
		if(counter != totalSize) {
			if(indexRow == startRow && indexCol != endCol) { //top row and it can continue to right side.
				System.out.printf(array[indexRow][indexCol] + " ");
				printSorted(array,startRow,endRow,startCol,endCol,indexRow,indexCol+1,totalSize,counter+1);
			}
		
			else if(indexRow == endRow && indexCol != startCol) { // bottom row and it can continue to left side.
				System.out.printf(array[indexRow][indexCol] + " ");
				printSorted(array,startRow,endRow,startCol,endCol,indexRow,indexCol-1,totalSize,counter+1);
			}
				
			else if(indexCol == startCol && indexRow > startRow + 1) { // mostleft column but it  wont turn right yet.
				System.out.printf(array[indexRow][indexCol] + " ");
				printSorted(array,startRow,endRow,startCol,endCol,indexRow-1,indexCol,totalSize,counter+1);
			}
			
			else if(indexCol == startCol && indexRow == startRow + 1) { //mostLeft column and it will turn to right side at that time.
				System.out.printf(array[indexRow][indexCol] + " ");
				printSorted(array,startRow+1,endRow-1,startCol+1,endCol-1,indexRow,indexCol+1,totalSize,counter+1);
			}
			
			else if(indexCol == endCol && indexRow != endRow) { // mostright column
				System.out.printf(array[indexRow][indexCol] + " ");
				printSorted(array,startRow,endRow,startCol,endCol,indexRow+1,indexCol,totalSize,counter+1);
			}

		}
	}
		
	
	/**
	 * @param expression expression which will be evaluate.
	 * @param index expression's current character's index
	 * @param expSize  expression's size.
	 * @param temp in first, temp should be 0. it keeps the numbers which has more than one digit.
	 * @param stack stack
	 * @param operandSize number of operand.
	 * @return result of evaluation postfix.
	 */
	public int evaluatePostfix(String expression,int index,int expSize,int temp,Stack<Integer> stack,int operandSize) {
		
        if(index == expSize)
            return stack.pop();  
        
        else {
        	 char c = expression.charAt(index); 
             
             if(c == ' ') { 
                 if(operandSize == 2)
                     return evaluatePostfix(expression,index+1,expSize,0,stack,0);	
                 
                 else {
                     stack.push(temp); 
                	 return evaluatePostfix(expression,index+1,expSize,0,stack,operandSize+1);	 
                 }
             }  
                 
             else if(isDigit(c)) 
             { 
            	 temp = temp * 10 + (int)(c - '0'); 
            	 return evaluatePostfix(expression,index+1,expSize,temp,stack,operandSize);	
             }
             else if(isOperator(c)) {   
            	  
            	 int val1 = stack.pop(); 
                 int val2 = stack.pop(); 
                 int result;
             
                 if(c == '+') {
                     result = val2+val1;
                     System.out.println(val2 + " + " + val1 + " = " + result);
                     stack.push(result);
                     return evaluatePostfix(expression,index+1,expSize,0,stack,2);	
                 }
                 else if(c == '-') {
                     result = val2-val1;
                     stack.push(result); 
                     System.out.println(val2 + " - " + val1 + " = " + result);
                 	return evaluatePostfix(expression,index+1,expSize,0,stack,2);	
             	 }
                 else if(c == '*') {
                     result = val2*val1;
                     stack.push(result);
                     System.out.println(val2 + " * " + val1 + " = " + result);
                     return evaluatePostfix(expression,index+1,expSize,0,stack,2);	
                 }
                 else if(c == '/') {
                     result = val2/val1;
                     stack.push(result); 
                     System.out.println(val2 + " / " + val1 + " = " + result);
                     return evaluatePostfix(expression,index+1,expSize,0,stack,2);	
                 }
             }
        }         
        return evaluatePostfix(expression,index+1,expSize,0,stack,operandSize);	
	}
	
}
