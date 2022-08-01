package util;

public class ArrayUtil {
	
	public static double[] duplicate(double[] arr) {
		double[] newArr = new double[arr.length];
		for (int i = 0 ; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		return newArr;
	}

}
