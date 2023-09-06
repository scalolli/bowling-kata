class BowlingGame {
  var frames = (1..10).map { Frame(mutableListOf(), 0) }
  var currentFrame: Frame = frames.first()
  var frameIndex = 0

  fun roll(numberOfPins: Int) {
    if (numberOfPins == 10) {
      currentFrame.rolls.add(numberOfPins)
      currentFrame.score = numberOfPins
      frameIndex += 1
      currentFrame = frames.get(frameIndex)
    } else if (currentFrame.rolls.isEmpty() && numberOfPins < 10) {
      currentFrame.rolls.add(numberOfPins)
      currentFrame.score = numberOfPins
    } else if (currentFrame.rolls.first() + numberOfPins == 10) {
      currentFrame.rolls.add(numberOfPins)
      currentFrame.score = currentFrame.score + numberOfPins + numberOfPins
    } else {
      currentFrame.rolls.add(numberOfPins)
      currentFrame.score = currentFrame.score + numberOfPins
    }
  }

  fun score(): Int = currentFrame.score
}

class Frame(var rolls: MutableList<Int>, var score: Int)
