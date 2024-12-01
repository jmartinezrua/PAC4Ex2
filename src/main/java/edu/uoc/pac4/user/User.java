package edu.uoc.pac4.user;

/**
 * Abstract class representing a user.
 */
public abstract class User {
    private String email;
    private String name;
    private String surname;

    /**
     * Constructs a new User.
     *
     * @param email    the email of the user
     * @param name     the name of the user
     * @param surname  the surname of the user
     * @throws UserException if the email or name is invalid
     */
    public User(String email, String name, String surname) throws UserException {
        setEmail(email);
        setName(name);
        setSurname(surname);
    }

    /**
     * Gets the email of the user.
     *
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the email to set
     * @throws UserException if the email is invalid
     */
    public void setEmail(String email) throws UserException {
        if (email == null || !email.matches("^[^@]+@uoc\\.edu$")) {
            throw new UserException(UserException.INVALID_EMAIL);
        }
        this.email = email;
    }

    /**
     * Gets the name of the user.
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name the name to set
     * @throws UserException if the name is null or empty
     */
    public void setName(String name) throws UserException {
        if (name == null || name.trim().isEmpty()) {
            throw new UserException(UserException.INVALID_NAME);
        }
        this.name = name.trim();
    }

    /**
     * Gets the surname of the user.
     *
     * @return the surname of the user
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of the user.
     *
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = (surname == null) ? "" : surname.trim();
    }

    /**
     * Returns a string representation of the user.
     *
     * @return a string representing the user
     */
    @Override
    public String toString() {
        return name + " " + surname + " (" + email + ")";
    }
}
