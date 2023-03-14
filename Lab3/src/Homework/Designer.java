package Homework;

import java.time.LocalDate;
import java.util.Date;

public class Designer extends Person{
    private String designerType;

    /**
     * Constructor
     *
     * @param name
     * @param birthDate
     */
    public Designer(String name, LocalDate birthDate, String designerType) {
        super(name, birthDate);
        this.designerType = designerType;
    }

    public String getDesignerType() {
        return designerType;
    }

    public void setDesignerType(String designerType) {
        this.designerType = designerType;
    }
}
