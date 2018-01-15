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
 * Categoria generated by hbm2java
 */
@Entity
@Table(name="categoria"
    ,catalog="dbprueba"
    , uniqueConstraints = @UniqueConstraint(columnNames="nombre") 
)
public class Categoria  implements java.io.Serializable {


     private Long id;
     private String nombre;
     private Set<Articulo> articulos = new HashSet<Articulo>(0);

    public Categoria() {
    }

	
    public Categoria(String nombre) {
        this.nombre = nombre;
    }
    public Categoria(String nombre, Set<Articulo> articulos) {
       this.nombre = nombre;
       this.articulos = articulos;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="categoria")
    public Set<Articulo> getArticulos() {
        return this.articulos;
    }
    
    public void setArticulos(Set<Articulo> articulos) {
        this.articulos = articulos;
    }




}


