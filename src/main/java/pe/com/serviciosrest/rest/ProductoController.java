
package pe.com.serviciosrest.rest;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.serviciosrest.entity.Producto;
import pe.com.serviciosrest.services.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> findAll() {
        return productoService.findAll();
    }
    @PostMapping
    public Producto add(@RequestBody Producto p) {
        return productoService.add(p);
    }
    @GetMapping("/{id}")
    public Optional<Producto> findById(@PathVariable long id) {
        return productoService.findById(id);
    }
    
     @PutMapping("/{id}")
    public Producto update(@PathVariable int id, @RequestBody Producto c) {
        c.setCodigo(id);
        return productoService.update(c);
    }

}
