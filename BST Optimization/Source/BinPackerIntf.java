package binpacking;

import java.util.List;
import java.util.function.Supplier;

public interface BinPackerIntf {
  public List<Integer> packWithBestFit(int emptyBinCapacity, List<Integer> itemSizes);
  public List<Integer> packWithBestFit_partialMarks(int emptyBinCapacity, List<Integer> itemSizes, Supplier<BinSTreeIntf> binTreeSupplier);
}
