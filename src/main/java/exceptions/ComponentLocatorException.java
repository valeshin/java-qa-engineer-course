package exceptions;

public class ComponentLocatorException extends Exception {

    public ComponentLocatorException(String classname) {
        super(String.format("Component locator of class %s is not found", classname));
    }
}
