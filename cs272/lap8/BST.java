import javax.xml.crypto.Data;

/**
 *  Node for Binary Tree
 * 
 */
class BSTNode{
	private int data;   //the element value for this node
	private BST left;	//the left child of this node
	private BST right;	//the right child of this node
	
	/**
	 * No-argument constructor
	 */
	public BSTNode(){
		data = 0; 
		left = new BST();
		right = new BST();
	}
	
	/**
	 * Constructor with the initial element
	 * @param initData: the initial element
	 */
	public BSTNode(int initData){
		data = initData; 
		left = new BST();
		right = new BST();
	}
	
	/**
	 * Constructor with the initial element, initial left and right children
	 * @param initData: the initial element
	 * @param initParent: the initial parent tree
	 * @param initLeft: left child
	 * @param initRight: right child
	 */
	public BSTNode(int initData, BST initLeft, BST initRight){
		data = initData;
		left = initLeft;
		right = initRight;
	}

	/**
	 * Evaluate whether this node is a leaf node or not
	 * @return true if it is a leaf node; otherwise, return false.
	 */
	public boolean isLeaf()
	{
		return (((left==null)||(left!=null && left.root==null))
				&&((right==null)||(right!=null && right.root==null)));
	}
	
	
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param set the element in this node
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the left child
	 */
	public BST getLeft() {
		return left;
	}

	/**
	 * @param the left child to be set
	 */
	public void setLeft(BST left) {
		this.left = left;
	}

	/**
	 * @return the right child
	 */
	public BST getRight() {
		return right;
	}

	/**
	 * @param the right child to be set
	 */
	public void setRight(BST right) {
		this.right = right;
	}
	
	
	/**
	 * Convert this BTNode to a string
	 */
	public String toString()
	{
		String str="";
		
		if((left==null)||(left!=null && left.root==null)) str +="(null)";
		else str +="("+left.root.getData()+")";
		
		str += data;
		
		if((right==null)||(right!=null&&right.root==null)) str +="(null)";
		else str +="("+right.root.getData()+")";
		
		return str;
	}

	

}


/**
 * The class for Binary Search Tree
 *
 */
public class BST {
	protected BSTNode root; //the tree root
	
	
	/**
	 * Get the left subtree of this tree
	 * @return the left subtree of this tree
	 */
	private BST getLeftSubtree(){
		return root.getLeft();
	}
	
	/**
	 * Get the right subtree of this tree
	 * @return the right subtree of this tree
	 */
	private BST getRightSubtree(){
		return root.getRight();
	}
	
	/**
	 * Print the tree using in-order traversal strategy
	 */
	public void inOrderPrt(){
		inOrderPrt(0);
	}
	
	/**
	 * private, recursive function
	 *     I slightly changed the method to print right subtree first
	 *     It is to make the display more easier to read
	 * 
	 * @param node
	 * @param indentation
	 * @param branch
	 */
	private void inOrderPrt(int indentation){
		if(root!=null){
			if(getRightSubtree()!=null) getRightSubtree().inOrderPrt(indentation+1);
			
			for(int i=0;i<indentation*4;i++) System.out.print(" ");
			
			System.out.println(root.getData());
			
			if(getLeftSubtree()!=null) getLeftSubtree().inOrderPrt(indentation+1);
		}
	}
	
	
	/**
	 * Debug function, print the tree for debugging purpose
	 */
	public String toString()
	{
		if(root!=null) return root.toString();
		else return null;
	}







	///////////////////////////////////////
    ///////////////////////////////////////
	// Please add the functions required for your lab homework here.

		//------------------------------------

	// to do insert into the tree
	public boolean insert(int data){
		if(root== null){
			root = new BSTNode(data);
			return true;
		}
		return this.inserthelpper(data, this);
	}
	public boolean inserthelpper(int data, BST c){
		//makes the things 
		BST n = new BST();
		n.root = new BSTNode(data);

		if(c.root== null){
			c.root = new BSTNode(data);
			return true;
		}

		if(data <= c.root.getData()){
			if(data == c.root.getData()){
				return false;
			}
			if(c.getLeftSubtree()!=null){
				return inserthelpper(data, c.getLeftSubtree());
			}
		}else{
			if(c.getRightSubtree()!=null){
				return inserthelpper(data, c.getRightSubtree());
			}
		}
		return false;
	}
	

