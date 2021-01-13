package com.gourmet.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gourmet.util.BinaryTree;
import com.gourmet.util.Node;

public class BinaryTreeAssertTest {
	
	public void showTree(Node node) {
		
		// end
		if (!node.isLeaf()) {
			showTree(node.getLeftChild());
			showTree(node.getRightChild());
		}
	}

	@Test
	public void test() {
		BinaryTree knowledge = new BinaryTree();
		
		// fruit
		knowledge.insertNewNode(null, "Fruta", true);
		knowledge.insertNewNode(knowledge.root, "Abacaxi", true);
		
		// vegetable
		knowledge.insertNewNode(knowledge.root, "Pepino", false);
		knowledge.insertNewNode(knowledge.root, "Moranga", false);
		
		
		String assertRightTreeValue = knowledge.root.getRightChild().getData();
		String assertLeftTreeValue = knowledge.root.getLeftChild().getLeftChild().getData();
		
		assertEquals("Abacaxi", assertRightTreeValue);
		assertEquals("Moranga", assertLeftTreeValue);
		
	}

}
