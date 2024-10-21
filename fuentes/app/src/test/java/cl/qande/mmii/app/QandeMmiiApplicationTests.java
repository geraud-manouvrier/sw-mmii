package cl.qande.mmii.app;

import cl.qande.mmii.app.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class QandeMmiiApplicationTests {

	@Autowired
	private AppConfig appConfig;
/*
	@Test
	void generaPassword() {
		PasswordEncoder encoder = passwordEncoder();
		var plainPass	= "~bK,,F#18{M!qhf";
		//CustomLog.getInstance().info("Clave 1 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");

		plainPass	= "QandE_2023_1";
		CustomLog.getInstance().info("Clave 2 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");
		plainPass	= "QandE_2023_2";
		CustomLog.getInstance().info("Clave 2 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");
		plainPass	= "QandE_2023_3";
		CustomLog.getInstance().info("Clave 2 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");
		plainPass	= "QandE_2023_4";
		CustomLog.getInstance().info("Clave 2 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");
		plainPass	= "QandE_2023_5";
		CustomLog.getInstance().info("Clave 2 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");
		plainPass	= "QandE_2023_6";
		CustomLog.getInstance().info("Clave 2 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");
		plainPass	= "QandE_2023_7";
		CustomLog.getInstance().info("Clave 2 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");

	}
*/

}