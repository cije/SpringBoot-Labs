package cn.ce.springboot.lab6.springwebsocket.handler;

import cn.ce.springboot.lab6.springwebsocket.message.SendResponse;
import cn.ce.springboot.lab6.springwebsocket.message.SendToAllRequest;
import cn.ce.springboot.lab6.springwebsocket.message.SendToUserRequest;
import cn.ce.springboot.lab6.springwebsocket.util.WebSocketUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

@Component
public class SendToAllHandler implements MessageHandler<SendToAllRequest> {

    @Override
    public void execute(WebSocketSession session, SendToAllRequest message) {
        // 这里，假装直接成功
        SendResponse sendResponse = new SendResponse().setMsgId(message.getMsgId()).setCode(0);
        WebSocketUtil.send(session, SendResponse.TYPE, sendResponse);

        // 创建转发的消息
        SendToUserRequest sendToUserRequest = new SendToUserRequest().setMsgId(message.getMsgId())
                .setContent(message.getContent());
        // 广播发送
        WebSocketUtil.broadcast(SendToUserRequest.TYPE, sendToUserRequest);
    }

    @Override
    public String getType() {
        return SendToAllRequest.TYPE;
    }

}
