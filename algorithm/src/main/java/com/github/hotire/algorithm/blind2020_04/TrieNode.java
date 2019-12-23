package com.github.hotire.algorithm.blind2020_04;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : hotire
 */
class TrieNode {
  private final Map<Character, TrieNode> children = new HashMap<>();
  private boolean endOfWord;

  protected Map<Character, TrieNode> getChildren() {
    return children;
  }

  protected boolean isEndOfWord() {
    return endOfWord;
  }

  protected void setEndOfWord(boolean endOfWord) {
    this.endOfWord = endOfWord;
  }
}
