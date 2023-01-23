package org.example.app.console.validator;

import org.example.app.console.viewModel.VehicleViewModel;
import org.example.app.exceptions.VehicelNotValidException;

public class VehicleValidator2 {
    public void validateString(String v) {
        if (v == null) {
            throw new VehicelNotValidException("Hiba");
        }
    }

    public void validateViewModel(VehicleViewModel v) {
        if (v == null) {
            throw new VehicelNotValidException("Hiba");
        }
    }

}
