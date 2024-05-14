package cl.qande.mmii.app.util.helper;

import com.cronutils.descriptor.CronDescriptor;
import com.cronutils.model.Cron;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.time.ExecutionTime;
import com.cronutils.parser.CronParser;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Locale;

@Component
public class CronHelper {

    private static final Locale LOCALE_ES   = new Locale ( "es" , "ES" );
    private static final Locale LOCALE_US   = Locale.US;
    private static final CronDefinition QANDE_CRON_FORMAT   = customCronDefinition();

    private static CronDefinition customCronDefinition() {
        return CronDefinitionBuilder.defineCron()
                .withSeconds().withValidRange(0, 59).and()
                .withMinutes().withValidRange(0, 59).and()
                .withHours().withValidRange(0, 23).and()
                .withDayOfMonth().withValidRange(1, 31).supportsL().supportsW().supportsLW().supportsQuestionMark().and()
                .withMonth().withValidRange(1, 12).and()
                //.withDayOfWeek().withValidRange(1, 7).withMondayDoWValue(2).supportsHash().supportsL().supportsQuestionMark().and()
                .withYear().withValidRange(1970, 2099).withStrictRange().optional().and()
                .instance();
    }
    public boolean compareCronDescription(String cronExpresion) {

        CronParser parser = new CronParser(QANDE_CRON_FORMAT);
        Cron quartzCron = parser.parse(cronExpresion);
        return ( cronExpresion.equals(quartzCron.asString()) );
    }

    public String humanDescriptionEs(String cronExpresion) {
        return humanDescription(cronExpresion, LOCALE_ES);
    }
    public String humanDescriptionUs(String cronExpresion) {
        return humanDescription(cronExpresion, LOCALE_US);
    }
    private String humanDescription(String cronExpresion, Locale locale) {
        CronParser parser = new CronParser(QANDE_CRON_FORMAT);
        return CronDescriptor.instance(locale).describe(parser.parse(cronExpresion));
    }

    public ZonedDateTime getNextExecution(String cronExpresion) {
        CronParser quartzCronParser = new CronParser(QANDE_CRON_FORMAT);
        Cron parsedQuartzCronExpression = quartzCronParser.parse(cronExpresion);
        ZonedDateTime now = ZonedDateTime.now();
        ExecutionTime executionTime = ExecutionTime.forCron(parsedQuartzCronExpression);
        return executionTime.nextExecution(now).get();
    }
}
