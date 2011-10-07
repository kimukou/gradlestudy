import org.msgpack.MessagePack

MyClass src = new MyClass(str:"msgpack",num:0.4)
println "src=${src.dump()}"

MessagePack msgpack = new MessagePack()
// シリアライズ
//byte[] raw = MessagePack.pack(src)
byte[] raw = msgpack.write(src)
println "raw=$raw"

// デシリアライズ
//MyClass dst = MessagePack.unpack(raw, MyClass.class)
MyClass dst = msgpack.read(raw, MyClass.class)
println "dst=${dst.dump()}"

