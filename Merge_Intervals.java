class Solution {
    public int[][] merge(int[][] intervals) { 
        int n  = intervals.length; 

        if(n == 1)
        {
            int[][] arr = new int[1][2]; 
            arr[0][0] = intervals[0][0]; 
            arr[0][1] = intervals[0][1]; 
            return arr;  
        }

        // sort on basics of start (ascending order ma)
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        ArrayList<ArrayList<Integer>> ll = new ArrayList<>(); 

        // start from first interval
        ArrayList<Integer> first = new ArrayList<>();
        first.add(intervals[0][0]);
        first.add(intervals[0][1]);
        ll.add(first);

        for(int i=1; i<n; i++)
        {   
            ArrayList<Integer> prev = ll.get(ll.size()-1);

            // check overlapping
            if(intervals[i][0] <= prev.get(1))
            {   
                prev.set(1, Math.max(prev.get(1), intervals[i][1]));
            }
            else 
            {
                ArrayList<Integer> l = new ArrayList<>();  
                l.add(intervals[i][0]); 
                l.add(intervals[i][1]); 
                ll.add(l);  
                
            }
        }

        int m =  ll.size(); 
        int[][] arr = new int[m][2];
        
        for(int i=0; i<ll.size(); i++)
        {
            for(int j=0; j<2; j++)
            {
                arr[i][j] = ll.get(i).get(j);
            }
        }
       
        return arr ;
    }
}
