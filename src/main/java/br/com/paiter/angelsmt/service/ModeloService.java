package br.com.paiter.angelsmt.service;

import java.util.List;

import javax.ejb.Local;

import br.com.paiter.angelsmt.entity.Modelo;

@Local
public interface ModeloService {
	
	public Modelo save(Modelo modelo);
	
	public void remove(Modelo modelo);
	
	public Modelo find(Long id);
	
	public List<Modelo> findAll();

}
