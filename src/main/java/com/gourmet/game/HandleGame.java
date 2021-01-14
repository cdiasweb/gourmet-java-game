package com.gourmet.game;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.gourmet.util.BinaryTree;
import com.gourmet.util.Node;

public class HandleGame {
    
    // Binary tree with the knowledge of the game
    BinaryTree knowledge;

    // Loop of the game
    boolean runGame = true;

    // Possible choices to JOptionPane
    final int YES = JOptionPane.YES_OPTION;
    final int NO = JOptionPane.NO_OPTION;
    
    public HandleGame() {

        knowledge = new BinaryTree();
        
    }

    // Insert first meals in the game 
    private void addFirstMeals() {
    	
    	knowledge.insertNewNode(null, "massa", true);
    	knowledge.insertNewNode(knowledge.root, "Lasanha", true);
    	knowledge.insertNewNode(knowledge.root, "Bolo de chocolate", false);
    	
    }

    // Start the game
    public void startGame() {
    	
    	// Add the first meals to the binarytree
        if ( knowledge.isEmpty() ) {

            addFirstMeals();

        }

        // Control the game loop
        int continueGame = showStartGameMessage();

        // To close application and stop loop
        if ( continueGame == JOptionPane.CANCEL_OPTION || continueGame == JOptionPane.CLOSED_OPTION ) {

            runGame = false;
            
        }

        // Continue the game and the search
        if( runGame ) {

            showConfirmMealCorrect(knowledge.root);
            
        }
        
    }

    /**
     * Recursive function to find meals
     * First search for the root
     * node then, if exists right node 
     * or left node, ask them.
     * @param node The current node
     * */
    public void showConfirmMealCorrect(Node node) {
    	
        String question = "O prato que você pensou é " + node.getData() + " ?";
        
        // Ask to user if the meal is correct
        int answer = JOptionPane.showConfirmDialog(null, question, "Confirm", JOptionPane.YES_NO_OPTION);

        if ( answer == YES ) {
        	
        	// End of the binarytree and the answer is correct. 
            if ( node.isLeaf() ) {
            	
            	showMessageAndRestartGame();
                
            } else {
            	
            	// Not the end of binarytree, check the right child
            	showConfirmMealCorrect(node.getRightChild());
            	
            }
        } else {
        	
        	// The right child is incorrect, and is the end of this branch, get the user meal, give up. 
            if (node.getRightChild() == null) {
            	
            	getUserMeal(node);
                startGame();
                
            } else {
            	
            	// Not the end of this branch, check left child
            	showConfirmMealCorrect(node.getLeftChild());
            	
            }
        }
    }

    // Show first message to the user
    private int showStartGameMessage() {

    	return JOptionPane.showConfirmDialog(null,  "Pense em um prato que gosta", "Jogo Gourmet", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
    
    }

    private void showMessageAndRestartGame() {

        JOptionPane.showMessageDialog(null, "Acertei de novo!");
        startGame();

    }

    /**
     * Function to get the meal from player when 
     * the program can't find
     * @param node 
     * */
    private void getUserMeal(Node node) {
    	
        String userMeal = JOptionPane.showInputDialog("Qual prato você pensou?");
        String newMealCategory = JOptionPane.showInputDialog(userMeal  + " é _______ mas " + node.getData() + " não.");
        changeNodeToCategory(node, newMealCategory, userMeal);
        
    }

    /**
     * Function to add new meal in the knowledge and set
     * the right and left nodes.
     * Left child is the wrong try
     * Right child is the new node
     * @param node The new node to add
     * @param category The new category to set this node
     * @param data The node data
     * 
     * */
    private void changeNodeToCategory(Node node, String category, String data) {
    	
        String wrongGuess = node.getData();
        node.setData(category);
        node.setLeftChild(new Node(wrongGuess));
        node.setRightChild(new Node(data));
        
    }

}
