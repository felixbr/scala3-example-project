package twitter

trait TimeLike[This <: TimeLike[This]]

trait TimeLikeOps[This <: TimeLike[This]] {
  def fromMilliseconds(milliseconds: Long): This

  def fromSeconds(seconds: Long): This = fromMilliseconds(seconds * 1000L)
}

sealed class Duration(val milliseconds: Long) extends TimeLike[Duration]
object Duration extends TimeLikeOps[Duration] {
  def fromMilliseconds(milliseconds: Long): Duration = new Duration(milliseconds)

  override def fromSeconds(seconds: Long): Duration = super.fromSeconds(seconds)
}
