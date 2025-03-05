class Solution {
    public String breakPalindrome(String palindrome) {
        //核心思想，为了字典序最小，需要把第一个不是a的字符变成a，如果都是a就把最后一个元素改成b
        //典型的贪心算法
        int n = palindrome.length();
        if(n == 1){ //长度为1怎么改都是回文的
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int index = n-1;
        for(int i=0;i<n;i++){
            char ch = palindrome.charAt(i);
            if(ch=='a' || (n%2 == 1 && i == n/2)){ //字符串长度为奇数时，改中间的位置没意义，改了也还是回文
                sb.append(ch);
            }else{
                sb.append('a');// 一旦发现有元素不是a，那么立刻替换成a
                index = i;
                break;
            }
        }
        if(index!=n-1){ // 替换成a之后，补齐后面的字符串即可
            for(int i=index+1;i<n;i++){
                sb.append(palindrome.charAt(i));
            }
        }else{ //字符串里只包含a，那么把最后一个元素换成b
            sb.deleteCharAt(sb.length()-1);
            sb.append('b');
        }
        return sb.toString();
    }
}