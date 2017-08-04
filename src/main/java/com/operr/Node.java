package com.operr;

/**
 * A Node object implementation to hold data in a SingleLinkedList.
 *
 * @author ThangTQ
 * @version 1.0.0 Aug 04, 2017
 */

public class Node<T extends Comparable>{
    private Node<T> next;   // Points to the next Node
    private T data;         // Holds data to be stored in Node

    /**
     * Create a new Node with empty data and no next Node.
     */
    public Node() {
        this(null, null);
    }

    /**
     * Create a new Node with input data.
     *
     * @param inputData - data of the Node to be stored
     */
    public Node(T inputData) {
        this(inputData, null);
    }

    /**
     * Create a new Node with input data at the index.
     *
     * @param inputData - data of the Node to be stored
     * @param inputNext - next Node to be related to
     */
    public Node(T inputData, Node<T> inputNext) {
        this.next = inputNext;
        this.data = inputData;
    }

    /**
     * Retrieve data of a current Node.
     *
     * @return data - data of the stored Node
     */
    public T getData() {
        return this.data;
    }

    /**
     * Set new data to a Node.
     *
     * @param inputData - data be stored the Node
     */
    public void setData(T inputData) {
        this.data = inputData;
    }

    /**
     * Return the Node in the next sequence.
     *
     * @return next - a next Node
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * Set a next Node.
     *
     * @param inputNode - a next Node to be stored
     */
    public void setNext(Node<T> inputNode) {
        this.next = inputNode;
    }

    /**
     * Comparing value of this Node with an input data Node
     *
     * @param inputData - Node to be compare
     */
    public boolean isGreaterThan(T inputData) {
        if(this.data.compareTo(inputData)>0) return true;
        else return false;
    }

}