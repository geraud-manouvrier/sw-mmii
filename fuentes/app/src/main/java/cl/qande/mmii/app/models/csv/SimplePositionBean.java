package cl.qande.mmii.app.models.csv;

import cl.qande.mmii.app.util.helper.CsvBean;
import com.opencsv.bean.CsvBindByPosition;

public class SimplePositionBean extends CsvBean {

    @CsvBindByPosition(position = 0)
    private String exampleColOne;

    @CsvBindByPosition(position = 1)
    private String exampleColTwo;

    public String getExampleColOne() {
        return exampleColOne;
    }

    public void setExampleColOne(String exampleColOne) {
        this.exampleColOne = exampleColOne;
    }

    public String getExampleColTwo() {
        return exampleColTwo;
    }

    public void setExampleColTwo(String exampleColTwo) {
        this.exampleColTwo = exampleColTwo;
    }
}
