package com.lanqiao.pattern.Proxy;

public class RealObject extends AbstractObject{

	@Override
	public void operation() {
		System.out.println("RealObject something");
	}

}
