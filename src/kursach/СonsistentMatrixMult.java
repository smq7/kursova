package kursach;

public class СonsistentMatrixMult {
	private int[][] matrixA;
	private int[][] matrixB;
	private  int[][] matrixResult;
	
	public СonsistentMatrixMult() {
		this.matrixA = null;
		this.matrixB = null;
		this.matrixResult = null;
	}
	
	public void multMatrixsAB() {
		if(matrixA[0].length == matrixB.length) {
			matrixResult = new int[matrixA.length][matrixB[0].length];
			for(int i = 0; i < matrixA.length;i++) {
				for(int j = 0; j < matrixB[0].length; j++) {
					for(int k = 0; k < matrixB.length; k++) {
						matrixResult[i][j] += matrixA[i][k] * matrixB[k][j];
					}
				}
			}
		}
		else {
			System.out.println("these matrices cannot be multiplied");
		}
	}
	
	public void multMatrixsBA() {
		if(matrixB[0].length == matrixA.length) {
			matrixResult = new int[matrixB.length][matrixA[0].length];
			for(int i = 0; i < matrixB.length;i++) {
				for(int j = 0; j < matrixA[0].length; j++) {
					for(int k = 0; k < matrixA.length; k++) {
						matrixResult[i][j] += matrixB[i][k] * matrixA[k][j];
					}
				}
			}
		}
		else {
			System.out.println("these matrices cannot be multiplied");
		}
	}
	
	public void createMatrixA(int rows, int colums, int maxNumber) {
		matrixA = new int[rows][colums];
		for(int i = 0; i < rows;i++) {
			for(int j = 0; j < colums; j++) {
				matrixA[i][j] = (int)(maxNumber * Math.random());
			}
		}
	}
	public void createMatrixB(int rows, int colums, int maxNumber) {
		matrixB = new int[rows][colums];
		for(int i = 0; i < rows;i++) {
			for(int j = 0; j < colums; j++) {
				matrixB[i][j] = (int)(maxNumber * Math.random());
			}
		}
	}
	public void showMatrixA() {
		if(matrixA == null) {
			System.out.println("you dont inicializete matrix А");
			return;
		}
		System.out.println("!!!!!!!!!! MATRIX A !!!!!!!!!!!!!");
		for(int i = 0; i < matrixA.length;i++) {
			for(int j = 0; j < matrixA[0].length; j++) {
				System.out.print(matrixA[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void showResult() {
		if(matrixResult == null) {
			System.out.println("you dont mult maxtrix yet");
			return;
		}
		System.out.println("!!!!!!!!!! MATRIX result !!!!!!!!!!!!!");
		for(int i = 0; i < matrixResult.length;i++) {
			for(int j = 0; j < matrixResult[0].length; j++) {
				System.out.print(matrixResult[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void showMatrixB() {
		if(matrixB == null) {
			System.out.println("you dont inicializete matrix B");
			return;
		}
		System.out.println("!!!!!!!!!! MATRIX B !!!!!!!!!!!!!");
		for(int i = 0; i < matrixB.length;i++) {
			for(int j = 0; j < matrixB[0].length; j++) {
				System.out.print(matrixB[i][j]+" ");
			}
			System.out.println();
		}
	}
}
