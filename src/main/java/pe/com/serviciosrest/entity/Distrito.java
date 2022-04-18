
package pe.com.serviciosrest.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity(name = "Distrito")
@Table(name = "t_distrito")
public class Distrito implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id //para identificar la clave primaria
    @Column(name = "coddis")//para identificar el nombre de la columna
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrement
    private long codigo;
    @Column(name = "nomdis")
    private String nombre;
    @Column(name = "estdis")
    private boolean estado;

    public Distrito() {
    }
    
    public Distrito(long codigo, String nombre, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
