class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        
            //Build a counter map for s 
            var counter = new HashMap<Character , Integer>();
        for( int i = 0 ; i < s.length(); i++){
            counter.put(s.charAt(i),counter.getOrDefault(s.charAt(i),0)+1);
        }

        for ( int i = 0 ; i <t.length(); i++){
             char c = t.charAt(i);
    if (counter.getOrDefault(c, 0) > 0) {
        // option A: it's a valid match, so "use up" one occurrence
        counter.put(c,counter.getOrDefault(c,0)-1);

    } else {
        // option B: t has a character s doesn't have enough of
        return false;
    }

        }

        return true;
    }

}
