package base;
import java.util.LinkedList;
import java.util.Queue;


public class DeleteNode {

	Node root;

	public void addNode(int key, String name) {

		Node newNode = new Node(key, name);

		if (root == null) {

			root = newNode;

		} else {

			Node focusNode = root;

			Node parent;

			while (true) {

				parent = focusNode;

				if (key < focusNode.key) {

					focusNode = focusNode.leftChild;

					if (focusNode == null) {

						parent.leftChild = newNode;
						return; 

					}

				} else { 

					focusNode = focusNode.rightChild;

					if (focusNode == null) {

						parent.rightChild = newNode;
						return; 

					}

				}

			}
		}

	}

	public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			preorderTraverseTree(focusNode.leftChild);

			System.out.println(focusNode);


			preorderTraverseTree(focusNode.rightChild);

		}

	}

	public void preorderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			System.out.println(focusNode);

			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);

		}

	}

	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);

			System.out.println(focusNode);

		}

	}

	public Node findNode(int key) {

		Node focusNode = root;

		while (focusNode.key != key) {

			if (key < focusNode.key) {

				focusNode = focusNode.leftChild;

			} else {

				focusNode = focusNode.rightChild;

			}

			if (focusNode == null)
				return null;

		}

		return focusNode;

	}

	public boolean remove(int key) {

		Node focusNode = root;
		Node parent = root;

		boolean isItALeftChild = true;

		while (focusNode.key != key) {

			parent = focusNode;

			if (key < focusNode.key) {

				isItALeftChild = true;

				focusNode = focusNode.leftChild;

			} else {

				isItALeftChild = false;

				focusNode = focusNode.rightChild;

			}

			if (focusNode == null)
				return false;

		}

		if (focusNode.leftChild == null && focusNode.rightChild == null) {

			if (focusNode == root)
				root = null;

			else if (isItALeftChild)
				parent.leftChild = null;

			else
				parent.rightChild = null;

		}

		else if (focusNode.rightChild == null) {

			if (focusNode == root)
				root = focusNode.leftChild;

			else if (isItALeftChild)
				parent.leftChild = focusNode.leftChild;

			else
				parent.rightChild = focusNode.leftChild;

		}

		else if (focusNode.leftChild == null) {

			if (focusNode == root)
				root = focusNode.rightChild;

			else if (isItALeftChild)
				parent.leftChild = focusNode.rightChild;

			else
				parent.rightChild = focusNode.rightChild;

		}

		else {

			Node replacement = getReplacementNode(focusNode);

			if (focusNode == root)
				root = replacement;

			else if (isItALeftChild)
				parent.leftChild = replacement;

			else
				parent.rightChild = replacement;

			replacement.leftChild = focusNode.leftChild;

		}

		return true;

	}

	public Node getReplacementNode(Node replacedNode) {

		Node replacementParent = replacedNode;
		Node replacement = replacedNode;

		Node focusNode = replacedNode.rightChild;

		while (focusNode != null) {

			replacementParent = replacement;

			replacement = focusNode;

			focusNode = focusNode.leftChild;

		}

		if (replacement != replacedNode.rightChild) {

			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;

		}

		return replacement;

	}

		public int findMax(Node node)
		{
			if (node == null)
				return Integer.MIN_VALUE;
	
			int res = node.key;
			int lres = findMax(node.leftChild);
			int rres = findMax(node.rightChild);
	
			if (lres > res)
				res = lres;
			if (rres > res)
				res = rres;
			return res;
		}

		public int findMin(Node node)
    {
        if (node == null)
            return Integer.MAX_VALUE;

        int res = node.key;
        int lres = findMin(node.leftChild);
        int rres = findMin(node.rightChild);

        if (lres < res)
            res = lres;
        if (rres < res)
            res = rres;
        return res;
    }
	
	int maxHeight(Node node)
    {
        if (node == null)
            return 0;
        else
        {
            int lHeight = maxHeight(node.leftChild);
            int rHeight = maxHeight(node.rightChild);
            if (lHeight > rHeight)
                return (lHeight + 1);
            else
                return (rHeight + 1);
        }
    }

	static void bSearch(Node node){
		Queue<Node> q = new LinkedList<Node>();

		q.add(node);
	
        while (!q.isEmpty()) {

            node = q.remove();

            System.out.print(" " + node.key);

            if (node.leftChild != null){

                q.add(node.leftChild);

			}

            if (node.rightChild != null){

                q.add(node.rightChild);

			}
		}
	}

	static void dSearch(Node node){

		if (node == null)
		{
			return;
		}

		System.out.println(node.key);

		dSearch(node.leftChild);

		dSearch(node.rightChild);
	}


}


