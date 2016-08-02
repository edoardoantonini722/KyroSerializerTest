package com.magnews.kyroSerializerTest;

import java.util.Properties;
import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
public class App
{
	public static void main(String ... args) {
        CachingProvider provider = Caching.getCachingProvider();
        Properties properties = new Properties();
        try (CacheManager cacheManager = provider.getCacheManager(provider.getDefaultURI(), provider.getDefaultClassLoader(), properties)) {
            MutableConfiguration<String, String> cacheConfiguration = new MutableConfiguration<>();
            Cache<String, String> cache = cacheManager.createCache("example", cacheConfiguration);
            cache.put("foo", "bar");
            String result = cache.get("foo");
            System.out.println("result:" + result);
        }
    }
}
