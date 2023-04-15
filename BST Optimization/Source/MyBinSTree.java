package binpacking;

import static binpacking.Internals.*;

public class MyBinSTree implements
        BinSTreeIntf,
        WithNodeType<MyBinSTreeNode>,
        WithRebalanceFunction {

  /**
   * <b>Don't delete this function.</b> The tests will use it.
   */
  private MyBinSTreeNode root;
  private int size;

  public MyBinSTree() {
    this.root = null;
    this.size = 0;
  }

  public int size() {
    return this.size;
  }

  public int height() {
    if (this.root == null) {
      return 0;
    } else {
      return this.root.getheight();
    }
  }


  public MyBinSTreeNode getRootNode() {
    return this.root;
  }

  public void addNode(BinData binData) {
    MyBinSTreeNode newNode = new MyBinSTreeNode(binData);
    if (this.root == null) {
      this.root = newNode;
    } else {
      this.root = this.root.addNode(newNode);
    }
    this.size++;
  }

  public BinData getSmallestBinWithMinCapacity(int minCapacity) {
    if (this.root == null) {
      return null;
    } else {
      MyBinSTreeNode node = this.root.findSmallestBinWithMinCapacity(minCapacity);
      if (node == null) {
        return null;
      } else {
        return node.getBinData();
      }
    }
  }

  public BinData popSmallestBinWithMinCapacity(int minCapacity) {
    if (this.root == null) {
      return null;
    } else {
      MyBinSTreeNode[] result = this.root.popSmallestBinWithMinCapacity(minCapacity);
      this.root = result[0];
      this.size--;
      return result[1] != null ? result[1].getBinData() : null;
    }
  }

  public void rebalance() {
    if (this.root == null) {
      return;
    } else {
      this.root = this.root.rebalance();
    }
  }
}
