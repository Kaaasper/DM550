public class section6{

    public static void main(String[] args){
        int[][] intM = new int[][]{{1,2},{-1,-3,0},{2,5}};
        double[][]  doubleM = new double[][]{{1, 4, 3.5}, {-4, 9.3}, {7, -14}, {4, 5, 6}};

        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // //Task 1
        // System.out.println(toString(dimensions(intM)));

        // //Task 2
        // System.out.println(toString(triangle(5)));

        // //Task 3
        // System.out.println(toString(multiplicationTable(12)));

        // //Task 4
        // System.out.println(sum(doubleM));

        // System.out.println(count(intM, 2));

        // System.out.println(smallerThan(intM, 10));

        // System.out.println(member(intM, -3));

        // System.out.println(max(doubleM));
        
        // System.out.println(toString(doubleM));
        // squareIt(doubleM);
        // System.out.println(toString(doubleM));

        // System.out.println(toString(compare(intM, 5)));

        // //Task 5
        // System.out.println(toString(intM));
        // parity(intM);
        // System.out.println(toString(intM));

        // //Task 6
        // System.out.println(toString(differences(new int[]{2,1,5,-2})));

        // //Task 7
        // System.out.println(toString(pascal(4)));

        // //Task 8
        // System.out.println(isMatrix(matrix));

        // //Task 9
        // System.out.println(toString(column(matrix, 0)));

        // //Task 10
        // System.out.println(toString(add(matrix, matrix)));

        // //Task 11
        // System.out.println(toString(multiply(5, matrix)));

        // //Task 12
        // System.out.println(isSquareMatrix(matrix));

        // //Task 13
        // System.out.println(trace(matrix));

        // //Task 14
        // System.out.println(toString(zeros(4,6)));

        // //Task 15
        // System.out.println(toString(identity(5)));

        // //Task 16
        // System.out.println(toString(delRowAndCol(matrix, 0, 2)));

        // //Task 17
        // System.out.println(toString(transpose(matrix)));

    }

    //Copied over from section4.java
    public static String toString(int[] v){
        String res = "{";
        int i = 0;
        while (i < v.length-1){
            res = res + v[i] + ", ";
            i++;
        } 
        res = res + v[i] + "}";
        return res;
    }

    //Copied over from section4.java
    public static String toString(double[] v){
        String res = "{";
        int i = 0;
        while (i < v.length-1){
            res = res + v[i] + ", ";
            i++;
        } 
        res = res + v[i] + "}";
        return res;
    }

    //toString method, but with multidimesional array
    public static String toString(int[][] v){
        String res = "{";
        int i = 0;
        while (i < v.length-1){
            res = res + toString(v[i]) + "\n";
            i++;
        } 
        res = res + toString(v[i]) + "}";
        return res;
    }

    //toString method, but with multidimesional array
    public static String toString(double[][] v){
        String res = "{";
        int i = 0;
        while (i < v.length-1){
            res = res + toString(v[i]) + "\n";
            i++;
        } 
        res = res + toString(v[i]) + "}";
        return res;
    }

    //Task 1
    public static int[] dimensions(int[][] m){
        int i = 0;
        int[] dimensions = new int[m.length];

        while (i < m.length){
            dimensions[i] = m[i].length;
            i++;
        }

        return dimensions;
    }

    //Task 2
    public static int[][] triangle(int n){
        int i = 0;
        int j = 0;
        int[][] triangle = new int[n][];

        while (i < n){
            triangle[i] = new int[i+1];
            while (j < j){
                triangle[i][j] = 1;
                j++;
            }
            j = 0;
            i++;
    
        }
        return triangle;
    }

    //Task 3
    public static int[][] multiplicationTable(int n){
        int[][] multTable = new int[n][n];
        int i = 0;
        int j = 0;

        while (i < n){
            while (j < n){
                multTable[i][j] = (i+1) * (j+1);
                j++;
            }
            j = 0;
            i++;

        }
        return multTable;

    }

    //Task 4
    public static double sum(double[][] v){
        int i = 0;
        int j = 0;
        double sum = 0;

        while ( i < v.length){

            while (j < v[i].length){
                sum = sum + v[i][j];
                j++;
            }
            j = 0;
            i++;
        }
        return sum;
    }

    public static int count(int[][] v, int n){
        int i = 0;
        int j = 0;
        int count = 0;
        
        while (i < v.length){
            while (j < v[i].length){
                if (v[i][j] == n){
                    count++;
                }
                j++;
            }
            j = 0;
            i++;
        }
        return count;
    }
    
    public static int smallerThan(int[][] v, int n){
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < v.length){
            while (j < v[i].length){
                if (v[i][j] < n){
                    count++;
                }
                j++;
            }
            j = 0;
            i++;
        }
        return count;
    }

    public static boolean member(int[][] v, int n){
        int i = 0;
        int j = 0;
        boolean member = false;

        while (i < v.length && !member){
            while (j < v[i].length && !member){
                if (v[i][j] == n){
                    member = true;
                }
                j++;
            }
            j = 0;
            i++;
        }
        return member;
        
    }

    public static double max(double[][] v){
        int i = 0;
        int j = 0;
        double max = Double.MIN_VALUE;
        
        while (i < v.length){
            while (j < v[i].length){
                if (v[i][j] > max){
                    max = v[i][j];
                }
                j++;
            }
            j = 0;
            i++;
        }
        return max;

    }
    
    public static void squareIt(double[][] v){
        int i = 0;
        int j = 0;

        while (i < v.length){
            while (j < v[i].length){
                v[i][j] = v[i][j] * v[i][j];
                j++;
            }
            j = 0;
            i++;
        }

    }

    public static int[] compare(int[][] v, int n){
        int i = 0;
        int j = 0;
        int larger = 0;
        int equals = 0;
        int smaller = 0;

        while (i < v.length){
            while (j < v[i].length){
                if (v[i][j] == n){
                    equals++;
                } else if (v[i][j] < n){
                    smaller++;
                } else {
                    larger++;
                }
                j++;

            }
            j = 0;
            i++;
        }

        int[] res = {larger, equals, smaller};
        return res;

    }

    //Task 5
    public static void parity(int[][] m){
        int i = 0;
        int j = 0;
        
        while (i < m.length){
            while (j < m[i].length){
                m[i][j] = m[i][j] % 2;

                if (m[i][j] == -1){
                    m[i][j] = 1;
                }

                j++;
            }
            j = 0;
            i++;
        }
        
    }

    //Task 6
    public static int[][] differences(int[] v){
        int[][] res = new int[v.length][];

        int i = 1;
        int j = 0;

        res[0] = v;
        while (i < v.length){
            res[i] = new int[v.length-i];

            while (j < (v.length-i)){
                res[i][j] = res[i-1][j] - res[i-1][j+1];
                j++;
            }
            j = 0;
            i++;
        }

        return res;
        
    }

    //Task 7
    public static int[][] pascal(int n){
        
        int[][] pascal = new int[n][];
        int i = 1;
        int j = 1;

        pascal[0] = new int[]{1};

        while (i < n){
            pascal[i] = new int[i+1];
            pascal[i][0] = 1;

            while (j < i){
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
                j++;
            }
            pascal[i][i] = 1;
            j = 1;
            i++;

        }
        
        return pascal;
    }

    //Task 8
    public static boolean isMatrix(int[][] m){
        int i = 1;
        boolean isMatrix = true;
        int length = m[0].length;

        while (i < m.length && isMatrix){
            if (m[i].length != length){
                isMatrix = false;
            }
            i++;
        }

        return isMatrix;
    }

    //Task 9
    public static int[] column(int[][] m, int j){
        int i = 0;
        int[] res = new int[m.length];

        while (i < m.length){
            res[i] = m[i][j];
            i++;
        }
        return res;

    }

    //Task 10
    public static int[][] add(int[][] m1, int[][] m2){
        int[][] res = new int[m1.length][m1[0].length];

        int i = 0;
        int j = 0;

        while (i < m1.length){
            while (j < m1[i].length){
                res[i][j] = m1[i][j] + m2[i][j];
                j++;
            }
            j = 0;
            i++;
        }

        return res;
    }

    //Task 11
    public static int[][] multiply(int a, int[][] m){
        int[][] res = m;
        int i = 0;
        int j = 0;

        while (i < res.length){
            while (j < res[i].length){
                res[i][j] = res[i][j] * a;
                j++;
            }
            j = 0;
            i++;
        }
        return res;

    }

    //Task 12
    public static boolean isSquareMatrix(int[][] m){
        return (isMatrix(m) && (m.length == m[0].length));
    }

    //Task 13
    public static int trace(int[][] m){
        if (isSquareMatrix(m)){
            int i = 0;
            int j = 0;
            int trace = 0;

            while (j < m.length){
                trace = trace + m[i][j];
                j++;
                i++;
            }
            
            return trace;

        } else {
            return -1;
        }

    }

    //Task 14
    public static int[][] zeros(int m, int n){
        int[][] res = new int[m][n];

        // int i = 0;
        // int j = 0;
        // while (i < m){
        //     while (j < n){
        //         res[i][j] = 0;
        //         j++;
        //     }
        //     j = 0;
        //     i++;
        // }

        return res;
    }

    //Task 15
    public static int[][] identity(int n){
        int[][] res = new int[n][n];
        int i = 0;
        int j = 0;

        while (i < n){
            while (j < n){
                if (j == i){
                    res[i][j] = 1;
                } else {
                    res[i][j] = 0;
                }
                j++;
            }
            j = 0;
            i++;
        }
        return res;
    }

    //Task 16
    public static int[][] delRowAndCol(int[][] m, int i, int j){
        int[][] res = new int[m.length-1][m[0].length-1];

        int k = 0;
        int n = 0;
        int newRow;
        int newCol;

        while (k < m.length-1){
            while (n < m[0].length-1){
                if (k < i){
                    newRow = k;
                } else {
                    newRow = k+1;
                }

                if (n < j){
                    newCol = n;
                } else {
                    newCol = n+1;
                }

                res[k][n] = m[newRow][newCol];
                n++;
            }
            n = 0;
            k++;
        }

        return res;
    }

    //Task 17
    public static int[][] transpose(int[][] m){
        int[][] res = new int[m[0].length][m.length];

        int i = 0;
        int j = 0;

        while (i < m[0].length){
            while (j < m.length){
                res[i][j] = m[j][i];
                j++;
            }
            j = 0;
            i++;
        }
        
        return res;
    }
}