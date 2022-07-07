package kursach;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		
		
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("select how you want to multiply matrices. 1 - successively. 2 - in parallel");
			
			int takeMetod = Integer.valueOf(in.nextLine());
			int takeRows;
			int takeColums;
			
			if(takeMetod == 1) {
				System.out.println("you select SUCCESSIVELY");
				СonsistentMatrixMult matr2 = new СonsistentMatrixMult();
				
				System.out.println("write number rows in matrixA");
				takeRows = Integer.valueOf(in.nextLine());
				
				System.out.println("write number colums in matrixA");
				takeColums = Integer.valueOf(in.nextLine());
				
				matr2.createMatrixA(takeRows, takeColums, 10);
				
				System.out.println("write number rows in matrixB");
				takeRows = Integer.valueOf(in.nextLine());
				
				System.out.println("write number colums in matrixB");
				takeColums = Integer.valueOf(in.nextLine());
				
				matr2.createMatrixB(takeRows, takeColums, 10);
				
				long startTime = System.currentTimeMillis();
				matr2.multMatrixsAB();
				long endTime = System.currentTimeMillis();
				System.out.println("Total execution time: " + (endTime-startTime) + "ms"); 
				matr2.showMatrixA();
				matr2.showMatrixB();
				matr2.showResult();
			}else if(takeMetod == 2) {
				System.out.println("you select IN PARALLEL");
				
				System.out.println("write number of threads");
				int thread =  Integer.valueOf(in.nextLine());
				
				ParallelMatrixMul matr = new ParallelMatrixMul(thread);
				
				System.out.println("write number rows in matrixA");
				takeRows = Integer.valueOf(in.nextLine());
				
				System.out.println("write number colums in matrixA");
				takeColums = Integer.valueOf(in.nextLine());
				
				matr.createMatrixA(takeRows, takeColums, 10);
				
				System.out.println("write number rows in matrixB");
				takeRows = Integer.valueOf(in.nextLine());
				
				System.out.println("write number colums in matrixB");
				takeColums = Integer.valueOf(in.nextLine());
				
				matr.createMatrixB(takeRows, takeColums, 10);
				
				long startTime = System.currentTimeMillis();
				matr.parallelMultMatrixsAB();
				long endTime = System.currentTimeMillis();
				System.out.println("Total execution time: " + (endTime-startTime) + "ms"); 
				matr.showMatrixA();
				matr.showMatrixB();
				matr.showResult();
			}else {
				System.out.println("you wtite not 1 and 2 ");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
