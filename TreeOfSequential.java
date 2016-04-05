/**
 * 二叉树的顺序存储结构的实现
 * 
 * 二叉树一般不用顺序存储结构，一是存储起来就很麻烦
 * 比如，你需要知道存储的规则才能正确存储二叉树
 *     规则是：tree[i]的双亲节点是tree[(i+1)/2-1],
 *             左右孩子节点是tree[2i],tree[2i+1]
 * 
 * 二是存储一般二叉树很浪费空间，因为需要按完全二叉树的形式存储
 * 三是，数组长度是固定的，不能随意延长二叉树，且删除等操作不方便
 * 
 * 所以不再延伸
 */
package com.binarytree;

import java.io.*;


public class TreeOfSequential 
{
	final int MAX=5;
	
	private int a[]=new int[MAX];
	
	int len;
	
	public TreeOfSequential()
	{
		a[0]=0;//数组第一个元素存储节点个数
		len=0;//记录下脚标
		
	}
	
	public void CreateTree()
	{
		System.out.println("根据二叉树特点输入数据，"
				+ "二叉树中不存在的节点用0表示,结束用#表示");
		
		InputStreamReader is1=null;
		BufferedReader br1=null;
		try{
		is1=new InputStreamReader(System.in);
		br1=new BufferedReader(is1);
		String s1=br1.readLine();
		int temp=Integer.parseInt(s1);
			
			
			
			while(len<(MAX-1))
			{
				//反复读取输入模块
				s1=br1.readLine();
				
				if (s1.equals("#"))
				{
					System.out.println("停止输入");
					break;
				}else {
					
					temp=Integer.parseInt(s1);

					if(len>=(MAX-1))
					{
						System.out.println("数组越界了");
						break;
					}else{
						
						len++;
						a[len]=temp;
						
						if(temp!=0)
						a[0]++;
					}
					
				}
				}
					
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
