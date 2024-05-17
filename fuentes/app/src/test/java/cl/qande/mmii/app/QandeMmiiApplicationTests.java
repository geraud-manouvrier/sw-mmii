package cl.qande.mmii.app;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.properties.AppNotificacionMailProperties;
import cl.qande.mmii.app.job.JobControlDiario;
import cl.qande.mmii.app.job.JobGetFromFtpPershing;
import cl.qande.mmii.app.job.JobMallaProcesos;
import cl.qande.mmii.app.job.JobReportesMaestros;
import cl.qande.mmii.app.models.db.core.dao.IControlDiarioDao;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosSaldoDao;
import cl.qande.mmii.app.models.db.pershing.dao.IProcesoSflDao;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.*;
import cl.qande.mmii.app.util.helper.*;
import cl.qande.mmii.app.util.reportes.MaestroDatosCsv;
import cl.qande.mmii.app.util.reportes.MaestroDatosExcel;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static cl.qande.mmii.app.MvcConfig.passwordEncoder;


@SpringBootTest
class QandeMmiiApplicationTests {

	private final static int DESFASE_DIAS = -1;
	@Autowired
	private CsvService csvService;
	@Autowired
	private AppConfig appConfig;
	@Autowired
	private CalendarioHelper calendarioHelper;
	@Autowired
	private IReporteMaestroDatosService reporteMaestroDatosService;
	@Autowired
	private MaestroDatosExcel maestroDatosExcel;
	@Autowired
	private MaestroDatosCsv maestroDatosCsv;
	@Autowired
	private ReportesMaestrosHelper reportesMaestrosHelper;
	@Autowired
	private ReportesMaestrosService reportesMaestrosService;
	@Autowired
	private IProcesoSflDao procesoSflDao;
	@Autowired
	private IEmailService emailService;
	@Autowired
	private AppNotificacionMailProperties appNotificacionMailProperties;
	@Autowired
	private NotificacionEmail notificacionEmail;
	@Autowired
	private UsuariosHelper usuariosHelper;
	@Autowired
	private ArchivosHelper archivosHelper;
	@Autowired
	private ControlDiarioService controlDiarioService;
	@Autowired
	private IControlDiarioDao controlDiarioDao;
	@Autowired
	private JobControlDiario jobControlDiario;
	@Autowired
	private FtpPershingService ftpPershingService;
	@Autowired
	private JobGetFromFtpPershing jobGetFromFtpPershing;
	@Autowired
	private CronHelper cronHelper;
	@Autowired
	private PershingService pershingService;
	@Autowired
	private IJobsService jobsService;
	@Autowired
	private IReporteMaestroDatosSaldoDao reporteMaestroDatosSaldoDao;
	@Autowired
	private JobMallaProcesos jobMallaProcesos;
	@Autowired
	private JobReportesMaestros jobReportesMaestros;

	@Test
	void generaPassword() {
		PasswordEncoder encoder = passwordEncoder();
		var plainPass	= "~bK,,F#18{M!qhf";
		//appConfig.customLog.info("Clave 1 para ["+plainPass+"]: ["+encoder.encode(plainPass)+"]");
		/*
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
		*/
	}

	@Test
	public void testJobByDate() {
		var processDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(-28)).replace("-","");
		var processStamp	= new SimpleDateFormat("_yyyy.MM.dd.HH.mm.ss.SSS.Z").format(new Date());
		//assertThat(processDate).isEqualTo("20221217");
		//jobGetFromFtpStonex.processByDate(processDate, processStamp);
	}

	@Test
	public void testJobHistoric() {
		var listaDesfases= new ArrayList<Integer>();
		//Desfase hasta el 24/01
		int desfaseAdicional=56;
		//assertThat(calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(-desfaseAdicional)).replace("-","")).isEqualTo("20230124");
/*
		listaDesfases.add(-0-desfaseAdicional);
		listaDesfases.add(1-desfaseAdicional);
		listaDesfases.add(2-desfaseAdicional);
		listaDesfases.add(3-desfaseAdicional);

		listaDesfases.add(6-desfaseAdicional);
		listaDesfases.add(7-desfaseAdicional);
		listaDesfases.add(8-desfaseAdicional);
		listaDesfases.add(9-desfaseAdicional);
		listaDesfases.add(10-desfaseAdicional);

		listaDesfases.add(13-desfaseAdicional);
		listaDesfases.add(14-desfaseAdicional);
		listaDesfases.add(15-desfaseAdicional);
		listaDesfases.add(16-desfaseAdicional);
		listaDesfases.add(17-desfaseAdicional);

		listaDesfases.add(20-desfaseAdicional);
		listaDesfases.add(21-desfaseAdicional);
		listaDesfases.add(22-desfaseAdicional);
		listaDesfases.add(23-desfaseAdicional);
		listaDesfases.add(24-desfaseAdicional);

		listaDesfases.add(28-desfaseAdicional);
		listaDesfases.add(29-desfaseAdicional);
		listaDesfases.add(30-desfaseAdicional);
		listaDesfases.add(31-desfaseAdicional);

		listaDesfases.add(34-desfaseAdicional);
		listaDesfases.add(35-desfaseAdicional);
		listaDesfases.add(36-desfaseAdicional);
*/

		for(var desfaseActual : listaDesfases) {
			var processDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(desfaseActual)).replace("-","");

			//Usamos marcas de tiempo distintas en cada iteración para que no choquen PK y marcas
			var processStamp	= new SimpleDateFormat(processDate+"_yyyy.MM.dd.HH.mm.ss.SSS.Z").format(new Date());
			//appConfig.customLog.info("Procesando fecha ["+processDate+"] con marca ["+processStamp+"]");
			//stonexService.processByDate(processDate, processStamp);

		}
	}
	/*
	@Test
	public void testFtpSura() {
		var processDate		= "20230517";
		try {
			var archivosConError	= suraChileService.cargaArchivosEnFtpPorFechaProceso(processDate, true);
		} catch (QandeMmiiException e) {
			throw new RuntimeException(e);
		}
	}
	@Test
	public void testJobFtpSura() {
		var processDate		= "20230516";
		try {
			jobFtpSuraChile.realizaCargaDiaria(processDate, false);
		} catch (QandeMmiiException e) {
			throw new RuntimeException(e);
		}
	}

	 */
