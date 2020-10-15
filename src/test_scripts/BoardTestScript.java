

import core.Board;

/**
 * Test script for <code>Board</code> class
 */
public class BoardTestScript {
    public static void main(String[] args) {
        Board b;

        /* Constructor: Board()
         * A Board object is created to test its methods */
        b = new Board();

        System.out.println("isOrangeSpace()");

        /* Method: isOrangeSpace(int index)
         *  Test case 1: The index of the start space is passed as a parameter.
         *  Expected output: false. */
        System.out.println("Test case 1: The index of the start space is passed as a parameter.");

        System.out.println(b.isOrangeSpace(0));

        /* Method: isOrangeSpace(int index)
         *  Test case 2: The index of an orange space is passed as a parameter.
         *  Expected output: true. */
        System.out.println("Test case 2: The index of an orange space is passed as a parameter.");

        System.out.println(b.isOrangeSpace(1));

        System.out.println();
        System.out.println("isBlueSpace()");

        /* Method: isBlueSpace(int index)
         *  Test case 1: The index of the start space is passed as a parameter.
         *  Expected output: false. */
        System.out.println("Test case 1: The index of the start space is passed as a parameter.");

        System.out.println(b.isBlueSpace(0));

        /* Method: isBlueSpace(int index)
         *  Test case 2: The index of a blue space is passed as a parameter.
         *  Expected output: true. */
        System.out.println("Test case 2: The index of a blue space is passed as a parameter.");

        System.out.println(b.isBlueSpace(15));

        System.out.println();
        System.out.println("isGreenSpace()");

        /* Method: isGreenSpace(int index)
         *  Test case 1: The index of the start space is passed as a parameter.
         *  Expected output: false. */
        System.out.println("Test case 1: The index of the start space is passed as a parameter.");

        System.out.println(b.isGreenSpace(0));

        /* Method: isGreenSpace(int index)
         *  Test case 2: The index of a green space is passed as a parameter.
         *  Expected output: true. */
        System.out.println("Test case 2: The index of a green space is passed as a parameter.");

        System.out.println(b.isGreenSpace(18));

        System.out.println();
        System.out.println("isMagentaSpace()");

        System.out.println();
        System.out.println("isMagentaSpace()");

        /* Method: isMagentaSpace(int index)
         *  Test case 1: The index of the start space is passed as a parameter.
         *  Expected output: false. */
        System.out.println("Test case 1: The index of the start space is passed as a parameter.");

        System.out.println(b.isMagentaSpace(0));

        /* Method: isMagentaSpace(int index)
         *  Test case 2: The index of a magenta space is passed as a parameter.
         *  Expected output: true. */
        System.out.println("Test case 2: The index of a magenta space is passed as a parameter.");

        System.out.println(b.isMagentaSpace(4));

        System.out.println();
        System.out.println("getMachineRandNum()");

        /* Method: getMachineRandNum()
         *  Test case 1: The getMachineRandNum() method of this object is called.
         *  Expected output: Either the number 1 or 2. */
        System.out.println("Test case 1: The getMachineRandNum() method of this object is called.");

        System.out.println(b.getMachineRandNum());
    }
}
