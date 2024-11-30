// ActivityProgramming.java
package edu.uoc.pac4.activity;

public abstract class ActivityProgramming extends Activity implements Evaluable {
    private double weight;

    public ActivityProgramming(String name, String description, double weight) throws ActivityException {
        super(name, description);
        setWeight(weight);
    }

    public double getWeight() {
        return weight;
    }

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