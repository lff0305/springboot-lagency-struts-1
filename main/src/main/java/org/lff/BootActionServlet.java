package org.lff;

import org.apache.struts.action.ActionServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Created by liuff on 2017/6/30 23:59
 */
@WebServlet(urlPatterns="*.do",loadOnStartup=1,
  initParams = {@WebInitParam( name="config", value="/WEB-INF/struts-config.xml") ,
                @WebInitParam( name="chainConfig", value="org/apache/struts/tiles/chain-config.xml")
              })
public class BootActionServlet extends ActionServlet {
    private static final long serialVersionUID = 4808896005283052578L;


}
