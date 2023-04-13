package binpacking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout;

public class ExampleTests {

  /**
   * Tell JUnit to fails tests that take 8+ seconds.
   *
   * <p><b>WARNING:</b> The time limit used by the auto-marker may be different,
   * or vary from test to test.
   */
  @Rule
  public final Timeout globalTimeout = new Timeout(8 * 1000);

  // A MyBinSTree used in the tests.
  private MyBinSTree binSTree;

  // A MyBinPacker used in the tests.
  private MyBinPacker binPacker;

  /**
   * This function is run before every test, letting us use a brand new
   * {@link MyBinSTree} and {@link MyBinPacker} each time.
   *
   * <p>This works because JUnit "sees" the <code>@Before</code> annotation.
   */
  @Before
  public void setUp() {
    binSTree = new MyBinSTree();
    binPacker = new MyBinPacker();
  }

  @Test
  public void testInsertion_increasingOrder() {
    binSTree.addNode(new BinData(5,1));
    assertEquals(1, binSTree.size());
    assertEquals(1, binSTree.height());

    binSTree.addNode(new BinData(5,2));
    assertEquals(2, binSTree.size());
    assertEquals(2, binSTree.height());

    binSTree.addNode(new BinData(6,0));
    assertEquals(3, binSTree.size());
    assertEquals(3, binSTree.height());

    binSTree.addNode(new BinData(7,3));
    assertEquals(4, binSTree.size());
    assertEquals(4, binSTree.height());

    assertEquals(
        new BinData(7, 3), // expected value for bottom-right node
        binSTree.getRootNode()
          .getRightChild()
          .getRightChild()
          .getRightChild()
          .getBinData());
  }

  @Test
  public void testBestFit_exampleFromAssignmentPDF() {
    // TODO
  }
}
