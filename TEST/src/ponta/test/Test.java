package ponta.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ponta.test.message.Message;
import ponta.test.message.MessageEnum;
import ponta.test.util.MessageUtil;
import ponta.test.util.PontaMessage;
import ponta.test.util.StringUtil;

public class Test {

	private Logger logger = LogManager.getLogger();

	public void testGetItem() {
		StringUtil strUtil = new StringUtil();
		String s1 = "abcｱｲｳｴｵあいうえお	";
		String item1 = strUtil.getItem(s1, 1, 3);
		String item2 = strUtil.getItem(s1, 4, 5);
		String item3 = strUtil.getItem(s1, 9, 10);
		System.out.println("str   : " + s1);
		System.out.println("item1 : " + item1);
		System.out.println("item2 : " + item2);
		System.out.println("item3 : " + item3);
	}

	public void testMessageEnum() {
		for (MessageEnum msgEnum : MessageEnum.values()) {
			if (msgEnum.name().equals("BE1221")) {
				System.out.println(msgEnum.ordinal() + ":" + msgEnum.name() + "," + msgEnum.getValue());
			}
		}

		PontaMessage pontaMsg = new PontaMessage();
		ArrayList<String> paramList = new ArrayList<String>();
		paramList.add("TEST1");
		paramList.add("テスト２");
		System.out.println(" " + pontaMsg.getMessage("BE1221", paramList));

	}
	
	public void testMessage() {
        String test = MessageUtil.getMessage(Message.M0001, "test");
        System.out.println(test);

	}

	public void testLog() {

		logger.trace("Start"); //2017/01/21 06:02:17.154 [main] TRACE  test1.Sample Start

		int a = 1;
		int b = 2;
		String c = null;

		logger.debug("debug"); //2017/01/21 06:02:17.157 [main] DEBUG  test1.Sample debug
		logger.info("info={}",a); //2017/01/21 06:02:17.159 [main] INFO   test1.Sample info=1
		logger.warn("warn={},={}" ,a,b); //2017/01/21 06:02:17.159 [main] WARN   test1.Sample warn=1,=2
		logger.error("error={}",c); //2017/01/21 06:02:17.171 [main] ERROR  test1.Sample error=null

		logger.trace("End"); //2017/01/21 06:02:17.172 [main] TRACE  test1.Sample End
	}

	public void testOracle() throws SQLException {
		// Oracle18iに接続
		Connection conn;
		conn = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.11.10:1521/XEPDB1", "ponta", "ponta5344");
		String sql = "SELECT NAME FROM V$CONTAINERS ";
		// ステートメントを作成
		PreparedStatement stmt = conn.prepareStatement(sql);
//		stmt.setInt(1, 1);
//		stmt.setString(2, "t%");
//
//		String que = formatQuery(sql, 1, "t%");
//		System.out.println(que);
		// 問合せの実行
		ResultSet rset = stmt.executeQuery();

		// 問合せ結果の表示
		while (rset.next()) {
			String cn = rset.getString("name");
			System.out.println("container name = " + cn);

//			// 列番号による指定
//			System.out.println(rset.getInt(1) + "\t" + rset.getString(2));
//			System.out.println(stmt.toString());
		}
		// 結果セットをクローズ
//		rset.close();
//		stmt.setInt(1, 2);
//		stmt.setString(2, "t%");
//		que = formatQuery(sql, "'" + 2 + "'", "'t%'");
//
//		ParameterMetaData pmtadta = stmt.getParameterMetaData();
//		int mtadtacnt = pmtadta.getParameterCount();
//		// Determine the number of parameters
//		System.out.println("Number of statement parameters: " + mtadtacnt);
////		for (int i = 1; i <= mtadtacnt; i++) {
////			int sqlType = pmtadta.getParameterType(i);
////			// Get SQL type for each parameter
////			System.out.println("SQL type of parameter " + i + " is " + sqlType);
////		}
//		System.out.println(que);
//		rset = stmt.executeQuery();
//		// 問合せ結果の表示
//		while (rset.next()) {
//			// 列番号による指定
//			System.out.println(rset.getInt(1) + "\t" + rset.getString(2));
//			System.out.println(stmt.toString());
//		}
		// 結果セットをクローズ
		rset.close();
		// ステートメントをクローズ
		stmt.close();
		// 接続をクローズ
		conn.close();

	}
}

