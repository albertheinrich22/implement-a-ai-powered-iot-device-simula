import java.util.*;

public class IoTDeviceSimulator {

    // Define IoT device properties
    private String deviceId;
    private String deviceType;
    private double temperature;
    private double humidity;
    private double pressure;

    // Define AI model
    private AIModel aiModel;

    // Constructor
    public IoTDeviceSimulator(String deviceId, String deviceType) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.temperature = 20.0;
        this.humidity = 50.0;
        this.pressure = 1013.25;
        this.aiModel = new AIModel();
    }

    // Simulate IoT device data
    public void simulateData() {
        // Generate random data
        this.temperature += Math.random() * 2 - 1;
        this.humidity += Math.random() * 5 - 2.5;
        this.pressure += Math.random() * 10 - 5;

        // Process data with AI model
        String prediction = this.aiModel.predict(this.temperature, this.humidity, this.pressure);

        // Print simulation results
        System.out.println("Device ID: " + this.deviceId);
        System.out.println("Device Type: " + this.deviceType);
        System.out.println("Temperature: " + this.temperature + "°C");
        System.out.println("Humidity: " + this.humidity + "%");
        System.out.println("Pressure: " + this.pressure + "hPa");
        System.out.println("Prediction: " + prediction);
        System.out.println();
    }

    // AI model class
    private class AIModel {
        public String predict(double temperature, double humidity, double pressure) {
            // Implement AI model logic here
            // For demonstration purposes, a simple threshold-based prediction is used
            if (temperature > 25) {
                return "High temperature detected";
            } else if (humidity > 60) {
                return "High humidity detected";
            } else if (pressure < 1000) {
                return "Low pressure detected";
            } else {
                return "Normal conditions";
            }
        }
    }

    public static void main(String[] args) {
        IoTDeviceSimulator simulator = new IoTDeviceSimulator("Device-001", "Weather Station");
        for (int i = 0; i < 10; i++) {
            simulator.simulateData();
        }
    }
}