/*
	@Test
	public void testReporteMaestros() {


		try {
			//21 mkin c/u app
			//reportesMaestrosService.generaReportesMaestros("20230509");
			//reportesMaestrosService.generaReportesMaestros("20230510");
			//reportesMaestrosService.generaReportesMaestros("20230511");
			//reportesMaestrosService.generaReportesMaestros("20230512");
			//reportesMaestrosService.generaReportesMaestros("20230513");
			//reportesMaestrosService.generaReportesMaestros("20230514");
			//reportesMaestrosService.generaReportesMaestros("20230515");
			//reportesMaestrosService.generaReportesMaestros("20230516");
			//reportesMaestrosService.generaReportesMaestros("20230517");
            //reportesMaestrosService.generaReportesMaestros("20230523");
            //reportesMaestrosService.generaReportesMaestros("20230524");
            //reportesMaestrosService.generaReportesMaestros("20230525");
            //reportesMaestrosService.generaReportesMaestros("20230602");
            //reportesMaestrosService.generaReportesMaestros("20230603");
            //reportesMaestrosService.generaReportesMaestros("20230604");

			//reportesMaestrosService.generaReportesMaestros("20230523");
			//reportesMaestrosService.generaReportesMaestros("20230526");

			//reportesMaestrosService.generaReportesMaestros("20230606");
			//reportesMaestrosService.generaReportesMaestros("20230609");
			//reportesMaestrosService.generaReportesMaestros("20230612");
			//reportesMaestrosService.generaReportesMaestros("20230614");

			//reportesMaestrosService.generaReportesMaestros("20230707");
			//reportesMaestrosService.generaReportesMaestros("20230708");
			//reportesMaestrosService.generaReportesMaestros("20230709");

			reportesMaestrosService.generaReportesMaestros("20230726");

		} catch (QandeMmiiException e) {
			appConfig.customLog.error("Error en Test testReporteMaestros");
		}

	}
*/
	@Test
	public void cargaHistoricaSftpStonex() {
		var minProcessDate	= "20221209";
		var maxProcessDate	= "20230325";
		minProcessDate		= "20230331";
		maxProcessDate		= "20230331";
		//Levantar docker SFTP!!!!
		/*
		try {
            stonexService.processByDateRange(minProcessDate, maxProcessDate);
		} catch (QandeMmiiException e) {
            throw new RuntimeException(e);
        }
        */
    }

	@Test
	public void testCalculoReporteIngresosEgresos() throws ParseException {
		var calcDate	= "20230102";
		//var resultado	= reporteIngresosEgresosService.calculaReportePorDia(calcDate);
		//assertThat(resultado.size()).isGreaterThanOrEqualTo(0);
	}

/*
    @Test
    public void testGeneraReportesIngresosEgresos() throws ParseException, QandeMmiiException {
		reportesIngresosEgresosService.generaReportesIngresosEgresos(calendarioHelper.convierteFechaStrToFormatoBd("2022-12-31"));
		reportesIngresosEgresosService.generaReportesIngresosEgresos(calendarioHelper.convierteFechaStrToFormatoBd("2023-01-31"));
		reportesIngresosEgresosService.generaReportesIngresosEgresos(calendarioHelper.convierteFechaStrToFormatoBd("2023-02-28"));
		reportesIngresosEgresosService.generaReportesIngresosEgresos(calendarioHelper.convierteFechaStrToFormatoBd("2023-03-31"));
		reportesIngresosEgresosService.generaReportesIngresosEgresos(calendarioHelper.convierteFechaStrToFormatoBd("2023-04-30"));
		reportesIngresosEgresosService.generaReportesIngresosEgresos(calendarioHelper.convierteFechaStrToFormatoBd("2023-05-31"));
		reportesIngresosEgresosService.generaReportesIngresosEgresos(calendarioHelper.convierteFechaStrToFormatoBd("2023-06-01"));
		reportesIngresosEgresosService.generaReportesIngresosEgresos(calendarioHelper.convierteFechaStrToFormatoBd("2023-06-02"));
		reportesIngresosEgresosService.generaReportesIngresosEgresos(calendarioHelper.convierteFechaStrToFormatoBd("2023-06-03"));
		reportesIngresosEgresosService.generaReportesIngresosEgresos(calendarioHelper.convierteFechaStrToFormatoBd("2023-06-04"));
		reportesIngresosEgresosService.generaReportesIngresosEgresos(calendarioHelper.convierteFechaStrToFormatoBd("2023-06-05"));
		reportesIngresosEgresosService.generaReportesIngresosEgresos(calendarioHelper.convierteFechaStrToFormatoBd("2023-06-06"));
		reportesIngresosEgresosService.generaReportesIngresosEgresos(calendarioHelper.convierteFechaStrToFormatoBd("2023-06-07"));

    }
*/
	@Test
	public void testRequisitosClave() {
		String clave	= "";
		var resultado	= usuariosHelper.validaClave(clave);
		/*
		assertThat(resultado.size()).isEqualTo(5);
		assertThat(usuariosHelper.validaClave("~,,F#{M!F#{").size()).isEqualTo(2);
		assertThat(usuariosHelper.validaClave("~b,,#18{!qhf").size()).isEqualTo(1);
		assertThat(usuariosHelper.validaClave("~bK,,F#18{M!qhf").size()).isEqualTo(0);
		*/
	}
/*
	@Test
	public void testListDirFtpPershing() {
		try {
			var contenidoDir	= ftpPershingService.listDir();
			appConfig.customLog.info("Contenido del directorio: "+contenidoDir.toString());
		} catch (QandeMmiiException e) {
			appConfig.customLog.error("Error en Test [testFtpPershing]: "+e.getMessage());
		}
	}
	*/
/*
	@Test
	public void testDonwloadAllDirFtpPershing() {
		try {
			ftpPershingService.downloadFilesByPattern("");
			appConfig.customLog.info("Contenido del directorio: ");
		} catch (QandeMmiiException e) {
			appConfig.customLog.error("Error en Test [testFtpPershing]: "+e.getMessage());
		}
	}

 */
