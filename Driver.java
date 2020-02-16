import java.util.Scanner;
public class Driver {

	public static void main(String[] args) {
		
		// I used the technique of running color flip on the root, so some may vary from yours where roots children are both black instead of both red on occasion.
		
		inputTest();
		
		// Flat out tests.. Uncomment if this would work better
		// Can choose to show just end result or uncomment within test for each step displayed
		
		//testOnTen(5, 6, 7, 2, 3, 1, 4, 9, 8, 10);
		//testOnTen(5, 6, 4, 1, 2, 3, 7, 8, 9, 10);
		//testOnTen(7, 5, 6, 2, 4, 3, 1, 10, 9, 8);
		//testOnTen(1, 3, 2, 5, 4, 8, 10, 6, 9, 7);
		//testOnTen(9, 10, 8, 7, 4, 1, 3, 2, 5, 6);
		
	}
	
	public static void inputTest () {
		Scanner keyboard = new Scanner(System.in);
		// Make tree
		redBlackTree rbt = new redBlackTree();
		int choice = 0;
		while (choice != -1) {
			System.out.println("\nEnter a positive integer to add, or enter -1 to leave");
			choice = keyboard.nextInt();
			if (choice != -1) {
				Node node = new Node(choice);
				System.out.println("\nAdding " + choice + " and showing resulting tree\n");
				rbt.add(node);
				rbt.displayTree();
			} else System.out.println("\nLater!");
		}
		keyboard.close();
	}
	public static void testOnTen (int a, int b, int c, int d, int e, int f, int g, int h, int i, int j) {
		// Make tree
		redBlackTree rbt = new redBlackTree();
		// Add ten values
		Node node1 = new Node (a);
		rbt.add(node1);
		//rbt.displayTree();
		Node node2 = new Node (b);
		rbt.add(node2);
		//rbt.displayTree();
		Node node3 = new Node (c);
		rbt.add(node3);
		//rbt.displayTree();
		Node node4 = new Node (d);
		rbt.add(node4);
		//rbt.displayTree();
		Node node5 = new Node (e);
		rbt.add(node5);
		//rbt.displayTree();
		Node node6 = new Node (f);
		rbt.add(node6);
		//rbt.displayTree();
		Node node7 = new Node (g);
		rbt.add(node7);
		//rbt.displayTree();
		Node node8 = new Node (h);
		rbt.add(node8);
		//rbt.displayTree();
		Node node9 = new Node (i);
		rbt.add(node9);
		//rbt.displayTree();
		Node node10 = new Node (j);
		rbt.add(node10);
		// Show tree, uncomment displays above to see each step every time the test runs
		rbt.displayTree();
	}
}
