
package pe.com.serviciosrest.services;

import java.util.List;
import java.util.Optional;
import pe.com.serviciosrest.entity.Distrito;

public interface DistritoService {
    
    List<Distrito> findAll();

    Optional<Distrito> findById(Long id);

    Distrito add(Distrito d);

    Distrito update(Distrito d);

    Distrito delete(Distrito d);
}
