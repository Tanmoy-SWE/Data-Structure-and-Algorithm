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
        return binData;
    }
    public void setBinData(BinData binData) {
        this.binData = binData;
    }

    public MyBinSTreeNode getLeftChild() {
        return leftChild;
    }

    public MyBinSTreeNode getRightChild() {
        return rightChild;
    }

    /**
     * Set the left child of this node, and update the invariant.
     */
    public void setLeftChild(MyBinSTreeNode leftChild) {
        this.leftChild = leftChild;
        updateInvariant();
    }

    /**
     * Set the right child of this node, and update the invariant.
     */
    public void setRightChild(MyBinSTreeNode rightChild) {
        this.rightChild = rightChild;
        updateInvariant();
    }

    /**
     * Update the invariant for this node, and recursively for all its
     * descendants.
     */
    private void updateInvariant() {
        // Check the invariant for the left child.
        if (leftChild != null && binData.capacity < leftChild.binData.capacity) {
            throw new RuntimeException("Invariant violation: left child has greater capacity");
        }
        // Check the invariant for the right child.
        if (rightChild != null && binData.capacity > rightChild.binData.capacity) {
            throw new RuntimeException("Invariant violation: right child has lesser capacity");
        }
        // Recursively update the invariant for all descendants.
        if (leftChild != null) {
            leftChild.updateInvariant();
        }
        if (rightChild != null) {
            rightChild.updateInvariant();
        }
    }
}
