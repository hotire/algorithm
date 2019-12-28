package com.github.hotire.algorithm.blind2020_04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author : hotire
 */
class TrieTest {

  @Test
  public void test() {
    Trie trie = new Trie();
    trie.insert("ABC");
    System.out.println(trie.containsNode("AB"));
  }
}