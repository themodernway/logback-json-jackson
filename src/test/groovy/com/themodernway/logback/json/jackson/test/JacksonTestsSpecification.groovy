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

package com.themodernway.logback.json.jackson.test

import com.themodernway.logback.json.jackson.JacksonJSONFormatter
import com.themodernway.logback.json.jackson.test.util.AbstractSpecification

public class JacksonTestsSpecification extends AbstractSpecification
{
    def setupSpec()
    {
    }

    def cleanupSpec()
    {
    }

    def "jackson(1)"()
    {
        setup:
        def json = new JacksonJSONFormatter().copy()
        json.setPretty(true)
        json.setPretty(false)
        def valu = json.toJSONString([test: 1])
        echo valu
        echo "jackson(1)"
        json.setPretty(true)

        expect:
        json.isPretty() == true
    }

    def "jackson(2)"()
    {
        setup:
        def json = new JacksonJSONFormatter().copy()
        json.setPretty(true)
        json.setPretty(false)
        def valu = json.toJSONString([test: 2])
        echo valu
        echo "jackson(2)"
        json.setPretty(false)

        expect:
        json.isPretty() == false
    }
}
