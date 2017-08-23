package demo;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

/**
 * 手动探测URL  爬去新闻网站
 * @author 燕
 *
 */
public class ManualNewsCrawler extends BreadthCrawler{

	public ManualNewsCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
	    for(int i=1;i<=10;i++){  //此处不是通过种子 和正则表达式了，而是手写探测
	    	this.addSeed("http://news.hfut.edu.cn/list-1-" + i + ".html", "list");
	    }
	    setThreads(50);
	    setTopN(100);
	}

	@Override
	public void visit(Page page, CrawlDatums next) {
		String url=page.url();
		if(page.matchType("list")){
			next.add(page.links("div[class=' col-lg-8 '] li>a")).type("content");
		}else if(page.matchType("content")){
			String title=page.select("div[id=Article]>h2").first().text();
			String content=page.select("div#artibody", 0).text();
			
			

			
		}
	}

}
