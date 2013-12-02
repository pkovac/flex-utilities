////////////////////////////////////////////////////////////////////////////////
//
//  Licensed to the Apache Software Foundation (ASF) under one or more
//  contributor license agreements.  See the NOTICE file distributed with
//  this work for additional information regarding copyright ownership.
//  The ASF licenses this file to You under the Apache License, Version 2.0
//  (the "License"); you may not use this file except in compliance with
//  the License.  You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
//
////////////////////////////////////////////////////////////////////////////////
package
{
    import flash.desktop.NativeApplication;
    import flash.display.Sprite;
    import flash.filesystem.File;
    import org.apache.flex.ant.Ant;
    import org.apache.flex.ant.tags.Condition; Condition.init(null);
    import org.apache.flex.ant.tags.Echo; Echo.init(null);
    import org.apache.flex.ant.tags.IsSet; IsSet.init(null);
    import org.apache.flex.ant.tags.OS; OS.init(null);
    import org.apache.flex.ant.tags.Project; Project.init(null);
    import org.apache.flex.ant.tags.Property; Property.init(null);
    import org.apache.flex.ant.tags.Target; Target.init(null);
    
    public class TestTarget extends Sprite
    {
        public function TestTarget()
        {
            ant = new Ant();
            var context:Object = { targets: "test" };
            var file:File = File.applicationDirectory;
            file = file.resolvePath("test.xml");
            ant.processXMLFile(file, context);
            NativeApplication.nativeApplication.exit();
        }
        
        private var ant:Ant;
    }
}