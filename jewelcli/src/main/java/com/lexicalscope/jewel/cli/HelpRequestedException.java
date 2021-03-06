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

import java.util.Arrays;

import com.lexicalscope.jewel.cli.specification.OptionsSpecification;

/**
 * The user requested help
 * 
 * @author tim
 */
public class HelpRequestedException extends ArgumentValidationException
{
    private static final long serialVersionUID = 2760658691533137382L;

    /**
     * The user requested help
     * 
     * @param specification
     *            The options specification
     */
    public HelpRequestedException(final OptionsSpecification<?> specification)
    {
        super(specification.toString(),
                Arrays.<ValidationFailure>asList(new ValidationFailureHelpRequested(specification)));
    }
}
