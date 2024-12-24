class Solution {
    public int eatenApples(int[] apples, int[] days) {
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int ans =0;
        int pos=0;
        while(true){
            if(pos<apples.length){
                queue.offer(new int[]{apples[pos],pos+days[pos]-1});
            }
            while(!queue.isEmpty()&&queue.peek()[1]<pos)
                queue.poll();
            pos++;
            if(queue.isEmpty()){
                if(pos>=apples.length)
                    break;
                else
                    continue;
            }
            ans++;
            int[] tmp = queue.peek();
            if(tmp[0]>1){
                tmp[0]--;
            }
            else
                queue.poll();
        }
        return ans;
    }
}