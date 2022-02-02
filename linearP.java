import javax.naming.directory.InvalidAttributeIdentifierException;

public class linearP {
    public static int linearP(int []arr , int key){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []a1 = {20,30,40,50,100};
        int key = 40;

        System.out.println(key +"is found at index:" + linearP(a1, key));

    }
}

