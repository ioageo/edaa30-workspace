package bst;

public class main {

	public static void main(String[] args) {
		BinarySearchTree<String> s = new BinarySearchTree<String>();
		BinarySearchTree<Integer> i = new BinarySearchTree<Integer>();
		BSTVisualizer String = new BSTVisualizer("Stgring", 500, 500);
		BSTVisualizer Integer = new BSTVisualizer("Integer", 500, 500);
		
		/*
		 * put 7 number in the tree
		 */
		for (int m = 0; m <= 6; m++) {
			System.out.println(i.add(m));
		}
		System.out.println();
		/*
		 * test for the same
		 */
		System.out.println(i.add(6));
		System.out.println();
		
		/*
		 * put 7 letters in the tree
		 */
		System.out.println(s.add("a"));
		System.out.println(s.add("b"));
		System.out.println(s.add("c"));
		System.out.println(s.add("d"));
		System.out.println(s.add("e"));
		System.out.println(s.add("f"));
		System.out.println(s.add("j"));
		System.out.println();
		/*
		 * test for the same
		 */
		System.out.println(s.add("j"));

		i.rebuild();
		s.rebuild();

		String.drawTree(s);
		Integer.drawTree(i);
	}

}
