package ru.labs.lab1.utils;

import ru.labs.lab1.errors.MatrixException;

import java.util.Arrays;
import java.util.Objects;

public class Matrix {

    private final double[][] data;
    private final int m;
    private final int n;

    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        this.data = new double[m][n];
    }

    public Matrix(double[][] data) {
        m = data.length;
        n = data[0].length;
        this.data = new double[m][n];
        for (int i = 0; i < m; i++) {
            if (data[i].length != n) {
                throw new MatrixException("gear matrix");
            }
            System.arraycopy(data[i], 0, this.data[i], 0, n);
        }
    }

    // return C = A + b
    public Matrix addition(Matrix b) {
        if (b.m != this.m || b.n != this.n) throw new MatrixException("Illegal matrix dimensions.");
        Matrix c = new Matrix(m, n);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                c.data[i][j] = this.data[i][j] + b.data[i][j];
        return c;
    }

    public void setValue(int i, int j, double value) {
        if (i < 0 || i > m || j < 0 || j > n) {
            throw new MatrixException("not valid index for set value data");
        }
        data[i][j] = value;
    }

    // return C = A - b
    public Matrix subtraction(Matrix b) {
        if (b.m != this.m || b.n != this.n) throw new MatrixException("Illegal matrix dimensions.");
        Matrix c = new Matrix(m, n);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                c.data[i][j] = this.data[i][j] - b.data[i][j];
        return c;
    }

    // return C = A * B
    public Matrix multiplication(Matrix b) {
        if (this.n != b.m) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix c = new Matrix(this.m, b.n);
        for (int i = 0; i < c.m; i++)
            for (int j = 0; j < c.n; j++)
                for (int k = 0; k < this.n; k++)
                    c.data[i][j] += this.data[i][k] * b.data[k][j];
        return c;
    }

    public double getElement(int i, int j) {
        return data[i][j];
    }

    public Matrix multiplicationScalar(double scalar) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] *= scalar;
            }
        }
        return this;
    }

    public static double matrixDeterminant(Matrix matrix) {
        if (matrix.n != matrix.m) {
            throw new MatrixException("matrix is not square");
        }
        double result = 0;
        if (matrix.m == 1){
            return matrix.getElement(0, 0);
        }
        if (matrix.m == 2){
            return matrix.getElement(0, 0) * matrix.getElement(1, 1) -
                    matrix.getElement(0, 1) * matrix.getElement(1, 0);
        }
        for (int i = 0; i < matrix.n; i++) {
            Matrix  tempMatrix = new Matrix(matrix.m - 1, matrix.n - 1);
            for (int j = 1; j < matrix.m; j++) {
                for (int k = 0; k < matrix.n; k++) {
                    if (k < i) {
                        tempMatrix.data[j - 1][k] = matrix.getElement(j, k);
                    } else if (k > i) {
                        tempMatrix.data[j - 1][k - 1] = matrix.getElement(j, k);
                    }
                }
            }
            result += matrix.getElement(0, i) * Math.pow(-1, i) * matrixDeterminant(tempMatrix);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return m == matrix.m &&
                n == matrix.n &&
                Arrays.equals(data, matrix.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(m, n);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
      StringBuilder result = new StringBuilder("The matrix is:>>");
        for (int i = 0; i < m; i++)
        {
            result.append("\n");
            for (int j = 0; j < n; j++)
            {
                result.append("   ").append(data[i][j]);
            }
        }
        return result.toString();
    }

    public void swap(int i, int j) {
        double[] temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
