Hello World with EJB 3.0
###########################################################################


Requirements
---------------------------------------------------------------------------

- JDK 5.0 on any operating system
- Ant 1.6


Building and running the example
---------------------------------------------------------------------------

The following Ant targets are available:

    clean         Clean the build directory
    startdb       Run HSQL database server with clean DB
    dbmanager     Start HSQL DB manager
    run           Build and run HelloWorld

1. Open your command shell and change to the example directory

2. Use ant startdb to start a fresh HSQL database, keep the database running

3. Open a second command shell and change to the example directory

4. Run the example with ant run and read the log output on the console

5. Reduce/increase the log output by tweaking src/etc/log4j.properties and
   src/etc/META-INF/persistence.xml

6. Call ant run again

7. Use ant dbmanager to open the HSQL database browser


Notes
---------------------------------------------------------------------------

Note: All tables are dropped and re-created when you run the example, you can disable this
      by commenting out the hbm2ddl.auto property in src/etc/META-INF/persistence.xml.

Note: You can always reset the database by restarting the database server.

Note for IntelliJ IDEA users: Open the project file in the Getting Started root directory.
