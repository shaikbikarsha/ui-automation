package utils;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

public class PostResultsToInfluxDB {

    private static final InfluxDB INFLXUDB = InfluxDBFactory.connect("http://localhost:8086", "admin", "admin");
    private static final String DB_NAME = "Automation";

    static {
        INFLXUDB.setDatabase(DB_NAME);
    }

    public static void post(final Point point) {
        try {
            INFLXUDB.write(point);
        } catch (Exception e) {
            System.out.println("Unable to post the details to InfluxDB. Please look at the InfluxDB configuration.");
        }
    }
}