package com.lanqiao.annotation;

/**
 * 给接口 加注释
 * @author 燕
 *
 */
public interface IWorker {
	 @ShowDuration()
	  void logic1();

	  @ShowDuration(false)
	  void logic2();
}
