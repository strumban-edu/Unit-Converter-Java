import java.util.Scanner;

public class unit_converter {
    public static double converter_distance(String unitFrom, String unitTo, double value) {
        if (unitFrom.equals(unitTo)) {
            return value;
        }

        switch (unitFrom) {
            case "mm":
                break;
            case "cm":
                value *= 10;
                break;
            case "m":
                value *= 1000;
                break;
            case "km":
                value *= 1000000;
                break;
            case "in":
                value *= 25.4;
                break;
            case "ft":
                value *= 304.8;
                break;
            case "yd":
                value *= 914.4;
                break;
            case "mi":
                value *= 1609000;
                break;
        }

        switch (unitTo) {
            case "mm":
                break;
            case "cm":
                value /= 10;
                break;
            case "m":
                value /= 1000;
                break;
            case "km":
                value /= 1000000;
                break;
            case "in":
                value /= 25.4;
                break;
            case "ft":
                value /= 304.8;
                break;
            case "yd":
                value /= 914.4;
                break;
            case "mi":
                value /= 1609000;
                break;
        }

        return value;
    }

    public static double converter_mass(String unitFrom, String unitTo, double value) {
        if (unitFrom.equals(unitTo)) {
            return value;
        }

        switch (unitFrom) {
            case "mg":
                break;
            case "g":
                value *= 1000;
                break;
            case "kg":
                value *= 1000000;
                break;
            case "t":
                value *= 1000000000;
                break;
            case "oz":
                value *= 28349.5;
                break;
            case "lb":
                value *= 453592;
                break;
            case "tn":
                value *= 907200000;
                break;
        }

        switch (unitTo) {
            case "mg":
                break;
            case "g":
                value /= 1000;
                break;
            case "kg":
                value /= 1000000;
                break;
            case "t":
                value /= 1000000000;
                break;
            case "oz":
                value /= 28349.5;
                break;
            case "lb":
                value /= 453592;
                break;
            case "tn":
                value /= 907200000;
                break;
        }

        return value;
    }

    public static double converter_volume(String unitFrom, String unitTo, double value) {
        if (unitFrom.equals(unitTo)) {
            return value;
        }

        switch (unitFrom) {
            case "mL":
                break;
            case "L":
                value *= 1000;
                break;
            case "tsp":
                value *= 5.91939;
                break;
            case "Tbsp":
                value *= 17.7582;
                break;
            case "floz":
                value *= 29.5735;
                break;
            case "cp":
                value *= 236.588;
                break;
            case "pt":
                value *= 473.176;
                break;
            case "qt":
                value *= 946.353;
                break;
            case "gal":
                value *= 3785.41;
                break;
        }

        switch (unitTo) {
            case "mL":
                break;
            case "L":
                value /= 1000;
                break;
            case "tsp":
                value /= 5.91939;
                break;
            case "Tbsp":
                value /= 17.7582;
                break;
            case "floz":
                value /= 29.5735;
                break;
            case "cp":
                value /= 236.588;
                break;
            case "pt":
                value /= 473.176;
                break;
            case "qt":
                value /= 946.353;
                break;
            case "gal":
                value /= 3785.41;
                break;
        }
        
        return value;
    }

