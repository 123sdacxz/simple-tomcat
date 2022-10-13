package zyp;

import java.io.PrintWriter;

public class Response {
    private String encoding;
    private String head;
    private PrintWriter p;

    public Response(PrintWriter printWriter) {
        p = printWriter;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public PrintWriter getP() {
        return p;
    }

    public void setP(PrintWriter p) {
        this.p = p;
    }

    public void responseEnd(int code){
       head = "HTTP/1.1 "+code;
       p.println(head);
       encoding = "Content-Type：text/html";
       p.println(encoding);
       p.flush();
       p.close();
    }
}
