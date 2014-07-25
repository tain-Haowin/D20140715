package com.jerrywu.log;

public class SystemMessage implements ILogMessage {

	@Override
	public void print(String message) {
			System.out.println(String.format("[系統訊息]:%s",message));
	}



}
