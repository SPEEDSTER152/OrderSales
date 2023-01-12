package entities;

public class User {

    Integer idUser;

    String nameUser;

    User user;

    String passwordUser;

    public User(Integer idUser, String nameUser, User user, String passwordUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.user = user;
        this.passwordUser = passwordUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
}
