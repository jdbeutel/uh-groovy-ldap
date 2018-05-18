uh-groovy-ldap
===========

LDAP Groovy Demonstration Program

**Overview**

The program demonstrates how to do a simple LDAP search
of the University of Hawaii LDAP service.

Note: You must specify your special DN and its password.<br/>
The example run of the program uses the 'filedrop' special DN,
but the value of the password has been removed from the
checked-in code. The use of the special DN will also require
the ability to pass through the UH firewall.

**Technology**

The program was developed on Apple Mac OS X 10.10.2,
using the below version of Groovy.

**Verify you have Groovy installed**

    $ groovy -version
    Groovy Version: 2.1.9 JVM: 1.7.0_60 Vendor: Oracle Corporation OS: Mac OS X

Install Groovy if you don't already have it.


**Running the Program**

Run the program from the command line:

    $ groovy ldapRunner duckart
    vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    [cn: Francis R Duckart, uid: duckart, uhUuid: 12345678, mail: duckart@hawaii.edu, francis.duckart@hawaii.edu]
    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

You can run the program with multiple UH usernames: </br>

    $ groovy ldapRunner duckart duckart
    vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    [cn: Francis R Duckart, uid: duckart, uhUuid: 12345678, mail: duckart@hawaii.edu, francis.duckart@hawaii.edu]
    ....................................
    [cn: Francis R Duckart, uid: duckart, uhUuid: 12345678, mail: duckart@hawaii.edu, francis.duckart@hawaii.edu]
    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
