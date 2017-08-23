package com.lanqiao.reflection;

import java.lang.reflect.Field;
import java.util.Map;

public class ReflectMap {
	  /**
     * 将制定的map转换为指定的claz代表的类型的一个实例（下称bean）
     * 具体来说：map中k为bean的property，map中v为bean的property value
     * map  {“name”:”王二狗”,”age”:”10”,”sex”:”?”}
     *Student{
     *private String name;
     *private int age;
     *

      *}

    *Student stu = map2Bean(map,Student.class);
   *断言：stu.getName().equals(“王二狗”);
    *断言：stu.getAge().equals(10);

    *  map中的k-v全部是字符串，但claz中可以是基本数据类型和String
     * map中可能有多余的数据，意味着claz中没有对应的域成员或setter方法，这时，在API级别给出警告日志，但不抛异常;
     * 请妥善处理各种异常情况。
     * @param map
     * @param claz
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
	  public static <T> T map2Bean(Map<String,String> map,Class<T> claz) throws InstantiationException, IllegalAccessException {
	        T t = claz.newInstance();
	        //获取属性
	        Field[] fields = claz.getDeclaredFields();
	        //遍历属性
	        for ( Field field : fields ) {
	            //遍历map
	            for(String key: map.keySet()){
	                //打开权限使能读取private
	                field.setAccessible(true);
	                //根据属性名与map.key的对比判断出属性名一致
	                if(field.getName().equals(key)){
	                    //获取属性类型的最后名字（String）类型
	                	String type=field.getType().getSimpleName();
	                    //判断对象的属性类型，并进行相应的转换
	                    switch(type){
	                        case "int":
	                            field.setInt(t, Integer.valueOf(map.get(key)));
	                            break;
	                        case "byte":
	                            field.setByte(t, Byte.valueOf(map.get(key)));
	                            break;
	                        case "short":
	                            field.setShort(t, Short.valueOf(map.get(key)));
	                            break;
	                        case "long":
	                            field.setLong(t, Long.valueOf(map.get(key)));
	                            break;
	                        case "float":
	                            field.setFloat(t, Float.valueOf(map.get(key)));
	                            break;
	                        case "double":
	                            field.setDouble(t, Double.valueOf(map.get(key)));
	                            break;
	                        case "boolean":
	                            field.setBoolean(t, Boolean.valueOf(map.get(key)));
	                            break;
	                        case "char":
	                            field.setChar(t, map.get(key).charAt(0));
	                            break;
	                        case "String":
	                            field.set(t, map.get(key));
	                            break;
	                            default:
	                                System.out.println("错误");
	                                break;
	                    }
	                }
	            }
	        }
	        return t;

	    }

}
