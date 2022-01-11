package utilities;

public class Config {
    public User[] user;
    public Dito[] dito;

    public User[] getUsers() {
        return user;
    }

    public void setUsers(User[] user) {
        this.user = user;
    }

    public Dito[] getDito() { return dito; }

    public void setDito(Dito[] dito) { this.dito = dito; }
}