/*
	@Test
	public void testJobDownloadByProcessDate() {
		var processDate	= "20230601";
		try {
			jobGetFromFtpPershing.processByProcessDate("20230531", true);
			jobGetFromFtpPershing.processByProcessDate("20230601", true);
			jobGetFromFtpPershing.processByProcessDate("20230602", true);
			jobGetFromFtpPershing.processByProcessDate("20230603", true);
			jobGetFromFtpPershing.processByProcessDate("20230604", true);
			jobGetFromFtpPershing.processByProcessDate("20230605", true);
			jobGetFromFtpPershing.processByProcessDate("20230606", true);
			jobGetFromFtpPershing.processByProcessDate("20230607", true);
			jobGetFromFtpPershing.processByProcessDate("20230608", true);
			jobGetFromFtpPershing.processByProcessDate("20230609", true);
			jobGetFromFtpPershing.processByProcessDate("20230610", true);
			jobGetFromFtpPershing.processByProcessDate("20230611", true);
			jobGetFromFtpPershing.processByProcessDate("20230612", true);
			jobGetFromFtpPershing.processByProcessDate("20230613", true);
			jobGetFromFtpPershing.processByProcessDate("20230614", true);
			jobGetFromFtpPershing.processByProcessDate("20230615", true);
			jobGetFromFtpPershing.processByProcessDate("20230616", true);
			jobGetFromFtpPershing.processByProcessDate("20230617", true);
			jobGetFromFtpPershing.processByProcessDate("20230618", true);
			jobGetFromFtpPershing.processByProcessDate("20230619", true);
			jobGetFromFtpPershing.processByProcessDate("20230620", true);
			jobGetFromFtpPershing.processByProcessDate("20230621", true);
			jobGetFromFtpPershing.processByProcessDate("20230622", true);
		} catch (QandeMmiiException e) {
			appConfig.customLog.error("Error en Test [testJobDownloadByProcessDate]: "+e.getMessage());
		}
	}
*/

/*
	@Test
	public void testCronDescription() {
		String cronPropertiesConfig	= "0 23 * ? * 1-5 *";
		cronPropertiesConfig	= "0 30 5 * * *";
		assertThat(cronHelper.compareCronDescription(cronPropertiesConfig)).isTrue();

		appConfig.customLog.info(cronHelper.humanDescriptionEs(cronPropertiesConfig));
		appConfig.customLog.info(cronHelper.humanDescriptionUs(cronPropertiesConfig));

		var nextExecution	= cronHelper.getNextExecution(cronPropertiesConfig);
		appConfig.customLog.info(calendarioHelper.convierteDateToStringWithFormat(Date.from(nextExecution.toInstant()), "HH:mm:ss (YYYY-MM-dd)"));


	}
*/

/*
	@Test
	public void testHumanDescription() {
		String cronPropertiesConfig = "0 23 * ? * 1-5 *";
		CronDefinition cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(QUARTZ);
		CronParser parser = new CronParser(cronDefinition);

		CronDescriptor descriptorUs = CronDescriptor.instance(Locale.US);// we support multiple languages! Just pick one!

		System.out.println(
				String.format("[US] Quartz expression '%s' is described as '%s'", cronPropertiesConfig, CronDescriptor.instance(Locale.US).describe(parser.parse(cronPropertiesConfig)))
		);

		Locale localeEs = new Locale ( "es" , "ES" );
		System.out.println(
				String.format("[ES] Quartz expression '%s' is described as '%s'", cronPropertiesConfig, CronDescriptor.instance(localeEs).describe(parser.parse(cronPropertiesConfig)))
		);
	}
*/

/*
	@Test
	public void testLastAndNextExecutionTimes() {

		String quartzCronExpression = "0 * * 1-3 * ? *";
		CronParser quartzCronParser = new CronParser(CronDefinitionBuilder.instanceDefinitionFor(QUARTZ));

		// parse the QUARTZ cron expression.
		Cron parsedQuartzCronExpression = quartzCronParser.parse(quartzCronExpression);

		// Create ExecutionTime for a given cron expression.
		ZonedDateTime now = ZonedDateTime.now();
		ExecutionTime executionTime = ExecutionTime.forCron(parsedQuartzCronExpression);

		// Given a Cron instance, we can ask for next/previous execution
		System.out.println(String.format("Given the Quartz cron '%s' and reference date '%s', last execution was '%s'",
				parsedQuartzCronExpression.asString(), now, executionTime.lastExecution(now).get())
		);
		System.out.println(String.format("Given the Quartz cron '%s' and reference date '%s', next execution will be '%s'",
				parsedQuartzCronExpression.asString(), now, executionTime.nextExecution(now).get())
		);

		// or request time from last / to next execution
		System.out
				.println(String.format("Given the Quartz cron '%s' and reference date '%s', last execution was %s seconds ago",
						parsedQuartzCronExpression.asString(), now, executionTime.timeFromLastExecution(now).get().getSeconds())
				);
		System.out.println(
				String.format("Given the Quartz cron '%s' and reference date '%s', next execution will be in %s seconds",
						parsedQuartzCronExpression.asString(), now, executionTime.timeToNextExecution(now).get().getSeconds())
		);
	}
*/
/*
	@Test
	public void testProcessSflByIdAndDate() {
		var processDate	= "20230601";
		var idSfl		= "ACCT";
		try {
			pershingService.processByDate("20230601", true, idSfl);
			pershingService.processByDate("20230602", true, idSfl);
			pershingService.processByDate("20230605", true, idSfl);
			pershingService.processByDate("20230606", true, idSfl);
			pershingService.processByDate("20230607", true, idSfl);
			pershingService.processByDate("20230608", true, idSfl);
			pershingService.processByDate("20230609", true, idSfl);
			pershingService.processByDate("20230612", true, idSfl);
			pershingService.processByDate("20230613", true, idSfl);
			pershingService.processByDate("20230614", true, idSfl);
		} catch (QandeMmiiException e) {
			appConfig.customLog.error("Error en Test [testProcessSflByIdAndDate]: "+e.getMessage());
		}

	}
*/

