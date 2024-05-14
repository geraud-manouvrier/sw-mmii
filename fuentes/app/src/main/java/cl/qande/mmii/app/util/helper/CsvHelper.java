package cl.qande.mmii.app.util.helper;


import cl.qande.mmii.app.models.exception.QandeMmiiException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvHelper {
    //https://www.baeldung.com/opencsv
    public List<CsvBean> beanBuilderStonex(Path path, Class clazz) throws QandeMmiiException {
        CsvTransfer csvTransfer = new CsvTransfer();

        try (Reader reader = Files.newBufferedReader(path)) {
            CsvToBean cb = new CsvToBeanBuilder<CsvBean>(reader)
                    .withType(clazz)
                    .withSeparator('|')
                    .withSkipLines(0)
                    .build();

            csvTransfer.setCsvList(cb.parse());
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error al leer CSV ["+path.toString()+"]: "+e.getMessage());
        }
        return csvTransfer.getCsvList();
    }

    public List<CsvBean> processCsvBean(Path pathToCsv, Class clazz) throws QandeMmiiException {
        return beanBuilderStonex(pathToCsv, clazz);
    }
}
