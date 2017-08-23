package org.lanqiao.searchword;
/**
 * java读取英语文本，找出频率最高的20个单词
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {
	public static void main(String [] args) throws Exception {  
        System.out.println("starting to read file");  
        File file=new File("F:\\学习课件\\english.txt");  
        BufferedReader bf=new BufferedReader(new FileReader(file));  
        String line;  
        String reg="\\s+";//正则表达式，把句子划分为一个个单词  
        TreeMap<String,Integer> tm= new TreeMap<String, Integer>();  
        while((line=bf.readLine())!=null) {    
           String []strs=line.split(reg);   
            for(String str:strs)  
            {  
                str=str.replaceAll("[\\p{Punct}\\pP]", ""); //去掉单词中含有的标点符号  
                if(!tm.containsKey(str))  
                {  
                    tm.put(str,1);  
                }  
                else  
                    tm.put(str,tm.get(str)+1);  
            }  
        }  
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(tm.entrySet());  
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {  
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) {  
                return (o2.getValue() - o1.getValue());  
            }  
        });  
        for (int i = 0; i <8 ; i++) {  
            System.out.println(list.get(i).getKey());  
        }  
    }  
}
