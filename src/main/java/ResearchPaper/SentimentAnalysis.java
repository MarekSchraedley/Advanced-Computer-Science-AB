package ResearchPaper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import org.jsoup.*;
import io.github.cdimascio.dotenv.Dotenv;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;



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
            var file = new Scanner(new File("Langdat/ukraine.txt"));
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
                            tempCountry = line.substring(i+1, line.length());
                        }
                        startIndex = i+1;
                        count++;
                    }
                }
                articleList.add(new Article(tempLink, tempPubDate, tempCountry));
            }
            FileWriter writer = new FileWriter("output.txt");
            for (int i = 0; i < articleList.size(); i++) {
                try {
 //              var doc = Jsoup.connect(articleList.get(i).getMyLink()).get();
//               System.out.println(doc.title());
//               var newsHeadlines = doc.select("#mp-itn b a");
//               for (var headline : newsHeadlines) {
//                   System.out.printf("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
//               }

                    Dotenv dotenv = Dotenv.configure().directory("Langdat").load();
                    String apiKey = dotenv.get("GEMINI_API_KEY");
                    Client client = Client.builder().apiKey(apiKey).build();
                    String prompt = "Given the following HTML code for a news article, " +
                            "paraphrase the text of the article ONLY with no additional commentary. Omit anything that is not the paraphrased article from the final output. Here is the Link:\n\n\n";
                    GenerateContentResponse response =
                            client.models.generateContent("gemini-2.0-flash-001", prompt + articleList.get(i).getMyLink(), null);

                    // Gets the text string from the response by the quick accessor method `text()`.
                    if (response.text() != null) {
                        System.out.println(articleList.get(i).getMyCountry());
                        writer.write(articleList.get(i).getMyCountry());
                        System.out.println(response.text());
                        writer.write(response.text());
                    }
                } catch (Exception e) {

                }
            }
            file.close();
//            for (int i = 0; i < articleList.size(); i++) {
//                System.out.println(articleList.get(i).getMyLink());
//            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
