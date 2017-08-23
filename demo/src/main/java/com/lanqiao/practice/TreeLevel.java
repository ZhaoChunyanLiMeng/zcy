package com.lanqiao.practice;



public class TreeLevel {
	ListNode ln=new ListNode(-1);
	ListNode p=ln;
    public ListNode getTreeLevel(TreeNode root, int dep) {
        // write code here
    	if(root==null||dep<=0){
    		return null;
    	}
    	if(dep==1){
    		
    		p.next=new ListNode(root.val);
    		p=p.next;
    	}else{
    		getTreeLevel(root.left, dep-1);
    		getTreeLevel(root.right, dep-1);
    	}
    	return ln.next;
    	
    }
    public static void main(String[] args) {
		TreeNode node1=new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);
		TreeNode node6=new TreeNode(6);
		TreeNode node7=new TreeNode(7);
		node1.left=node2;
		node1.right=node3;
		
		node2.right=node4;
		node3.left=node5;
		node3.right=node6;
		node5.left=node7;
		ListNode node=new TreeLevel().getTreeLevel(node1, 2);
		while(node!=null){
			System.out.println(node.val);
			node=node.next;
		}
	}

}
