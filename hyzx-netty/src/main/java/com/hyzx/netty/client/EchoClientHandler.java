package com.hyzx.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * 1. @Sharable 标记这个类的实例可以在 channel 里共享
 * 2.当被通知该 channel 是活动的时候就发送信息
 * 3.记录接收到的消息
 * 4.记录日志错误并关闭 channel
 *
 * @author huyue
 * @date 2019/9/18 17:10
 */
public class EchoClientHandler extends
        SimpleChannelInboundHandler<ByteBuf> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", //2
                CharsetUtil.UTF_8));
    }
//    @Override
    public void channelRead0(ChannelHandlerContext ctx,
                             ByteBuf in) {
        System.out.println("Client received: " + in.toString(CharsetUtil.UTF_8)); //3
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) { //4
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        System.out.println("Client received: " + byteBuf.toString(CharsetUtil.UTF_8)); //3
    }
}
