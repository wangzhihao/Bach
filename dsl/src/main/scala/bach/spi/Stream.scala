package bach.spi

trait Stream[A] extends Source[A] with Sink[A] {

  def map(transformer: A => B): Stream[B]

}
