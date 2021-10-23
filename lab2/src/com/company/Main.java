package com.company;

import dao.DAOFactory;
import entity.Appliance;

public class Main {

    public static void main(String[] args) {
        var dao = DAOFactory.getInstance();
        var kettles = dao.getApplianceDAO().getAll(Appliance.ApplianceType.Kettle);

        if (kettles != null) {
            for (var kettle : kettles) {
                System.out.printf("%s : \n", kettle.getTitle());
            }
        }


        var appliances = dao.getApplianceDAO().getAll(null);
        Appliance maxApp = null;

        if (appliances != null) {
            var maxPrice = -1;
            for (var appliance : appliances) {
                var price = appliance.getPrice();
                if (price > maxPrice) {
                    maxPrice = price;
                    maxApp = appliance;
                }
            }
            System.out.printf("%s %d  \n",maxApp.getTitle(),maxPrice);
        }


    }
}
