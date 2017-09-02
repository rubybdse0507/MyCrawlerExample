package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.6"
				+ "/search?q==%e5%a5%bd%e5%b8%82%e5%a4%9a%0d%0a&type=page&limit=1000&fields=name,id,likes,talking_about_count"
				+ "&access_token=EAACEdEose0cBAFKRjcPz9BbZAKsNDgneUSZC6lsBYuZCpdf6Fs4yfoPK3dkmbUufJ6fk8VNQhQd2QMrEXwtaQsuKCf67s2gYgNlSHZCE9CY75DVLZBF4SZBIVtv88LDPvu1YGfGxEIPlrAkUpo2F8HsHKRH9pkHZCoVzj2c84dOUtibyqcO5kI5egZCizC7ZBETcZD";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,名稱,按讚數,討論人數\n";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();
			String name = data.select("name").text();
			String likes = data.select("likes").text();
			String talking_about_count = data.select("talking_about_count").text();


			output += id+",\""+name+"\","+likes+","+talking_about_count+"\n";
			// FIXIT
			//String reactions = "";


			//output += id + "," + reactions + "\n";
		}

		System.out.println( output );
	} 
}