/*
	@Test
	public void testLsDirFtpExterno() throws QandeMmiiException {
		var contenidoSura		= ftpSuraAmService.contenidoDirectorio();
		//var contenidoPershing	= ftpPershingService.contenidoDirectorio();
		var contenidoStonex		= ftpStonexService.contenidoDirectorio();
		appConfig.customLog.info("contenidoSura: "+contenidoSura.toString());
		//appConfig.customLog.info("contenidoPershing: "+contenidoPershing.toString());
		appConfig.customLog.info("contenidoStonex: "+contenidoStonex.toString());
		//contenidoSura.get(0).getPath()
	}
*/

/*
	@Test
	public void testControlJobsBd() {
		assertThat(jobsService.verificaEjecucionJobPorIdProceso(1, "20230105", true)).isTrue();
		assertThat(jobsService.verificaEjecucionJobPorIdProceso(1, "20230105", false)).isTrue();
		assertThat(jobsService.verificaEjecucionJobPorIdProceso(1, "20230110", true)).isFalse();
		assertThat(jobsService.verificaEjecucionJobPorIdProceso(1, "20230110", false)).isFalse();

		assertThat(jobsService.verificaEjecucionJobPorIdProceso(2, "20230105", false)).isFalse();
		assertThat(jobsService.verificaEjecucionJobPorIdProceso(2, "20230110", false)).isFalse();

		assertThat(jobsService.verificaEjecucionJobPorIdProceso(3, "20230115", false)).isTrue();
		assertThat(jobsService.verificaEjecucionJobPorIdProceso(3, "20230115", true)).isFalse();
	}
*/

	/*
	@Test
	void testExisteCodPaisAtencion() {
		Integer codFalse	= -99;
		Integer codTrue		= 1;
		assertThat(cuentaService.hasValidCodPaisAtencion(codFalse)).isFalse();
		assertThat(clienteService.hasValidCodPaisAtencion(codFalse)).isFalse();
		assertThat(cuentaService.hasValidCodPaisAtencion(codTrue)).isTrue();
		assertThat(clienteService.hasValidCodPaisAtencion(codTrue)).isTrue();
		assertThat(parPaisAtencionDao.findById(codTrue).orElse(null).getGlosa()).isEqualTo("Chile");
	}
	*/

/*
	@Test
	void testDiaHabilesFtp() {
		var diaNoHabil	= "20230904";
		var diaHabil	= "20230905";
		assertThat(procesoFtpStonexDao.esHabil(diaNoHabil)).isFalse();
		assertThat(procesoFtpStonexDao.esHabil(diaHabil)).isTrue();
		assertThat(procesoSflDao.esHabil(diaNoHabil)).isFalse();
		assertThat(procesoSflDao.esHabil(diaHabil)).isTrue();

	}
	*/

/*
@Test
public void reprocesoMaestros() {


	try {
		//21 mkin c/u app
		//reportesMaestrosService.generaReportesMaestros("20231001");
		//reportesMaestrosService.generaReportesMaestros("20231002");
		//reportesMaestrosService.generaReportesMaestros("20231003");
		//reportesMaestrosService.generaReportesMaestros("20231004");
		//reportesMaestrosService.generaReportesMaestros("20231005");
		//reportesMaestrosService.generaReportesMaestros("20231006");
		//reportesMaestrosService.generaReportesMaestros("20231007");
		//reportesMaestrosService.generaReportesMaestros("20231008");
		//reportesMaestrosService.generaReportesMaestros("20231009");
		//reportesMaestrosService.generaReportesMaestros("20231010");
		//reportesMaestrosService.generaReportesMaestros("20231011");
		//reportesMaestrosService.generaReportesMaestros("20231012");
		//reportesMaestrosService.generaReportesMaestros("20231013");
		//reportesMaestrosService.generaReportesMaestros("20231014");
		//reportesMaestrosService.generaReportesMaestros("20231015");
		//reportesMaestrosService.generaReportesMaestros("20231016");
		//reportesMaestrosService.generaReportesMaestros("20231017");
		//reportesMaestrosService.generaReportesMaestros("20231018");
		//reportesMaestrosService.generaReportesMaestros("20231019");
		//reportesMaestrosService.generaReportesMaestros("20231020");
		//reportesMaestrosService.generaReportesMaestros("20231021");
		//reportesMaestrosService.generaReportesMaestros("20231022");
		//reportesMaestrosService.generaReportesMaestros("20231023");
		//reportesMaestrosService.generaReportesMaestros("20231024");
		//reportesMaestrosService.generaReportesMaestros("20231025");
		//reportesMaestrosService.generaReportesMaestros("20231026");
		//reportesMaestrosService.generaReportesMaestros("20231027");
		//reportesMaestrosService.generaReportesMaestros("20231028");
		//reportesMaestrosService.generaReportesMaestros("20231029");
		//reportesMaestrosService.generaReportesMaestros("20231030");
		//reportesMaestrosService.generaReportesMaestros("20231031");

		//reportesMaestrosService.generaReportesMaestros("20231101");
		//reportesMaestrosService.generaReportesMaestros("20231102");
		//reportesMaestrosService.generaReportesMaestros("20231103");
		//reportesMaestrosService.generaReportesMaestros("20231104");
		//reportesMaestrosService.generaReportesMaestros("20231105");
		//reportesMaestrosService.generaReportesMaestros("20231106");
			//reportesMaestrosService.generaReportesMaestros("20231107");
			//reportesMaestrosService.generaReportesMaestros("20231108");
		//reportesMaestrosService.generaReportesMaestros("20231109");
		//reportesMaestrosService.generaReportesMaestros("20231110");
		//reportesMaestrosService.generaReportesMaestros("20231111");
		//reportesMaestrosService.generaReportesMaestros("20231112");
		//reportesMaestrosService.generaReportesMaestros("20231113");

		//reportesMaestrosService.generaReportesMaestros("20231115");
		//reportesMaestrosService.generaReportesMaestros("20240201");
		//reportesMaestrosService.generaReportesMaestros("20240222");
		//reportesMaestrosService.generaReportesMaestros("20240315");
		//reportesMaestrosService.generaReportesMaestros("20240316");
		//reportesMaestrosService.generaReportesMaestros("20240317");

	} catch (QandeMmiiException e) {
		appConfig.customLog.error("Error en Test reprocesoMaestros");
	}

}
*/

