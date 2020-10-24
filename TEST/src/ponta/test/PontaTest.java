package ponta.test;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Java検証用テストクラス
 *
 * @author ponta
 *
 */
public class PontaTest {

	public static void main(String[] args) {
		Logger logger = LogManager.getLogger();
		logger.trace("■ Start PontaTest.");
		Test t = new Test();
		logger.trace("■ String split test start.");
		t.testGetItem();
		logger.trace("■ String split test end.");

		logger.trace("■ Message test start.");
		t.testMessage();
		logger.trace("■ Message test end.");

//		t.testLog();
		try {
			logger.trace("■ Oracle test start.");
			t.testOracle();
			logger.trace("■ Oracle test end.");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			logger.trace("■ End PontaTest.");
		}

	}

}
