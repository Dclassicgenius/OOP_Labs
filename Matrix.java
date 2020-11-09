import java.util.InputMismatchException;
import java.util.Scanner;

final public class Matrix {
    private final double[][] data;
    private final int M;
    private final int N;

    //Create M-by-N matrix of 0's
    public Matrix (int M,int N)
    {
        this.M = M;
        this.N = N;
        data = new double [M][N];
    }
    //Create matrix based on 2d array
    public Matrix (double[][] data) {
        M = data.length;
        N = data[0].length;
        this.data = new double[M][N];
        for (int i = 0; i < M; i++) System.arraycopy(data[i], 0, this.data[i], 0, N);
    }

    // copy constructor
    private Matrix(Matrix A) { this(A.data); }

    // create and return an M-by-N matrix
    public static Matrix get_matrix(int M, int N) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the elements of the matrix row-wise: \n");

        Matrix A = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.data[i][j] = sc.nextDouble();
        return A;
    }

    public void print_matrix()
    {
        System.out.println("The matrix is:>>");
        for (int i = 0; i < M; i++)
        {
            System.out.println("");
            for (int j = 0; j < N; j++)
            {
                System.out.print("   "+data[i][j]);
            }
        }
    }

    // swap rows i and j
    private void swap(int i, int j) {
        double[] temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


    // return C = A + B
    public Matrix addition(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] + B.data[i][j];
            return C;
    }


    // return C = A - B
    public Matrix subtraction(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] - B.data[i][j];
            return C;
    }

    // does A = B exactly?
    public boolean isequal(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (A.data[i][j] != B.data[i][j]) return false;
            return true;
    }

    // return C = A * B
    public Matrix multiplication(Matrix B) {
        Matrix A = this;
        if (A.N != B.M) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(A.M, B.N);
        for (int i = 0; i < C.M; i++)
            for (int j = 0; j < C.N; j++)
                for (int k = 0; k < A.N; k++)
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
            return C;
    }

    public double get_element(int i, int j){
        return data[i][j];
    }


    public static void main(String[] args) {
        //double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3} };
        //Matrix D = new Matrix(d);

        int a,b,c,d;
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows of the FIRST matrix:  ");
        a = sc.nextInt();
        System.out.println("Enter the number of columns of the FIRST matrix:  ");
        b = sc.nextInt();
        System.out.println("Enter the number of rows of the SECOND matrix:  ");
        c = sc.nextInt();
        System.out.println("Enter the number of columns of the SECOND matrix:  ");
        d = sc.nextInt();

        Matrix A = new Matrix(get_matrix(a,b));
        Matrix B = new Matrix(get_matrix(c,d));
        do{
            System.out.println("\nWhich Operation do you wish to perform? :\n");
            System.out.println("1) print Matrix\n");
            System.out.println("2) Add 2 Matrices\n");
            System.out.println("3) Subtract Matrix B from Matrix A\n");
            System.out.println("4) Multiply 2 Matrices\n");
            System.out.println("5) Swap values\n");
            System.out.println("6) Search for an element in a Matrix\n");
            System.out.println("7) Compare 2 Matrices\n");
            option = sc.nextInt();

            switch(option) {
                case 0:
                    break;
                case 1:
                    boolean done = false;
                    while (!done) {
                        System.out.print("Which matrix do you want to print? A/B\n");
                        try {
                            char n = sc.next().toLowerCase().charAt(0);
                            if (n == 'a' || n == 'b') {
                                if (n == 'a') {
                                    A.print_matrix();
                                } else {
                                    B.print_matrix();
                                }
                                done = true;
                            } else {
                                done = false;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("\tInvalid Input type (Must be A or B)\n ");
                            sc.nextLine();
                        }
                    }
                    break;
                case 2:
                    A.addition(B).print_matrix();
                    break;
                case 3:

                    System.out.println("press A for (A-B) or B for (B-A) \n");
                    char n = sc.next().toLowerCase().charAt(0);
                    if (n == 'a') {
                        A.subtraction(B).print_matrix();
                    } else if (n == 'b') {
                        B.subtraction(A).print_matrix();
                    } else {
                        throw new InputMismatchException("Invalid input");
                    }
                    break;
                case 4:
                    System.out.println("press A for (A*B) or B for (B*A) \n");
                    char inp = sc.next().toLowerCase().charAt(0);
                    if (inp == 'a') {
                        A.multiplication(B).print_matrix();
                    } else if (inp == 'b') {
                        B.multiplication(A).print_matrix();
                    } else {
                        throw new InputMismatchException("Invalid input");
                    }
                    break;
                case 5:
                    System.out.println("From which Matrix do you wish to swap? A/B \n");
                    char f = sc.next().toLowerCase().charAt(0);
                    if (f == 'a') {
                        System.out.println("Enter the indexes you wish to swap\n");
                        int index1 = sc.nextInt();
                        int index2 = sc.nextInt();
                        A.swap(index1, index2);
                        System.out.println("Values at " + index1 + " and " + " Values at " + index2 + " swapped");
                    } else if (f == 'b') {
                        System.out.println("Enter the indexes you wish to swap\n");
                        int index1 = sc.nextInt();
                        int index2 = sc.nextInt();
                        B.swap(index1, index2);
                        System.out.println("Values at " + index1 + " and " + " Values at " + index2 + " swapped");
                    } else {
                        throw new InputMismatchException("Invalid input");
                    }
                    break;
                case 6:
                    System.out.println("From which Matrix do you wish to get element? A/B \n");
                    char input = sc.next().toLowerCase().charAt(0);
                    if (input == 'a') {
                        System.out.println("Enter the indexes \n");
                        int index1 = sc.nextInt();
                        int index2 = sc.nextInt();
                        System.out.println("The value is : "+ A.get_element(index1, index2));
                    } else if (input == 'b') {
                        System.out.println("Enter the indexes \n");
                        int index1 = sc.nextInt();
                        int index2 = sc.nextInt();
                       System.out.println("The value is : "+ B.get_element(index1, index2));
                    } else {
                        throw new InputMismatchException("Invalid input");
                    }
                    break;
                case 7:
                    System.out.print(A.isequal(B));
                    break;
                default:
                    System.out.print("Invalid option\n");

            }
        } while(option!=0);
    }
}


