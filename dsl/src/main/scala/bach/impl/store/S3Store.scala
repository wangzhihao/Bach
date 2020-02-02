package bach.impl.store

import bach.spi.Store

case class S3Store[A] extends Store[A] {

    def to(sink: Sink[A]): {
      Convertor(this, sink) 
    }

    def from(source: Source[A]): {
      Convertor(source, this) 
    }
}
