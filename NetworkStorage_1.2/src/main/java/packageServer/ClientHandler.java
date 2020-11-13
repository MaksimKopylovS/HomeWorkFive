package packageServer;

import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import packageMessage.FileMessage;
import packageMessage.MyMessage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    private ArrayList<ChannelHandler> listClientHandler;
    private String clientName;
    private int newClientIndex = 1;

    public String getClientName(){
        return clientName;
    }

    public void setClientName(String clientName){
        this.clientName = clientName;
    }

    public ClientHandler(){
        listClientHandler = new ArrayList<>();
        clientName = "user";
    }





    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Клиент " +newClientIndex+" " + ctx + " подключился");
        clientName = "Клиента # " + newClientIndex;
        newClientIndex++;
    }
    //0xc2dac13e
//0xdb032a7a

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        new MessageHandler(ctx, msg, this);
            }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                cause.printStackTrace();
                ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("Client "+clientName+" disconnected");
        deleteChannel(ctx);
        listClientHandler.remove(this);
    }

    public synchronized void saveChannel(ChannelHandlerContext ctx){
        listClientHandler.add(this);
    }

    public synchronized void deleteChannel(ChannelHandlerContext ctx){
        listClientHandler.remove(this);
    }

}
