package com.grafrio.GraficasRiobamba.interfaces;

import java.util.List;
import java.util.Optional;

import com.grafrio.GraficasRiobamba.entities.Producto;

public interface IproductoService {
	public List<Producto> listar();
	public Optional<Producto>listarId (Long id);
	public int save(Producto p);
	public void delete(Long id);

}
