package bst;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
	int size;
	

	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {
		root = null;
		size = 0;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * 
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		int s = size;
		root = add2(root, x);
		return size > s;
	}

	private BinaryNode<E> add2(BinaryNode<E> n, E x) {
		if (n == null) {
			size++;
			return new BinaryNode<E>(x);
		} else if (x.compareTo(n.element) == 0) {
			return n;
		} else if (x.compareTo(n.element) < 0) {
			n.left = add2(n.left, x);
			return n;
		} else {
			n.right = add2(n.right, x);
			return n;
		}
	}

	/**
	 * Computes the height of tree.
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		return height2(root);
	}

	private int height2(BinaryNode<E> n) {
		if (n == null) {
			return 0;
		} else {
			int left = 1 + height2(n.left);
			int right = 1 + height2(n.right);
			if (left >= right) {
				return left;
			} else {
				return right;
			}
		}
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}

	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		print(root);
	}

	private void print(BinaryNode<E> temp) {
		if (temp != null) {
			print(temp.left);
			System.out.println(temp.element.toString());
			print(temp.right);
		}
	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		@SuppressWarnings("unchecked")
		E[] a = (E[]) new Comparable[size];
		toArray(root, a, 0);
		root = buildTree(a, 0, a.length - 1);
	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index]. Returns the index of the last inserted element + 1 (the
	 * first empty position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {
		if (n == null) {
			return index;
		} else {
			index = toArray(n.left, a, index);
			a[index] = n.element;

			return toArray(n.right, a, index + 1);
		}

	}

	/*
	 * Builds a complete tree from the elements a[first]..a[last]. Elements in the
	 * array a are assumed to be in ascending order. Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {

		if (first <= last) {
			int mid = (first + last) / 2;
			BinaryNode<E> root = new BinaryNode<E>(a[mid]);
			root.left = buildTree(a, first, mid - 1);
			root.right = buildTree(a, mid + 1, last);
			return root;
		}
		return null;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
			left = right = null;
		}


	}

}
