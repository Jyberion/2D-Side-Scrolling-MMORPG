package com.jyberion.mmorpg.client.networking;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import com.jyberion.mmorpg.client.ui.UIManager;

public class NetworkClient {
    private final String host;
    private final int port;
    private Channel channel;
    private EventLoopGroup group;

    public NetworkClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() {
        group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioSocketChannel.class)
             .option(ChannelOption.SO_KEEPALIVE, true)
             .handler(new ChannelInitializer<Channel>() {
                 @Override
                 protected void initChannel(Channel ch) throws Exception {
                     ch.pipeline().addLast(new StringDecoder(), new StringEncoder(), new NetworkClientHandler());
                 }
             });

            ChannelFuture f = b.connect(host, port).sync();
            channel = f.channel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        if (channel != null) {
            channel.close();
        }
        if (group != null) {
            group.shutdownGracefully();
        }
    }

    public void login(String username, String password) {
        String loginMessage = "LOGIN:" + username + ":" + password;
        channel.writeAndFlush(loginMessage);
    }

    private class NetworkClientHandler extends SimpleChannelInboundHandler<String> {
        @Override
        protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
            if (msg.equals("LOGIN_SUCCESS")) {
                // handle login success
            } else if (msg.equals("LOGIN_FAILED")) {
                // handle login failure
                System.out.println("Login failed");
                // Notify the UI of the failed login attempt
                uiManager.showLoginFailedMessage();
            }
        }
    }

    // Add a setter for UIManager
    private UIManager uiManager;

    public void setUiManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }
}
