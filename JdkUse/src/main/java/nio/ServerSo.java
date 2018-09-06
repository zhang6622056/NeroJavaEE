package nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 多路复用
 * Created by Nero on 2018-08-09.
 */
public class ServerSo {


    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        Selector selector = Selector.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_CONNECT);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);




        while(true){
            int readyChannels = selector.select();
            if(readyChannels == 0) continue;
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyInterator = selectedKeys.iterator();

            while(keyInterator.hasNext()){
                SelectionKey selectionKey = keyInterator.next();
                if(selectionKey.isAcceptable()){
                    System.out.println("accept....");
                }
                if(selectionKey.isConnectable()){
                    System.out.println("connection....");
                }
                if(selectionKey.isValid()){
                    System.out.println("valid....");
                }
                if(selectionKey.isWritable()){
                    System.out.println("write....");
                }
            }
        }
    }














}
