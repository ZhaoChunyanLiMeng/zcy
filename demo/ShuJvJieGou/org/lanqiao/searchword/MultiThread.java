package org.lanqiao.searchword;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 多线程下读取
 *
 */
public class MultiThread implements Runnable {
	private static BufferedReader br=null;
	private List<String> list;
	static{
		try {
			br=new BufferedReader(new FileReader(""),10);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		String line=null;
		int count=0;
		while(true){
			this.list=new ArrayList<String>();
			synchronized(br){
				try{
					while((line=br.readLine())!=null){
						if(count<15){
							list.add(line); //把文本文档读到list中
							count++;
						}else{
							list.add(line);
							count=0;
							break;
						}
					}
				}catch(	IOException e){
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1);
				display(this.list);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(line==null)
				break;  //读到文件末尾，结束跳出
		}
	}
	private void display(List<String> list) {
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println(list.size());
	}

}
