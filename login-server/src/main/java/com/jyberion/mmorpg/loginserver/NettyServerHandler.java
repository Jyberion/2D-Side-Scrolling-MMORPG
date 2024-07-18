package com.jyberion.mmorpg.loginserver;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import com.jyberion.mmorpg.loginserver.service.UserService;

public class NettyServerHandler extends SimpleChannelInboundHandler<String> {

    private final UserService userService;

    public NettyServerHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // Handle incoming messages here
        // For example, authenticate user
        String[] credentials = msg.split(",");
        if (credentials.length == 2) {
            String username = credentials[0];
            String password = credentials[1];
            if (userService.authenticate(username, password) != null) {
                ctx.writeAndFlush("Authentication successful\n");
            } else {
                ctx.writeAndFlush("Authentication failed\n");
            }
        } else {
            ctx.writeAndFlush("Invalid message format\n");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
