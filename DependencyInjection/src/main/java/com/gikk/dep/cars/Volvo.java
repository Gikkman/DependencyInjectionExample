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
package com.gikk.dep.cars;

import com.gikk.dep.Body;
import com.gikk.dep.Car;
import com.gikk.dep.Engine;

/**
 *
 * @author Gikkman
 */
public class Volvo implements Car{
    private final Engine engine;
    private final Body body;
    
    public Volvo(Engine engine, Body body){
        this.body = body;
        this.engine = engine;
    };

    @Override
    public void showoff() {
        body.showOff();
    }

    @Override
    public void drive() {
        engine.accelerate();
    }

    @Override
    public void overtake() {
        engine.turbo();
    } 
}
