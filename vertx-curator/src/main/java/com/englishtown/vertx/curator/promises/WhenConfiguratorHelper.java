package com.englishtown.vertx.curator.promises;

import com.englishtown.promises.Promise;
import com.englishtown.vertx.curator.ConfigElement;
import com.englishtown.vertx.curator.MatchBehavior;
import org.apache.curator.framework.api.CuratorWatcher;

import java.util.List;

/**
 * Promises version of {@link com.englishtown.vertx.curator.ConfiguratorHelper}
 */
public interface WhenConfiguratorHelper {

    Promise<ConfigElement> getConfigElement(String path);

    Promise<ConfigElement> getConfigElement(String path, MatchBehavior matchBehavior);

    Promise<ConfigElement> getConfigElement(String path, CuratorWatcher watcher);

    Promise<ConfigElement> getConfigElement(String path, CuratorWatcher watcher, MatchBehavior matchBehavior);

    WhenConfiguratorHelper usingNamespace(String namespace);

    List<String> getPathSuffixes();

}
