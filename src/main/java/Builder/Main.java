package Builder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select the type of computer you want to build:");
        System.out.println("1. Gaming Computer");
        System.out.println("2. Office Computer");
        int choice = scanner.nextInt();
        ComputerBuilder computerBuilder;
        if (choice == 1) {
            computerBuilder = new GamingComputerBuilder();
        } else if (choice == 2) {
            computerBuilder = new OfficeComputerBuilder();
        } else {
            System.out.println("Invalid choice. Exiting.");
            return;
        }

        System.out.println("Select the processor:");
        System.out.println("1. Intel i9\n2. AMD Ryzen 9\n3. Apple M1\n4. Intel i7\n5. AMD Ryzen 7\n6. Intel Xeon");
        String processor = switch (scanner.nextInt()) {
            case 1 -> "Intel i9";
            case 2 -> "AMD Ryzen 9";
            case 3 -> "Apple M1";
            case 4 -> "Intel i7";
            case 5 -> "AMD Ryzen 7";
            case 6 -> "Intel Xeon";
            default -> {
                throw new IllegalArgumentException("Invalid choice. Exiting.");
            }
        };

        System.out.println("Select the RAM size:");
        System.out.println("1. 8GB\n2. 16GB\n3. 32GB\n4. 64GB\n5. 128GB\n6. 256GB");
        int ram = switch (scanner.nextInt()) {
            case 1 -> 8;
            case 2 -> 16;
            case 3 -> 32;
            case 4 -> 64;
            case 5 -> 128;
            case 6 -> 256;
            default -> {
                throw new IllegalArgumentException("Invalid choice. Exiting.");
            }
        };

        System.out.println("Select the storage type:");
        System.out.println("1. HDD 1TB\n2. HDD 2TB\n3. SSD 256GB\n4. SSD 512GB\n5. SSD 1TB\n6. SSD 2TB");
        String storage = switch (scanner.nextInt()) {
            case 1 -> "HDD 1TB";
            case 2 -> "HDD 2TB";
            case 3 -> "SSD 256GB";
            case 4 -> "SSD 512GB";
            case 5 -> "SSD 1TB";
            case 6 -> "SSD 2TB";
            default -> {
                throw new IllegalArgumentException("Invalid choice. Exiting.");
            }
        };

        System.out.println("Select the graphics card:");
        System.out.println("1. NVIDIA RTX 3080\n2. AMD Radeon RX 6800\n3. Integrated Graphics\n4. NVIDIA RTX 4090\n5. AMD Radeon RX 7900\n6. Intel Arc A770");
        String graphicsCard = switch (scanner.nextInt()) {
            case 1 -> "NVIDIA RTX 3080";
            case 2 -> "AMD Radeon RX 6800";
            case 3 -> "Integrated Graphics";
            case 4 -> "NVIDIA RTX 4090";
            case 5 -> "AMD Radeon RX 7900";
            case 6 -> "Intel Arc A770";
            default -> {
                throw new IllegalArgumentException("Invalid choice. Exiting.");
            }
        };

        System.out.println("Select the operating system:");
        System.out.println("1. Windows 11\n2. Ubuntu Linux\n3. macOS\n4. Windows 10\n5. Fedora\n6. Arch Linux");
        String operatingSystem = switch (scanner.nextInt()) {
            case 1 -> "Windows 11";
            case 2 -> "Ubuntu Linux";
            case 3 -> "macOS";
            case 4 -> "Windows 10";
            case 5 -> "Fedora";
            case 6 -> "Arch Linux";
            default -> {
                throw new IllegalArgumentException("Invalid choice. Exiting.");
            }
        };

        ComputerDirector computerDirector = new ComputerDirector(computerBuilder);
        computerDirector.constructComputer(processor, ram, storage, graphicsCard, operatingSystem);
        Computer computer = computerDirector.getComputer();
        System.out.println("Computer built successfully!");
        computer.showDetails();
        System.out.println("Congratulations! Your computer is ready to use.");
    }
}
