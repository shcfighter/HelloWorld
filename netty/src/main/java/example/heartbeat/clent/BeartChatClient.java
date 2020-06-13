package example.heartbeat.clent;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class BeartChatClient {
	public static void main(String[] args) throws Exception{
	        new BeartChatClient("localhost", 8080).run();
	    }
	
	    private final String host;
	    private final int port;
	
	    public BeartChatClient(String host, int port){
	        this.host = host;
	        this.port = port;
	    }
	
	    public void run() throws Exception{
	        EventLoopGroup group = new NioEventLoopGroup();
	        try {
	            Bootstrap bootstrap  = new Bootstrap()
	                    .group(group)
	                    .channel(NioSocketChannel.class)
	                    .handler(new HeartBeatClientInitializer());
	            Channel channel = bootstrap.connect(host, port).sync().channel();
	            /*BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	            while(true){
	                channel.writeAndFlush(in.readLine() + "\r\n");
	            }*/
				channel.closeFuture().sync();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            group.shutdownGracefully();
	        }
	
	    }
    }
