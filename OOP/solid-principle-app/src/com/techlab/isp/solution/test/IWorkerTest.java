package com.techlab.isp.solution.test;

import com.techlab.isp.solution.IEatable;
import com.techlab.isp.solution.IWorkable;
import com.techlab.isp.solution.Manager;
import com.techlab.isp.solution.Robot;

public class IWorkerTest {

	public static void main(String args[]) {
		atWorkStation(new Manager());
		atCafeteria(new Manager());
		atWorkStation(new Robot());
	}

	private static void atWorkStation(IWorkable w) {
		System.out.println("\n-----work-----");
		w.startWork();
		w.startWork();
	}

	private static void atCafeteria(IEatable w) {
		System.out.println("\n-----Eat-----");
		w.startEat();
		w.stopEat();
	}
}
