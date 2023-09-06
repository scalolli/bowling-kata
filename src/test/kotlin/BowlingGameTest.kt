import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class BowlingGameTest {

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
}
