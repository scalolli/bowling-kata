import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class BowlingGameTest {

  @Test
  fun testGetScoreWhenSpareWithFirstThrow() {
    val game = BowlingGame()

    game.roll(5)

    assertEquals(5, game.score())
  }

  @Test
  fun testGetScoreWhenItsASpare() {
    val game = BowlingGame()

    game.roll(5)
    game.roll(5)

    assertEquals(15, game.score())
  }

  @Test
  fun testGetScoreWhenTheFrameWasAMiss() {
    val game = BowlingGame()

    game.roll(5)
    game.roll(4)

    assertEquals(9, game.score())
  }

  @Test
  fun testGetScoreForAStrike() {
    val game = BowlingGame()

    game.roll(10)

    assertEquals(10, game.score())
  }
}
