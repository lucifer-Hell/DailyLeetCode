import java.util.HashMap;

class Solution {
    
    // naive approach
    private static boolean isPossible(String s,int i,int j,int f){
        HashMap<Character,Integer> m=new HashMap<>();
        for(int k=i;k<=j;k++){
            char c=s.charAt(k);
            if(m.containsKey(c)) m.put(c,m.get(c)+1);
            else m.put(c,1);
        }
        // check if every character occurs k time times or not
        for(char k:m.keySet()){
            if(m.get(k)<f)return false;
        }
        return true;
    }
    public int naivelongestSubstring(String s, int k) {
        int len=0;
        // try all possible combination
        for(int i=0;i<s.length();i++){
            
            for(int j=i+1;j<s.length();j++){
                    if(isPossible(s, i, j, k)){
                        int tempLen=j-i+1;
                        Math.max(len,tempLen);
                    }
            }
        }
        return len;
    }

    // optimized approach
    // idea here is to use the fact that no of unique char's cannot be more the 26
    // taking range of unique char from 1 to 26 we can generate all possible strings 
    // 

    public int longestSubstring(String s, int k) {
       
        int maxLen=0;
        for(int i=1;i<=26;i++){
            // there can only be max of  26 unique characters in any string at a time
            int targetUnique=i;
            int currentUnique=0;
            int atLeastKUnique=0;
            // char freq
            int end=0;int start=0;
            int freq[]=new int[26];
            int tempLen=0;
            while(end<s.length()){
                char c=s.charAt(end);
                int idx=(int)c-'a';
                freq[idx]++;
                if(freq[idx]==k)atLeastKUnique++;
                if(freq[idx]==1)currentUnique++;
                while(start<=end && currentUnique>targetUnique){
                    char d=s.charAt(start);
                    int sidx=(int)d-'a';
                    if(freq[sidx]==k)atLeastKUnique--;
                    if(freq[sidx]==1)currentUnique--;
                    freq[sidx]--;
                    start++;
                }
                // valid case 
                // System.out.println("currentUnique "+currentUnique);
                if(currentUnique==targetUnique && atLeastKUnique==currentUnique){
                    maxLen=Math.max(end-start+1,maxLen);
                    // System.out.println(end-start+1);                                                             
                                                                                
                }
                end++;
            }
           
        }
        
        return maxLen;
    }




}