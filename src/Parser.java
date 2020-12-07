import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Parser {
	private Document doc;
	private Document doc1;
	
	
	public Parser() {
		super();
		connect();
	}


	public Parser(Document doc, Document doc1) {
		super();
		this.doc = doc;
		this.doc1 = doc1;
	}


	public Document getDoc() {
		return doc;
	}


	public void setDoc(Document doc) {
		this.doc = doc;
	}


	public Document getDoc1() {
		return doc1;
	}


	public void setDoc1(Document doc1) {
		this.doc1 = doc1;
	}


	@Override
	public String toString() {
		return "Parser [doc=" + doc + ", doc1=" + doc1 + "]";
	}
	
	private void connect() {

		try {
			doc = Jsoup.connect("https://sinoptik.ua/%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0-%D0%BA%D0%B8%D0%B5%D0%B2")
					.get();
			doc1=Jsoup.connect("https://index.minfin.com.ua/reference/coronavirus/ukraine/").get();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}
	public String getWeatheStatus() {
		
		Elements todayTime = doc.getElementsByClass("today-time");
		Elements todayTemp = doc.getElementsByClass("today-temp");
		Elements infoDayLight = doc.getElementsByClass("infoDaylight");
		Elements descStorm = doc.getElementsByClass("description ico-stormWarning-1 ico-stormWarning-wide");
		
		Elements descStatusWeather = doc.getElementsByClass("description").get(0).getElementsByClass("description");

		
		String text= todayTime.text()+" "+todayTemp.text()+" \n\n"+descStatusWeather.text()+" \n"+descStorm.text()+"\n"+" \n"+infoDayLight.text()
		+" \n";

		return text;
	
}
	
	public String getCovidStatus() {
		Elements covid = doc1.getElementsByClass("bg-grey nopaddingleft idx-tablecell-640").get(0).getElementsByClass("bg-grey nopaddingleft idx-tablecell-640");
		Elements coviddat = doc1.getElementsByClass("table-comment").get(0).getElementsByClass("table-comment");
		String text = covid.text()+" "+coviddat.text();
		return text;
		
	}
}