package com.gourmet.util;

public class Node {

	// Value of the node
    private String data;
    
    // Left child of this node 
    private Node leftChild;
    
    // Right child of this node
    private Node rightChild;

    // Define the data of this node in the constructor
    public Node(String data) {

        this.data = data;

    }

    // To check if the given node is leaf
    public boolean isLeaf() {

        return leftChild == null && rightChild == null;

    }

    // Set the data to the current NODE
    public void setData(String data) {

        this.data = data;

    }

    // Get the data from the current NODE
    public String getData() {

        return this.data;

    }

    // Set the left child of this NODE
    public void setLeftChild(Node leftChild) {

        this.leftChild = leftChild;

    }

    // Get left child of this NODE
    public Node getLeftChild() {

        return leftChild;

    }

    // Set right child of this NODE
    public void setRightChild(Node rightChild) {

        this.rightChild = rightChild;

    }

    // Get right child of this NODE
    public Node getRightChild() {

        return rightChild;
        
    }
}
