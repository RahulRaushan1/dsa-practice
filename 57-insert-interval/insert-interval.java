/*class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] interval= Arrays.copyOf(intervals,intervals.length+1);
        int [][] res = new int [n+1][2];
        int e=0;
        interval[n]= newInterval;
        Arrays.sort(interval,(a,b)-> Integer.compare(a[0],b[0]));
        res[0] = interval[0];
        for(int i=1;i<=n;i++){
            if(res[e][1]>=interval[i][0]){
               res[e][1] = Math.max(interval[i][1],res[e][1]);
            }
            else{
                 e++;
                 res[e]=interval[i];
                }
        } 
        return Arrays.copyOfRange(res,0,e+1);
    }
}
*/

class Solution{
    public int[][] insert(int[][] intervals, int[] newInterval){
        ArrayList <int[]> res = new ArrayList<>();
        int i=0;
        int n = intervals.length;
        while(i<n && intervals[i][1]< newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while(i<n){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int [res.size()][2]);
    }
}