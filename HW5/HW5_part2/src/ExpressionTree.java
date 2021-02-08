import java.util.Scanner;

/**
 * @author  Elif Goral
 *			171044003
 */
public class ExpressionTree extends BinaryTree<String> {
	/**
	 * Constructor.
	 * That constructor controls the expression is prefix or postfix. If expression is prefix send  the expression to readBinaryTree method and assign to root.
	 * If expression is postfix, firstly reverse the string and send to readBinaryTree method and assign to root.
	 * @param exp expression 
	 */
	public ExpressionTree(String exp){
		if(isPrefix(exp)) {
	 		Scanner scanPre = new Scanner(exp);
			System.out.println("expression is prefix");
			System.out.println("Expression        : "+ exp);
			setRoot(readBinaryTree(scanPre).root);
			scanPre.close();
		}
		else {
			System.out.println("expression is postfix");
			System.out.println("Expression         : "+ exp);
			String output = "";
			output = reverseString(exp,output);
			Scanner scanPost = new Scanner(output);
			setRoot(readBinaryTree(scanPost).root);
			scanPost.close();
		}		
	}
	
	
	/**
	 * That method controls the character which is given as a parameter. If character is operator returns true,otherwise false.
	 * @param c character will be controlled.
	 * @return If character is operator returns true,otherwise false.
	 */
	public static boolean isOperator(char c) {
		if(c == '+' || c == '-' || c == '/' || c == '*')
			return true;
		return false;
	}
	
	/**
	 * That method checks the character is digit or not.
	 * @param c character will be controlled.
	 * @return returns true if character is digit,otherwise false.
	 */
	public static boolean isDigit(char c) {
		if (c >= 48 && c <= 57) 
            return true; 
        return false;
	}
	
	/**
	 * That method controls the expression is prefix or not.
	 * @param exp expression will be controlled.
	 * @return if expression is prefix, returns true, otherwise false.
	 */
	public boolean isPrefix(String exp) {
		if(isOperator(exp.charAt(0)))
			return true;
		return false;
	}
	
	/**
	 * That method controls the expression is postfix or not.
	 * @param exp expression will be controlled.
	 * @return if expression is postfix, returns true, otherwise false.
	 */
	public boolean isPostfix(String exp) {
		if(isDigit(exp.charAt(0)))
			return true;
		return false;
	}
	
	
	/**
	 * That method returns the evaluation of expression.
	 * @return returns the evaluation of expression.
	 */
	public int eval(){		
		return eval(getRoot());	
	}
	
	
	/**
	 * That method evaluate the tree's result.
	 * @param node node.
	 * @return returns the evaluation of expression tree.
	 */
	public int eval(BinaryTree<String> node) {
		if (node == null)  
	        return 0; 
		if(node.getData() instanceof String) {
			String strData = (String) node.getData();
			if (node.isLeaf())  
		        return Integer.parseInt(strData); 
		    int resultLeft = eval(node.getLeftSubtree());  
		    int resultRight = eval(node.getRightSubtree());  
		   
		    return calculator(strData.charAt(0),resultLeft,resultRight);  
		}
		return 0;		
	}
	
	/**
	 * That method of calculator of expression. 
	 * @param operator operator
	 * @param leftData left side of operator.
	 * @param rightData right side of operator.
	 * @return returns the calculation.
	 */
	public int calculator(char operator,int leftData,int rightData) {
		if(operator == '+') {
			return (leftData + rightData);	
		}
		else if(operator == '-') {
			return (leftData - rightData);	
		}
		else if(operator == '*') {
			return (leftData * rightData);	
		}
		else if(operator == '/') {
			if(leftData>rightData)
				return (leftData / rightData);	
			return rightData / leftData;
		}
		return 0;
	}
	
	/**
	 * That method returns traverse the tree as a postorder.
	 * @return  returns to postordered traversal tree.
	 */
	public String toString2() {
		StringBuilder sb = new StringBuilder();
		postOrderTraverse(root,sb);
		return sb.toString();	
	}

	
	/**
	 * That method traverse the tree as a postorder.
	 * @param node node
	 * @param sb output string.
	 */
	private void postOrderTraverse(Node<String> node,StringBuilder sb) {
		if(node == null)
			sb.append("");
		else {
			postOrderTraverse(node.left,sb);
			postOrderTraverse(node.right,sb);
			sb.append(node.toString() + " ");
		}		
	}

	
	/**
	 * That method reads the expression and assign to tree.
	 * @param scan scan expression.
	 * @return return the binary tree.
	 */
	public static BinaryTree<String> readBinaryTree(Scanner scan) {
		if(scan.hasNext()) {
			String data = scan.next();
			if(isDigit(data.charAt(0))) {
				return new BinaryTree<String>(data,null,null);
			}
			else {
				BinaryTree<String> leftTree = readBinaryTree(scan);
				BinaryTree<String> rightTree = readBinaryTree(scan);
				return new BinaryTree<String>(data,leftTree,rightTree);
			}
		}	
		return null;
	}
	
	
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
	
}
