package ponta.test.util;

import java.io.UnsupportedEncodingException;

import ponta.test.Exeption.PontaSystemException;

/**
 * 文字列ユーティリティクラス
 * @author ponta
 *
 */
public class StringUtil {

	private static final String CHARASET_JP = "MS932";

	public String getItem(String item, int stratIndex, int length){
		String ret = "";
		byte[] bt = {};

		try {
			bt = item.getBytes(CHARASET_JP);
			ret =new String(bt,stratIndex - 1 , length, CHARASET_JP);
		} catch (UnsupportedEncodingException | StringIndexOutOfBoundsException e) {
			String className = StringUtil.getClassName();
			String methodName = StringUtil.getMethodName();
			String message = className + "." + methodName
					+ "の文字列分割で異常が発生しました。（データ長=[" + bt.length + "]、分割開始位置=[" + stratIndex + "]、項目長=[" + length + "]）";
			throw new PontaSystemException(message, e);
		}
		return ret;
	}


    /**
     * 実行中のクラス名を取得します。
     * @return クラス名
     */
    public static String getClassName() {
        return Thread.currentThread().getStackTrace()[2].getClassName();
    }

    /**
     * 実行中のメソッド名を取得します。
     * @return メソッド名
     */
    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

	/**
	 *
	 * SQLバインド変数値埋め込み成形処理
	 *
	 * @param sql
	 * @param arguments
	 * @return
	 */
	public static String formatQuery(final String sql, Object... arguments) {
		for (Object object : arguments) {
			String cn = object.getClass().getName();
			System.out.println(object + "=(" + cn + ")");
		}
		if (arguments != null && arguments.length <= 0) {
			return sql;
		}
		String query = sql;
		int count = 0;
		while (query.matches("(.*)\\?(.*)")) {
			query = query.replaceFirst("\\?", "{" + count + "}");
			count++;
		}
		String formatedString = java.text.MessageFormat.format(query, arguments);
		return formatedString;
	}
}
