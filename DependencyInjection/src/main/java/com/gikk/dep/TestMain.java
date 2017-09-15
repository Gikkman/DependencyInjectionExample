/*
 * The MIT License
 *
 * Copyright 2017 sjonasson.
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
package com.gikk.dep;

import com.gikk.dep.parts.engines.SportEngine;
import com.github.pyknic.stiletto.Injector;
import java.io.IOException;

/**
 *
 * @author Gikkman
 */
public class TestMain {
    
    private static Injector injector = Injector.builder()
                               .fromProviders("com.gikk.dep.parts")
                               .build();
    private static Injector mockInjector = Injector.builder()
                               .fromProviders("com.gikk.dep.test")
                               .build();
    
    public static void main(String ... args){
        engineShowcase();
    }
    
    private static void engineShowcase() {
        System.out.println("************************************************");
        System.out.println("************************************************");
        
        Engine sport = injector.create(SportEngine.class);
        sport.accelerate();
        System.out.println("And the turbo:");
        sport.turbo();
        
        awaitKeystroke();
        System.out.println("************************************************");
        Engine test = mockInjector.create(SportEngine.class);
        test.accelerate();
        System.out.println("And the turbo:");
        test.turbo();
        
        System.out.println("************************************************");
        System.out.println("************************************************");
    }
        
    private static void awaitKeystroke() {
        try {
            System.in.read();
        } catch (IOException ex) {
            //Ignore
        }
    }
}
