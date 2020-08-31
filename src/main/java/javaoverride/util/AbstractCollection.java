/*
 * Copyright 2008 Google Inc.
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

import javaoverride.util.Collection;
import javaoverride.util.Iterator;
import javaoverride.util.Objects;
import javaoverride.util.StringJoiner;

import javaemul.internal.ArrayHelper;

/**
 * Skeletal implementation of the Collection interface. <a
 * href="http://javaoverride.sun.com/j2se/1.5.0/docs/api/java/util/AbstractCollection.html">[Sun
 * docs]</a>
 *
 * @param <E> the element type.
 *
 */
public abstract class AbstractCollection<E> implements Collection<E> {

  protected AbstractCollection() {
  }

  @Override
  public boolean add(E o) {
    throw new UnsupportedOperationException("Add not supported on this collection");
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    checkNotNull(c);

    boolean changed = false;
    for (E e : c) {
      changed |= add(e);
    }
    return changed;
  }

  @Override
  public void clear() {
    for (java.util.Iterator<E> iter = iterator(); iter.hasNext();) {
      iter.next();
      iter.remove();
    }
  }

  @Override
  public boolean contains(Object o) {
    return advanceToFind(o, false);
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    checkNotNull(c);

    for (Object e : c) {
      if (!contains(e)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public abstract java.util.Iterator<E> iterator();

  @Override
  public boolean remove(Object o) {
    return advanceToFind(o, true);
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    checkNotNull(c);

    boolean changed = false;
    for (java.util.Iterator<?> iter = iterator(); iter.hasNext();) {
      Object o = iter.next();
      if (c.contains(o)) {
        iter.remove();
        changed = true;
      }
    }
    return changed;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    checkNotNull(c);

    boolean changed = false;
    for (java.util.Iterator<?> iter = iterator(); iter.hasNext();) {
      Object o = iter.next();
      if (!c.contains(o)) {
        iter.remove();
        changed = true;
      }
    }
    return changed;
  }

  @Override
  public abstract int size();

  @Override
  public Object[] toArray() {
    return toArray(new Object[size()]);
  }

  @Override
  public <T> T[] toArray(T[] a) {
    int size = size();
    if (a.length < size) {
      a = ArrayHelper.createFrom(a, size);
    }
    Object[] result = a;
    java.util.Iterator<E> it = iterator();
    for (int i = 0; i < size; ++i) {
      result[i] = it.next();
    }
    if (a.length > size) {
      a[size] = null;
    }
    return a;
  }

  @Override
  public String toString() {
    StringJoiner joiner = new StringJoiner(", ", "[", "]");
    for (E e : this) {
      joiner.add(((Object)e) == this ? "(this Collection)" : String.valueOf(e));
    }
    return joiner.toString();
  }

  private boolean advanceToFind(Object o, boolean remove) {
    for (java.util.Iterator<E> iter = iterator(); iter.hasNext();) {
      E e = iter.next();
      if (Objects.equals(o, e)) {
        if (remove) {
          iter.remove();
        }
        return true;
      }
    }
    return false;
  }
}
