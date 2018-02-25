package br.com.livro.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarroService {
	
	@Autowired
	private CarroDao db;
	
	//Listar todos os carros do banco de dados.
	public List<Carro> getCarros(){
		
		try {			
			List<Carro> carros = db.getCarros();
			return carros;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
		
	}
	
	//Buscar um carro pelo id.
	public Carro getCarro(Long id){
		
		try {
			return db.getCarroById(id);
			
		} catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
	//Deletar um carro pelo id.
	public boolean delete(Long id){
		
		try {
			return db.delete(id);
			
		} catch(SQLException ex) {
			return false;
		}
		
	}
	
	//Salvar ou atualizar um carro pelo id.
	public boolean save(Carro carro){
		
		try {
			db.save(carro);
			return true;
			
		} catch(SQLException ex) {
			return false;
		}
		
	}
	
	//Buscar um carro pelo nome.
	public List<Carro> findByName(String name){
		
		try {
			return db.findByName(name);
			
		} catch(SQLException ex) {
			return null;
		}
		
	}
	
	//Buscar um carro pelo nome.
	public List<Carro> findByTipo(String tipo){
		
		try {
			return db.findByTipo(tipo);
			
		} catch(SQLException ex) {
			return null;
		}		
	}
}
