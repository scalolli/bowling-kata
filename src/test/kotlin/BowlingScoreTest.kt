import org.junit.jupiter.api.Test
import testbed.Miss
import testbed.Spare
import testbed.calculateScores
import kotlin.test.assertEquals

class BowlingScoreTest {

    @Test
    fun testScoreForSingleFrame() {
        val frames = listOf(Spare(4, 6), Miss(1, 8))
        val scores = mapOf(0 to 11, 1 to 20)

        val frameNumberToScore = calculateScores(frames)

        assertEquals(scores, frameNumberToScore)
    }
}