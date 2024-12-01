package edu.uoc.pac4.activity;

/**
 * Class representing a C++ programming activity.
 */
public class ActivityProgrammingCpp extends ActivityProgramming {
    private String compiler;
    private String standard;

    /**
     * Constructs a new ActivityProgrammingCpp.
     *
     * @param name        the name of the activity
     * @param description the description of the activity
     * @param weight      the weight of the activity
     * @param compiler    the C++ compiler to be used
     * @param standard    the C++ standard to be used
     * @throws ActivityException if any parameter is invalid
     */
    public ActivityProgrammingCpp(String name, String description, double weight, String compiler, String standard) throws ActivityException {
        super(name, description, weight);
        setCompiler(compiler);
        setStandard(standard);
    }

    /**
     * Gets the compiler used for this activity.
     *
     * @return the compiler
     */
    public String getCompiler() {
        return compiler;
    }

    /**
     * Sets the compiler for this activity.
     *
     * @param compiler the compiler to set
     * @throws ActivityException if the compiler is null or empty
     */
    public void setCompiler(String compiler) throws ActivityException {
        if (compiler == null || compiler.trim().isEmpty()) {
            throw new ActivityException(ActivityException.INVALID_CPP_COMPILER);
        }
        this.compiler = compiler.trim();
    }

    /**
     * Gets the standard used for this activity.
     *
     * @return the standard
     */
    public String getStandard() {
        return standard;
    }

    /**
     * Sets the standard for this activity.
     *
     * @param standard the standard to set
     * @throws ActivityException if the standard is null or empty
     */
    public void setStandard(String standard) throws ActivityException {
        if (standard == null || standard.trim().isEmpty()) {
            throw new ActivityException(ActivityException.INVALID_CPP_STANDARD);
        }
        this.standard = standard.trim();
    }

    @Override
    public String toString() {
        return "[C++] " + super.toString() + " (" + getCompiler() + ", " + getStandard() + ")";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
