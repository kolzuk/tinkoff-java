package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTest {
    @Test
    public void Test1() {
        GameManager gameManager = new GameManager("test");

        assertThat(gameManager.getMaximumAttempts())
                .isEqualTo(4);

        while (gameManager.canDoMove()) {
            assertThat(gameManager.isGuessed('a'))
                    .isFalse();
        }

        assertThat(gameManager.isVictory())
                .isFalse();
        assertThat(gameManager.getCurrentWord())
                .isEqualTo("****");
        assertThat(gameManager.canDoMove())
                .isFalse();

    }

    @Test
    public void Test2() {
        GameManager gameManager = new GameManager("kolzuk");
        assertThat(gameManager.getCurrentWord())
                .isEqualTo("******");

        assertThat(gameManager.isGuessed('k'))
                .isTrue();

        assertThat(gameManager.getCurrentWord())
                .isEqualTo("k****k");

        assertThat(gameManager.isGuessed('o'))
                .isTrue();

        assertThat(gameManager.getCurrentWord())
                .isEqualTo("ko***k");

        assertThat(gameManager.isGuessed('l'))
                .isTrue();

        assertThat(gameManager.getCurrentWord())
                .isEqualTo("kol**k");


        assertThat(gameManager.isGuessed('z'))
                .isTrue();

        assertThat(gameManager.getCurrentWord())
                .isEqualTo("kolz*k");


        assertThat(gameManager.isGuessed('u'))
                .isTrue();

        assertThat(gameManager.getCurrentWord())
                .isEqualTo("kolzuk");

        assertThat(gameManager.isVictory())
                .isTrue();
    }

    @Test
    @DisplayName("Wrong input test")
    public void Test3() {
        GameManager gameManager = new GameManager("itmo");

        assertThat(GameRunner.nextMove("asd", gameManager))
                .isEqualTo(GameState.WRONG_INPUT);

        assertThat(GameRunner.nextMove("", gameManager))
                .isEqualTo(GameState.WRONG_INPUT);

        assertThat(gameManager.getCountOfAttempts())
                .isEqualTo(0);
    }
}
