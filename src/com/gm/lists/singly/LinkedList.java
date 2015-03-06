package com.gm.lists.singly;

import com.gm.util.MenuItems;
import com.gm.util.Utility;

/**
 * This class has the implementation of the various operations of the linked
 * list.
 * 
 * @author Aliza
 */
public class LinkedList{
  private static final String THE_LIST_IS_EMPTY = "The list is empty!!";
  
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
    Node current = null;
    /*
     * If the list is empty and you are trying to add elements to it, then we
     * are creating a node and then adding it to the list.
     */
    if (start == null) {
      current = new Node();
      current.setValue(value);
      current.setNextNode(null);
      return current;
    }
    
    /*
     * If the list already has element in it, then we are traversing to the end
     * of the list and then adding a new node to it
     */
    current = start;
    while (current.getNextNode() != null) {
      current = current.getNextNode();
    }
    Node nextNode = new Node();
    nextNode.setNextNode(null);
    nextNode.setValue(value);
    current.setNextNode(nextNode);
    return start;
  }
  
  public void printList(Node start) {
    if (start == null) {
      System.out.println(THE_LIST_IS_EMPTY);
    } else {
      Node current = start;
      System.out.print("Printing the list:");
      System.out.print("[ ");
      while (current.getNextNode() != null) {
        System.out.print(current.getValue() + ", ");
        current = current.getNextNode();
      }
      System.out.println(current.getValue() + " ]");
    }
  }
  
  public int searchElement(Node start, int value) {
    if (start == null) {
      return -1;
    }
    Node currentNode = start;
    int i = 0;
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
      return null;
    }
    if (start.getNextNode() == null && start.getValue() == value) {
      start = null;
      System.out.println("Element " + value + " is deleted!!");
      return start;
    }
    Node currNode = start;
    Node prevNode = start;
    while (currNode != null) {
      if (start.getValue() == value) {
        System.out.println("Element " + value + " is deleted!!");
        return start.getNextNode();
      }
      if (currNode.getValue() == value) {
        prevNode.setNextNode(currNode.getNextNode());
        currNode.setNextNode(null);
        System.out.println("Element " + value + " is deleted!!");
        return start;
      }
      prevNode = currNode;
      currNode = currNode.getNextNode();
    }
    System.out.println("Element " + value + " is not found!!");
    return start;
  }
  
  public int listLength(Node start) {
    if (start == null) {
      return 0;
    }
    
    Node current = start;
    int length = 0;
    while (current != null) {
      length++;
      current = current.getNextNode();
    }
    return length;
  }
  
  public Node reverse(Node start) {
    if (start == null) {
      System.out.println(THE_LIST_IS_EMPTY);
      return null;
    }
    if (start.getNextNode() == null) {
      return start;
    }
    
    Node outer = start;
    Node reversedList = start;
    Node prevNode = start;
    outer = outer.getNextNode();
    reversedList.setNextNode(null);
    
    while (outer != null) {
      prevNode = outer;
      outer = outer.getNextNode();
      prevNode.setNextNode(reversedList);
      reversedList = prevNode;
    }
    return reversedList;
  }
  
  public Node sort(Node start) {
    if (start == null) {
      System.out.println(THE_LIST_IS_EMPTY);
      return null;
    }
    if (start.getNextNode() == null) {
      return start;
    }
    
    Node outer = start;
    while (outer != null) {
      Node inner = outer.getNextNode();
      while (inner != null) {
        if (outer.getValue() > inner.getValue()) {
          int temp = outer.getValue();
          outer.setValue(inner.getValue());
          inner.setValue(temp);
        }
        inner = inner.getNextNode();
      }
      outer = outer.getNextNode();
    }
    return start;
  }
}
