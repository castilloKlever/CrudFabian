package com.grafrio.GraficasRiobamba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grafrio.GraficasRiobamba.entities.Producto;
import com.grafrio.GraficasRiobamba.interfaces.IproductoService;
import com.grafrio.GraficasRiobamba.repository.ProductoRepo;
@Service
public class ProductoService implements IproductoService {
    @Autowired
	private ProductoRepo data ;
	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return (List<Producto>)data.findAll();
	}

	@Override
	public Optional<Producto> listarId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Producto p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
