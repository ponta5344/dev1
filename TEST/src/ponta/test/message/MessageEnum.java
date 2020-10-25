package ponta.test.message;

/**
 * メッセージ列挙型クラスサンプル
 * @author ponta
 *
 */
public enum MessageEnum {
	BI0001("{0}を開始しました。（起動引数=[{1}]）"),
	BI0002("{0}を終了しました。（処理時間=[{1}]）"),
	BE1218("エラー１２１８"),
	BE1219("エラー１２１９"),
	BE1220("エラー１２２０"),
	BE1221("エラー１２２１({%1}, {%2})");
    // フィールドの定義
    private String name;

    // コンストラクタの定義
    private MessageEnum(String name) {
        this.name = name;
    }
    public String getValue() {
        return this.name;
    }
}
