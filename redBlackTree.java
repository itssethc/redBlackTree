import java.util.Stack;
public class redBlackTree {
	public Node root;
	
	public redBlackTree () {
		root = null;
	}
	
	public void add (Node node) {
		if (root == null) {
			root = node;
			root.color = 'B';
		}
		else insert(node);
	}
	
	public void insert (Node node) {
		Node current = root;
		int checko = 1;
		while (checko == 1) {
			if (current.color == 'B') // Check if black with two red children
				if (current.leftChild != null && current.rightChild != null)
					if (current.leftChild.color == 'R' && current.rightChild.color == 'R') flipColors(current);
			// Traverse Onward
			if (node.num > current.num) { // Go right
				if (current.rightChild == null) { // Add to the right
					current.rightChild = node;
					node.parent = current;
					current = node;
					redViolation(node);
					checko = 0;
				} else current = current.rightChild; // Keep going
			}
			else if (node.num < current.num) { // Go left 
				if (current.leftChild == null) { // Add to the left
					current.leftChild = node;
					node.parent = current;
					current = node;
					redViolation(node);
					checko = 0;
				} else current = current.leftChild; // Keep going
			}
		}
		// Make sure root is black
		if (root.color == 'R') root.color = 'B';
	}
	
	public void flipColors (Node node) {
		node.color = 'R';
		node.leftChild.color = 'B';
		node.rightChild.color = 'B';
		if (node.num == root.num) node.color = 'B';
		else redViolation(node);
	}
	
	public void redViolation (Node node) {
		// See if violation occurs, and if so what type of grandchild
		if (node.parent.color == 'R') {
			if (node.parent.parent != null) {
				if (node.parent.parent.leftChild == node.parent && node.parent.leftChild == node) singleRotate(node, 1);
				else if (node.parent.parent.rightChild == node.parent && node.parent.rightChild == node) singleRotate(node, 1);
				else doubleRotate(node);
			}
		}
	}
	
	public void singleRotate (Node node, int check) {
		// Switch nodes grandparents color
		if (node.parent.parent.color == 'R') node.parent.parent.color = 'B';
		else node.parent.parent.color = 'R';
		if (check == 1) { // One single rotation..
			// Switch nodes parents color
			if (node.parent.color == 'R') node.parent.color = 'B';
			else node.parent.color = 'R';
		}
		// Make references
		Node grandparent = node.parent.parent;
		Node parent = node.parent;
		// If right child, rotate left. If left child, rotate right.
		if (parent.rightChild == node) {
			if (parent.leftChild == null) grandparent.rightChild = null;
			else grandparent.rightChild = parent.leftChild; // Cross-over
			parent.leftChild = grandparent;
			if (grandparent.parent == null) { // Grandparent is root
				parent.parent = null;
				root = parent;
				grandparent.parent = parent;
			} else {
				parent.parent = grandparent.parent;
				// Check what child the grandparent as for reassignments
				if (parent.parent.rightChild == grandparent) parent.parent.rightChild = parent;
				else parent.parent.leftChild = parent;
				grandparent.parent = parent;
			}
		} else if (parent.leftChild == node) {
			if (parent.rightChild == null) grandparent.leftChild = null;
			else grandparent.leftChild = parent.rightChild; // Cross-over
			parent.rightChild = grandparent;
			if (grandparent.parent == null) { // Grandparent is root
				parent.parent = null;
				root = parent;
				grandparent.parent = parent;
			} else {
				parent.parent = grandparent.parent;
				// Check what child the grandparent as for reassignments
				if (parent.parent.leftChild == grandparent) parent.parent.leftChild = parent;
				else parent.parent.rightChild = parent;
				grandparent.parent = parent;
			}
		}
	}
	
	public void doubleRotate (Node node) {
		// Switch nodes color
		if (node.color == 'R') node.color = 'B';
		else node.color = 'R';
		// Rotation 1 then 2
		if (node.parent.rightChild == node) {
			if (node.leftChild == null) node.parent.rightChild = null;
			else node.parent.rightChild = node.leftChild;
			node.leftChild = node.parent;
			node.parent = node.parent.parent;
			node.parent.leftChild = node;
			node.leftChild.parent = node;
			singleRotate(node.leftChild, 0);
		} else {
			if (node.rightChild == null) node.parent.leftChild = null;
			else node.parent.leftChild = node.rightChild;
			node.rightChild = node.parent;
			node.parent = node.parent.parent;
			node.parent.rightChild = node;
			node.rightChild.parent = node;
			singleRotate(node.rightChild, 0);
		}
	}
	
	public void displayTree(){
	      Stack<Node> globalStack = new Stack<Node>();
	      globalStack.push(root);
	      int nBlanks = 32;
	      boolean isRowEmpty = false;
	      System.out.println(
	      ".......................................................................................");
	      while(isRowEmpty==false){
	         Stack<Node> localStack = new Stack<Node>();
	         isRowEmpty = true;

	         for(int j=0; j<nBlanks; j++)
	            System.out.print(' ');

	         while(globalStack.isEmpty()==false){
	            Node temp = globalStack.pop();
	            if(temp != null){
	               System.out.print(temp.color + "-" + temp.num);
	               localStack.push(temp.leftChild);
	               localStack.push(temp.rightChild);

	               if(temp.leftChild != null || temp.rightChild != null)
	                  isRowEmpty = false;
	            }
	            else{
	               System.out.print("--");
	               localStack.push(null);
	               localStack.push(null);
	            }
	            for(int j=0; j<nBlanks*2-2; j++)
	               System.out.print(' ');
	         } 
	         System.out.println();
	         nBlanks /= 2;
	         while(localStack.isEmpty()==false)
	            globalStack.push( localStack.pop() );
	         }  
	      System.out.println(
	      ".......................................................................................");
	      }
}