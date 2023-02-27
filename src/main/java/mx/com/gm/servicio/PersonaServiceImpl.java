package mx.com.gm.servicio;
import java.util.List;
import mx.com.gm.dao.iPersonaDao;
import mx.com.gm.domain.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements iPersonaService{
    
    @Autowired
    private iPersonaDao personaDao;

    @Override
    public List<Persona> listarPersonas(){
        return (List<Persona>) personaDao.findAll();
    }
    @Override
    public void guardar(Persona persona){
        personaDao.save(persona);
    }
    @Override
    public void eliminar(Persona persona){
        personaDao.findById(persona.getIdPersona());
    }
}
