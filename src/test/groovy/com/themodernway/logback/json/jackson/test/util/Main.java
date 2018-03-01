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

package com.themodernway.logback.json.jackson.test.util;

import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.themodernway.logback.json.core.JSONFormattingException;

public class Main
{
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(final String... strings)
    {
        final long stop = System.currentTimeMillis() + 6400000L;

        final Timer timer = new Timer();

        final TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                logger.info("info");

                logger.warn("warn");

                logger.error("oops", new JSONFormattingException("oops"));

                if (System.currentTimeMillis() >= stop)
                {
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 10000, 5);
    }
}