	public boolean remove(int data){
		return removeHelper(data, this);
	}
	public boolean removeHelper(int data, BST c){
		/*
		 * • Case 1: root==null //this subtree is empty
• Case 2: (e==root.getdata())
• Case 2.1: (left.root==null)&&(right.root==null)
• This root to null
• Case 2.2: (left.root==null)&&(right.root!=null)
• Set this root to the root of current node’s right subtree
• Case 2.3: (left.root!=null)&&(right.root==null)
• Set this root to the root of current node’s left subtree
• Case 2.4: (left.root!=null)&&(right.root!=null)
• maxDataLeft = get and remove the largest value in the left subtree by
calling another function removeMax()
• replace the current node’s root value with maxDataLeft
• Case 3: (e<root.getdata())
• getLeftSubTree().remove(e);
• Case 4: (e>root.getdata())
• getRightSubTree().remove(e);
		 * 
		 */

		// tree is empty
		 if(c.root == null){
			return false;
		 }
		
		 if(data == c.root.getData()){//the root to delete

			if((c.getLeftSubtree().root==null) && (c.getRightSubtree().root == null)){//set the root to null 
				c.root = null;
				return true;
			}

			if((c.getLeftSubtree().root==null) && (c.getRightSubtree().root != null)){//Set this root to the root of current node’s right subtree
				c.root = c.getRightSubtree().root;
				return true;
			}

			if((c.getLeftSubtree().root!=null) && (c.getRightSubtree().root == null)){//Set this root to the root of current node’s left subtree
				c.root = c.getLeftSubtree().root;
				return true;
			}

			if((c.getLeftSubtree().root!=null) && (c.getRightSubtree().root != null)){// maxDataLeft = get and remove the largest value in the left subtree by
				//calling another function removeMax()
				//calling another function removeMax()
				//• replace the current node’s root value with maxDataLeft
				c.root.setData(c.getLeftSubtree().removeMax().getData());
				return true;
				
			}

			return false;

		}else{
			if(data < c.root.getData()){
				c = c.getLeftSubtree();
				return removeHelper(data, c);
			}else{
				c = c.getRightSubtree();
				return removeHelper(data, c);
			}

		 }
	}
	public BSTNode removeMax(){
		BST RT = getRightSubtree();
		BSTNode Max = null;
		if(RT.root == null){
			Max = this.root;
			this.root =getLeftSubtree().root;
		}else{
			return RT.removeMax();
		}
		return Max;
	}
	

// the complexaty of this is o(log2n) becaus the
//loop only has to look over a very small part of the list

	public BSTNode searchNonRecursion(int data){
		boolean found = false;
		BST c = this;
		while(!found){

			if(c.root==null){
				return null;
			}

			if(c.root.getData()== data){
				found = true;
				return c.root;
			}else{
				if(data > c.root.getData()){
					c = c.getLeftSubtree();
				}else{
					c = c.getRightSubtree();
				}
			}

		}
		return root;
	}

	public BSTNode searchRecursion(int data){
		return searchRecursionHelper(data, this);
	}
// the runtime of this is o(2log2(n))
// this is becaus the worst case the number of itterations would be equal to the depth of the list
// so if we drop the 2 oprations  we get o(log2(n))
	public BSTNode searchRecursionHelper(int data, BST c){
		if(c.root==null){//1
			return null;
		}
		if(data == c.root.getData()){//2
			return c.root;
		}else{
			if(c.root.getData() > data ){	
				return searchRecursionHelper(data, c.getLeftSubtree());
			}else{
				return searchRecursionHelper(data, c.getRightSubtree());
			}
		}
	}

	//-----------------------------------

