2024-06-28T12:29:57.913+02:00 ERROR 1316 --- [EsercizioSQLLITE] [           main] j.LocalContainerEntityManagerFactoryBean : Failed to initialize JPA EntityManagerFactory: Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment] due to: Could not instantiate named strategy class [org.hibernate.dialect.Dialect]
2024-06-28T12:29:57.914+02:00  WARN 1316 --- [EsercizioSQLLITE] [           main] ConfigServletWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment] due to: Could not instantiate named strategy class [org.hibernate.dialect.Dialect]
2024-06-28T12:29:57.914+02:00  INFO 1316 --- [EsercizioSQLLITE] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2024-06-28T12:29:57.917+02:00  INFO 1316 --- [EsercizioSQLLITE] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
2024-06-28T12:29:57.920+02:00  INFO 1316 --- [EsercizioSQLLITE] [           main] o.apache.catalina.core.StandardService   : Stopping service [Tomcat]
2024-06-28T12:29:57.933+02:00  INFO 1316 --- [EsercizioSQLLITE] [           main] .s.b.a.l.ConditionEvaluationReportLogger :

Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2024-06-28T12:29:57.960+02:00 ERROR 1316 --- [EsercizioSQLLITE] [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment] due to: Could not instantiate named strategy class [org.hibernate.dialect.Dialect]
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
at it.apuliadigital.eserciziosqllite.EsercizioSqlliteApplication.main(EsercizioSqlliteApplication.java:10) ~[classes/:na]
Caused by: org.hibernate.service.spi.ServiceException: Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment] due to: Could not instantiate named strategy class [org.hibernate.dialect.Dialect]
at org.hibernate.service.internal.AbstractServiceRegistryImpl.createService(AbstractServiceRegistryImpl.java:276) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:238) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:215) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.boot.model.relational.Database.<init>(Database.java:45) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.getDatabase(InFlightMetadataCollectorImpl.java:282) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.<init>(InFlightMetadataCollectorImpl.java:215) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.<init>(InFlightMetadataCollectorImpl.java:221) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.boot.model.process.spi.MetadataBuildingProcess.complete(MetadataBuildingProcess.java:197) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.metadata(EntityManagerFactoryBuilderImpl.java:1429) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1500) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:75) ~[spring-orm-6.1.10.jar:6.1.10]
at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:390) ~[spring-orm-6.1.10.jar:6.1.10]
at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.1.10.jar:6.1.10]
at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-6.1.10.jar:6.1.10]
at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:366) ~[spring-orm-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1835) ~[spring-beans-6.1.10.jar:6.1.10]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1784) ~[spring-beans-6.1.10.jar:6.1.10]
... 15 common frames omitted
Caused by: org.hibernate.boot.registry.selector.spi.StrategySelectionException: Could not instantiate named strategy class [org.hibernate.dialect.Dialect]
at org.hibernate.boot.registry.selector.internal.StrategySelectorImpl.resolveStrategy(StrategySelectorImpl.java:244) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.boot.registry.selector.internal.StrategySelectorImpl.resolveStrategy(StrategySelectorImpl.java:189) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.engine.jdbc.dialect.internal.DialectFactoryImpl.constructDialect(DialectFactoryImpl.java:123) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.engine.jdbc.dialect.internal.DialectFactoryImpl.buildDialect(DialectFactoryImpl.java:88) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.getJdbcEnvironmentWithDefaults(JdbcEnvironmentInitiator.java:154) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.getJdbcEnvironmentUsingJdbcMetadata(JdbcEnvironmentInitiator.java:364) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:125) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:78) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.boot.registry.internal.StandardServiceRegistryImpl.initiateService(StandardServiceRegistryImpl.java:130) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.service.internal.AbstractServiceRegistryImpl.createService(AbstractServiceRegistryImpl.java:263) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
... 31 common frames omitted
Caused by: org.hibernate.boot.registry.selector.spi.StrategySelectionException: Could not instantiate named dialect class [org.hibernate.dialect.Dialect]
at org.hibernate.engine.jdbc.dialect.internal.DialectFactoryImpl.lambda$constructDialect$0(DialectFactoryImpl.java:143) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.boot.registry.selector.internal.StrategySelectorImpl.resolveStrategy(StrategySelectorImpl.java:240) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
... 40 common frames omitted
Caused by: java.lang.IllegalAccessException: class org.hibernate.engine.jdbc.dialect.internal.DialectFactoryImpl cannot access a member of class org.hibernate.dialect.Dialect with modifiers "protected"
at java.base/jdk.internal.reflect.Reflection.newIllegalAccessException(Reflection.java:394) ~[na:na]
at java.base/java.lang.reflect.AccessibleObject.checkAccess(AccessibleObject.java:714) ~[na:na]
at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:495) ~[na:na]
at java.base/java.lang.reflect.ReflectAccess.newInstance(ReflectAccess.java:128) ~[na:na]
at java.base/jdk.internal.reflect.ReflectionFactory.newInstance(ReflectionFactory.java:304) ~[na:na]
at java.base/java.lang.Class.newInstance(Class.java:725) ~[na:na]
at org.hibernate.engine.jdbc.dialect.internal.DialectFactoryImpl.lambda$constructDialect$0(DialectFactoryImpl.java:139) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
... 41 common frames omitted


Process finished with exit code 1