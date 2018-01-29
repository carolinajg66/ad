package serpis.ad.clases;
// Generated 15-ene-2018 11:51:42 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name="cliente"
    ,catalog="dbprueba"
    , uniqueConstraints = @UniqueConstraint(columnNames="nombre") 
)
public class Cliente  implements java.io.Serializable {


     private Long id;
     private String nombre;
     private Set<Pedido> pedidos = new HashSet<Pedido>(0);

    public Cliente() {
    }

	
    public Cliente(String nombre) {
        this.nombre = nombre;
    }
    public Cliente(String nombre, Set<Pedido> pedidos) {
       this.nombre = nombre;
       this.pedidos = pedidos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    
    @Column(name="nombre", unique=true, nullable=false, length=50)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cliente")
    public Set<Pedido> getPedidos() {
        return this.pedidos;
    }
    
    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }




}

