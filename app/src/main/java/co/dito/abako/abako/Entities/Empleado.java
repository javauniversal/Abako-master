package co.dito.abako.abako.Entities;

public class Empleado {

    private String nombre_empleado;

    private int id_empleado;

    private String password;

    private static String ip_select;

    public static String getIp_select() {
        return ip_select;
    }

    public static void setIp_select(String ip_select) {
        Empleado.ip_select = ip_select;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

}
