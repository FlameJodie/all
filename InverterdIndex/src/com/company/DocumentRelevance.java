package com.company;

public class DocumentRelevance {
    private int docID;
    private double relevance;
    public DocumentRelevance(int docID){
        this.docID = docID;
    }
    public int getDocID(){
        return this.docID;
    }
    public double getRelevance(){
        return relevance;
    }
    public void updateRelevance(double tf){
        this.relevance+=tf;
    }

    @Override
    public String toString() {
        return "DocumentRelevance{" +
                "docID=" + docID +
                ", relevance=" + relevance +
                '}';
    }
}
