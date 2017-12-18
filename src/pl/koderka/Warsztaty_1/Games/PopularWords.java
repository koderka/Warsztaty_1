package pl.koderka.Warsztaty_1.Games;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PopularWords {

	public static void main(String[] args) {

		Path path = Paths.get("popular_words.txt");
		try {
			Files.createFile(path);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String[] webpages = {"https://www.wp.pl/", "http://www.gazeta.pl/0,0.html", 
		"http://www.onet.pl/", "https://www.pudelek.pl/"};
		
		try {
			for(String webpage: webpages) {
			Connection connect = Jsoup.connect(webpage);
			Document document = connect.get();
			Elements links = document.select("span.title");

			ArrayList<String> out = new ArrayList<>();
			for (Element elem : links) {
//				System.out.println(elem.text());
				out.add(elem.text());
			}
			Files.write(path, out);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<String> in = new ArrayList<>();
		try {
			
			for(String line: Files.readAllLines(path)) {
				StringTokenizer tok = new StringTokenizer(line, " ");
				while(tok.hasMoreTokens()) {
					in.add(tok.nextToken());
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, Long> counts = in.stream().collect(Collectors
		.groupingBy(e -> e, Collectors.counting()));
		
		counts.entrySet().stream()
			.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
			.limit(10)
			.forEach(System.out::println);
	}

}
