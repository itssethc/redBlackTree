public class Node {
	
	public int num;
	public char color;
	   
	public Node parent;          
	public Node leftChild;         
	public Node rightChild;   
   
	public Node (int n) {
		num = n;
		color = 'R';
	}
	   
	public Node () {
		num = 0;
		color = 'R';
	}
	   
	public void displayNode () {
		System.out.print("{ ");
	    System.out.print(color);
	    System.out.print("(");
	    System.out.print(num);
	    System.out.print(") } ");
	}
}
