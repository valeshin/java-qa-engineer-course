package exceptions;

public class TemplateDataException extends Exception {

    public TemplateDataException(String name) {
        super(String.format("Template data %s is empty", name));
    }
}
