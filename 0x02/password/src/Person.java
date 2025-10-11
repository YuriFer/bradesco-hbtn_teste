package password.src;

public class Person {
    private String usuario;
    private String password;

    public Person() {
        this.usuario = "";
        this.password = "";
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public boolean checkUser() {
        return this.usuario.length() >= 8 && !this.usuario.matches("^[a-zA-Z0-9@#$%&*]+$");
    }

    public boolean checkPassword() {
        return this.password.length() >= 8 && this.password.matches(".*\\d.*") && this.password.matches(".*[A-Z].*") && this.password.matches("^[a-zA-Z0-9@#$%&*]+$");
    }

    public void setUsuario(String string) {
        this.usuario = string;
    }

    public void setPassword(String string) {
        this.password = string;
    }
}
