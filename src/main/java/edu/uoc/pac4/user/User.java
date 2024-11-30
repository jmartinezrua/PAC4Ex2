package edu.uoc.pac4.user;

public abstract class User {
    private String email;
    private String name;
    private String surname;

    public User(String email, String name, String surname) throws UserException {
        setEmail(email);
        setName(name);
        setSurname(surname);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws UserException {
        if (email == null || !email.matches("^[^@]+@uoc\\.edu$")) {
            throw new UserException(UserException.INVALID_EMAIL);
        }
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws UserException {
        if (name == null || name.trim().isEmpty()) {
            throw new UserException(UserException.INVALID_NAME);
        }
        this.name = name.trim();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = (surname == null) ? "" : surname.trim();
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + email + ")";
    }
}