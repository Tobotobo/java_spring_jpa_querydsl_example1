# java_spring_jpa_querydsl_example1

## 概要
Spring Data JPA + QueryDSLの実装例もといメモ

## 環境
- Java 17
- Spring Boot 2.7.11
- QueryDSL 5.0.0

## TODO
- SQLQueryFactoryの使い方

## メモ

- QueryDSL  
  - http://querydsl.com/  
  - https://github.com/querydsl/querydsl  
  - (2023年5月5日現在)  
    最新:5.0.0　※2021年7月22日リリース  
    最終コミット:2022年10月12日  
    ライセンス:Apache-2.0  
- [QueryDSLトラブルシューティング](doc/QueryDSLトラブルシューティング.md)
- Hibernate ORM  
  - https://hibernate.org/orm/
  - https://github.com/hibernate/hibernate-orm
  - Hibernate ORM は、オブジェクト/リレーショナル マッピング (ORM) サポートをアプリケーション、ライブラリ、およびフレームワークに提供するライブラリです。  
  また、ORM の標準 Java 仕様である JPA 仕様の実装も提供します。  
  - バージョン5系と6系がある。5系が javax、6系が jakarta
  - 最新:5.6.15、6.2.2 ※2023年5月7日現在
- Criteria API
  - Criteria API は、Java Persistence Query Language (JPQL) 照会のストリングを作成する代わりに、Java™ オブジェクトを使用して照会を作成するための API です。
  - 記述方法が煩雑で使いにくい。以下は実現したいSQLに対する記述例
    ```sql
    SELECT e FROM Employee e WHERE e.serviceyears < 5
    ```
    ```java
    QueryBuilder qb = emf.getQueryBuilder();
    CriteriaQuery q = qb.create(Employee.class);
    Root e = q.from(Employee.class);
    q.where(qb.lt(e.get(Employee_.serviceyears), 5));
    TypedQuery tq = em.createQuery(q);
    List result = q.getResultList();
    ```

## 参考
- https://spring.pleiades.io/guides/gs/accessing-data-jpa/

- 【JPA徹底入門】QueryDSLで実現する型安全な動的クエリ  
  https://zenn.dev/sooogle/articles/74106eec5f91f6

- Spring Data JPA および Querydsl を使用した REST クエリ言語  
  https://www.baeldung.com/rest-api-search-language-spring-data-querydsl

- https://github.com/querydsl/querydsl/tree/master/querydsl-jpa

- http://querydsl.com/static/querydsl/5.0.0/reference/html/ch02s03.html

- https://spring.pleiades.io/spring-data/jpa/docs/current/reference/html/

- Spring Boot Data Accesss Examples
  https://github.com/making/spring-boot-db-samples