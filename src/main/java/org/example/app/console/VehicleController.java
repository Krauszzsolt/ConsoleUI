package org.example.app.console;

import org.example.app.console.parser.VehicleParser;
import org.example.app.console.viewModel.VehicleViewModel;
import org.example.app.interfaces.VehicleRegisterLoadAPI;
import org.example.app.interfaces.VehicleRegisterSaveAPI;
import org.example.app.console.validator.vehicleValidator;

public class VehicleController {

    private VehicleRegisterSaveAPI vehicelRegisterSave;
    private VehicleRegisterLoadAPI vehicelRegisterLoad;
    private org.example.app.console.validator.vehicleValidator vehicleValidator = new vehicleValidator();
    private VehicleParser vehicleParser = new VehicleParser();

    boolean running = true;

    public VehicleController(VehicleRegisterSaveAPI iVehicelRegister, VehicleRegisterLoadAPI vehicelRegisterLoad) {
        this.vehicelRegisterSave = iVehicelRegister;
        this.vehicelRegisterLoad = vehicelRegisterLoad;
    }

    public void createVehicle(VehicleViewModel vehicleViewModel){
        vehicleValidator.validateViewModel(vehicleViewModel);
        vehicelRegisterSave.saveVehicle(vehicleParser.ViewModelToJson(vehicleViewModel));
    }

    public void getVehicle(String registrationnumber){
        vehicleValidator.validateString(registrationnumber);
        vehicelRegisterLoad.loadVehicle(vehicleParser.RegistrationNumberToJson(registrationnumber));
    }

}
