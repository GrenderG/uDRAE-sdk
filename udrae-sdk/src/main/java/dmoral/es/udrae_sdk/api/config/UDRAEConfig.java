package dmoral.es.udrae_sdk.api.config;

/**
 * This file is part of uDRAE-SDK.
 * <p>
 * uDRAE-SDK is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * <p>
 * uDRAE-SDK is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with uDRAE-SDK.  If not, see <http://www.gnu.org/licenses/>.
 */

public class UDRAEConfig {
    private int cacheDuration;
    private int offlineCacheDuration;
    private int cacheSize;
    private int connectTimeout;
    private String cacheFolderName;

    private UDRAEConfig() {
    }

    private UDRAEConfig(int cacheDuration, int offlineCacheDuration, int cacheSize,
                        int connectTimeout, String cacheFolderName) {
        this.cacheDuration = cacheDuration;
        this.offlineCacheDuration = offlineCacheDuration;
        this.cacheSize = cacheSize;
        this.connectTimeout = connectTimeout;
        this.cacheFolderName = cacheFolderName;
    }

    public static UDRAEConfig getDefaultUDRAEConfig() {
        return new UDRAEConfig.Builder().apply();
    }

    public int getCacheDuration() {
        return cacheDuration;
    }

    public void setCacheDuration(int cacheDuration) {
        this.cacheDuration = cacheDuration;
    }

    public int getOfflineCacheDuration() {
        return offlineCacheDuration;
    }

    public void setOfflineCacheDuration(int offlineCacheDuration) {
        this.offlineCacheDuration = offlineCacheDuration;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public String getCacheFolderName() {
        return cacheFolderName;
    }

    public void setCacheFolderName(String cacheFolderName) {
        this.cacheFolderName = cacheFolderName;
    }

    static class Builder {
        private int cacheDuration = 30; // 30 days
        private int offlineCacheDuration = 180; // 180 days
        private int cacheSize = 10_485_760; // 10 MiB
        private int connectTimeout = 15; // 15 seconds
        private String cacheFolderName = "udrae-cache";

        public Builder setCacheDuration(int cacheDuration) {
            this.cacheDuration = cacheDuration;
            return this;
        }

        public Builder setOfflineCacheDuration(int offlineCacheDuration) {
            this.offlineCacheDuration = offlineCacheDuration;
            return this;
        }

        public Builder setCacheSize(int cacheSize) {
            this.cacheSize = cacheSize;
            return this;
        }

        public Builder setConnectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public Builder setCacheFolderName(String cacheFolderName) {
            this.cacheFolderName = cacheFolderName;
            return this;
        }

        public UDRAEConfig apply() {
            return new UDRAEConfig(cacheDuration, offlineCacheDuration, cacheSize,
                    connectTimeout, cacheFolderName);
        }
    }
}
