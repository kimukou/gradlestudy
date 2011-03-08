import org.msgpack.MessagePack
import org.msgpack.annotation.MessagePackMessage

// ユーザー定義のクラス
// アノテーションを付ける
@MessagePackMessage
public class MyClass {
    String str
    double num
}
