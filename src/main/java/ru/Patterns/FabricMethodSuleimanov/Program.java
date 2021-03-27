package ru.Patterns.FabricMethodSuleimanov;

public class Program {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = createDeveloperFactoryBySpecialty("ruby");
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();
    }

    public static DeveloperFactory createDeveloperFactoryBySpecialty(String specoalty) {
        if (specoalty.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        } else if (specoalty.equalsIgnoreCase("php")) {
            return new PHPDeveloperFactory();
        } else if (specoalty.equalsIgnoreCase("python")) {
            return new PythonDeveloperFactory();
        } else if (specoalty.equalsIgnoreCase("Ruby")) {
            return new RubyDeveloperFactory();
        } else {
            throw new RuntimeException("unknown specialty");
        }
    }
}
