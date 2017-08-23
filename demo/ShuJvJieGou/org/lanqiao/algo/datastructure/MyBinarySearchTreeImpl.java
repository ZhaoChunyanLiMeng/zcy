package org.lanqiao.algo.datastructure;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 实现自写 二叉搜索树 增删查询代码    此二叉搜索树的每个节点是一个map的一个元素，有键和值两部分，因为键key是不可以重复的，
 * 在此比较的是每个map元素的键元素
 * 每个结点都是一个对象；结点中除了数据key外，还有三个指针p，left，right，分别指向父结点，左儿子，右儿子。
 * @author 燕
 *
 */
public class MyBinarySearchTreeImpl<K,V> implements MyBinarySearchTree<K,V>{
	public static void main(String[] args){
		MyBinarySearchTreeImpl<Integer,Integer> tree=new MyBinarySearchTreeImpl<Integer,Integer>(new MyComparator());
		tree.insert(1, 5);
		tree.insert(2, 6);
		tree.insert(3, 3);
		System.out.println(tree.successor(2));
	}
	private Node root; //根节点
	int size; //元素个数
	private Comparator  comparator;  //一个比较器
	//构造函数
	public MyBinarySearchTreeImpl(){
		
	}
	public MyBinarySearchTreeImpl(Comparator  comparator){
		this.comparator=comparator;
	}
	/**
	 * 往二叉搜索树里添加元素   查看找到当前元素合适位置，把当前元素加紧去，然后看其p父亲，
	 */
	@Override
	public void insert(K key, V value) {
		if(!(key instanceof Comparable)){
			throw new ClassCastException();  //如果要添加的节点的值不可以比较，则抛出异常
		}
		Node<K,V> p=null;//父节点
		Node<K,V> curr=root; //当前节点，用于与加入的节点进行比较
		while(curr!=null){
			p=curr;   //先把当前元素赋给他的父亲，随着寻找，父亲节点是变化的
			if(compare(key, curr.key)<0){  //如果compare(key, curr.key)<0，说明要加入元素的值小于当前元素的值
				curr=curr.left;  //则找当前元素的左孩子继续与要加入的元素相比较
			}else if(compare(key, curr.key)>0){  //如果compare(key, curr.key)>0，说明要加入元素的值大于当前元素的值
				curr=curr.left;  //则继续找当前元素的右孩子继续比较
			}else{
				curr.key=key;  //直到最后，寻找到了要加入元素的正确位置，要加入的 元素是个叶子节点
				return;
			}
		}
		curr=new Node<K,V>(key,value,null,null,null);//以当前传进来的值和键创建一个新节点，然后寻找他的父亲
		curr.parent=p;  
		if(p==null){
			root=curr; //如果父亲节点为空，则当前加入的元素就是父亲节点
		}else if(compare(key,p.key)<0){
			p.left=curr;   //如果存在父亲节点，并且当前要加入的值，小于父亲节点的值，则当前加入的节点是父亲节点的左孩子
			curr.isLeftChild=true;
		}else if(compare(key,p.key)>0){
			p.right=curr;
			curr.isLeftChild=false;
		}
		size++;    //加上 之后，元素个数增加
	}
	
	
/**
 * 自写一个  比较方法
 * @param key1
 * @param key2
 * @return
 */
	 private int compare(K key1, K key2) {
		    if (null == comparator) {
		      return ((Comparable) key1).compareTo((Comparable) key2);
		    } else {
		      return comparator.compare(key1, key2);
		    }
		  }
	 /**
	  * 中序遍历
	  * 遍历二叉树的元素
	  * @param con
	  */
	@Override
	public void inorder(Consumer con) {
		if(root!=null){
			inorder(root,con);
		}
	}
	private  void inorder(Node<K,V> p,Consumer con){
		if(p!=null){
			inorder(p.left,con);
			con.accept(p.key);
			inorder(p.right,con);
		}
	}
/**
 * 根据节点的key找到节点父亲节点的value
 */
	@Override
	public V lookupValue(K key) {
		Node<K,V> lookupNode=lookUpNode( key);
		return lookupNode==null?null:lookupNode.value;
	}
    /**
     * 自己写一个通过元素值key 找到 节点的方法
     * @param key
     * @return
     */
	private Node<K, V> lookUpNode(K key) {
		Node<K,V> p=root; //定义一个根节点，把根节点赋值给它
	    while(p!=null&&compare(key,p.key)!=0){   //根节点是变化的，当根节点不为空，且与key的值不相等时
	    	if(compare(key,p.key)<0){
	    		p=p.left;  //继续往下寻找
	    	}else{
	    		p=p.right;
	    	}
	    }
	    return p;  //把找到的节点返回
}
	/**
	 * 找最小元素值
	 */
	@Override
	public K min() {
		return minNode(root).key;
	}

