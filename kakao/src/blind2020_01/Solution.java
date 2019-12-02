package blind2020_01;

import java.util.stream.IntStream;


class Solution {

  public int solution(String s) {
    final int totalLength = s.length();
    return IntStream.rangeClosed(1, totalLength/2)
        .map(i -> {
          int length = totalLength;

          for (int index = 0; index + i <= totalLength;) {
            final String word = s.substring(index, index + i);
            index += i;

            final int cnt = findCountOfWordRepeated(s, word, index);
            index += cnt * i;

            if (cnt > 0) {
              length -= i * cnt;
              length += (int)(Math.log10(cnt) + 1);
            }

          }
          return length;
        })
        .min()
        .orElse(totalLength);
  }


  protected int findCountOfWordRepeated(final String text, final String word, int begin) {
    int count = 0;
    final int totalLength = text.length();
    final int unitLength = word.length();

    while((begin + unitLength) <= totalLength) {
      if (!word.equals(text.substring(begin, begin + unitLength))) {
        return count;
      }
      begin += unitLength;
      count++;
    }

    return count;
  }

}
