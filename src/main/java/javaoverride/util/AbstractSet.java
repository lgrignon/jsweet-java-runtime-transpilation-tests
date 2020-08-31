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
package javaoverride.util;

import static javaemul.internal.InternalPreconditions.checkNotNull;

import javaoverride.util.AbstractCollection;
import javaoverride.util.Collection;
import javaoverride.util.Collections;
import javaoverride.util.Iterator;
import javaoverride.util.Set;

/**
 * Skeletal implementation of the Set interface. <a
 * href="http://javaoverride.sun.com/j2se/1.5.0/docs/api/java/util/AbstractSet.html">[Sun
 * docs]</a>
 * 
 * @param <E> the element type.
 */
public abstract class AbstractSet<E> extends AbstractCollection<E> implements
    Set<E> {

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (!(o instanceof Set)) {
      return false;
    }

    Set<?> other = (Set<?>) o;
    if (other.size() != size()) {
      return false;
    }
    return containsAll(other);
  }

  @Override
  public int hashCode() {
    return Collections.hashCode(this);
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    checkNotNull(c);

    int size = size();
    if (size < c.size()) {
      // If the member of 'this' is in 'c', remove it from 'this'.
      //
      for (java.util.Iterator<E> iter = iterator(); iter.hasNext();) {
        E o = iter.next();
        if (c.contains(o)) {
          iter.remove();
        }
      }
    } else {
      // Remove every member of 'c' from 'this'.
      //
      for (Object o1 : c) {
        remove(o1);
      }
    }
    return (size != size());
  }

}
