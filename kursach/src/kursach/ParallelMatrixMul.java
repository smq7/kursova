package kursach;

import java.text.DecimalFormat;

public class ParallelMatrixMul {
	private double[][] matrixA;
	private double[][] matrixB;
	private  double[][] matrixResult;
	DecimalFormat f = new DecimalFormat("##.00");
	private int numThread;
	private MatrixTask[] arrThread;
	
	public ParallelMatrixMul(int numThread) {
		this.matrixA = null;
		this.matrixB = null;
		this.numThread = numThread;
		arrThread = new MatrixTask[numThread];
	}
	
	public void parallelMultMatrixsAB() {
		if(matrixA[0].length == matrixB.length) {
			matrixResult = new double[matrixA.length][matrixB[0].length];
				for(int k = 0; k < numThread;k++) {
					double[][] matrixTemp = new double[matrixA.length/numThread][matrixA[0].length];
					for(int i = 0; i <matrixA.length/numThread;i++) {
						for(int j = 0; j < matrixA[0].length;j++) {
							matrixTemp[i][j] = matrixA[i+k*(matrixA.length/numThread)][j];
						}
					}
					arrThread[k] = new MatrixTask(matrixTemp,matrixB);
					arrThread[k].start();
				}
				try {
					for(int k = 0; k < numThread;k++) {
						arrThread[k].join();
						double[][] matrixTemp = arrThread[k].returnResult();
						for(int i = 0; i <matrixA.length/numThread;i++) {
							for(int j = 0; j < matrixB[0].length;j++) {
								matrixResult[i+k*(matrixA.length/numThread)][j] = matrixTemp[i][j];
							}
						}
						
					}
				} catch (InterruptedException e) {
				      System.out.println("Error.");
			    }
//			} 			
		} else{
			System.out.println("these matrices cannot be multiplied");
		}
	}
	
	
	public void createMatrixA(int rows, int colums, int maxNumber) {
		matrixA = new double[rows][colums];
		for(int i = 0; i < rows;i++) {
			for(int j = 0; j < colums; j++) {
				matrixA[i][j] = (double)((double)(Math.round((maxNumber * Math.random())*100))/100);
			}
		}
	}
	public void createMatrixB(int rows, int colums, int maxNumber) {
		matrixB = new double[rows][colums];
		for(int i = 0; i < rows;i++) {
			for(int j = 0; j < colums; j++) {
				matrixB[i][j] = (double)((double)(Math.round((maxNumber * Math.random())*100))/100);
			}
		}
	}
	public double[][] showMatrixA() {
		if(matrixA == null) {
			System.out.println("you dont inicializete matrix А");
			return matrixA;
		}
		System.out.println("!!!!!!!!!! MATRIX A !!!!!!!!!!!!!");
		for(int i = 0; i < matrixA.length;i++) {
			for(int j = 0; j < matrixA[0].length; j++) {
				System.out.print(f.format(matrixA[i][j])+" ");
			}
			System.out.println();
		}
		return matrixA;
	}
	public void showResult() {
		if(matrixResult == null) {
			System.out.println("you dont mult maxtrix yet");
			return;
		}
		System.out.println("!!!!!!!!!! MATRIX result !!!!!!!!!!!!!");
		for(int i = 0; i < matrixResult.length;i++) {
			for(int j = 0; j < matrixResult[0].length; j++) {
				System.out.print(f.format(matrixResult[i][j]) +" ");
			}
			System.out.println();
		}
	}
	
	public double[][] showMatrixB() {
		if(matrixB == null) {
			System.out.println("you dont inicializete matrix B");
			return matrixB;
		}
		System.out.println("!!!!!!!!!! MATRIX B !!!!!!!!!!!!!");
		for(int i = 0; i < matrixB.length;i++) {
			for(int j = 0; j < matrixB[0].length; j++) {
				System.out.print(f.format(matrixB[i][j])+" ");
			}
			System.out.println();
		}
		return matrixB;
	}
}
