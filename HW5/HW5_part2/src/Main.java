
/**
 * @author  Elif Goral
 *			171044003
 *
 */
public class Main {

	public static void main(String[] args) {
		ExpressionTree expTreePre1 = new ExpressionTree("+ + 10 * 5 15 20");
		System.out.println("postOrderTraverse: "+ expTreePre1.toString2());
		System.out.println("eval             : "+ expTreePre1.eval());
		System.out.println();
		
		ExpressionTree expTreePre2 = new ExpressionTree("* + 2 3 / + 4 5 3");
		System.out.println("postOrderTraverse: "+ expTreePre2.toString2());
		System.out.println("eval             : "+ expTreePre2.eval());
		System.out.println();
		
		ExpressionTree expTreePost1 = new ExpressionTree("10 5 15 * + 20 +");
		System.out.println("preOrderTraverse : " + expTreePost1.toString());
		System.out.println("eval             : "+ expTreePost1.eval());
		System.out.println();
	
		ExpressionTree expTreePost2 = new ExpressionTree("2 3 + 4 5 + 3 / *");
		System.out.println("preOrderTraverse : " + expTreePost2.toString());
		System.out.println("eval             : "+ expTreePost2.eval());
		System.out.println();
	
		
	}
}
