package com.lanqiao.reflection;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReflectList {
	public static <T> List<T> rs2List(ResultSet rs,Class<T> claz) throws Exception{
		List<T> list = new ArrayList<T>();    //新建一个ArrayList集合,用来接收结果集
		Field[] fields = claz.getDeclaredFields();  //获取传入类的属性
		int count = rs.getMetaData().getColumnCount();   //传入结果集的行数
		while(rs.next()) {                                                  //当结果集有下一条数据时
			T in = claz.newInstance();                                 //新建一个传入类的对象
			for (Field field : fields) {                                    //遍历属性
				for (int j = 0; j < count; j++) {
					if(field.getName().equals(rs.getMetaData().getColumnName(j+1))) {   //如果属性名与结果集行名相同
						field.setAccessible(true);         //属性变为可设置
						field.set(in, rs.getObject(j+1));
					}
				}
			}
			list.add(in);
		}
		return list;

	}


}
