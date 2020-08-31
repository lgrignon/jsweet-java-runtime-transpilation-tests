/*
 * Copyright 2007 Google Inc.
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
package javaoverride.lang;

import static javaemul.internal.InternalPreconditions.checkNotNull;

import java.util.function.Consumer;

import javaemul.internal.IterableHelper;
import javaoverride.util.Iterator;

/**
 * Allows an instance of a class implementing this interface to be used in the
 * foreach statement.
 * See <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html">
 * the official Java API doc</a> for details.
 *
 * @param <T> type of returned iterator
 */
public interface Iterable<T> extends java.lang.Iterable<T> {
  java.util.Iterator<T> iterator();

  default void forEach(Consumer<? super T> action) {
    checkNotNull(action);
    for (T t : IterableHelper.castToLang(this)) {
      action.accept(t);
    }
  }
}
