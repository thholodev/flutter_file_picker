package com.flutter.plugin.filepicker;

import android.net.Uri;

import java.util.HashMap;

public class FileInfo {

    final String path;
    final String name;
    final String metadata;
    final Uri uri;
    final long size;
    final byte[] bytes;

    public FileInfo(String path, String name,  Uri uri, String metadata, long size, byte[] bytes) {
        this.path = path;
        this.name = name;
        this.size = size;
        this.bytes = bytes;
        this.uri = uri;
        this.metadata = metadata;
    }

    public static class Builder {

        private String path;
        private String name;

        private String metadata;
        private Uri uri;
        private long size;
        private byte[] bytes;

        public Builder withPath(String path){
            this.path = path;
            return this;
        }

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withSize(long size){
            this.size = size;
            return this;
        }

        public Builder withData(byte[] bytes){
            this.bytes = bytes;
            return this;
        }

        public Builder withUri(Uri uri){
            this.uri = uri;
            return this;
        }

        public Builder withMetadata(String metadata){
            this.metadata = metadata;
            return this;
        }

        public FileInfo build() {
            return new FileInfo(this.path, this.name, this.uri, this.metadata, this.size, this.bytes);
        }
    }


    public HashMap<String, Object> toMap() {
        final HashMap<String, Object> data = new HashMap<>();
        data.put("path", path);
        data.put("name", name);
        data.put("metadata", metadata);
        data.put("size", size);
        data.put("bytes", bytes);
        data.put("identifier", uri.toString());
        return data;
    }
}
