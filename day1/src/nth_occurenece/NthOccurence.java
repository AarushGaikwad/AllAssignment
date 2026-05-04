package nth_occurenece;

public class NthOccurence {

    static int findNth(int arr[], int key, int n) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                count++;

                if (count == n)
                    return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {5, 2, 5, 7, 5, 9};

        System.out.println(findNth(arr, 5, 3));
    }
}