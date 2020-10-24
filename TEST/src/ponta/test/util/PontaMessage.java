package ponta.test.util;

import java.util.ArrayList;

import ponta.test.message.MessageEnum;

public class PontaMessage {
	public String getMessage(String msgId, ArrayList<String> paramList) {
		String ret = "";
		try {
			String msg = assenbleMessage(msgId, paramList);
			ret = msg;
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return ret;
	}

	private String assenbleMessage(String msgId, ArrayList<String> paramList) throws Exception {
		String retMsg = "";
		String msg = "";
		int i = 0;
		boolean chgFlg = false;
		StringBuffer msgBuf = new StringBuffer();
		StringBuffer newMsg = new StringBuffer();

		int sepFCount = 0;
		int sepACount = 0;
		int prmCount = 0;
		ArrayList<String> msgList = new ArrayList<String>();

		for (MessageEnum enumMsg : MessageEnum.values()) {
			msg = enumMsg.getValue();
			if (enumMsg.name().equals(msgId)) {

				prmCount = paramList.size();

				String chr = "";
				for (int count = 0; count < msg.length(); count++) {
					chr = msg.substring(count, count + 1);
					if (!chgFlg) {
						if ("{".equals(chr)) {
							msgList.add(msgBuf.toString());
							sepFCount++;
							chgFlg = true;
						} else if ("}".equals(chr)) {
							msgBuf = new StringBuffer();
						} else {
							msgBuf.append(chr);
						}
					} else {
						if ("}".equals(chr)) {
							sepACount++;
							msgBuf = new StringBuffer();
							chgFlg = false;
						}
					}
				}
				msgList.add(msgBuf.toString());

				if (sepFCount != sepACount) {
					throw new Exception("区切り文字の数が一致しません。");
				} else if (prmCount != sepFCount) {
					throw new Exception("パラメータの数が一致しません。");
				}

				for (String m : msgList) {
					if (i == 0) {
						newMsg.append(msgId);
						newMsg.append(" : ");
						newMsg.append(m);
					} else {
						newMsg.append(m);
					}

					if (i < prmCount) {
						newMsg.append(paramList.get(i++));
					}
				}
			}
		}
		retMsg = newMsg.toString();
		return retMsg;
	}
}
