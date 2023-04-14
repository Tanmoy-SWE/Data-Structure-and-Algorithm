package binpacking;

import static binpacking.Internals.*;

public class MyBinSTree implements
  BinSTreeIntf,
  WithNodeType<MyBinSTreeNode>,
  WithRebalanceFunction {

  /**
   * <b>Don't delete this function.</b> The tests will use it.
   */
  public MyBinSTree() {
    // TODO: implement this!
    //    if node == NULL
//    return createNode(data)
//    if (data < node->data)
//      node->left  = insert(node->left, data);
//    else if (data > node->data)
//      node->right = insert(node->right, data);
  }

  public int size() {
    // TODO: implement this!
    return 0;
  }
  public int height() {
    // TODO: implement this!
    return 0;
  }

  public MyBinSTreeNode getRootNode() {
    // TODO: implement this!
    return null;
  }

  public void addNode(BinData binData) {
    // TODO: implement this!
  }

  public BinData getSmallestBinWithMinCapacity(int minCapacity) {
    // TODO: implement this!
    return null;
  }

  public BinData popSmallestBinWithMinCapacity(int minCapacity) {
    // TODO: implement this!
    return null;
  }

  public void rebalance() {
    // TODO: implement this!
  }
}
