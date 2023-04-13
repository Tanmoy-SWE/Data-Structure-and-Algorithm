/**
 * <p><b>Warning:</b> Don't modify this file!
 * If you do, your changes will be <i>overwritten</i> during grading.
 */

package binpacking;

/**
 * Everything here is meant to make sure tests work smoothly.
 *
 * Ideally, you shouldn't need to look at this file too closely.
 */
public class Internals {

  public static interface IsABinSTreeNode<N extends IsABinSTreeNode<N> > {
    BinData getBinData();

    // returns null if no such child
    N getLeftChild();
    // returns null if no such child
    N getRightChild();
  }

  public static interface WithNodeType<N extends IsABinSTreeNode<N> > {
    N getRootNode();
  }

  public static interface WithRebalanceFunction extends BinSTreeIntf {
    void rebalance();
  }

}
