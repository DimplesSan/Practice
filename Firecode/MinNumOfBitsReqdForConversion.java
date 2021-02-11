public int bitSwapRequired(int a, int b) {
    
  int c = a ^ b; // Returns num with diff bits set
  int count = 0;

  while(c != 0){
    c = c & (c-1);
    count++;
  }
  
  // String binStr = Integer.toBinaryString(c);
  // for(char c : binStr.toCharArray()) {
  //   if(c == '1') count++;
  // }

  return count;
}
