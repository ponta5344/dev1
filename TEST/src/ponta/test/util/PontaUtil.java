package ponta.test.util;

public class PontaUtil {

	public static boolean isEmpty(String value) {
		boolean ret = false;
		if (value == null || value.isEmpty()) {
			ret = true;
		}
		return ret;
	}

}
