package com.ce.lab601.handler;

import com.ce.lab601.message.AuthRequest;
import com.ce.lab601.message.AuthResponse;
import com.ce.lab601.message.UserJoinNoticeRequest;
import com.ce.lab601.util.WebSocketUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.websocket.Session;

/**
 * @author c__e
 * @date Created in 2020/9/26 9:46
 */
@Component
public class AuthMessageHandler implements MessageHandler<AuthRequest> {
    @Override
    public void execute(Session session, AuthRequest message) {
        //如果未传递accessToken
        if (StringUtils.isEmpty(message.getAccessToken())) {
            WebSocketUtil.send(session, AuthResponse.TYPE,
                    new AuthResponse().setCode(1).setMessage("认证 accessToken 未传入"));
            return;
        }

        // 添加到WebSocketUtil中
        WebSocketUtil.addSession(session, message.getAccessToken());

        // 判断是否认证成功，这里假装成功
        WebSocketUtil.send(session, AuthResponse.TYPE, new AuthResponse().setCode(0));

        // 通知所有人，某个人加入了。（可选逻辑，仅演示）
        WebSocketUtil.broadcast(UserJoinNoticeRequest.TYPE, new UserJoinNoticeRequest().setNickname(message.getAccessToken()));
    }

    @Override
    public String getType() {
        return AuthRequest.getTYPE();
    }
}
