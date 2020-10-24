package ponta.test.message;

/**
 * メッセージ列挙型クラスサンプル
 * @author ponta
 *
 */
public enum MessageEnum {
	BI001("めっせーじ００１"),
	BI002("めっせーじ００２"),
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
