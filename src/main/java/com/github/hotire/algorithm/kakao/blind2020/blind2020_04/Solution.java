package com.github.hotire.algorithm.kakao.blind2020.blind2020_04;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Solution {

  public int[] solution(String[] words, String[] queries) {
    final Trie root = new Trie();
    Arrays.stream(words).forEach(word -> {
      Trie prev = root;
      for (char c : word.toCharArray()) {
        prev = prev.putChild(new Trie(c), word.length());
      }
    });

    //reverse
    final Trie rootReverse = new Trie();
    reverse(words).stream().map(this::reverse).forEach(word -> {
      Trie prev = rootReverse;
      for (char c : word.toCharArray()) {
        prev = prev.putChild(new Trie(c), word.length());
      }
    });

   return Arrays.stream(queries)
      .mapToInt(query -> {
        if (query.charAt(0) != '?') {
          return findWord(root, query);
        }
        return findWord(rootReverse, reverse(query));
      })
    .toArray();
  }


  protected int findWord(Trie trie, String query) {
    Trie trav = trie;
    for (int j = 0; j < query.length(); j++) {
      char c = query.charAt(j);
      if (c == '?') {
        return trav.getNumChildrenWithLen(query.length());
      }
      trav = trav.getChild(c);
      if (Objects.isNull(trav)) {
        break;
      }
    }
    return 0;
  }

  protected List<String> reverse(String[] strings) {
    final List<String> list = Arrays.asList(strings);
    Collections.reverse(list);
    return list;
  }

  protected String reverse(String s) {
    return new StringBuilder(s).reverse().toString();
  }

  class Trie {
    private char c;
    private Map<Character, Trie> children;
    private Map<Integer, Integer> numChildrenWithLen;

    Trie(char c) {
      this.c = c;
      children = new HashMap<>();
      numChildrenWithLen = new HashMap<>();
    }

    Trie() {
      children = new HashMap<>();
      numChildrenWithLen = new HashMap<>();
    }

    Trie putChild(Trie t, int len) {
      if (!children.containsKey(t.c)) {
        children.put(t.c, t);
      }
      if (numChildrenWithLen.containsKey(len)) {
        numChildrenWithLen.put(len, numChildrenWithLen.get(len) + 1);
      }
      else {
        numChildrenWithLen.put(len, 1);
      }
      return children.get(t.c);
    }

    Trie getChild(char c) {
      return children.get(c);
    }

    int getNumChildrenWithLen(int len) {
      if (numChildrenWithLen.containsKey(len)) return numChildrenWithLen.get(len);
      return 0;
    }
  }
}
