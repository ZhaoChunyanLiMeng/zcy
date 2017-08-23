package demo;
/**
 * 自动探测URL 爬去新闻网站实例
 */
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class AutoNewsCrawler extends BreadthCrawler {

	public AutoNewsCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		//种子
		this.addSeed("http://news.hfut.edu.cn/list-1-1.html");
		//正则表达式
		this.addRegex("http://news.hfut.edu.cn/show-.*html");
		//不抓取的
		this.addRegex("-.*\\.(jpg|png|gif).*");
		this.addRegex("-.*#.*");
		//线程
		setThreads(50);
		setTopN(100);  //getConf().setTopN(100);
	}

	@Override
	public void visit(Page page, CrawlDatums next) {
		String url=page.url();
		if(page.matchUrl("http://news.hfut.edu.cn/show-.*html")){
			String title=page.select("div[id=Article]>h2").first().text();
			String content=page.select("div#artibody").text();
			
			System.out.println("URL:\n" + url);
            System.out.println("title:\n" + title);
            System.out.println("content:\n" + content);

		}
		
	}
	public static  void main(String[] args) throws Exception{
		AutoNewsCrawler crawler=new AutoNewsCrawler("crawl",true);
		crawler.start(4);
	}

}
