# operaMNG
## 一、设计目的
**的bilibili和Chrome用来看戏体验并不是很好,尤其是在看熟戏的时候,占用内存较大,
分类不是很明确,网络问题等等.故而设计出这么一个小工具用来看戏.后续可能会添加管理功能.
## 二、设计思路
使用本地的数据库管理京剧剧目,京剧剧目下载在本地(自己有的才是真的有),通过在自己本地电脑的web服务器tomcat实现对自己的京剧剧目的管理与播放,采用Maven+MyBatis+MVC设计,前端采用axios+vue+Element
### 1、数据库设计
```mysql
create table tb_opera
(
    -- id 主键
    id           int primary key auto_increment,
    -- 剧目名称
    opera_name   varchar(20),
		-- 行当
		roles varchar(5),
    -- 流派名称
    genre_name varchar(20),
    -- 类型字段 1为全本,2为集锦,3为音频
    type INT,
		-- 演员
		actor VARCHAR(20),
		-- 相对路径,相对路径以/file开头,通过在tomcat的server.xml中配置达到相对访问
		local_path VARCHAR(20),
		-- B站地址
		bili_path VARCHAR(150),
    -- 描述信息
    description  varchar(100)

);
```
### 后端
## 三、后续优化以及丰富内容