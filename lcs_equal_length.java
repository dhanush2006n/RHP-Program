import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        HashMap<Integer,Integer> al = new HashMap<>();
        al.put(0,-1);//val,index
        int csum=0,maxl=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)=='1'){
                csum+=1;
            }
            else{
                csum-=1;
            }
            if(al.containsKey(csum)){
                maxl = Math.max(maxl, i - al.get(csum));
            }
            else{
                al.put(csum,i);
            }
        }
        System.out.println(maxl);
        
    }
}
