/*
 * The MIT License
 *
 * Copyright 2017 Gikkman.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.gikk.dep.parts.engines.turbo;

import com.github.pyknic.stiletto.Provider;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Gikkman
 */
@Provider
class Mk2RemoteTurbo implements Turbo{
    
    private String desc;
    
    public Mk2RemoteTurbo(){
        try {
            this.desc = getHTML("https://pastebin.com/raw/313RWktb");
        } catch (Exception ex) {
            this.desc = null;
        }
    }
    
    @Override
    public String accelerate(){
        return desc;
    }

    @Override
    public boolean isOnline() {
        return desc != null && !desc.isEmpty();
    }   
    
    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (InputStream is = conn.getInputStream();
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader rd = new BufferedReader(isr)
            ) {
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line).append(System.lineSeparator());
            } 
        }
      return result.toString();
   }
}
