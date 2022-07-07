package kursach;

public class MatrixTask  extends Thread{
	private int[][] matrixA;
	private int[][] matrixB;
	private int[][] matrixResult;
	
	public MatrixTask(int[][] matrixA,int[][] matrixB) {
		this.matrixA = matrixA;
		this.matrixB = matrixB;
		this.matrixResult = new int[matrixA.length][matrixB[0].length];
	}


		public void run() {
			matrixResult = new int[matrixA.length][matrixB[0].length];
			for(int i = 0; i < matrixA.length;i++) {
				for(int j = 0; j < matrixB[0].length; j++) {
					for(int k = 0; k < matrixB.length; k++) {
						matrixResult[i][j] += matrixA[i][k] * matrixB[k][j];
					}
				}
			}
	    }
		public int[][] returnResult() {
			return matrixResult;
		}	
}
