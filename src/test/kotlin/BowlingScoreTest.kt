import org.junit.jupiter.api.Test
import testbed.Miss
import testbed.Spare
import testbed.Strike
import testbed.calculateScores
import kotlin.test.assertEquals

class BowlingScoreTest {

    @Test
    fun testScoreForSpareAndMiss() {
        val frames = listOf(Spare(4, 6), Miss(1, 8))
        val scores = mapOf(0 to 11, 1 to 20)

        val frameNumberToScore = calculateScores(frames)

        assertEquals(scores, frameNumberToScore)
    }

    @Test
    fun testScoreForStrikeAndMiss() {
        val frames = listOf(Strike, Miss(1, 8))
        val scores = mapOf(0 to 19, 1 to 28)

        val frameNumberToScore = calculateScores(frames)

        assertEquals(scores, frameNumberToScore)
    }
}