package game;

import domain.NotRegisteredException;
import domain.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Game {
    private Collection<Player> items = new ArrayList<>();


    public void setPlayersRegistered(Player player) {
        items.add(player);
    }

    public void checkForRegistered(String name) throws NotRegisteredException {
        if (searchByName(name) == null) {
            throw new NotRegisteredException("Player " + name + " is not registered");
        }
    }

    public Player searchByName(String name) {
        for (Player player : items) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String firstName, String secondName) throws NotRegisteredException {

        checkForRegistered(firstName);
        checkForRegistered(secondName);
        if (searchByName(firstName).getStrength() > searchByName(secondName).getStrength()) {
            return 1;
        }
        if (searchByName(firstName).getStrength() < searchByName(secondName).getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

}
