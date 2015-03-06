package com.gm.lists.doubly;

/**
 * Denotes a single node of the Linked List. It stores the value, the next node
 * pointer and the previous node pointer.
 * 
 * @author Aliza
 */
public class Node {
  private int value;
  private Node nextNode;
  private Node prevNode;
  
  public Node getPrevNode() {
    return prevNode;
  }
  
  public void setPrevNode(Node prevNode) {
    this.prevNode = prevNode;
  }
  
  public int getValue() {
    return value;
  }
  
  public void setValue(int value) {
    this.value = value;
  }
  
  public Node getNextNode() {
    return nextNode;
  }
  
  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
  }
}
