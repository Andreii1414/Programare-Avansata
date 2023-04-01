package org.example.Compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SharedMemory {
    private List<Integer> tokenList;
    private int nextToken;
    private int size;

    public SharedMemory(int size) {
        this.size = size;
        tokenList = new ArrayList<>();
        for(int i = 1; i<=size*size*size;i++)
        {
            tokenList.add(i);
        }
        Collections.shuffle(tokenList);
        nextToken = 0;
    }

    public synchronized List<Integer> extractTokens()
    {
        List<Integer> extractedTokens = new ArrayList<>();
        for(int i = 0; i < size; i++)
        {
            extractedTokens.add(tokenList.get(nextToken));
            nextToken++;
        }
        return extractedTokens;
    }

}
