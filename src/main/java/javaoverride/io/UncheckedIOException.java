/*
 * Copyright 2015 Google Inc.
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

import static javaemul.internal.InternalPreconditions.checkNotNull;

import javaoverride.io.IOException;

import javaoverride.lang.RuntimeException;

/**
 * See <a href=
 * "https://docs.oracle.com/javase/8/docs/api/java/io/UncheckedIOException.html">the
 * official Java API doc</a> for details.
 */
public class UncheckedIOException extends RuntimeException {
    public UncheckedIOException(String message, IOException cause) {
        super(message, checkNotNull(cause));
    }

    public UncheckedIOException(IOException cause) {
        super(checkNotNull(cause));
    }

    @Override
    public IOException getCause() {
        return (IOException) super.getCause();
    }
}
