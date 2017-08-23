package org.lanqiao.algo.datastructure;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyBinarySearchTreeImplTest {

	@Test
	public void testInsert() {
		MyBinarySearchTreeImpl binaryTree=new MyBinarySearchTreeImpl();
		binaryTree.insert(1, 5);
		binaryTree.insert(2, 6);
		binaryTree.insert(3, 3);
	}

	@Test
	public void testLookupValue() {
		MyBinarySearchTreeImpl binaryTree=new MyBinarySearchTreeImpl();
		binaryTree.insert(1, 5);
		binaryTree.insert(2, 6);
		binaryTree.insert(3, 3);
		binaryTree.lookupValue(1);
	}
	@Test
	public void testMin() {
		MyBinarySearchTreeImpl binaryTree=new MyBinarySearchTreeImpl();
		binaryTree.insert(1, 5);
		binaryTree.insert(2, 6);
		binaryTree.insert(3, 3);
		System.out.println(binaryTree.min());
	}
	@Test
	public void testMax() {
		MyBinarySearchTreeImpl binaryTree=new MyBinarySearchTreeImpl();
		binaryTree.insert(1, 5);
		binaryTree.insert(2, 6);
		binaryTree.insert(3, 3);
		System.out.println(binaryTree.max());
		System.out.println("元素个数为："+binaryTree.getSize());
	}
	@Test
	public void testRemove() {
		MyBinarySearchTreeImpl binaryTree=new MyBinarySearchTreeImpl();
		binaryTree.insert(1, 5);
		binaryTree.insert(2, 6);
		binaryTree.insert(3, 3);
		System.out.println("删除3前最大元素为："+binaryTree.max());
		binaryTree.remove(3);
		System.out.println("删除3后元素个数为："+binaryTree.getSize());
		System.out.println("删除3后最大元素为："+binaryTree.max());
	}
	
	/*public void testSuccessor(){
		MyBinarySearchTreeImpl binaryTree=new MyBinarySearchTreeImpl();
	
		MyBinarySearchTreeImpl binaryTree = new MyBinarySearchTreeImpl<>(new Myc)
		binaryTree.insert(1, 5);
		binaryTree.insert(2, 6);
		binaryTree.insert(3, 3);
		 binaryTree.successor(2);
		//System.out.println(binaryTree.predecessor(2));
	}*/
	
	public void testSuccessor(){
	
		MyBinarySearchTreeImpl<Integer,Integer> tree=new MyBinarySearchTreeImpl<Integer,Integer>(new MyComparator());
		tree.insert(1, 5);
		tree.insert(2, 6);
		tree.insert(3, 3);
		tree.successor(2);
	}
}
