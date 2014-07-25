package com.jerrywu.log;

/**
 * 訊息工廠類別
 *
 */
public class MessageFactory {
		//顯示SQL訊息
		public static ILogMessage sql()
		{
				return new SQLMessage();
		}
		
		public static ILogMessage system()
		{
				return new SystemMessage();
		}
		
		public static ILogMessage error()
		{
				return new SystemMessage();
		}
}
