package pe.com.serviciosrest.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.serviciosrest.entity.Cliente;
import pe.com.serviciosrest.repository.ClienteRepository;


@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAllCustom();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> finByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente add(Cliente cl) {
        return clienteRepository.save(cl); 
    }

    @Override
    public Cliente update(Cliente cl) {
        Cliente objcliente = clienteRepository.getById(cl.getCodigo());
        BeanUtils.copyProperties(cl, objcliente);
        return clienteRepository.save(objcliente);
    }

    @Override
    public Cliente delete(Cliente cl) {
        Cliente objcliente = clienteRepository.getById(cl.getCodigo());
        objcliente.setEstado(false);
        return clienteRepository.save(objcliente);
    }
    
}
