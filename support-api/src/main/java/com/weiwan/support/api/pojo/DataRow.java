/*
 *      Copyright [2020] [xiaozhennan1995@gmail.com]
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 *      http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.weiwan.support.api.pojo;

import org.apache.flink.annotation.PublicEvolving;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: xiaozhennan
 * @Date: 2020/8/10 10:21
 * @Package: com.weiwan.support.core.pub.pojo
 * @ClassName: DataRow
 * @Description:
 **/
@PublicEvolving
public class DataRow<T> implements Serializable {


    private final T[] fields;


    public DataRow(Class<T> tClass, int arity) {
        this.fields = (T[]) Array.newInstance(tClass, arity);
    }


    public int getArity() {
        return fields.length;
    }


    public T getField(int pos) {
        return (T) fields[pos];
    }


    public void setField(int pos, T value) {
        fields[pos] = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DataRow row = (DataRow) o;

        return Arrays.deepEquals(fields, row.fields);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(fields);
    }


    public static DataRow of(Object... values) {
        DataRow row = new DataRow(Object.class, values.length);
        for (int i = 0; i < values.length; i++) {
            row.setField(i, values[i]);
        }
        return row;
    }

    public static DataRow copy(DataRow row) {
        final DataRow newRow = new DataRow(Object.class, row.fields.length);
        System.arraycopy(row.fields, 0, newRow.fields, 0, row.fields.length);
        return newRow;
    }


    public static DataRow project(DataRow row, int[] fields) {
        final DataRow newRow = new DataRow(Object.class, fields.length);
        for (int i = 0; i < fields.length; i++) {
            newRow.fields[i] = row.fields[fields[i]];
        }
        return newRow;
    }

    @Override
    public String toString() {
        return "DataRow{" +
                "fields=" + Arrays.toString(fields) +
                '}';
    }

    public T[] getFields() {
        return fields;
    }
}
