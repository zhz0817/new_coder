class Solution {
    List<List<String>> res;
    int length;
    List<String> list;
    boolean[][] flag;
    public List<List<String>> partition(String s) {
        this.length = s.length();
        res = new ArrayList<>();
        list = new ArrayList<>();
        flag = new boolean[this.length][this.length];
        for(int i=0;i<this.length;i++){
            Arrays.fill(flag[i],true);
        }
        for(int i=length-1;i>=0;i--){
            for(int j=i+1;j<length;j++)
                flag[i][j] = (s.charAt(i)==s.charAt(j))&&(flag[i+1][j-1]);//精髓
        }
        dfs(0,s);
        return res;
    }
    public void dfs(int pos,String s){
        if(pos==this.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=pos;i<length;i++){
            if(flag[pos][i]){
                list.add(s.substring(pos,i+1));
                dfs(i+1,s);
                list.remove(list.size()-1);
            }
        }
    }
}