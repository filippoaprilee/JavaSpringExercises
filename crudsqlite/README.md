"C:\Program Files\Eclipse Adoptium\jdk-21.0.3.9-hotspot\bin\java.exe" -XX:TieredStopAtLevel=1 -Dspring.output.ansi.enabled=always -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true "-Dmanagement.endpoints.jmx.exposure.include=*" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2024.1.3\lib\idea_rt.jar=58636:C:\Program Files\JetBrains\IntelliJ IDEA 2024.1.3\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\Studente\EserciziJava\JavaSpringExercises\crudsqlite\target\classes;C:\Users\Studente\.m2\repository\org\springframework\boot\spring-boot-starter-data-jpa\3.3.1\spring-boot-starter-data-jpa-3.3.1.jar;C:\Users\Studente\.m2\repository\org\springframework\boot\spring-boot-starter-aop\3.3.1\spring-boot-starter-aop-3.3.1.jar;C:\Users\Studente\.m2\repository\org\springframework\spring-aop\6.1.10\spring-aop-6.1.10.jar;C:\Users\Studente\.m2\repository\org\aspectj\aspectjweaver\1.9.22\aspectjweaver-1.9.22.jar;C:\Users\Studente\.m2\repository\org\springframework\boot\spring-boot-starter-jdbc\3.3.1\spring-boot-starter-jdbc-3.3.1.jar;C:\Users\Studente\.m2\repository\com\zaxxer\HikariCP\5.1.0\HikariCP-5.1.0.jar;C:\Users\Studente\.m2\repository\org\springframework\spring-jdbc\6.1.10\spring-jdbc-6.1.10.jar;C:\Users\Studente\.m2\repository\org\hibernate\orm\hibernate-core\6.5.2.Final\hibernate-core-6.5.2.Final.jar;C:\Users\Studente\.m2\repository\jakarta\persistence\jakarta.persistence-api\3.1.0\jakarta.persistence-api-3.1.0.jar;C:\Users\Studente\.m2\repository\jakarta\transaction\jakarta.transaction-api\2.0.1\jakarta.transaction-api-2.0.1.jar;C:\Users\Studente\.m2\repository\io\smallrye\jandex\3.1.2\jandex-3.1.2.jar;C:\Users\Studente\.m2\repository\jakarta\inject\jakarta.inject-api\2.0.1\jakarta.inject-api-2.0.1.jar;C:\Users\Studente\.m2\repository\org\antlr\antlr4-runtime\4.13.0\antlr4-runtime-4.13.0.jar;C:\Users\Studente\.m2\repository\org\springframework\data\spring-data-jpa\3.3.1\spring-data-jpa-3.3.1.jar;C:\Users\Studente\.m2\repository\org\springframework\data\spring-data-commons\3.3.1\spring-data-commons-3.3.1.jar;C:\Users\Studente\.m2\repository\org\springframework\spring-orm\6.1.10\spring-orm-6.1.10.jar;C:\Users\Studente\.m2\repository\org\springframework\spring-context\6.1.10\spring-context-6.1.10.jar;C:\Users\Studente\.m2\repository\org\springframework\spring-tx\6.1.10\spring-tx-6.1.10.jar;C:\Users\Studente\.m2\repository\org\springframework\spring-beans\6.1.10\spring-beans-6.1.10.jar;C:\Users\Studente\.m2\repository\jakarta\annotation\jakarta.annotation-api\2.1.1\jakarta.annotation-api-2.1.1.jar;C:\Users\Studente\.m2\repository\org\springframework\spring-aspects\6.1.10\spring-aspects-6.1.10.jar;C:\Users\Studente\.m2\repository\org\springframework\boot\spring-boot-starter-web\3.3.1\spring-boot-starter-web-3.3.1.jar;C:\Users\Studente\.m2\repository\org\springframework\boot\spring-boot-starter\3.3.1\spring-boot-starter-3.3.1.jar;C:\Users\Studente\.m2\repository\org\springframework\boot\spring-boot\3.3.1\spring-boot-3.3.1.jar;C:\Users\Studente\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\3.3.1\spring-boot-autoconfigure-3.3.1.jar;C:\Users\Studente\.m2\repository\org\springframework\boot\spring-boot-starter-logging\3.3.1\spring-boot-starter-logging-3.3.1.jar;C:\Users\Studente\.m2\repository\ch\qos\logback\logback-classic\1.5.6\logback-classic-1.5.6.jar;C:\Users\Studente\.m2\repository\ch\qos\logback\logback-core\1.5.6\logback-core-1.5.6.jar;C:\Users\Studente\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.23.1\log4j-to-slf4j-2.23.1.jar;C:\Users\Studente\.m2\repository\org\apache\logging\log4j\log4j-api\2.23.1\log4j-api-2.23.1.jar;C:\Users\Studente\.m2\repository\org\slf4j\jul-to-slf4j\2.0.13\jul-to-slf4j-2.0.13.jar;C:\Users\Studente\.m2\repository\org\yaml\snakeyaml\2.2\snakeyaml-2.2.jar;C:\Users\Studente\.m2\repository\org\springframework\boot\spring-boot-starter-json\3.3.1\spring-boot-starter-json-3.3.1.jar;C:\Users\Studente\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.17.1\jackson-databind-2.17.1.jar;C:\Users\Studente\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.17.1\jackson-annotations-2.17.1.jar;C:\Users\Studente\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.17.1\jackson-core-2.17.1.jar;C:\Users\Studente\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.17.1\jackson-datatype-jdk8-2.17.1.jar;C:\Users\Studente\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.17.1\jackson-datatype-jsr310-2.17.1.jar;C:\Users\Studente\.m2\repository\com\fasterxml\jackson\module\jackson-module-parameter-names\2.17.1\jackson-module-parameter-names-2.17.1.jar;C:\Users\Studente\.m2\repository\org\springframework\boot\spring-boot-starter-tomcat\3.3.1\spring-boot-starter-tomcat-3.3.1.jar;C:\Users\Studente\.m2\repository\org\apache\tomcat\embed\tomcat-embed-core\10.1.25\tomcat-embed-core-10.1.25.jar;C:\Users\Studente\.m2\repository\org\apache\tomcat\embed\tomcat-embed-el\10.1.25\tomcat-embed-el-10.1.25.jar;C:\Users\Studente\.m2\repository\org\apache\tomcat\embed\tomcat-embed-websocket\10.1.25\tomcat-embed-websocket-10.1.25.jar;C:\Users\Studente\.m2\repository\org\springframework\spring-web\6.1.10\spring-web-6.1.10.jar;C:\Users\Studente\.m2\repository\io\micrometer\micrometer-observation\1.13.1\micrometer-observation-1.13.1.jar;C:\Users\Studente\.m2\repository\io\micrometer\micrometer-commons\1.13.1\micrometer-commons-1.13.1.jar;C:\Users\Studente\.m2\repository\org\springframework\spring-webmvc\6.1.10\spring-webmvc-6.1.10.jar;C:\Users\Studente\.m2\repository\org\springframework\spring-expression\6.1.10\spring-expression-6.1.10.jar;C:\Users\Studente\.m2\repository\jakarta\xml\bind\jakarta.xml.bind-api\4.0.2\jakarta.xml.bind-api-4.0.2.jar;C:\Users\Studente\.m2\repository\jakarta\activation\jakarta.activation-api\2.1.3\jakarta.activation-api-2.1.3.jar;C:\Users\Studente\.m2\repository\org\springframework\spring-core\6.1.10\spring-core-6.1.10.jar;C:\Users\Studente\.m2\repository\org\springframework\spring-jcl\6.1.10\spring-jcl-6.1.10.jar;C:\Users\Studente\.m2\repository\org\xerial\sqlite-jdbc\3.46.0.0\sqlite-jdbc-3.46.0.0.jar;C:\Users\Studente\.m2\repository\org\slf4j\slf4j-api\2.0.13\slf4j-api-2.0.13.jar;C:\Users\Studente\.m2\repository\org\hibernate\hibernate-core\5.6.5.Final\hibernate-core-5.6.5.Final.jar;C:\Users\Studente\.m2\repository\org\jboss\logging\jboss-logging\3.5.3.Final\jboss-logging-3.5.3.Final.jar;C:\Users\Studente\.m2\repository\javax\persistence\javax.persistence-api\2.2\javax.persistence-api-2.2.jar;C:\Users\Studente\.m2\repository\net\bytebuddy\byte-buddy\1.14.17\byte-buddy-1.14.17.jar;C:\Users\Studente\.m2\repository\antlr\antlr\2.7.7\antlr-2.7.7.jar;C:\Users\Studente\.m2\repository\org\jboss\spec\javax\transaction\jboss-transaction-api_1.2_spec\1.1.1.Final\jboss-transaction-api_1.2_spec-1.1.1.Final.jar;C:\Users\Studente\.m2\repository\org\jboss\jandex\2.4.2.Final\jandex-2.4.2.Final.jar;C:\Users\Studente\.m2\repository\com\fasterxml\classmate\1.7.0\classmate-1.7.0.jar;C:\Users\Studente\.m2\repository\javax\activation\javax.activation-api\1.2.0\javax.activation-api-1.2.0.jar;C:\Users\Studente\.m2\repository\org\hibernate\common\hibernate-commons-annotations\5.1.2.Final\hibernate-commons-annotations-5.1.2.Final.jar;C:\Users\Studente\.m2\repository\javax\xml\bind\jaxb-api\2.3.1\jaxb-api-2.3.1.jar;C:\Users\Studente\.m2\repository\org\glassfish\jaxb\jaxb-runtime\4.0.5\jaxb-runtime-4.0.5.jar;C:\Users\Studente\.m2\repository\org\glassfish\jaxb\jaxb-core\4.0.5\jaxb-core-4.0.5.jar;C:\Users\Studente\.m2\repository\org\eclipse\angus\angus-activation\2.0.2\angus-activation-2.0.2.jar;C:\Users\Studente\.m2\repository\org\glassfish\jaxb\txw2\4.0.5\txw2-4.0.5.jar;C:\Users\Studente\.m2\repository\com\sun\istack\istack-commons-runtime\4.1.2\istack-commons-runtime-4.1.2.jar com.example.crudsqlite.CrudsqliteApplication

