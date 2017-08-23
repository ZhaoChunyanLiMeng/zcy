package com.lanqiao.pattern.Proxy;

public class ProxyObject extends AbstractObject {
	RealObject realobject=new RealObject();
	@Override
	public void operation() {
		
		System.out.println("brfore");
		realobject.operation();
		System.out.println("after");
	}

}
