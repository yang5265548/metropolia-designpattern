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
        boolean isGaming;
        if (choice == 1) {
            computerBuilder = new GamingComputerBuilder();
            isGaming = true;
        } else if (choice == 2) {
            computerBuilder = new OfficeComputerBuilder();
            isGaming = false;
        } else {
            System.out.println("Invalid choice. Exiting.");
            return;
        }

        // Processor
        System.out.println("Select the processor:");
        if (isGaming) {
            System.out.println("1. Intel i9\n2. AMD Ryzen 9\n3. Intel i7\n4. AMD Ryzen 7\n5. Intel Xeon\n6. AMD Threadripper");
        } else {
            System.out.println("1. Intel i5\n2. AMD Ryzen 5\n3. Intel i3\n4. AMD Athlon\n5. Apple M1\n6. Intel N200");
        }
        String processor = switch (scanner.nextInt()) {
            case 1 -> isGaming ? "Intel i9" : "Intel i5";
            case 2 -> isGaming ? "AMD Ryzen 9" : "AMD Ryzen 5";
            case 3 -> isGaming ? "Intel i7" : "Intel i3";
            case 4 -> isGaming ? "AMD Ryzen 7" : "AMD Athlon";
            case 5 -> isGaming ? "Intel Xeon" : "Apple M1";
            case 6 -> isGaming ? "AMD Threadripper" : "Intel N200";
            default -> throw new IllegalArgumentException("Invalid choice. Exiting.");
        };

        // RAM
        System.out.println("Select the RAM size:");
        if (isGaming) {
            System.out.println("1. 16GB\n2. 32GB\n3. 64GB\n4. 128GB\n5. 256GB\n6. 512GB");
        } else {
            System.out.println("1. 4GB\n2. 8GB\n3. 16GB\n4. 32GB\n5. 64GB\n6. 128GB");
        }
        int ram = switch (scanner.nextInt()) {
            case 1 -> isGaming ? 16 : 4;
            case 2 -> isGaming ? 32 : 8;
            case 3 -> isGaming ? 64 : 16;
            case 4 -> isGaming ? 128 : 32;
            case 5 -> isGaming ? 256 : 64;
            case 6 -> isGaming ? 512 : 128;
            default -> throw new IllegalArgumentException("Invalid choice. Exiting.");
        };

        // Storage
        System.out.println("Select the storage type:");
        if (isGaming) {
            System.out.println("1. SSD 512GB\n2. SSD 1TB\n3. SSD 2TB\n4. SSD 4TB\n5. NVMe 2TB\n6. NVMe 4TB");
        } else {
            System.out.println("1. HDD 500GB\n2. HDD 1TB\n3. SSD 128GB\n4. SSD 256GB\n5. SSD 512GB\n6. HDD 2TB");
        }
        String storage = switch (scanner.nextInt()) {
            case 1 -> isGaming ? "SSD 512GB" : "HDD 500GB";
            case 2 -> isGaming ? "SSD 1TB" : "HDD 1TB";
            case 3 -> isGaming ? "SSD 2TB" : "SSD 128GB";
            case 4 -> isGaming ? "SSD 4TB" : "SSD 256GB";
            case 5 -> isGaming ? "NVMe 2TB" : "SSD 512GB";
            case 6 -> isGaming ? "NVMe 4TB" : "HDD 2TB";
            default -> throw new IllegalArgumentException("Invalid choice. Exiting.");
        };

        // Graphics Card
        System.out.println("Select the graphics card:");
        if (isGaming) {
            System.out.println("1. NVIDIA RTX 4070\n2. NVIDIA RTX 4080\n3. NVIDIA RTX 4090\n4. AMD Radeon RX 7900 XTX\n5. Intel Arc A770\n6. Dual RTX 4080");
        } else {
            System.out.println("1. Integrated Graphics\n2. NVIDIA GT 1030\n3. AMD Radeon Vega 8\n4. Intel UHD 770\n5. NVIDIA Quadro P620\n6. No Graphics Card");
        }
        String graphicsCard = switch (scanner.nextInt()) {
            case 1 -> isGaming ? "NVIDIA RTX 4070" : "Integrated Graphics";
            case 2 -> isGaming ? "NVIDIA RTX 4080" : "NVIDIA GT 1030";
            case 3 -> isGaming ? "NVIDIA RTX 4090" : "AMD Radeon Vega 8";
            case 4 -> isGaming ? "AMD Radeon RX 7900 XTX" : "Intel UHD 770";
            case 5 -> isGaming ? "Intel Arc A770" : "NVIDIA Quadro P620";
            case 6 -> isGaming ? "Dual RTX 4080" : "No Graphics Card";
            default -> throw new IllegalArgumentException("Invalid choice. Exiting.");
        };

        // Operating System
        System.out.println("Select the operating system:");
        System.out.println("1. Windows 11\n2. Windows 10\n3. Ubuntu Linux\n4. Fedora\n5. macOS\n6. Arch Linux");
        String operatingSystem = switch (scanner.nextInt()) {
            case 1 -> "Windows 11";
            case 2 -> "Windows 10";
            case 3 -> "Ubuntu Linux";
            case 4 -> "Fedora";
            case 5 -> "macOS";
            case 6 -> "Arch Linux";
            default -> throw new IllegalArgumentException("Invalid choice. Exiting.");
        };

        ComputerDirector computerDirector = new ComputerDirector(computerBuilder);
        computerDirector.constructComputer(processor, ram, storage, graphicsCard, operatingSystem);
        Computer computer = computerDirector.getComputer();
        System.out.println("Computer built successfully!");
        computer.showDetails();
        System.out.println("Congratulations! Your computer is ready to use.");
    }
}
