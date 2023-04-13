package binpacking;

import static binpacking.Internals.*;

/**
 * The class for the nodes.
 *
 * The `IsABinSTreeNode&lt;...&gt;` text helps the tests understand that they
 * can call getLeftChild() and getLeftChild() safely.
 */
public class MyBinSTreeNode
  implements IsABinSTreeNode<MyBinSTreeNode> {

  /**
   * INVARIANT:
   * <li>this node's getBinData().capacity is at least as big as (&ge;)
   *      the capacity of all children and descendants on the left.</li>
   * <li>this node's getBinData().capacity is no bigger than (&le;)
   *      the capacity of all children and descendants on the right.</li>
   */
  public BinData getBinData() {
    // TODO: implement this!
    return null;
  }

  // returns null if no such child
  public MyBinSTreeNode getLeftChild() {
    // TODO: implement this!
    return null;
  }

  // returns null if no such child
  public MyBinSTreeNode getRightChild() {
    // TODO: implement this!
    return null;
  }
}