.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/

:: Spring Boot ::                (v3.3.1)

2024-06-28T10:28:09.833+02:00  INFO 11220 --- [crudsqlite] [           main] c.e.crudsqlite.CrudsqliteApplication     : Starting CrudsqliteApplication using Java 21.0.3 with PID 11220 (C:\Users\Studente\EserciziJava\JavaSpringExercises\crudsqlite\target\classes started by Studente in C:\Users\Studente\EserciziJava\JavaSpringExercises\crudsqlite)
2024-06-28T10:28:09.837+02:00  INFO 11220 --- [crudsqlite] [           main] c.e.crudsqlite.CrudsqliteApplication     : No active profile set, falling back to 1 default profile: "default"
2024-06-28T10:28:10.632+02:00  INFO 11220 --- [crudsqlite] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2024-06-28T10:28:10.688+02:00  INFO 11220 --- [crudsqlite] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 47 ms. Found 1 JPA repository interface.
2024-06-28T10:28:11.171+02:00  INFO 11220 --- [crudsqlite] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-06-28T10:28:11.184+02:00  INFO 11220 --- [crudsqlite] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-06-28T10:28:11.184+02:00  INFO 11220 --- [crudsqlite] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.25]
2024-06-28T10:28:11.246+02:00  INFO 11220 --- [crudsqlite] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-06-28T10:28:11.246+02:00  INFO 11220 --- [crudsqlite] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1354 ms
2024-06-28T10:28:11.410+02:00  INFO 11220 --- [crudsqlite] [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2024-06-28T10:28:11.467+02:00  INFO 11220 --- [crudsqlite] [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.5.2.Final
2024-06-28T10:28:11.503+02:00  INFO 11220 --- [crudsqlite] [           main] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
2024-06-28T10:28:11.518+02:00  INFO 11220 --- [crudsqlite] [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
2024-06-28T10:28:11.841+02:00  INFO 11220 --- [crudsqlite] [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2024-06-28T10:28:11.866+02:00  INFO 11220 --- [crudsqlite] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2024-06-28T10:28:12.003+02:00  INFO 11220 --- [crudsqlite] [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection org.sqlite.jdbc4.JDBC4Connection@67e77f52
2024-06-28T10:28:12.006+02:00  INFO 11220 --- [crudsqlite] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2024-06-28T10:28:12.020+02:00  WARN 11220 --- [crudsqlite] [           main] o.h.e.j.e.i.JdbcEnvironmentInitiator     : HHH000342: Could not obtain connection to query metadata

org.hibernate.boot.registry.selector.spi.StrategySelectionException: Unable to resolve name [org.hibernate.dialect.SQLiteDialect] as strategy [org.hibernate.dialect.Dialect]
at org.hibernate.boot.registry.selector.internal.StrategySelectorImpl.selectStrategyImplementor(StrategySelectorImpl.java:154) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.boot.registry.selector.internal.StrategySelectorImpl.resolveStrategy(StrategySelectorImpl.java:236) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.boot.registry.selector.internal.StrategySelectorImpl.resolveStrategy(StrategySelectorImpl.java:189) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.engine.jdbc.dialect.internal.DialectFactoryImpl.constructDialect(DialectFactoryImpl.java:123) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.engine.jdbc.dialect.internal.DialectFactoryImpl.buildDialect(DialectFactoryImpl.java:88) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$1.execute(JdbcEnvironmentInitiator.java:323) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$1.execute(JdbcEnvironmentInitiator.java:291) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.jdbc.WorkExecutor.executeReturningWork(WorkExecutor.java:58) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.jdbc.AbstractReturningWork.accept(AbstractReturningWork.java:34) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.resource.transaction.backend.jdbc.internal.JdbcIsolationDelegate.delegateWork(JdbcIsolationDelegate.java:70) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.getJdbcEnvironmentUsingJdbcMetadata(JdbcEnvironmentInitiator.java:290) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:123) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:77) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.boot.registry.internal.StandardServiceRegistryImpl.initiateService(StandardServiceRegistryImpl.java:130) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.service.internal.AbstractServiceRegistryImpl.createService(AbstractServiceRegistryImpl.java:263) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:238) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:215) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.boot.model.relational.Database.<init>(Database.java:45) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.getDatabase(InFlightMetadataCollectorImpl.java:221) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.<init>(InFlightMetadataCollectorImpl.java:189) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.boot.model.process.spi.MetadataBuildingProcess.complete(MetadataBuildingProcess.java:171) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.metadata(EntityManagerFactoryBuilderImpl.java:1431) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1502) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:75) ~[spring-orm-6.1.10.jar:6.1.10]
at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:390) ~[spring-orm-6.1.10.jar:6.1.10]
at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.1.10.jar:6.1.10]
at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-6.1.10.jar:6.1.10]
at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:366) ~[spring-orm-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1835) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1784) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:522) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:337) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:335) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:205) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:952) ~[spring-context-6.1.10.jar:6.1.10]
at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:624) ~[spring-context-6.1.10.jar:6.1.10]
at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.3.1.jar:3.3.1]
at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:754) ~[spring-boot-3.3.1.jar:3.3.1]
at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:456) ~[spring-boot-3.3.1.jar:3.3.1]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:335) ~[spring-boot-3.3.1.jar:3.3.1]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:1363) ~[spring-boot-3.3.1.jar:3.3.1]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:1352) ~[spring-boot-3.3.1.jar:3.3.1]
at com.example.crudsqlite.CrudsqliteApplication.main(CrudsqliteApplication.java:10) ~[classes/:na]
Caused by: org.hibernate.boot.registry.classloading.spi.ClassLoadingException: Unable to load class [org.hibernate.dialect.SQLiteDialect]
at org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl.classForName(ClassLoaderServiceImpl.java:126) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.boot.registry.selector.internal.StrategySelectorImpl.selectStrategyImplementor(StrategySelectorImpl.java:150) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
... 44 common frames omitted
Caused by: java.lang.ClassNotFoundException: Could not load requested class : org.hibernate.dialect.SQLiteDialect
at org.hibernate.boot.registry.classloading.internal.AggregatedClassLoader.findClass(AggregatedClassLoader.java:216) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:593) ~[na:na]
at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526) ~[na:na]
at java.base/java.lang.Class.forName0(Native Method) ~[na:na]
at java.base/java.lang.Class.forName(Class.java:534) ~[na:na]
at java.base/java.lang.Class.forName(Class.java:513) ~[na:na]
at org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl.classForName(ClassLoaderServiceImpl.java:123) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
... 45 common frames omitted
Caused by: java.lang.Throwable: null
at org.hibernate.boot.registry.classloading.internal.AggregatedClassLoader.findClass(AggregatedClassLoader.java:209) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
... 51 common frames omitted
Suppressed: java.lang.ClassNotFoundException: org.hibernate.dialect.SQLiteDialect
at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641) ~[na:na]
at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188) ~[na:na]
at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526) ~[na:na]
at org.hibernate.boot.registry.classloading.internal.AggregatedClassLoader.findClass(AggregatedClassLoader.java:206) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
... 51 common frames omitted
Suppressed: java.lang.ClassNotFoundException: org.hibernate.dialect.SQLiteDialect
at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641) ~[na:na]
at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188) ~[na:na]
at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526) ~[na:na]
at org.hibernate.boot.registry.classloading.internal.AggregatedClassLoader.findClass(AggregatedClassLoader.java:206) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
... 51 common frames omitted
Suppressed: java.lang.ClassNotFoundException: org.hibernate.dialect.SQLiteDialect
at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641) ~[na:na]
at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188) ~[na:na]
at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526) ~[na:na]
at org.hibernate.boot.registry.classloading.internal.AggregatedClassLoader.findClass(AggregatedClassLoader.java:206) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
... 51 common frames omitted

