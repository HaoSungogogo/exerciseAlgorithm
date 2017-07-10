public class Solution {
  public int[][] maze(int n) {
    int[][] res = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          res[i][j] = 0;
        } else {
          res[i][j] = 1;
        }
      }
    }
    generate(res, 0, 0);
    return res;
  }
  private void generate (int[][] res, int x, int y) {
    Dir[] dir = Dir.values();
    shuffle(dir);
    for (Dir iter : dir) {
      int xLoc = iter.moveX(x, 2);
      int yLoc = iter.moveY(y, 2);
      if (isValid(xLoc, yLoc, res)) {
        res[iter.moveX(x, 1)][iter.moveY(y, 1)] = 0;
        res[xLoc][yLoc] = 0;
        generate(res, xLoc, yLoc);
      }
    }
  }
  private void shuffle (Dir[] dir) {
    for (int i = 0; i < dir.length; i++) {
      int index = (int) (Math.random() * (dir.length - i));
      Dir cur = dir[i];
      dir[i] = dir[index + i];
      dir[index + i] = cur;
    }
  }
  private boolean isValid (int x, int y, int[][] res) {
    return x >= 0 && x < res.length && y >= 0 && y < res[0].length && res[x][y] == 1;
  }
  enum Dir {
    North (-1, 0), South (1, 0), West (0, -1), East(0, 1);
    int dirX;
    int dirY;
    private Dir (int dirX, int dirY) {
      this.dirX = dirX;
      this.dirY = dirY;
    }
    public int moveX (int x, int times) {
      return x + times * dirX;
    }
    public int moveY (int y, int times) {
      return y + times * dirY;
    }
  }
}
