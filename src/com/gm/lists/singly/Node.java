package com.gm.lists.singly;

/**
 * Denotes a single node of the Linked List. It stores the value and the next
 * node pointer.
 * 
 * @author Aliza
 */
public class Node{
  private int value;
  private Node nextNode;
  
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
