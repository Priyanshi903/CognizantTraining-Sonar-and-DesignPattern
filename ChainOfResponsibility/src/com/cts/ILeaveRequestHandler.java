package com.cts;

public abstract class ILeaveRequestHandler {
	public ILeaveRequestHandler nextHandler;

	public void setNextHandler(ILeaveRequestHandler nextHandler) {
		this.nextHandler = nextHandler;
	}
	public abstract String handleRequest(Leave leave);

}
