package kursach;

public class MatrixTask  extends Thread{
	private double[][] matrixA;
	private double[][] matrixB;
	private double[][] matrixResult;
	
	public MatrixTask(double[][] matrixA,double[][] matrixB) {
		this.matrixA = matrixA;
		this.matrixB = matrixB;
		this.matrixResult = new double[matrixA.length][matrixB[0].length];
	}


		public void run() {
			matrixResult = new double[matrixA.length][matrixB[0].length];
			for(int i = 0; i < matrixA.length;i++) {
				for(int j = 0; j < matrixB[0].length; j++) {
					for(int k = 0; k < matrixB.length; k++) {
						matrixResult[i][j] += matrixA[i][k] * matrixB[k][j];
					}
				}
			}
	    }
		public double[][] returnResult() {
			return matrixResult;
		}	
}
