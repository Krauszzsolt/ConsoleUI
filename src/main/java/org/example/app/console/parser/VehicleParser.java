package org.example.app.console.parser;

import org.example.app.console.viewModel.VehicleViewModel;
import org.json.JSONException;
import org.json.JSONObject;

public class VehicleParser {

    public String ViewModelToJson(VehicleViewModel v) {
        JSONObject vehicle = new JSONObject();
        try {
            vehicle.put("model", v.model);
            vehicle.put("registrationNumber", v.registrationNumber);
            vehicle.put("make", v.make);
            vehicle.put("numberOfSeats", v.numberOfSeats);
            vehicle.put("vehicleType",v.vehicleType);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return vehicle.toString();
    }

    public VehicleViewModel JsonToViewModel(String v) {
        JSONObject vehicle;
        String model;
        String registrationNumber;
        String make;
        Integer numberOfSeats;
        String vehicleType;
        try {
            vehicle = new JSONObject(v);
            model = vehicle.getString("model");
            registrationNumber = vehicle.getString("registrationNumber");
            make = vehicle.getString("make");
            numberOfSeats = vehicle.getInt("numberOfSeats");
            vehicleType = vehicle.getString("vehicleType");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return new VehicleViewModel(model, registrationNumber, make, numberOfSeats, vehicleType);
    }

    public String RegistrationNumberToJson(String r) {
        JSONObject registrationNumber = new JSONObject();
        try {
            registrationNumber.put("registrationNumber", r);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return registrationNumber.toString();
    }

    public String JsonToRegistrationNumber(String r) {
        JSONObject registrationNumber;
        try {
            registrationNumber = new JSONObject(r);
            return registrationNumber.getString("registrationNumber");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
