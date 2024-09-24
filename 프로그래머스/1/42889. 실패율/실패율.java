import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        // 실패율 = 도달했으나 클리어 x 플레이어 수 / 도달한 플레이어 수
        int[] answer = {};
        int n = stages.length; //사용자 수
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<=N+1; i++){
            map.put(i, 0);
        }
        for(int i=0; i<n; i++){
            map.put(stages[i], map.getOrDefault(stages[i], 0)+1);
        }
        //int[][] arr = new int[n][2];
        double a;
        double b =n;
        List<double[]> arr = new ArrayList<>();
        for(int i=1; i<N+1; i++){
            
            a = map.get(i);
            
            b -= map.get(i-1);
            //System.out.println(a + " " + b);
            if(b!=0){
               arr.add(new double[] {(a/b), i});
                //System.out.println(a/b + " " + i); 
            }else{
                arr.add(new double[] {0, i});
            
            }
            
        }
        
        arr.sort((o1,o2) -> Double.compare(o2[0], o1[0]));
        
        int[] ans = new int[N];
        for(int i=0; i<N; i++){
            ans[i] = (int) arr.get(i)[1];
        }
        
        return ans;
    }
}