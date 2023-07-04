package ar.edu.unju.fi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.service.IConsejoService;

@SpringBootTest
class Tp2Grupo22ApplicationTests {

/*	@Autowired
	@Qualifier("consejoServiceMysql")
	private IConsejoService consejoService;
	
	Consejo consejo;
	@Test
	void guardarConsejoTest() {
		consejo = new Consejo();
		consejo.setDescripcion("Chupame");
		consejo.setLink("https://www.google.com");
		consejo.setCategoria("Gatos");
		consejo.setEstado(true);
		consejoService.guardar(consejo);
	}*/

}
