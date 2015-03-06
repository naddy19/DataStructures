/**
 * 
 */
package com.gm.lists.doubly;

import com.gm.util.MenuItems;
import com.gm.util.Utility;

/**
 * @author Aliza
 * 
 */
public class LinkedList {
  private static final String THE_LIST_IS_EMPTY = "The list is empty!!";
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    Node start = null;
    int selectedOption = -1;
    MenuItems selectedMenu = null;
    do {
      System.out.println("Singly Linked List Program. Please select the desired option");
      for (MenuItems menu : MenuItems.values()) {
        System.out.println((menu.ordinal() + 1) + " " + menu);
      }
      
      selectedOption = Utility.readInteger();
      System.out.println();
      selectedMenu = MenuItems.values()[selectedOption - 1];
      
      switch (selectedMenu) {
      case ADD:
        int enteredValue = -1;
        System.out.println("Please enter the value to be inserted. Enter -1 to end");
        do {
          enteredValue = Utility.readInteger();
          if (enteredValue == Integer.MIN_VALUE) {
            System.out.println("Please enter a valid integer value");
            continue;
          }
          if (enteredValue != -1) {
            start = linkedList.addElement(start, enteredValue);
            System.out.println(enteredValue + " added to the list");
          }
        } while (enteredValue != -1);
        break;
      case PRINT:
        linkedList.printList(start);
        break;
      case DELETE:
        System.out.println("Please enter the element to be deleted: ");
        int value = Utility.readInteger();
        System.out.println();
        start = linkedList.deleteElement(start, value);
        break;
      case SEARCH:
        System.out.print("Please enter the element to be searched: ");
        value = Utility.readInteger();
        System.out.println();
        int position = linkedList.searchElement(start, value);
        if (position != -1) {
          System.out.println("The element is found at the location: " + (position + 1));
        } else {
          System.out.println("The element is not found");
        }
        break;
      case LENGTH:
        System.out.println("List length: " + linkedList.listLength(start));
        break;
      case EXIT:
        System.out.println("Good Bye!!!");
        break;
      case SORT:
        start = linkedList.sort(start);
        System.out.println("The list is sorted");
        break;
      case REVERSE:
        start = linkedList.reverse(start);
        System.out.println("Reverse");
        break;
      default:
        System.out.println("Please select a valid operation.");
        break;
      }
    } while (!MenuItems.EXIT.equals(selectedMenu));
  }
  
  public Node addElement(Node start, int value) {
    if (start == null) {
      start = new Node();
      start.setValue(value);
      start.setNextNode(null);
      start.setPrevNode(null);
      return start;
    }
    
    Node current = start;
    while (current.getNextNode() != null) {
      current = current.getNextNode();
    }
    Node newNode = new Node();
    newNode.setValue(value);
    newNode.setNextNode(null);
    newNode.setPrevNode(current);
    current.setNextNode(newNode);
    
    return start;
  }
  
  public void printList(Node start) {
    Node currentNode = start;
    System.out.print("[");
    while (currentNode.getNextNode() != null) {
      System.out.println(currentNode.getValue() + ", ");
      currentNode = currentNode.getNextNode();
    }
    System.out.println(currentNode.getValue() + "]");
  }
  
  public void printReverseList(Node start) {
    Node currentNode = start;
    while (currentNode.getNextNode() != null) {
      currentNode = currentNode.getNextNode();
    }
    System.out.print("[");
    while (currentNode.getPrevNode() != start) {
      System.out.println(currentNode.getValue() + ", ");
      currentNode = currentNode.getPrevNode();
    }
    System.out.println(currentNode.getValue() + "]");
  }
  
  public int searchElement(Node start, int value) {
    int i = 0;
    Node currentNode = start;
    if (start == null) {
      return -1;
    }
    
    while (currentNode != null) {
      if (currentNode.getValue() == value) {
        return i;
      }
      i++;
      currentNode = currentNode.getNextNode();
    }
    return -1;
  }
  
  public Node deleteElement(Node start, int value) {
    if (start == null) {
      System.out.println(THE_LIST_IS_EMPTY);
      return start;
    }
    
    if (start.getNextNode() == null && start.getValue() == value) {
      start = null;
      return null;
    }
    
    Node currentNode = start;
    while (currentNode != null) {
      currentNode = currentNode.getNextNode();
    }
    return start;
  }
  
  public int listLength(Node start) {
    return 0;
  }
  
  public Node reverse(Node start) {
    return start;
  }
  
  public Node sort(Node start) {
    return start;
  }
}
