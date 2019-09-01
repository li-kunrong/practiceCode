package com.test;


public class Main {
	private static final int COUNT_BITS = Integer.SIZE - 3;
	private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

	// runState is stored in the high-order bits
	private static final int RUNNING    = -1 << COUNT_BITS;
	private static final int SHUTDOWN   =  0 << COUNT_BITS;
	private static final int STOP       =  1 << COUNT_BITS;
	private static final int TIDYING    =  2 << COUNT_BITS;
	private static final int TERMINATED =  3 << COUNT_BITS;

    public static void main(String[] args) {
	 retry:
		for (int i = 0; i < 100; i++) {
	 		for (int j = 0; j < 10; j ++) {
				System.out.println("i=" +i+"j=" +j);
	 			if (i==1&&j==9){
	 				break retry;
				}

			}
		}
		System.out.println("terminted");
	}
}