	private Node<K,V> minNode(Node<K,V> p) {
		while(p.left!=null){
			p=p.left;    //如果左孩子不为空，就往下寻找左孩子
		}
		return p; 
	}
	@Override
	/**
	 * 找最大元素值
	 */
	public K max() {
		
		return  lookMaxNode(root).key;
	}
    private Node<K,V>  lookMaxNode(Node p){
    	while(p.right!=null){
    		p=p.right;
    	}
		return p;	
    }
    /**
     * 删除元素
     */
	@Override
	public void remove(K key) {
		removeNode(lookUpNode(key));
		size--;
	}
//自己写一个删除 指定节点的方法  分左右孩子都不存在；左孩子不存在；右孩子不存在；左右孩子都不存在
	private void removeNode(Node<K,V> x) {
		if(x!=null){
			  if(x.left==null&&x.right==null){  //x左右孩子都为空   
				  if(x.isLeftChild){     //如果x本身是左孩子     
					  x.parent.left=null;  //把x的父亲的左孩子变为空
				  }else{
					    if(x.parent!=null){//如果父亲不为空，x本身是右节点
						  x.parent.right=null; 
					    }else{
					    	root=null;  //如果父亲为空，x本身则就是跟节点，直接删除跟节点就可以
					    }
				  } 
				  x=null;
			  }else if(x.left==null){  //x如果有子节点，但左子节点为空
				   if(x.isLeftChild==true){
					  x.parent.left=x.right;
					  x.right.isLeftChild=true;
					  x.right.parent=x.parent;
				    }else{
				    	  if(x.parent!=null){
				    		  x.parent.right=x.right;
				    		  x.right.parent=x.parent;
				    	  }else{
				    		  root=null;
				    	  }
				    }
			  }else if(x.right==null){ //x如果有子节点，但右子节点为空
				  if(x.isLeftChild==true){
					  x.parent.left =x.left;
					  x.left.isLeftChild=true;
					  x.left.parent=x.parent;
				  }else{
					  if(x.parent!=null){
						  x.parent.right=x.left;
						  x.left.parent=x.parent;
					  }else{
						  root=null;
					  }
				  }
			  }else{//x左右子节点都有
				    Node<K,V> minRight=minNode(x.right); 
				    x.key=minRight.key;//更换x的内容
				    removeNode(minRight);//删掉右子树中最小的元素
			  }
		}
	}
	 /**
	   * x的后继——比x大的第一个元素
	   * 1、是其右子树的最小值
	   * 2、没有右子树，则向上追溯，直到每个祖先节点是左孩子，返回这个祖先节点的父节点，它就是x的后继
	   * 所以求法为：若有右子树，右子树的最小的元素，即右子树的最左边叶子节点
	   *                        若没有右子树，则分为两种情况;(1)若该节点是左孩子，其父节点就是后继
	   *                                                                               (2)若该节点是右孩子，则向上找，找到第一个是左孩子的，其父节点就是后继。
	   *   向上找，找到第一个是左孩子的，找找找，找到root，如果还不满足条件，返回null，则没有后继
	   * @param x
	   * @return
	   */
	@Override
	public K successor(K x) {
		Node<K,V> xNode=lookUpNode(x);//根据key找到这个节点
		if(xNode==null){//如果这个节点为空，返回空
			return null;
		}
		if(xNode.right!=null){
			return minNode(xNode.right).key;  //如果有右节点，则返回右节点中最小的节点
		}
		Node<K,V> yNode=xNode.parent;//yNode是xNode 的父亲节点
		while(yNode!=null&&xNode==yNode.right){  //当xNode父节点不为空时，一直往上找，找父节点，直到找到一个左孩子
			xNode=yNode;  //把xNode变为父节点
			yNode=yNode.parent; //把yNode父节点再找他的父节点
		}
		return yNode==null?null: yNode.key;
	}
/**
 * 前驱
 * 找比x小的第一个元素
 * （1）如果有左孩子，则返回其左孩子中最大的一个元素，（2）如果其左孩子为空，则往上找，直到找到一个右孩子，然后返回右孩子的父节点即可
 * @param x 关键字
 * @return
 */
	@Override
	public K predecessor(K x) {
		Node<K,V> xNode=lookUpNode(x);//根据key找到这个节点
		if(xNode==null){//如果这个节点为空，返回空
			return null;
		}
		if(xNode.left!=null){
			return lookMaxNode(xNode.right).key;  //如果有左节点，则返回左节点中最小的节点
		}
		Node<K,V> yNode=xNode.parent;
		while( yNode!=null&&xNode.isLeftChild){
			xNode=yNode;
			yNode=yNode.parent;
		}
		return yNode==null?null:yNode.key;
		
	}

	@Override
	public int getSize() {
		return size;
	}
	/**
	 * 自己写一个节点类用来放节点
	 * @author 燕
	 *
	 * @param <K>
	 * @param <V>
	 */
	private static class Node<K,V>{
		public K key;  //节点包括的键
		public V value;  //节点包括的值
		public Node<K,V> left;  //左孩子节点
		public Node<K,V> right; //右孩子节点
		public Node<K,V> parent;//父亲节点
		public boolean isLeftChild;    //定义一个是否是左孩子的布尔判断变量
		public Node(){}
		
		public Node(K key, V value, Node<K, V> left, Node<K, V> right, Node<K, V> parent) {
		      super();
		      this.key = key;
		      this.value = value;
		      this.left = left;
		      this.right = right;
		      this.parent = parent;
		    }

		@Override
		public String toString() {
			return "Node [key=" + key + "]";
		}

		
	}
	
	

}
