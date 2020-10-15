package core;

/**
 * Interface representing a game component that requires a machine-generated
 * random number (that is, it does not require any interaction from the player),
 * usually to initialize one or more of its attributes at the start of every game
 *
 * <p>The implementation of the method in this interface varies depending
 * on the specifications of the component. Typically, an upper and lower bound
 * are supplied, and increments have to be taken into account, as is the case
 * in most of the cards (except for some blue cards). </p>
 */
public interface MachineRandom {
    /**
     * Abstract method for returning a randomly generated number
     *
     * <p>All implementations of this method in this machine project use the Java
     * <code>ThreadLocalRandom</code> utility class. Therefore, the number is generated
     * in a pseudorandom fashion, which is adequate for the purposes of the game.</p>
     *
     * @return randomly generated number
     */
    public abstract int getMachineRandNum();
}
