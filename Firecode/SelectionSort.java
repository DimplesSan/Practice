// {4,12,4,78,7,-1}
// {52,3,2}
// [Empty]
// 4

public static int[] selectionSortArray(int[] arr){

    if(arr==null || arr.length < 2) return arr;
    
    int indexOfMin = 0, temp=0;
    for(int i=0; i<arr.length; i++) {
       for(int j=i+1; j<arr.length; j++) {
           indexOfMin = arr[i] <= arr[j] ? i : j;
       }

       // Swap with value at minIndex
       temp = arr[i];
       arr[i] = arr[indexOfMin];
       arr[indexOfMin] = temp;
    }

    return arr;
}
