package March;

import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-02
 * Time: 15:10
 */
public class StudyDayDay {
    @Test
    public  void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        try{
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            outputStream = socket.getOutputStream();
            outputStream.write("I am client".getBytes());
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        try{
            serverSocket = new ServerSocket(9090);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[20];
            int len;
            while ((len = inputStream.read(bytes)) != -1){
                String str = new String(bytes,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                socket.close();
                serverSocket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}


