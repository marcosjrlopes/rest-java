package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.livro.domain.Carro;
import br.com.livro.domain.CarroService;

public class CarroTest {

	private CarroService carroService;
	
	@Before
	public void setUp() throws Exception{
		carroService  = (CarroService) SpringUtil.getInstance().getBean(CarroService.class);
	}
	
	
	@Test
	public void testListaCarros() {
		//TESTAR A LISTAGEM DE CARROS.
		List<Carro> carros = carroService.getCarros();
		assertNotNull(carros);
		
		//VALIDA SE ENCONTROU ALGO.
		assertTrue(carros.size() > 0);
		
		Carro tucker = carroService.findByName("Tucker 1948").get(0);
		assertEquals("Tucker 1948", tucker.getNome());
		
		Carro ferrari = carroService.findByName("Ferrari FF").get(0);
		assertEquals("Ferrari FF", ferrari.getNome());
		
		Carro bugatti = carroService.findByName("Bugatti Veyron").get(0);
		assertEquals("Bugatti Veyron", bugatti.getNome());		
		
	}
	
	@Test
	public void testSalvarDeletarCarro() {
		Carro c = new Carro();
		c.setNome("Teste");
		c.setDesc("Teste desc");
		c.setUrlFoto("url da foto aqui");
		c.setUrlvideo("Url video aqui");
		c.setLatitude("lat");
		c.setLongitude("lng");
		c.setTipo("tipo");
		carroService.save(c);
		
		//id do carro salvo.
		Long id = c.getId();
				
		assertNotNull(id);
		
		c = carroService.getCarro(id);
		
		assertEquals("Teste", c.getNome());
		assertEquals("Teste desc",c.getDesc());
		assertEquals("url da foto aqui",c.getUrlFoto());
		assertEquals("Url video aqui",c.getUrlvideo());
		assertEquals("lat",c.getLatitude());
		assertEquals("lng",c.getLongitude());
		assertEquals("tipo",c.getTipo());
		
		//ATUALIZAR O CARRO.
		c.setNome("Teste UPDATE");
		carroService.save(c);
		
		//testar se o carro foi atualizado.
		carroService.getCarro(id);
		assertEquals("Teste UPDATE", c.getNome());
		
		//Deletar o carro.
		carroService.delete(id);
		
		//Buscar o carro novamente para conferir se foi deletado.
		c = carroService.getCarro(id);
		assertNull(c);
	}

}
