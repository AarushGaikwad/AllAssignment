package reversearray;

import java.util.Stack;

public class ReverseArray {
    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5};
        Stack<Integer> st = new Stack<>();

        for(int x : arr)
            st.push(x);

        for(int i=0;i<arr.length;i++)
            arr[i] = st.pop();

        for(int x : arr)
            System.out.print(x + " ");
    }
}