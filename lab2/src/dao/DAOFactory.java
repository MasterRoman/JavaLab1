package dao;

import service.Parser;
import service.XMLParser;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ApplianceDAO applianceDAO = new ApplianceDAO(new XMLParser("Appliance.xml"));

    private DAOFactory() {}

    public ApplianceDAO getApplianceDAO() {
        return applianceDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
