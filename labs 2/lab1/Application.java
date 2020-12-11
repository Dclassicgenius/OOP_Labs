package ru.labs.lab1;

import ru.labs.lab1.utils.Matrix;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    public static Matrix getMatrix(int m, int n) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the elements of the matrix row-wise: \n");
        Matrix a = new Matrix(m, n);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a.setValue(i, j, sc.nextDouble());
        return a;
    }

    public static void main(String[] args) {
        //double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3} };
        //Matrix D = new Matrix(d);
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows of the FIRST matrix:  ");
        int m1 = sc.nextInt();
        System.out.println("Enter the number of columns of the FIRST matrix:  ");
        int n1 = sc.nextInt();
        System.out.println("Enter the number of rows of the SECOND matrix:  ");
        int m2 = sc.nextInt();
        System.out.println("Enter the number of columns of the SECOND matrix:  ");
        int n2 = sc.nextInt();

        Matrix a = getMatrix(m1, n1);
        Matrix b = getMatrix(m2, n2);
        do {
            System.out.println("\nWhich Operation do you wish to perform? :\n");
            System.out.println("1) print Matrix\n");
            System.out.println("2) Add 2 Matrices\n");
            System.out.println("3) Subtract Matrix b from Matrix a\n");
            System.out.println("4) Multiply 2 Matrices\n");
            System.out.println("5) Swap values\n");
            System.out.println("6) Search for an element in a Matrix\n");
            System.out.println("7) Compare 2 Matrices\n");
            System.out.println("8) Determinant matrix\n");
            System.out.println("9) Matrix-scalar multiplication\n");
            option = sc.nextInt();

            switch (option) {
                case 0:
                    break;
                case 1:
                    boolean done = false;
                    while (!done) {
                        System.out.print("Which matrix do you want to print? a/b\n");
                        try {
                            char n = sc.next().toLowerCase().charAt(0);
                            if (n == 'a' || n == 'b') {
                                if (n == 'a') {
                                    System.out.println(a);
                                } else {
                                    System.out.println(b);
                                }
                                done = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("\tInvalid Input type (Must be a or b)\n ");
                            sc.nextLine();
                        }
                    }
                    break;
                case 2:
                    System.out.println(a.addition(b));
                    break;
                case 3:
                    System.out.println("press a for (a-b) or b for (b-a) \n");
                    char n = sc.next().toLowerCase().charAt(0);
                    switch (n) {
                        case 'a':
                            System.out.println(a.subtraction(b));
                            break;
                        case 'b':
                            System.out.println(b.subtraction(a));
                            break;
                        default:
                            throw new InputMismatchException("Invalid input");
                    }
                    break;
                case 4:
                    System.out.println("press a for (a*b) or b for (b*a) \n");
                    char inp = sc.next().toLowerCase().charAt(0);
                    if (inp == 'a') {
                        System.out.println(a.multiplication(b));
                    } else if (inp == 'b') {
                        System.out.println(b.multiplication(a));
                    } else {
                        throw new InputMismatchException("Invalid input");
                    }
                    break;
                case 5:
                    System.out.println("From which Matrix do you wish to swap? a/b \n");
                    char f = sc.next().toLowerCase().charAt(0);
                    if (f == 'a') {
                        System.out.println("Enter the indexes you wish to swap\n");
                        int index1 = sc.nextInt();
                        int index2 = sc.nextInt();
                        a.swap(index1, index2);
                        System.out.println("Values at " + index1 + " and " + " Values at " + index2 + " swapped");
                    } else if (f == 'b') {
                        System.out.println("Enter the indexes you wish to swap\n");
                        int index1 = sc.nextInt();
                        int index2 = sc.nextInt();
                        b.swap(index1, index2);
                        System.out.println("Values at " + index1 + " and " + " Values at " + index2 + " swapped");
                    } else {
                        throw new InputMismatchException("Invalid input");
                    }
                    break;
                case 6:
                    System.out.println("From which Matrix do you wish to get element? a/b \n");
                    char input = sc.next().toLowerCase().charAt(0);
                    if (input == 'a') {
                        System.out.println("Enter the indexes \n");
                        int index1 = sc.nextInt();
                        int index2 = sc.nextInt();
                        System.out.println("The value is : " + a.getElement(index1, index2));
                    } else if (input == 'b') {
                        System.out.println("Enter the indexes \n");
                        int index1 = sc.nextInt();
                        int index2 = sc.nextInt();
                        System.out.println("The value is : " + b.getElement(index1, index2));
                    } else {
                        throw new InputMismatchException("Invalid input");
                    }
                    break;
                case 7:
                    System.out.print(a.equals(b));
                    break;
                case 8:
                    System.out.println("What matrix to find the determinant a or b?");
                    n = sc.next().toLowerCase().charAt(0);
                    if (n == 'a') {
                        System.out.println(Matrix.matrixDeterminant(a));
                    } else {
                        if (n == 'b') {
                            System.out.println(Matrix.matrixDeterminant(b));
                        } else {
                            throw new InputMismatchException("Invalid input");
                        }
                    }
                    break;
                case 9:
                    System.out.println("Enter scalar");
                    double scalar = sc.nextDouble();
                    System.out.println("Which matrix to use a or b?");
                    n = sc.next().toLowerCase().charAt(0);
                    if (n == 'a') {
                        System.out.println(a.multiplicationScalar(scalar));
                    } else {
                        if (n == 'b') {
                            System.out.println(b.multiplicationScalar(scalar));
                        } else {
                            throw new InputMismatchException("Invalid input");
                        }
                    }
                    break;
                default:
                    System.out.print("Invalid option\n");

            }
        } while (option != 0);
    }
}
