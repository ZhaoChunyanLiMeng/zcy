package org.lanqiao.recursioncc150;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;


/**
 * 假设一个机器人在x*y的左上角，它只能向下向右移动，那它从（0,0）走到（x,y）
 * @author 燕
 *
 */
public class RobotWaysCount {
	
	public boolean getPath(int x,int y,ArrayList<Point> path,Hashtable<Point,Boolean> cache){
		Point p=new Point(x,y);
		if(cache.containsKey(p)){
			cache.get(p);
		}
		path.add(p); //把p这个点加入到路径当中
		if(x==0&&y==0){
			return true;
		}
		boolean sucess=false;
		if(x>=1&& isFree(x-1,y)){
			sucess=getPath(x-1,y,path,cache);
		}
        if(!sucess&&y>=1&&isFree(x,y-1)){
        	sucess=getPath(x,y-1,path,cache);
        }
        if(!sucess){
        	path.add(p);
        }
        cache.put(p, sucess);
        return sucess; 
	}

	private boolean isFree(int i, int y) {
		// TODO Auto-generated method stub
		return false;
	}
}
