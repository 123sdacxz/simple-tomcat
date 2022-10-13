package zyp;


import java.io.InputStream;

public class Request {
    private String head;
    private String method;
    private String url;
    private InputStream ips;

    public Request(InputStream inputStream) {
        ips = inputStream;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public InputStream getIps() {
        return ips;
    }

    public void setIps(InputStream ips) {
        this.ips = ips;
    }

    public void fRequest() throws Exception{

        String str = new String(ips.readAllBytes());
        String[] strs = str.split(" ");
        for (String s : strs) {
            System.out.println(s);
        }
        method = strs[0];
        int i = strs[1].indexOf("?");
        url = strs[1].substring(0,i);
    }

}
