package base;

public class Main {
    public static void main(String[] args) {

		DeleteNode theTree = new DeleteNode();

		theTree.addNode(50, "Boss");

		theTree.addNode(25, "Vice President");

		theTree.addNode(15, "Office Manager");

		theTree.addNode(30, "Secretary");

		theTree.addNode(75, "Sales Manager");

		theTree.addNode(85, "Salesman 1");

		System.out.println("\nNode with the key 75");

		System.out.println(theTree.findNode(75));

		System.out.println("Remove Key 25");

		theTree.remove(25);

		System.out.println(theTree.findNode(25));

		theTree.inOrderTraverseTree(theTree.root);

		System.out.println("The Maximum element is " + theTree.findMax(theTree.root));

		System.out.println("The Minimum element is " + theTree.findMin(theTree.root));

		System.out.println("The tree hight is " + theTree.maxHeight(theTree.root));

	}
}
