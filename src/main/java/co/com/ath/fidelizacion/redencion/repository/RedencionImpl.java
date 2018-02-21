package co.com.ath.fidelizacion.redencion.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ath.fidelizacion.redencion.domain.Pais;

@Service
public class RedencionImpl implements Redencion{
	
	@Autowired
	RedencionRepository repositorioRedencion;
	
	@Override
	public Iterable<Pais> listaPaises() {
		// TODO Auto-generated method stub
		return repositorioRedencion.findAll();
	}

}
