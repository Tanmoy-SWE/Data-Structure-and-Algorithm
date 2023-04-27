package binpacking;

import java.util.List;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.List;
public class MyBinPacker implements BinPackerIntf {

  /**
   * <b>Don't delete this function.</b> The tests will use it.
   */
  public MyBinPacker() {
    // TODO: implement this!
  }

  /**
   * Implements the 'best-fit' bin packing algorithm (see the assignment spec).
   *
   * <p>
   * <ul>
   * <li>Initially, there are no bins in use.</li>
   * <li>
   *   Go through <code>itemSizes</code> in order.
   *   For each item:
   *   <ul>
   *     <li>Let <code>s =</code> this item's size.</li>
   *     <li>
   *       Check if there are any bins with <code>bin.capacity &ge; s</code>.
   *     </li>
   *     <li>
   *       <b>If</b> there are no bins that can fit the item,
   *       create a new bin with ID = (# bins in use), and
   *       capacity = <code>emptyBinCapacity</code>.
   *       <p>
   *       <i>(Note: the first bin we create will have ID of 0, then 1, 2, ..., etc.)</i>
   *       <p>
   *       Then update that bin, so that <b>b.capacity -= s</b>.
   *     </li>
   *     <li>
   *       <b>Otherwise,</b> some bins can fit the item.
   *       Pick the bin with smallest capacity that can still fit
   *         the item. (If there's a tie, pick the smallest ID.)
   *       <p>
   *       Then update that bin, so that <b>b.capacity -= s</b>.
   *     </li>
   *   </ul>
   * </li>
   * </ul>
   * </p>
   *
   * <b>PRECONDITION:</b>
   * <ul>
   * <li>
   *   <code>emptyBinCapacity &ge; 0</code>
   * </li>
   * <li>
   *   All values in <code>itemSizes</code> are between
   *   0 and <code>emptyBinCapacity</code>, inclusive.
   *   <p>
   *   (In other words,
   *     for all <code>i</code> such that <code>0 &le; i &lt; itemSizes.size()</code>,
   *     we have
   *     <code>0 &le; itemSizes.get(i) &le; emptyBinCapacity</code>.)
   * </li>
   * </ul>
   *
   * @param   emptyBinCapacity  The starting capacity of a new bin, before
   *                              any items are placed inside.
   * @param   itemSizes         The items to be packed, given in the order that
   *                              the algorithm should process them.
   *
   * @return  a list of bin IDs, with the same length as <code>itemSizes</code>.
   *          The value at index <code>i</code> is the ID of the bin
   *          used for the item at index <code>i</code>.
   */
  @Override
  public List<Integer> packWithBestFit(int emptyBinCapacity, List<Integer> itemSizes) {
    List<Integer> binIds = new ArrayList<>();
    List<Bin> bins = new ArrayList<>();
    for (int size : itemSizes) {
      Bin bestBin = null;
      for (Bin bin : bins) {
        if (bin.capacity >= size && (bestBin == null || bin.capacity < bestBin.capacity)) {
          bestBin = bin;
        }
      }
      if (bestBin == null) {
        bestBin = new Bin(bins.size(), emptyBinCapacity);
        bins.add(bestBin);
      }
      bestBin.addItem(size);
      binIds.add(bestBin.id);
    }
    return binIds;
  }

  private static class Bin {
    private final int id;
    private int capacity;
    private final List<Integer> items;

    public Bin(int id, int capacity) {
      this.id = id;
      this.capacity = capacity;
      this.items = new ArrayList<>();
    }

    public void addItem(int size) {
      capacity -= size;
      items.add(size);
    }
  }

  /**
   * (OPTIONAL)
   * An alternative version of {@link #packWithBestFit(int, List<Integer>)} which
   * scores fewer marks.
   *
   * <p>
   * If you're having trouble coding a working binary tree, use this instead.
   * Otherwise, just leave this alone.
   *
   * <p>
   * PRECONDITION: <code>binTreeSupplier.get()</code> returns a working implementation of {@link BinSTreeIntf}.
   * ...and all the other preconditions for {@link #packWithBestFit(int, List<Integer>)}.
   *
   * <p>
   * POSTCONDITION: same as {@link #packWithBestFit(int, List<Integer>)}.
   */
  public List<Integer> packWithBestFit_partialMarks(
          int emptyBinCapacity,
          List<Integer> itemSizes,
          Supplier<BinSTreeIntf> binTreeSupplier
  ) {
    /**
     * Here's some code that uses the binTreeSupplier:
     */
    // BinSTreeIntf binTree = binTreeSupplier.get();
    // binTree.addNode(new BinData(10, 0));
    // binTree.addNode(new BinData(6, 2));
    // binTree.addNode(new BinData(8, 3));
    // binTree.addNode(new BinData(6, 1));
    // for (int capacity = 5; capacity <= 11; capacity++) {
    //   System.out.println(
    //      "The best bin for capacity " + capacity
    //      + " is " + binTree.getSmallestBinWithMinCapacity(capacity));
    // }
    // BinData aBin = binTree.popSmallestBinWithMinCapacity(9);

    /**
     * ...but if we've already implemented MyBinSTree, we don't need to use
     * <code>binTreeSupplier</code> at all!
     *
     * Instead, we can just go...
     */
    return packWithBestFit(emptyBinCapacity, itemSizes);
  }
}
