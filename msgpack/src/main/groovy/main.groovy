import org.msgpack.MessagePack
import org.msgpack.annotation.MessagePackMessage

MyClass src = new MyClass(str:"msgpack",num:0.4)

// シリアライズ
byte[] raw = MessagePack.pack(src)

// デシリアライズ
MyClass dst = MessagePack.unpack(raw, MyClass.class)
println "dst=${dst.dump()}"

