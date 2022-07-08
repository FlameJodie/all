package com.company;

import java.util.LinkedList;
import java.util.List;

public class Term {
    public int termFrequency;
    public LinkedList<TermDocument> list = new LinkedList<TermDocument>();

    public Term(int docID) {
        TermDocument td = new TermDocument(docID);
        this.termFrequency = 1;
        this.list.add(td);
    }
    public void addDocument(int docID) {

        if (docID > list.getLast().getDocID()) {
            list.add(new TermDocument(docID));
        }
        else {
            this.list.getLast().increaseFrequency();
        }

    }
    public void computeTfIdf(double idf) {
        for (TermDocument t: list) {
            t.computeTfIdf(idf);
        }
    }
    public int getDocumentFrequency() {
        return this.list.size();
    }
    public List<TermDocument> getList() {
        return this.list;
    }
}