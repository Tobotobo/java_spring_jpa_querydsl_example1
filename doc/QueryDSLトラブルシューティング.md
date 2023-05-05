# QueryDSLトラブルシューティング

## 前提
- バージョン:5.0.0
- javax

## JPAQueryFactoryのinsert()でNoViableAltException例外が発生する
### 結論
- Spring Boot 2.7 で insert の values を使うのは無理(使えるのは3.0以上)
### 詳細
```java
var query = queryFactory
    .insert(customer)
    .columns(customer.firstName, customer.lastName)
    .values("Jack", "Bauer")
    ;
```
```
antlr.NoViableAltException: unexpected token: values
```
https://github.com/querydsl/querydsl/issues/3027#issuecomment-1519050505
- Hibernate 5.6 以前は INSERT の VALUES に非対応(別テーブルからのインサートのみ対応)
- Hibernate 6.0 以上では対応しているが、Spring Boot 3.0以上でないと使用できない。よって 2.7 では無理

