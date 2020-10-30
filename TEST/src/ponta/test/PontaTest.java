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
		logger.trace("■■■ Start PontaTest.");
		System.out.println();
		Test t = new Test();
		logger.trace("■ String split test start.");
		t.testGetItem();
		logger.trace("■ String split test end.");

		System.out.println();

		logger.trace("■ MessageEnum test start.");
		t.testMessageEnum();
		logger.trace("■ MessageEnum test end.");

		System.out.println();

		logger.trace("■ Message test start.");
		t.testMessage();
		logger.trace("■ Message test end.");

		System.out.println();

		try {
			logger.trace("■ Oracle test start.");
			t.testOracle();
			logger.trace("■ Oracle test end.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			System.out.println();

			logger.trace("■■■ End PontaTest.");
		}

	}

}
