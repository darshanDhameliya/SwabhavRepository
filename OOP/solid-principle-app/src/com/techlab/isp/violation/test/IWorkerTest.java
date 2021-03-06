package com.techlab.isp.violation.test;


import com.techlab.isp.violation.IWorker;
import com.techlab.isp.violation.Manager;
import com.techlab.isp.violation.Robot;

public class IWorkerTest {

	public static void main(String args[])
	{
		atWorkStation(new Manager());
		atCafeteria(new Manager());
		atWorkStation(new Robot());
		atCafeteria(new Robot());
	}
	private static void atWorkStation(IWorker w)
	{
		w.startWork();
		w.startWork();
	}
	private static void atCafeteria(IWorker w)
	{
		w.startEat();
		w.stopEat();
	}
}
