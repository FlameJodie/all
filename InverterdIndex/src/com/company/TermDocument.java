package com.company;

public class TermDocument {
    private int docID;
    private int tf;
    private double tf_idf;

    public TermDocument(int docID){
        this.docID = docID;
        this.tf = 1;
    }
    public int getDocID() {
        return this.docID;
    }
    public void increaseFrequency(){
        tf++;
    }

    public void computeTfIdf(double idf){
        this.tf_idf = (1+ Math.log10(this.tf)) * idf;
    }

    public double getTfIdf(){
        return this.tf_idf;
    }

    @Override
    public String toString() {
        return "TermDocument{" +
                "docID=" + docID +
                ", tf=" + tf +
                ", tf_idf=" + tf_idf +
                '}';
    }
}
