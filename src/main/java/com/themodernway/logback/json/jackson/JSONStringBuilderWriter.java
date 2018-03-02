/*
 * Copyright (c) 2018, The Modern Way. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.themodernway.logback.json.jackson;

import java.io.IOException;
import java.io.Writer;

public class JSONStringBuilderWriter extends Writer
{
    private final StringBuilder m_builder;

    public JSONStringBuilderWriter()
    {
        this(new StringBuilder(8192));
    }

    protected JSONStringBuilderWriter(final StringBuilder builder)
    {
        super(builder);

        m_builder = builder;
    }

    @Override
    public void write(final int c) throws IOException
    {
        m_builder.append((char) c);
    }

    @Override
    public void write(final char[] chr, final int off, final int len) throws IOException
    {
        if (null != chr)
        {
            m_builder.append(chr, off, len);
        }
    }

    @Override
    public void write(final String str) throws IOException
    {
        if (null != str)
        {
            m_builder.append(str);
        }
    }

    @Override
    public void write(final String str, final int off, final int len) throws IOException
    {
        if (null != str)
        {
            m_builder.append(str.substring(off, off + len));
        }
    }

    @Override
    public JSONStringBuilderWriter append(final CharSequence chs) throws IOException
    {
        if (null != chs)
        {
            m_builder.append(chs);
        }
        return this;
    }

    @Override
    public JSONStringBuilderWriter append(final CharSequence chs, final int beg, final int end) throws IOException
    {
        if (null != chs)
        {
            m_builder.append(chs, beg, end);
        }
        return this;
    }

    @Override
    public JSONStringBuilderWriter append(final char c) throws IOException
    {
        m_builder.append(c);

        return this;
    }

    @Override
    public String toString()
    {
        return m_builder.toString();
    }

    @Override
    public void flush()
    {
        // flush does nothing here
    }

    @Override
    public void close() throws IOException
    {
        // close does nothing here
    }

    public void clear()
    {
        m_builder.setLength(0);
    }
}
