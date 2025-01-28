class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        List<Integer> cur = new ArrayList<Integer>();
        for(int i=1;i<=rowIndex;i++){
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    cur.add(1);
                }
                else{
                    cur.add(pre.get(j-1)+pre.get(j));
                }
            }
            pre =  new ArrayList(cur);//深拷贝
            cur.clear();
        }
        return pre;
    }
}