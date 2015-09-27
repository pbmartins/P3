package aula1;

public class Sort {
	public static void sortArray(int[] array) {
		mergeSort(array, 0, array.length);
	}
	
	public static void sortArray(double[] array) {
		mergeSort(array, 0, array.length);
	}
	
	public static void sortArray(String[] array) {
		mergeSort(array, 0, array.length);
	}
	
	private static void mergeSort(int[] array, int start, int end) {
	   if (end - start > 1) {
		   int middle = (start + end) / 2;
		   mergeSort(array, start, middle);
		   mergeSort(array, middle, end);
		   mergeSubArrays(array, start, middle, end);
	   }
    }
   
    private static void mergeSubArrays(int[] array, int start, int middle, int end) {
	   int b[] = new int[end - start];
	   int i1 = start;
	   int i2 = middle;
	   int j = 0;
	   
	   while (i1<middle && i2<end) {
		   if (array[i1] < array[i2]) {
			   b[j++] = array[i1++];
		   } else {
			   b[j++] = array[i2++];
		   }
	   }
	   
	   while (i1 < middle) {
		   b[j++] = array[i1++];
	   }
	   
	   while (i2 < end) {
		   b[j++] = array[i2++];
	   }
	   
	   System.arraycopy(b, 0, array, start, end - start);
    }
    
    private static void mergeSort(double[] array, int start, int end) {
 	   if (end - start > 1) {
 		   int middle = (start + end) / 2;
 		   mergeSort(array, start, middle);
 		   mergeSort(array, middle, end);
 		   mergeSubArrays(array, start, middle, end);
 	   }
     }
    
     private static void mergeSubArrays(double[] array, int start, int middle, int end) {
 	   double b[] = new double[end - start];
 	   int i1 = start;
 	   int i2 = middle;
 	   int j = 0;
 	   
 	   while (i1<middle && i2<end) {
 		   if (array[i1] < array[i2]) {
 			   b[j++] = array[i1++];
 		   } else {
 			   b[j++] = array[i2++];
 		   }
 	   }
 	   
 	   while (i1 < middle) {
 		   b[j++] = array[i1++];
 	   }
 	   
 	   while (i2 < end) {
 		   b[j++] = array[i2++];
 	   }
 	   
 	   System.arraycopy(b, 0, array, start, end - start);
     }
    
    private static void mergeSort(String[] array, int start, int end) {
 	   if (end - start > 1) {
 		   int middle = (start + end) / 2;
 		   mergeSort(array, start, middle);
 		   mergeSort(array, middle, end);
 		   mergeSubArrays(array, start, middle, end);
 	   }
     }
    
     private static void mergeSubArrays(String[] array, int start, int middle, int end) {
 	   String b[] = new String[end - start];
 	   int i1 = start;
 	   int i2 = middle;
 	   int j = 0;
 	   
 	   while (i1<middle && i2<end) {
 		   if (array[i1].compareTo(array[i2]) < 0) {
 			   b[j++] = array[i1++];
 		   } else {
 			   b[j++] = array[i2++];
 		   }
 	   }
 	   
 	   while (i1 < middle) {
 		   b[j++] = array[i1++];
 	   }
 	   
 	   while (i2 < end) {
 		   b[j++] = array[i2++];
 	   }
 	   
 	   System.arraycopy(b, 0, array, start, end - start);
     }
}
