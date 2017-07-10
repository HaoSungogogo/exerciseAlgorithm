/*
* class Point {
*   public int x;
*   public int y;
*   public Point(int x, int y) {
*     this.x = x;
*     this.y = y;
*   }
* }
*/
public class Solution {
  public int largest(Point[] points) {
    if (points.length == 0) {
      return 0;
    }
    Arrays.sort(points, new Comparator<Point>() {
      public int compare (Point o1, Point o2) {
        if (o1.y < o2.y) {
          return -1;
        } else if (o1.y > o2.y) {
          return 1;
        } else if (o1.x < o2.x) {
          return -1;
        } else if (o1.x > o2.x) {
          return 1;
        }
        return 0; 
      }
    });
    int res = 1;
    int[] dp = new int[points.length];
    dp[0] = 1;
    for (int i = 1; i < points.length; i++) {
      int cur = 0;
      for (int j = 0; j < i; j++) {
        if (points[i].x > points[j].x && points[i].y > points[j].y) {
          cur = Math.max(cur, dp[j]);
        }
      }
      dp[i] = cur + 1;
      res = Math.max(res, dp[i]);
    }
    return res < 2 ? 0 : res;
  }
}
