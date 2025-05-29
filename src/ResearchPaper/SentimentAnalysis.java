package ResearchPaper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.jsoup.*;

public class SentimentAnalysis {
    public static class Article {
        private String myLink;
        private String myPubDate;
        private String myCountry;
        public Article(String link, String pubDate, String country) {
            myLink = link;
            myPubDate = pubDate;
            myCountry = country;
        }
        public String getMyLink() {return myLink;}
        public String getMyPubDate() {return myPubDate;}
        public String getMyCountry() {return  myCountry;}
    }
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("src/ResearchPaper/ukraine.txt"));
            ArrayList<Article> articleList = new ArrayList<>();
            file.nextLine();
            while (file.hasNext()) {
                String line = file.nextLine();
                int count = 1;
                String tempLink = "";
                String tempPubDate = "";
                String tempCountry = "";
                int startIndex = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (line.substring(i, i + 1).equals(",")) {
                        if (count == 1) {
                            tempLink = line.substring(startIndex, i);
                        } else if (count == 2) {
                            tempPubDate = line.substring(startIndex, i);
                        } else if (count == 3) {
                            tempCountry = line.substring(startIndex, line.length());
                        }
                        startIndex = i+1;
                        count++;
                    }
                }
                articleList.add(new Article(tempLink, tempPubDate, tempCountry));
            }
            var doc = Jsoup.connect("https://en.wikipedia.org/").get();
            System.out.println(doc.title());
            var newsHeadlines = doc.select("#mp-itn b a");
            for (var headline : newsHeadlines) {
                System.out.println(("%s\n\t%s",
                        headline.attr("title"), headline.absUrl("href"));
            }
            file.close();
            for (int i = 0; i < articleList.size(); i++) {
                System.out.println(articleList.get(i).getMyLink());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
