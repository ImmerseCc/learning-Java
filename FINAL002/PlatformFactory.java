package FINAL002;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlatformFactory {

    private static final Map<String, Platform> PLATFORMS = new LinkedHashMap<>();

    static {
        register(new DStationPlatform());
        register(new TiaoYinPlatform());
        register(new BlueBookPlatform());
        register(new SlowFootPlatform());
    }

    private static void register(Platform platform) {
        PLATFORMS.put(platform.getName(), platform);
    }

    public static Platform get(String name) {
        if (name == null) return null;
        return PLATFORMS.get(name.trim());
    }

    public static boolean isSupported(String name) {
        return get(name) != null;
    }

    public static Collection<Platform> all() {
        return PLATFORMS.values();
    }
}