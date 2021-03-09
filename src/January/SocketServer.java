package January;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-23
 * Time: 17:19
 */
public class SocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8888);
            System.out.println("服务已经启动！");

            Socket socket = server.accept();

            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine()) != null){
                System.out.println(info);
            }

            // 向客户端写程序。
            OutputStream os = socket.getOutputStream();
            String str = "欢迎登陆到server服务器！";
            os.write(str.getBytes());
            

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
