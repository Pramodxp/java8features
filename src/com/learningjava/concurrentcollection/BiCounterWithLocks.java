package com.learningjava.concurrentcollection;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BiCounterWithLocks {
	private int i = 0;
	private int j = 0;
	
	Lock lockForI = new ReentrantLock();
	Lock lockForJ = new ReentrantLock();
	

	/* synchronized */ public void incrementI() {
		//get lock
		lockForI.lock();
		i++;
		lockForI.unlock();
//		release lock
		
	}

	/* synchronized */ public void incrementJ() {
		lockForJ.lock();
		j++;
		lockForJ.unlock();
		// get i
		// increment
		// set i
	}

	public int getI() {
		return i;
	}

	public int getJ() { 
		return j;
	}

}
