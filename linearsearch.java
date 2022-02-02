public class linearsearch {
    public static int linearsearch(int[]arr,int key){
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
     public static void main(String[] a) {
         int[]a1={10,20,25,35,70,100};
         int key= 35;
         System.out.println(key+ "is found at index:" +linearsearch(a1, key) );
    } 
        
}
