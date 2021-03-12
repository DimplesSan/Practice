// aaaabcdnha
// abcda
// abc
// []
// BCEFGHBCFG

// max=6
// B=6
// C=7
// E=2
// F=8
// G=9
// H=5

public static int longestNRSubstringLen(String input) {
    if(input == null) { return 0; }
    if(input.length() < 2) { return input.length(); }
    Hashtable<Character, Integer> substrChars = new Hashtable<Character, Integer>();

    int i=0, maxCount=0;
    while(i < input.length()) {
        Integer index = substrChars.get(input.charAt(i));
        if(index != null) {
            if(i-index > 1) {
                maxCount = ((i-index) >= maxCount) ? (i-index) : maxCount;
            }            
        }

        substrChars.put(input.charAt(i), i);
        i++;
    }

    return maxCount==0 ? i : maxCount;
}
