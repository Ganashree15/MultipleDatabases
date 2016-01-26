# MultipleDatabases

##Spring Multiple Resource Transaction:##
  These are multiple phased transaction which is using multiple databases to which the data should be commited in co-ordinating to each other databases which is alsp called as 2 Phase Commit(2PC) protocol.

So here, I have created a simple Entity Classes which maps to two different databses and trying to persist objects of the classes to the databases using distributed transaction.

###In DAO class we mainly use 3 annotations:###

    @Service:- Incicating it is a Spring Bean and thus it allows auto-detect, which uses javax.persistence.EntityManager to interact with databases.
    
    @Persistence Context:- Where Entity Manager is injected as per the persistence.xml.
    
    @Transactional:- It is used to deteermine the target transaction manager which qualifies the value for the specified transaction.
    
###In Service Class:###
  The Dao's methods are invoked to perform the basic interaction with the databases.
  
##Pros and Cons:##

###Pros:-###
  By using @Transactional, many important aspects such as transaction propogation are handled automatically. In this cases we are using another transaction method which is called as BusinessLogic(), which has the option of joining the ongoing transaction.

###Cons:-###
  @Transactional defines the scope of a single database transaction.This happens inside persistence context, where persistence context is in JPA the Entity Manager implemented using Hibernate.
  
  Persistence Context are used as synchronizer to persist back the changes in the database.Usually one Entity Manager can be used across several databases transaction, but here we are using multiple Entity Manager, because Java EE application Server doesn't include or support distributed transaction.
  
##In Persistence.xml:-##
  We have two persistence unit named PersistenceUnitA and PersistenceUnitB, with the transaction-type *"Resource_Local"* and mentioned a class packaged which it refers to.
  
##In applicationcontext.xml:-##
  We have an annotation driven **TransactionManager** with a bean id called *transactionManagerA* and *transactionManagerB* for each different Entity, with a class **JPA TranasactionManager** and also has a property name **EntityManagerFactory** which refers to two different *EntityManagerFactoryA* and *EntityManagerFactoryB*.
  
  We do have a bean which connects to Databases. The bean looks like:
  
      <bean id="dataSourceB" class="org.apache.commons.dbcp.BasicDataSource">
     	<property name="username" value="username" />
     	<property name="password" value="password" />
		<property name="driverClassName" value="org.postgresql.Driver" />
        <property name="url" value="url which connects to databases" />
      </bean> 
  
  we also have another bean which connects to the EntityManager
   
      <bean id="entityManagerFactoryA"
         class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
         <property name="dataSource" ref="dataSourceA" />
         <property name="persistenceUnitName" value="PersistenceUnitA" />
	 	<property name="jpaVendorAdapter">
      <bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter">
	 	<property name="generateDdl" value="false" />
       	 <property name="showSql" value="true" />
	 	<property name="databasePlatform" value="org.hibernate.dialect.PostgreSQLDialect" />
      </bean>
         </property>
	 	<property name="jpaProperties">
         <props>
         <prop key="hibernate.hbm2ddl.auto">update</prop>
         </props>
         </property>
      </bean>    
  
  
  

  
  
