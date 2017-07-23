package org.lff.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.lff.form.TestForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liuff on 2017/7/1 0:05
 */
public class TestAction extends DispatchAction {

    private Logger logger = LoggerFactory.getLogger(TestAction.class);

    public TestAction() {
        logger.info("TestAction created.");
    }

    public ActionForward test(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("TestAction.test called");
        logger.info("SessionId = {} {}", request.getSession().getId(), request.getSession().isNew());
        request.getSession().invalidate();
        logger.info("SessionId = {} {}", request.getSession().getId(), request.getSession().isNew());
        TestForm f = (TestForm) form;
        f.setValue("This is from struts");

        Cookie[] cookies = request.getCookies() == null ? new Cookie[0] : request.getCookies();
        for (Cookie c : cookies) {
            logger.info(c.getName() + " " + c.getPath() + " " + c.getSecure());
        }

        return mapping.findForward("hello");
    }

    public ActionForward test1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward("tiles");
    }
}
