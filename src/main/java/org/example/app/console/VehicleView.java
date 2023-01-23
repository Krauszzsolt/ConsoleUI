package org.example.app.console;

import org.example.app.console.viewModel.VehicleViewModel;

import java.util.Scanner;

public class VehicleView {

    private boolean running = true;


    public void setVehicleController(VehicleController vehicleController) {
        this.vehicleController = vehicleController;
    }

    private VehicleController vehicleController;

    public void DisplayVehicle(VehicleViewModel v){
        System.out.println("Rendszám: ");
        System.out.println(v.registrationNumber + "\n");
        System.out.println("Gyártmány: ");
        System.out.println(v.make + "\n");
        System.out.println("Típus: ");
        System.out.println(v.model + "\n");
        System.out.println("Űlőhelyek száma vezetővel: ");
        System.out.println(v.numberOfSeats + "\n");
        System.out.println("Jármű kategória: ");
        System.out.println(v.vehicleType + "\n");
    }

    public void simpleDisplay(String output) {
        System.out.println(output);
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (running)
        {
            selectAction(scanner);
        }
    }

    void selectAction(Scanner scanner) {
        System.out.print("Válassz tevékenységet!\n");
        System.out.print("Jármű nyilvántartásba felvétele (v), Jármű adatának lekérdezése (l)\n");
        String action = scanner.next();
        switch(action) {
            case "v":
                create(scanner);
                break;
            case "l":
                get(scanner);
                break;
            default:
                stop(action);
        }
    }

    private void create(Scanner scanner){
        System.out.print("Add meg a jármű rendszámát:\n");
        String registrationNumber = scanner.next();
        System.out.print("Add meg a jármű gyártmányát:\n");
        String make = scanner.next();
        System.out.print("Add meg a jármű típusát:\n");
        String model = scanner.next();
        System.out.print("Add meg a jármű ülőhelyei számát vezetővel:\n");
        Integer numberOfSeats = Integer.valueOf(scanner.next());
        System.out.print("Add meg a jármű kategóriáját:\n");
        String vehicleType = scanner.next();
        VehicleViewModel vehicleViewModel = new VehicleViewModel(model,registrationNumber,make,numberOfSeats,vehicleType);
        vehicleController.createVehicle(vehicleViewModel);
    }

    private void get(Scanner scanner){
        System.out.print("Add meg a jármű rendszámát:\n");
        String RegistrationNumber = scanner.next();
        vehicleController.getVehicle(RegistrationNumber);
    }

    private void stop(String action){
        if(action.equals("Stop")){
            running = false;
        }
    }


}
