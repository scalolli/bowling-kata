import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class BowlingGameTest {

  @Test
  fun testGetScoreForFirstFrame() {
    val game = BowlingGame()

    game.roll(5)

    assertEquals(5, game.score())
  }
}
