/**
 * 链式存储的二叉树
 * 
 * 要存储的二叉树
 *                    A
 *            B               C
 *       D         E               F
 *          G   H     I         J    K
 *      
 *      之前一直纠结，怎么通过输入来解决二叉树的存储，其实没必要纠结，在
 *      节点数目较少时可以直接法生成。如果用输入法存储一般二叉树，右要浪费
 *      很多空间，直接法，反而省了空间
 */     

package com.binarytree;

import java.util.Stack;

public class TreeOfChain
{
	Bnode root;
	
	//初始换二叉树
	public TreeOfChain()
	{
		root=null;
	}
	
	//直接法生成二叉树
	public void Creat()
	{
		root= new Bnode("A");
		Bnode b1=new Bnode("B");
		Bnode b2=new Bnode("C");
		Bnode b3=new Bnode("D");
		Bnode b4=new Bnode("E");
		Bnode b5=new Bnode("F");
		Bnode b6=new Bnode("G");
		Bnode b7=new Bnode("H");
		Bnode b8=new Bnode("I");
		Bnode b9=new Bnode("J");
		Bnode b10=new Bnode("K");
		root.lchild=b1;
		root.rchild=b2;
		
		b1.lchild=b3;
		b1.rchild=b4;
		
		b2.rchild=b5;
		
		b3.rchild=b6;
		
		b4.lchild=b7;
		b4.rchild=b8;
		
		b5.lchild=b9;
		b5.rchild=b10;
		
	}
	
	
	//判断二叉树是否为空
	public boolean isEmpty()
	{
		return root==null;
	}
	
	//计算树的高度(递归法)
	public int Height(Bnode tree)
	{
		if(tree==null)
		{
			return 0;
		}else {
			
			int i=Height(tree.lchild);
			int j=Height(tree.rchild);
			return (i>j)?(i+1):(j+1);
		}
	}
	
	
	//节点的个数
	public int size(Bnode tree)
	{
		if(tree==null)
		{
			return 0;
		}
		else
		{
			
			return size(tree.lchild)+1+
			size(tree.rchild);
		}
	}
	
	
	//前序遍历，递归
	public void preOrder(Bnode tree)
	{
		if(tree!=null)
		{
			visit(tree);
			preOrder(tree.lchild);
			preOrder(tree.rchild);
		}
		
	}
	
	//前序遍历，非递归(栈)
	public void preOder1(Bnode tree)
	{
		System.out.print("\r\n");//并无实际意义
		Stack <Bnode> stack=new Stack<Bnode>();
		
		Bnode node1=tree;//保护原二叉树
		
		//下面用迭代方法代替了递归，显然这也是常规方法了，递归与迭代相互转化
		while (node1!=null || stack.size()>0)
		{
			while(node1!=null)
			{
				visit(node1);//访问根节点
				stack.push(node1);//根指针进栈
				node1=node1.lchild;//移向左子树
			}
			
			if(stack.size()>0)//如果还有根指针，不能用while
			{
				node1=stack.pop();//取出根指针
				node1=node1.rchild;//移向右子树
			}
			
		}
		
		System.out.print("\r\n");//并无实际意义
	}
	
	
	
	//中序遍历，递归
		public void midOrder(Bnode tree)
		{
			if(tree!=null)
			{
				midOrder(tree.lchild);
				visit(tree);
				midOrder(tree.rchild);
			}
			
		}
		
		//中序遍历，非递归(栈)
		public void midOder1(Bnode tree)
		{
			System.out.print("\r\n");//并无实际意义
			Stack <Bnode> stack=new Stack<Bnode>();
			
			Bnode node1=tree;//保护原二叉树
			
			//下面用迭代方法代替了递归，显然这也是常规方法了，递归与迭代相互转化
			while (node1!=null || stack.size()>0)
			{
				while(node1!=null)
				{
					stack.push(node1);//根指针进栈
					node1=node1.lchild;//移向左子树
					
				}
				
				if(stack.size()>0)//如果还有根指针，不能用while
				{
					node1=stack.pop();//取出根指针
					visit(node1);//访问左子树
					node1=node1.rchild;//移向右子树
				}
				
			} 
			System.out.print("\r\n");//并无实际意义
		}
		
		
		//后序遍历，递归
		public void posOrder(Bnode tree)
		{
			if(tree!=null)
			{
				posOrder(tree.lchild);
				posOrder(tree.rchild);
				visit(tree);
			}
			
		}
		
		//后序遍历，非递归(栈)
		public void posOder1(Bnode tree)
		{
			System.out.print("\r\n");//并无实际意义
			Stack <Bnode> stack=new Stack<Bnode>();
			
			Bnode node1=tree;//保护原二叉树
			Bnode node2=tree;//保护原二叉树
			
			//下面用迭代方法代替了递归，显然这也是常规方法了，递归与迭代相互转化
			while (node1!=null)
			{
//				while(node1!=null) 不能用while，因为推入栈的可能是空元素了
//				{
//					node1=node1.lchild;
//					stack.push(node1);//左子树进栈
//					
//				}
				
				//结合上面体会一下 for 和 while
				for(;node1.lchild!=null;node1=node1.lchild)
				{
					stack.push(node1);//左子树进栈
				}
				
				//当前节点无右子树或右子树已经输出（右子树已经处理完）
				while(node1!=null && (node1.rchild==null || node1.rchild==node2))
				{
					visit(node1);
					
					//记录上一个已经输出的节点
					node2=node1;
					if(stack.empty())
					{
						return;
					}
					node1=stack.pop();
				}
				
				//处理右子树
				stack.push(node1);
				node1=node1.rchild;
				
			} 
			System.out.print("\r\n");//并无实际意义
		}	
	//访问节点
	public void visit(Bnode tree)
	{
		System.out.print(tree.data+" ");
	}
	

	

}

//三个节点的二叉树单元存储结构
class Bnode
{
	String data;
	
	Bnode lchild;
	Bnode rchild;
	
	
	public Bnode(String data)
	{
		this.data=data;
		this.lchild=null;
		this.rchild=null;
	}
	
	public Bnode(String data,Bnode lchild,Bnode rchild)
	{
		this.data=data;
		this.lchild=lchild;
		this.rchild=rchild;
	}
	
}
