package com.jyberion.mmorpg.client.networking;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NetworkClient {
    private final String host;
    private final int port;
    private Channel channel;

    public NetworkClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) {
                        ch.pipeline().addLast(new StringDecoder(), new StringEncoder(), new ClientHandler());
                    }
                });

            ChannelFuture f = b.connect(host, port).sync();
            channel = f.channel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean login(String username, String password) {
        // Implement login logic
        // For example, send login request to the server and await response
        // Return true if login is successful, otherwise false
        return true;
    }

    private class ClientHandler extends SimpleChannelInboundHandler<String> {
        @Override
        protected void channelRead0(ChannelHandlerContext ctx, String msg) {
            // Handle server responses here
        }
    }
}
