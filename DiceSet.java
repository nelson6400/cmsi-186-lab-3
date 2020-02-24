import java.util.*;

/**
 * A dice set holds a collection of Die objects. All of the die objects have
 * the same number of sides.
 */
public class DiceSet {

    private Die[] dice;

    /**
     * Creates a DiceSet containing the given number of dice, each with the
     * given number of sides. All die values start off as 1. Throws an
     * IllegalArgumentException if either less than two dice were provided
     * or if it is asked to make dice with less than 4 sides.
     */
    public DiceSet(int sidesOnEachDie, int numberOfDice) {
        if (numberOfDice < 2) {
            throw new IllegalArgumentException("At least two dice required");
        }
        if (sidesOnEachDie < 4) {
            throw new IllegalArgumentException("Dice must have at least four sides");
        }
        this.dice = new Die[numberOfDice];
        for (var i = 0; i < dice.length; i++) {
            this.dice[i] = new Die(sidesOnEachDie, 1);
        }
    }

    /**
     * Creates a DiceSet where each die has the given number of sides, with the
     * given values.
     */
    public DiceSet(int sidesOnEachDie, int... values) {
        if (sidesOnEachDie < 4) {
            throw new IllegalArgumentException("Dice must have at least 4 sides");
        };
        if (values.length < 2) {
                throw new IllegalArgumentException("At least two dice required");
        }
        this.dice = new Die[values.length];
        for (int i = 0; i < values.length; i++) {
            this.dice[i] = new Die(sidesOnEachDie, values[i]);
        }
    }

    /**
     * Returns the descriptor of the dice set; for example "5d20" for a set with
     * five dice of 20 sides each; or "2d6" for a set of two six-sided dice.
     */
    public String descriptor() {
        return this.dice.length + "d" + this.dice[0].getSides();
    }

    /**
     * Returns the sum of the values of each die in the set.
     */
    public int sum() {
        int sum = 0;
        for (int i = 0; i < this.dice.length; i++) {
            sum += this.dice[i].getValue();
        }
        return sum;
    }

    /**
     * Rolls all the dice in the set.
     */
    public void rollAll() {
        for (int i = 0; i < this.dice.length; i++) {
            this.dice[i].roll();
        }
    }

    /**
     * Rolls the ith die, updating its value.
     */
    public void rollIndividual(int i) {
        this.dice[i].roll();
    }

    /**
     * Returns the value of the ith die.
     */
    public int getIndividual(int i) {
        return this.dice[i].getValue();
    }

    /**
     * Returns the values of each of the dice in a list.
     */
    public List<Integer> values() {
        var result = new ArrayList<Integer>();
        for (var d: this.dice){
            result.add(d.getValue());
        }
        return result;
    }

    /**
     * Returns whether this dice set has the same distribution of values as
     * an other dice set. The two dice sets must have the same number of dice
     * and the same number of sides per dice, and there must be the same
     * number of each value in each set.
     */
    public boolean isIdenticalTo(DiceSet diceSet) {
        return true;
    }

    /**
     * Returns a string representation in which each of the die strings are
     * joined without a separator, for example: "[2][5][2][3]".
     */
    @Override public String toString() {
        var result = "";
        for (var d: this.dice){
            result += "[" + d.getValue() + "]";
        }
            return result;
    }
}
