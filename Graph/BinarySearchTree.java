public class BinarySearchTree{

	class Node{
		int data;
		Node left;
		Node right;

		Node(int data){
			this.data = data;
		}
	}

	Node root;

	public Node makeTreeR(int[] a){
		return root = makeTreeR(a, 0, a.length-1);
	}

	public Node makeTreeR(int[] a, int start, int end){
		if(start>end)	return null;
		int mid = (start + end)/2;
		Node node = new Node(mid);
		node.left = makeTreeR(a, start, mid-1);
		node.right = makeTreeR(a, mid+1, end);
		return node;
	}

	public void searchBTree(Node n, int find){
		if(n == null){
			System.out.println("There is no "+find);
			return;
		}
		if(find < n.data){
			searchBTree(n.left, find);
		}
		else if(find > n.data){
			searchBTree(n.right, find);
		}
		else{
			System.out.println(find+" is found");
		}
	}

	public static void main(String[] args){
		int[] a = new int[10];
		for(int i = 0; i<10; i++){
			a[i] = i;
		}

		BinarySearchTree bst = new BinarySearchTree();
		bst.makeTreeR(a);
		bst.searchBTree(bst.root, -1);
	}
}
