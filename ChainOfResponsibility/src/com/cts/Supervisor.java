package com.cts;

public class Supervisor extends ILeaveRequestHandler{


	public void setNextHandler() {
		this.nextHandler = new ProjectManager();
	}

	@Override
	public String handleRequest(Leave leave) {
		if(leave.getLeaveDays()<2) {
			System.out.println("Supervisor approved your leave");
			return;
		}
		else {
			System.out.println("Supevisor cant handle request,request passing to Project manager");
			setNextHandler(nextHandler);
		}
		
	}

}
