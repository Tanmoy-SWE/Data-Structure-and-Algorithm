package binpacking;

import java.util.ArrayList;
import java.util.Collections;

import static binpacking.Internals.*;

public class MyBinSTree implements
        BinSTreeIntf,
        WithNodeType<MyBinSTreeNode>,
        WithRebalanceFunction {

  private MyBinSTreeNode rootNode;
  private int size;

  public MyBinSTree() {
    rootNode = null;
    size = 0;
  }

  public int size() {
    return size;
  }

  public int height() {
    return height(rootNode);
  }

  private int height(MyBinSTreeNode node) {
    if (node == null) {
      return 0;
    } else {
      int leftHeight = height(node.getLeftChild());
      int rightHeight = height(node.getRightChild());
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }


  public MyBinSTreeNode getRootNode() {
    return rootNode;
  }

  public void addNode(BinData binData) {
    rootNode = addNode(rootNode, binData);
    size++;
  }

  private MyBinSTreeNode addNode(MyBinSTreeNode node, BinData binData) {
    // If the node is null, create a new node and return it
    if (node == null) {
      return new MyBinSTreeNode(binData);
    }
    // If the bin data's capacity is less than or equal to the node's capacity, add it to the left subtree
    else if (binData.capacity < node.getBinData().capacity) {
      System.out.println("Added left");
      node.setLeftChild(addNode(node.getLeftChild(), binData));
    }
    // If the bin data's capacity is greater than the node's capacity, add it to the right subtree
    else {
      System.out.println("Added right");
      node.setRightChild(addNode(node.getRightChild(), binData));
    }
    // Rebalance the tree if necessary
    rebalance();
    return node;
  }


  public BinData getSmallestBinWithMinCapacity(int minCapacity) {
    return getSmallestBinWithMinCapacity(rootNode, minCapacity);
  }

  private BinData getSmallestBinWithMinCapacity(MyBinSTreeNode node, int minCapacity) {
    // Return null if the node is null
    if (node == null) {
      return null;
    }
    // If the node's capacity is less than the minimum capacity, check the right subtree
    else if (node.getBinData().capacity < minCapacity) {
      return getSmallestBinWithMinCapacity(node.getRightChild(), minCapacity);
    }
    // If the node's capacity is greater than or equal to the minimum capacity, check the left subtree
    else {
      BinData leftBinData = getSmallestBinWithMinCapacity(node.getLeftChild(), minCapacity);
      // Return the left node's bin data if it exists and has a capacity greater than or equal to the minimum capacity
      if (leftBinData != null && leftBinData.capacity >= minCapacity) {
        return leftBinData;
      }
      // Otherwise, return the current node's bin data
      else {
        return node.getBinData();
      }
    }
  }

  public BinData popSmallestBinWithMinCapacity(int minCapacity) {
    // Find the bin data to remove
    BinData binDataToRemove = getSmallestBinWithMinCapacity(minCapacity);
    // If the bin data does not exist, return null
    if (binDataToRemove == null) {
      return null;
    }
    // Remove the bin data from the tree and return it
    else {
      rootNode = removeNode(rootNode, binDataToRemove);
      size--;
      return binDataToRemove;
    }
  }

  private MyBinSTreeNode removeNode(MyBinSTreeNode node, BinData binDataToRemove) {
    // If the node is null, return null
    if (node == null) {
      return null;
    }
    // If the bin data to remove is in the left subtree, remove it and update the left child
    if (binDataToRemove.capacity < node.getBinData().capacity) {
      node.setLeftChild(removeNode(node.getLeftChild(), binDataToRemove));
      return node;
    }
    // If the bin data to remove is in the right subtree, remove it and update the right child
    else if (binDataToRemove.capacity > node.getBinData().capacity) {
      node.setRightChild(removeNode(node.getRightChild(), binDataToRemove));
      return node;
    }
    // If the current node has the bin data to remove, remove it and update the tree
    else {
      // If the node has no children, return null
      if (node.getLeftChild() == null && node.getRightChild() == null) {
        return null;
      }
      // If the node has only a left child, return the left child
      else if (node.getLeftChild() != null && node.getRightChild() == null) {
        return node.getLeftChild();
      }
      // If the node has only a right child, return the right child
      else if (node.getRightChild() != null && node.getLeftChild() == null) {
        return node.getRightChild();
      }
      // If the node has both left and right children, find the minimum node in the right subtree and replace the current node with it
      else {
        MyBinSTreeNode minNode = findMinNode(node.getRightChild());
        node.setBinData(minNode.getBinData());
        node.setRightChild(removeNode(node.getRightChild(), minNode.getBinData()));
        return node;
      }
    }
  }

  private MyBinSTreeNode findMinNode(MyBinSTreeNode node) {
    while (node.getLeftChild() != null) {
      node = node.getLeftChild();
    }
    return node;
  }

  public void rebalance() {
    ArrayList<BinData> binDataList = new ArrayList<BinData>();
    getBinDataList(rootNode, binDataList);
    rootNode = balance(binDataList, 0, binDataList.size() - 1);
  }

  private void getBinDataList(MyBinSTreeNode node, ArrayList<BinData> binDataList) {
    if (node == null) {
      return;
    }
    getBinDataList(node.getLeftChild(), binDataList);
    binDataList.add(node.getBinData());
    getBinDataList(node.getRightChild(), binDataList);
  }

  private MyBinSTreeNode balance(ArrayList<BinData> binDataList, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    MyBinSTreeNode node = new MyBinSTreeNode(binDataList.get(mid));
    node.setLeftChild(balance(binDataList, start, mid - 1));
    node.setRightChild(balance(binDataList, mid + 1, end));
    return node;
  }
}
