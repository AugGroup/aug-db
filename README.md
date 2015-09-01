AugHrDb
===========

How to run generate schema for Development

    mvn hibernate3:hbm2ddl sql:execute -P dev
    
How to run generate schema for Production
    
    mvn hibernate3:hbm2ddl sql:execute -P prod
