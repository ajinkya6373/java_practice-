package String;

public class palidromII {

    public static boolean validPalindrome(String s) {
            int start = 0;
            int end = s.length()-1;
            while (start<end){
                if (s.charAt(start)!=s.charAt(end)){
                    return  isPali(s,start+1,end) || isPali(s,start,end-1);
                }
                start++;
                end--;
            }

            return true;
    }

   public static boolean isPali(String s, int start, int end){
       while(start<=end){
           if(s.charAt(start)!=s.charAt(end)){
               return false;
           }
           start++;
           end--;
       }
       return true;
   }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
    }
}
