package zyp;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class myown {

    private myServletContext m;

    public myhttpServlet start(String url) throws Exception {
        this.m = new myServletContext(url);
        String own = m.getServlet().get(m.getMapping().get(url));
        Class c = Class.forName(own);
        myhttpServlet my = (myhttpServlet) c.getConstructor().newInstance();
        return my;
    }
}
