package org.lff.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebServlet(value = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    private static final long serialVersionUID = -8785115802610210660L;
    private ExecutorService managedExecutorService = Executors.newCachedThreadPool();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        long start_tstamp = System.currentTimeMillis();
        System.out.println("async servlet request received by thread-"+Thread.currentThread().getId());

        executeAsynchronously(req.startAsync(), start_tstamp);

        long end_tstamp = System.currentTimeMillis();
        System.out.println("servlet execution took ["+(end_tstamp-start_tstamp)+"]ms");
    }

    private void executeAsynchronously(AsyncContext asyncContext, long start_tstamp) {
        managedExecutorService.submit(() -> {
            try {
                Thread.sleep(5000);
                asyncContext.getResponse().getWriter().write("Async response!");
                long now = System.currentTimeMillis();
                System.out.println("async servlet request processed by thread-"+Thread.currentThread().getId()+" in ["+(now-start_tstamp)+"]ms");
                asyncContext.getResponse().getWriter().write("After Async");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                asyncContext.complete();
            }
        });
    }

}