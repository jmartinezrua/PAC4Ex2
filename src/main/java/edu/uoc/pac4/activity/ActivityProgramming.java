package edu.uoc.pac4.activity;

/**
 * Abstract class representing a programming activity that can be evaluated.
 */
public abstract class ActivityProgramming extends Activity implements Evaluable {
    private double weight;

    /**
     * Constructs a new ActivityProgramming.
     *
     * @param name        the name of the activity
     * @param description the description of the activity
     * @param weight      the weight of the activity
     * @throws ActivityException if the name is invalid
     */
    public ActivityProgramming(String name, String description, double weight) throws ActivityException {
        super(name, description);
        setWeight(weight);
    }

    /**
     * Gets the weight of the activity.
     *
     * @return the weight of the activity
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the activity.
     *
     * @param weight the new weight of the activity
     */
    public void setWeight(double weight) {
        if (weight < 0 || weight > 100) {
            weight = Math.max(0, Math.min(weight, 100));
        }
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + weight + "%)";
    }
}
