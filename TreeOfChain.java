/**
 * ��ʽ�洢�Ķ�����
 * 
 * Ҫ�洢�Ķ�����
 *                    A
 *            B               C
 *       D         E               F
 *          G   H     I         J    K
 *      
 *      ֮ǰһֱ���ᣬ��ôͨ������������������Ĵ洢����ʵû��Ҫ���ᣬ��
 *      �ڵ���Ŀ����ʱ����ֱ�ӷ����ɡ���������뷨�洢һ�����������Ҫ�˷�
 *      �ܶ�ռ䣬ֱ�ӷ�������ʡ�˿ռ�
 */     

package com.binarytree;

import java.util.Stack;

public class TreeOfChain
{
	Bnode root;
	
	//��ʼ��������
	public TreeOfChain()
	{
		root=null;
	}
	
	//ֱ�ӷ����ɶ�����
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
	
	
	//�ж϶������Ƿ�Ϊ��
	public boolean isEmpty()
	{
		return root==null;
	}
	
	//�������ĸ߶�(�ݹ鷨)
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
	
	
	//�ڵ�ĸ���
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
	
	
	//ǰ��������ݹ�
	public void preOrder(Bnode tree)
	{
		if(tree!=null)
		{
			visit(tree);
			preOrder(tree.lchild);
			preOrder(tree.rchild);
		}
		
	}
	
	//ǰ��������ǵݹ�(ջ)
	public void preOder1(Bnode tree)
	{
		System.out.print("\r\n");//����ʵ������
		Stack <Bnode> stack=new Stack<Bnode>();
		
		Bnode node1=tree;//����ԭ������
		
		//�����õ������������˵ݹ飬��Ȼ��Ҳ�ǳ��淽���ˣ��ݹ�������໥ת��
		while (node1!=null || stack.size()>0)
		{
			while(node1!=null)
			{
				visit(node1);//���ʸ��ڵ�
				stack.push(node1);//��ָ���ջ
				node1=node1.lchild;//����������
			}
			
			if(stack.size()>0)//������и�ָ�룬������while
			{
				node1=stack.pop();//ȡ����ָ��
				node1=node1.rchild;//����������
			}
			
		}
		
		System.out.print("\r\n");//����ʵ������
	}
	
	
	
	//����������ݹ�
		public void midOrder(Bnode tree)
		{
			if(tree!=null)
			{
				midOrder(tree.lchild);
				visit(tree);
				midOrder(tree.rchild);
			}
			
		}
		
		//����������ǵݹ�(ջ)
		public void midOder1(Bnode tree)
		{
			System.out.print("\r\n");//����ʵ������
			Stack <Bnode> stack=new Stack<Bnode>();
			
			Bnode node1=tree;//����ԭ������
			
			//�����õ������������˵ݹ飬��Ȼ��Ҳ�ǳ��淽���ˣ��ݹ�������໥ת��
			while (node1!=null || stack.size()>0)
			{
				while(node1!=null)
				{
					stack.push(node1);//��ָ���ջ
					node1=node1.lchild;//����������
					
				}
				
				if(stack.size()>0)//������и�ָ�룬������while
				{
					node1=stack.pop();//ȡ����ָ��
					visit(node1);//����������
					node1=node1.rchild;//����������
				}
				
			} 
			System.out.print("\r\n");//����ʵ������
		}
		
		
		//����������ݹ�
		public void posOrder(Bnode tree)
		{
			if(tree!=null)
			{
				posOrder(tree.lchild);
				posOrder(tree.rchild);
				visit(tree);
			}
			
		}
		
		//����������ǵݹ�(ջ)
		public void posOder1(Bnode tree)
		{
			System.out.print("\r\n");//����ʵ������
			Stack <Bnode> stack=new Stack<Bnode>();
			
			Bnode node1=tree;//����ԭ������
			Bnode node2=tree;//����ԭ������
			
			//�����õ������������˵ݹ飬��Ȼ��Ҳ�ǳ��淽���ˣ��ݹ�������໥ת��
			while (node1!=null)
			{
//				while(node1!=null) ������while����Ϊ����ջ�Ŀ����ǿ�Ԫ����
//				{
//					node1=node1.lchild;
//					stack.push(node1);//��������ջ
//					
//				}
				
				//����������һ�� for �� while
				for(;node1.lchild!=null;node1=node1.lchild)
				{
					stack.push(node1);//��������ջ
				}
				
				//��ǰ�ڵ������������������Ѿ�������������Ѿ������꣩
				while(node1!=null && (node1.rchild==null || node1.rchild==node2))
				{
					visit(node1);
					
					//��¼��һ���Ѿ�����Ľڵ�
					node2=node1;
					if(stack.empty())
					{
						return;
					}
					node1=stack.pop();
				}
				
				//����������
				stack.push(node1);
				node1=node1.rchild;
				
			} 
			System.out.print("\r\n");//����ʵ������
		}	
	//���ʽڵ�
	public void visit(Bnode tree)
	{
		System.out.print(tree.data+" ");
	}
	

	

}

//�����ڵ�Ķ�������Ԫ�洢�ṹ
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
