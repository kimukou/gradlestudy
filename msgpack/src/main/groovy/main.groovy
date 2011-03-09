import org.msgpack.MessagePack
import org.msgpack.annotation.MessagePackMessage

MyClass src = new MyClass(str:"msgpack",num:0.4)
println "src=${src.dump()}"

// シリアライズ
byte[] raw = MessagePack.pack(src)
println "raw=$raw"

// デシリアライズ
MyClass dst = MessagePack.unpack(raw, MyClass.class)
println "dst=${dst.dump()}"

