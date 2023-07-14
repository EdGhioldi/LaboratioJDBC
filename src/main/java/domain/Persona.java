package domain;

public class Persona {
    public int id_usuario;
    public String usuario;
    public String password;

    public Persona(){};
    public Persona(int id_usuario){
        this.id_usuario = id_usuario;
    }
    public Persona(String usuario, String password){
        this.usuario = usuario;
        this.password = password;
    }
    public Persona(int id_usuario, String usuario, String password){
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.password = password;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id_usuario=" + id_usuario +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
