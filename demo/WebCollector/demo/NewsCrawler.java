package demo;

import org.jsoup.nodes.Document;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

/**1、网络爬虫
 * 爬取网站新闻
 * @author 燕
 *
 */
public class NewsCrawler extends BreadthCrawler{
	//编写构造器
	public NewsCrawler(String crawlPath,boolean autoParse){
		super(crawlPath,autoParse);
		//添加一个种子站点
		this.addSeed("http://news.hfut.edu.cn/list-1-1.html");
		//添加正则表达式，即要什么样的网页
		this.addRegex("http://news.hfut.edu.cn/show-.*html");
		//不抓取 jpg|png|gif*/
		this.addRegex("-.*\\.(jpg|png|gif).*");
		//不抓取url contains #*/
		this.addRegex("-.*#.*");

	}

	@Override
	public void visit(Page page, CrawlDatums next) {
		String url = page.getUrl();
		if(page.matchUrl("http://news.hfut.edu.cn/show-.*html")){
			Document doc =page.getDoc();
			//
			String title=page.select("div[id=Article]>h2").first().text();
			String content=page.select("div#artibody",0).text();
			
			System.out.println("URL:\n"+url);
			System.out.println("title:\n"+title);
			System.out.println("content:\n"+content);

		}
	}
	public static void main(String[] args) throws Exception{
		NewsCrawler crawler=new NewsCrawler("crawl",true);
		//开启50个线程抓取
		crawler.setThreads(50);
		//住区100个
		crawler.setTopN(100);
		crawler.start(4);
	}
}
