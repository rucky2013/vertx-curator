package com.englishtown.vertx.curator.builders.impl;

import com.englishtown.vertx.curator.CuratorClient;
import com.englishtown.vertx.curator.CuratorOperation;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.api.ExistsBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultExistsBuilderTest {

    @Mock
    CuratorClient client;

    @Mock
    CuratorFramework framework;

    @Mock
    ExistsBuilder builder;

    @Mock
    CuratorWatcher watcher;

    String path = "/test/path";

    @Mock
    Handler<AsyncResult<CuratorEvent>> handler;

    @Test
    public void testBuild() throws Exception{

        DefaultExistsBuilder target = new DefaultExistsBuilder();

        CuratorOperation operation = target.forPath(path)
                .usingWatcher(watcher)
                .build();

        when(client.getCuratorFramework()).thenReturn(framework);
        when(framework.checkExists()).thenReturn(builder);
        when(builder.inBackground(any(BackgroundCallback.class))).thenReturn(builder);

        operation.execute(client, handler);

        verify(builder).inBackground(any(BackgroundCallback.class));
        verify(builder).usingWatcher(any(CuratorWatcher.class));
        verify(builder).forPath(path);
    }
}
