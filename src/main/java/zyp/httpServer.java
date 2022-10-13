package zyp;

public interface httpServer {
    void doget(Request request,Response response);
    void dopost(Request request,Response response);
}
