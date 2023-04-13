/**
 * <p><b>Warning:</b> Don't modify this file!
 * If you do, your changes will be <i>overwritten</i> during grading.
 */

package binpacking;

/**
 * A class containing information about a bin:
 * a unique 'ID' number, and the bin's capacity.
 */
public final class BinData {
  public final int capacity, binId;

  // constructor
  public BinData(int capacity, int binId) {
    this.capacity = capacity;
    this.binId = binId;
  }

  /**
   * <b>You can ignore this.</b>
   *
   * <p>
   * A <code>toString()</code> method, in case we need it for debugging.
   */
  @Override
  public String toString() {
    return "(capacity: " + capacity + ", binId:" + binId + ")";
  }

  /**
   * <b>You can ignore this.</b>
   *
   * <p>
   * An <code>equals()</code> method, to help make <code>assertEquals()</code>
   * work in tests.
   */
  @Override
  public boolean equals(Object obj) {
      if (obj == this) {
          return true;
      }

      if (!(obj instanceof BinData)) {
          return false;
      }

      BinData that = (BinData) obj;

      return this.capacity == that.capacity //
          && this.binId == that.binId;
  }
}
