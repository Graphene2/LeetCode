package Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import static java.nio.channels.SelectionKey.OP_ACCEPT;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-05
 * Time: 12:58
 */
public class NIOServer {

    private static Selector serverSelector;
//    private  Selector serverSelector = Selector.open();
    private  Selector clientSelector = Selector.open();

    public NIOServer() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        NIOServer server = new NIOServer();
        new Thread(()->{
            try {
                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                listenerChannel.socket().bind(new InetSocketAddress(3333));
                listenerChannel.configureBlocking(false);
                listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);
                server.acceptListener();
            }catch (IOException ignored){

            }
        }).start();
        new Thread(()->{
            try {
                server.clientListener();
            }catch (IOException ignored){
                
            }
        }).start();
    }

    private void clientListener() throws IOException {
        while (true){
            if (clientSelector.select(1) > 0){
                Set<SelectionKey> set = clientSelector.selectedKeys();
                Iterator<SelectionKey> keyIterator = set.iterator();
                while (keyIterator.hasNext()){
                    SelectionKey key = keyIterator.next();
                    if (key.isReadable()){
                        try {
                            SocketChannel clientChannel = (SocketChannel)key.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            clientChannel.read(byteBuffer);
                            byteBuffer.flip();
                            System.out.println(LocalTime.now().toString() + "server端接收到来自Client 端的消息："
                                    + Charset.defaultCharset().decode(byteBuffer).toString());
                        }finally {
                            keyIterator.remove();
                            key.interestOps(SelectionKey.OP_READ);
                        }
                        
                    }
                }
            }
        }
    }

    private void acceptListener() throws IOException {
        while (true){
            if (serverSelector.select(1) > 0){
                Set<SelectionKey> set = serverSelector.selectedKeys();
                Iterator<SelectionKey> keyIterator = set.iterator();
                while (keyIterator.hasNext()){
                    SelectionKey key = keyIterator.next();
                    if (key.isAcceptable()){
                        try {
                            SocketChannel clientChannel = ((ServerSocketChannel)key.channel()).accept();
                            clientChannel.configureBlocking(false);
                            clientChannel.register(clientSelector,SelectionKey.OP_READ);
                        }finally {
                            keyIterator.remove();
                        }
                    }
                }
            }
        }
    }


}
