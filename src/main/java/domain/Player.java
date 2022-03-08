package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Player implements Comparable<Player> {
    private int id;
    private String name;
    private int strength;

    @Override
    public int compareTo(@NotNull Player other){return this.strength - other.strength;}
}
