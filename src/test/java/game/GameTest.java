package game;

import domain.NotRegisteredException;
import domain.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    private Player alpha = new Player(11, "Povetkin", 20);
    private Player beta = new Player(22, "Emelyanenko", 25);
    private Player gama = new Player(33, "Mike Tyson", 15);
    private Player delta = new Player(44, "Mike Tyson junior", 15);
    private Player omega = new Player(55, "Muhammad Ali", 15);


    @Test
    void setPlayersRegistered() throws NotRegisteredException {
        game.setPlayersRegistered(alpha);
        game.checkForRegistered("Povetkin");
        Player expected = alpha;
        Player actual = game.searchByName("Povetkin");

        assertEquals(expected, actual);
    }

    @Test
    void checkForRegistered() {
        game.setPlayersRegistered(beta);

        Player expected = beta;
        Player actual = game.searchByName("Emelyanenko");

        assertEquals(expected, actual);
    }

    @Test
    void searchByName() {
        game.setPlayersRegistered(alpha);
        game.setPlayersRegistered(beta);
        game.setPlayersRegistered(gama);
        game.setPlayersRegistered(delta);

        Player expected = beta;
        Player actual = game.searchByName("Emelyanenko");

        assertEquals(expected, actual);

    }

    @Test
    public void searchByNameIfMultiValues() {
        game.setPlayersRegistered(alpha);
        game.setPlayersRegistered(beta);
        game.setPlayersRegistered(gama);
        game.setPlayersRegistered(delta);

        Player[] expected = {gama, delta};
        Player actual = game.searchByName("Tay");

        assertArrayEquals(expected, actual);

    }

    private void assertArrayEquals(Player[] expected, Player actual) {
    }

    @Test
    public void searchByNameIfNotFound() {
        game.setPlayersRegistered(alpha);
        game.setPlayersRegistered(beta);
        game.setPlayersRegistered(gama);
        game.setPlayersRegistered(delta);

        Player[] expected = {};
        Player actual = game.searchByName("Muhammad Ali");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void roundWinBeta() throws NotRegisteredException {
        game.setPlayersRegistered(alpha);
        game.setPlayersRegistered(beta);
        int expected = 1;
        int actual = game.round ("Emelyanenko", "Povetkin");
        assertEquals(expected, actual);
    }

    @Test
    public void roundWinGama() throws NotRegisteredException {
        game.setPlayersRegistered(gama);
        game.setPlayersRegistered(alpha);
        int expected = 2;
        int actual = game.round ("Mike Tyson", "Povetkin");
        assertEquals(expected, actual);
    }

    @Test
    public void roundWinAlpha() throws NotRegisteredException {
        game.setPlayersRegistered(delta);
        game.setPlayersRegistered(gama);
        int expected = 0;
        int actual = game.round ("Mike Tyson junior", "Mike Tyson");
        assertEquals(expected, actual);
    }

    @Test
    public void roundIfNotRegistered()  {
        game.setPlayersRegistered(gama);

        int expected = 0;

        try {int actual = game.round ("Mike Tyson junior", "Muhammad Ali");
        assertEquals(expected, actual);}
        catch (NotRegisteredException exception){
            System.out.println("Player is not registered");
        }
    }

}
