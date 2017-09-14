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
package com.gikk.dep;

import com.gikk.dep.cars.Fiat;
import com.gikk.dep.cars.Jaguar;
import com.gikk.dep.cars.Volvo;
import com.gikk.dep.parts.bodies.NormalBody;
import com.gikk.dep.parts.engines.SedanEngine;
import com.gikk.dep.parts.engines.SportEngine;
import com.gikk.dep.parts.engines.turbo.Mk1Turbo;
import com.github.pyknic.stiletto.Injector;
import java.io.IOException;

/**
 *
 * @author Gikkman
 */
public class Main {
    public static void main(String ... args){
        Car fiat = new Fiat();
        testDrive(fiat);
        
        Engine engine = new SedanEngine( new Mk1Turbo());
        Body body = new NormalBody();
        Car volvo = new Volvo(engine, body);
        testDrive(volvo);
        
        Injector factory = Injector.builder()
                                   .fromProviders("com.gikk.dep.parts")
                                   .build();
        Car jaguar = factory.create(Jaguar.class);
        testDrive(jaguar);
        
        System.out.println("----------------------------------------");
        System.out.println("------- TESTER SHOWCASE -----------");
        System.out.println("----------------------------------------");
        engineShowcase();       
    }

    private static void testDrive(Car car) {
        System.out.println("-----");
        
        System.out.println("Checking for show-off potential:");
        car.showoff();
        awaitKeystroke();
        
        System.out.println("Taking her for a test drive:");
        car.drive();
        awaitKeystroke();
        
        System.out.println("Testing out an aggresive overtake!");
        car.overtake();
        System.out.println("-----\n");
        
        awaitKeystroke();
    }

    private static void awaitKeystroke() {
        try {
            System.in.read();
        } catch (IOException ex) {
            //Ignore
        }
    }

    private static void engineShowcase() {
        Injector normalInjector = Injector.builder()
                                            .fromProviders("com.gikk.dep.parts")
                                            .build();
        Engine normalSport = normalInjector.create(SportEngine.class);
        System.out.println("Normal accelerate:");
        normalSport.accelerate();
        System.out.println("Normal turbo:");
        normalSport.turbo();
        
        awaitKeystroke();
        System.out.println("*************************");
        
        Injector testInjector = Injector.builder()
                                            .fromProviders("com.gikk.dep.test")
                                            .build();
        Engine testSport = testInjector.create(SportEngine.class);
        System.out.println("Test accelerate:");
        testSport.accelerate();
        System.out.println("Test turbo:");
        testSport.turbo();
    }
}
