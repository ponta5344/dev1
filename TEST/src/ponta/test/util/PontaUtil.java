package ponta.test.util;

public class PontaUtil {

	public static boolean isEmpty(String value) {
		boolean ret = false;
		if (value == null || value.isEmpty()) {
			ret = true;
		}
		return ret;
	}

	public static String getEnv(String value) {
		String envStr;
		if (isEmpty(value)) {
			envStr = null;
		} else {
			envStr = System.getenv(value);
		}
		return envStr;
	}
}


