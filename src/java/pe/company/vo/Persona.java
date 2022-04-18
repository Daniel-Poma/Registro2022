/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.company.vo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"id", "nombres", "apellidos","redSocial", "cuentaRedSocial"})
public class Persona {
    private int id;
    private String nombres;
    private String apellidos;
    private RedSocial redSocial;
    private String cuentaRedSocial;

    public Persona() {
    }

    public Persona(int id, String nombres, String apellidos, String cuentaRedSocial) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cuentaRedSocial = cuentaRedSocial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public RedSocial getRedSocial() {
        return redSocial;
    }

    public void setRedSocial(RedSocial redSocial) {
        this.redSocial = redSocial;
    }

    public String getCuentaRedSocial() {
        return cuentaRedSocial;
    }

    public void setCuentaRedSocial(String cuentaRedSocial) {
        this.cuentaRedSocial = cuentaRedSocial;
    }
    
}
