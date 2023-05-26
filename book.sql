create table book(
                     book_id int auto_increment primary key  not null ,# 图书编号
                             book_name varchar(100) not null , # 图书名称
                         book_anchor varchar(100) not null ,# 图书作者
                             book_price int not null ,# 图书价格
                             book_borrower varchar(100) not null,# 借阅时间
                             book_status int not null ,# 图书当前去状态
                         book_return_time date not null ,# 图书返回时间
                             book_isbn varchar(100)#图书ISBN
)engine = INNODB DEFAULT CHARSET = UTF8;
# status 0:未上架 1:已借阅 2:未借阅