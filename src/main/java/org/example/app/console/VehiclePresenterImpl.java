package org.example.app.console;

import org.example.app.console.parser.VehicleParser;
import org.example.app.interfaces.Presenter;
import org.example.app.console.viewModel.VehicleViewModel;
import org.example.app.console.validator.VehicleValidator2;

public class VehiclePresenterImpl implements Presenter {

    VehicleView view ;
    VehicleParser vehicleParser = new VehicleParser();
    VehicleValidator2 vehicleValidator = new VehicleValidator2();

    public VehiclePresenterImpl(VehicleView view) {
        this.view = view;
    }

    @Override
    public void DisplayVehicle(String v) {
       vehicleValidator.validateString(v);
       VehicleViewModel vehicleViewModel = vehicleParser.JsonToViewModel(v);
       view.DisplayVehicle(vehicleViewModel);
    }

    @Override
    public void DisplaySuccess() {
        view.simpleDisplay("Sikeres művelet");
    }

    @Override
    public void DisplayError() {
        view.simpleDisplay("Sikertelen művelet");

    }
}
