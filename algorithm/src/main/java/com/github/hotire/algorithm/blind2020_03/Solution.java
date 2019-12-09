package com.github.hotire.algorithm.blind2020_03;


import java.util.stream.IntStream;

public class Solution {
  private int backgroundSize;
  private int center;
  private int end;

  public boolean solution(int[][] key, int[][] lock) {
    final int lockSize = lock.length;
    center = key.length - 1;
    end = center + lockSize;
    backgroundSize = lockSize + (2 * center);

    for (int x = 0; x < 4; x++) {
      for (int i = 0; i < end; i++) {
        for (int j = 0; j < end; j++) {
          if (isUnlock(lock, key, i, j)) {
            return true;
          }
        }
      }
      cycle(key);
    }

    return false;
  }

  protected boolean isUnlock(final int[][] lock, final int[][] key, final int startX, final int startY ) {
    final int[][] background = new int[backgroundSize][backgroundSize];

    IntStream.range(0, key.length).forEach(i ->
        IntStream.range(0, key.length).forEach(j ->
            background[startY + i][startX + j] = key[i][j]
        )
    );

    for (int i = center; i < end; i++) {
      for (int j = center; j < end; j++) {
        background[i][j] += lock[i - center][j - center];
        if (background[i][j] != 1) {
          return false;
        }
      }
    }

    return true;
  }

  protected void cycle(final int[][] arr) {
    final int n = arr.length;
    for (int i = 0; i < n / 2; i++){
      for (int j = i; j < n - i - 1; j++){
        int temp = arr[i][j];
        arr[i][j] = arr[n - j - 1][i];
        arr[n - j - 1][i] = arr[n - 1 - i][n - 1 - j];
        arr[n - 1 - i][n - 1 - j] = arr[j][n - 1 - i];
        arr[j][n - 1 - i] = temp;
      }
    }
  }
}
