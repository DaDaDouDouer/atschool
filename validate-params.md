# 验证类型：

1.  UUID id 

    String 
    not_empty 
    符合java.util.UUID的规则 

1.  AuthBaseBean username

    String not_empty length_6_20 a-zA-Z0-9下划线

1.  AuthBaseBean password

    String not_empty length_6_20 a-zA-Z0-9下划线

1.  BookType name

    String not_empty

1.  BookType baseName

    String not_empty

1.  goods goodsCount

    Number  >=0

1.  Goods keyword



1.  Evaluation content

    String length_0_255

1.  DeliveryAddress address

    String not_empty length_0_255