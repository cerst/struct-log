import scala.util.control.Breaks._

trait LogObject {

  // TODO: return level as well
  def toBytes(): Array[Byte]

}

sealed trait LogObjectValue[A <: LogObject, V] {
  def put(logObject: A, value: V): Unit
}

class JsonLogger extends Log[JsObject] {
  override def info(args: Map[String, LogObjectValue[_]]): Unit = ???
}

final class JsLogObject extends LogObject {
  private val root = JsObject(Map.empty)

  def put(path: String, jsValue: JsValue): Unit = {
    val pathAsArray = path.split(".")
    breakable {
      var node: JsObject = root
      for(index <- 0 to pathAsArray.length -2 ) {
        val segment = pathAsArray(index)
        node.value.get(segment) match
          case None =>

          case Some(child: JsObject) =>
            node = child
          case Some(other) =>
      }
    }

  }

  override def toBytes(): Array[Byte] = ???
}

sealed trait JsValue

final case class JsInt(value: Int) extends JsValue

final case class JsObject(value: Map[String, JsValue]) extends JsValue

final case class JsString(value: String) extends JsValue
