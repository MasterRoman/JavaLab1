package com.application.controller.command.implementation;

import com.application.controller.command.Command;
import com.application.controller.command.PagePath;
import com.application.controller.command.rout.Rout;
import com.application.controller.command.rout.RoutingType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAddHotel implements Command {
    @Override
    public Rout execute(HttpServletRequest request, HttpServletResponse response) {
        return new Rout(PagePath.SHOW_ADD_HOTEL, RoutingType.FORWARD);
    }
}
