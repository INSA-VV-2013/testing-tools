Mutation testing with PIT
=========================

Concept
-------

The aim of mutation testing is to evaluate how effectively a test suite
operates on a given program. We do this by inserting mutations into
the tested program and running the test cases against it. If the tests succeed,
that could mean something is wrong with the program or with the tests.

Basic usage
-----------

[PIT](http://pitest.org/) is an open-source (Apache-licensed) mutation testing tool based on JUnit4.
It is available as a command line tool, as a Maven plugin (org.pitest:pitest-maven)
and as an Eclipse plugin. This repository contains a Maven project configured
for use with PIT. We added the following lines to the default `pom.xml` :

    <plugin>
        <groupId>org.pitest</groupId>
        <artifactId>pitest-maven</artifactId>
        <version>0.32</version>
        <configuration>
            <targetClasses>
                <param>vvt.pit.code.Calculatrice</param>
            </targetClasses>
            <targetTests>
                <param>vvt.pit.test.CalculatriceTest</param>
            </targetTests>
            <mutators>
                <mutator>DEFAULTS</mutator>
                <!-- you could enable experimental mutators here -->
            </mutators>
        </configuration>
    </plugin>

Once it is confirmed that all the tests run correctly on the program, we can run
PIT. We do this with :

    mvn org.pitest:pitest-maven:mutationCoverage 

This generates HTML reports in the `targets/` directory. These reports contain
information about line coverage (light green / light pink) and mutation coverage
(dark green / dark pink). A line is colored in dark pink if the mutants
for that line *survived* the tests, indicating there might be an issue with the
test suite. 

Available mutations
-------------------

PIT provides a set of basic [mutators](http://pitest.org/quickstart/mutators/) :

* Conditionals Boundary Mutator
* Negate Conditionals Mutator
* Remove Conditionals Mutator
* Math Mutator
* Increments Mutator
* Invert Negatives Mutator
* Inline Constant Mutator
* Return Values Mutator
* Void Method Calls Mutator
* Non Void Method Calls Mutator
* Constructor Calls Mutator
* Experimental Inline Constant Mutator
* Experimental Member Variable Mutator
* Experimental Switch Mutator

However, as of today (24/01/2014), it doesn't provide many object-oriented mutators
such as one which would turn public members private.

References
----------

* PIT official website : [pitest.org](http://pitest.org/)
