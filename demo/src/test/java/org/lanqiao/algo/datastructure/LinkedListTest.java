package org.lanqiao.algo.datastructure;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testAddObject() {
		LinkedList list =new LinkedList();
		list.add(1);
		list.add(2);
		System.out.println(list);
		list.add(0, 0);
		System.out.println(list);
		System.out.println("元素个数为："+list.size());
		System.out.println("删除的元素为值："+list.delete(1));
		System.out.println("元素个数为："+list.size());
		System.out.println("要寻找的元素值为："+list.search(2));
		System.out.println("是否包含要寻找的值："+list.contains(2));
		System.out.println("2元素对应下标为："+list.indexOf(2));
	}

}