	/**
	 * Test cases provided by the instructor
	 * @throws Exception
	 */
	private static void test1() throws Exception{
		BST tree = new BST();
		System.out.println("Initial tree:");
		tree.inOrderPrt(); //test inOrder traversal
		
		boolean rc = true;
		
		//test 1: insert method, and test 2 in-order traversal
		rc = tree.insert(12); System.out.println("\nInsert 12, inserted="+rc+", after adding 12:"); tree.inOrderPrt();
		rc = tree.insert(6);  System.out.println("\nInsert 6, inserted="+rc+", after adding 6:"); tree.inOrderPrt();
		rc = tree.insert(19); System.out.println("\nInsert 19, inserted="+rc+", after adding 19:"); tree.inOrderPrt();
		rc = tree.insert(4);  System.out.println("\nInsert 4, inserted="+rc+", after adding 4:"); tree.inOrderPrt();
		rc = tree.insert(8);  System.out.println("\nInsert 8, inserted="+rc+", after adding 8:"); tree.inOrderPrt();
		rc = tree.insert(16); System.out.println("\nInsert 16, inserted="+rc+", after adding 16:"); tree.inOrderPrt();
		rc = tree.insert(8);  System.out.println("\nInsert 8 (second), inserted="+rc+", after adding 8:"); tree.inOrderPrt();
		rc = tree.insert(5);  System.out.println("\nInsert 5, inserted="+rc+", after adding 5:"); tree.inOrderPrt();
		rc = tree.insert(9);  System.out.println("\nInsert 9, inserted="+rc+", after adding 9:"); tree.inOrderPrt();
		rc = tree.insert(20);  System.out.println("\nInsert 20, inserted="+rc+", after adding 20:"); tree.inOrderPrt();
		
		System.out.println("Inorder traversal results:");
		tree.inOrderPrt(); 
		System.out.print("\n\n");
		
		//test 3: search method
		BSTNode node = tree.searchRecursion(6);
		System.out.println("searchRecursion 6, node="+node);
		node = tree.searchRecursion(22);
		System.out.println("searchRecursion 22, node="+node);
		node = tree.searchRecursion(8);
		System.out.println("searchRecursion 8, node="+node+"\n");
		
		node = tree.searchNonRecursion(6);
		System.out.println("searchNonRecursion 6, node="+node);
		node = tree.searchNonRecursion(22);
		System.out.println("searchNonRecursion 22, node="+node);
		node = tree.searchNonRecursion(8);
		System.out.println("searchNonRecursion 8, node="+node);
		
		//test 4: remove method
		rc = tree.remove(30); //test case 0: e does not exist
		System.out.println("\nRemove 30, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(20); //test case 1: leaf
		System.out.println("\nRemove 20, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(4); //test case 2: left is empty
		System.out.println("\nRemove 4, rc="+rc);
		tree.inOrderPrt();
		
		
		rc = tree.remove(19); //test case 3: right is empty
		System.out.println("\nRemove 19, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(6); //test case 4: no subtree is empty
		System.out.println("\nRemove 6, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(12); //more tests: remove root
		System.out.println("\nRemove 12, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(8); //more tests
		System.out.println("\nRemove 8, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(5); //more tests
		System.out.println("\nRemove 5, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(8); //more tests
		System.out.println("\nRemove 8, rc="+rc);
		tree.inOrderPrt();
		rc = tree.remove(16); //more tests
		System.out.println("\nRemove 16, rc="+rc);
		tree.inOrderPrt();
		
		
		System.out.println("\nAdding a series of numbers:");
		tree.insert(30);
		tree.insert(20);tree.insert(10);tree.insert(25);tree.insert(28);tree.insert(24);
		tree.insert(11);tree.insert(5);tree.insert(11);tree.insert(12);
		tree.insert(50);tree.insert(40);tree.insert(35);
		tree.inOrderPrt();
		
		
		
		System.out.print("\n\n");
		
		System.out.println("\nRemove 20 (removeNode case 4):");
		tree.remove(20);
		tree.inOrderPrt();
		
		
		System.out.println("Inorder traversal results: ");
		tree.inOrderPrt();
		System.out.print("\n");
		
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//You need to let your program pass the  test cases in this function
		test1(); 
		
		//You can add your own test cases here. 
		
	}

}
