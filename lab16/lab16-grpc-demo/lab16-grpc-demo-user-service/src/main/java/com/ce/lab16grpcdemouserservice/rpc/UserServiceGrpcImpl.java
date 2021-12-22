package com.ce.lab16grpcdemouserservice.rpc;

import com.ce.lab64.userservice.api.*;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

/**
 * @author cuijie
 * @date 2021/12/22 16:29
 */
@Service
public class UserServiceGrpcImpl extends UserServiceGrpc.UserServiceImplBase {
    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void get(UserGetRequest request, StreamObserver<UserGetResponse> responseObserver) {
        // 创建响应对象
        UserGetResponse.Builder builder = UserGetResponse.newBuilder();
        builder.setId(request.getId())
                .setName("没有昵称：" + request.getId())
                .setGender(request.getId() % 2 + 1);
        // 返回响应
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void create(UserCreateRequest request, StreamObserver<UserCreateResponse> responseObserver) {
        // 创建响应对象
        UserCreateResponse.Builder builder = UserCreateResponse.newBuilder();
        builder.setId((int) (System.currentTimeMillis() / 1000));
        // 返回响应
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
