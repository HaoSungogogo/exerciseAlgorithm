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
  public int most(Point[] points) {
    int res = 0;
    for (int i = 0; i < points.length; i++) {
      Point cur = points[i];
      int same = 1; 
      int sameX = 0;
      int most = 0;
      Map<Double, Integer> map = new HashMap<>();
      for (int j = 0; j < points.length; j++) {
        if (i == j) {
          continue;
        } else if (cur.x == points[j].x && cur.y == points[j].y) {
          same++;
        } else if (cur.x == points[j].x) {
          sameX++;
        } else {
          double slope = (cur.y - points[j].y + 0.0) / (cur.x - points[j].x);
          if (!map.containsKey(slope)) {
            map.put(slope, 1);
          } else {
            map.put(slope, map.get(slope) + 1);
          }
          most = Math.max(most, map.get(slope));
        }
      }
      most = Math.max(most, sameX) + same;
      res = Math.max(res, most);
    }
    return res;
  }
}
