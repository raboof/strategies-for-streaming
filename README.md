# Strategies for Streaming

These are the slides for the 'Strategies for Streaming' talk.

The HTML version of the slides can be found at https://raboof.github.io/strategies-for-streaming .

There is also a [recording](https://www.youtube.com/watch?v=GMUXXGJW7Qw) of this talk at [CurryOn 2018](http://www.curry-on.org/2018/sessions/strategies-for-streaming.html)

## Abstract

When a program must process many concurrent data streams, there is a number of general techniques available: for example you may use push or pull, and you may choose to use blocking threads or go asynchronous. In this talk we explore the design space and highlight a number of possible desirable properties of streaming systems. We show where the approach standardized in the [Reactive Streams](https://www.reactive-streams.org/) initiative falls in this spectrum, and look at a practical example using [Akka Streams](https://doc.akka.io/docs/akka/current/stream/) on the JVM

## Building

Generate the slides for this task with `sbt paradox`. You will find them in `target/paradox/site/main/index.html`.
