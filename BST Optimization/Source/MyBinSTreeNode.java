package binpacking;

import static binpacking.Internals.*;

/**
 * The class for the nodes.
 *
 * The `IsABinSTreeNode&lt;...&gt;` text helps the tests understand that they
 * can call getLeftChild() and getLeftChild() safely.
 */
public class MyBinSTreeNode implements IsABinSTreeNode<MyBinSTreeNode> {
    private BinData binData;
    private MyBinSTreeNode leftChild;
    private MyBinSTreeNode rightChild;

  /**
   * INVARIANT:
   * <li>this node's getBinData().capacity is at least as big as (&ge;)
   *      the capacity of all children and descendants on the left.</li>
   * <li>this node's getBinData().capacity is no bigger than (&le;)
   *      the capacity of all children and descendants on the right.</li>
   */

  public MyBinSTreeNode(BinData binData) {
      this.binData = binData;
  }
  public BinData getBinData() {
    // TODO: implement this!
    return binData;
  }

  public void setLeftChild(MyBinSTreeNode leftChild) {
        this.leftChild = leftChild;
  }
  // returns null if no such child
  public MyBinSTreeNode getLeftChild() {
    // TODO: implement this!
    return leftChild;
  }

  public void setRightChild(MyBinSTreeNode rightChild) {
        this.rightChild = rightChild;
  }
  // returns null if no such child
  public MyBinSTreeNode getRightChild() {
    // TODO: implement this!
    return rightChild;
  }

  //function to calculate larger number
    public int max(int a, int b){
      if(a>b){
          return a;
      }
      return b;
    }
  public int height(MyBinSTreeNode node) {
      if (node == null) {
          return 0;
      } else {
          int leftHeight = height(node.getLeftChild());
          int rightHeight = height(node.getRightChild());
          return Math.max(leftHeight, rightHeight) + 1;
      }
  }

    // fuction to calculate the height/ level of tree
    public int getheight(){
      return height(this);
    }
}
