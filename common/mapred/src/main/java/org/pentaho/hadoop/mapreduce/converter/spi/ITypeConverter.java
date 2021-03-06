/*******************************************************************************
 *
 * Pentaho Big Data
 *
 * Copyright (C) 2002-2017 by Hitachi Vantara : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.hadoop.mapreduce.converter.spi;

import org.pentaho.di.core.row.ValueMetaInterface;
import org.pentaho.hadoop.mapreduce.converter.TypeConversionException;

/**
 * Provides conversion between types
 *
 * @param <F> Type this converter can convert from
 * @param <T> Type this converter can convert to
 */
public interface ITypeConverter<F, T> {
  /**
   * Can this converter convert between the types provided?
   *
   * @param from Type to convert from
   * @param to   Type to convert to
   * @return {@code true} if this converter can handle the conversion between {@code from} and {@code to}
   */
  public boolean canConvert( Class from, Class to );

  /**
   * Convert an object with some metadata to the destination type.
   *
   * @param meta Metadata for the object provided. This provides hints and formatting to aid in conversion.
   * @param obj  Object to convert
   * @return Converted object
   * @throws org.pentaho.hadoop.mapreduce.converter.TypeConversionException Error encountered when converting {@code
   *                                                                        obj} to type {@code T}
   */
  public T convert( ValueMetaInterface meta, F obj ) throws TypeConversionException;
}
