package org.lff;

import org.apache.struts.action.ActionServlet;

import javax.servlet.annotation.WebServlet;

/**
 * Created by liuff on 2017/6/30 23:59
 */
@WebServlet(urlPatterns="*.do",loadOnStartup=1)
public class BootActionServlet extends ActionServlet {
}
