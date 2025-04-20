import java.util.*;

public class Main {

    public void getString(String s){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='['){
                sb.append('{');
            }
            else if(ch==']'){
                sb.append('}');
            }
            else{
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            map.put(v1,v2);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(a,b)->{
            if(b.getValue().compareTo(a.getValue())!=0)
                return b.getValue().compareTo(a.getValue());
            return a.getKey().compareTo(b.getKey());
        });
        int max = m*3/2;
        int min = list.get(max-1).getValue();
        int count = max;
        for(int i=max;i<n;i++){
            if(list.get(i).getValue()==min){
                count++;
            }
        }
        System.out.println(list.get(count-1).getValue()+" "+count);
        for(int i=0;i<count;i++) {
            System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
        }
    }
}

//88 5
//1005 95
//2390 95
//1000 90
//1001 88
//3239 88 