package dao;

import entity.Appliance;
import service.Parser;

import java.util.ArrayList;
import java.util.List;

public class ApplianceDAO {

    private Parser parser;

    public ApplianceDAO(Parser parser) {
        this.parser = parser;
    }

    public List<Appliance> getAll(Appliance.ApplianceType type) {
        var appliances = parser.getAll();

        if (appliances == null) {
            return null;
        }

        List<Appliance> appToFind = new ArrayList<Appliance>();

        if (type == null) { return appliances; }

        for (var appliance:appliances) {
            if (appliance.getType() == type) {
                appToFind.add(appliance);
            }
        }

        return appToFind;
    }
}
