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
		//appConfig.customLog.info("Clave 1 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");

		plainPass	= "QandE_2023_1";
		appConfig.customLog.info("Clave 2 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");
		plainPass	= "QandE_2023_2";
		appConfig.customLog.info("Clave 2 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");
		plainPass	= "QandE_2023_3";
		appConfig.customLog.info("Clave 2 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");
		plainPass	= "QandE_2023_4";
		appConfig.customLog.info("Clave 2 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");
		plainPass	= "QandE_2023_5";
		appConfig.customLog.info("Clave 2 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");
		plainPass	= "QandE_2023_6";
		appConfig.customLog.info("Clave 2 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");
		plainPass	= "QandE_2023_7";
		appConfig.customLog.info("Clave 2 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");

	}
*/

}