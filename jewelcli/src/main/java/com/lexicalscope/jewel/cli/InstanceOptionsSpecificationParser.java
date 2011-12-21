/*
 * Copyright 2007 Tim Wood
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lexicalscope.jewel.cli;

import static ch.lambdaj.Lambda.convert;
import static com.lexicalscope.fluentreflection.ReflectionMatchers.*;

import com.lexicalscope.fluentreflection.ReflectedClass;

class InstanceOptionsSpecificationParser<O> {
    private final ReflectedClass<O> klass;

    InstanceOptionsSpecificationParser(final ReflectedClass<O> klass) {
        this.klass = klass;
    }

    OptionsSpecification<O> buildOptionsSpecification() {
        return new OptionsSpecificationImpl<O>(klass,
                convert(
                        klass.methods(isSetter().and(annotatedWith(Option.class))),
                        new ConvertSetterMethodToParsedOptionSpecification(klass)),
                convert(
                        klass.methods(isSetter().and(annotatedWith(Unparsed.class))),
                        new ConvertUnparsedSetterMethodToUnparsedOptionSpecification(klass)));
    }

    static <O> OptionsSpecification<O> createOptionsSpecificationImpl(final ReflectedClass<O> klass) {
        return new InstanceOptionsSpecificationParser<O>(klass).buildOptionsSpecification();
    }
}
