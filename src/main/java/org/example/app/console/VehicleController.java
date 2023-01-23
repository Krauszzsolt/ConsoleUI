package org.example.app.console;

import org.example.app.console.parser.VehicleParser;
import org.example.app.console.viewModel.VehicleViewModel;
import org.example.app.interfaces.VehicleRegisterLoadAPI;
import org.example.app.interfaces.VehicleRegisterSaveAPI;
import org.example.app.console.validator.VehicleValidator2;

public class VehicleController {

    private VehicleRegisterSaveAPI vehicelRegisterSave;
    private VehicleRegisterLoadAPI vehicelRegisterLoad;
    private VehicleValidator2 vehicleValidator = new VehicleValidator2();
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

        vehicelRegisterLoad.loadVehicle(registrationnumber);
    }

    private void stop(String action){
        if(action.equals("Stop")){
            running = false;
        }
    }
}
