package bach.spi

trait Source[A] {

  def to(sink: Sink[A]): Unit = {
    Convertor(this, sink)
  }
}
