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
import ponta.test.message.util.MessageUtil;
import ponta.test.string.util.StringUtil;
import ponta.test.util.PontaMessage;
import ponta.test.util.PontaUtil;

public class Test {

	private Logger logger = LogManager.getLogger();

	public void testGetItem() {
		StringUtil strUtil = new StringUtil();
		String s1 = "abcｱｲｳｴｵあいうえお	";
		String item1 = strUtil.getItem(s1, 1, 3);
		String item2 = strUtil.getItem(s1, 4, 5);
		String item3 = strUtil.getItem(s1, 9, 10);
		logger.debug("■ 分割前 str   : " + s1);
		logger.debug("■ 分割後 item1 : " + item1);
		logger.debug("■ 分割後 item2 : " + item2);
		logger.debug("■ 分割後 item3 : " + item3);
	}

	public void testMessageEnum() {
		String msg;
		for (MessageEnum msgEnum : MessageEnum.values()) {
			if (msgEnum.name().equals("BE1221")) {
				msg = (msgEnum.ordinal() + ":" + msgEnum.name() + "," + msgEnum.getValue());
				logger.debug("■ メッセージ確認 " + msg);
			}
		}

		PontaMessage pontaMsg = new PontaMessage();
		ArrayList<String> paramList = new ArrayList<String>();
		paramList.add("TEST1");
		paramList.add("テスト２");
		msg = pontaMsg.getMessage("BE1221", paramList);
		logger.debug("■ メッセージ確認 " + msg);

	}

	public void testMessage() {
        String test = MessageUtil.getMessage(Message.M0001, "test");
		logger.debug("■ メッセージ確認 [" + test + "]");
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

	public void testStringUtil() {
		String msg = null;

		String test1 = "   abc   ";
		String test2 = "　　　あいう　　　";
		String test3 = null;
		String test4 = "";

		msg = "■ trim(\"" + test1 + "\") = [" + StringUtil.trim(test1) + "]";
		logger.debug(msg);
		msg = "■ trim(\"" + test2 + "\") = [" + StringUtil.trim(test2) + "]";
		logger.debug(msg);
		msg = "■ trim(\"" + test3 + "\") = [" + StringUtil.trim(test3) + "]";
		logger.debug(msg);
		msg = "■ trim(\"" + test4 + "\") = [" + StringUtil.trim(test4) + "]";
		logger.debug(msg);

		msg = "■ ltrim(\"" + test1 + "\") = [" + StringUtil.ltrim(test1) + "]";
		logger.debug(msg);
		msg = "■ ltrim(\"" + test2 + "\") = [" + StringUtil.ltrim(test2) + "]";
		logger.debug(msg);
		msg = "■ ltrim(\"" + test3 + "\") = [" + StringUtil.ltrim(test3) + "]";
		logger.debug(msg);
		msg = "■ ltrim(\"" + test4 + "\") = [" + StringUtil.ltrim(test4) + "]";
		logger.debug(msg);

		msg = "■ rtrim(\"" + test1 + "\") = [" + StringUtil.rtrim(test1) + "]";
		logger.debug(msg);
		msg = "■ rtrim(\"" + test2 + "\") = [" + StringUtil.rtrim(test2) + "]";
		logger.debug(msg);
		msg = "■ rtrim(\"" + test3 + "\") = [" + StringUtil.rtrim(test3) + "]";
		logger.debug(msg);
		msg = "■ rtrim(\"" + test4 + "\") = [" + StringUtil.rtrim(test4) + "]";
		logger.debug(msg);
	}

	public void testOracle() throws SQLException {
		String msg;
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

			msg = "container name = " + cn;
			logger.debug("■ メッセージ確認 [" + msg + "]");

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

	public void testPontaUtil() {
//		PontaUtil ut = new PontaUtil();S
		String t1 = null;
		String t2 = "";
		String t3 = "test";
		String e1 = "PNTENV";
		String e2 = "NGENV";
		String e3 = "";
		String e4 = null;

		try {
			logger.debug("isEmpty(" + t1 + ")=[" + PontaUtil.isEmpty(t1) + "]");
			logger.debug("isEmpty(" + t2 + ")=[" + PontaUtil.isEmpty(t2) + "]");
			logger.debug("isEmpty(" + t3 + ")=[" + PontaUtil.isEmpty(t3) + "]");

			logger.debug("getEnv(" + e1 + ")=[" + PontaUtil.getEnv(e1) + "]");
			logger.debug("getEnv(" + e2 + ")=[" + PontaUtil.getEnv(e2) + "]");
			logger.debug("getEnv(" + e3 + ")=[" + PontaUtil.getEnv(e3) + "]");
			logger.debug("getEnv(" + e4 + ")=[" + PontaUtil.getEnv(e4) + "]");
			logger.debug("System.getenv()=[" + System.getenv() + "]");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

