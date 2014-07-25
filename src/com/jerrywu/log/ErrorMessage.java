package com.jerrywu.log;

public class ErrorMessage implements ILogMessage {

	@Override
	public void print(String message) {
		System.out.println(String.format("[例外錯誤]:%s",message));
	}

}
