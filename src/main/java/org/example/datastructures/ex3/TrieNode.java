package org.example.datastructures.ex3;

import java.util.HashMap;

public class TrieNode {
    private HashMap<Character, TrieNode> children;
    private String content;
    private boolean isWord;

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }
    public void setEndOfWord( boolean isEndOfWord ){
        isWord = true;
    }
    public boolean isEndOfWord() {
        return isWord;
    }
}