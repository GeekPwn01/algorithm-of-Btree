/**
 * ��������˳��洢�ṹ��ʵ��
 * 
 * ������һ�㲻��˳��洢�ṹ��һ�Ǵ洢�����ͺ��鷳
 * ���磬����Ҫ֪���洢�Ĺ��������ȷ�洢������
 *     �����ǣ�tree[i]��˫�׽ڵ���tree[(i+1)/2-1],
 *             ���Һ��ӽڵ���tree[2i],tree[2i+1]
 * 
 * ���Ǵ洢һ����������˷ѿռ䣬��Ϊ��Ҫ����ȫ����������ʽ�洢
 * ���ǣ����鳤���ǹ̶��ģ����������ӳ�����������ɾ���Ȳ���������
 * 
 * ���Բ�������
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
		a[0]=0;//�����һ��Ԫ�ش洢�ڵ����
		len=0;//��¼�½ű�
		
	}
	
	public void CreateTree()
	{
		System.out.println("���ݶ������ص��������ݣ�"
				+ "�������в����ڵĽڵ���0��ʾ,������#��ʾ");
		
		InputStreamReader is1=null;
		BufferedReader br1=null;
		try{
		is1=new InputStreamReader(System.in);
		br1=new BufferedReader(is1);
		String s1=br1.readLine();
		int temp=Integer.parseInt(s1);
			
			
			
			while(len<(MAX-1))
			{
				//������ȡ����ģ��
				s1=br1.readLine();
				
				if (s1.equals("#"))
				{
					System.out.println("ֹͣ����");
					break;
				}else {
					
					temp=Integer.parseInt(s1);

					if(len>=(MAX-1))
					{
						System.out.println("����Խ����");
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
