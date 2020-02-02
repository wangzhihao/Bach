package bach.spi

trait Sink[A] {

  def from(source: Source[A]): Unit
}
