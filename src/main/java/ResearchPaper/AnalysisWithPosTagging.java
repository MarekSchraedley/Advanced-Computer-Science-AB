package ResearchPaper;

import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.checkerframework.checker.units.qual.A;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class AnalysisWithPosTagging {
    public static class ArticleItem {
        private String myCountry;
        private String myContents;
        public ArticleItem(String country, String contents) {
            myCountry = country;
            myContents = contents;
        }
        public String getMyCountry() {return  myCountry;}
        public String getMyContents() {return  myContents;}
    }
    public static class word {
        private Double myPosSentiment;
        private Double myNegSentiment;
        public word(Double posSentiment, Double negSentiment) {
            myPosSentiment = posSentiment;
            myNegSentiment = negSentiment;
        }
        public Double getMyPosSentiment() {return  myPosSentiment;}
        public Double getMyNegSentiment() {return  myNegSentiment;}
    }
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/output.txt"));
            String tempCountry = file.nextLine().substring(1);
            String tempContents = "";
            ArrayList<ArticleItem> list = new ArrayList<>();
            while (file.hasNext()) {
                String line = file.nextLine();
                if (line != null && line.length() > 0) {
                    if (line.substring(0, 1).equals("#")) {
                        tempCountry = line.substring(1);
                        list.add(new ArticleItem(tempCountry, tempContents.toLowerCase()));
                        tempContents = "";
                    } else {
                        tempContents += line;
                    }
                }
            }
            file.close();

             String[] ukraineRef = {"ukraine", "zelensky", "ukrainian"};
             String[] russiaRef = {"russia", "putin"};

            var WordNetScanner = new Scanner(new File("Langdat/SentiWordNet_3.0.0.txt"));
            Map<String, word> WordMap = new HashMap<>();
            while (WordNetScanner.hasNext()) {
                String[] line = WordNetScanner.nextLine().split("\\s+");
                String tempPos = line[0];
                Double tempPosSentiment = Double.parseDouble(line[2]);
                Double tempNegSentiment = Double.parseDouble(line[3]);
                int i = 4;
                while (line[i].contains("#")) {
                    WordMap.put("!" + tempPos + line[i], new word(tempPosSentiment, tempNegSentiment));
                    i++;
                }
            }
            var CommonScentences = new Scanner(new File("Langdat/yelp_labelled.txt"));
            double successes = 0.0;
            int total = 0;
            String[] negation = {"no", "not", "neither", "never", "none", "nothing", "nor", "nobody", "doesnt", "havent", "nowhere", "wasnt", "dont", "wont", "cant", "never", "arent", "isnt", "werent", "couldnt", "mustnt", "shouldnt", "wouldnt", "didnt", "hasnt", "havent", "hadnt", "lack", "without", "hardly", "barely", "scarcely", "fail"};
            var props = new Properties();
            props.setProperty("annotators", "tokenize,ssplit,pos");
            StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
            while (CommonScentences.hasNext()) {
                String line = CommonScentences.nextLine();
                int score = Integer.parseInt(line.substring(line.length()-1));
                line = line.substring(0, line.length()-1);
                line = line.toLowerCase().replaceAll("\\p{Punct}", "");
                CoreDocument document = new CoreDocument(line);
                pipeline.annotate(document);
                ArrayList<String> words = new ArrayList<>();
                for (CoreSentence scentence : document.sentences()) {
                    List<CoreLabel> tokens = scentence.tokens();
                    for (CoreLabel token : tokens) {
                        String word = token.word();
                        String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                        if (pos.substring(0, 1).toLowerCase().equals("j")) {
                            words.add("!a" + word);
                        }
                        else if (pos.substring(0, 1).toLowerCase().equals("n")) {
                            words.add("!n" + word);
                        }
                        else if (pos.substring(0, 1).toLowerCase().equals("r")) {
                            words.add("!r" + word);
                        }
                        else if (pos.substring(0, 1).toLowerCase().equals("v")) {
                            words.add("!v" + word);
                        }
                        else {
                            words.add(word);
                        }
                    }
                }

                double average = 0.0;
                double value = 0.0;
                boolean negated = false;
                for (int i = 0; i < words.size(); i++) {
                    System.out.print(words.get(i));
                    if (WordMap.get(words.get(i) + "#1") != null) {
                        System.out.print(WordMap.get(words.get(i) + "#1").getMyPosSentiment() + "|" + WordMap.get(words.get(i) + "#1").getMyNegSentiment());
                    }
                }

                /*for (int i = 0; i < line.length-1; i++) {
                    if (WordMap.get(line[i] + "#1") != null) {
                        average += (WordMap.get(line[i] + "#1").getMyPosSentiment() - WordMap.get(line[i] + "#1").getMyNegSentiment());
                    }
                }*/
                for (int i = 0; i < words.size(); i++) {
                    value = 0.0;
                    negated = false;
                    if (WordMap.get(words.get(i) + "#1") != null) {
                        for (int j = 0; j < 5; j++) { //j < window size
                            if (i > j) {
                                for (String item : negation) {
                                    String tempWord = words.get(i-(j+1));
                                    if (words.get(i-(j+1)).substring(0,1).equals("!")) {
                                        tempWord = tempWord.substring(2);
                                    }
                                    if (tempWord.equals(item)) {
                                        negated = !negated;
                                        break;
                                    }
                                }
                            }
                        }
                        if (negated) {
                            average += (WordMap.get(words.get(i) + "#1").getMyNegSentiment() - WordMap.get(words.get(i) + "#1").getMyPosSentiment());
                        } else {
                            average += (WordMap.get(words.get(i) + "#1").getMyPosSentiment() - WordMap.get(words.get(i) + "#1").getMyNegSentiment());
                        }
                    }
                }
                average = average/(words.size());
                System.out.print(score + " " + average);
                if ((int)(average+1) == score && average != 0.0) {
                    successes++;
                    System.out.print(" success");
                }
                if (average != 0.0) {
                    total++;
                }
                System.out.println();
            }
            System.out.println(successes/total);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
