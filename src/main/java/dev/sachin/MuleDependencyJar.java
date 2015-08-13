package dev.sachin;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.codehaus.plexus.util.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Goal which touches a timestamp file.
 *
 * @ deprecated Don't use!
 */
@Mojo( name = "muledepjar", defaultPhase = LifecyclePhase.PACKAGE )
public class MuleDependencyJar
    extends AbstractMojo
{
    /**
     * Location of the file.
     */
    @Parameter( defaultValue = "${project.build.directory}", property = "dev.sachin.targetDir", required = true )
    private File outputDirectory;

    @Parameter( defaultValue="${project.artifactId}-${project.version}.zip", property = "dev.sachin.zipfile", required = true )
    private String zipFile;

    @Parameter( defaultValue="${project.artifactId}-${project.version}.jar", property = "dev.sachin.jarfile", required = true )
    private String jarFile;

    public void execute()
        throws MojoExecutionException
    {
    	if(outputDirectory.exists())
    	{ 
			File f_zp = new File(outputDirectory+File.separator+zipFile);
			File f_jr = new File(outputDirectory+File.separator+jarFile);
			if(f_zp.exists()) {
				try {
					FileUtils.copyFile(f_zp, f_jr);
				} catch (IOException e) {
					throw new MojoExecutionException(e.getMessage(), e);
				}
			}
			else {
				this.getLog().info("ZIP ("+f_zp+") file not found.");
			}
    	}
    	else {
    		this.getLog().info("target directory not found.");
    	}
    }
}
