/*
 * $RCSfile: DefaultSourceFactory.java,v $$
 * $Revision: 1.1 $
 * $Date: 2013-11-04 $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 */
package com.skin.ayada.source;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.skin.ayada.util.IO;
import com.skin.ayada.util.Path;

/**
 * <p>Title: DefaultSourceFactory</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @version 1.0
 */
public class DefaultSourceFactory extends SourceFactory {
    /**
     * @param args
     */
    public static void main(String[] args) {
        DefaultSourceFactory sourceFactory = new DefaultSourceFactory();
        sourceFactory.setHome("D:\\workspace2/ayada\\webapp");
        sourceFactory.getFile("\\outTest.jsp");
    }

    /**
     *
     */
    public DefaultSourceFactory() {
    }

    /**
     * @param home
     */
    public DefaultSourceFactory(String home) {
        super();
        File file = null;

        if(home == null) {
            file = new File(".");
        }
        else {
            file = new File(home);
        }

        try {
            this.setHome(this.getStrictPath(file.getCanonicalPath()));
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param path
     * @param charset
     * @return Source
     */
    @Override
    public Source getSource(String path, String charset) {
        File file = this.getFile(path);

        try {
            String content = IO.read(file, charset);
            Source source = new Source(this.getHome(), path, content, this.getSourceType(file.getName()));
            source.setLastModified(file.lastModified());
            return source;
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param path
     * @return URL
     */
    @Override
    public URL getResource(String path) {
        try {
            File file = this.getFile(path);

            if(file != null) {
                return file.toURI().toURL();
            }
        }
        catch (MalformedURLException e) {
        }
        return null;
    }

    /**
     * @param path
     * @return InputStream
     */
    @Override
    public InputStream getInputStream(String path) {
        try {
            File file = this.getFile(path);

            if(file != null) {
                return new FileInputStream(file);
            }
        }
        catch(IOException e) {
        }
        return null;
        
    }

    /**
     * @param path
     * @return long
     */
    @Override
    public long getLastModified(String path) {
        return this.getFile(path).lastModified();
    }

    /**
     * @param path
     * @return boolean
     */
    @Override
    public boolean exists(String path) {
        File file = null;

        try {
            file = this.getFile(path);
        }
        catch(Exception e) {
        }
        return (file != null);
    }

    /**
     * @param path
     * @return File
     */
    public File getFile(String path) {
        if(path == null) {
            throw new NullPointerException("path must be not null !");
        }

        if(!Path.contains(this.getHome(), path)) {
            throw new RuntimeException("home: " + this.getHome() + ", file: " + path + " not exists !");
        }

        String full = Path.join(this.getHome(), path);
        File file = new File(full);

        if(!file.exists() || !file.isFile()) {
            throw new RuntimeException("home: " + this.getHome() + ", file: " + file.getAbsolutePath() + " not exists !");
        }
        return file;
    }
}
