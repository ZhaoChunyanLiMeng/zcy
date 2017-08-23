package org.lanqiao.algo.datastructure;

import java.util.function.Consumer;

/**
 * 二叉搜索树的接口
 * 二叉搜索树：所有非叶子结点至多拥有两个儿子（Left和Right）；2.所有结点存储一个关键字；
 *   3.非叶子结点的左指针指向小于其关键字的子树，右指针指向大于其关键字的子树；
 * @author 燕
 *
 */
public interface MyBinarySearchTree<K,V>{
	/**
	   * 新增节点
	   * @param k 关键字
	   * @param v 值
	   */
	  void insert(K key,V value);
	  /**
	   * 中序遍历
	   *
	   * @param con
	   *          处理中序遍历的每个元素的函数
	   */
	  void inorder(Consumer<K> con);
	  /**
	   * 查找元素
	   * @param key
	   * @return
	   */
	  V lookupValue(K key);
	  /**
	   * 获取最小关键字
	   * @return
	   */
	  K min();
	  /**
	   * 获取最大关键字
	   * @return
	   */
	  K max();

	  /**
	   * 移除关键字对应的节点
	   * @param key
	   */
	  void remove(K key);
	  /**
	   * x的后继——比x大的第一个元素
	   * 1、是其右子树的最小值
	   * 2、没有右子树，则向上追溯，直到每个祖先节点是左孩子，返回这个祖先节点的父节点，它就是x的后继
	   * @param x
	   * @return
	   */
	  K successor(K x);

	  /**
	   * 前驱
	   * @param x 关键字
	   * @return
	   */
	  K predecessor(K x);

	  /**
	   * 返回节点数
	   * @return
	   */
	  int getSize();

}
