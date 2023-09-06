class BowlingGame {
  var frames = (1 .. 10).map { Frame(emptyList(), 0) }
  var currentFrame: Frame = frames.first()

  fun roll(numberOfPins: Int) {
      currentFrame.score = currentFrame.score + numberOfPins
  }

  fun score(): Int = currentFrame.score
}

class Frame(var rolls: List<Int>, var score: Int)
