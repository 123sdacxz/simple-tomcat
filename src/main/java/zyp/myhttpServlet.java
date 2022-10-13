package zyp;

public  class myhttpServlet implements httpServer{
    @Override
    public void doget(Request request, Response response) {
        response.responseEnd(200);
        System.out.println(request.getUrl()+"=="+request.getMethod()+"==");
        System.out.println(response.getHead()+"=="+response.getEncoding());
    }

    @Override
    public void dopost(Request request, Response response) {
        this.doget(request,response);
    }

}
