import org.junit.jupiter.api.Test
import testbed.*
import kotlin.test.assertEquals

class BowlingScoreTest {

    @Test
    fun testScoreForSpareAndMiss() {
        val frames = listOf(Spare(4), Miss(1, 8))
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

    @Test
    fun testScoreForMissStrikeAndLastFrame() {
        val frames = listOf(Miss(1, 4), Strike, LastFrame(6, 4, 10))
        val scores = mapOf(0 to 5, 1 to 25, 2 to 45)

        val frameNumberToScore = calculateScores(frames)

        assertEquals(scores, frameNumberToScore)
    }

    @Test
    fun testScoreForMissSpareAndLastFrame() {
        val frames = listOf(Miss(1, 4), Spare(6), LastFrame(6, 4, 10))
        val scores = mapOf(0 to 5, 1 to 21, 2 to 41)

        val frameNumberToScore = calculateScores(frames)

        assertEquals(scores, frameNumberToScore)
    }

    @Test
    fun testFullGameScore() {
        val frames = listOf(
            Miss(1, 4),
            Miss(4, 5),
            Spare(6),
            Spare(5),
            Strike,
            Miss(0, 1),
            Spare(7),
            Spare(6),
            Strike,
            LastFrame(2, 8, 6)
        )
        val scores = listOf(5, 14, 29, 49, 60, 61, 77, 97, 117, 133).mapIndexed { index, value -> index to value }.toMap()

        val frameNumberToScore = calculateScores(frames)

        assertEquals(scores, frameNumberToScore)
    }
}