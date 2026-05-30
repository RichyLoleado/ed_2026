package registros.sensores;

public class LecturaSensor {
    private String idSensor;
    private double temperatura;

    public LecturaSensor(String idSensor, double temperatura) {
        this.idSensor = idSensor;
        this.temperatura = temperatura;
    }

    public String getIdSensor() {
        return idSensor;
    }
    public double getTemperatura() {
        return temperatura;
    }

}
