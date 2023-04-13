package binpacking;

import static binpacking.Internals.IsABinSTreeNode;
import static binpacking.Internals.WithNodeType;
import static binpacking.Internals.WithRebalanceFunction;

public interface BinSTreeIntf {
  public int size();
  public int height();

  public void addNode(BinData binData);

  // returns null on failure
  // no deletion
  public BinData getSmallestBinWithMinCapacity(int minCapacity);

  // returns null on failure
  // deletes the node it finds
  public BinData popSmallestBinWithMinCapacity(int minCapacity);

}
