package com.company;

import java.util.Comparator;

public class DocumentRelevanceComparator implements Comparator<DocumentRelevance> {
    public int compare(DocumentRelevance o1, DocumentRelevance o2) {
        return Double.compare(o2.getRelevance(), o1.getRelevance());
    }
}
