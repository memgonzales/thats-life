package core;

/**
 * Interface representing a game component that requires interaction from the
 * player in generating a random number while the game itself is in motion
 * (for example, the player has to spin a wheel to obtain a random number
 * upon drawing some specific blue cards)
 */
public interface PlayerRandom {
    /**
     * Abstract method for returning the number obtained after spinning the
     * number wheel of the game
     *
     * <p>To simulate the randomness of the outcome when spinning a number wheel,
     * all implementations of this method in this machine project use the Java
     * <code>ThreadLocalRandom</code> utility class. Therefore, the number is generated
     * in a pseudorandom fashion, which is adequate for the purposes of the game.</p>
     *
     * @param w number wheel of the game
     * @param currPlayer current player with turn
     * @return number obtained after spinning the wheel of the game
     */
    public abstract int spinWheel(NumberWheel w, Player currPlayer);
}