2024-06-28T10:28:12.027+02:00 ERROR 11220 --- [crudsqlite] [           main] j.LocalContainerEntityManagerFactoryBean : Failed to initialize JPA EntityManagerFactory: Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment] due to: Unable to resolve name [org.hibernate.dialect.SQLiteDialect] as strategy [org.hibernate.dialect.Dialect]
2024-06-28T10:28:12.028+02:00  WARN 11220 --- [crudsqlite] [           main] ConfigServletWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment] due to: Unable to resolve name [org.hibernate.dialect.SQLiteDialect] as strategy [org.hibernate.dialect.Dialect]
2024-06-28T10:28:12.028+02:00  INFO 11220 --- [crudsqlite] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2024-06-28T10:28:12.029+02:00  INFO 11220 --- [crudsqlite] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
2024-06-28T10:28:12.032+02:00  INFO 11220 --- [crudsqlite] [           main] o.apache.catalina.core.StandardService   : Stopping service [Tomcat]
2024-06-28T10:28:12.042+02:00  INFO 11220 --- [crudsqlite] [           main] .s.b.a.l.ConditionEvaluationReportLogger :

Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2024-06-28T10:28:12.064+02:00 ERROR 11220 --- [crudsqlite] [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment] due to: Unable to resolve name [org.hibernate.dialect.SQLiteDialect] as strategy [org.hibernate.dialect.Dialect]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1788) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:522) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:337) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:335) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:205) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:952) ~[spring-context-6.1.10.jar:6.1.10]
at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:624) ~[spring-context-6.1.10.jar:6.1.10]
at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.3.1.jar:3.3.1]
at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:754) ~[spring-boot-3.3.1.jar:3.3.1]
at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:456) ~[spring-boot-3.3.1.jar:3.3.1]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:335) ~[spring-boot-3.3.1.jar:3.3.1]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:1363) ~[spring-boot-3.3.1.jar:3.3.1]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:1352) ~[spring-boot-3.3.1.jar:3.3.1]
at com.example.crudsqlite.CrudsqliteApplication.main(CrudsqliteApplication.java:10) ~[classes/:na]
Caused by: org.hibernate.service.spi.ServiceException: Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment] due to: Unable to resolve name [org.hibernate.dialect.SQLiteDialect] as strategy [org.hibernate.dialect.Dialect]
at org.hibernate.service.internal.AbstractServiceRegistryImpl.createService(AbstractServiceRegistryImpl.java:276) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:238) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:215) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.boot.model.relational.Database.<init>(Database.java:45) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.getDatabase(InFlightMetadataCollectorImpl.java:221) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.<init>(InFlightMetadataCollectorImpl.java:189) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.boot.model.process.spi.MetadataBuildingProcess.complete(MetadataBuildingProcess.java:171) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.metadata(EntityManagerFactoryBuilderImpl.java:1431) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1502) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:75) ~[spring-orm-6.1.10.jar:6.1.10]
at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:390) ~[spring-orm-6.1.10.jar:6.1.10]
at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.1.10.jar:6.1.10]
at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-6.1.10.jar:6.1.10]
at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:366) ~[spring-orm-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1835) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1784) ~[spring-beans-6.1.10.jar:6.1.10]
... 15 common frames omitted
Caused by: org.hibernate.boot.registry.selector.spi.StrategySelectionException: Unable to resolve name [org.hibernate.dialect.SQLiteDialect] as strategy [org.hibernate.dialect.Dialect]
at org.hibernate.boot.registry.selector.internal.StrategySelectorImpl.selectStrategyImplementor(StrategySelectorImpl.java:154) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.boot.registry.selector.internal.StrategySelectorImpl.resolveStrategy(StrategySelectorImpl.java:236) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.boot.registry.selector.internal.StrategySelectorImpl.resolveStrategy(StrategySelectorImpl.java:189) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.engine.jdbc.dialect.internal.DialectFactoryImpl.constructDialect(DialectFactoryImpl.java:123) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.engine.jdbc.dialect.internal.DialectFactoryImpl.buildDialect(DialectFactoryImpl.java:88) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.getJdbcEnvironmentWithDefaults(JdbcEnvironmentInitiator.java:152) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.getJdbcEnvironmentUsingJdbcMetadata(JdbcEnvironmentInitiator.java:362) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:123) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:77) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.boot.registry.internal.StandardServiceRegistryImpl.initiateService(StandardServiceRegistryImpl.java:130) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.service.internal.AbstractServiceRegistryImpl.createService(AbstractServiceRegistryImpl.java:263) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
... 30 common frames omitted
Caused by: org.hibernate.boot.registry.classloading.spi.ClassLoadingException: Unable to load class [org.hibernate.dialect.SQLiteDialect]
at org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl.classForName(ClassLoaderServiceImpl.java:126) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at org.hibernate.boot.registry.selector.internal.StrategySelectorImpl.selectStrategyImplementor(StrategySelectorImpl.java:150) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
... 40 common frames omitted
Caused by: java.lang.ClassNotFoundException: Could not load requested class : org.hibernate.dialect.SQLiteDialect
at org.hibernate.boot.registry.classloading.internal.AggregatedClassLoader.findClass(AggregatedClassLoader.java:216) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:593) ~[na:na]
at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526) ~[na:na]
at java.base/java.lang.Class.forName0(Native Method) ~[na:na]
at java.base/java.lang.Class.forName(Class.java:534) ~[na:na]
at java.base/java.lang.Class.forName(Class.java:513) ~[na:na]
at org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl.classForName(ClassLoaderServiceImpl.java:123) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
... 41 common frames omitted
Caused by: java.lang.Throwable: null
at org.hibernate.boot.registry.classloading.internal.AggregatedClassLoader.findClass(AggregatedClassLoader.java:209) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
... 47 common frames omitted
Suppressed: java.lang.ClassNotFoundException: org.hibernate.dialect.SQLiteDialect
at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641) ~[na:na]
at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188) ~[na:na]
at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526) ~[na:na]
at org.hibernate.boot.registry.classloading.internal.AggregatedClassLoader.findClass(AggregatedClassLoader.java:206) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
... 47 common frames omitted
Suppressed: java.lang.ClassNotFoundException: org.hibernate.dialect.SQLiteDialect
at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641) ~[na:na]
at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188) ~[na:na]
at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526) ~[na:na]
at org.hibernate.boot.registry.classloading.internal.AggregatedClassLoader.findClass(AggregatedClassLoader.java:206) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
... 47 common frames omitted
Suppressed: java.lang.ClassNotFoundException: org.hibernate.dialect.SQLiteDialect
at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641) ~[na:na]
at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188) ~[na:na]
at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526) ~[na:na]
at org.hibernate.boot.registry.classloading.internal.AggregatedClassLoader.findClass(AggregatedClassLoader.java:206) ~[hibernate-core-6.5.2.Final.jar:6.5.2.Final]
... 47 common frames omitted


Process finished with exit code 1