/*
	@Test
	public void testVariantes() {
		var porPaises	= true;
		var nuevaLista	= reportesMaestrosHelper.generaListaVariantesNueva(porPaises);
		var antiguaLista	= reportesMaestrosHelper.generaListaVariantes(porPaises);

		assertThat(nuevaLista.equals(antiguaLista)).isTrue();

		for (var variante : nuevaLista) {
			var antiguoSufijo	= reportesMaestrosHelper.generaSufijoArchivo(variante);
			var nuevoSufijo		= reportesMaestrosHelper.generaSufijoArchivoNuevo(variante);
			assertThat(antiguoSufijo).isEqualTo(nuevoSufijo);
		}
		appConfig.customLog.info("Fin test");
	}
*/
/*
	@Test
	public void testCodificaFrase() {
		String fraseOriginal	= "Hola, bonito día!";
		this.codificaImprime(fraseOriginal);

		//Carlos
		fraseOriginal		= "Fácil! Sabes cuantos años cumplo.";
		this.codificaImprime(fraseOriginal);

		fraseOriginal		= "Lee las primeras invitaciones!";
		this.codificaImprime(fraseOriginal);

		fraseOriginal		= "El ave da orinen al primer nombre de mi hija.";
		this.codificaImprime(fraseOriginal);

		fraseOriginal		= "El ave tiene 2 nombres... el primero es “similar” al primer nombre de mi hija y el segundo es por la actividad que hace para obtener su alimento (actividad que hacen humanos también).";
		this.codificaImprime(fraseOriginal);

		fraseOriginal		= "Se alimenta de peces (ojo, para el segundo nombre), es un ave del sur y algo chascona.";
		this.codificaImprime(fraseOriginal);

		fraseOriginal		= "Has estado cuando lo usamos!";
		this.codificaImprime(fraseOriginal);

		fraseOriginal		= "Tiene el nombre de una “actividad” que solemos hacer cada vez que vamos de paseo/vacaciones";
		this.codificaImprime(fraseOriginal);

		fraseOriginal		= "Esa actividad involucra caballos!";
		this.codificaImprime(fraseOriginal);

		fraseOriginal		= "Está en la entrada, en el antejardín (escríbelo como una sola palabra y sin acentos!)";
		this.codificaImprime(fraseOriginal);

		fraseOriginal		= "Suele estar en los campos y plantaciones, pero a nosotros se nos ocurrió tener uno.";
		this.codificaImprime(fraseOriginal);

		fraseOriginal		= "Hace poco le cambiamos ropa por una nueva";
		this.codificaImprime(fraseOriginal);

		fraseOriginal		= "Escribe el nombre separado del apellido por un espacio, todo en minúsculas.";
		this.codificaImprime(fraseOriginal);

		fraseOriginal		= "El primer nombre suelen escribirlo con “H”, pero nuestra asistente no lleva “H” inicial (con “H” es el nombre de una mujer de Troya/Esparta).";
		this.codificaImprime(fraseOriginal);

		fraseOriginal		= "Si bien es nombre de mujer, cuando lo lees todo junto parece nombre masculino.";
		this.codificaImprime(fraseOriginal);

		fraseOriginal		= "Su nombre todo junto hace referencia a una persona (hombre) muy pequeña o con “acondroplasia”";
		this.codificaImprime(fraseOriginal);
	}

	public void codificaImprime(String fraseOriginal) {

		appConfig.customLog.info("Frase original: ["+fraseOriginal+"]");
		appConfig.customLog.info("Frase codificada: ["+this.testCodifica(fraseOriginal)+"]");
	}
	public String testCodifica(String fraseOriginal) {

		String claveUno    = "tauo";
		String claveDos    = "deli";

		String frasePorCodificar	= fraseOriginal;
		String fraseNueva		= "";
		for (int i =0; i< frasePorCodificar.length(); i++) {
			char letra=frasePorCodificar.charAt(i);
			char letraNueva= letra;
			for (int j=0; j<claveUno.length(); j++) {
				letraNueva	= this.sustituye(letra, claveUno.charAt(j), claveDos.charAt(j));
				if (letraNueva!=letra) {
					break;
				}
			}
			fraseNueva	= fraseNueva.concat(String.valueOf(letraNueva));
		}
		//appConfig.customLog.info("Frase original: ["+fraseOriginal+"]");
		//appConfig.customLog.info("Frase codificada: ["+fraseNueva+"]");

		return fraseNueva;
	}

	public char sustituye(char letraOriginal, char letraCodUno, char letraCodDos) {
		//Pasamos a minúscula
		char letraPorCodificar=String.valueOf(letraOriginal).toLowerCase().charAt(0);
		boolean tieneAcento	= !( letraPorCodificar==quitarAcento(letraPorCodificar) );
		letraPorCodificar	= quitarAcento(letraPorCodificar);
		char letraPorRetornar=letraPorCodificar;
		boolean isUpper	= ( String.valueOf(letraOriginal).toUpperCase().equals(String.valueOf(letraOriginal)) );
		//TODO: Acentos
		if (letraPorCodificar==letraCodUno) {
			letraPorRetornar=letraCodDos;
		} else if (letraPorCodificar==letraCodDos) {
			letraPorRetornar=letraCodUno;
		}
		if(tieneAcento) {
			letraPorRetornar=agregarAcento(letraPorRetornar);
		}
		if (isUpper) {
			letraPorRetornar=String.valueOf(letraPorRetornar).toUpperCase().charAt(0);;
		}
		return letraPorRetornar;
	}
	public char agregarAcento(char letra) {
		switch (letra) {
			case 'a': return 'á';
			case 'e': return 'é';
			case 'i': return 'í';
			case 'o': return 'ó';
			case 'u': return 'ú';
			// Puedes agregar más casos según tus necesidades
			default: return letra; // Si la letra no tiene acento, devolver la misma letra
		}
	}
	public char quitarAcento(char letra) {
		switch (letra) {
			case 'á': return 'a';
			case 'é': return 'e';
			case 'í': return 'i';
			case 'ó': return 'o';
			case 'ú': return 'u';
			// Puedes agregar más casos según tus necesidades
			default: return letra; // Si la letra no tiene acento, devolver la misma letra
		}
	}
*/

	/*
	@Test
	public void testDateFromExcelNumber() throws ParseException {
		assertThat(calendarioHelper.convierteFechaStrToFormatoBd("2021-02-12").toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).isEqualTo(HtmlToDto.dateFromExcelNumber(Double.valueOf("44239")));
		assertThat(calendarioHelper.convierteFechaStrToFormatoBd("1976-07-09").toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).isEqualTo(HtmlToDto.dateFromExcelNumber(Double.valueOf("27950")));
		assertThat(calendarioHelper.convierteFechaStrToFormatoBd("1950-08-31").toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).isEqualTo(HtmlToDto.dateFromExcelNumber(Double.valueOf("18506")));
	}
	*/

	/*
	@Test
	public void testReporteInversiones() {
		var salida	= reporteInversionesService.calculaRentabilidadDetallada("13139823-9", null, null, null, "20230101", "20240330");
		//Varificar que el tamaño de la lista salida sean 141 registros
		assertThat(salida.size()).isEqualTo(141);
		//Muestra por consola con algún formato "humano" el detalle de la variable salida
		appConfig.customLog.info("Salida: "+salida.toString());
	}
	*/
	/*
	@Test
	public void testListaclientesCuentas() {
		var resultadoClientes = reporteInversionesService.listaUniversoClientes(null);
		resultadoClientes.forEach(item -> appConfig.customLog.info("Salida Clientes: " + item.getProjectionAsString()));

		var resultadoCuentas = reporteInversionesService.listaUniversoCuentas(null);
		resultadoCuentas.forEach(item -> appConfig.customLog.info("Salida Cuentas: " + item.getProjectionAsString()));

	}
	*/
	/*
	@Test
	public void testListaclientesCuentas() {
		var resultado = rentabilidadCalculadaDao.calculaRentabilidad("13829808-6", null, null, null, "20240313", "20240413");
		appConfig.customLog.info("Salida resultado: " + resultado);
		var resultado2 = reporteInversionesService.calculaRentabilidad("13829808-6", null, null, null, "20240313", "20240413");

		assertThat(resultado.equals(resultado2)).isTrue();
	}
	*/
	/*
	--No usar esta librería
	@Test
	public void creaReporteInversiones() {
		String processDate	= "20240331";
		String idCliente	= "13829808-6";
		idCliente	= "19431643";

		var reporteCliente	= reporteInversionesService.generaReporteInversionesCliente(idCliente,processDate);
		appConfig.customLog.info("Salida: " + reporteCliente.toString());
		try {
			reporteInversionesService.generaPdfReporteInversiones(reporteCliente);
		} catch (IOException | URISyntaxException e) {
			appConfig.customLog.info("Error generando pdf:"+e.getMessage());
			throw new RuntimeException(e);
		}
	}
	 */
