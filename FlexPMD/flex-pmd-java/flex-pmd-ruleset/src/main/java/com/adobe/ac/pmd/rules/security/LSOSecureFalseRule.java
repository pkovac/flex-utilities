/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.adobe.ac.pmd.rules.security;

import java.util.regex.Matcher;

import com.adobe.ac.pmd.rules.core.AbstractRegexpBasedRule;
import com.adobe.ac.pmd.rules.core.ViolationPriority;

/**
 * @author xagnetti
 */
public class LSOSecureFalseRule extends AbstractRegexpBasedRule
{
   /*
    * (non-Javadoc)
    * @see
    * com.adobe.ac.pmd.rules.core.AbstractFlexRule#isConcernedByTheCurrentFile()
    */
   @Override
   public final boolean isConcernedByTheCurrentFile()
   {
      return true;
   }

   /*
    * (non-Javadoc)
    * @see com.adobe.ac.pmd.rules.core.AbstractFlexRule#getDefaultPriority()
    */
   @Override
   protected final ViolationPriority getDefaultPriority()
   {
      return ViolationPriority.LOW;
   }

   /*
    * (non-Javadoc)
    * @see com.adobe.ac.pmd.rules.core.AbstractRegexpBasedRule#getRegexp()
    */
   @Override
   protected final String getRegexp()
   {
      return ".*\\.getLocal\\s*\\([^,]+\\,[^,]+\\,([A-Za-z ]+)\\).*";
   }

   /*
    * (non-Javadoc)
    * @see
    * com.adobe.ac.pmd.rules.core.AbstractRegexpBasedRule#isCurrentLineConcerned
    * (java.lang.String)
    */
   @Override
   protected boolean isCurrentLineConcerned( final String line )
   {
      return line.contains( "getLocal" );
   }

   /*
    * (non-Javadoc)
    * @seecom.adobe.ac.pmd.rules.core.AbstractRegexpBasedRule#
    * isViolationDetectedOnThisMatchingLine(java.lang.String)
    */
   @Override
   protected final boolean isViolationDetectedOnThisMatchingLine( final String line )
   {
      final Matcher matcher = getMatcher( line );

      if ( matcher.matches() )
      {
         final String secureFlag = matcher.group( 1 ).trim();

         if ( secureFlag.equalsIgnoreCase( "false" ) )
         {
            return true;
         }

      }
      return false;
   }
}
