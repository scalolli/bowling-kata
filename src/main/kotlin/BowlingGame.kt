class BowlingGame {
  var frames = (1..10).map { Frame(mutableListOf(), 0) }
  var currentFrame: Frame = frames.first()
  var frameIndex = 0

  fun roll(numberOfPins: Int) {
    if (isStrike(numberOfPins)) {
      currentFrame.rolls.add(numberOfPins)
      currentFrame.score = numberOfPins
      val previousScore = currentFrame.score
      frameIndex += 1
      currentFrame = frames[frameIndex]
      currentFrame.score = previousScore
    } else if (isSpare(numberOfPins)) {
      if (firstThrow()) {
        currentFrame.score = currentFrame.score + numberOfPins
        currentFrame.rolls.add(numberOfPins)
      } else if (!firstThrow() && notAnOpenFrame(numberOfPins)) {
        currentFrame.score = currentFrame.score + numberOfPins + numberOfPins
        currentFrame.rolls.add(numberOfPins)
        val previousScore = currentFrame.score
        frameIndex += 1
        currentFrame = frames[frameIndex]
        currentFrame.score = previousScore
      } else {
        // miss
        currentFrame.rolls.add(numberOfPins)
        currentFrame.score = currentFrame.score + numberOfPins
        val previousScore = currentFrame.score
        frameIndex += 1
        currentFrame = frames[frameIndex]
        currentFrame.score = previousScore
      }
    }
  }

  private fun notAnOpenFrame(numberOfPins: Int) = currentFrame.rolls.first() + numberOfPins == 10
  private fun firstThrow() = currentFrame.rolls.isEmpty()
  private fun isSpare(numberOfPins: Int) = numberOfPins < 10
  private fun isStrike(numberOfPins: Int) = numberOfPins == 10
  fun score(): Int = currentFrame.score
}

class Frame(var rolls: MutableList<Int>, var score: Int)
