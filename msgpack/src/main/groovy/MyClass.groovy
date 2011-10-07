//import org.msgpack.MessagePack
//import org.msgpack.annotation.MessagePackMessage
import org.msgpack.annotation.Message
import org.msgpack.annotation.Optional

// ユーザー定義のクラス
// アノテーションを付ける
//@MessagePackMessage
@Message
public class MyClass {

		//[NOTE]変数にpublic宣言がないと上手くシリアライズ、デシリアライズが出来ないみたい
    public String str
    public double num

		// new field
    @Optional
    public int flag = 0
}
