package com.operr;

/**
 * A <code>SingleLinkedList</code> implementation that uses the Node class.
 *
 * @author ThangTQ
 * @version 1.0.0 Aug 04, 2017
 */

public class SingleLinkedList<T extends Comparable> {

    protected Node<T> head;      // First node
    protected Node<T> tail;      // Last node
    protected int listSize;      // Size of SingleLinkedList

    /**
     * Default constructor for SingleLinkedList.
     * <p>
     * initializing head and tail node to null.
     * ListSize is zero.
     */
    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.listSize = 0;
    }

    /**
     * Output SingleLinkedList in String format.
     */
    public String toString() {
        Node<T> currentNode = this.head;
        StringBuilder output = new StringBuilder();
        output.append("SingleLinkedList{size:"+size()+"; nodes:");
        while (currentNode != null) {
            output.append("[");
            output.append(currentNode.getData());
            output.append("]");
            currentNode = currentNode.getNext();
        }
        output.append("}\n");
        return output.toString();
    }

    /**
     * Return the number of Nodes in our SingleLinkedList.
     */
    public int size() {
        return this.listSize;
    }

    /**
     * Return true if SingleLinkedList is empty.
     *
     * @return true if no Nodes in SingleLinkedList.
     */
    private boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Clears the list - all the Nodes are to be removed.
     * <p>
     *
     * @return head element of the list.
     */
    public T clear() {
        T headData = this.get(1);
        head = null;
        tail = null;
        listSize = 0;
        return headData;
    }

    /**
     * Add a node with data to end of SingleLinkedList.
     *
     * @param data - data of the node to be stored
     */
    public void addToTail(T data) {

        Node<T> newNode = new Node<>(data);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = head;
        } else {
            (this.tail).setNext(newNode);
            this.tail = newNode;
        }
        this.listSize++;
    }

    /**
     * Add a new node with data to front of SingleLinkedList.
     *
     * @param data - data of the node to be stored
     */
    public void addToHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = head;
        } else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.listSize++;
    }

    /**
     * Add a node with data after a specific index.
     * <p>
     * @param data  - data of the node to be stored
     * @param index - at point which to add data
     */
    public void addAfterIndex(T data, int index) {

        if (index <= 0) {
            this.addToHead(data);
        } else if (index >= this.size()) {
            this.addToTail(data);
        } else {

            Node<T> newNode = new Node<>(data);

            // go to the Node that which is to be inserted after
            Node<T> targetNode = this.head;

            for (int i = 1; i < index; i++) {
                targetNode = targetNode.getNext();
            }

            newNode.setNext(targetNode.getNext());
            targetNode.setNext(newNode);
            this.listSize++;

        }
    }

    /**
     * Returns data of the node at the specified position of SingleLinkedList.
     *
     * @param index - index of a node to retrieve.
     * @return data of the node at that index.
     */
    public T get(int index) {
        if (index <= 0 || index > size()) {
            throw new IndexOutOfBoundsException("index should be >=1 and < size of the list.");
        }
        Node<T> currentNode = this.head;
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    /**
     * Returns node at the specified position of SingleLinkedList.
     *
     * @param index - index of node to retrieve.
     * @return node at that index.
     */
    public Node<T> getNode(int index) {
        if (index <= 0 || index > size()) {
            throw new IndexOutOfBoundsException("index should be >=1 and < size of the list.");
        }

        Node<T> currentNode = this.head;
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    /**
     * Remove from the end-tail of SingleLinkedList.
     *
     * @return data of the tail Node.
     */
    public T removeTail() {

        if (this.isEmpty()) {
            return null;
        } else if (this.size() == 1) {
            return this.clear();
        } else {

            Node<T> previousNode = this.head;
            for (int i = 1; i < size() - 1; i++) {
                previousNode = previousNode.getNext();
            }

            T returnData = get(this.size());
            previousNode.setNext(null);
            this.tail = previousNode;

            listSize--;
            return returnData;
        }
    }

    /**
     * Remove from the head node of the SingleLinkedList.
     *
     * @return data of the head node.
     */
    public T removeHead() {
        if (isEmpty()) {
            return null;
        } else if (size() == 1) {
            return clear();
        } else {
            T headData = get(1);
            this.head = head.getNext();
            this.listSize--;
            return headData;
        }
    }

    /**
     * Remove from a specified node index in SingleLinkedList.
     *
     * @return data the specified node index.
     */
    public T removeAtIndex(int index) {
        if (index <= 1) {
            return removeHead();
        } else if (index >= size()) {
            return removeTail();
        } else {
            Node<T> previousNode = this.head;

            // Reaches to the previous of the node we  want to remove
            for (int i = 1; i < index - 1; i++) {
                previousNode = previousNode.getNext();
            }
            T nodeData = previousNode.getNext().getData();
            previousNode.setNext(previousNode.getNext().getNext());
            listSize--;
            return nodeData;
        }
    }

    /**
     * Remove from a specified node index in SingleLinkedList.
     *
     * @return data contained at the node index.
     */
    public String removeElementsGreaterThanValue(T data) {

        StringBuilder output = new StringBuilder();
        Node<T> currentNode=null;
        for (int index = 1; index <= listSize; index++) {
            currentNode = getNode(index);
            if(currentNode.isGreaterThan(data)){
                output.append("[");
                output.append(currentNode.getData());
                output.append("]");
                removeAtIndex(index);
                index=0;
            }
        }
        return output.toString();
    }

    /**
     * inserting an array elements for testing.
     * @param testInput array of the nodes to be stored
     */
    public void insert(T[] testInput) {

        for (int i = 0; i < testInput.length; i++) {
            this.addToTail(testInput[i]);
        }

    }


}