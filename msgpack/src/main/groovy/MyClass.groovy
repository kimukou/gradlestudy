import org.msgpack.MessagePack
import org.msgpack.annotation.MessagePackMessage
import org.msgpack.annotation.Optional

// ユーザー定義のクラス
// アノテーションを付ける
@MessagePackMessage
public class MyClass {
    String str
    double num

		// new field
    //@Optional
    public int flag = 0;
}
