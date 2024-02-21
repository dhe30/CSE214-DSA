package A;
public class BinarySearch {
    public static int binarySearchRealness(int[] list, int target, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (list[mid] == target) return mid;
        if (list[mid] < target) return binarySearchRealness(list, target, mid + 1, high);
        return binarySearchRealness(list, target, low, high - 1);
    }
    public static int binarySearch(int[] list, int target) {
        return binarySearchRealness(list, target, 0, list.length - 1);
    }

    public static void main(String[] args) {
        int[] empty = new int[]{};
        int[] one = new int[]{1};
        int[] fullOdd = new int[]{1,2,3,4,5,6,7};
        int[] fullEven = new int[]{1,2,3,4,5,6,7,8};
        //search for first 
        System.out.println(binarySearch(empty, 1)==-1);
        System.out.println(binarySearch(one, 1)==0);
        System.out.println(binarySearch(fullOdd, 1)==0);
        System.out.println(binarySearch(fullEven, 1)==0);
        //search for last
        System.out.println(binarySearch(empty, 1)==-1);
        System.out.println(binarySearch(one, 1)==0);
        System.out.println(binarySearch(fullOdd, 7)==6);
        System.out.println(binarySearch(fullEven, 8)==7);
        //search for middle 
        System.out.println(binarySearch(empty, 1)==-1);
        System.out.println(binarySearch(one, 1)==0);
        System.out.println(binarySearch(fullOdd, 7/2)==2);
        System.out.println(binarySearch(fullEven, 8/2)==3);
    }
}
