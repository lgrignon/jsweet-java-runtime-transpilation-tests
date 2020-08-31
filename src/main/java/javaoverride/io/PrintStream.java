/*
 * Copyright 2006 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package javaoverride.io;

import javaoverride.io.FilterOutputStream;
import javaoverride.io.IOException;
import javaoverride.io.OutputStream;

/**
 * @skip
 */
public class PrintStream extends FilterOutputStream {

  public PrintStream(OutputStream out) {
    super(out);
  }

  public void print(String s) {
    try {
      write(s.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void println(String s) {
    print(s + System.lineSeparator());
  }

  public void print(boolean x) {
    print(String.valueOf(x));
  }

  public void print(char x) {
    print(String.valueOf(x));
  }

  public void print(char[] x) {
    println(String.valueOf(x));
  }

  public void print(double x) {
    print(String.valueOf(x));
  }

  public void print(float x) {
    print(String.valueOf(x));
  }

  public void print(int x) {
    print(String.valueOf(x));
  }

  public void print(long x) {
    print(String.valueOf(x));
  }

  public void print(Object x) {
    print(String.valueOf(x));
  }

  public void println() {
    println("");
  }

  public void println(boolean x) {
    println(String.valueOf(x));
  }

  public void println(char x) {
    println(String.valueOf(x));
  }

  public void println(char[] x) {
    println(String.valueOf(x));
  }

  public void println(double x) {
    println(String.valueOf(x));
  }

  public void println(float x) {
    println(String.valueOf(x));
  }

  public void println(int x) {
    println(String.valueOf(x));
  }

  public void println(long x) {
    println(String.valueOf(x));
  }

  public void println(Object x) {
    println(String.valueOf(x));
  }
}
