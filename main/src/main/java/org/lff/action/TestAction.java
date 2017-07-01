package org.lff.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.lff.form.TestForm;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liuff on 2017/7/1 0:05
 */
public class TestAction extends DispatchAction {

    public TestAction() {
        System.out.println("==================");
    }
    public ActionForward test(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("TEst");
        TestForm f = (TestForm)form;
        f.setValue("This is from struts");
        return mapping.findForward("hello");
    }

    public ActionForward test1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }
}
