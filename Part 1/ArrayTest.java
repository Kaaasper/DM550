public class ArrayTest{

	public static String toString(int[] v){
		int i = 0;
		String res = "[";
		while (i < v.length-1){
			
			res = res + v[i] + ",";
			i++;

		}

		res = res + v[i] + "]";
		return res;


	}

	public static void main(String[] args){

		int[] test = {1,2,3,4};

		System.out.println(toString(test));

	}

}