    public static void main(String[] args) throws Exception {
        String unitType;
        String[] validUnits;
        double value;
        String unitFrom = "";
        String unitTo = "";
        boolean exit;

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("------------------------");
            System.out.println("--                    --");
            System.out.println("--   UNIT CONVERTER   --");
            System.out.println("--                    --");
            System.out.println("------------------------");
            System.out.println("What kind of units would you like to convert?");
            System.out.println();
            System.out.println("Available unit types: ");
            System.out.println("distance, mass, volume");
            System.out.println();
            System.out.println("Or type 'exit' to leave the converter.");
            System.out.println();

            System.out.print("Enter a unit type: ");
            unitType = scan.nextLine();
            System.out.println();

            if (unitType.equals("exit") || unitType.equals("e")) {
                scan.close();
                System.out.println("Thank you for using the converter!");
                break;
            } else if (unitType.equals("distance") || unitType.equals("d")) {
                unitType = "DISTANCE";
                validUnits = new String[] {"mm", "cm", "m", "km", "in", "ft", "yd", "mi"};
            } else if (unitType.equals("mass") || unitType.equals("m")) {
                unitType = "MASS";
                validUnits = new String[] {"mg", "g", "kg", "t", "oz", "lb", "tn"};
            } else if (unitType.equals("volume") || unitType.equals("v")) {
                unitType = "VOLUME";
                validUnits = new String[] {"mL", "L", "tsp", "Tbsp", "floz", "cp", "pt", "qt", "gal"};
            } else {
                System.out.println("Sorry, but '" + unitType + "' is not a valid unit.");
                System.out.println("Please recheck your input and try again.");
                System.out.println();
                System.out.print("Enter anything to continue... ");
                scan.nextLine();
                System.out.println();
                continue;
            }
            
            int unitPadding = (22 - unitType.length()) / 2;
            String fill = "";
            for (int i = 0; i < unitPadding; i++) {
               fill += " ";
            }

            while (true) {
                System.out.println("------------------------");
                System.out.println("-" + fill + String.format(unitType) + fill + "-");
                System.out.println("------------------------");
    
                System.out.println("Now, pick a unit to convert from.");
                System.out.println();
                System.out.println("Available options: ");
                System.out.println(String.join(", ", validUnits));
                System.out.println();
                System.out.println("Or type 'back' to return to the main menu.");
                System.out.println();
                
                exit = false;
                while (!exit) {
                    System.out.print("Enter a unit: ");
                    unitFrom = scan.nextLine();
    
                    if (unitFrom.equals("back") || unitFrom.equals("b")) {
                        break;
                    }
    
                    for (String unit : validUnits) {
                        if (unitFrom.equals(unit)) {
                            exit = true;
                            break;
                        }
                    }
                    
                    if (!exit) {
                        System.out.println("Unit must be one of available options. Please input again.");
                        System.out.println();
                    }
                }
                
                if (unitFrom.equals("back") || unitFrom.equals("b")) {
                    System.out.println("Returning to main menu...");
                    System.out.println();
                    break;
                }
    
                value = -1;
                while (value < 0) {
                    System.out.print("Enter a quantity of " + unitFrom + " to convert: ");
                    value = scan.nextDouble();
                    scan.nextLine();

                    if (value < 0) {
                        System.out.println("Quantity must be greater than or equal to 0. Please input again.");
                        System.out.println();
                    }
                }

                System.out.println();
                System.out.println("------------------------------------------------");
                System.out.println("And now pick a unit to convert to.");
                System.out.println();
                System.out.println("Available options: ");
                System.out.println(String.join(", ", validUnits));
                System.out.println();
                System.out.println("Or type 'back' to return to the main menu.");
                System.out.println();

                exit = false;
                while (!exit) {
                    System.out.print("Enter a unit: ");
                    unitTo = scan.nextLine();
    
                    if (unitTo.equals("back") || unitTo.equals("b")) {
                        break;
                    }
    
                    for (String unit : validUnits) {
                        if (unitTo.equals(unit)) {
                            exit = true;
                            break;
                        }
                    }
                    
                    if (!exit) {
                        System.out.println("Unit must be one of available options. Please input again.");
                        System.out.println();
                    }
                }
                
                if (unitTo.equals("back") || unitTo.equals("b")) {
                    System.out.println("Returning to main menu...");
                    System.out.println();
                    break;
                }

                System.out.println();
                System.out.println("------------------------------------------------");
                if (unitType.equals("DISTANCE")) {
                    System.out.println(String.format("%.4f", value) + " " + unitFrom + " is equivalent to about " + String.format("%.4f", converter_distance(unitFrom, unitTo, value)) + " " + unitTo + "!");
                } else if (unitType.equals("MASS")) {
                    System.out.println(String.format("%.4f", value) + " " + unitFrom + " is equivalent to about " + String.format("%.4f", converter_mass(unitFrom, unitTo, value)) + " " + unitTo + "!");
                } else if (unitType.equals("VOLUME")) {
                    System.out.println(String.format("%.4f", value) + " " + unitFrom + " is equivalent to about " + String.format("%.4f", converter_volume(unitFrom, unitTo, value)) + " " + unitTo + "!");
                }
                System.out.println();

                System.out.print("Enter anything to continue... ");
                scan.nextLine();
                System.out.println();
            }
        }
    }
}
