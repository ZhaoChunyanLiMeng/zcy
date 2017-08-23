package org.lanqiao.algo.datastructure;

import org.lanqiao.algo.datastructure.LinkedList.Entry;

/**
 * LinkedList类是双向列表,列表中的每个节点都包含了对前一个和后一个元素的引用.
 * @author 燕
 *
 */
public class LinkedList implements IList {
	
	private Entry head;   //双向链表的头
	private Entry last;     //双向链表的尾
	private int size = 0;// 元素个数
	/**
	 * 添加元素：添加单个元素 如果不指定索引的话，元素将被添加到链表的最后.public boolean add(Object element)
	 *  Entry(Object value, Entry pre, Entry next) 构造方法     值，前引用，后引用
	 */
	@Override
	public void add(Object e) {
		if(head==null){                 //如果链表里还没有元素，新填入第一个元素
			head=new Entry(e,null,null);
			last=head;//新加入后，自己变为最后一个元素，赋值给last
		}else{
			Entry temp=new Entry(e,last,null);
			last.next=temp;  //原来的最后一个元素（尾）的下一个元素是新加入的
			last=temp; //新加入后，自己变为最后一个元素，赋值给last
		}
		size++;//元素个数增加
	}
	/**
	 * 根据下标来添加元素    如果下标大于当前链表元素个数，抛出异常；如果下标等于元素个数，直接加入即可；
	 * 如果下标小于元素个数，需要把原来连着的两个断开，前个的后引用指向它，它的后引用指向后边那个
	 */
	@Override
	public void add(Object obj, int index) {
		if(index>size){
			throw new IndexOutOfBoundsException();//要加入的下标大于当前链表元素个数，抛出异常
		}else{
			Entry e=getEntry(index);//链表当前这个下标得元素是什么
			Entry  temp=new Entry(obj,last,null);//根据传进来的值，新建一个元素，即将要加入的元素
			if(e==head){  //如果通过下标得，这个下标下的元素是头元素
				head.pre=temp;//原头元素的前指向是 现元素
				temp.next=head; // 现元素的后指向是 原头元素
				head=temp;
			}else{
				//交换指针
				e.pre.next=temp;//把当前元素原来前面那个元素 的下一个变为加入的元素
				temp.next=e;//加入元素的下一个，变为当前元素
				e.pre=temp;
			}
			size++; //元素个数增加
		}
	}
/**
 * delete(int index)：根据下标删除元素，并返回所删除元素的值
 */
	@Override
	public Object delete(int index) {
		Entry e=getEntry(index);//先根据下标知道当前要删除的元素是谁
		Object v=e.value;//存下要删除元素的值
		removeEntry(e);
		return v;
	}
	/**
	 * remove(Object key) :根据元素的值删除元素
	 */
	@Override
	public void remove(Object key) {
		Entry e=getEntry(key);
		removeEntry(e);
	}
/**
 * 自己写一个从链表中删除元素的方法
 * @param e
 */
	private void removeEntry(Entry e) {
		//考虑要删除的元素是最后一个元素
		if(last==e){
			e.pre.next=null;
			last=e.pre;
			size--;//不要忘记个数减少
			return;//终止方法
		}
		//考虑要删除的元素是第一个元素
		if(head==e){
			head.next.pre=null;
			head=head.next;
			size--;
			return;
		}
		//考虑删除的是中间元素
		if(null!=e){
			e.pre.next=e.next;
			e.next.pre=e.pre;
			size--;
			return;
		}
	}
	/**
	 * 重写 根据下得到元素方法
	 */
	@Override
	public Object get(int index) {
		if(index>=size){
			return null;
		}else{
		Entry temp=getEntry(index);
		Object obj=temp.value;
		return obj;
		}
	}
	/**
	 * 重写 根据元素值寻找元素方法
	 */
	@Override
	public Object search(Object key) {
		Entry temp=getEntry(key);
		if(null==temp){
			return null;
		}else{
		return temp.value;
		}
	}
	/**
	 * 重写方法 判断集合是否包含指定元素值
	 */
	@Override
	public boolean contains(Object key) {
		return (search(key)!=null);
	}
	@Override
	public int size() {
		return size;
	}
/**
 * 判断集合是否为空
 */
	@Override
	public boolean isEmpty() {
		return size==0;
	}
/**
 * 重写方法indexOf(Object e) ：找到指定元素值 的元素下标
 */
	@Override
	public int indexOf(Object obj) {
		int index=0;//设定初始下标为0
		Entry temp=head;//从头元素开始寻找
		while(temp!=null){
			if(temp.value==null&&obj==null||temp.value.equals(obj)){ //找到对应元素下标
				return index;
			}else{
				temp=temp.next;  //没找到时，继续往下找
				index++;
			}
		}
		return 0;
	}

	
	/**
	 * 自己写一个根据下标找到元素的方法
	 * @param index
	 * @return
	 */
	public Entry getEntry(int index){
		if(index>=size){
			return null;
		}else{
			Entry e=head;
			int i=0;
			int j=index;
			while(i<j){   //当下标小于 要找的那个元素的下标， 一直循环，直到下标值，返回对应元素
			e=e.next;
			i++;
			}
			return e;
		}
	}
/**
 * 自己写一个根据元素值找到对应元素的方法
 * @param key
 * @return
 */
	public Entry getEntry(Object key){
		Entry temp=head;//键一个元素对象，让它等于头元素
		while(temp!=null){
			if(temp.value==null&&key==null||temp.value.equals(key)){  //元素值为空或找到元素
				return temp;
			}else{
				temp=temp.next;  //没找到的话，继续往下寻找
			}
		}
		return null;
		
	}

	/**
	 * 新建一个类，用来产生链表中的元素
	 */
	class Entry {
		Object value;  //要操作的那个元素的值
		Entry pre;      //它的前指向
		Entry next;    //它的后指向

		public Entry(Object value, Entry pre, Entry next) {    //构造方法
			super();
			this.value = value;
			this.pre = pre;
			this.next = next;
		}

		@Override
		public String toString() {                        //重写toString()方法
			return value.toString();                       
		}

		@Override
		public int hashCode() {                       //重写 hashCode()方法
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {      //判断链表中是否已有这个元素
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entry other = (Entry) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		private LinkedList getOuterType() {
			return LinkedList.this;
		}

	}

	@Override
	public String toString() {
		Entry e = head;  //头
		StringBuilder sb = new StringBuilder("["); 
		while (e != null) {    //当第一个头 不为空时
			sb.append(e.value.toString()).append(","); //输出 [ value,]
			e = e.next;
		}
		sb.deleteCharAt(sb.lastIndexOf(",")).append("]");
		return sb.toString();   //返回这个元素
	}
}
