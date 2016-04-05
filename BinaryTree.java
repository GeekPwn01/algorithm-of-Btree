package com.binarytree;

public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Ë³Ðò´æ´¢µÄÊµÏÖ
//		TreeOfSequential tos=new TreeOfSequential();
//		
//		tos.CreateTree();
		
		//Á´Ê½´æ´¢
		TreeOfChain toc=new TreeOfChain();
		toc.Creat();
		toc.preOrder(toc.root);
		toc.preOder1(toc.root);
		toc.midOrder(toc.root);
		toc.midOder1(toc.root);
		toc.posOrder(toc.root);
		toc.posOder1(toc.root);

	}

}
