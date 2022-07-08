package com.company;

import java.util.*;
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class InvertedIndex {
    List<String> documents = new ArrayList<String>();
    Map<String, Term> index = new HashMap<String, Term>();
    int docID = 0;
    int countTokens = 0;

    public InvertedIndex(String path) throws IOException {
        File file = new File(path);
        Scanner sc = new Scanner(file);

    }

    public InvertedIndex() {

    }

    public void indexDocument(String path) throws IOException {
        File file = new File(path);

        if (!documents.contains(file.getName())) {
            documents.add(docID, file.getName());

            String line;
            Stemmer stemmer = new Stemmer();

            if (path.contains(".txt")) {
                Scanner in = new Scanner(file);
                while (in.hasNextLine()) {
                    line = in.nextLine().toLowerCase();
                    String[] words = line.split("[^a-zA-Z0-9_']+");
                    indexWords(words);
                }
            } else if (path.contains(".htm")) {
                Document doc = Jsoup.parse(file, "UTF-8");

                line = doc.select("body").text().toLowerCase();
                indexWords(line.split("[^a-zA-Z0-9_']+"));
            }

            System.out.printf("| %5d  | %-60s | %8d  |\n", docID, file.getPath(), index.size());

            docID++;
        }

    }

    public void indexWords(String[] words) {
        Term idx;

        for (int i = 0; i < words.length; i++) {

            Stemmer stemmer = new Stemmer();
            String word = words[i];
            stemmer.add(word.toCharArray(), word.length());
            stemmer.stem();
            String term = stemmer.toString();

            if (index.containsKey(term)) {
                index.get(term).addDocument(docID);
            } else {
                idx = new Term(docID);
                index.put(term, idx);
            }
            countTokens++;

        }
    }

    public void indexCollection(String folder) throws IOException {
        File dir = new File(folder);
        String[] files = dir.list();

        String out = "+--------+--------------------------------------------------------------+-----------+";
        System.out.println(out);
        System.out.println("| docID  | file                                                         | indexsize |");
        System.out.println(out);
        for (int i = 0; i < files.length; i++) {
            this.indexDocument(folder + "\\" + files[i]);
        }
        String word;
        Term term;
        Iterator<String> iterator = index.keySet().iterator();
        double idf;
        while (iterator.hasNext()) {
            word = iterator.next();
            term = index.get(word);
            idf = Math.log10((double) documents.size() / term.getDocumentFrequency());

            term.computeTfIdf(idf);
        }

        System.out.println(out);
        System.out.println("countTokens: " + countTokens);
        System.out.println("indexSize: " + index.size());

    }

    void getIntersection(List<DocumentRelevance> answer, Term term) {
        for (TermDocument td : term.getList()) {
            answer.get(td.getDocID()).updateRelevance(td.getTfIdf());
        }
    }

    List executeQuery(String query) {
        String[] arrquery = query.toLowerCase().split(" ");
        Stemmer stemmer;

        ArrayList<DocumentRelevance> answer = new ArrayList<>();

        for (int i = 0; i < documents.size(); i++) {
            DocumentRelevance d = new DocumentRelevance(i);
            answer.add(d);
        }

        for (String w : arrquery) {
            stemmer = new Stemmer();
            stemmer.add(w.toCharArray(), w.length());
            stemmer.stem();
            String term = stemmer.toString();
            if (index.containsKey(term)) {
                getIntersection(answer, index.get(term));
            }
        }
        LinkedList<DocumentRelevance> res = new LinkedList();
        Collections.sort(answer, new DocumentRelevanceComparator());

        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).getRelevance() == 0) break;
            res.add(answer.get(i));
        }
        printResult(query, res);
        return res;
    }

    public List<DocumentRelevance> executeQuery(String q, int n) {
        List<DocumentRelevance> data = executeQuery(q);
        LinkedList<DocumentRelevance> res = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            res.add(data.get(i));
        }
        return res;
    }

    void printResult(String query, LinkedList<DocumentRelevance> list) {
        System.out.println("Ваш запрос: " + query);
        System.out.println("Результат:");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf(i + 1 + ". (%5f) %s\n", list.get(i).getRelevance(),
                    documents.get(list.get(i).getDocID()));
        }

    }
}


