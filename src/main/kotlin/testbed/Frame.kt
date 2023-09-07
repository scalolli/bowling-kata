package testbed

sealed class Frame
sealed class LookAheadFrame : Frame()
object Strike : LookAheadFrame()
data class Spare(val firstThrow: Int, val secondThrow: Int) : LookAheadFrame()
data class FirstThrow(val numberOfPins: Int) : Frame()
data class Miss(val firstThrow: Int, val secondThrow: Int) : Frame()

fun calculateScores(frames: List<Frame>): Map<Int, Int> {
    var scores = mutableMapOf<Int, Int>()

    frames.mapIndexed { index, frame ->
        val tuple = when (frame) {
            is FirstThrow -> TODO()
            is Miss -> index to frame.firstThrow + frame.secondThrow
            is Spare -> index to (10 + calculateBonus(frame, frames.subList(index + 1, frames.size)))
            is Strike -> index to (10 + calculateBonus(frame, frames.subList(index + 1, frames.size)))
        }
        scores[tuple.first] = tuple.second + scores.getOrDefault(index - 1, 0)
        tuple
    }

    return scores
}

private fun calculateBonus(currentFrame: LookAheadFrame, frames: List<Frame>): Int {
    return if (frames.isNotEmpty()) {
        when (currentFrame) {
            is Spare -> {
                when (val f = frames.first()) {
                    is FirstThrow -> f.numberOfPins
                    is Spare -> f.firstThrow
                    is Strike -> 10
                    is Miss -> f.firstThrow
                }
            }

            Strike -> {
                when (val f = frames.first()) {
                    is FirstThrow -> f.numberOfPins
                    is Spare -> f.firstThrow + f.secondThrow
                    is Strike -> {
                        val currentIndex = frames.indexOf(f)
                        10 + calculateBonus(f, frames.subList(currentIndex + 1, frames.size))
                    }
                    is Miss -> f.firstThrow + f.secondThrow
                }
            }
        }
    } else 0
}
