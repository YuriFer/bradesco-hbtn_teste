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
        if (!this.password.matches(".*[A-Z].*")) {
            return false;
        }

        if (!this.password.matches(".*\\d.*")) {
            return false;
        }

        if (!this.password.matches("^[a-zA-Z0-9@#$%&*]+$")) {
            return false;
        }

        if (this.password.length() < 8) {
            return false;
        }

        return true;
    }

    public void setUsuario(String string) {
        this.usuario = string;
    }

    public void setPassword(String string) {
        this.password = string;
    }
}
