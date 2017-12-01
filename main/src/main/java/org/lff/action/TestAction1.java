package org.lff.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.lff.form.TestForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Feifei Liu
 * @datetime Aug 15 2017 11:01
 */
public class TestAction1 extends DispatchAction {

    private Logger logger = LoggerFactory.getLogger(TestAction1.class);

    public TestAction1() {
        logger.info("TestAction1 created.");
    }

    public @Nullable ActionForward test(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("In test {}", request.getAttribute("ZZZ"));
        logger.info("Request is {}", System.identityHashCode(request));
        return null;
    }
}
