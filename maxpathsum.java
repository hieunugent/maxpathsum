import java.util.*;

class Program {
  public static int maxPathSum(BinaryTree tree) {
    // Write your code here.
		List<Integer> rootMSP = findMaxPath(tree);
    return rootMSP.get(1);
  }
	public static List<Integer> findMaxPath(BinaryTree tree){
		if(tree == null){ return new ArrayList<Integer>(Arrays.asList(0, Integer.MIN_VALUE));}
		
		List<Integer> leftMSA = findMaxPath(tree.left); // left max sum array
		Integer leftMSB = leftMSA.get(0); // left max sum branch 
		Integer leftMPS = leftMSA.get(1); // left max path sum 
		List<Integer> rightMSA = findMaxPath(tree.right);// right max sum array
		Integer rightMSB = rightMSA.get(0);// right max sum branch
	  Integer rightMPS = rightMSA.get(1); // right max path sum 
		// max child sum branch 
		Integer MCSB = Math.max(leftMSB, rightMSB);
		// max sum branch
		Integer MSB = Math.max(MCSB + tree.value, tree.value);
		Integer MPSroot= Math.max(MSB,leftMSB+rightMSB+tree.value);
		// max path sum 
		int MPS = Math.max(leftMPS, Math.max(rightMPS, MPSroot));
		return new  ArrayList<Integer> (Arrays.asList(MSB, MPS));
	}
  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
