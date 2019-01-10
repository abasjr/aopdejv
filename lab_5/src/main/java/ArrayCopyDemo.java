public class ArrayCopyDemo{
  public static void main(String[] args) {
    char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',
      'i', 'n', 'a', 't', 'e', 'd' };
    char[] copyTo = new char[7];

    System.arraycopy(copyFrom, 2, copyTo, 0, 7);  // konsep array copy
    System.out.println(new String(copyTo)); //caffein
    System.out.println(copyTo); //caffein


    System.out.println("===================");


    int arr1[] = { 0, 1, 2, 3, 4, 5 };
    int arr2[] = { 5, 10, 20, 30, 40, 50 };

    // copies an array from the specified source array
    System.arraycopy(arr1, 0, arr2, 0, 1);  // konsep array copy
    System.out.print("array2 = ");
    System.out.print(arr2[0] + " ");
    System.out.print(arr2[1] + " ");
    System.out.print(arr2[2] + " ");
    System.out.print(arr2[3] + " ");
    System.out.print(arr2[4] + " ");
  }
}
