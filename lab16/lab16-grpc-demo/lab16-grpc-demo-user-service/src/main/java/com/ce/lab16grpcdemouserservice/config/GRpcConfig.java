package com.ce.lab16grpcdemouserservice.config;

import com.ce.lab16grpcdemouserservice.rpc.UserServiceGrpcImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author cuijie
 * @date 2021/12/22 16:33
 */
@Slf4j
@Configuration
public class GRpcConfig {

    /**
     * gRPC Server 端口
     */
    private static final Integer GRPC_PORT = 8888;

    @Bean
    public Server grpcServer(final UserServiceGrpcImpl userServiceGrpc) throws IOException {
        // 创建 gRPC Server 对象
        Server server = ServerBuilder.forPort(GRPC_PORT)
                .addService(userServiceGrpc)
                .build();
        // 启动 gRPC Server
        server.start();
        log.info("[grpcServer][启动完成，端口为({})]", server.getPort());
        return server;
    }
}
