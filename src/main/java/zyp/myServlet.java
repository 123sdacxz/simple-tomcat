package zyp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class myServlet {
    public static void main(String[] args) throws Exception {
         ServerSocket serverSocket = new ServerSocket(8888);
         while (true) {
             Socket accept = serverSocket.accept();
             Request request = new Request(accept.getInputStream());
             request.fRequest();
             PrintWriter p = new PrintWriter(accept.getOutputStream(),true);
             Response response = new Response(p);
             myown myown = new myown();
             myown.start(request.getUrl()).doget(request,response);
             p.close();
         }

    }
}