/*
	@Test
	public void testGeneraPdf() {

		String processDate	= "20240331";
		String idCliente	= "13829808-6";
		idCliente	= "19431643";

		appConfig.customLog.info("Obteniendo datos cliente: " + idCliente + " para fecha: " + processDate);
		var reporteCliente	= reporteInversionesService.generaReporteInversionesCliente(idCliente,processDate);	//3 min
		appConfig.customLog.info("Datos obtenidos");
		try {
			pdfReporteInversionesService.generaPdfCliente(reporteCliente);
		} catch (Exception e) {
			appConfig.customLog.info("Error generando pdf:"+e.getMessage());
			throw new RuntimeException(e);
		}
		idCliente	= "10091580";

		appConfig.customLog.info("Obteniendo datos cliente: " + idCliente + " para fecha: " + processDate);
		reporteCliente	= reporteInversionesService.generaReporteInversionesCliente(idCliente,processDate);	//3 min
		appConfig.customLog.info("Datos obtenidos");
		try {
			pdfReporteInversionesService.generaPdfCliente(reporteCliente);
		} catch (Exception e) {
			appConfig.customLog.info("Error generando pdf:"+e.getMessage());
			throw new RuntimeException(e);
		}

	}
*/
/*
	@Test
	public void testFormatNumThymeleaf() {
		//assertThat(CustomThymeleafHelper.formatNumberWithDecimals(null, 0, BigDecimal.ZERO)).isEqualTo("0");
		//assertThat(CustomThymeleafHelper.formatNumberWithDecimals(null, 4, BigDecimal.ZERO)).isEqualTo("0.0000");
		//assertThat(CustomThymeleafHelper.formatNumberWithDecimals(BigDecimal.valueOf(0.000000), 0, BigDecimal.ZERO)).isEqualTo("0");
		//assertThat(CustomThymeleafHelper.formatNumberWithDecimals(BigDecimal.valueOf(0.000000), 2, BigDecimal.ZERO)).isEqualTo("0.00");
		//assertThat(CustomThymeleafHelper.formatNumberWithDecimals(BigDecimal.valueOf(1.23456789), 3, BigDecimal.ZERO)).isEqualTo("1.235");
		//assertThat(CustomThymeleafHelper.formatNumberWithDecimals(BigDecimal.valueOf(1.23456789), 0, BigDecimal.ZERO)).isEqualTo("1");
		//assertThat(CustomThymeleafHelper.formatNumberWithDecimals(BigDecimal.valueOf(1.23456789), 1, BigDecimal.ZERO)).isEqualTo("1.2");
		assertThat(CustomThymeleafHelper.formatNumberWithDecimals(BigDecimal.valueOf(12345.6789), 0, BigDecimal.ZERO)).isEqualTo("12,346");
		assertThat(CustomThymeleafHelper.formatNumberWithDecimals(BigDecimal.valueOf(12345.6789), 1, BigDecimal.ZERO)).isEqualTo("12,345.7");
		assertThat(CustomThymeleafHelper.formatNumberWithDecimals(BigDecimal.valueOf(12345.6789), 5, BigDecimal.ZERO)).isEqualTo("12,345.67890");
	}
*/
/*
	@Test
	public void testCalculaAnioAtras() {
		String endProcessDate = "";
		endProcessDate = "20240131";
		assertThat(calendarioHelper.convierteDateToStringWithFormat(calendarioHelper.makeDateFromParts(Integer.valueOf(endProcessDate.substring(0, 4)), Integer.valueOf(endProcessDate.substring(4, 6))-12, 1), "yyyyMMdd")).isEqualTo("20230101");

		endProcessDate = "20240229";
		assertThat(calendarioHelper.convierteDateToStringWithFormat(calendarioHelper.makeDateFromParts(Integer.valueOf(endProcessDate.substring(0, 4)), Integer.valueOf(endProcessDate.substring(4, 6))-12, 1), "yyyyMMdd")).isEqualTo("20230201");

		endProcessDate = "20240331";
		assertThat(calendarioHelper.convierteDateToStringWithFormat(calendarioHelper.makeDateFromParts(Integer.valueOf(endProcessDate.substring(0, 4)), Integer.valueOf(endProcessDate.substring(4, 6))-12, 1), "yyyyMMdd")).isEqualTo("20230301");

		endProcessDate = "20240430";
		assertThat(calendarioHelper.convierteDateToStringWithFormat(calendarioHelper.makeDateFromParts(Integer.valueOf(endProcessDate.substring(0, 4)), Integer.valueOf(endProcessDate.substring(4, 6))-12, 1), "yyyyMMdd")).isEqualTo("20230401");

		endProcessDate = "20240531";
		assertThat(calendarioHelper.convierteDateToStringWithFormat(calendarioHelper.makeDateFromParts(Integer.valueOf(endProcessDate.substring(0, 4)), Integer.valueOf(endProcessDate.substring(4, 6))-12, 1), "yyyyMMdd")).isEqualTo("20230501");

		endProcessDate = "20240630";
		assertThat(calendarioHelper.convierteDateToStringWithFormat(calendarioHelper.makeDateFromParts(Integer.valueOf(endProcessDate.substring(0, 4)), Integer.valueOf(endProcessDate.substring(4, 6))-12, 1), "yyyyMMdd")).isEqualTo("20230601");

		endProcessDate = "20240731";
		assertThat(calendarioHelper.convierteDateToStringWithFormat(calendarioHelper.makeDateFromParts(Integer.valueOf(endProcessDate.substring(0, 4)), Integer.valueOf(endProcessDate.substring(4, 6))-12, 1), "yyyyMMdd")).isEqualTo("20230701");

		endProcessDate = "20240831";
		assertThat(calendarioHelper.convierteDateToStringWithFormat(calendarioHelper.makeDateFromParts(Integer.valueOf(endProcessDate.substring(0, 4)), Integer.valueOf(endProcessDate.substring(4, 6))-12, 1), "yyyyMMdd")).isEqualTo("20230801");

		endProcessDate = "20240930";
		assertThat(calendarioHelper.convierteDateToStringWithFormat(calendarioHelper.makeDateFromParts(Integer.valueOf(endProcessDate.substring(0, 4)), Integer.valueOf(endProcessDate.substring(4, 6))-12, 1), "yyyyMMdd")).isEqualTo("20230901");

		endProcessDate = "20241031";
		assertThat(calendarioHelper.convierteDateToStringWithFormat(calendarioHelper.makeDateFromParts(Integer.valueOf(endProcessDate.substring(0, 4)), Integer.valueOf(endProcessDate.substring(4, 6))-12, 1), "yyyyMMdd")).isEqualTo("20231001");

		endProcessDate = "20241130";
		assertThat(calendarioHelper.convierteDateToStringWithFormat(calendarioHelper.makeDateFromParts(Integer.valueOf(endProcessDate.substring(0, 4)), Integer.valueOf(endProcessDate.substring(4, 6))-12, 1), "yyyyMMdd")).isEqualTo("20231101");

		endProcessDate = "20241231";
		assertThat(calendarioHelper.convierteDateToStringWithFormat(calendarioHelper.makeDateFromParts(Integer.valueOf(endProcessDate.substring(0, 4)), Integer.valueOf(endProcessDate.substring(4, 6))-12, 1), "yyyyMMdd")).isEqualTo("20231201");

	}
*/
	@Test
	public void testCargaSflHistorica() throws QandeMmiiException {
		String startProcessDate = "20240409";
		String endProcessDate	= "20240514";
		//haz un ciclo desde startProcessDate hasta endProcessDate y llama al job jobGetFromFtpPershing.processByProcessDate(processDate, true);

		//jobGetFromFtpPershing.processByProcessDate("20240409", true);
		//jobGetFromFtpPershing.processByProcessDate("20240410", true);
		//jobGetFromFtpPershing.processByProcessDate("20240411", true);
		//jobGetFromFtpPershing.processByProcessDate("20240412", true);
		//jobGetFromFtpPershing.processByProcessDate("20240413", true);
		//jobGetFromFtpPershing.processByProcessDate("20240414", true);
		//jobGetFromFtpPershing.processByProcessDate("20240415", true);
		//jobGetFromFtpPershing.processByProcessDate("20240416", true);
		//jobGetFromFtpPershing.processByProcessDate("20240417", true);
		//jobGetFromFtpPershing.processByProcessDate("20240418", true);
		//jobGetFromFtpPershing.processByProcessDate("20240419", true);
		//jobGetFromFtpPershing.processByProcessDate("20240420", true);
		//jobGetFromFtpPershing.processByProcessDate("20240421", true);
		//jobGetFromFtpPershing.processByProcessDate("20240422", true);
		//jobGetFromFtpPershing.processByProcessDate("20240423", true);

		//jobGetFromFtpPershing.processByProcessDate("20240424", true);
		//jobGetFromFtpPershing.processByProcessDate("20240425", true);
		//jobGetFromFtpPershing.processByProcessDate("20240426", true);
		//jobGetFromFtpPershing.processByProcessDate("20240427", true);
		//jobGetFromFtpPershing.processByProcessDate("20240428", true);
		//jobGetFromFtpPershing.processByProcessDate("20240429", true);
		//jobGetFromFtpPershing.processByProcessDate("20240430", true);
		//jobGetFromFtpPershing.processByProcessDate("20240501", true);
		//jobGetFromFtpPershing.processByProcessDate("20240502", true);
		//jobGetFromFtpPershing.processByProcessDate("20240503", true);
		//jobGetFromFtpPershing.processByProcessDate("20240504", true);
		//jobGetFromFtpPershing.processByProcessDate("20240505", true);
		//jobGetFromFtpPershing.processByProcessDate("20240506", true);
		//jobGetFromFtpPershing.processByProcessDate("20240507", true);
		//jobGetFromFtpPershing.processByProcessDate("20240508", true);
		//jobGetFromFtpPershing.processByProcessDate("20240509", true);
		//jobGetFromFtpPershing.processByProcessDate("20240510", true);
		//jobGetFromFtpPershing.processByProcessDate("20240511", true);
		//jobGetFromFtpPershing.processByProcessDate("20240512", true);
		//jobGetFromFtpPershing.processByProcessDate("20240513", true);
		//jobGetFromFtpPershing.processByProcessDate("20240514", true);


	}
	/*
	@Test
	public void testProcesoHistorico() throws QandeMmiiException, ParseException {
		
		jobGetFromFtpPershing.processByProcessDate("20240409", true);
		jobGetFromFtpPershing.processByProcessDate("20240410", true);
		jobGetFromFtpPershing.processByProcessDate("20240411", true);
		jobGetFromFtpPershing.processByProcessDate("20240412", true);
		jobGetFromFtpPershing.processByProcessDate("20240413", true);
		jobGetFromFtpPershing.processByProcessDate("20240414", true);
		jobGetFromFtpPershing.processByProcessDate("20240415", true);
		jobGetFromFtpPershing.processByProcessDate("20240416", true);
		jobGetFromFtpPershing.processByProcessDate("20240417", true);
		jobGetFromFtpPershing.processByProcessDate("20240418", true);
		jobGetFromFtpPershing.processByProcessDate("20240419", true);
		jobGetFromFtpPershing.processByProcessDate("20240420", true);
		jobGetFromFtpPershing.processByProcessDate("20240421", true);
		jobGetFromFtpPershing.processByProcessDate("20240422", true);
		jobGetFromFtpPershing.processByProcessDate("20240423", true);
		jobGetFromFtpPershing.processByProcessDate("20240424", true);
		jobGetFromFtpPershing.processByProcessDate("20240425", true);
		jobGetFromFtpPershing.processByProcessDate("20240426", true);
		jobGetFromFtpPershing.processByProcessDate("20240427", true);
		jobGetFromFtpPershing.processByProcessDate("20240428", true);
		jobGetFromFtpPershing.processByProcessDate("20240429", true);
		jobGetFromFtpPershing.processByProcessDate("20240430", true);
		jobGetFromFtpPershing.processByProcessDate("20240501", true);
		jobGetFromFtpPershing.processByProcessDate("20240502", true);
		jobGetFromFtpPershing.processByProcessDate("20240503", true);
		jobGetFromFtpPershing.processByProcessDate("20240504", true);
		jobGetFromFtpPershing.processByProcessDate("20240505", true);
		jobGetFromFtpPershing.processByProcessDate("20240506", true);
		jobGetFromFtpPershing.processByProcessDate("20240507", true);
		jobGetFromFtpPershing.processByProcessDate("20240508", true);
		jobGetFromFtpPershing.processByProcessDate("20240509", true);
		jobGetFromFtpPershing.processByProcessDate("20240510", true);
		jobGetFromFtpPershing.processByProcessDate("20240511", true);
		jobGetFromFtpPershing.processByProcessDate("20240512", true);
		jobGetFromFtpPershing.processByProcessDate("20240513", true);
		jobGetFromFtpPershing.processByProcessDate("20240514", true);
		jobGetFromFtpPershing.processByProcessDate("20240515", true);



		jobReportesMaestros.generaReportesByProcessDate("20240409");
		jobReportesMaestros.generaReportesByProcessDate("20240410");
		jobReportesMaestros.generaReportesByProcessDate("20240411");
		jobReportesMaestros.generaReportesByProcessDate("20240412");
		jobReportesMaestros.generaReportesByProcessDate("20240413");
		jobReportesMaestros.generaReportesByProcessDate("20240414");
		jobReportesMaestros.generaReportesByProcessDate("20240415");
		jobReportesMaestros.generaReportesByProcessDate("20240416");
		jobReportesMaestros.generaReportesByProcessDate("20240417");
		jobReportesMaestros.generaReportesByProcessDate("20240418");
		jobReportesMaestros.generaReportesByProcessDate("20240419");
		jobReportesMaestros.generaReportesByProcessDate("20240420");
		jobReportesMaestros.generaReportesByProcessDate("20240421");
		jobReportesMaestros.generaReportesByProcessDate("20240422");
		jobReportesMaestros.generaReportesByProcessDate("20240423");
		jobReportesMaestros.generaReportesByProcessDate("20240424");
		jobReportesMaestros.generaReportesByProcessDate("20240425");
		jobReportesMaestros.generaReportesByProcessDate("20240426");
		jobReportesMaestros.generaReportesByProcessDate("20240427");
		jobReportesMaestros.generaReportesByProcessDate("20240428");
		jobReportesMaestros.generaReportesByProcessDate("20240429");
		jobReportesMaestros.generaReportesByProcessDate("20240430");
		jobReportesMaestros.generaReportesByProcessDate("20240501");
		jobReportesMaestros.generaReportesByProcessDate("20240502");
		jobReportesMaestros.generaReportesByProcessDate("20240503");
		jobReportesMaestros.generaReportesByProcessDate("20240504");
		jobReportesMaestros.generaReportesByProcessDate("20240505");
		jobReportesMaestros.generaReportesByProcessDate("20240506");
		jobReportesMaestros.generaReportesByProcessDate("20240507");
		jobReportesMaestros.generaReportesByProcessDate("20240508");
		jobReportesMaestros.generaReportesByProcessDate("20240509");
		jobReportesMaestros.generaReportesByProcessDate("20240510");
		jobReportesMaestros.generaReportesByProcessDate("20240511");
		jobReportesMaestros.generaReportesByProcessDate("20240512");
		jobReportesMaestros.generaReportesByProcessDate("20240513");
		jobReportesMaestros.generaReportesByProcessDate("20240514");
		jobReportesMaestros.generaReportesByProcessDate("20240515");

	}
	*/

}