# mvn-cp

How to use:

Edited for nivedita

```xml

<plugin>
	<groupId>dev.sachin</groupId>
	<artifactId>mvn-cp</artifactId>
	<version>1.0</version>
	<executions>
		<execution>
			<id>1</id>
			<phase>install</phase>
			<goals>
			  <goal>muledepjar</goal>
			</goals>
			<inherited>false</inherited>
			<configuration>
				<!-- zipfile>${project.artifactId}-${project.version}.zip</zipfile>
				<jarfile>${project.artifactId}-${project.version}.jar</jarfile -->
			</configuration>
		  </execution>
	</executions>
</plugin>

