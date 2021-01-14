package com.gourmet.util;

public class BinaryTree {

	// Store the active node
    public Node root;

    /**
     * Function to insert new node inside the binary tree.
     * @param parentNode the node that is the parent of the new node
     * @param data The information value of the new node
     * @param position To control the position of the new node and classify data
     * @return the binarytree root node with the new node
     * 
     * */
    public void insertNewNode(Node parentNode, String value, boolean position) {

        root = insertNode(parentNode, value, position);
        
    }
    
    // To check if the binarytree is empty, without nodes
    public boolean isEmpty() {
    	
        return root == null;
        
    }

    private Node insertNode(Node parentNode, String data, boolean position) {
        	
    	// check if the binarytree is empty, return the new root node if empty.
        if (parentNode == null) {
        	
            parentNode = new Node(data);
            return parentNode;
            
        } else if (position) {
        	
        	// The position is true, insert new node and define as rightchild in the parentNode
        	Node newNode = insertNode(parentNode.getRightChild(), data, position);
            parentNode.setRightChild(newNode);
            
        } else {
        	
        	// The position is false, insert new node and define as leftchild in the parentNode
        	Node newNode = insertNode(parentNode.getLeftChild(), data, position);
            parentNode.setLeftChild(newNode);
            
        }

        return parentNode;
        
    }
}