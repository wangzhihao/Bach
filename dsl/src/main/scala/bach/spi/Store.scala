package bach.spi

trait Store[A] extends Source[A] with Sink[A] {
  def tail: Unit
}
