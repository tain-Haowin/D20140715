package com.jerrywu.log;

/**
 * SQL 顯示類別
 */
public class SQLMessage implements ILogMessage {

	@Override
	public void print(String message) {
		  String tempMessage = String.format("[資料庫訊息]：%s", message);
		  System.out.println(tempMessage);
	}

}
