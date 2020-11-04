package ponta.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ponta.test.Exeption.PontaSystemException;

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

		logger.trace("■ StringUtil test start.");
		t.testStringUtil();
		logger.trace("■ StringUtil test end.");

		logger.trace("■ PontaUtil test start.");
		t.testPontaUtil();
		logger.trace("■ PontaUtil test end.");

		System.out.println();

		try {
			logger.trace("■ Oracle test start.");
			t.testOracle();
			logger.trace("■ Oracle test end.");
		} catch (Exception e) {
			PontaSystemException pe = new PontaSystemException(e);
			pe.printStackTrace();
			//throw pe;
		} finally {

			System.out.println();

			logger.trace("■■■ End PontaTest.");

			logger.trace("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		}

	}

}
