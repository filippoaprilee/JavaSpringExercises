Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2024-06-28T10:18:26.403+02:00 ERROR 13584 --- [crudsqlite] [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: jakarta/persistence/CheckConstraint
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
Caused by: java.lang.NoClassDefFoundError: jakarta/persistence/CheckConstraint
at org.hibernate.boot.models.JpaAnnotations.<clinit>(JpaAnnotations.java:230) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.boot.models.internal.OrmAnnotationHelper.forEachOrmAnnotation(OrmAnnotationHelper.java:40) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.boot.models.internal.ModelsHelper.preFillRegistries(ModelsHelper.java:25) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.models.internal.SourceModelBuildingContextImpl.primeRegistries(SourceModelBuildingContextImpl.java:87) ~[hibernate-models-0.8.5.jar:na]
at org.hibernate.models.internal.SourceModelBuildingContextImpl.<init>(SourceModelBuildingContextImpl.java:48) ~[hibernate-models-0.8.5.jar:na]
at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.createModelBuildingContext(InFlightMetadataCollectorImpl.java:233) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.<init>(InFlightMetadataCollectorImpl.java:223) ~[hibernate-core-7.0.0.Alpha3.jar:7.0.0.Alpha3]
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
Caused by: java.lang.ClassNotFoundException: jakarta.persistence.CheckConstraint
at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641) ~[na:na]
at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188) ~[na:na]
at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526) ~[na:na]
... 32 common frames omitted


Process finished with exit code 1
