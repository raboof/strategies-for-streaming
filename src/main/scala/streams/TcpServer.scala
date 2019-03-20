package sc.streams

import scala.concurrent.duration._

import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, ThrottleMode}
import akka.stream.scaladsl.{Flow, Sink, Source, Tcp}
import akka.stream.scaladsl.Tcp.IncomingConnection
import akka.util.ByteString

object TcpServer extends App {
  implicit val system = ActorSystem()
  implicit val mat = ActorMaterializer()

  //#bind
  val bind: Source[IncomingConnection, _] =
    Tcp(system).bind("127.0.0.1", 8081)
  //#bind

  //#flow
  val sink = Sink.ignore

  val source = Source(0 to 200000000)
    .throttle(5000, per = 10.milliseconds, maximumBurst = 1000, ThrottleMode.shaping)
    .map(i => ByteString.fromString(i.toString + "\n"))

  val flow = Flow.fromSinkAndSourceCoupled(sink, source)
  //#flow

  //#run
  bind.runForeach(conn => {
    conn.handleWith(flow)
  })
  //#run
}
