package zyp;

import java.util.HashMap;
import java.util.List;

public class myServletContext {
    private HashMap<String,String> servlet;
    private HashMap<String,String> mapping;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, String> getServlet() {
        return servlet;
    }

    public void setServlet(HashMap<String, String> servlet) {
        this.servlet = servlet;
    }

    public HashMap<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(HashMap<String, String> mapping) {
        this.mapping = mapping;
    }

    public myServletContext(String url) {
        this.url = url;
        servlet = new HashMap<>();
        mapping = new HashMap<>();
        myDom myDom = new myDom();
        myDom.parseDocument(myDom.getDocument());
        List<myEntity> myEntityList = myDom.getMyEntityList();
        List<myMapping> myMappingList = myDom.getMyMappingList();
        for (myMapping myMapping : myMappingList) {
            if(myMapping.getUrl().contains(url)){
                mapping.put(url , myMapping.getName());
            }
        }
        for (myEntity entity : myEntityList) {
            if(entity.getName().equals(mapping.get(url))){
                servlet.put(entity.getName(), entity.getCla());
            }
        }

    }


}
